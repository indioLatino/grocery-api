package hn.foodie.shopping.model;

import lombok.Builder;
import lombok.Data;

/**
 * Created by: Rodolfo Galo on 21/7/2019
 */
@Data
@Builder
public class Product {
    private String ean;
    private String name;
    private Double measurement;
    private String unit;
    private String image;
    private Double price;
}
