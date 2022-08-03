package com.easyimmo.common.utils;

import com.easyimmo.common.exception.InvalidEntityException;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class CustomValidator {

    private final Validator validator;

    public CustomValidator(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> errors = validator.validate(object);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException(errors.toString());
        }
    }
}
