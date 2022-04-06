package ru.job4j.accident.service;

import org.springframework.stereotype.Service;
import ru.job4j.accident.model.Accident;
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

}
