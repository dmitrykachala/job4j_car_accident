package ru.job4j.accidents.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.job4j.accidents.model.Accident;
import ru.job4j.accidents.model.AccidentType;
import ru.job4j.accidents.model.Rule;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
@AllArgsConstructor
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    private AtomicInteger id = new AtomicInteger(1);

    private AtomicInteger idType = new AtomicInteger(1);

    private AtomicInteger idRule = new AtomicInteger(1);

    public Accident add(Accident accident) {
        jdbc.update("insert into accidents (name) values (?)",
                accident.getName());
        return accident;
    }

    public List<Accident> getAccidents() {
        return jdbc.query("select id, name from accidents",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                });
    }

    public AccidentType add(AccidentType accidentType) {
        jdbc.update("insert into accidentTypes (name) values (?)",
                accidentType.getName());
        return accidentType;
    }

    public Rule add(Rule rule) {
        jdbc.update("insert into rules (name) values (?)",
                rule.getName());
        return rule;
    }

    public Accident getAccById(int id) {
        return jdbc.queryForObject("select id, name from accidents where id = ?",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    return accident;
                },
                id);
    }

    public Collection<AccidentType> getAccidentTypes() {

        return jdbc.query("select id, name from accidentTypes",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                });
    }

    public Collection<Rule> getRules() {

        return jdbc.query("select id, name from rules",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    public void edit(Accident accident) {

        jdbc.update(
                "update accidents set name = ? where id = ?",
                "Banjo", accident.getId());
    }

    public AccidentType getAccidentTypeById(int id) {

        return jdbc.queryForObject("select id, name from accidentTypes where id = ?",
                (rs, row) -> {
                    AccidentType accidentType = new AccidentType();
                    accidentType.setId(rs.getInt("id"));
                    accidentType.setName(rs.getString("name"));
                    return accidentType;
                },
                id);
    }

    public Rule getRuleById(int id) {

        return jdbc.queryForObject("select id, name from rules where id = ?",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                },
                id);
    }
}
