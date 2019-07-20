package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Total {
    private Integer all;
    @JsonProperty("new")
    private Integer news;
    private Integer offer;
}
