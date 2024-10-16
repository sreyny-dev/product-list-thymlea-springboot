package co.istad.webmvc2.service.impl;

import co.istad.webmvc2.dto.response.ProductResponse;
import co.istad.webmvc2.model.Product;
import co.istad.webmvc2.repository.ProductRepository;
import co.istad.webmvc2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;//product of model or domain

    @Override
    public List<ProductResponse> findAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(product->new ProductResponse(product.getCode(),product.getName(),product.getPrice()))
                .toList();
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        return productRepository
                .findByName(name)
                .stream()
                .map(product->new ProductResponse(product.getCode(), product.getName(), product.getPrice()))
                .toList();
    }

    //need to convert domain or model data to DTOs
    @Override
    public List<ProductResponse> searchProducts(String name, Boolean status) {
        return productRepository
                .search(name, status)
                .stream()
                .map(product->new ProductResponse(product.getCode(), product.getName(), product.getPrice()))
                .toList();
    }

    @Override
    public List<ProductResponse> searchByCode(String code) {
        return productRepository
                .findByCode(code)
                .stream()
                .map(product->new ProductResponse(product.getCode(),
                        product.getName(),
                        product.getPrice()))
                .toList();
    }

//    @Override
//    public List<ProductResponse> searchById(Integer id) {
//        return productRepository
//                .findByID(id)
//                .stream()
//                .map(product->new ProductResponse(product.getCode(),product.getName(),product.getPrice()))
//                .toList();
//    }
@Override
public ProductResponse searchById(Integer id) {
    Product product =productRepository.findByID(id);
    if(product!=null)
        return new ProductResponse(product.getCode(), product.getName(),product.getPrice());
    else
        return null;
}

    @Override
    public List<ProductResponse> searchByPriceEqual(BigDecimal price) {
        return productRepository
                .findByPriceEqual(price)
                .stream()
                .map(product->new ProductResponse(product.getCode(),product.getName(), product.getPrice()))
                .toList();
    }

    @Override
    public List<ProductResponse> searchByPriceGreater(BigDecimal price) {
        return productRepository
                .findByPriceGreater(price)
                .stream()
                .map(product->new ProductResponse(product.getCode(),product.getName(), product.getPrice()))
                .toList();
    }

    @Override
    public List<ProductResponse> searchByPriceLess(BigDecimal price) {
        return productRepository
                .findByPriceLess(price)
                .stream()
                .map(product->new ProductResponse(product.getCode(),product.getName(), product.getPrice()))
                .toList();
    }

    @Override
    public void insertProduct(Product product) {

    }

}
