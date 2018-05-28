package com.microsilver.mrcard.basicservice.core.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;

/**
 * 
 * @Name com.microsilver.mrcard.serviceplatform.core.filter.TokenFilter
 * @Description api对APP请求的token进行校验
 * 
 * @Author bruce
 * @Version 2017年6月28
 * @Copyright Micro Silver
 *
 */

import org.springframework.web.filter.OncePerRequestFilter;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.utils.Utils;


@Order(1)
@WebFilter(filterName = "tokenFilter", urlPatterns = "/api/*")
public class TokenFilter extends OncePerRequestFilter {
	/**
	 * 对token进行校验
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		boolean doFilter = true;
		if(!Consts.CHECK_TOKEN){
			filterChain.doFilter(request, response);
			return;
		}
		String[] clientIPs =  Consts.EFFECTIVE_IP.split(",");
		String clientIp = com.microsilver.mrcard.common.Utils.getIpAddress(request);
		for (String s : clientIPs) {
			if (s.equals(clientIp)) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if(!doFilter){
			filterChain.doFilter(request, response);
			return;
		}
		// 不过滤的uri
		String[] notFilter = new String[] { "Login","register","getSysTime","getActivatedArea","quickRegister","baiduTranslate","getTradingArea" };
		// 请求的uri
		String uri = request.getRequestURI();
		// 是否过滤
		

		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		if (doFilter) {
			boolean isEffective = false;
			// 执行过滤
			// 从session中获取登录者实体
			String token = request.getHeader("token");
			String clientType = request.getHeader("clienttype");
			String ua = request.getHeader("ua");
			String appType=request.getHeader("apptype");
			if (token != null && !token.equals("")) {
				isEffective = Utils.checkToken(appType,token,clientType+":"+appType+":"+ua);
			}
			if (!isEffective) {
				// token校验失败
				String rsJson = "{\"state\": 100,\"message\": \"非法请求！\",\"data\": []}";
				response.setContentType("text/html; charset=UTF-8"); 
				PrintWriter out = response.getWriter();
				out.print(rsJson);
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			// 如果不执行过滤，则继续
			filterChain.doFilter(request, response);
		}
	}
}
