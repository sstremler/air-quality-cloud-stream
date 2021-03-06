package io.stremler.airqualitysink;

import io.stremler.airqualitysink.model.Measurement;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.UnicastProcessor;

import java.time.Duration;
import java.util.List;

@Component
public class Batcher {

    private static final UnicastProcessor processor = UnicastProcessor.create();

    public void next(Measurement element) {
        processor.sink().next(element);
    }

    public Flux<List<Measurement>> listen() {
        return processor.bufferTimeout(10, Duration.ofSeconds(10));
    }

}
