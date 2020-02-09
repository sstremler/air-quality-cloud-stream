package io.stremler.airqualitysource.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Measurement {
    @JsonIgnore
    private Integer aqi;
    private Integer idx;
    @JsonIgnore
    private City city;
    private Double no2;
    private Double o3;
    private Double p;
    private Double pm10;
    private Double pm25;
    private Double so2;
    private Double t;
    private Double w;
    private Double wg;
    private Date time;

    @JsonProperty("time")
    private void unpackNestedTime(Map<String, String> m) {
        try {
            this.time = new Date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").parse(m.get("s").concat(m.get("tz"))).getTime());
            log.info(m.get("s"));
        } catch (ParseException e) {
            log.info(e.getMessage());
        }
    }

    @JsonProperty("iaqi")
    private void unpackNestedaAiqi(Map<String, Map<String, Double>> m) {
        this.no2 = getDoubleOrNull(m.get("no2"));
        this.o3 = getDoubleOrNull(m.get("o3"));
        this.p = getDoubleOrNull(m.get("p"));
        this.pm10 = getDoubleOrNull(m.get("pm10"));
        this.pm25 = getDoubleOrNull(m.get("pm25"));
        this.so2 = getDoubleOrNull(m.get("so2"));
        this.t = getDoubleOrNull(m.get("t"));
        this.w = getDoubleOrNull(m.get("w"));
        this.wg = getDoubleOrNull(m.get("wg"));
    }

    private Double getDoubleOrNull(Map<String, Double> map) {
        if (map != null) {
            return map.get("v");
        }

        return null;
    }
}
