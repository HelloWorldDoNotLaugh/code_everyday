## kafka

Apache Kafka是一款开源的消息引擎系统也是一个分布式流处理平台；支持两种消息引擎模型：点对点模型，发布-订阅模型。

## 常用术语

* 生产者
* 消费者
* 客户端：生产者消费者的客户端应用程序
* 服务器端：由broker进程组成。一个kafka集群由多个broker组成。
* broker：负责接收和处理客户端的请求，以及对消息持久化
* 分区：一个主题下有多个分区
* 主题
* 消费者组：Consumer Group。多个消费者实例共同组成的一个组，同时消费多个分区以实现高吞吐。
* 重平衡：Rebalance。消费者组内某个消费者实例挂掉后，其他消费者实例自动重新分配订阅主题分区的过程。Rebalance是Kafka消费者端实现高可用的重要手段。

## kafka高可用的原因

1. kafka集群是由多个broker组成，并且不同的broker分布在不同的服务器上。这样当一台机器宕机后，整个集群依旧可用。
2. 备份机制：kafka中有两类副本：领导者副本(leader replica) 和 追随者副本(follower replica)。leader replica提供对外服务，会与客户端进行交互，但是follwer replica仅与leader replica交互来获取leader中最新的消息。



## kafka broker的数据持久化

kafka使用消息日志来保存数据，一个消息日志就是磁盘上只能追加写消息的物理文件。因为只能追加写入，因此也避免了缓慢的随机I/O操作，改为性能较好的的顺序I/O写操作，这也是实现kafka高吞吐特性的一个重要手段。

## kafka集群参数配置

### broker端参数

| log.dirs                       | Broker需要使用的若干个文件目录路径，/home/kafka1,/home/kafka2,/home/kafka3 |
| ------------------------------ | ------------------------------------------------------------ |
| zookeeper.connect              | zk1:2181,zk2:2181,zk3:2181                                   |
| auto.create.topics.enable      | 是否允许自动创建Topic，推荐值 false                          |
| unclean.leader.election.enable | 是否让与leader副本数据差距较大的follower副本参与选举：推荐值false |
| auto.leader.rebalance.enable   | 定期有条件更换leader，推荐值 false                           |

### topic级别参数

topic参数与broker参数作用相同时，topic会覆盖broker

| retention.ms    | 规定了该Topic消息被保存的时长。默认是7天，即该Topic只保存最近7天的消息。一旦设置了这个值，它会覆盖掉Broker端的全局参数值。 |
| --------------- | ------------------------------------------------------------ |
| retention.bytes | 规定了要为该Topic预留多大的磁盘空间。和全局参数作用相似，这个值通常在多租户的Kafka集群中会有用武之地。当前默认值是-1，表示可以无限使用磁盘空间。 |

### JVM参数

* 堆大小，默认1g，推荐6g： KAFKA_HEAP_OPTS=--Xms6g  --Xmx6g

* 指定GC参数： 

	```java
	KAFKA_JVM_PERFORMANCE_OPTS= -server -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:+ExplicitGCInvokesConcurrent -Djava.awt.headless=true
	```

### 操作系统参数

- 文件描述符限制： ulimit -n 1000000， 较小会提示：Too many open files

## 分区策略配置

在生产者端实现`org.apache.kafka.clients.producer.Partitioner`接口

* 轮询策略：默认的，当未显示指定`partitioner.class`参数时，默认轮询

* 随机策略：

	```java
	List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
	return ThreadLocalRandom.current().nextInt(partitions.size());
	```

	先计算出该主题总的分区数，然后随机地返回一个小于它的正整数。

* **按消息键保序策略**

	```java
	List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
	return Math.abs(key.hashCode()) % partitions.size();
	```

	如果指定了Key，那么默认实现按消息键保序策略；如果没有指定Key，则使用轮询策略。

## 消息压缩

**当生产者端的CPU资源充足时，可以考虑开启压缩**

在生产者端压缩，broker保持，消费者解压

