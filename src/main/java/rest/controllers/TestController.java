package rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    public String testImplementation() {
        return "<h1>Spring was initialized correctly.</h1>";
    }

}
