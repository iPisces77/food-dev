package com.ipisces42.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fuhaixin
 * @date 2022/9/3
 **/
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private String message;
}
