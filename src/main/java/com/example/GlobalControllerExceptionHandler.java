package com.example;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 예외 처리기
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404() {
        return "404.html";
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultHandler(HttpServletRequest req, Exception e, Model model) throws Exception {

        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        model.addAttribute("exception", e);
        model.addAttribute("url", req.getRequestURL());

        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));

        model.addAttribute("errorTrace", errors.toString());

        return "500";
    }
}
