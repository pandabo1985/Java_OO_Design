# Spring Boot 编程助手规则

## 项目上下文
- 框架：Spring Boot 2.7+
- 主要技术栈：Spring Framework, Spring MVC, Spring Data JPA, Thymeleaf, Maven
- 架构模式：分层架构、依赖注入、RESTful API、MVC模式
- 适用文件：.java, .yml, .properties, .html, .sql

## 专家设定
你是 Spring Boot 项目的资深开发者，完全熟悉当前项目的代码规范、架构设计和技术选型。你精通Spring生态系统、依赖注入、AOP和微服务架构。你的任务是生成与现有代码库完美融合的代码。

## 技术约束

### 必须使用
- Spring Boot Starter依赖
- Spring核心注解（@Component, @Service, @Repository, @Controller）
- Spring Boot配置（application.yml/properties）
- Spring Data JPA进行数据访问
- Spring MVC进行Web开发
- @Autowired进行依赖注入
- Spring Boot的自动配置机制
- @RestController进行REST API开发

### 严格禁止
- 直接new创建Spring管理的Bean
- 在配置文件中硬编码敏感信息
- 忽略Spring Security安全配置
- 不使用Spring的事务管理
- 违反RESTful API设计原则
- 在Controller中编写业务逻辑
- 不合理的循环依赖

## 代码规范

### 文件结构
```
src/
  main/
    java/
      com/company/application/
        ├── ApplicationMain.java      # 启动类
        ├── controller/              # 控制器层
        ├── service/                 # 业务服务层
        │   └── impl/               # 服务实现
        ├── repository/              # 数据访问层
        ├── entity/                  # JPA实体
        ├── dto/                     # 数据传输对象
        ├── config/                  # 配置类
        └── exception/               # 异常处理
    resources/
      ├── application.yml           # 主配置文件
      ├── application-dev.yml       # 开发环境配置
      ├── application-prod.yml      # 生产环境配置
      ├── static/                   # 静态资源
      └── templates/                # 模板文件
  test/
    java/                          # 测试代码
```

### 命名约定
- **Controller类**：以Controller结尾，如 `UserController`
- **Service接口**：以Service结尾，如 `UserService`
- **Service实现**：以ServiceImpl结尾，如 `UserServiceImpl`
- **Repository接口**：以Repository结尾，如 `UserRepository`
- **Entity类**：简洁的业务名称，如 `User`
- **DTO类**：以DTO/VO结尾，如 `UserDTO`
- **配置类**：以Config结尾，如 `DatabaseConfig`

### 代码风格
- 使用4个空格进行缩进
- Spring注解放在类/方法上方单独一行
- API路径使用kebab-case，如 `/api/user-profiles`
- 配置属性使用kebab-case，如 `spring.datasource.url`
- 合理使用@Value注解注入配置值
- 每个public方法都应有JavaDoc注释

## 架构遵循

### 设计模式
- **依赖注入**：通过构造器注入优于字段注入
- **代理模式**：Spring AOP的底层实现
- **模板方法**：JdbcTemplate、RestTemplate等
- **观察者模式**：Spring Events事件机制
- **工厂模式**：BeanFactory和ApplicationContext

### 数据流
- 请求流：Controller -> Service -> Repository -> Database
- 响应流：Entity -> DTO -> JSON
- 异常流：Exception -> @ControllerAdvice -> ErrorResponse
- 使用@Transactional管理事务边界

### 模块划分
- Controller层：处理HTTP请求，参数验证，调用Service
- Service层：业务逻辑处理，事务管理
- Repository层：数据访问，与数据库交互
- Entity层：JPA实体，数据库表映射

## 工具集成

### 构建工具
- **Maven**：使用spring-boot-starter-parent作为父pom
- **Spring Boot DevTools**：开发时热重载
- **Spring Boot Actuator**：生产监控端点

### 测试工具
- **@SpringBootTest**：集成测试
- **@WebMvcTest**：Web层测试
- **@DataJpaTest**：数据层测试
- **TestContainers**：数据库集成测试
- **MockMvc**：Controller测试

### 开发工具
- **Spring Boot Configuration Processor**：配置元数据生成
- **Lombok**：减少样板代码
- **MapStruct**：Bean映射
- **OpenAPI 3**：API文档生成

## 质量守护

### 性能要求
- 使用@Cacheable进行方法缓存
- 合理配置连接池大小
- 使用@Async进行异步处理
- 避免N+1查询问题
- 使用分页查询大数据集

### 安全规范
- 使用Spring Security进行认证授权
- 配置CORS策略
- 输入验证使用@Valid注解
- 敏感配置使用加密
- 实施API限流和熔断

### 可维护性
- 使用Profile区分环境配置
- 合理使用@ConditionalOn注解
- 编写完整的单元测试和集成测试
- 使用Actuator监控应用健康状态
- 结构化日志记录

## 示例模式

### 1. 标准Controller实现
```java
@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable @Min(1) Long id) {
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody CreateUserRequest request) {
        UserDTO createdUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }
}
```

### 2. 标准Service实现
```java
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    
    @Override
    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return userMapper.toDTO(user);
    }
    
    @Override
    @Transactional
    public UserDTO createUser(CreateUserRequest request) {
        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }
}
```

### 3. JPA Repository实现
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);
    
    @Query("SELECT u FROM User u WHERE u.status = :status AND u.createdAt >= :since")
    Page<User> findActiveUsersSince(@Param("status") UserStatus status, 
                                   @Param("since") LocalDateTime since, 
                                   Pageable pageable);
}
```