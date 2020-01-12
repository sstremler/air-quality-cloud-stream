package io.stremler.airqualitysource.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

@Service
public interface UrlBuilderService {
    public Function<UriBuilder, URI> buildStationsUrl();
    public Function<UriBuilder, URI> buildCountryUrl(String country);
}
