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
