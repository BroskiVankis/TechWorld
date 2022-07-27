package com.example.techworld.model.dto.offer;

import com.example.techworld.model.enums.StateEnum;
import com.example.techworld.model.enums.StatusEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class AddOfferDTO {

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private StateEnum state;

    @Positive
    @NotNull
    private Integer price;

    @Positive
    @NotNull
    private Integer yearsUsed;

    @Min(2000)
    @NotNull
    private Integer year;

    @NotEmpty
    private String description;

    @NotNull
    private StatusEnum status;

    @NotEmpty
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public AddOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public StateEnum getState() {
        return state;
    }

    public AddOfferDTO setState(StateEnum state) {
        this.state = state;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public AddOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYearsUsed() {
        return yearsUsed;
    }

    public AddOfferDTO setYearsUsed(Integer yearsUsed) {
        this.yearsUsed = yearsUsed;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public AddOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public AddOfferDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}
