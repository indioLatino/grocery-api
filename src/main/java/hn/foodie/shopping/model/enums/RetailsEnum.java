package hn.foodie.shopping.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

/**
 * Created by: Rodolfo Galo on 21/7/2019
 */
@AllArgsConstructor
@Getter
public enum RetailsEnum {

    TESCO("TESCO", " Tesco"),
    CARR("CARR", "Carrefour"),
    DIA("DIA", "Dia");

    public String code;
    public String name;

}
