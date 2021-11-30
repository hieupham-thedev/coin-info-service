package com.example.coininfoservice.dto;

import com.example.coininfoservice.serializer.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoughtAssetDTO {

    @JsonProperty("asset_id")
    private String assetId;

    @JsonProperty("icon_url")
    private String iconUrl;

    @JsonProperty("bought_usd")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal boughtPriceUSD;

    @JsonProperty("current_usd")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal currentPriceUSD;

    public void setAssetId(String assetId) {
        this.assetId = assetId;
        this.iconUrl = "https://cdn.jsdelivr.net/gh/atomiclabs/cryptocurrency-icons@d5c68edec1f5eaec59ac77ff2b48144679cebca1/32/icon/".concat(assetId.toLowerCase()).concat(".png");
    }

    public String getAssetId() {
        return assetId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public BoughtAssetDTO setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
        return this;
    }

    public BigDecimal getBoughtPriceUSD() {
        return boughtPriceUSD;
    }

    public BoughtAssetDTO setBoughtPriceUSD(BigDecimal boughtPriceUSD) {
        this.boughtPriceUSD = boughtPriceUSD;
        return this;
    }

    public BigDecimal getCurrentPriceUSD() {
        return currentPriceUSD;
    }

    public BoughtAssetDTO setCurrentPriceUSD(BigDecimal currentPriceUSD) {
        this.currentPriceUSD = currentPriceUSD;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
