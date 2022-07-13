# Documentation of “Qualification Test Backend Developer”

**由于个人技术还是比较有限，也非常希望能完整地设计出微服务，所以目前项目的开发程度并不能完整实现所有的需求，但是基本的服务与接口请求调用基本还是能完整实现。**

前置说明，技术上还是有一些欠缺，我个人的技术栈能保证微服务开发运行，实际苦于缺少一定的实际项目经验无法将想法与需求结合后完全具现化。在实际代码的开发中，Spring MVC 的大部分功能内容都能完整实现，但实际是使用需要完善到Spring Security 整合 JWT保证安全性开发，且而外需求用到Kafka进行数据管理，在接近两周的开发中我需要花费一定的时间在Kafka和JWT技术上的学习，以保证技术上开发可行性。


## 关于启动执行

*本项目文件是使用IDEA进行开发的，可直接导入IDEA中或者使用maven打包之后运行jar文件*


## 可执行操作

### 数据层

#### Kafka与信息调取

##### 通过普通Spring Web访问数据库
    远端数据库shellwe.top:3306
    需要先执行数据库文件benjamin.sql 其中数据都为随机生成的假数据配置文件
    入口请在application.yml中修改，远端数据库不会一直开启访问接口为
    http://localhost:80/entity-unis
    需要访问方式 通过使用注解实现
    
    实体类 EntityUser 使用Lombok注解创建getter与setter
    
    Mybatis-plus的使用
    拦截器
        用于分页功能快速实现
    条件查询语句
        分别通过继承BaseMapper<E> IService<E>实现大部分通用数据操作
    
##### 通过Kafka访问数据库并加载到producer提供访问
    zookeeper启动在远端服务器shellwe.top:8088
    普通生产信息创建将通过 http://localhost:80/kafka/{singleMsg} 传入到 Topic001 中
    数据库信息将通过 http://localhost:80/kafka/multiMsg 获取数据库信息后返回 Topic001 中

### 业务层
    接口定义 interface => service
	接口名称应以业务名称定义，并与Dao接口区分
	实现类定义 serviceImpl
		返回Boolean用以简化流程 大于0 即成功执行数据库 小于等于0即执行失败
	测试类定义 springboottest
    业务层快速开发(Mybatis-Plus提供)
	业务层通用接口类 (IService<T>) 与业务层通用实现类(ServiceImpl<M, T>)
	通用功能不满足的情况下可直接重写或修改业务(追加)

#### JWT 与 Spring Security
    此处代码借助网络资料，目前我在JWT和Spring Security处于学习阶段，可能很难直接将自己的想法完整地实现
    且由于代码环境不同，则没有将目标项目整合到一起

    无凭证处理类 JwtAuthenticationEntryPoint.class
    当用户没有携带有效凭证时，就会转到这里来，当然，我们还需要在Spring Security的配置类中指定我们自定义的处理类才可以

    自定义认证失败类 LoginFailureHandler.class
    当用户输入错误的账号或者密码时，就会进入这个处理类，同样要在配置类中指明

    自定义权限不足处理类 JwtAccessDeniedHandler.class

    JWT工具类 JwtTokenUtil.class

    自定义认证成功处理类 JwtAuthenticationSuccessHandler.class
    当用户认证成功之后，我们要在这里为用户生成token,并返回给用户，需要用到我们自定义的jwt工具类，也需要在配置类中配置

### 表现层
    基于Restful进行表现层接口开发

    查询所有数据
	@GetMapping
	publicList<EntityUni>getAll(){
	returniEntityUniService.list();
	}
	
    保存到数据
	@PostMapping
	publicBooleansave(@RequestBodyEntityUnientityUni){
	returniEntityUniService.save(entityUni);
	}

    更新数据
	@PutMapping
	publicBooleanupdate(@RequestBodyEntityUnientityUni){
	returniEntityUniService.rewrite(entityUni);
	}

    通过id删除
	@DeleteMapping("{id}")
	publicBooleandelete(@PathVariableIntegerid){
	returniEntityUniService.removeById(id);
	}
	
    通过id获取
	@GetMapping("{id}")
	publicEntityUnigetById(@PathVariableIntegerid){
	returniEntityUniService.getById(id);
	}

    Kafka生产者提交单独信息
    @RequestMapping("/kafkas/{singleMsg}")

    Kafka生产者获取数据库信息
    @GetMapping("/kafkas/multiMsg")
   


### 安全性

    整合Spring Security 开发，目前学习中
    如果整合使用，启动后将会要求登录，使用原始Spring Security登录控制即user与随机生成密码

### 记录与监控

    通过 @Slf4j 注解实现，并且保存文件

### Kubernetes
    目前我仅有一台私人服务器，性能也能很难满足集群条件。k8s就不设计整合到其中，而且k8s我需要更深入学习
