package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties
public class Products {
    private String input_query;
    private String output_query;
    private String queryPhase;
    private Total totals;
    private String config;
    private List<Result> results;
    private Sugestion[] suggestions;

}
