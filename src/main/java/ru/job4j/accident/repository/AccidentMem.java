package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {

    private HashMap<Integer, Accident> accidents = new HashMap<>();
    private AtomicInteger id = new AtomicInteger(1);

    public AccidentMem() {

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

    public Accident getAccById(int id) {
        return accidents.get(id);
    }

    public Collection<Accident> getAccidents() {
        return accidents.values();
    }

    public void edit(Accident accident) {
        accidents.replace(accident.getId(), accident);
    }
}
