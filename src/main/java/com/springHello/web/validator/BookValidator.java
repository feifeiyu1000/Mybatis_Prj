package com.springHello.web.validator;

import com.springHello.bean.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by mar1 on 2/17/17.
 */
public class BookValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Book.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"name","name.empty");
        Book book = (Book) o;
        if(book.getNbrPage() < 10)
            errors.rejectValue("nbrPage","min.nbrPage");
    }
}
