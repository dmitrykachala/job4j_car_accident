package ru.job4j.accidents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;
import ru.job4j.accidents.repository.AccidentJdbcTemplate;
import ru.job4j.accidents.repository.AccidentMem;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class AccidentService {

    private final AccidentJdbcTemplate accidentsRepostiory;

    public Accident getAccById(int id) {
        return accidentsRepostiory.getAccById(id);
    }

    public Collection<Accident> getAccidents() {
        return accidentsRepostiory.getAccidents();
    }

    public Collection<AccidentType> getAccidentTypes() {
        return accidentsRepostiory.getAccidentTypes();
    }

    public Collection<Rule> getRules() {
        return accidentsRepostiory.getRules();
    }

    public void save(Accident accident, String[] ids) {
        Set<Rule> rules = new HashSet<>();
        for (String id : ids) {
            rules.add(accidentsRepostiory.getRuleById(Integer.parseInt(id)));
        }
        accident.setType(accidentsRepostiory.getAccidentTypeById(accident.getType().getId()));
        accident.setRules(rules);
        if (accident.getId() <= 0) {
            accidentsRepostiory.add(accident);
        } else {
            accidentsRepostiory.edit(accident);
        }
    }

    public void create(Accident accident) {
        accidentsRepostiory.add(accident);
    }
}
