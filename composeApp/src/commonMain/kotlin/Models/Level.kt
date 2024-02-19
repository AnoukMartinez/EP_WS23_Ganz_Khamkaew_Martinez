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
import Models.Scripts.Kevin.omaLookHere0
import Models.Scripts.Kevin.riasZimmerLookHere1
import Models.Scripts.Kevin.riasZimmerLookHere2
import Models.Scripts.Kevin.riasZimmerLookHere3
import Models.Scripts.Kevin.riasZimmerLookHere4
import Models.Scripts.Oma.omaHelp
import Models.Scripts.Oma.omaLookHere1
import Models.Scripts.Oma.omaLookHere2
import Models.Scripts.Oma.omaLookHere3
import Models.Scripts.Oma.omaNegativeFeedback
import Models.Scripts.Oma.omaPositiveFeedback
import Models.Scripts.Oma.omaScript
import Models.Scripts.Oma.omaTaskExplanation
import Models.Scripts.Protagonist.justinHelp
import Models.Scripts.Protagonist.justinLookHere0
import Models.Scripts.Protagonist.justinLookHere1
import Models.Scripts.Protagonist.justinNegativeFeedback
import Models.Scripts.Protagonist.justinPositiveFeedback
import Models.Scripts.Protagonist.justinTaskExplanation
import Models.Scripts.Schule.schuleHelp
import Models.Scripts.Schule.schuleLookHere0
import Models.Scripts.Schule.schuleLookHere1
import Models.Scripts.Schule.schuleLookHere2
import Models.Scripts.Schule.schuleLookHere3
import Models.Scripts.Schule.schuleLookHere4
import Models.Scripts.Schule.schuleNegativeFeedback
import Models.Scripts.Schule.schulePositiveFeedback
import Models.Scripts.Schule.schuleScript
import Models.Scripts.Schule.schuleTaskExplanation
import Views.LevelOverlays.GameSituation

data class Level (
    val location : Location,
    var discovered : Boolean = false,
    var cleared : Boolean = false,
    var scripts : List<Script>,
    var helpContents : List<HelpContent>
)

var levels = mutableListOf<Level>()

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
            buildScript(riasZimmerLookHere3, ScriptType.LOOKHERE),
            buildScript(riasZimmerLookHere4, ScriptType.LOOKHERE),
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
            buildScript(omaScript, ScriptType.GREETING),
            buildScript(omaTaskExplanation, ScriptType.TASKEXPLANATION),
            buildScript(omaLookHere0, ScriptType.LOOKHERE),
            buildScript(omaLookHere1, ScriptType.LOOKHERE),
            buildScript(omaLookHere2, ScriptType.LOOKHERE),
            buildScript(omaLookHere3, ScriptType.LOOKHERE),
            buildScript(omaPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
            buildScript(omaNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
        ),
        buildHelpContent(omaHelp)
    )

    val schule = Level (
        Location.SCHULE,
        false,
        false,
        listOf(
            buildScript(schuleScript, ScriptType.GREETING),
            buildScript(schuleTaskExplanation, ScriptType.TASKEXPLANATION),
            buildScript(schuleLookHere0, ScriptType.LOOKHERE),
            buildScript(schuleLookHere1, ScriptType.LOOKHERE),
            buildScript(schuleLookHere2, ScriptType.LOOKHERE),
            buildScript(schuleLookHere3, ScriptType.LOOKHERE),
            buildScript(schuleLookHere4, ScriptType.LOOKHERE),
            buildScript(schulePositiveFeedback, ScriptType.POSITIVEFEEDBACK),
            buildScript(schuleNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
        ),
        buildHelpContent(schuleHelp)
    )

    val justin = Level (
        Location.JUSTINSHAUS,
        false,
        false,
        listOf(
            buildScript(justinScript, ScriptType.GREETING),
            buildScript(justinTaskExplanation, ScriptType.TASKEXPLANATION),
            buildScript(justinLookHere0, ScriptType.LOOKHERE),
            buildScript(justinLookHere1, ScriptType.LOOKHERE),
            buildScript(justinPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
            buildScript(justinNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
        ),
        buildHelpContent(justinHelp)
    )

    return mutableListOf(kevin, oma, schule, justin)
}

// WIP
suspend fun buildScriptsServer() : MutableList<Level> {
    return mutableListOf (
        // KEVIN
        Level (
            location = Location.KEVINSHAUS,
            discovered = false,
            cleared = false,
            scripts = listOf(
                buildScript(getLocationScriptFromServer("kevinScript"), ScriptType.GREETING),
                buildScript(getLocationScriptFromServer("kevinTaskExplanation"), ScriptType.TASKEXPLANATION),
                buildScript(getLocationScriptFromServer("kevinLookHere0"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("kevinLookHere1"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("riasZimmerLookHere1"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("riasZimmerLookHere2"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("riasZimmerLookHere3"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("riasZimmerLookHere4"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("kevinPositiveFeedback"), ScriptType.POSITIVEFEEDBACK),
                buildScript(getLocationScriptFromServer("kevinNegativeFeedback"), ScriptType.NEGATIVEFEEDBACK)
            ),
            helpContents = buildHelpContent(getLocationScriptFromServer("kevinHelp"))
        ),

        // OMA
        Level (
            location = Location.OMASHAUS,
            discovered = false,
            cleared = false,
            scripts = listOf(
                buildScript(getLocationScriptFromServer("omaScript"), ScriptType.GREETING),
                buildScript(getLocationScriptFromServer("omaTaskExplanation"), ScriptType.TASKEXPLANATION),
                buildScript(getLocationScriptFromServer("omaLookHere0"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("omaLookHere1"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("omaLookHere2"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("omaLookHere3"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("omaPositiveFeedback"), ScriptType.POSITIVEFEEDBACK),
                buildScript(getLocationScriptFromServer("omaNegativeFeedback"), ScriptType.NEGATIVEFEEDBACK)
            ),
            helpContents = buildHelpContent(getLocationScriptFromServer("omaHelp"))
        ),

        // SCHULE
        Level (
            location = Location.SCHULE,
            discovered = false,
            cleared = false,
            scripts = listOf(
                buildScript(getLocationScriptFromServer("schuleScript"), ScriptType.GREETING),
                buildScript(getLocationScriptFromServer("schuleTaskExplanation"), ScriptType.TASKEXPLANATION),
                buildScript(getLocationScriptFromServer("schuleLookHere0"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("schuleLookHere1"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("schuleLookHere2"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("schuleLookHere3"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("schuleLookHere4"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("schulePositiveFeedback"), ScriptType.POSITIVEFEEDBACK),
                buildScript(getLocationScriptFromServer("schuleNegativeFeedback"), ScriptType.NEGATIVEFEEDBACK)
            ),
            helpContents = buildHelpContent(getLocationScriptFromServer("schuleHelp"))
        ),

        // PROTAG
        Level (
            location = Location.JUSTINSHAUS,
            discovered = false,
            cleared = false,
            scripts = listOf(
                buildScript(getLocationScriptFromServer("protagScript"), ScriptType.GREETING),
                buildScript(getLocationScriptFromServer("protagTaskExplanation"), ScriptType.TASKEXPLANATION),
                buildScript(getLocationScriptFromServer("protagLookHere0"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("protagLookHere1"), ScriptType.LOOKHERE),
                buildScript(getLocationScriptFromServer("protagPositiveFeedback"), ScriptType.POSITIVEFEEDBACK),
                buildScript(getLocationScriptFromServer("protagNegativeFeedback"), ScriptType.NEGATIVEFEEDBACK)
            ),
            helpContents = buildHelpContent(getLocationScriptFromServer("protagHelp"))
        )
    )
}

suspend fun buildScriptsLocal() : MutableList<Level> {
    return mutableListOf (
        // BUILD KEVIN
        Level (
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
                buildScript(riasZimmerLookHere3, ScriptType.LOOKHERE),
                buildScript(riasZimmerLookHere4, ScriptType.LOOKHERE),
                buildScript(kevinPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
                buildScript(kevinNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
            ),
            buildHelpContent(kevinHelp)
        ),

        // OMA
        Level (
            Location.OMASHAUS,
            false,
            false,
            listOf(
                buildScript(omaScript, ScriptType.GREETING),
                buildScript(omaTaskExplanation, ScriptType.TASKEXPLANATION),
                buildScript(omaLookHere0, ScriptType.LOOKHERE),
                buildScript(omaLookHere1, ScriptType.LOOKHERE),
                buildScript(omaLookHere2, ScriptType.LOOKHERE),
                buildScript(omaLookHere3, ScriptType.LOOKHERE),
                buildScript(omaPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
                buildScript(omaNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
            ),
            buildHelpContent(omaHelp)
        ),

        // SCHULE
        Level (
            Location.SCHULE,
            false,
            false,
            listOf(
                buildScript(schuleScript, ScriptType.GREETING),
                buildScript(schuleTaskExplanation, ScriptType.TASKEXPLANATION),
                buildScript(schuleLookHere0, ScriptType.LOOKHERE),
                buildScript(schuleLookHere1, ScriptType.LOOKHERE),
                buildScript(schuleLookHere2, ScriptType.LOOKHERE),
                buildScript(schuleLookHere3, ScriptType.LOOKHERE),
                buildScript(schuleLookHere4, ScriptType.LOOKHERE),
                buildScript(schulePositiveFeedback, ScriptType.POSITIVEFEEDBACK),
                buildScript(schuleNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
            ),
            buildHelpContent(schuleHelp)
        ),

        // PROTAGONIST
        Level (
            Location.JUSTINSHAUS,
            false,
            false,
            listOf(
                buildScript(justinScript, ScriptType.GREETING),
                buildScript(justinTaskExplanation, ScriptType.TASKEXPLANATION),
                buildScript(justinLookHere0, ScriptType.LOOKHERE),
                buildScript(justinLookHere1, ScriptType.LOOKHERE),
                buildScript(justinPositiveFeedback, ScriptType.POSITIVEFEEDBACK),
                buildScript(justinNegativeFeedback, ScriptType.NEGATIVEFEEDBACK)
            ),
            buildHelpContent(justinHelp)
        )
    )
}