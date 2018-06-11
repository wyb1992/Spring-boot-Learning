package com.example.redis;

import com.alibaba.fastjson.JSONObject;
import com.example.redis.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Test
	public void testSave() throws Exception {

		// 保存对象
		User user = new User("小王", 20);
		redisTemplate.opsForValue().set(user.getUsername(), JSONObject.toJSONString(user));

		user = new User("小李", 30);
		redisTemplate.opsForValue().set(user.getUsername(), JSONObject.toJSONString(user));

		user = new User("小赵", 40);
		redisTemplate.opsForValue().set(user.getUsername(), JSONObject.toJSONString(user));

	}

}
