CREATE TABLE accidents (
                           id serial primary key,
                           name text,
                           text text,
                           address text,
                           accidentType_id       int references accidentType(id),
);