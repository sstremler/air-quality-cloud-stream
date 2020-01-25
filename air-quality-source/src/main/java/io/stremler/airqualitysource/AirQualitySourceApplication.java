package io.stremler.airqualitysource;

import io.stremler.airqualitysource.model.Response;
import io.stremler.airqualitysource.model.Station;
import io.stremler.airqualitysource.model.StationMap;
import io.stremler.airqualitysource.service.UrlBuilderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.ResolvableType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Flux;

import java.net.URI;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class AirQualitySourceApplication {

    @Autowired
    private WebClient webClient;

    @Autowired
    private UrlBuilderService urlBuilderService;

    public static void main(String[] args) {
        SpringApplication.run(AirQualitySourceApplication.class, args);
    }

    @PollableBean
    public Supplier<Flux<Station>> stationSupplier() {
        log.info("Polling...");
        return () -> route(urlBuilderService.buildStationsUrl(), StationMap.class).map(response -> response.getData())
                .log()
                .flatMap(Flux::fromIterable).limitRequest(1)
                .flatMap(station -> route(urlBuilderService.buildCountryUrl(station.getUid().toString()), Station.class))
                .map(response -> response.getData())
                .flatMap(Flux::fromIterable);
    }

    public <T> Flux<Response<T>> route(Function<UriBuilder, URI> uriBuilderFunction, Class<T> responseType) {
        return webClient.get().uri(uriBuilderFunction).retrieve()
                .bodyToFlux(ParameterizedTypeReference.forType(ResolvableType.forClassWithGenerics(Response.class, responseType).getType()));
    }

}
