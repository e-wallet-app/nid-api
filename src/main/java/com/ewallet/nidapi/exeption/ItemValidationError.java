package com.ewallet.nidapi.exeption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemValidationError {
    private String itemName;
    private String field;
    private Object rejectedValue;
    private String message;
}

