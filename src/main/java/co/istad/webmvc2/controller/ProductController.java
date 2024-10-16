package co.istad.webmvc2.controller;

import co.istad.webmvc2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    //to get data , we do contructor injection
    private final List<Product> dataProducts;

    //Mapping URL
    //TODO: View product-list
    @GetMapping
    String viewProduct(Model model){
        model.addAttribute("dataProducts", dataProducts);
        return "/product/product-list";
    }
    //TODO: View Product Detail
    @GetMapping("/{productId}/detail")
    String viewProductDetail(@PathVariable Integer productId, Model model){
        Product product=dataProducts
                        .stream()
                        .filter(p->p.getId()==productId)
                        .findFirst()
                        .orElse(null);
//        model.addAttribute("productId", productId);
        model.addAttribute("product", product);
        return "/product/product-detail";
    }
}

