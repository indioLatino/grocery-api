package hn.foodie.shopping.model.collection;

import hn.foodie.shopping.model.Product;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by: Rodolfo Galo on 21/7/2019
 * This class represents a Shopping basket. There will be as many shopping
 * list per item as retailers are integrated in the application.
 *
 * @productList: The list of products
 * @retailId: the retail identifier
 * @itemId: The identifier of the recepee/diet associated
 */
@NoArgsConstructor
@Data
@Document(collection = "shoppingBasket")
public class ShoppingBasket {
    private List<Product> productList;
    private String retailId;
    private String itemId;
}
