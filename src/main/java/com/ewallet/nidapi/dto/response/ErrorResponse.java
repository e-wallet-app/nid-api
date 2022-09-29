package com.ewallet.nidapi.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss Z")
    private OffsetDateTime timestamp;
    private String error;
    private String message;
    private List<?> errorItems;

    public ErrorResponse(String error, String message) {
        this.timestamp = OffsetDateTime.now();
        this.error = error;
        this.message = message;
    }

    public void setErrorItems(List<?> errorItems) {
        this.errorItems = errorItems;
    }
}
