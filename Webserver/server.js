const express = require('express')
const app = express()
const port = 3000

// KEVIN SCRIPTS
const kevinHelp = require('./scripts/kevin/KevinHelp.json')
const kevinScript = require('./scripts/kevin/KevinScript.json')
const kevinTaskExplanation = require('./scripts/kevin/KevinTaskExplanation.json')
const kevinLookHere0 = require('./scripts/kevin/KevinLookHere0.json')
const kevinLookHere1 = require('./scripts/kevin/KevinLookHere1.json')
const riasZimmerLookHere1 = require('./scripts/kevin/RiaszimmerLookHere1.json')
const riasZimmerLookHere2 = require('./scripts/kevin/RiaszimmerLookHere2.json')
const riasZimmerLookHere3 = require('./scripts/kevin/RiaszimmerLookHere3.json')
const riasZimmerLookHere4 = require('./scripts/kevin/RiasZimmerLookHere4.json')
const kevinPositiveFeedback = require('./scripts/kevin/KevinPositiveFeedback.json')
const kevinNegativeFeedback = require('./scripts/kevin/KevinNegativeFeedback.json')

// OMA SCRIPTS
const omaHelp = require('./scripts/oma/OmaHelp.json')
const omaScript = require('./scripts/oma/OmaScript.json')
const omaTaskExplanation = require('./scripts/oma/OmaTaskExplanation.json')
const omaLookHere0 = require('./scripts/oma/OmaLookHere0.json')
const omaLookHere1 = require('./scripts/oma/OmaLookHere1.json')
const omaLookHere2 = require('./scripts/oma/OmaLookHere2.json')
const omaLookHere3 = require('./scripts/oma/OmaLookHere3.json')
const omaPositiveFeedback = require('./scripts/oma/OmaPositiveFeedback.json')
const omaNegativeFeedback = require('./scripts/oma/OmaNegativeFeedback.json')

// SCHULE SCRIPTS
const schuleHelp = require('./scripts/schule/SchuleHelp.json')
const schuleScript = require('./scripts/schule/SchuleScript.json')
const schuleTaskExplanation = require('./scripts/schule/SchuleTaskExplanation.json')
const schuleLookHere0 = require('./scripts/schule/SchuleLookHere0.json')
const schuleLookHere1 = require('./scripts/schule/SchuleLookHere1.json')
const schuleLookHere2 = require('./scripts/schule/SchuleLookHere2.json')
const schuleLookHere3 = require('./scripts/schule/SchuleLookHere3.json')
const schuleLookHere4 = require('./scripts/schule/SchuleLookHere4.json')
const schulePositiveFeedback = require('./scripts/schule/SchulePositiveFeedback.json')
const schuleNegativeFeedback = require('./scripts/schule/SchuleNegativeFeedback.json')

// PROTAG SCRIPTS
const protagHelp = require('./scripts/protag/JustinHelp.json')
const protagScript = require('./scripts/protag/JustinScript.json')
const protagTaskExplanation = require('./scripts/protag/JustinTaskExplanation.json')
const protagLookHere0 = require('./scripts/protag/JustinLookHere0.json')
const protagLookHere1 = require('./scripts/protag/JustinLookHere1.json')
const protagPositiveFeedback = require('./scripts/protag/JustinPositiveFeedback.json')
const protagNegativeFeedback = require('./scripts/protag/JustinNegativeFeedback.json')

const studentList = require('./profiles/studentList.json')
const teacherList = require('./profiles/teacherList.json')
const classesList = require('./profiles/classes.json')

app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.get('/script/:scriptname', (req, res) => {
    switch (req.params.scriptname) {
        // KEVIN SCRIPTS
        case 'kevinHelp' : res.json(kevinHelp); break;
        case 'kevinScript' : res.json(kevinScript); break;
        case 'kevinTaskExplanation' : res.json(kevinTaskExplanation); break;
        case 'kevinLookHere0' : res.json(kevinLookHere0); break;
        case 'kevinLookHere1' : res.json(kevinLookHere1); break;
        case 'riasZimmerLookHere1' : res.json(riasZimmerLookHere1); break;
        case 'riasZimmerLookHere2' : res.json(riasZimmerLookHere2); break;
        case 'riasZimmerLookHere3' : res.json(riasZimmerLookHere3); break;
        case 'riasZimmerLookHere4' : res.json(riasZimmerLookHere4); break;
        case 'kevinPositiveFeedback' : res.json(kevinPositiveFeedback); break;
        case 'kevinNegativeFeedback' : res.json(kevinNegativeFeedback); break;

        // OMA SCRIPTS
        case 'omaHelp' : res.json(omaHelp); break;
        case 'omaScript' : res.json(omaScript); break;
        case 'omaTaskExplanation' : res.json(omaTaskExplanation); break;
        case 'omaLookHere0' : res.json(omaLookHere0); break;
        case 'omaLookHere1' : res.json(omaLookHere1); break;
        case 'omaLookHere2' : res.json(omaLookHere2); break;
        case 'omaLookHere3' : res.json(omaLookHere3); break;
        case 'omaPositiveFeedback' : res.json(omaPositiveFeedback); break;
        case 'omaNegativeFeedback' : res.json(omaNegativeFeedback); break;

        // SCHULE SCRIPTS
        case 'schuleHelp' : res.json(schuleHelp); break;
        case 'schuleScript' : res.json(schuleScript); break;
        case 'schuleTaskExplanation' : res.json(schuleTaskExplanation); break;
        case 'schuleLookHere0' : res.json(schuleLookHere0); break;
        case 'schuleLookHere1' : res.json(schuleLookHere1); break;
        case 'schuleLookHere2' : res.json(schuleLookHere2); break;
        case 'schuleLookHere3' : res.json(schuleLookHere3); break;
        case 'schuleLookHere4' : res.json(schuleLookHere4); break;
        case 'schulePositiveFeedback' : res.json(schulePositiveFeedback); break;
        case 'schuleNegativeFeedback' : res.json(schuleNegativeFeedback); break;

        // PROTAG SCRIPTS
        case 'protagHelp' : res.json(protagHelp); break;
        case 'protagScript' : res.json(protagScript); break;
        case 'protagTaskExplanation' : res.json(protagTaskExplanation); break;
        case 'protagLookHere0' : res.json(protagLookHere0); break;
        case 'protagLookHere1' : res.json(protagLookHere1); break;
        case 'protagPositiveFeedback' : res.json(protagPositiveFeedback); break;
        case 'protagNegativeFeedback' : res.json(protagNegativeFeedback); break;

        default : res.json({ error: 'Script not found' });
    }
})

// PROFILES
app.get('/students', (req, res) => {
    res.json(studentList)
})
app.get('/teachers', (req, res) => {
    res.json(teacherList)
})
app.get('/classes', (req, res) => {
    res.json(classesList)
})

// SERVER
app.listen(port, () => {
  console.log(`Listening on port ${port}`)
})