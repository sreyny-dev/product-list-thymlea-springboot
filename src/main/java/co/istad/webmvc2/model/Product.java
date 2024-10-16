package co.istad.webmvc2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Product {
    private Integer id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean status;
    private String imgPath;

}
//use wrapper class Integer, String, Boolean, BigDecimal Double