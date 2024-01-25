package Models

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
    TASK,
    LOOKHERE,
    FEEDBACK
}

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

fun buildScript(rawCharacterScript : String) : Script {
    val dialogueLines : List<DialogueLine> = mapper.readValue(rawCharacterScript)
    val characterScript = Script(ScriptType.GREETING)

    for(element in dialogueLines) {
        characterScript.lines.add(element)
    }

    return characterScript
}