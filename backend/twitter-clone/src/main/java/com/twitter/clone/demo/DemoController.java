package com.twitter.clone.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DemoController {

    @PostMapping(value = "dashboard")
    public String welcome() {
        return "Pepe la volanta";
    }
}
