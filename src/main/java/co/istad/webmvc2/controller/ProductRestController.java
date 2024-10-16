package co.istad.webmvc2.controller;

import co.istad.webmvc2.dto.response.ProductResponse;
import co.istad.webmvc2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductRestController {
    //API
//    private final List<Product> products;
    private final ProductService productService;
    @GetMapping
    public List<ProductResponse> searchProductByName(
            @RequestParam(required=false, defaultValue="")String name,
            @RequestParam(required=false) Boolean status
){
    return productService.searchProducts(name, status);
}
    @GetMapping("/productCode/{code}")
    public List<ProductResponse> searchByCode(@PathVariable String code){
    return productService.searchByCode(code);
}
    @GetMapping("/productName/{name}")
    public List<ProductResponse> searchByName(@PathVariable String name){
        return productService.findByName(name);
    }
    @GetMapping("/productId/{id}")
    public ProductResponse searchById(@PathVariable Integer id){
    return productService.searchById(id);
    }
//    @GetMapping("/price/equal")
//    public List<ProductResponse> searchByPriceEqual(@RequestParam BigDecimal price){
//        return productService.searchByPriceEqual(price);
//    }
//    @GetMapping("/price/greater")
//    public List<ProductResponse> searchByPriceGreater(@RequestParam BigDecimal price){
//        return productService.searchByPriceGreater(price);
//    }
//    @GetMapping("/price/less")
//    public List<ProductResponse> searchByPrinceLess(@RequestParam BigDecimal price){
//        return productService.searchByPriceLess(price);
//    }
//@GetMapping("/price")
//public List<ProductResponse> searchByPrice(
//        @RequestParam BigDecimal price,
//        @RequestParam String condition
//) {
//    switch (condition.toLowerCase()) {
//        case "equal":
//            return productService.searchByPriceEqual(price);
//        case "greater":
//            return productService.searchByPriceGreater(price);
//        case "less":
//            return productService.searchByPriceLess(price);
//        default:
//            throw new IllegalArgumentException("Invalid condition: " + condition);
//    }
//}

    //Search by having 2 requestParam, using if-else statements
    @GetMapping("/price")
    public List<ProductResponse> searchByPrice(@RequestParam BigDecimal price, @RequestParam String condition
    ){
        if(condition.toLowerCase().equals("equal")){
            return productService.searchByPriceEqual(price);
        }else if(condition.toLowerCase().equals("greater")){
            return productService.searchByPriceGreater(price);
        }else {
            return productService.searchByPriceLess(price);
            }
        }
    @GetMapping("/search")
    public List<ProductResponse> findAll(){
        return productService.findAllProducts();
    }
}



//http://localhost:8080/api/products/price?price=200&condition=less
//Stream by name and return a list of result
