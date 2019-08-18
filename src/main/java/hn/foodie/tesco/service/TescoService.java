package hn.foodie.tesco.service;

import hn.foodie.shopping.exceptions.ShoppingBasketNotFoundException;
import hn.foodie.shopping.model.requests.IngredientsRequest;
import hn.foodie.shopping.responses.ShoppingBasketsListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface TescoService {
    /**
     * Method that retrieve the products list matching a query term
     * @param queryTerm: String used to filter the products list
     * @return An object containing the products list
     */
    ResponseEntity getGroceryOptions(String queryTerm);

    void createShoppingList(IngredientsRequest request);
    ShoppingBasketsListResponse getShoppingListByItemId(String itemId) throws ShoppingBasketNotFoundException;

}
