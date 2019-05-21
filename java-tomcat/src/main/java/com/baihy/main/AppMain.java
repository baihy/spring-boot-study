package com.baihy.main;

import com.baihy.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

/**
 * @projectName: springboot
 * @packageName: com.baihy.main
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 17:31
 */
public class AppMain {

    private static final String CONTEXT_PATH = "/abc";
    private static final String SERVLET_NAME = "helloServlet";


    public static void main(String[] args) {
        try {
            startTomcat9();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
    
    public static void startTomcat9() throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8888);
        Context context = tomcat.addContext(CONTEXT_PATH, new File(".").getAbsolutePath());
        Tomcat.addServlet(context, SERVLET_NAME, new HelloServlet());
        context.addServletMappingDecoded("/hello", SERVLET_NAME);
        tomcat.start();
        tomcat.getServer().await();
    }
    
    
    public static void startTomcat8() throws LifecycleException {
        //创建一个tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        // 设置tomcat的端口号
        tomcatServer.setPort(8888);
        // 设置tomcat的自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建一个tomcat运行的上下文
        StandardContext context = new StandardContext();
        // 设置tomcat项目的访问地址。
        context.setPath(CONTEXT_PATH);
        // 监听上下文
        context.addLifecycleListener(new Tomcat.FixContextListener());
        // 给tomcat服务器，添加上下中context
        tomcatServer.getHost().addChild(context);
        //把Servlet程序，添加到tomcat服务器中。
        tomcatServer.addServlet(CONTEXT_PATH, SERVLET_NAME, new HelloServlet());
        // 注意：这里向上下文中添加访问路径
        context.addServletMappingDecoded("/hello", SERVLET_NAME);
        // 上面两行就相当于是在web.xml文件中，添加Servlet配置
        tomcatServer.start();  // 启动tomcat服务器
        tomcatServer.getServer().await(); // 异步进行接受请求
    }

}
