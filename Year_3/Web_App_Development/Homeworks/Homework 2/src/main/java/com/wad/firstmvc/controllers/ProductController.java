package com.wad.firstmvc.controllers;


import com.wad.firstmvc.domain.Product;
import com.wad.firstmvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    //-populate the model with the retrieved products!
    //-select the appropriate view (navigation)
    @GetMapping
    public String viewProducts(Model model){
        model.addAttribute("products",productService.findAll());
        return "products";
    }

    @GetMapping("/new")
    public String showAddProductForm(Model model){
        model.addAttribute("product",new Product());
        return "addproducts";
    }

    @PostMapping("/new")
    public String addProduct(Product product){
        if(product.getId()==null)
            product.setId(new Random().nextLong());
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String showSearchForm(Model model) {
        model.addAttribute("products", productService.findAll());
        return "searchproducts";
    }

    @PostMapping("/search")
    public String searchProducts(@RequestParam(required = false) String category, @RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice, Model model) {
        List<Product> products = productService.searchProducts(category, minPrice, maxPrice);
        model.addAttribute("products", products);
        return "searchproducts";
    }

}
