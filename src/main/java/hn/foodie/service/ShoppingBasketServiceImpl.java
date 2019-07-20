package hn.foodie.service;

import hn.foodie.tesco.model.grocery.GroceryResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ShoppingBasketServiceImpl implements ShoppingBasketService {
    @Override
    public ResponseEntity getShoppingBasket() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Ocp-Apim-Subscription-Key", "9d1e5bb6b1f24b499ee3fc18390249ad");
        HttpEntity<String> entity = new HttpEntity<>("body", headers);
        ResponseEntity<GroceryResponse> groceryResponse = restTemplate.exchange("https://dev.tescolabs.com/grocery/products/?query=chocolat&offset=0&limit=5", HttpMethod.GET, entity, GroceryResponse.class);
        System.out.println(groceryResponse.toString());
        return groceryResponse;
    }
}
