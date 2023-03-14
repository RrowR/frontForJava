// express是一个nodejs的web框架，可以用来快速搭建一个web服务器
import express from 'express';
// 添加一个代理中间件，用来解决跨域问题
import { createProxyMiddleware } from 'http-proxy-middleware';
const app = express();
app.use("/api", createProxyMiddleware({ target: 'http://localhost:8080', changeOrigin: true }));
app.use(express.static('./'));
app.listen(7070);
