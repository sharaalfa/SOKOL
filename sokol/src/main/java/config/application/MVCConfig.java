package config.application;

//import config.TilesDefinitionsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

//@Configuration
//@EnableWebMvc
//@ComponentScan({"config", "controller"})
//public class MVCConfig extends WebMvcConfigurerAdapter {
//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
//
//    /**
//     * Configure ViewResolvers to deliver preferred views.
//     */
////    @Override
////    public void configureViewResolvers(ViewResolverRegistry registry) {
////        TilesViewResolver viewResolver = new TilesViewResolver();
////        registry.viewResolver(viewResolver);
////    }
//
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setViewClass(JstlView.class);
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        viewResolver.setContentType("text/html; charset-utf-8");
//        viewResolver.setOrder(1);
//        return viewResolver;
//    }
//
//    @Bean
//    public TilesViewResolver getTilesViewResolver() {
//        TilesViewResolver tilesViewResolver = new TilesViewResolver();
//        tilesViewResolver.setViewClass(TilesView.class);
//        tilesViewResolver.setOrder(0);
//        return tilesViewResolver;
//    }
//
//    @Bean
//    public TilesConfigurer getTilesConfigurer() {
//        TilesConfigurer tilesConfigurer = new TilesConfigurer();
//        tilesConfigurer.setCheckRefresh(true);
//        tilesConfigurer.setDefinitionsFactoryClass(TilesDefinitionsConfig.class);
//        // Add apache tiles definitions
//        TilesDefinitionsConfig.addDefinitions();
//        return tilesConfigurer;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/views/css/");
//        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/WEB-INF/views/css/");
//    }
//}
