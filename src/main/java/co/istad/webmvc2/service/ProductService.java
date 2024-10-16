package co.istad.webmvc2.service;

import co.istad.webmvc2.dto.response.ProductResponse;
import co.istad.webmvc2.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    //abstract methods
    //Return the products of DTO
    List<ProductResponse> findAllProducts();
    List<ProductResponse> findByName(String name);
    List<ProductResponse> searchProducts(String name, Boolean Status);
    List<ProductResponse> searchByCode(String code);
    ProductResponse searchById(Integer id);
    List<ProductResponse> searchByPriceEqual(BigDecimal price);
    List<ProductResponse> searchByPriceGreater(BigDecimal price);
    List<ProductResponse> searchByPriceLess(BigDecimal price);
    void insertProduct(Product product);

}
