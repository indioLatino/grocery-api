package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Envelop1 {
    private Products products;
}
