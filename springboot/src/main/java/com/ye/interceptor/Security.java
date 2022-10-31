package com.ye.interceptor;

import com.ye.common.util.MD5Util;
import com.ye.common.util.StringUtil;
import com.ye.exception.FailException;
import com.ye.model.dto.LoginDto;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 登录认证
 */
public class Security {

    private static final String USER_TOKEN_KEY = "USER:TOKEN:";

    @Resource
    private RedisTemplate<String, Object> redis;

    private static RedisTemplate<String, Object> redisTemplate;

    // 初始化 static 的 redisTemplate
    // 构建顺序 constructor -> @Autowired -> @PostConstruct
    @PostConstruct
    public void init(){
        redisTemplate = redis;
    }

    /**
     * 验证 token
     * @param token 登录 token
     * @return true-验证通过 false-验证失败
     */
    public static Boolean validate(String token){
        String redisKey = USER_TOKEN_KEY + token;
        return redisTemplate.hasKey(redisKey);
    }

    /**
     * 登录信息缓存
     * redis 存储格式：
     *     key："USER:TOKEN:" + token
     *     value: LoginDto
     * @param loginDto 登录信息
     * @return 登录 token
     */
    public static String loginToken(LoginDto loginDto){
        String token = MD5Util.encode(loginDto.getAccount() + System.currentTimeMillis()).toUpperCase();
        String redisKey = USER_TOKEN_KEY + token;
        // 登录信息加入 redis
        redisTemplate.opsForValue().set(redisKey, loginDto);
        return token;
    }

    /** 登出 */
    public static void logout(){
        redisTemplate.delete(redisKey());
    }

    /**
     * 获取媒体登录缓存信息
     * @return 媒体登录缓存信息
     */
    public static LoginDto info() {
        Object obj = redisTemplate.opsForValue().get(redisKey());
        if (obj == null) {
            throw new FailException("请登录");
        }
        return (LoginDto) obj;
    }

    private static String redisKey() {
        String token = LoginInterceptor.TOKEN.get();
        if (StringUtil.isEmpty(token)) {
            throw new FailException("请登录");
        }
        return USER_TOKEN_KEY + token;
    }

}
