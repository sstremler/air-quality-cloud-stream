package io.stremler.airqualitysource.config;

import io.stremler.airqualitysource.service.UrlBuilderService;
import io.stremler.airqualitysource.service.impl.DefaultUrlBuilderServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class BeanConfig {

    @Value("${air-quality.api.base-url}")
    private String baseUrl;

    @Bean
    public UrlBuilderService urlBuilderService(){
        return new DefaultUrlBuilderServiceImpl();
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl(this.baseUrl).clientConnector(new ReactorClientHttpConnector(
                HttpClient.create().wiretap(true)
        )).build();
    }

}
