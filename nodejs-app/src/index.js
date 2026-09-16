const express = require('express');
const dotenv = require('dotenv');
dotenv.config();

const app = express();
const PORT = process.env.PORT || 3000;
const ENV = process.env.NODE_ENV || 'development';

app.get('/health', (req, res) => {
  res.json({ status: 'UP', service: 'NodeJS', environment: ENV, timestamp: new Date() });
});

app.listen(PORT, () => {
  console.log(`[Node.js] Service running on port ${PORT} in ${ENV} mode`);
});
