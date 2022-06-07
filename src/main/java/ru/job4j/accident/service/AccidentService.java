package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.model.Rule;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccidentService {

    private final AccidentMem repo;

    public AccidentService(AccidentMem repo) {
        this.repo = repo;
    }

    public Accident getAccById(int id) {
        return repo.getAccById(id);
    }

    public Collection<Accident> getAccidents() {
        return repo.getAccidents();
    }
    public Collection<AccidentType> getAccidentTypes() {
        return repo.getAccidentTypes();
    }

    public Collection<Rule> getRules() {
        return repo.getRules();
    }

    public void save(Accident accident, String[] ids) {
        Set<Rule> rules = new HashSet<>();
        for (String id : ids) {
            rules.add(repo.getRuleById(Integer.parseInt(id)));
        }
        accident.setType(repo.getAccidentTypeById(accident.getType().getId()));
        accident.setRules(rules);
        if (accident.getId() <= 0) {
            repo.add(accident);
        } else {
            repo.edit(accident);
        }
    }
}
