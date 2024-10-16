package co.istad.webmvc2.repository;

import co.istad.webmvc2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final List<Product> dataProducts; //Inject Product Bean from Model

    //SELECT * FROM product
    public List<Product> findAll() {
        return dataProducts;
    }
    //
    public List<Product> findByName(String name){
       return  dataProducts.stream()
                .filter(product->product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
    //Find by Code
    public List<Product> findByCode(String code){
        return dataProducts.stream()
                .filter(product->product.getCode().equals(code))
                .toList();
    }
    //Find By ID
//    public List<Product> findByID(Integer id){
//        return dataProducts
//                .stream()
//                .filter(product->product.getId()==id)
//                .toList();
//    }
    public Product findByID(Integer id){
        return dataProducts.stream()
                .filter(product->product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    //Find by Price ==
    public List<Product> findByPriceEqual(BigDecimal price){
        return dataProducts
                .stream()
                .filter(product->product.getPrice().compareTo(price)==0)
                .toList();
    }
    //Find by Price >
    public List<Product> findByPriceGreater(BigDecimal price){
        return dataProducts
                .stream()
                .filter(product->product.getPrice().compareTo(price)>0)
                .toList();
    }
    //Find by price <
    public List<Product> findByPriceLess(BigDecimal price){
        return dataProducts
                .stream()
                .filter(product->product.getPrice().compareTo(price)<0)
                .toList();
    }
    // search by name and code
    public List<Product> search(String name, Boolean status){
        return dataProducts.stream()
                .filter(product->{
                    if(status==null)
                        return searchCondition(product, name);
                    else
                        return searchCondition(product, name, status);
                })
                .toList();
    }
    private Boolean searchCondition(Product product, String name, boolean status){
        return product.getName().toLowerCase().contains(name.toLowerCase()) && product.getStatus().equals(status);
    }
    private Boolean searchCondition(Product product, String name){
        return product.getName().toLowerCase().contains(name.toLowerCase());
    }
    //Insert
    public void insertProduct(Product product){
        dataProducts.add(product);
    }
}
