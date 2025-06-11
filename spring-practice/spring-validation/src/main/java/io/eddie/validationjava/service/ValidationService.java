package io.eddie.validationjava.service;

import io.eddie.validationjava.dto.SignUpRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
public class ValidationService {

    public void enrollWithUsernameAndPassword(
            @Valid @NotBlank String username, @Valid @NotBlank String password
    ) {
        log.info("username = {}, password= {}", username, password);
    }

    public void enrollWithReq(@Valid SignUpRequest signUpRequest) {
        log.info("ValidationService.enrollWithReq() 성공적으로 호출");
    }

}
