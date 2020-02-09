package io.stremler.airqualitysink.repository;

import io.stremler.airqualitysink.model.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
