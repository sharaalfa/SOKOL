package io.khasang.sokol.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.jcache.JCacheManagerFactoryBean;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
//import net.sf.ehcache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager(net.sf.ehcache.CacheManager cm, javax.cache.CacheManager jcm) {
        CompositeCacheManager cacheManager = new CompositeCacheManager();
        List<CacheManager> managers = new ArrayList<CacheManager>();
        managers.add(new JCacheCacheManager(jcm));
        managers.add(new EhCacheCacheManager(cm));
        //managers.add(new RedisCacheManager(redisTemplate()));
        cacheManager.setCacheManagers(managers);
        return cacheManager;
    }

//    @Bean
//    public EhCacheCacheManager cacheEhCacheManager(CacheManager cm) {
//        return new EhCacheCacheManager(cm);
//    }

//    @Bean
//    public CacheManager cacheRedisManager(RedisTemplate redisTemplate) {
//        return new RedisCacheManager(redisTemplate);
//    }

    @Bean
    public EhCacheManagerFactoryBean ehcache() {
        EhCacheManagerFactoryBean ehCacheFactoryBean =
                new EhCacheManagerFactoryBean();
        ehCacheFactoryBean.setConfigLocation(
                new ClassPathResource("com/habuma/spittr/cache/ehcache.xml"));
        return ehCacheFactoryBean;

    }

    @Bean
    public JCacheManagerFactoryBean jcache() {
        JCacheManagerFactoryBean ehCacheFactoryBean =
                new JCacheManagerFactoryBean();
        return ehCacheFactoryBean;
    }
//    @Bean
//    public JedisConnectionFactory redisConnectionFactory() {
//        JedisConnectionFactory jedisConnectionFactory =
//                new JedisConnectionFactory();
//        jedisConnectionFactory.afterPropertiesSet();
//        return jedisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(
//            RedisConnectionFactory redisCF) {
//        RedisTemplate<String, String> redisTemplate =
//                new RedisTemplate<String, String>();
//        redisTemplate.setConnectionFactory(redisCF);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }
}
