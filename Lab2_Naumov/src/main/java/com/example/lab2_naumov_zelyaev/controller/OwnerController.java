package com.example.lab2_naumov_zelyaev.controller;
import com.example.lab2_naumov_zelyaev.model.Owner;
import com.example.lab2_naumov_zelyaev.repository.OwnerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/owner")
public class OwnerController {
    final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("owners", ownerRepository.findAll());
        return "owners";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Owner> getAllBooks(){
        return ownerRepository.findAll();
    }
    @GetMapping("/add")
    public String addOwner(Model model){
        model.addAttribute("owner", new Owner());
        return "addOwner";
    }
    @PostMapping("/add")
    public String insertOwner(@ModelAttribute("owner") Owner owner, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/error";
        }
        ownerRepository.save(owner);
        return "redirect:/owner";
    }
    @GetMapping("/edit")
    public String editOwner(@RequestParam Long ownerID, Model model){
        Optional<Owner> optionalOwner= ownerRepository.findById(ownerID);
        if (optionalOwner.isPresent())
            model.addAttribute("owner",optionalOwner.get());
        else
            throw new RuntimeException("Owner not found. Id = " + ownerID);
        return "editOwner";

    }
    @PostMapping("/edit")
    public String updateOwner(@ModelAttribute("owner") Owner owner, BindingResult bindingResult){
        if (!bindingResult.hasErrors())
            ownerRepository.save(owner);
        return "redirect:/owner";
    }

    @GetMapping("/remove")
    public String deleteOwner(@RequestParam Long ownerId){
        ownerRepository.deleteById(ownerId);
        return "redirect:/owner";
    }
}
