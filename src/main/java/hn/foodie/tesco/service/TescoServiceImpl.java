package hn.foodie.tesco.service;

import hn.foodie.shopping.exceptions.ShoppingBasketNotFoundException;
import hn.foodie.shopping.model.requests.IngredientsRequest;
import hn.foodie.shopping.model.Ingredient;
import hn.foodie.shopping.model.Product;
import hn.foodie.shopping.model.collection.ShoppingBasket;
import hn.foodie.shopping.model.enums.RetailsEnum;
import hn.foodie.shopping.repositories.ShoppingBasketRepository;
import hn.foodie.shopping.responses.ShoppingBasketsListResponse;
import hn.foodie.tesco.model.grocery.GroceryResponse;
import hn.foodie.tesco.model.grocery.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * Created by: Rodolfo Galo on 20/7/2019
 */

@Service
public class TescoServiceImpl implements TescoService {
    @Value("${tesco.base-url}")
    private String tescoBaseUrl;
    @Value("${tesco.grocery-path}")
    private String groceryPath;
    @Value("${tesco.protocol}")
    private String tescoProtocol;
    @Value("${tesco.secret-key}")
    private String tescoSecretKey;
    @Autowired
    private ShoppingBasketRepository shoppingBasketRepository;

    @Override
    public ResponseEntity getGroceryOptions(String queryTerm) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Ocp-Apim-Subscription-Key", tescoSecretKey);
        HttpEntity<String> entity = new HttpEntity<>("{}", headers);
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(tescoProtocol).host(tescoBaseUrl)
                .path(groceryPath).queryParam("query", queryTerm)
                .queryParam("offset", "0")
                .queryParam("limit", "10").buildAndExpand();
        System.out.println(uriComponents.toString());
        System.out.println("");
        ResponseEntity<GroceryResponse> groceryResponse = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity, GroceryResponse.class);
        System.out.println(groceryResponse.toString());
        System.out.println("");
        return groceryResponse;
    }

    @Override
    public ShoppingBasketsListResponse getShoppingListByItemId(String itemId) throws ShoppingBasketNotFoundException {
        final Optional<List<ShoppingBasket>> shoppingBasketsList = shoppingBasketRepository.findByItemId(itemId);
        if (shoppingBasketsList.get().size() == 0) {
            throw new ShoppingBasketNotFoundException();
        }
        // todo: instead of hardcoding the price it should be calculated calling the supermarket api
        return new ShoppingBasketsListResponse(shoppingBasketsList.get());
    }

    /*@Async
    public CompletableFuture<Double> updateProductPrice(String gtin){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Ocp-Apim-Subscription-Key", tescoSecretKey);
        HttpEntity<String> entity = new HttpEntity<>("{}", headers);
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(tescoProtocol).host(tescoBaseUrl)
                .path(groceryPath).queryParam("gtin", gtin).buildAndExpand();
        ResponseEntity<Product> product = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity, Product.class);
    }*/

    @Override
    public void createShoppingList(IngredientsRequest request) {
        String itemId = request.getItemId();
        List<Ingredient> ingredientList = request.getIngredientList();
        List<Result> resultList;
        Result cheapestResult;
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        List<Product> productsList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            Product product;
            GroceryResponse gr = (GroceryResponse) getGroceryOptions(ingredient.getProductName()).getBody();
            resultList = gr.getUk().getGhs().getProducts().getResults();
            cheapestResult = findCheapest(resultList);
            if (cheapestResult != null) {
                product = Product.builder()
                        .ean(String.valueOf(cheapestResult.getId()))
                        .image(cheapestResult.getImage())
                        .measurement(new Double(cheapestResult.getContentsQuantity()))
                        .price(cheapestResult.getPrice())
                        .unit(cheapestResult.getContentsMeasureType())
                        .name(cheapestResult.getName())
                        .build();
                System.out.println("Product name: " + product.getName() + " Price: " + product.getPrice());
                System.out.println("");
                System.out.println("");
                productsList.add(product);
            }
        }
        shoppingBasket.setProductList(productsList);
        shoppingBasket.setItemId(itemId);
        shoppingBasket.setRetailId(RetailsEnum.TESCO.code);
        shoppingBasketRepository.insert(shoppingBasket);
    }

    private Result findCheapest(List<Result> optionsList) {
        Result min = null;
        if (optionsList.size() > 0) {
            min = optionsList.get(0);
            for (Result i : optionsList) {
                min = min.getPrice() < i.getPrice() ? min : i;
            }
            return min;
        }
        return min;
    }
}
