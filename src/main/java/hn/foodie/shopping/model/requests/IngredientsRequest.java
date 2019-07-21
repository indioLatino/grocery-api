package hn.foodie.shopping.model.requests;

import hn.foodie.shopping.model.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class IngredientsRequest {
    private String itemId;
    private List<Ingredient> ingredientList;
}
