package com.example.milkorder_backend.jwt;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// OncePerRequestFilter 是请求过滤器，自定义的过滤器都要继承自它
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            if (isProtectedUrl(request)){
                // Options请求可以不用校验，其他诸如Get、Post等请求都要校验
                if (!request.getMethod().equals("OPTIONS")){
                    request = JwtUtil.validateTokenAndAddUserIdToHeader(request) ; // 验证token
                }
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            return;
        }
        filterChain.doFilter(request, response);  // 放行
    }

    private boolean isProtectedUrl(HttpServletRequest request) {
        List<String> protectedPaths = new ArrayList<>();
        protectedPaths.add("/user/info") ;  // 登录后获取用户信息
        protectedPaths.add("/drink/add");  // 新增饮品
        protectedPaths.add("/drink/order");  // 下单
        protectedPaths.add("/order/info");  // 订单信息
        // ...

        boolean bFind = false;
        for (String passedPath : protectedPaths) {
            bFind = pathMatcher.match(passedPath, request.getServletPath());
            if (bFind) {
                break;
            }
        }
        return bFind;
    }
}
