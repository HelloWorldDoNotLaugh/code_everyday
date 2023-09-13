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

![image-20230913115048085](/Users/helloworld/code/code_everyday/file/study/大数据/spark.assets/image-20230913115048085.png)

依次敲入代码

![image-20230913115125024](/Users/helloworld/code/code_everyday/file/study/大数据/spark.assets/image-20230913115125024.png)

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

![image-20230913115329596](/Users/helloworld/code/code_everyday/file/study/大数据/spark.assets/image-20230913115329596.png)
