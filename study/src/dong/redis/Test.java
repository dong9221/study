package dong.redis;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

public class Test {
	
	public static void main(String[] args) {
		testRedis();
	}
	private static void testRedis() {
		Jedis jedis = new Jedis("192.168.67.131",6379);
		String ping = jedis.ping();
		System.out.println(ping);
		//jedis.set("aa", "aaq");
		System.out.println(jedis.get("aa"));
		String age = jedis.hget("dong", "age");
		System.out.println(age);
		Map hash = new HashMap();
		Map m = new HashMap();
		m.put("ww", "ww");
		hash.put("ss", m);
		jedis.hmset("dd", hash);
		String dd_ss = jedis.hget("dd", "ss");
		System.out.println(dd_ss);
	}
}
