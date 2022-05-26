package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
import ru.job4j.accident.model.AccidentType;
import ru.job4j.accident.repository.AccidentMem;

import java.util.Collection;

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

    public void save(Accident accident) {
        accident.setType(repo.getAccidentTypeById(accident.getType().getId()));
        if (accident.getId() <= 0) {
            repo.add(accident);
        } else {
            repo.edit(accident);
        }
    }
}
