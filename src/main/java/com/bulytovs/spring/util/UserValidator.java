package com.bulytovs.spring.util;

import com.bulytovs.spring.dao.UserDAO;
import com.bulytovs.spring.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    private final UserDAO userDAO;

    @Autowired
    public UserValidator(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

//        if (userDAO.show(user.getEmail()).isPresent()) {
//            errors.rejectValue("email", "", "This email is already taken");
//        }

    }
}
