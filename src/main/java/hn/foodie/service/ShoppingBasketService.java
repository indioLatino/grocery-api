package hn.foodie.service;

import hn.foodie.tesco.model.grocery.GroceryResponse;
import org.springframework.http.ResponseEntity;

public interface ShoppingBasketService {
    public ResponseEntity getShoppingBasket();
}
