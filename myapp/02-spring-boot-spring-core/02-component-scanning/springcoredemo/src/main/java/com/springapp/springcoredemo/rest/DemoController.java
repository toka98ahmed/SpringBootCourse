package com.springapp.springcoredemo.rest;

import com.springapp.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;

    //define a constructor

    @Autowired //this tells Spring to inject a dependency. Optional if one constructor
    public DemoController (Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
