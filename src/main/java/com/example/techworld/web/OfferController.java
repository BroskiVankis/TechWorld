package com.example.techworld.web;


import com.example.techworld.model.dto.offer.CreateOrUpdateOfferDTO;
import com.example.techworld.model.dto.offer.SearchOfferDTO;
import com.example.techworld.model.user.TechUserDetails;
import com.example.techworld.service.BrandService;
import com.example.techworld.service.OfferService;
import com.example.techworld.exception.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class OfferController {

    private final OfferService offerService;

    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/offers/all")
    public String allOffers(Model model, @PageableDefault(sort = "price", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable) {
        model.addAttribute("offers", offerService.getAllOffers(pageable));

        return "offers";
    }

    @GetMapping("/offers/add")
    public String addOffer(Model model) {
        if(!model.containsAttribute("addOfferModel")) {
            model.addAttribute("addOfferModel", new CreateOrUpdateOfferDTO());
        }
        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/offers/add")
    public String addOffer(@Valid CreateOrUpdateOfferDTO addOfferModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, @AuthenticationPrincipal TechUserDetails userDetails) {

        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferModel", addOfferModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferModel", bindingResult);
            return "redirect:/offers/add";
        }

        offerService.addOffer(addOfferModel, userDetails);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/search")
    public String searchQuery(@Valid SearchOfferDTO searchOfferDTO,BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("searchOfferModel", searchOfferDTO);
            model.addAttribute("org.springframework.validation.BindingResult.searchOfferModel", bindingResult);
            return "offer-search";
        }

        if(!model.containsAttribute("searchOfferModel")) {
            model.addAttribute("searchOfferModel", searchOfferDTO);
        }

        if(!searchOfferDTO.isEmpty()) {
            model.addAttribute("offers", offerService.searchOffer(searchOfferDTO));
        }

        return "offer-search";
    }

    @GetMapping("offers/{id}/edit")
    public String edit(@PathVariable ("id") UUID uuid, Model model) {

       var offer = offerService.getOfferEditDetails(uuid).orElseThrow(() -> new ObjectNotFoundException("Offer with ID " + uuid + " not found"));

        model.addAttribute("offer", offer);

        return "details";
    }

    @PreAuthorize("isOwner(#uuid)")
    @DeleteMapping("/offers/{id}")
    public String deleteOffer(
            @PathVariable("id") UUID uuid) {
        offerService.deleteOfferById(uuid);

        return "redirect:/offers/all";
    }

    @GetMapping("/offers/{id}/details")
    public String getOfferDetail(@PathVariable("id") UUID uuid,
                                 Model model) {

        var offerDto =
                offerService.findOfferByUUID(uuid).
                        orElseThrow(() -> new ObjectNotFoundException("Offer with UUID " + uuid + " not found!"));

        model.addAttribute("offer", offerDto);

        return "details";
    }

}
