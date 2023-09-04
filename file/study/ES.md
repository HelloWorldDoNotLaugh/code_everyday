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