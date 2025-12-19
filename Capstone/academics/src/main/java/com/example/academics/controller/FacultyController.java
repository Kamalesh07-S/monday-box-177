package com.example.academics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.academics.model.AcademicRequest;
import com.example.academics.model.RequestStatus;
import com.example.academics.repository.AcademicRequestRepository;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private AcademicRequestRepository requestRepo;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("requests", requestRepo.findAll());
        return "faculty/dashboard";
    }

    @PostMapping("/action")
    public String takeAction(@RequestParam Long id,
                             @RequestParam String decision) {

        AcademicRequest req = requestRepo.findById(id).orElse(null);

        if (req != null && req.getStatus() == RequestStatus.PENDING) {
            req.setStatus(RequestStatus.valueOf(decision));
            requestRepo.save(req);
        }

        return "redirect:/faculty/dashboard";
    }
}
