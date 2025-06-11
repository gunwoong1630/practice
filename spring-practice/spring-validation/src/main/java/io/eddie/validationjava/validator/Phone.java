package io.eddie.validationjava.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface Phone {

    String message() default "핸드폰 번호를 제대로 입력해주세요!";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
