package com.example.academics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.academics.repository.AcademicRequestRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AcademicRequestRepository requestRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("requests", requestRepo.findAll());
        return "admin/dashboard";
    }
}
