package com.example.account.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

@Configuration
public class LocalRedisConfig {
    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer redisServer;


    @PostConstruct
    public void startRedis(){
        redisServer = new RedisServer(new File("/Users/eunseo/Desktop/zerobase/Mission2/Account/src/main/resources/binary.redis/redis-server-6.0.10-mac-arm64"), redisPort);
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis(){
        if(redisServer !=  null){
            redisServer.stop();
        }
    }
}
