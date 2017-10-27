package com.baidu.uuap.conf;

/**
 * 该类采用Java Configuration，来代替web.xml
 * <p>
 * 该类会在Servlet启动时加载（当然也可以采用别的加载方法，比如采用扫描@Configuration注解类的方式等等）。
 */
/*

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //  将RedisHttpSessionConfig加入到WebInitializer#getRootConfigClasses()中，
    //  让Spring容器加载RedisHttpSessionConfig类。
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RedisHttpSessionConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
*/
