package com.sp.controllers;

import com.sp.entities.Product;
import com.sp.entities.User;
import com.sp.services.ProductService;
import com.sp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/shop")
    public String shopPage(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "shop";
    }

    @GetMapping("/details/{id}")
    public String detailsPage(Model model, @PathVariable("id") Long id) {
       Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "details";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProductsById(Model model, @PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/shop";
    }

    @GetMapping("/product_by_title")
    public String searchProductByTitle(Model model, @RequestParam("title") String title) {
        Product product = productService.getProductByTitle(title);
        model.addAttribute("product", product);
        return "details";
    }




}

