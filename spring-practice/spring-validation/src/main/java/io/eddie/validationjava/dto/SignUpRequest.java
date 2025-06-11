package io.eddie.validationjava.dto;

import io.eddie.validationjava.validator.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Size(min = 4, message = "아이디는 최소한 4글자는 입력하여야 합니다.")
    private String username;

    @NotBlank
    @Size(min = 4, message = "비밀번호는 최소한 4글자는 입력하여야 합니다.")
    private String password;

    @NotBlank(message = "이름은 반드시 입력되어야 합니다.")
    private String name;

    @Email(message = "올바른 이메일 형식으로 입력되어야 합니다.")
    @NotBlank(message = "이메일은 반드시 입력되어야 합니다.")
    private String email;

    @Phone
    @NotBlank(message = "연락방식은 반드시 입력되어야 합니다.")
    private String phone;

}
