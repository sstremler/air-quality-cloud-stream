package io.stremler.airqualitysource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Station {
    private Double lat;
    private Double lon;
    private Integer uid;
    private String aqi;
    private String name;

    @JsonProperty("station")
    private void unpackNested(java.util.Map<String, String> station) {
        this.name = station.get("name");
    }
}
