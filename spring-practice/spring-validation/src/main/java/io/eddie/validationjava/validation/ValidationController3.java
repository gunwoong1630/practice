package io.eddie.validationjava.validation;

import io.eddie.validationjava.dto.HtmlForm;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/validates/e")
public class ValidationController3 {

    @GetMapping("/1")
    public String showPage1(Model model) {
        model.addAttribute("htmlForm", new HtmlForm());
        return "/validation_exception/page1";
    }

    @PostMapping("/1")
    public String processPage1(
            @Valid HtmlForm htmlForm,
            BindingResult bindingResult
    ) {

//        bindingResult.hasErrors();

        if ( bindingResult.hasErrors() ) {

            List<ObjectError> errors = bindingResult.getAllErrors();

            for (ObjectError error : errors) {
                log.error("ERR = {}", error.getCode());
                log.error("ERROR_MESSAGE = {}", error.getDefaultMessage());
            }

            return "/validation_exception/page1";

        }


        log.info("htmlForm = {}", htmlForm.toString());
        return "redirect:/";
    }

}
