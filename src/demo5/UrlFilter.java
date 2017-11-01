package demo5;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UrlFilter implements Filter{

	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		 //获取URL的路径和参数  
        HttpServletRequest req = (HttpServletRequest) request;  
        HttpServletResponse resp = (HttpServletResponse) response;  
        String path=req.getServletPath();  
        String param=req.getQueryString();  
        if(path!=null&&param!=null){  
            path=path+"?"+param;//全请求路径  
        }  
        System.out.println("Path:"+path);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}



}
