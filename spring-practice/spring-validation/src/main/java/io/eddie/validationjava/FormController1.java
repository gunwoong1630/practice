package io.eddie.validationjava;

import io.eddie.validationjava.dto.FormDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/forms")
public class FormController1 {

    @GetMapping("/1")
    public String showForm1() {
        return "/forms/form1";
    }

    @PostMapping("/1")
    public String processForm1(HttpServletRequest req) {

        String formNumber = req.getParameter("form_number");
        String formRange = req.getParameter("form_range");
        String formDate = req.getParameter("form_date");
        String formText = req.getParameter("form_text");

        log.info("formNumber = {}", formNumber);
        Integer.parseInt(formNumber);
        log.info("formRange = {}", formRange);
        log.info("formDate = {}", formDate);
        log.info("formText = {}", formText);


        return "/forms/form1";
    }

    @GetMapping("/2")
    public String showForm2() {
        return "/forms/form2";
    }

    @PostMapping("/2")
    public String processForm2(FormDto formDto) {
        log.info("formDto.toString() = {}", formDto.toString());
        return "/forms/form2";
    }

}
