package com.example.techworld.model.dto.offer;

import javax.validation.constraints.NotEmpty;

public class SearchOfferDTO {

    @NotEmpty
    private String query;

    public SearchOfferDTO() {
    }

    public String getQuery() {
        return query;
    }

    public SearchOfferDTO setQuery(String query) {
        this.query = query;
        return this;
    }
}
