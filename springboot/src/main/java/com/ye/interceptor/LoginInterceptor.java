package com.ye.interceptor;

import com.ye.common.result.HttpStatusEnum;
import com.ye.common.result.Result;
import com.ye.common.util.StringUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    /*
    * token 在请求的 Authorization 获取
    */
    protected static final ThreadLocal<String> TOKEN = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (StringUtil.isEmpty(token)) {
            String result = Result.fail(HttpStatusEnum.AUTH_FAIL, "请登录").toString();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
            response.getWriter().flush();
            return false;
        }

        if (!Security.validate(token)) {
            String result = Result.fail(HttpStatusEnum.AUTH_FAIL, "请登录").toString();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(result);
            response.getWriter().flush();
            return false;
        }
        // 验证成功
        TOKEN.set(token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        TOKEN.remove();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

}
