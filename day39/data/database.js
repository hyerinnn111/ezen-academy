// dotenv는 패키지가 맨 위 라인에 있어야 합니다
require('dotenv').config();
const mysql = require('mysql2/promise');

const pool = mysql.createPool({
  host: process.env.DB_HOST, 
  database: process.env.DB_DATABASE, 
  user: process.env.DB_USER, 
  password: process.env.DB_PASSWORD 
});

module.exports = pool;

