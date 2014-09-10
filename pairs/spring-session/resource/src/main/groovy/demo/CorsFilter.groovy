package demo

import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.springframework.stereotype.Component

@Component
public class CorsFilter implements Filter {

	void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res
		HttpServletRequest request = (HttpServletRequest) req
		response.setHeader("Access-Control-Allow-Origin", "*")
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE")
		response.setHeader("Access-Control-Max-Age", "3600")
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-token")
		if (request.getMethod()!='OPTIONS') {
			chain.doFilter(req, res)
		}
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}
