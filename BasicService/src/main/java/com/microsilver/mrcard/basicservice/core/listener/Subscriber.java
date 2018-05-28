package com.microsilver.mrcard.basicservice.core.listener;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Subscriber  {

	public static void main(String[] args) {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
		Jedis jedis = pool.getResource();
		jedis.auth("superShortLeg@2018");
		jedis.set("999578064021872640", "22222222222222222");
		jedis.expire("999578064021872640", 10);
		jedis.psubscribe(new KeyExpiredListener(), "__key*__:*");
	}
}
