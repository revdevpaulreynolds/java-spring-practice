package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye because of routing above
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    // Now at /hello/hello
//    @GetMapping("hello")
//    @PostMapping()
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String lang) {

        return "<h3>" + HelloController.createMessage(name, lang) + "</h3>";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" +
                    "<input type='text' name='name'>" +
                    "<select name='lang' id='lang-select'>" +
                        "<option value='eng'>English</option>" +
                        "<option value='it'>Italian</option>" +
                        "<option value='fr'>French</option>" +
                        "<option value='gr'>Greek</option>" +
                        "<option value='jap'>Japanese</option>" +
                    "</select>" +
                    "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    public static String createMessage(String name, String lang) {
        HashMap<String, String> greeting = new HashMap<>();
        greeting.put("eng", "Hello");
        greeting.put("it", "Benvenuto");
        greeting.put("fr", "Bienvenue");
        greeting.put("gr", "καλως ΗΡΘΑΤΕ");
        greeting.put("jap", "ようこそ");

        if (lang == null) lang = "eng";

        return  greeting.get(lang) + " " + name + "!";
    }
}
