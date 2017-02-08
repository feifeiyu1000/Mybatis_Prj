package com.springHello.exception;


import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by mar1 on 2/3/17.
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "errorPage";


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = BookNotFoundException.class)
    public ModelAndView exceptionBookNotFoundHandler(HttpServletRequest req, HttpServletResponse res, Exception ex){
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(),ex.getMessage());
        ModelAndView mav = new ModelAndView();
        mav.addObject("url",req.getRequestURL());
        mav.addObject("exception",ex);
        mav.addObject("status", errorInfo.getErrorCode());
        mav.addObject("errorInfo", errorInfo);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ModelAndView badRequestErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception ex) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", ex);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("status", res.getStatus());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) throw e;

        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.addObject("status", res.getStatus());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;
    }




}
