package com.wy.spring_demo.es.config;

import cn.fraudmetrix.module.elasticsearch.SearchServiceFactory;
import cn.fraudmetrix.module.elasticsearch.basic.ElasticSearchConfig;
import cn.fraudmetrix.module.elasticsearch.basic.SearchService;
import cn.fraudmetrix.module.elasticsearch.basic.select.SelectBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/11
 */

@Configuration
@ComponentScan({"cn.fraudmetrix.module.elasticsearch"})
public class EsClientService {
    private static final String INVOKE_RECORD_MAPPING = "invokerecord";

    @Bean("invokeRecordConfig")
    @ConfigurationProperties(prefix = "invokerecord.store.es")
    ElasticSearchConfig invokeRecordConfig() {
        return new ElasticSearchConfig();
    }

    @Bean("invokeRecordService")
    SearchService invokeRecordService(@Autowired @Qualifier("invokeRecordConfig") ElasticSearchConfig config) {
        return SearchServiceFactory.create(config, true);
    }

    @Resource(name = "invokeRecordService")
    private SearchService invokeRecordService;

    public SelectBuilder invokeRecordSelectBuilder() {
        return invokeRecordService.selectFrom(INVOKE_RECORD_MAPPING);
    }
}
