package co.istad.webmvc2.staticDB;

import co.istad.webmvc2.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class staticDataBase {
    @Bean
    List<Product> dataProduct(){
        Product p1=new Product();
        Product p2=new Product();
        Product p3=new Product();
        Product p4=new Product();
        p1.setId(1);
        p1.setCode("100");
        p1.setName("Product 1");
        p1.setDescription("Product 1");
        p1.setPrice(BigDecimal.valueOf(100));
        p1.setStatus(true);
        p1.setImgPath("ip12.png");

        p2.setId(2);
        p2.setCode("200");
        p2.setName("Product 2");
        p2.setDescription("Product 2");
        p2.setPrice(BigDecimal.valueOf(200));
        p2.setStatus(true);
        p2.setImgPath("ip13.png");

        p3.setId(3);
        p3.setCode("300");
        p3.setName("Product 3");
        p3.setDescription("Product 3");
        p3.setPrice(BigDecimal.valueOf(300));
        p3.setStatus(false);
        p3.setImgPath("ip14.png");

        p4.setId(4);
        p4.setCode("400");
        p4.setName("Product 4");
        p4.setDescription("Product 4");
        p4.setPrice(BigDecimal.valueOf(400));
        p4.setStatus(true);
        p4.setImgPath("ip15pro.png");

        return List.of(
                p1,p2,p3,p4
        );
    }
}
