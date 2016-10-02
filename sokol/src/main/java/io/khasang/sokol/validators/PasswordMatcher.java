package io.khasang.sokol.validators;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface PasswordMatcher {
}
