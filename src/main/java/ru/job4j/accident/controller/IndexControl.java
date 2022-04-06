package ru.job4j.accident.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.accident.model.Accident;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexControl {
    @GetMapping("/")
    public String index(Model model) {

        List<Accident> list = new ArrayList<>();

        Accident ac1 = new Accident();
        ac1.setId(1);
        ac1.setName("first");
        ac1.setText("first accident");
        ac1.setAddress("address 1");

        Accident ac2 = new Accident();
        ac2.setId(2);
        ac2.setName("second");
        ac2.setText("second accident");
        ac2.setAddress("address 2");

        Accident ac3 = new Accident();
        ac3.setId(3);
        ac3.setName("third");
        ac3.setText("third accident");
        ac3.setAddress("address 3");

        list.add(ac1);
        list.add(ac2);
        list.add(ac3);

        model.addAttribute("accidents", list);
        return "index";
    }
}
