package Models

import Models.Scripts.kevinScript
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
    SCHULE, // Vielleicht sollten Locations und Character seperat sein?
    JUSTIN
}

data class Script (
    val lines : MutableList<DialogueLine> = mutableListOf()
)

data class DialogueLine (
    val dialogueLine : String,
    val speaker : GameCharacter,
    val mood : Mood
)

val test = """
    [
        {
            "dialogueLine": "Hey Mann, wie geht's? Cool dass du nach der Schule vorbeischaust.",
            "speaker": "KEVIN",
            "mood": "HAPPY"
        },
        {
            "dialogueLine": "Hör mal, ich weiss wir wollten eigentlich Fortnite spielen...",
            "speaker": "KEVIN",
            "mood": "NEUTRAL"
        },
        {
            "dialogueLine": "Aber meine Schwester hat meinen Laptop geklaut und das Passwort geändert!",
            "speaker": "KEVIN",
            "mood": "ANGRY"
        },
        {
            "dialogueLine": "Kannst du mir helfen das Passwort zu knacken? So schwer kann das ja nicht sein...!",
            "speaker": "KEVIN",
            "mood": "NEUTRAL"
        }
    ]
""".trimIndent()

val mapper = jacksonObjectMapper()
val dialogueLinesTest : List<DialogueLine> = mapper.readValue(test)
fun gogetem(){
    for(element in dialogueLinesTest){
        println(element)
    }
}

fun buildScript(rawCharacterScript : String) : Script {
    val dialogueLines : List<DialogueLine> = mapper.readValue(rawCharacterScript)
    val characterScript = Script()

    for(element in dialogueLines) {
        characterScript.lines.add(element)
    }

    return characterScript
}