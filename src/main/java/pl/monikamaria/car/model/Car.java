package pl.monikamaria.car.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private Long id;
    private String mark;
    private String model;
    private Color color;

}
