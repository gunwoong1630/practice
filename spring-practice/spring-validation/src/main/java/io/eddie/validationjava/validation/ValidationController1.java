package io.eddie.validationjava.validation;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/validates")
public class ValidationController1 {

    @GetMapping("/1")
    public String showPage1() {
        return "/validation_form/page1";
    }

    @PostMapping("/1")
    public String processPage1(
            HttpServletRequest req
    ) {

        String name = req.getParameter("name");

        if ( name.isBlank() ) {
            return "redirect:/validates/1";
        }

        log.info("통과");

        return "redirect:/validates/1";

    }

}
