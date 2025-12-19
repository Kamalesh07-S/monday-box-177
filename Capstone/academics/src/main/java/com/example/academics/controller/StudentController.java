package com.example.academics.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.academics.model.AcademicRequest;
import com.example.academics.model.RequestStatus;
import com.example.academics.model.User;
import com.example.academics.repository.AcademicRequestRepository;
import com.example.academics.repository.UserRepository;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private AcademicRequestRepository requestRepo;

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {

        User student = userRepo.findByEmail(principal.getName());

        model.addAttribute("username", student.getName());
        model.addAttribute("requests", requestRepo.findAll());

        return "student/dashboard";
    }

    @PostMapping("/submit")
    public String submitRequest(@RequestParam String reason,
                                Principal principal) {

        User student = userRepo.findByEmail(principal.getName());

        AcademicRequest req = new AcademicRequest();
        req.setReason(reason);
        req.setStatus(RequestStatus.PENDING);
        req.setStudent(student);

        requestRepo.save(req);

        return "redirect:/student/dashboard";
    }
}
