package com.cpp.HelloSpring;

import com.cpp.HelloSpring.domain.Person;
import java.util.ArrayList;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//SPRING MVC CONTROLLER ANNOTATION
@Controller
@Slf4j
public class HomeController {

    //GETTING VALUE FROM application.properties usign IoC
    @Value("${index.hi}")
    private String hi;
    
    @GetMapping("/")
    public String home(Model model) {
        //-------------------
        var person = new Person();
        person.setName("Cesar");
        person.setLastname("Penaloza");
        person.setEmail("cpenaloz@tcs.com");
        person.setPhoneNumber("5586177777");
        
        var person2 = new Person();
        person2.setName("Namratha");
        person2.setLastname("Gangula");
        person2.setEmail("gnamratha@tcs.com");
        person2.setPhoneNumber("8234567812");
        //--------------------
        
        //VARIABLE TO BE SENT TO INDEX HTML
        var sayHi = "Hello World! Thymeleaf";
        
        //KEY-VALUE MODEL
        model.addAttribute("sayHi", sayHi);

        //SHARING application.properties sayHi VALUE
        model.addAttribute("hi", hi);
        
        //SHARING Person OBJECT
        model.addAttribute("person", person);
        
        //SHARING Person OBJECTS
        var people = Arrays.asList(person, person2);
        //var people = new ArrayList();
        model.addAttribute("people", people);
        
        //log.info("Executing rest controller");
        log.info("Executing MVC Controller");
        //log.debug("More details about controller");
        //REST CONTROLLER RETURN
        //return "Hello Spring World";
        //CONTROLLER RETURN
        return "index";
    }

}
