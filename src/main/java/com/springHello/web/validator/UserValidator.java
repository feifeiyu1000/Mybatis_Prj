package com.springHello.web.validator;

import com.springHello.bean.Book;
import com.springHello.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mar1 on 2/17/17.
 */

/**
 * This Validator validates User instances, and any subclasses of User too
 */
public class UserValidator implements Validator {


    private Validator bookValidator;

    public UserValidator(Validator bookValidator){
        if(bookValidator == null)
            throw  new IllegalArgumentException("The supplied [Validator] is required and must not be null");
        if(!bookValidator.supports(Book.class))
            throw new IllegalArgumentException("The supplied [Validator] must support the validation of [Book] instances. ");
        this.bookValidator = bookValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"username","name.empty");
        User user = (User) o;
        if(user.getPassword().length() < 5)
            errors.rejectValue("password","minimum length");
    }
}
