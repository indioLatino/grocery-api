package hn.foodie.shopping.controller;

import hn.foodie.shopping.exceptions.ShoppingBasketException;
import hn.foodie.shopping.exceptions.ShoppingBasketNotFoundException;
import hn.foodie.shopping.model.collection.ShoppingBasket;
import hn.foodie.shopping.model.requests.IngredientsRequest;
import hn.foodie.shopping.responses.ShoppingBasketsListResponse;
import hn.foodie.tesco.service.TescoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by: Rodolfo Galo on 20/7/2019
 */
@RestController
public class ShoppingBasketController {
    private TescoServiceImpl shoppingBasketServiceImpl;

    public ShoppingBasketController(TescoServiceImpl shoppingBasketServiceImpl) {
        this.shoppingBasketServiceImpl = shoppingBasketServiceImpl;
    }

    @RequestMapping(value = {"/shoppingBasket"}, method = RequestMethod.GET)
    public ResponseEntity getShoppingBasket(@RequestParam(name = "name") String name) {
        return shoppingBasketServiceImpl.getGroceryOptions(name);
    }

    @RequestMapping(value = {"/createShoppingList"}, method = RequestMethod.POST)
    public void createShoppingList(@RequestBody @Valid IngredientsRequest request) {
        shoppingBasketServiceImpl.createShoppingList(request);
    }


    @RequestMapping(value = {"/getShoppingListByItemId/{itemId}"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ShoppingBasketsListResponse> getShoppingBasketsListByItemId(
            @PathVariable(name = "itemId") String itemId
    ) throws ShoppingBasketNotFoundException {
        System.out.println("Se ejecuta");
            return new ResponseEntity(shoppingBasketServiceImpl.getShoppingListByItemId(itemId), HttpStatus.OK);
    }


    @ExceptionHandler({ShoppingBasketNotFoundException.class, Exception.class})
    private ResponseEntity<String> shoppingExceptions(ShoppingBasketException e) {
        String exceptionName = e.getClass().getSimpleName();
        switch (exceptionName) {
            case "ShoppingBasketNotFoundException":
                return new ResponseEntity<>(e.getMessage(), e.getStatus());

            default:
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
