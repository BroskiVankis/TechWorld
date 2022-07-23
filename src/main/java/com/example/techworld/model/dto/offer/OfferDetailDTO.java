package com.example.techworld.model.dto.offer;

import com.example.techworld.model.enums.ConditionEnum;
import com.example.techworld.model.enums.StatusEnum;

import java.math.BigDecimal;
import java.util.UUID;

public class OfferDetailDTO {

    private UUID id;

    private String imageUrl;

    private String year;

    private String brand;

    private String model;

    private Integer yearsUsed;

    private BigDecimal price;

    private ConditionEnum condition;

    private StatusEnum status;

    public OfferDetailDTO() {
    }

    public UUID getId() {
        return id;
    }

    public OfferDetailDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDetailDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getYear() {
        return year;
    }

    public OfferDetailDTO setYear(String year) {
        this.year = year;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public OfferDetailDTO setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public OfferDetailDTO setModel(String model) {
        this.model = model;
        return this;
    }

    public Integer getYearsUsed() {
        return yearsUsed;
    }

    public OfferDetailDTO setYearsUsed(Integer yearsUsed) {
        this.yearsUsed = yearsUsed;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferDetailDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public OfferDetailDTO setCondition(ConditionEnum condition) {
        this.condition = condition;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OfferDetailDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }
}
