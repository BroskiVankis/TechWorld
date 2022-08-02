package com.example.techworld.model.dto.offer;

import com.example.techworld.model.enums.StateEnum;
import com.example.techworld.model.enums.StatusEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class CreateOrUpdateOfferDTO {

    @NotNull
    @Min(1)
    private Long modelId;

    @NotNull
    private StateEnum state;

    @Positive
    @NotNull
    private Integer price;

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

    public CreateOrUpdateOfferDTO setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public StateEnum getState() {
        return state;
    }

    public CreateOrUpdateOfferDTO setState(StateEnum state) {
        this.state = state;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public CreateOrUpdateOfferDTO setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getYearsUsed() {
        return yearsUsed;
    }

    public CreateOrUpdateOfferDTO setYearsUsed(Integer yearsUsed) {
        this.yearsUsed = yearsUsed;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public CreateOrUpdateOfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CreateOrUpdateOfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public CreateOrUpdateOfferDTO setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public CreateOrUpdateOfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}

