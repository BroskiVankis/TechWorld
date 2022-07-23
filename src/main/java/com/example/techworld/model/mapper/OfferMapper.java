package com.example.techworld.model.mapper;

import com.example.techworld.model.dto.offer.AddOfferDTO;
import com.example.techworld.model.dto.offer.OfferDetailDTO;
import com.example.techworld.model.entity.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    OfferEntity addOfferDtoToOfferEntity(AddOfferDTO addOfferDTO);

    @Mapping(source = "model.name", target = "model")
    @Mapping(source = "model.brand.name", target = "brand")
    OfferDetailDTO offerEntityToCardListingOfferDto(OfferEntity offerEntity);
    }

