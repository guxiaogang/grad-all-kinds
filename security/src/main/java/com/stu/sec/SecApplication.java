package com.stu.sec;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@RestController
public class SecApplication {
    public static void main(String[] args) {
        run(SecApplication.class, args);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Object welcome() {
        return "test";
    }
}
