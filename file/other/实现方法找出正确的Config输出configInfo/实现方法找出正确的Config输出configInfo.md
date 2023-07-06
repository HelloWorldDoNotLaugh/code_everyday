## 需求描述

```java
class TravelInfo{
    private Long depTime;
    private String depCode;
    private String arrCode;
    private String company;
}
出发：北京
到达 上海
出发时间：2023-06-11
航司：CA
class Config{
    private Boolean mustBeforeDepTime;
    private List<String> depCodes;
    private List<String> arrCodes;
    private String company;
    private String configInfo;
}

1：
    {true,[北京，上海，南京]，[南京，天津]，MU，"AAAAAAAA"}
2:
    {false,[上海],[乌鲁木齐],CA,"BBBBBBB"}
3:
    {false,[北京],[上海，杭州],CA,"CCCCCCCC"}

实现方法找出正确的Config输出configInfo
public String findConfig(TravelInfo t, List<Config> configs){
    
}
```

## 实现方案

依次校验条件是否满足

* 时间 (待确认)
* 出发地点
* 目的地点
* 航空公司编码

如果存在返回其中的一个，不存在抛出异常

```java
package com.wy;

import cn.hutool.core.date.DateUtil;
import lombok.Data;

import java.util.List;

public class Temp {
    public String findConfig(TravelInfo travelInfo, List<Config> configs) {
        return configs.stream()
                // todo 不理解config.mustBeforeDepTime 的具体含义。必须在出发时间之前提前预定吗？
                .filter(config -> config.getMustBeforeDepTime() && DateUtil.current() > travelInfo.getDepTime())
                .filter(config -> config.getDepCodes().contains(travelInfo.getDepCode()))
                .filter(config -> config.getArrCodes().contains(travelInfo.getArrCode()))
                .filter(config -> config.getCompany().equals(travelInfo.getCompany()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no config found"))
                .getConfigInfo();

    }
}
@Data
class TravelInfo{
    private Long depTime;
    private String depCode;
    private String arrCode;
    private String company;
}

@Data
class Config{
    private Boolean mustBeforeDepTime;
    private List<String> depCodes;
    private List<String> arrCodes;
    private String company;
    private String configInfo;
}
```

