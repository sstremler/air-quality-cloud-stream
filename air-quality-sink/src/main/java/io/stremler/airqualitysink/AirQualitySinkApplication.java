package io.stremler.airqualitysink;

import io.stremler.airqualitysink.model.Station;
import io.stremler.airqualitysink.repository.StationRepository;
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
	private StationRepository stationRepository;

	@Autowired
	private Batcher batcher;

	public static void main(String[] args) {
		SpringApplication.run(AirQualitySinkApplication.class, args);
	}

	@Bean
	public Consumer<Flux<Station>> store(){
		return flux -> flux.subscribe(batcher::next);
	}

	@PostConstruct
	public void subscribeListener() {
		batcher.listen().subscribe(stationRepository::saveAll);
	}

}
