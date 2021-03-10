package com.aresix.eudemoniabackend.interceptors;

import com.aresix.eudemoniabackend.common.Const;
import com.aresix.eudemoniabackend.common.ResponseCode;
import com.aresix.eudemoniabackend.pojo.User;
import com.aresix.eudemoniabackend.utils.ServerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

@Component
public class PortalLoginCheckInterceptor implements HandlerInterceptor {
    /**
     * 请求达到controller之前
     *
     * @param request
     * @param response
     * @param handler
     * @return true:可以通过拦截器 false:拦截请求
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("------preHandle------");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) return true;

        try {
            // 用户未登录，重写Response 使用输出流
            response.reset();
            response.addHeader("Content-Type","application/json;charset=utf-8");
            PrintWriter printWriter = response.getWriter();
            ServerResponse serverResponse =
                    ServerResponse.createServerResponseByFailure
                            (ResponseCode.NEED_LOGIN.getCode(), ResponseCode.NEED_LOGIN.getMsg());
            ObjectMapper objectMapper = new ObjectMapper();
            String info = objectMapper.writeValueAsString(serverResponse);
            printWriter.write(info);
            printWriter.flush();
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // 请求处理完成后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("------postHandle------");
    }

    // 客户端接收到响应后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("------afterCompletion------");
    }
}
