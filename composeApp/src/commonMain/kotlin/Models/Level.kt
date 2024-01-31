package Models

import Location
import Models.Scripts.Kevin.kevinHelp
import Models.Scripts.Kevin.kevinLookHere1
import Models.Scripts.justinScript
import Models.Scripts.Kevin.kevinScript
import Models.Scripts.Kevin.kevinTaskExplanationScript
import Models.Scripts.Kevin.riasZimmerLookHere1
import Models.Scripts.Kevin.riasZimmerLookHere2
import Models.Scripts.omaScript
import Models.Scripts.schuleScript
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
            buildScript(kevinScript),
            buildScript(kevinTaskExplanationScript),
            buildScript(kevinLookHere1),
            buildScript(riasZimmerLookHere1),
            buildScript(riasZimmerLookHere2)
        ),
        buildHelpContent(kevinHelp),
    )

    val oma = Level (
        Location.OMASHAUS,
        false,
        false,
        listOf(
            buildScript(omaScript)
        ),
        buildHelpContent(kevinHelp)
    )

    val schule = Level (
        Location.SCHULE,
        false,
        false,
        listOf(
            buildScript(schuleScript)
        ),
        buildHelpContent(kevinHelp)
    )

    val justin = Level (
        Location.JUSTINSHAUS,
        false,
        false,
        listOf(
            buildScript(justinScript)
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
        kevinGreetingScript = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))
        kevinTaskScript = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))
        kevinLookhere1 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))
        kevinLookHere2 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))
        kevinLookHere3 = buildScript(getLocationScriptFromServer(Location.KEVINSHAUS))

        // TODO - Der Help Content muss auch aus einer JSON kommen

        omaProcessedScript = buildScript(getLocationScriptFromServer(Location.OMASHAUS))
        schuleProcessedScript = buildScript(getLocationScriptFromServer(Location.SCHULE))
        justinProcessedScript = buildScript(getLocationScriptFromServer(Location.JUSTINSHAUS))

    } catch (e : Exception){
        // Wenn Server Verbindung fehlschlägt, nehme stattdessen die lokalen Scripts
        kevinGreetingScript = buildScript(kevinScript)
        kevinTaskScript = buildScript(kevinTaskExplanationScript)
        kevinLookhere1 = buildScript(kevinLookHere1)
        kevinLookHere2 = buildScript(riasZimmerLookHere1)
        kevinLookHere3 = buildScript(riasZimmerLookHere2)

        // TODO - Der Help Content muss auch aus einer JSON kommen

        omaProcessedScript = buildScript(omaScript)
        schuleProcessedScript = buildScript(schuleScript)
        justinProcessedScript = buildScript(justinScript)
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
    val kevin = Level(Location.KEVINSHAUS, scripts = listOf(buildScript(kevinScript)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val oma = Level(Location.OMASHAUS, scripts = listOf(buildScript(omaScript)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val schule = Level(Location.SCHULE, scripts = listOf(buildScript(schuleScript)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))
    val justin = Level(Location.JUSTINSHAUS, scripts = listOf(buildScript(justinScript)), helpContents = listOf(HelpContent(GameSituation.GREETINGDIALOGUE, "hi", "platzhalter")))

    levels.add(kevin)
    levels.add(oma)
    levels.add(schule)
    levels.add(justin)
    return levels
}