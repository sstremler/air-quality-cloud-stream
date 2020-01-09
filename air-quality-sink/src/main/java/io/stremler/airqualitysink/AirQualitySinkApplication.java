package io.stremler.airqualitysink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Consumer;

@SpringBootApplication
public class AirQualitySinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirQualitySinkApplication.class, args);
	}

	@Bean
	public Consumer<Flux<String>> stringConsumer(){
		return flux -> flux.subscribe(System.out::println);
	}

}
