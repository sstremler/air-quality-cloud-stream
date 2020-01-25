package io.stremler.airqualitysink.repository;

import io.stremler.airqualitysink.model.Station;
import org.springframework.data.repository.CrudRepository;

public interface StationRepository extends CrudRepository<Station, Long> {
}
