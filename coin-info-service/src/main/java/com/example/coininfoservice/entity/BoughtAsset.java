package com.example.coininfoservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "bought_asset")
public class BoughtAsset {

    @Id
    @Column(name = "asset_id")
    private String assetId;

    @Column(name = "bought_usd")
    private BigDecimal boughtPriceUSD;

    public String getAssetId() {
        return assetId;
    }

    public BoughtAsset setAssetId(String assetId) {
        this.assetId = assetId;
        return this;
    }

    public BigDecimal getBoughtPriceUSD() {
        return boughtPriceUSD;
    }

    public BoughtAsset setBoughtPriceUSD(BigDecimal boughtPriceUSD) {
        this.boughtPriceUSD = boughtPriceUSD;
        return this;
    }
}
