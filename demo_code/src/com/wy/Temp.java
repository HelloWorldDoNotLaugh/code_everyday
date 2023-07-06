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