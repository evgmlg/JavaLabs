package com.vyatsu.task14.services;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Page<Product> getProduct (Specification<Product> specification, PageRequest pageable){
        return productRepository.findAll(specification,pageable);
    }
    public Product getbyId(Long id){
        return productRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id){
        productRepository.deleteById( id);
    }
    public void saveOrUpdate(Product product){
        productRepository.save(product);

    }
    public List<Product> getFilteredProducts(Specification spec){
        return productRepository.findAll(spec);
    }

//Версия если работает подсчёт
public void saveShowed(Product product) {
    product.setCounter(product.getCounter() + 1);
    productRepository.save(product);

}
//    public List<Product> top3 () {
//        saveShowed().stream()
//                .sorted(Comparator.comparing(Product::getCounter).reversed())
//                .limit(3)
//                .collect(Collectors.toList());
//        return top3();
//    }
public List<Product> top3() {
    return productRepository
            .findAll(new Sort(Sort.Direction.DESC, "counter"))
            .stream()
            .limit(3)
            .collect(Collectors.toList());
}
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
//
}
