package hn.foodie.tesco.model.grocery;

import lombok.Data;

@Data
public class Result {
    private String image;
    private String superDepartment;
    private Integer tpnb;
    private String ContentsMeasureType;
    private String name;
    private Integer unitOfSale; //Case
    private Double AverageSellingUnitWeight; //Case
    private String[] description;
    private String UnitQuantity;
    private Integer id;
    private Integer ContentsQuantity;
    private String department;
    private Double price;
    private Double unitprice;
}
