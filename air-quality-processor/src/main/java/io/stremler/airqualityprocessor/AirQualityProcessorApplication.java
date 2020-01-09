package io.stremler.airqualityprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class AirQualityProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirQualityProcessorApplication.class, args);
	}

	@Bean
	public Function<Flux<String>, Flux<String>> appender() {
		return flux -> flux.map(str -> str.concat(" and from Processor!"));
	}

}
