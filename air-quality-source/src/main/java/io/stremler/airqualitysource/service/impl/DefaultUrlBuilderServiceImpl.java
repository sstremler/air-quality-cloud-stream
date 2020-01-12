package io.stremler.airqualitysource.service.impl;

import io.stremler.airqualitysource.service.UrlBuilderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.Map;
import java.util.function.Function;

public class DefaultUrlBuilderServiceImpl implements UrlBuilderService {
    @Value("${air-quality.api.token}")
    private String token;

    @Value("#{${air-quality.api.endpoints}}")
    private Map<String, String> endpoints;

    @Value("#{${air-quality.api.parameter.countries.latlng}}")
    private Map<String, String> countries;

    public Function<UriBuilder, URI> buildStationsUrl() {
        return uriBuilder -> uriBuilder
                .path(this.endpoints.get("stations"))
                .queryParam("token", this.token)
                .queryParam("latlng", this.countries.get("germany"))
                .build();
    }

    public Function<UriBuilder, URI> buildCountryUrl(String country) {
        return uriBuilder -> uriBuilder
                .path(this.endpoints.get("city"))
                .queryParam("token", this.token)
                .build(country);
    }
}
