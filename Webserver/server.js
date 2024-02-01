const express = require('express')
const app = express()
const port = 3000

const omascript = require('./scripts/omascript')
const kevinscript = require('./scripts/kevinscript')
const justinscript = require('./scripts/justinscript')
const schulescript = require('./scripts/schulescript')

app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.get('/script/:location', (req, res) => {
    switch (req.params.location) {
        case 'omashaus' : res.json(omascript); break;
        case 'kevinshaus' : res.json(kevinscript); break;
        case 'justinshaus' : res.json(justinscript); break;
        case 'schule' : res.json(schulescript); break;
        default : res.json({ error: 'Script not found' });
    }
})

app.listen(port, () => {
  console.log(`Listening on port ${port}`)
})