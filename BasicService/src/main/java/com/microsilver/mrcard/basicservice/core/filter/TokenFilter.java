package com.microsilver.mrcard.basicservice.core.filter;

import com.microsilver.mrcard.basicservice.common.Consts;
import com.microsilver.mrcard.basicservice.model.TokenType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "tokenFilter", urlPatterns = "/api/*")
public class TokenFilter extends OncePerRequestFilter {
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	@Resource
	private RedisTemplate redisTemplate;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {
		boolean doFilter = true;
		if(!Consts.CHECK_TOKEN){
			filterChain.doFilter(request, response);
			return;
		}
		String userId = request.getHeader("userId");
		String token = request.getHeader("token");
		//appType-1代表用户端,2代表骑手端
		String appType = request.getHeader("appType");


		// 不过滤的uri
		String[] notFilter = new String[] { "Login","Register",
				"quickRegister","uploadPicture","getAllArea","getAppVersion","getOpenArea" ,"getSysTime","sendAndSaveCheckCode","getDeliversPosition"};
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
		if(doFilter){
			//boolean isEffective = false;
			Boolean flag =false;
			if(token!=null&&!token.equals("")&&userId!=null&&!userId.equals("")){
				//String idToken = stringRedisTemplate.opsForValue().get(userId+appType+"");
				TokenType tokenType = (TokenType) redisTemplate.opsForValue().get(userId + appType + "");
				String idToken = tokenType.getToken();
				System.out.println(idToken);
				if(idToken!=null){
					if(idToken.equals(token)){
						flag = true;
					}
				}
			}
			if(!flag){
				// token校验失败
				String rsJson = "{\"state\": 100,\"message\": \"非法请求！\",\"data\": []}";
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print(rsJson);
			}else{
				filterChain.doFilter(request, response);
			}
		} else{
			filterChain.doFilter(request, response);
		}

	}


}
