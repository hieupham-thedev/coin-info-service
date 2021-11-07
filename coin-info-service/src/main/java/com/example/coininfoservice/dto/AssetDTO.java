package com.example.coininfoservice.dto;

import com.example.coininfoservice.serializer.MoneySerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class AssetDTO {

    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("asset_id")
    private String assetId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type_is_crypto")
    private Boolean isCryto;
    @JsonProperty("data_start")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataStart;
    @JsonProperty("data_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataEnd;
    @JsonProperty("price_usd")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal priceUSD;

    public void setAssetId(String assetId) {
        this.assetId = assetId;
        this.iconUrl = "https://cdn.jsdelivr.net/gh/atomiclabs/cryptocurrency-icons@d5c68edec1f5eaec59ac77ff2b48144679cebca1/32/icon/".concat(assetId.toLowerCase()).concat(".png");
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
