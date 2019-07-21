package hn.foodie.shopping.repositories;

import hn.foodie.shopping.model.collection.ShoppingBasket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingBasketRepository extends MongoRepository<ShoppingBasket, String> {

}