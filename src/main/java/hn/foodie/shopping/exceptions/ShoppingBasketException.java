package hn.foodie.shopping.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ShoppingBasketException extends Exception {

    public abstract HttpStatus getStatus();

    public abstract String getMessage();

}
