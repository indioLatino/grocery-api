package hn.foodie.shopping.controller;

import hn.foodie.shopping.model.requests.IngredientsRequest;
import hn.foodie.tesco.service.TescoServiceImpl;
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
	public ResponseEntity getShoppingListByItemId(@PathVariable(name = "itemId") String itemId) {
		return shoppingBasketServiceImpl.getShoppingListByItemId(itemId);
	}
}
