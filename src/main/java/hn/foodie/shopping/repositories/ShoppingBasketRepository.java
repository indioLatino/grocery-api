package hn.foodie.shopping.repositories;

import ch.qos.logback.core.hook.ShutdownHook;
import hn.foodie.shopping.model.collection.ShoppingBasket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingBasketRepository extends MongoRepository<ShoppingBasket, String> {
	Optional<ShoppingBasket> findByItemId(String itemId);
}
