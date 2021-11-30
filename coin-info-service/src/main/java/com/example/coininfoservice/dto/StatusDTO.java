package com.example.coininfoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusDTO {

    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yy-hh:mm:ss")
    private Date currentTime;

    public String getStatus() {
        return status;
    }

    public StatusDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public StatusDTO setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
