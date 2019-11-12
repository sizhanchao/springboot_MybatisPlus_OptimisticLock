package com.zhan.mp_optimisticlock.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhan
 * @since 2019-11-12 11:06
 */
@Configuration
public class MybatisPlusConfig {
    /**
     *
     * 当要更新一条记录的时候，希望这条记录没有被别人更新
     *
     * 乐观锁 插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }
}
