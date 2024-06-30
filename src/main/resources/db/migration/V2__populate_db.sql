INSERT INTO client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('PLU', 'Pluto'),
    ('MER', 'Mercury'),
    ('SAT', 'Saturn');

INSERT INTO ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VEN'),
    (2, 'PLU', 'MARS'),
    (3, 'VEN', 'MER'),
    (4, 'SAT', 'VEN'),
    (5, 'MARS', 'PLU'),
    (6, 'MARS', 'SAT'),
    (7, 'VEN', 'PLU'),
    (8, 'MER', 'SAT'),
    (9, 'PLU', 'MARS'),
    (10, 'SAT', 'MER');