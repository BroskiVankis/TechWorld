package com.example.techworld.model.entity;

import com.example.techworld.model.enums.ConditionEnum;
import com.example.techworld.model.enums.StatusEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "offers")
public class OfferEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "uuid-char")
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionEnum condition;

    private String imageUrl;

    private int yearsUsed;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusEnum status;

    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity seller;

    public UUID getId() {
        return id;
    }

    public OfferEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public ConditionEnum getCondition() {
        return condition;
    }

    public OfferEntity setCondition(ConditionEnum condition) {
        this.condition = condition;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getYearsUsed() {
        return yearsUsed;
    }

    public OfferEntity setYearsUsed(int yearsUsed) {
        this.yearsUsed = yearsUsed;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OfferEntity setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public int getYear() {
        return year;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public ModelEntity getModel() {
        return model;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public OfferEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", condition=" + condition +
                ", imageUrl='" + imageUrl + '\'' +
                ", yearsUsed=" + yearsUsed +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", year=" + year +
                ", model=" + model +
                ", seller=" + seller +
                '}';
    }
}
