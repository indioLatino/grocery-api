package hn.foodie.rest.controller;

import hn.foodie.rest.model.ShoppingBasket;
import hn.foodie.service.ShoppingBasketServiceImpl;
import hn.foodie.tesco.model.grocery.GroceryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingBasketController {
    @RequestMapping(value = {"/shoppingBasket"}, method = RequestMethod.GET)
    public ResponseEntity getShoppingBasket() {
        return new ShoppingBasketServiceImpl().getShoppingBasket();
    }
}
