package Models

import Location
import Models.Scripts.Kevin.kevinHelp
import Models.Scripts.Kevin.kevinLookHere0
import Models.Scripts.Kevin.kevinLookHere1
import Models.Scripts.Kevin.kevinNegativeFeedback
import Models.Scripts.Kevin.kevinPositiveFeedback
import Models.Scripts.Protagonist.justinScript
import Models.Scripts.Kevin.kevinScript
import Models.Scripts.Kevin.kevinTaskExplanationScript
import Models.Scripts.Kevin.riasZimmerLookHere1
import Models.Scripts.Kevin.riasZimmerLookHere2
import Models.Scripts.Oma.omaScript
import Models.Scripts.Schule.schuleScript
import Views.LevelOverlays.GameSituation

data class Level (
    val location : Location,
    var discovered : Boolean = false,
    var cleared : Boolean = false,
    var scripts : List<Script>,
    var helpContents : List<HelpContent>
)

var levels = mutableListOf<Level>()

// ganz grausiger code bitte nochmal drübergehen wenn wir zeit haben aua aua
suspend fun buildScripts() : MutableList<Level> {
    val kevin = Level (
        Location.KEVINSHAUS,
        false,
        false,
        listOf(
            buildScript(kevinScript, ScriptType.GREETING),
            buildScript(kevinTaskExplanationScript, ScriptType.TASKEXPLANATION),
            buildScript(kevinLookHere0, ScriptType.LOOKHERE),
            buildScript(kevinLookHere1, ScriptType.LOOKHERE),
            buildScript(riasZimmerLookHere1, ScriptType.LOOKHERE),
            buildScript(riasZimmerLookHere2, ScriptType.LOOKHERE),
            buildScript(kevinPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
            buildScript(kevinNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
        ),
        buildHelpContent(kevinHelp),
    )

    val oma = Level (
        Location.OMASHAUS,
        false,
        false,
        listOf(
            buildScript(omaScript, ScriptType.GREETING)
        ),
        buildHelpContent(kevinHelp)
    )

    val schule = Level (
        Location.SCHULE,
        false,
        false,
        listOf(
            buildScript(schuleScript, ScriptType.GREETING)
        ),
        buildHelpContent(kevinHelp)
    )

    val justin = Level (
        Location.JUSTINSHAUS,
        false,
        false,
        listOf(
            buildScript(justinScript, ScriptType.GREETING)
        ),
        buildHelpContent(kevinHelp)
    )

    return mutableListOf(kevin, oma, schule, justin)
}

suspend fun buildScriptsServer() : MutableList<Level> {
    val levels = mutableListOf<Level>()

    // Kevin Scripts
    var kevinGreetingScript : Script
    var kevinTaskScript : Script
    var kevinLookhere1 : Script
    var kevinLookHere2 : Script
    var kevinLookHere3 : Script

    var omaProcessedScript : Script
    var schuleProcessedScript : Script
    var justinProcessedScript : Script

    try {
        // PLATZHALTER IST WORK IN PROGRESS
        kevinGreetingScript = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS), ScriptType.GREETING)
        kevinTaskScript = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS), ScriptType.TASKEXPLANATION)
        kevinLookhere1 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS), ScriptType.LOOKHERE)
        kevinLookHere2 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS), ScriptType.LOOKHERE)
        kevinLookHere3 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS), ScriptType.LOOKHERE)

        omaProcessedScript = buildScript(getLocationScriptFromServer(Location.OMASHAUS), ScriptType.GREETING)
        schuleProcessedScript = buildScript(getLocationScriptFromServer(Location.SCHULE), ScriptType.GREETING)
        justinProcessedScript = buildScript(getLocationScriptFromServer(Location.JUSTINSHAUS), ScriptType.GREETING)

    } catch (e : Exception){
        // Wenn Server Verbindung fehlschlägt, nehme stattdessen die lokalen Scripts
        kevinGreetingScript = buildScript(kevinScript, ScriptType.GREETING)
        kevinTaskScript = buildScript(kevinTaskExplanationScript, ScriptType.TASKEXPLANATION)
        kevinLookhere1 = buildScript(kevinLookHere1, ScriptType.LOOKHERE)
        kevinLookHere2 = buildScript(riasZimmerLookHere1, ScriptType.LOOKHERE)
        kevinLookHere3 = buildScript(riasZimmerLookHere2, ScriptType.LOOKHERE)

        omaProcessedScript = buildScript(omaScript, ScriptType.GREETING)
        schuleProcessedScript = buildScript(schuleScript, ScriptType.GREETING)
        justinProcessedScript = buildScript(justinScript, ScriptType.GREETING)
    }

    val kevin = Level(
        Location.KEVINSHAUS,
        scripts = listOf(
            kevinGreetingScript,
            kevinTaskScript,
            kevinLookhere1,
            kevinLookHere2,
            kevinLookHere3
        ),
        helpContents = listOf(
            HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "hi")
        )
    )

    val oma = Level(
        Location.OMASHAUS,
        scripts = listOf(omaProcessedScript),
        helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))

    val schule = Level(
        Location.SCHULE,
        scripts = listOf(schuleProcessedScript),
        helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))

    val justin = Level(
        Location.JUSTINSHAUS,
        scripts = listOf(justinProcessedScript),
        helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))

    levels.add(kevin)
    levels.add(oma)
    levels.add(schule)
    levels.add(justin)
    return levels
}

// Die Funktion ist eigentlich nur für den Dev Process und kommt danach wieder weg
fun buildScriptsLocal() : MutableList<Level> {
    val kevin = Level(Location.KEVINSHAUS, scripts = listOf(buildScript(kevinScript,  ScriptType.GREETING)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val oma = Level(Location.OMASHAUS, scripts = listOf(buildScript(omaScript, ScriptType.GREETING)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val schule = Level(Location.SCHULE, scripts = listOf(buildScript(schuleScript, ScriptType.GREETING)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val justin = Level(Location.JUSTINSHAUS, scripts = listOf(buildScript(justinScript, ScriptType.GREETING)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))

    levels.add(kevin)
    levels.add(oma)
    levels.add(schule)
    levels.add(justin)
    return levels
}