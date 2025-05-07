package com.kanishk;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {

        System.out.println("Hello World");

        Connector connector = new Connector();
        connector.setPort(8080);

        Tomcat tomcat = new Tomcat();

//        Context context = tomcat.addContext("", null);
//        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
//        context.addServletMappingDecoded("/hello", "HelloServlet");
//        tomcat.getService().addConnector(connector);
        
        tomcat.start();
        tomcat.getServer().await();

    }
}
