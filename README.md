# Java面向对象设计 & LLM编程助手规则配置

## 项目概述

本项目包含两个主要部分：

1. **Java面向对象设计示例** - 经典设计模式的Java实现（观察者模式等）
2. **LLM编程助手规则配置系统** - 为不同开发框架创建专业的AI编程助手规则

## 目录结构

```
├── Java_Observer/                    # 观察者模式实现示例
│   ├── src/com/panda/java/design/observer/
│   │   ├── data/                     # 数据层
│   │   ├── display/                  # 显示层
│   │   ├── inter/                    # 接口定义
│   │   └── station/                  # 应用程序入口
│   └── bin/                          # 编译输出目录
├── LLM_Java_Assistant_Rules.md       # 通用Java开发助手规则
├── LLM_Spring_Boot_Assistant_Rules.md # Spring Boot专用助手规则
├── LLM_Assistant_Rules_Usage_Guide.md # 使用指南
└── README.md                         # 项目说明文档
```

## Java设计模式示例

### 观察者模式实现

项目中包含了观察者模式的完整实现：

- **Subject接口**: 定义主题的基本操作
- **Observer接口**: 定义观察者的更新方法
- **WeatherData**: 天气数据主题的具体实现
- **Display组件**: 各种显示组件的观察者实现

#### 运行示例

```bash
cd Java_Observer
javac -d bin src/com/panda/java/design/observer/*/*.java
java -cp bin com.panda.java.design.observer.station.WeatherStation
```

## LLM编程助手规则配置系统

### 核心特性

- **上下文感知**: 深度理解项目技术栈和架构模式
- **保持一致性**: 确保AI生成代码与现有代码库风格一致
- **工具利用最大化**: 优先使用项目已配置的工具和框架
- **减少随意性**: 严格限制AI的自由发挥，防止引入不符合规范的代码

### 可用规则配置

#### 1. 通用Java开发规则 (`LLM_Java_Assistant_Rules.md`)
适用于：
- 标准Java SE/EE项目
- 面向对象设计模式项目
- 传统Java应用程序

#### 2. Spring Boot专用规则 (`LLM_Spring_Boot_Assistant_Rules.md`)
适用于：
- Spring Boot Web应用
- Spring Boot微服务
- Spring生态系统项目

### 快速开始

1. **选择规则文件**: 根据项目技术栈选择对应的规则配置文件
2. **自定义配置**: 将 `{{框架名称}}` 替换为具体的框架名称和版本
3. **配置AI助手**: 将规则内容设置为AI助手的系统提示词
4. **验证效果**: 测试AI生成的代码是否符合项目规范

### 示例使用

```markdown
# 原始模板
- 框架：{{框架名称}} {{版本}}

# 自定义后
- 框架：Spring Boot 2.7.0
```

## 技术规范

### Java代码规范
- 使用标准Java命名约定（camelCase、PascalCase）
- 遵循面向对象设计原则（SOLID）
- 采用标准包结构组织代码
- 包含完整的异常处理机制

### 架构模式
- **观察者模式**: 事件通知和状态变化监听
- **分层架构**: Controller-Service-Repository分层
- **依赖注入**: 通过接口实现解耦
- **MVC模式**: 分离关注点

## 贡献指南

### 添加新框架规则

1. Fork本仓库
2. 创建新的规则文件：`LLM_{框架名}_Assistant_Rules.md`
3. 遵循现有文件结构：
   - 项目上下文
   - 专家设定  
   - 技术约束
   - 代码规范
   - 架构遵循
   - 工具集成
   - 质量守护
   - 示例模式
4. 提交Pull Request

### 改进现有规则

欢迎提交改进建议：
- 补充遗漏的技术约束
- 完善代码示例
- 优化规则描述
- 修正错误信息

## 许可证

本项目采用MIT许可证，详见LICENSE文件。

## 联系方式

如有问题或建议，请通过以下方式联系：
- 提交GitHub Issue
- 发起Pull Request
- 参与项目讨论