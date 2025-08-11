package com.example;

import org.springframework.web.bind.annotation.PostMapping;

public class BuzzerController {

	 @PostMapping("/buzzer/on")
	    public String buzzerOn() {
	        // Send command to Raspberry Pi
	        return "Buzzer activated!";
	    }
}
