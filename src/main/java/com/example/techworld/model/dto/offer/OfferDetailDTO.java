package com.example.techworld.model.dto.offer;

import com.example.techworld.model.enums.StateEnum;
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

    private StateEnum state;

    private StatusEnum status;

    private String sellerFirstName;

    private String sellerLastName;

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public OfferDetailDTO setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
        return this;
    }

    public String getSellerFullName() {
        return sellerFirstName + " " + sellerLastName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public OfferDetailDTO setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
        return this;
    }

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

    public StateEnum getState() {
        return state;
    }

    public OfferDetailDTO setState(StateEnum state) {
        this.state = state;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OfferDetailDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public String getOfferHighlight() {
        return this.year + " " + this.brand + " " + this.model;
    }
}
