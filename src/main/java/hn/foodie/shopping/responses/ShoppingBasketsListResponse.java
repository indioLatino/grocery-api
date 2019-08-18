package hn.foodie.shopping.responses;

import hn.foodie.shopping.model.collection.ShoppingBasket;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ShoppingBasketsListResponse {
    private List<ShoppingBasket> shoppingBasketList;
}