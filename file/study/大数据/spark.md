## Demo wordCount
### 1. 安装spark

官网下载：https://spark.apache.org/downloads.html

解压

bin目录下：

```shell
./spark-shell
```

### 2. 代码编写

先准备个txt文件

![image-20230913115048085](./spark.assets/image-20230913115048085.png)

依次敲入代码

![image-20230913115125024](./spark.assets/image-20230913115125024.png)

```scala
import org.apache.spark.rdd.RDD

val rootPath: String = "/Users/td/Desktop/spark.txt"

// 读取文件内容
val lineRDD: RDD[String] = spark.sparkContext.textFile(rootPath)

// 以行为单位做分词
val wordRDD: RDD[String] = lineRDD.flatMap(line => line.split(" "))
val cleanWordRDD: RDD[String] = wordRDD.filter(word => !word.equals(""))

// 把RDD元素转换为（Key，Value）的形式
val kvRDD: RDD[(String, Int)] = cleanWordRDD.map(word => (word, 1))
// 按照单词做分组计数
val wordCounts: RDD[(String, Int)] = kvRDD.reduceByKey((x, y) => x + y)

// 打印词频最高的5个词汇
wordCounts.map{case (k, v) => (v, k)}.sortByKey(false).take(5)
```

效果：	

![image-20230913115329596](./spark.assets/image-20230913115329596.png)

## RDD与编程模型

### 什么是RDD

RDD是一种抽象，是Spark对于分布式数据集的抽象，它用于囊括所有内存中和磁盘中的分布式数据实体。

![image-20230913140026484](./spark.assets/image-20230913140026484.png)

**RDD的四大属性** 

* partitions: 数据分片
* partitioner: 分片切割规则
* dependencies: RDD依赖
* compute: 转换函数

### 编程模型与延迟计算

RDD是spark对于分布式数据集的抽象，每一个RDD都代表着一种分布式数据形态。

在wordCount Demo中，得到最终的计算结果，经过多次的RDD转换。

RDD到RDD间的转换，本质上是数据形态间的转换(Transformations)

在RDD的编程模型中，一共有两种算子，Transformations类算子和Actions类算子。

**Transformations类算子**定义描述数据形态的转换过程；

**Actions类算子**将计算结果收集起来，或是物化到磁盘。

![image-20230913142638048](./spark.assets/image-20230913142638048.png)

```scala
import org.apache.spark.rdd.RDD

val rootPath: String = "/Users/td/Desktop/spark.txt"

// 读取文件内容
val lineRDD: RDD[String] = spark.sparkContext.textFile(rootPath)

// 以行为单位做分词
val wordRDD: RDD[String] = lineRDD.flatMap(line => line.split(" "))
val cleanWordRDD: RDD[String] = wordRDD.filter(word => !word.equals(""))

// 把RDD元素转换为（Key，Value）的形式
val kvRDD: RDD[(String, Int)] = cleanWordRDD.map(word => (word, 1))
// 按照单词做分组计数
val wordCounts: RDD[(String, Int)] = kvRDD.reduceByKey((x, y) => x + y)

// 打印词频最高的5个词汇
wordCounts.map{case (k, v) => (v, k)}.sortByKey(false).take(5)
```

在这样的编程模型下，spark在运行时的计算被划分为两个环节：

**1. 基于不同数据形态之间的转换，构架计算流图(DAG, Directed Acyclic Graph)**

**2. 通过Actions类算子，以回溯的方式触发执行这个计算流图。**

![image-20230913150833052](./spark.assets/image-20230913150833052.png)

在调用各种Transformations算子做数据转换时，并没有立即执行计算，只有调用Action算子时，之前调用的Transformations才会被计算。这样的计算模式被称为**延迟计算**

![image-20230913151327864](./spark.assets/image-20230913151327864.png)

## RDD内部的数据转换

**创建RDD的两种方式** 

* 通过SparkContext.parallelize在内部数据上创建RDD
* 通过SparkContext.textFile等API从外部数据创建RDD

**基于内部数据创建**

```scala
import org.apache.spark.rdd.RDD
val words: Array[String] = Array("Spark", "is", "cool")
val rdd: RDD[String] = sc.parallelize(words)
```

**基于外部数据创建**

```scala
import org.apache.spark.rdd.RDD
val rootPath: String = _
val file: String = s"${rootPath}/wikiOfSpark.txt"
// 读取文件内容
val lineRDD: RDD[String] = spark.sparkContext.textFile(file)
```

### map：以元素为粒度的数据转换

**map算子的用法**：给定映射函数f，map(f)以元素为粒度对RDD做数据转换。

```scala
// 把普通RDD转换为Paired RDD
val cleanWordRDD: RDD[String] = _ // 请参考第一讲获取完整代码
val kvRDD: RDD[(String, Int)] = cleanWordRDD.map(word => (word, 1))
```

其中 word => (word, 1) 是匿名函数

### mapPartitions：以数据分区为粒度对数据转换

**mapPartitions算子用法**： 以数据分区为粒度，使用映射函数f对RDD进行函数数据转换





