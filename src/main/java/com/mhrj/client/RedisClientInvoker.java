package com.mhrj.client;

import redis.clients.jedis.Jedis;

import java.io.IOException;

public interface RedisClientInvoker<T> {
    T invoke(Jedis jedis) throws IOException;
}
