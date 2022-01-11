功能：
1.登录页面
2.在线观看电影

技术点：
1.springboot+maven多模块
2.git
3.swagger
4.mybatisPlus+lambda

本地部署√
linux部署√
docker部署√
    服务器执行：
    1.vim Dockerfile
    FROM java:8
    ADD movie_online_bootstrap-0.0.1-SNAPSHOT.jar /movie_online.jar
    ENTRYPOINT ["java","-jar","movie_online.jar","--spring.profiles.active=stg"]
    2.docker build -f Dockerfile -t movieonlineimage .
    3.docker run -d -p 8080:8888 movieonlineimage
查docker进程：docker ps
查docker容器日志：
idea一键docker√



spring security
vue
redis
mq
zk
apollo
spring cloud
log






movie_online遇到的坑：
1.SpringBootApplication启动时会默认扫描主类当前包及子包，如果需要扫描主类当前包外的其他包或不扫描当前包下的特定包或类，可通过下列属性实现：
@SpringBootApplication(scanBasePackages=("com.eddie"))

2.项目本地可以启动，打包后却无法找到子类的manger的controller方法？
<plugins>插件不要放在父pom文件，直接放在bootstrap启动类的pom文件即可解决。



疑问点：
Q1:脚手架采用分层模式的优势在于？ 
A1:api可用于打包给外部直接引用
A2:使用Maven的多模块配置，可以帮助项目划分模块，鼓励重用，防止POM变得过于庞大，方便某个模块的构建，而不用每次都构建整个项目，并且使得针对某个模块的特殊控制更为方便


Q2：本地部署，局域网外无法访问；部署到linux系统呢？也是无法访问。