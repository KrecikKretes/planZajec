CREATE TABLE grupy (
                         id INTEGER PRIMARY KEY NOT NULL,
                         grupa varchar(4) NOT NULL
);

CREATE TABLE grupy_grup (
                              id INTEGER PRIMARY KEY NOT NULL,
                              grupa_grupy varchar(255) DEFAULT NULL,
                              grupy_id INTEGER DEFAULT NULL,
                              FOREIGN KEY (grupy_id) REFERENCES grupy(id)
);

CREATE TABLE sale (
                        id INTEGER PRIMARY KEY NOT NULL,
                        sala varchar(10) NOT NULL,
                        id_strony INTEGER NOT NULL
);

CREATE TABLE wykladowcy (
                              id INTEGER PRIMARY KEY NOT NULL,
                              nazwisko varchar(50) NOT NULL,
                              skrot varchar(4) NOT NULL,
                              id_strony INTEGER NOT NULL
);

CREATE TABLE zajecia (
                           id INTEGER PRIMARY KEY NOT NULL,
                           nazwa varchar(50) NOT NULL
);

CREATE TABLE plan (
                      id INTEGER PRIMARY KEY NOT NULL,
                      dzien varchar(255) DEFAULT NULL,
                      godz varchar(255) DEFAULT NULL,
                      tydzien varchar(255) DEFAULT NULL,
                      id_grupy_grup INTEGER DEFAULT NULL,
                      id_sale INTEGER DEFAULT NULL,
                      id_wykladowcy INTEGER DEFAULT NULL,
                      id_zajecia INTEGER DEFAULT NULL,
                      FOREIGN KEY (id_wykladowcy) REFERENCES wykladowcy(id),
                      FOREIGN KEY (id_grupy_grup) REFERENCES grupy_grup (id),
                      FOREIGN KEY (id_sale) REFERENCES sale(id)
);

