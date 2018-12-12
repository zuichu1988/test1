package com.mhrj.controll;

import com.mhrj.entity.TArticle;
import com.mhrj.utils.RedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * 测试类
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/redis")
public class TestJRedisControll {

	@RequestMapping("/test1")
	public void list(HttpServletRequest req){
		System.out.println("hello redis");
    }
	//核心工具对象
	@Autowired
    private RedisCache redisCache;
	private Logger LOGGER = LoggerFactory.getLogger(TestJRedisControll.class);
	 /**
     * 存储字符串
     */
	@RequestMapping("/test2")
    public void testPutString() {
        String key = "test_string_2";
        String value = "string_value";
        System.out.println("存储字符串开始 key='"+key+"' value='"+value+"'" );
        boolean putFlag = redisCache.put(key, "string_value", 0, TimeUnit.MINUTES);
        System.out.println(TimeUnit.MINUTES);
        System.out.println(TimeUnit.MINUTES);
        System.out.println(TimeUnit.MINUTES);
        
        
        System.out.println("存储字符串结束 putFlag='"+putFlag+"'" );
        String rvalue = redisCache.get(key);
        System.out.println("存储字符串-> 查询缓存value='"+rvalue+"'");
    }
    /**
     * 存储自定义对象
     */
	@RequestMapping("/test3")
    public void testPutObject() {
        String key = "test_object_article_2";
        TArticle tArticle =
                new TArticle("1111", "测试文章1", "作者1", 1.0, 1);
        System.out.println("存储对象开始 key='"+key+"'   value='"+tArticle+"'");
        redisCache.put(key, tArticle);
        
        System.out.println("存储对象结束");
        TArticle value = redisCache.get(key, TArticle.class);
        System.out.println("存储对象-> 查询缓存value='"+value+"'");
    }
	/**
	 * 
	 */
	@RequestMapping("/test4")
	public void aaa()
	{
		String article;
		article=redisCache.get("test_object_article_2");
		System.out.println(article);
	}
	
	@RequestMapping("/test5")
	public void bbb()
	{
		String qqq=redisCache.get("test_string_2");
		System.out.println(qqq);
		String zzz=redisCache.get("aaa");
		System.out.println(zzz);
	}
	
}
