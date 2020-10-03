# ApacheShiroVulnExample

分析 `ApacheShiro` 漏洞时使用的测试项目。

- /index 无需登录，可以直接访问；
- /account/index 登录后才可以访问，未登录状态下访问会自动跳转到 /login 页面；
- /login 登录接口，访问 /login?username=lightless&password=123456 即可登录；

`ApacheShiro` 相关的鉴权配置均在 `ShiroConfig.java` 中，测试时可以根据需要自行调整；

分析总结：https://lightless.me/archives/apache-shiro-analysis.html