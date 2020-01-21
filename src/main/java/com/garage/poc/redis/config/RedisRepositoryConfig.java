package com.garage.poc.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableRedisRepositories
public class RedisRepositoryConfig {
	private final RedisProperties redisProperties;

	/*
	 * // jedis
	 * 
	 * @Bean public RedisConnectionFactory redisConnectionFactory() {
	 * RedisStandaloneConfiguration config = new
	 * RedisStandaloneConfiguration(redisProperties.getHost(),
	 * redisProperties.getPort()); return new JedisConnectionFactory(config); }
	 */

//    jedis connection pool
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(config);
//        jedisConnectionFactory.setPoolConfig(jedisPoolConfig());
//        return jedisConnectionFactory;
//    }
//
//    private JedisPoolConfig jedisPoolConfig() {
//        final JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxTotal(128);
//        poolConfig.setMaxIdle(128);
//        poolConfig.setMinIdle(36);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setTestOnReturn(true);
//        poolConfig.setTestWhileIdle(true);
//        poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
//        poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
//        poolConfig.setNumTestsPerEvictionRun(3);
//        poolConfig.setBlockWhenExhausted(true);
//        return poolConfig;
//    }

	// lettuce
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());

		/*
		 * In Sentinel Configuration 
		 * 
		 * RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
		 * 		.master("mymaster") 
		 * 		.sentinel("127.0.0.1", 26379)
		 * 		.sentinel("127.0.0.1", 26380); 
		 * return new LettuceConnectionFactory(sentinelConfig);
		 * 
		 * // spring.redis.sentinel.master: name of the master node. 
		 * // spring.redis.sentinel.nodes: Comma delimited list of host:port pairs. 
		 * // spring.redis.sentinel.password: The password to apply when authenticating
		 * with Redis Sentinel
		 */

		/*
		 * In WriteToMasterReadFromReplica Configuration LettuceClientConfiguration
		 * 
		 * clientConfig = LettuceClientConfiguration.builder()
		 * 		.readFrom(SLAVE_PREFERRED) 
		 * 		.build();
		 * 
		 * RedisStandaloneConfiguration serverConfig = new RedisStandaloneConfiguration("server", 6379);
		 * 
		 * return new LettuceConnectionFactory(serverConfig, clientConfig);
		 */
	}

	@Bean
	public RedisTemplate<?, ?> redisTemplate() {
		RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	}
}
