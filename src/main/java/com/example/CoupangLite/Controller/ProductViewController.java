package com.example.CoupangLite.Controller;

import com.example.CoupangLite.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productList(Model model) {
        model.addAttribute("products", productService.getAllTbProductInfroList());
        return "product/list";
    }
}
