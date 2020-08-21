package com.example.food_shop_spring.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfig  extends WebMvcConfigurerAdapter {
    @Bean
    public UrlBasedViewResolver urlBasedViewResolver(){
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfig = new TilesConfigurer();
        tilesConfig.setDefinitions(new String[]{
                "/WEB-INF/tiles/tiles_user.xml",
                "/WEB-INF/tiles/tiles_product.xml",
                "/WEB-INF/tiles/tiles_blog.xml",
                "/WEB-INF/tiles/tiles_admin.xml",
                "/WEB-INF/tiles/tiles_admin_category.xml",
                "/WEB-INF/tiles/tiles_admin_product.xml",
                "/WEB-INF/tiles/tiles_admin_photo.xml"

        });
        return tilesConfig;
    }

}
