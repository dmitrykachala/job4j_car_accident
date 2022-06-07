package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private Map<Integer, Accident> accidents = new HashMap<>();

    private Map<Integer, AccidentType> accidentTypes = new HashMap<>();

    private Map<Integer, Rule> rules = new HashMap<>();

    private AtomicInteger id = new AtomicInteger(1);

    private AtomicInteger idType = new AtomicInteger(1);

    private AtomicInteger idRule = new AtomicInteger(1);

    public AccidentMem() {

        add(AccidentType.of(1, "Две машины"));
        add(AccidentType.of(2, "Машина и человек"));
        add(AccidentType.of(3, "Машина и велосипед"));

        add(Rule.of(1, "Статья 1"));
        add(Rule.of(2, "Статья 2"));
        add(Rule.of(3, "Статья 3"));

        Accident ac1 = new Accident();
        ac1.setName("first");
        ac1.setText("first accident");
        ac1.setAddress("address 1");

        Accident ac2 = new Accident();
        ac2.setName("second");
        ac2.setText("second accident");
        ac2.setAddress("address 2");

        Accident ac3 = new Accident();
        ac3.setName("third");
        ac3.setText("third accident");
        ac3.setAddress("address 3");

        add(ac1);
        add(ac2);
        add(ac3);

    }

    public void add(Accident accident) {
        accident.setId(id.getAndIncrement());
        accidents.put(accident.getId(), accident);
    }

    public void add(AccidentType accidentType) {
        accidentType.setId(idType.getAndIncrement());
        accidentTypes.put(accidentType.getId(), accidentType);
    }

    public void add(Rule rule) {
        rule.setId(idRule.getAndIncrement());
        rules.put(rule.getId(), rule);
    }

    public Accident getAccById(int id) {
        return accidents.get(id);
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public Collection<AccidentType> getAccidentTypes() {
        return accidentTypes.values();
    }

    public Collection<Rule> getRules() {
        return rules.values();
    }

    public void edit(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }

    public AccidentType getAccidentTypeById(int id) {
        return accidentTypes.get(id);
    }

    public Rule getRuleById(int id) {
        return rules.get(id);
    }
}
