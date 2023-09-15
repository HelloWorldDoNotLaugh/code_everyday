package com.wy.spring_demo.es.config.service;

import cn.fraudmetrix.module.elasticsearch.basic.select.SelectBuilder;
import com.wy.spring_demo.es.config.EsClientService;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/11
 */
@Service("invokeRecordElasticService")
public class InvokeRecordElasticService {

    @Autowired
    private EsClientService esClientService;
    public void getData() {
        SelectBuilder selectBuilder = esClientService.invokeRecordSelectBuilder();

        // set builder
        // selectBuilder.whereIn()

        Aggregations aggregations = selectBuilder.limit(0, 10).response().getAggregations();

        // 解析 aggregations
    }
}
