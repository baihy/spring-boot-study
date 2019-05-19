package com.baihy.main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * @projectName: springboot
 * @packageName: com.baihy.main
 * @description:
 * @author: huayang.bai
 * @date: 2019-05-19 20:08
 */
public class SpringMain {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(8080);
        // 为tomcat添加跟路径, 主要是为了加载静态资源
        //String webRoot = SpringMain.class.getClassLoader().getResource("").getPath();
        String webRoot = new File("java-springmvc/src/main/webapp").getAbsolutePath();
        StandardContext context = (StandardContext) tomcatServer.addWebapp("/", webRoot);
        // 禁止重新加载
        context.setReloadable(false);
        // 指定classes文件所在的位置
        WebResourceRoot resources = new StandardRoot(context);
        File classesFile = new File("target/classes");
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", classesFile.getAbsolutePath(), "/"));
        tomcatServer.start();// 启动
        tomcatServer.getServer().await();
    }

}
