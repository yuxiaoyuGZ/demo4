package demo;




import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class demo1 extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException { 
			  
		System.out.println(arg0.getRemoteAddr());    //取得客户端的IP     
		System.out.println(arg0.getRemoteHost());    //取得客户端的主机名     
		System.out.println(arg0.getRemotePort());    //取得客户端的端口     
		    
		System.out.println(arg0.getLocalAddr());    //取得本地IP     
		System.out.println(arg0.getLocalPort());    //取得本地端口
		
		
		
		
		
		System.out.println(arg0.getParameter("name"));
		System.out.println(arg0.getParameter("pasw"));
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse rps=(HttpServletResponse) arg1;
		HttpSession session=req.getSession();
		String username=req.getParameter("name");
		String password=req.getParameter("pasw");
		String JSESSIONID=session.getId();
		
//		arg1.getWriter().write("my name is 2  sessionId��"+JSESSIONID);
//		arg1.getWriter().write("客户端的IP"+arg0.getRemoteAddr());
//		arg1.getWriter().write("取得客户端的端口"+arg0.getRemotePort());
//		arg1.getWriter().write("取得客户端的主机名 "+arg0.getRemoteHost());
//		arg1.getWriter().write("取得本地IP "+arg0.getLocalPort());
//		arg1.getWriter().write("取得本地端口"+arg0.getLocalAddr());
//		arg1.getWriter().write("项目名称"+arg0.getServletContext().getContextPath());
		
		session.setAttribute("name", username);
		session.setAttribute("sessionID", JSESSIONID);
		
		String name = ManagementFactory.getRuntimeMXBean().getName();  
		System.out.println(name);  
		// get pid  
		String pid = name.split("@")[0];  
		System.out.println("Pid is:" + pid);  
		
//		callCMD();
		
		rps.sendRedirect(req.getContextPath()+"/index.jsp");
		
	}
	
	
    private void callCMD(){  
    	try {
			String[] cmds = {"/bin/sh","-c","ps -ef|grep demo4-demo4.04-alogic"};  
			Process pro = Runtime.getRuntime().exec(cmds);  
			pro.waitFor();  
			InputStream in = pro.getInputStream();  
			BufferedReader read = new BufferedReader(new InputStreamReader(in));  
			String line = null;  
			while((line = read.readLine())!=null){  
			    System.out.println(line);  
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
    }  




	

	
	
	
}
