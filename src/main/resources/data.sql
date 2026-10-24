-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('ola@student.merito.pl',   'Ola',   'USER',    current_timestamp),
    ('kuba@student.merito.pl',  'Kuba',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
insert into user_account (email, display_name, role, created_at) values
    ('s816612@student.wroclaw.merito.pl', 'Jakub Wiśniewski', 'USER',    current_timestamp),
    ('s617916@student.wroclaw.merito.pl', 'Piotr Śpiewak',    'USER',    current_timestamp),
    ('trener@example.com',                'Trener',           'PARTNER', current_timestamp);

-- ===== LAB 02 · trainer =====
insert into trainer (first_name, last_name, email, specialization, hourly_rate, active) values
    ('Marta', 'Zielińska', 'marta.zielinska@example.com', 'joga i stretching',    90.00, true),
    ('Paweł', 'Krawczyk',  'pawel.krawczyk@example.com',  'crossfit i siłownia', 110.00, true),
    ('Agata', 'Nowicka',   'agata.nowicka@example.com',   'zumba i pilates',      85.50, false);

-- ===== LAB 02 · fitness_class =====
insert into fitness_class (name, category, starts_at, duration_minutes, capacity, room) values
    ('Poranna joga',        'YOGA',     '2026-11-02 07:30:00', 60, 15, 'Sala A'),
    ('Pilates dla każdego', 'PILATES',  '2026-11-02 18:00:00', 55, 12, 'Sala B'),
    ('CrossFit WOD',        'CROSSFIT', '2026-11-03 19:00:00', 45, 10, 'Strefa funkcjonalna'),
    ('Zumba party',         'ZUMBA',    '2026-11-04 18:30:00', 60, 20, 'Sala A');

-- ===== LAB 02 · club_member =====
insert into club_member (first_name, last_name, phone, membership_type, joined_on, street, city, postal_code) values
    ('Katarzyna', 'Mazur',       '601234567', 'MONTHLY', '2026-09-01', 'Legnicka 15/3', 'Wrocław', '53-671'),
    ('Tomasz',    'Lewandowski', null,        'STUDENT', '2026-10-05', 'Grunwaldzka 8', 'Wrocław', '50-357'),
    ('Ewa',       'Dąbrowska',   '698765432', 'OPEN',    '2026-10-20', null,            null,      null);
