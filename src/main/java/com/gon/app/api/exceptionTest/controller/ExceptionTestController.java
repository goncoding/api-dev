package com.gon.app.api.exceptionTest.controller;

import com.gon.app.api.exceptionTest.dto.BindExceptionTestDto;
import com.gon.app.api.health.dto.TestEnum;
import com.gon.app.global.error.ErrorCode;
import com.gon.app.global.error.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exception")
public class ExceptionTestController {



    @GetMapping("/bind-exception-test")
    public String bindExceptionTest(@Valid  BindExceptionTestDto bindExceptionTestDto) {
        return "ok";
    }

    
    @GetMapping("/type-exception-test")
    public String typeMismatchException(TestEnum testEnum) {
        return "ok";
    }

    @GetMapping("/business-exception-test")
    public String businessException(String isError) {
        if ("true".equals(isError)) {
            throw new BusinessException(ErrorCode.TEST);
        }
        return "ok";
    }

    @GetMapping("/exception-test")
    public String exceptionTest(String isError) {
        if ("true".equals(isError)) {
            throw new IllegalArgumentException("예외 테스트");
        }
        return "ok";
    }


}
