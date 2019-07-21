package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Total {
    private Integer all;
    @JsonProperty("new")
    private Integer news;
    private Integer offer;
}
