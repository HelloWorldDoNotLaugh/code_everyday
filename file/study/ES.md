## 什么是ES

ES是开源的企业级的分布式搜索引擎；

### 特点

- 一个分布式的实时文档存储，每个字段 可以被索引与搜索
- 一个分布式实时分析搜索引擎
- 能胜任上百个服务节点的扩展，并支持 PB 级别的结构化或者非结构化数据

### 基本概念

- **Near Realtime（NRT）** 近实时。数据提交索引后，立马就可以搜索到。
- **Cluster 集群**，一个集群由一个唯一的名字标识，默认为“elasticsearch”。集群名称非常重要，具有相同集群名的节点才会组成一个集群。集群名称可以在配置文件中指定。
- **Node 节点**：存储集群的数据，参与集群的索引和搜索功能。像集群有名字，节点也有自己的名称，默认在启动时会以一个随机的UUID的前七个字符作为节点的名字，你可以为其指定任意的名字。通过集群名在网络中发现同伴组成集群。一个节点也可是集群。
- **Index 索引**: 一个索引是一个文档的集合（等同于solr中的集合）。每个索引有唯一的名字，通过这个名字来操作它。一个集群中可以有任意多个索引。
- **Type 类型**：指在一个索引中，可以索引不同类型的文档，如用户数据、博客数据。从6.0.0 版本起已废弃，一个索引中只存放一类数据。
- **Document 文档**：被索引的一条数据，索引的基本信息单元，以JSON格式来表示。
- **Shard 分片**：在创建一个索引时可以指定分成多少个分片来存储。每个分片本身也是一个功能完善且独立的“索引”，可以被放置在集群的任意节点上。
- **Replication 备份**: 一个分片可以有多个备份（副本）

![image-20230904153743164](/Users/helloworld/code/code_everyday/file/study/ES.assets/image-20230904153743164.png)

## 安装Kibana

1. 下载地址

2. https://www.elastic.co/cn/downloads/past-releases/kibana-8-9-1

3. 修改 config/kibnana.yml: 

   elasticsearch.hosts
4. 启动 kibnan： bin/kibnan
5. 打开 kibnan
   http://localhost:5601


## ES常用查询
1. 检查ES节点

    http://10.58.11.10:19200/_cat/health?v

2. 获取集群节点列表

    http://10.58.11.10:19200/_cat/nodes?v

3. 查看集群全部索引 

   http://10.58.11.10:19200/_cat/indices?v

4. 创建索引与删除索引

   * 创建索引

     ```shell
     curl -XPUT 'localhost:9200/indexName?pretty'
     ```

   * 删除索引

     ```shell
     curl -XDELETE 'localhost:9200/indexName?pretty'
     ```

   * 查看

     ```shell
        curl -XGET 'localhost:9200/indexName/type/1?pretty'
     ```

   * 插入

     ```shell
     　　curl -XPUT 'localhost:9200/customer/external/1?pretty' -d' {
            　　  "name": "John Doe"
     　　}'
     ```




## 查看索引分片状态

curl -XGET '10.58.11.10:19200/_cat/shards/`autoscene36653_person`?v

```bash
curl -XGET '10.58.11.10:19200/_cat/shards/.kibana_7.17.5_001?v'
```

## 查看主分片状态

```bash
curl -XGET '10.58.11.10:19200/_cat/shards/.kibana_7.17.5_001?h=index,shard,prirep,state,unassigned.reason'
```

## 重新设置分片

```shell
curl -X POST '10.58.11.10:19200/_cluster/reroute?retry_failed=true'
```

## 查看某个索引的健康状态

```shell
curl -X GET "http://10.58.11.10:19200/.kibana_7.17.5_001/_health"
```

## 参考资料
* 官方文档 https://www.elastic.co/guide/en/elasticsearch/reference/current/index.html