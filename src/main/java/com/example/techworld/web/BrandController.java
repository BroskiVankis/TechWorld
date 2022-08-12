package com.example.techworld.web;

import com.example.techworld.service.BrandService;
import com.example.techworld.service.OfferService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;

@Controller
public class BrandController {

    private final BrandService brandService;

    private final OfferService offerService;


    public BrandController(BrandService brandService, OfferService offerService) {
        this.brandService = brandService;
        this.offerService = offerService;
    }

    @GetMapping("brands/all")
    public String allBrands(Model model, @PageableDefault(sort = "price", direction = Sort.Direction.ASC, page = 0, size = 5)Pageable pageable) {

        model.addAttribute("brands", brandService.getAllBrands());

        return "brands";
    }
}
