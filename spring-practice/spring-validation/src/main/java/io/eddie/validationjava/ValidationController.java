package io.eddie.validationjava;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/page")
public class ValidationController {

    @GetMapping("/1")
    public String showPage1() {
        return "/form_body/page1";
    }

    @PostMapping("/1")
    public String processPage1(
            HttpServletRequest req
    ) {

        String name = req.getParameter("name");
        log.info("name = {}", name);

        return "redirect:/page/1";
    }

}
