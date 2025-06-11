package io.eddie.validationjava.validation;

import io.eddie.validationjava.dto.SignInRequest;
import io.eddie.validationjava.dto.SignUpRequest;
import io.eddie.validationjava.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/v2/validates")
public class ValidationController2 {

    private final ValidationService validationService;

    @ResponseBody
    @GetMapping("/1")
    public String callService1(
            String username,
            String password
    ) {

        log.info("username = {}", username);
        log.info("password = {}", password);

        validationService.enrollWithUsernameAndPassword(username, password);

        return "OK";
    }

    @PostMapping("/2")
    public String callService2(
            SignInRequest req
    ) {

        String username = req.getUsername();
        String password = req.getPassword();

        if ( username.isBlank() ) {
            return "redirect:/?err=true&code=1";
        }

        return "index";

    }

    @ResponseBody
    @GetMapping("/3")
    public String callService3(@RequestParam(defaultValue = "true") boolean isNg) {
        validationService.enrollWithReq(getSignUpRequest(isNg));
        return "OK";
    }

    private SignUpRequest getSignUpRequest(boolean isNg) {
        if ( isNg ) {
            return new SignUpRequest(
                    "",
                    "",
                    "",
                    "",
                    ""
            );
        } else {
            return new SignUpRequest(
                    "user1",
                    "pwd1",
                    "user1",
                    "user1@user.com",
                    "010-0000-0001"
            );
        }
    }


}
