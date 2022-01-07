功能：
1.登录页面
2.在线观看电影

技术点：
1.前后端分离,前端vue
2.spring cloud + docker


1.springboot+maven多模块
2.git
3.swagger
4.mybatisPlus+lambda



spring security

容器+docker








那些年我们遇到的坑：
1.SpringBootApplication启动时会默认扫描主类当前包及子包，如果需要扫描主类当前包外的其他包或不扫描当前包下的特定包或类，可通过下列属性实现：
@SpringBootApplication(scanBasePackages=("com.eddie"))




疑问点：
Q1:脚手架采用分层模式的优势在于？ 
A1:api可用于打包给外部直接引用
A2:使用Maven的多模块配置，可以帮助项目划分模块，鼓励重用，防止POM变得过于庞大，方便某个模块的构建，而不用每次都构建整个项目，并且使得针对某个模块的特殊控制更为方便

Q2:打包后的项目，无法找到引用的manager的代码？