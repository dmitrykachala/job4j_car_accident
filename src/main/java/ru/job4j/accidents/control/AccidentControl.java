package ru.job4j.accidents.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.service.AccidentService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccidentControl {

    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", service.getAccidents());
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {

        model.addAttribute("types", service.getAccidentTypes());

        model.addAttribute("rules", service.getRules());

        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {

        String[] ids = req.getParameterValues("rIds");

        service.save(accident, ids);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {

        model.addAttribute("types", service.getAccidentTypes());
        model.addAttribute("accident", service.getAccById(id));
        model.addAttribute("rules", service.getRules());
        return "accident/edit";
    }
}
