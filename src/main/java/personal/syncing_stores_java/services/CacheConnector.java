package personal.syncing_stores_java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Consumer;

@Component
public class CacheConnector {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${redis.prefix}")
    private String prefix;

    @Value("${redis.channel}")
    private String channel;

    // Equivalent to getCache(key)
    public String getCache(String key) {
        try {
            return redisTemplate.opsForValue().get(prefix + key);
        } catch (Exception e) {
            System.out.println("Error reading from cache: " + e.getMessage());
            return null;
        }
    }

    // Equivalent to apply({key, data, primary})
    public void apply(String key, String data, boolean primary) {
        redisTemplate.opsForValue().set(prefix + key, data);
        if (primary) {
            redisTemplate.convertAndSend(channel, data);
        }
    }

    // Equivalent to getAll()
    public List<String> getAll() {
        Set<String> keys = redisTemplate.keys(prefix + "*");
        if (keys == null) return Collections.emptyList();

        return keys.stream()
                .map(key -> redisTemplate.opsForValue().get(key))
                .collect(Collectors.toList());
    }

    // Equivalent to watchCache(cb)
    public void watchCache(Consumer<String> callback) {
        redisTemplate.getConnectionFactory().getConnection()
            .subscribe((message, pattern) -> {
                String msg = new String(message.getBody());
                System.out.println("message: " + msg);
                callback.accept(msg);
            }, channel.getBytes());
    }
}
