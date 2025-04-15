Acticiti7工作流引擎
===============
# 项目介绍
基于[Acticiti7](https://github.com/Activiti/Activiti)的Web工作流引擎，完整开源。

前端基于[layuimini](https://github.com/zhongshaofa/layuimini/releases)。

# 主要特性
* 完整的流程部署、创建实例、任务流转
* 使用Acticiti7新版特性
* 融合BPMN-JS作为流程绘制工具
* 整合SpringSecurity安全框架
 
# 执行user.sql创建用户表并修复Activiti7官方Bug
 * 注意：先运行一次项目，Activiti会自动初始化数据库需要的表，然后再执行下面的sql
 * 使用Navicat等工具执行项目根目录下user.sql


# 运行项目
>
     测试账号：bajie
     密码：1
     测试账号：wukong
     密码：1

* 浏览器 localhost:8080/layuimini/page/login-1.html

# 使用说明
### 动态表单配置原则
>
    控件命名约束：FormProperty_0ueitp2-_!类型-_!名称-_!默认值-_!是否参数
    ID：自行标号同一流程定义无重复
    类型：string、long、cUser（cUser为自定义类型读取用户列表）
    默认值：无、字符、FormProperty_开头定义过的控件ID
    是否参数：f为不是参数，s是字符，t是时间(不需要int，因为这里int等价于string)
    例子：FormProperty_0lovri0-_!string-_!姓名-_!请输入姓名-_!f
    FormProperty_1iu6onu-_!long-_!年龄-_!请输入年龄-_!s
    FormProperty_2rd4dtv-_!cUser-_!执行人-_!无-_!s
    注意:表单Key必须要任务编号一致
    （因为参数需要任务key，但是无法获取，只能获取表单key“task.getFormKey()”当做任务key）




