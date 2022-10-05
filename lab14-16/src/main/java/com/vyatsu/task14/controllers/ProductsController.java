package com.vyatsu.task14.controllers;

import com.vyatsu.task14.entities.Product;
import com.vyatsu.task14.repositories.ProductRepository;
import com.vyatsu.task14.repositories.ProductSpecs;
import com.vyatsu.task14.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class ProductsController {
    private ProductsService productsService;
    private ProductRepository productRepository;
    private int pagees = 0;
    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("")
    public String Firste()
    {
        return "redirect:/products?Min=&Max=&Substring=";
    }



    @GetMapping("/products")
    public String ShowProducts(@RequestParam(value = "page",required = false) PageRequest page,
                               @RequestParam(value = "Min",required = false) BigDecimal Min,
                               @RequestParam(value = "Max",required = false) BigDecimal Max,
                               @RequestParam(value = "Substring",required = false) String Substring,
                               @PageableDefault(page = 0, size = 5, sort = "counter", direction = Sort.Direction.DESC) Pageable pageable,
                               Model model)
    {
        Product product = new Product();
        Specification<Product> specification = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root,
                                         CriteriaQuery<?> query,
                                         CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };
        Specification<Product> X = Specification.where(null);
//        if(page == null)
//        {
//            page = PageRequest.ofSize(8);
//        }
        if(Max != null)
        {
            X = X.and(ProductSpecs.priceLesserThanOrEq(Max));
        }
        if(Min != null)
        {
            X = X.and(ProductSpecs.priceGreaterThanOrEq(Min));
        }
        if(Substring != "")
        {
            X = X.and(ProductSpecs.titleContainsWord(Substring));
        }
//        System.out.println("min "+ProductSpecs.priceLesserThanOrEq(Min));
//        System.out.println("max "+ProductSpecs.priceGreaterThanOrEq(Max));
        model.addAttribute("products",productsService.getProduct(X,PageRequest.of(pagees,5)).getContent());
//        System.out.println("//// "+productsService.getProduct(specification,PageRequest.of(0,5)).getContent());
//        Pageable firstPageWithTwoElements = PageRequest.of(0,3);
//        Pageable secondPageWithFiveElements =  PageRequest.of(0,5);
//        Page<Product> allProducts =  productRepository.findAll(firstPageWithTwoElements);
//        Page<Product> allProductsSortedByName =  productRepository.findAll(Sort.by("title"));
//        model.addAttribute("products", productsService.getAllProducts(Min,Max,Substring));
//        Pageable sortedByName =  PageRequest.of(0, 3, Sort.by("title"));
        //(specification, PageRequest.of(-1,5)).get
        model.addAttribute("product", product);
        model.addAttribute("Min", Min);
        model.addAttribute("Max", Max);
        model.addAttribute("Substring", Substring);
        model.addAttribute("top3",productsService.top3());
        return "hello";
    }

    @GetMapping("/add")
    public String addProduct(Model model)
    {
//        productsService.add(Name,Price);
        Product product = new Product();
        model.addAttribute("product",product);
//        productsService.saveOrUpdate(product);
        return "edit";
    }
//
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id)
    {
        productsService.deleteById(id);
        return "redirect:/products?Min=&Max=&Substring=";
    }
//
//    @GetMapping("/change")
//    public String changeProduct(@RequestParam(value = "ID") Integer id,
//                                @RequestParam(value = "Name",required = false) String Name,
//                                @RequestParam(value = "Price",required = false) Integer Price)
//    {
//        productsService.changeById(id,Name,Price);
//        return "redirect:/products?Min=&Max=&Substring=";
//    }
//    @GetMapping("/show/{id}")
//    public String showOneProduct(Model model, @PathVariable(value = "id") long id) {
//        Product product = productsService.getbyId(id);
//        model.addAttribute("product", product);
//        return "product-page";
//    }
    @GetMapping("/showPage/{id}")
    public String showPageProduct(Model model, @PathVariable(value = "id") int id) {

        pagees = id;
        System.out.println(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println(currentPrincipalName);
        return "redirect:/products?Min=&Max=&Substring=";
    }
    private static HashMap<Long,Long> County = new HashMap<>();

//    public void SoutLikeProducts(){
//        ArrayList<Long> keys = new ArrayList<>(County.keySet());
//        ArrayList<Long> values = new ArrayList<>(County.values());
//        for (int i = 0; i < values.size(); i++) {
//            System.out.println("ID самых просматриваемых товаров " + keys.get(i));
//        }
//    }
//версия если работает просмотр информации
//    @GetMapping("/products/show/{id}")
//    public String showOneProduct(Model model, @PathVariable(value = "id") long id)
//    {
//        Product product = productsService.getbyId(id);
//        model.addAttribute("product", product);
//        System.out.println("Посмотрели товар с id " + id);
//        if(County.get(id) != null) County.put(id, County.get(id) + 1);
//        else County.put(id, 1L);
//      //  SoutLikeProducts();
//        Long max = County.entrySet()
//                .stream()
//                .max((entry1,
//                      entry2) -> entry1.getValue() >
//                        entry2.getValue() ? 1 : -1)
//                .get().getKey();
//        System.out.println("Самый просматриваемый id товара " + max + " кол-во просмотров " + County.get(max));
//        return "product-page";
//    }


    @PostMapping("/product/edit")
    public String editProduct(@ModelAttribute(value = "product")Product product) {
        productsService.saveOrUpdate(product);
        return "redirect:/products?Min=&Max=&Substring=";
    }
    @GetMapping("/show_edit/{id}")
    public String editOneProduct(Model model, @PathVariable(value = "id") int id) {
        Product product = productsService.getbyId((long)id);
        System.out.println("POPAL V CONTORL GET MAPPIN");
        model.addAttribute("product", product);
        return "edit";
    }
    // Версия если работает подсчёт
   // @GetMapping("/show/{id}")
    @GetMapping("/products/show/{id}")
    public String showProduct(Model model, @PathVariable(value = "id") Long id) {
        Product product = productsService.getById(id);
        productsService.saveShowed(product);
        model.addAttribute("product", product);
        return "product-page";
    }
//    @GetMapping("/top3")
//    public String top3()
//    {
//
//    }

    @GetMapping("/res")
    public String reset(){
        return "redirect:/products?Min=&Max=&Substring=";
    }
}
