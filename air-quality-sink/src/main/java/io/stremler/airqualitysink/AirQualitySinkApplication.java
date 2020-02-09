package io.stremler.airqualitysink;

import io.stremler.airqualitysink.model.Measurement;
import io.stremler.airqualitysink.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.function.Consumer;

@SpringBootApplication
public class AirQualitySinkApplication {

	@Autowired
	private MeasurementRepository measurementRepository;

	@Autowired
	private Batcher batcher;

	public static void main(String[] args) {
		SpringApplication.run(AirQualitySinkApplication.class, args);
	}

	@Bean
	public Consumer<Flux<Measurement>> store(){
		return flux -> flux.subscribe(batcher::next);
	}

	@PostConstruct
	public void subscribeListener() {
		batcher.listen().subscribe(measurementRepository::saveAll);
	}

}
