package io.stremler.airqualitysource.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class Station {
    private Integer aqi;
    private Integer idx;
    private City city;
    @JsonProperty("iaqi")
    private Measurement measurement;
    private Date time;

    @JsonProperty("time")
    private void unpackNestedTime(java.util.Map<String, String> m) {
        try {
            this.time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssX").parse(m.get("s").concat(m.get("tz")));
            log.info(m.get("s"));
        } catch (ParseException e) {
            log.info(e.getMessage());
        }
    }
}
