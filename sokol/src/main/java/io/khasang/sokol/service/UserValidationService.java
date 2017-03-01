//package io.khasang.sokol.service;
//
//import io.khasang.sokol.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.validation.ConstraintViolation;
//import javax.validation.Validator;
//import java.util.Set;
//
//@Service("userValidationService")
//public class UserValidationService  {
//    @Autowired
//    private Validator validators;
//
//
//    public Set<ConstraintViolation<User>> validateUser(User user){
//        return validators.validate(user);
//    }
//}
