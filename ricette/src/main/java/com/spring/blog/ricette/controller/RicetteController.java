package com.spring.blog.ricette.controller;

import com.spring.blog.ricette.model.Ricette;
import com.spring.blog.ricette.repository.RicetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping
public class RicetteController {
    @Autowired
    private RicetteRepository ricetteRepository;
    @GetMapping
    public String index (Model model){
        List<Ricette> ricette = ricetteRepository.findAll();
        model.addAttribute("ricetteList", ricette);
        return "index";
    }

}
