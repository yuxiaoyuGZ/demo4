package demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class demo11 implements ServletContextListener{


	    /**
	     * 监听web容器关闭
	     */
	    @Override
	    public void contextDestroyed(ServletContextEvent sce) {
	        System.out.println("web容器关闭");

	    }

	    /**
	     * 监听web容器启动
	     */
	    @Override
	    public void contextInitialized(ServletContextEvent sce) {
	        System.out.println("web容器启动");
	        

	    }

	
}
