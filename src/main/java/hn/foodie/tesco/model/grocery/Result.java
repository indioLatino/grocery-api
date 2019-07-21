package hn.foodie.tesco.model.grocery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class Result {
    private String image;
    private String superDepartment;
    private Integer tpnb;
    @JsonProperty("ContentsMeasureType")
    private String contentsMeasureType;
    private String name;
    @JsonProperty("UnitOfSale")
    private Integer unitOfSale; //Case
    @JsonProperty("AverageSellingUnitWeight")
    private Double averageSellingUnitWeight; //Case
    private String[] description;
    @JsonProperty("UnitQuantity")
    private String unitQuantity;
    private Integer id;
    @JsonProperty("ContentsQuantity")
    private String contentsQuantity;
    private String department;
    private Double price;
    private Double unitprice;
}
