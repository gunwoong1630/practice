package io.eddie.validationjava.dto;

import io.eddie.validationjava.validator.Phone;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class HtmlForm {

    @NotBlank(message = "text값은 비어있을 수 없습니다. 반드시 입력이 필요합니다!")
    private String text;

    @Email
    @NotBlank
    private String email;

    @Phone
    @NotBlank
    private String phone;

    @NotNull
    private LocalDate localDate;

}
