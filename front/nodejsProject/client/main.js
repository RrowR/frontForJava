// express是一个nodejs的web框架，可以用来快速搭建一个web服务器
import express from 'express';
const app = express();
app.use(express.static('./'));
app.listen(7070);
