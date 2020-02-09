package io.stremler.airqualitysink.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idx;
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
}
