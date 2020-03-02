# Table of Contents

  * [Eureka核心特性](#eureka核心特性)
    * [服务注册](#服务注册)
    * [服务续约](#服务续约)
    * [服务下线](#服务下线)
    * [获取注册列表信息](#获取注册列表信息)
  * [Eureka面试点](#eureka面试点)
    * [注册中心比较](#注册中心比较)
    * [Eureka注册慢问题](#eureka注册慢问题)
    * [Eureka的自我保护](#eureka的自我保护)
  * [Ribbon负载均衡](#ribbon负载均衡)
    * [概述](#概述)
    * [Ribbon的核心](#ribbon的核心)
      * [IRule](#irule)
      * [IPing](#iping)
      * [ServerList](#serverlist)
  * [Hystrix](#hystrix)
    * [概述](#概述-1)
    * [主要作用](#主要作用)
    * [两种命令模式](#两种命令模式)
    * [配置GroupKey](#配置groupkey)
    * [配置CommandKey](#配置commandkey)
    * [请求缓存](#请求缓存)
    * [请求合并](#请求合并)
    * [隔离术](#隔离术)
    * [降级处理](#降级处理)
      * [降级触发原则](#降级触发原则)
      * [快速失败](#快速失败)
    * [熔断机制](#熔断机制)


## Eureka核心特性
![Eureka](image/Eureka.png)
### 服务注册
* Eureka Client在第一次心跳时Eureka Server注册
* 注册时提供诸多元数据: 主机名, 端口, 健康指标URL等
### 服务续约
* Eureka Client通过发送心跳进行续约
* 默认情况下是每30s发送一次心跳
* 如果90s内Eureka Server未收到续约, 则进行服务剔除 
### 服务下线
* Eureka Client优雅退出时会发送cancel的命令
* Eureka Server在收到cancel命令时会删除该节点
### 获取注册列表信息
* Eureka Client会缓存由Server获取的注册表信息
* Eureka Client会定期更新注册表信息, **默认是30s**
* Eureka Client会处理注册表的合并等内容
## Eureka面试点
### 注册中心比较
* 分布式基础CAP理论: 没有任何一个系统能同时满足CAP 
    * 一致性: Consistency
    * 可用性: Availability
    * 分区容错性: Partition tolerance
* 常见的注册中心: Zookeeper, Eureka等
* Eureka主要保证AP特性: 可用和容错
* Zookeeper主要保证CP特性: 一致和容错
### Eureka注册慢问题
* 根本原因在于Eureka的AP特性
* Eureka Client延迟注册, 默认30s
* Eureka Server的响应缓存, 默认30s
* Eureka Server的缓存刷新, 默认30s
### Eureka的自我保护
* Eureka Server会自动更新续约更新阈值
* 当Eureka Server续约更新频率低于阈值则进入保护模式
* 自我保护的模式下Eureka Server不会剔除任何的注册信息
## Ribbon负载均衡
### 概述
* Ribbon是**客户端**负载均衡器
* Ribbon核心功能: 服务发现, 服务的选择规则, 服务监听
### Ribbon的核心
#### IRule
* IRule通过特定的算法选取要访问的服务
* IRule的常用的算法: BestAvailableRule, WeightedResponseTimeRule
![](image/4362ece3.png)
#### IPing
* 探测服务存活状态
* 是Ribbon保证服务可用的基石
* 常见的实现: NIWSDiscoveryPing, PingUrl
![](image/3dcc805a.png)
#### ServerList
* ServerList是Ribbon存储的可用服务列表
* ServerList可以手动设置
* ServerList常见应用是从Eureka中自动获取
## Hystrix
![](image/fcd4f1da.png)
### 概述
* Hystrix是用于处理演出和容错的**开源库**
* Hystrix只要勇于避免联级故障, 提高系统的弹性
* Hystrix解决了由于扇出导致的 "雪崩效应"
* Hystrix核心是 "隔离术" 和 "熔断机制"
![](image/c6b1fb6f.png)
### 主要作用
* **服务隔离** 和 **服务熔断**
* **服务降级**, **限流** 和 **快速失败**
* 请求合并和请求缓存
* 自带单体和集群监控
### 两种命令模式
* HystrixCommand和HystrixObservableCommand
* Command会以隔离的形式完成run方法调用
* ObservableCommand使用当前线程进行调用
### 配置GroupKey
* Hystrix中GroupKey是唯一必填项
* GroupKey可以作为分组监控和报警作用
* GroupKey将作为线程池的默认名称
### 配置CommandKey
* Hystrix可以不填写CommandKey
* 默认Hystrix会反射类名命名CommandKey
* 在Setting中加入andCommandKey进行命名
### 请求缓存
* Hystrix支持将请求结果进行本地缓存
* 通过实现getCacheKey方法来判断是否取出缓存
* 请求缓存要求请求必须在同一个上下文
* 可以通过RequestCacheEnabled开启请求缓存
### 请求合并
* 支持多次请求合并成一次请求
* 请求合并要求两次请求必须足够的"近" (默认是10ms)
* 请求合并分为局部合并和全局合并两种
* Collapser可以设置相关参数
### 隔离术
* 提供了信号量和线程两种隔离手段
* 线程隔离会在单独的线程中执行业务逻辑
* 信号量隔离在调用线程上执行
* 官方推荐优先线程隔离
### 降级处理
* 降级是一种"无奈"的选择,简单说就是B方案
* Command降级需要实现fallback方法
* ObservableCommand降级实现ResumeWithFallback方法
#### 降级触发原则
* HystrixBadRequestException以外的异常都会被降级处理
* 运行超时或熔断处于开启的状态
* 线程池或信号量已满
#### 快速失败
* Hystrix提供了快速失败的机制
* 当不实现fallback的时候会将异常直接抛出
### 熔断机制
* 熔断器是一种开关,用来控制流量是否执行业务逻辑
* 熔断器核心指标:
    * 快照时间窗 (即一个时间段)
    * 请求总数阈值
    * 错误百分比阈值
* 熔断器开启: 所有的请求都会进入fallback方法
* 熔断器半开启: 间歇性让请求触发run方法
* 熔断器关闭: 正常处理业务请求
* 默认情况下熔断器开启**5s**之后进入半开启状态
