package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Products {
    private String input_query;
    private String output_query;
    private String queryPhase;
    private Total totals;
    private String config;
    private Result[] results;
    private Sugestion[] suggestions;

}
