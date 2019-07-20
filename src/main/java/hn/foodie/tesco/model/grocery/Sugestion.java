package hn.foodie.tesco.model.grocery;

import lombok.Data;

@Data
public class Sugestion {
    private String text;
    private Double score;
    private Integer freq;
}
