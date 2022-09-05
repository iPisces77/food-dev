package com.ipisces42.config;

import com.ipisces42.exception.CustomException;
import com.ipisces42.utils.IMOOCJSONResult;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * @author fuhaixin
 * @date 2022/8/17
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {
    public static final String NOTE = "请求参数不正确:%s";

    @ExceptionHandler(CustomException.class)
    public IMOOCJSONResult customException(CustomException exception) {
        return IMOOCJSONResult.errorMsg(exception.getMessage());
    }


    /**
     * 处理 SpringMVC 参数校验不正确
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public IMOOCJSONResult methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        return IMOOCJSONResult.errorMsg(String.format(NOTE, fieldError.getDefaultMessage()));
    }

    /**
     * 处理 SpringMVC 参数绑定不正确，本质上也是通过 Validator 校验
     */
    @ExceptionHandler(BindException.class)
    public IMOOCJSONResult bindExceptionHandler(BindException ex) {
        FieldError fieldError = ex.getFieldError();
        return IMOOCJSONResult.errorMsg(String.format(NOTE, fieldError.getDefaultMessage()));
    }

    /**
     * 处理 Validator 校验不通过产生的异常
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public IMOOCJSONResult constraintViolationExceptionHandler(ConstraintViolationException ex) {
        ConstraintViolation<?> constraintViolation = ex.getConstraintViolations().iterator().next();
        return IMOOCJSONResult.errorMsg(String.format(NOTE, constraintViolation.getMessage()));
    }
}
