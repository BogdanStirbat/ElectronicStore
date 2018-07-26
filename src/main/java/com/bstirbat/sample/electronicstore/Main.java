package com.bstirbat.sample.electronicstore;

import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;

public class Main {

    private static final String DEFAULT_TOMCAT_PORT = "8080";

    public static void main(String[] args) throws Exception {
        String appBase = ".";
        String webPort = System.getenv("PORT");
        if (webPort == null || webPort.isEmpty()) {
            webPort = DEFAULT_TOMCAT_PORT;
        }

        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(createTempDir(webPort));
        tomcat.setPort(Integer.parseInt(webPort));
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp("", appBase);
        tomcat.start();
        tomcat.getServer().await();
    }

    // based on AbstractEmbeddedServletContainerFactory.java
    private static String createTempDir(String port) {
        try {
            File tempDir = File.createTempFile("tomcat.", "." + port);
            tempDir.delete();
            tempDir.mkdir();
            tempDir.deleteOnExit();
            return tempDir.getAbsolutePath();
        } catch (IOException e) {
            throw new RuntimeException("Unable to create tempDir.", e);
        }
    }
}