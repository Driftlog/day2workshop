package com.example.day2workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.day2workshop.model.image;
import com.example.day2workshop.service.RandomNumService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(path = "/api")
public class RandomNumberGenController {
    
    @GetMapping("/home")
    public String landingPage() {
        return "home";
    }
   
    @GetMapping("/api/home/{number}")
    @ResponseBody
    public String getURL(@PathVariable int pathNumber) {
        return "URL: " + pathNumber;
    }

    //injecting 
    @Autowired
    RandomNumService service;

    //get is in html
    @GetMapping("/get/{number}") 
        public String generateRanNumbers(Model model, HttpServletRequest request){

            int number = Integer.parseInt(request.getParameter("number"));

            System.out.println("Input no is: " + number);

            //check 
            if (number < 1 || number >30) {

                String errorMessage = "Invalid Number: " + number;
                model.addAttribute("errorMessage", errorMessage);
                return "home";
            }

            List<Integer> randomNumbers = service.generateRanNumbers(number);

            List <image> imageList = new ArrayList<image>();

            for(int randomNumber: randomNumbers) {
                imageList.add(new image(Integer.toString(randomNumber), "/images" + Integer.toString(randomNumber) + ".png"));
            }

            return "display";

    }
}
