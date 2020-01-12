package io.stremler.airqualitysource.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private String name;
    private String url;
    private Double[] geo = new Double[2];
}
