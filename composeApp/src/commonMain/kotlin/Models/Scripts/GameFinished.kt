package Models.Scripts

import Models.DialogueLine
import Models.GameCharacter
import Models.Mood
import Models.Script
import Models.ScriptType

var gameFinishedScript = Script(
    scriptType = ScriptType.LOOKHERE,
    lines = mutableListOf(
        DialogueLine(
            "Wow, wir haben das ganze Spiel durchgespielt!",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        ),
        DialogueLine(
            "Natürlich ist das nur ein Prototyp... Also eine Demo...",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        ),
        DialogueLine(
            "Aber trotzdem, du hast alle Aufgaben perfekt beantwortet!",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        ),
        DialogueLine(
            "Das ist wirklich cool muss ich sagen.",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        ),
        DialogueLine(
            "Naja... Dann erst mal auf Wiedersehen.",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        ),
        DialogueLine(
            "Vielleicht sieht man sich eines Tages im echten Spiel wieder?",
            GameCharacter.JUSTIN,
            Mood.HAPPY,
            GameCharacter.NOBODY,
            Mood.NEUTRAL
        )
    )
)

