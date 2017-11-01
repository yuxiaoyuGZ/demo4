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

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		 //获取URL的路径和参数  
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse rps = (HttpServletResponse) arg1;
        String username=(String) req.getSession().getAttribute("name");
        String path=req.getServletPath();  
        if(username!=null||path.equals("/hello")||path.equals("/login.html")){
        	arg2.doFilter(arg0, arg1);
        }else{
        	rps.sendRedirect(req.getContextPath()+"/login.html");
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
