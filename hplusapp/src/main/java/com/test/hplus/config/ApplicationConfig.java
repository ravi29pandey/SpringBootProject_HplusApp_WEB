package com.test.hplus.config;

import com.test.hplus.convertors.StringToEnumConvertor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = "com.test.hplus")
public class ApplicationConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("css/**", "images/**")
                .addResourceLocations("classpath:/static/css/", "classpath:/static/images/");
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    protected void addFormatters(FormatterRegistry registry){
        registry.addConverter(new StringToEnumConvertor());

    }

/*this method helps for Async support (non-blocking i/o)*/
@Override
protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    configurer.setDefaultTimeout(5000);//Timeout in 5sec do this only if needed
    configurer.setTaskExecutor(mvcTaskExecutor());
}
/*this task executor allocate threads to serve with max size and many others*/
@Bean
public AsyncTaskExecutor mvcTaskExecutor(){
    ThreadPoolTaskExecutor threadPoolTaskExecutor=new ThreadPoolTaskExecutor();
    threadPoolTaskExecutor.setThreadNamePrefix("hplussapp-thread-");
    return threadPoolTaskExecutor;
/*this prefix allocate diff threads with name  hplussapp-thread-1 hplussapp-thread-2 so on */
/*ThreadPoolTaskExecutor helps to threadpool , configure maxSize */
}

    }




