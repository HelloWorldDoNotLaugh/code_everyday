## 引入依赖

```xml
        <dependency>
            <groupId>cn.fraudmetrix</groupId>
            <artifactId>module-elasticsearchV6-enterprise</artifactId>
            <version>6.3.5-atreus-es7</version>
            <exclusions>
                <exclusion>
                    <groupId>org.elasticsearch</groupId>
                    <artifactId>elasticsearch</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.elasticsearch</groupId>
            <artifactId>elasticsearch</artifactId>
            <version>1.3.4</version>
        </dependency>

```



## 添加配置并注入bean

