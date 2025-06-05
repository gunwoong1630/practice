package io.eddie.validationjava.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class FormDto {

    private String username;
    private String password;

    private String email;

    private LocalDate formDate1;
    private LocalDateTime formDate2;

    private Integer formRange;

//    public void setForm_date_1(LocalDate formDate1) {
//        this.formDate1 = formDate1;
//    }


}
