package io.stremler.airqualitysource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@SpringBootApplication
public class AirQualitySourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirQualitySourceApplication.class, args);
	}

	@Bean
	public Supplier<Flux<String>> stringSupplier() {
		return () -> Flux.from(emitter -> {
			while (true) {
				try {
					emitter.onNext("Hello from Supplier");
					Thread.sleep(1000);
				} catch (Exception e) {
					// ignore
				}
			}
		});
	}

}
