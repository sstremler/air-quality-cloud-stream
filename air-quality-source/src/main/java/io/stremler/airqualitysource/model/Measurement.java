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
public class Measurement {
    private Double no2;
    private Double o3;
    private Double p;
    private Double pm10;
    private Double pm25;
    private Double so2;
    private Double t;
    private Double w;
    private Double wg;

    @JsonProperty("no2")
    private void unpackNestedNo2(java.util.Map<String, Double> m) {
        this.no2 = m.get("v");
    }

    @JsonProperty("o3")
    private void unpackNestedO3(java.util.Map<String, Double> m) {
        this.o3 = m.get("v");
    }

    @JsonProperty("p")
    private void unpackNestedP(java.util.Map<String, Double> m) {
        this.p = m.get("v");
    }

    @JsonProperty("pm10")
    private void unpackNestedPm10(java.util.Map<String, Double> m) {
        this.pm10 = m.get("v");
    }

    @JsonProperty("pm25")
    private void unpackNestedPm25(java.util.Map<String, Double> m) {
        this.pm25 = m.get("v");
    }

    @JsonProperty("so2")
    private void unpackNestedSo2(java.util.Map<String, Double> m) {
        this.so2 = m.get("v");
    }

    @JsonProperty("t")
    private void unpackNestedT(java.util.Map<String, Double> m) {
        this.t = m.get("v");
    }

    @JsonProperty("w")
    private void unpackNestedW(java.util.Map<String, Double> m) {
        this.w = m.get("v");
    }

    @JsonProperty("wg")
    private void unpackNestedWg(java.util.Map<String, Double> m) {
        this.wg = m.get("v");
    }
}
