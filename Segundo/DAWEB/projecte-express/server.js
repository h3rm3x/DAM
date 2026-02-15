const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res) => {
  res.send('<h1>Hola Mundo desde Express.js</h1><p>Projecte UD6 Alan</p>');
});

app.listen(port, () => {
  console.log(`Servidor escoltant a http://localhost:${port}`);
});