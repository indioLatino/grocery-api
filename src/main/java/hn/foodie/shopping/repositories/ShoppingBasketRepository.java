package hn.foodie.shopping.repositories;

import ch.qos.logback.core.hook.ShutdownHook;
import hn.foodie.shopping.model.collection.ShoppingBasket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingBasketRepository extends MongoRepository<ShoppingBasket, String> {
	Optional<List<ShoppingBasket>> findByItemId(String itemId);
}
