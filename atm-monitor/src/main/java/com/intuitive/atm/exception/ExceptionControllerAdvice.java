package com.intuitive.atm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.intuitive.atm.dto.BaseResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler({Exception.class})
	  public final ResponseEntity<BaseResponse> handleException(Exception ex) {
	    log.error(ex.getMessage());
	    BaseResponse response =
	        BaseResponse.builder().success(false).responseCode(90).message(ex.getMessage())
	            .build();
	    return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
	
	@ExceptionHandler({ATMException.class})
	  public final ResponseEntity<Object> handleATMException(
			  ATMException ex) {
	    BaseResponse baseResponse =
	        BaseResponse.builder().success(false).responseCode(90).message(ex.getMessage()).build();
	    return new ResponseEntity(baseResponse, ex.getHttpStatus());
	  }

}
