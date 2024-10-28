package com.springapp.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component  //marks it as a Spring Bean and makes it available for injection
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-) !!";
    }
}
