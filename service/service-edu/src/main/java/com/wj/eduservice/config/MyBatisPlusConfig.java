package com.wj.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ：wj
 * @date ：Created in 2021/8/9 20:48
 * @description：
 * @version:
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.wj.eduservice.mapper")
public class MyBatisPlusConfig {
    /**
     * create by: wj
     * description: 逻辑删除插件
     * create time:
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
