package Models

import Views.LevelOverlays.GameSituation
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

enum class Mood {
    NEUTRAL,
    HAPPY,
    ANGRY,
    SAD
}

enum class GameCharacter {
    KEVIN,
    OMA,
    JUSTIN,
    NOBODY
}

enum class ScriptType {
    GREETING,
    TASKEXPLANATION,
    LOOKHERE,
    POSITIVEFEEDBACK,
    NEGATIVEFEEDBACK
}

data class HelpContent(
    val situation : GameSituation,
    val title : String,
    val content : String
)

data class Script (
    val scriptType : ScriptType,
    val lines : MutableList<DialogueLine> = mutableListOf()
) {
    operator fun get(scriptLineNumber: Int) : DialogueLine {
            return lines[scriptLineNumber]
    }

    fun getScriptSize() : Int {
        return lines.size
    }
}

data class DialogueLine (
    val dialogueLine : String,
    val speaker : GameCharacter,
    val speakermood : Mood,
    val listener : GameCharacter,
    val listenermood : Mood
)

val mapper = jacksonObjectMapper()

fun buildScript(rawCharacterScript : String, scriptType : ScriptType) : Script {
    val dialogueLines : List<DialogueLine> = mapper.readValue(rawCharacterScript)
    // TODO Alle Skripts haben unterschiedliche Typen
    val characterScript = Script(scriptType)

    for(element in dialogueLines) {
        characterScript.lines.add(element)
    }

    return characterScript
}

fun buildHelpContent(rawHelpContent : String) : List<HelpContent> {
    return mapper.readValue(rawHelpContent)
}