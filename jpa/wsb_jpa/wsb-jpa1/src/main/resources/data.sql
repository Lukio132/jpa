insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030'),
                   (2, 'xxx', 'yyy', 'city2', '62-031'),
                   (3, 'xxxx', 'yyyy', 'city3', '62-032'),
                   (4, 'xxxx', 'yyyy', 'city4', '62-033');

insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
            values (1, 'Jan', 'Kowal', '4891357829', 'jan@kowal.pl', '123', 'OCULIST', 1);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, height)
            values (1, 'Jan', 'Nowak', '421753213', 'jan@nowak.pl', '123', '2015-01-13', 4, 175.2);

insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'goraczka', '2022-02-01T13:45:10', 1, 1),
                   (2, 'goraczka', '2023-02-01T13:45:10', 1, 1);

insert into medical_treatment (id, description, type, visit_id)
            values (1, 'przepisano leki', 'RTG', 1);


insert into doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id)
        values (2, 'Zbigniew', 'Zbigowski', '4891357829', 'zb@ski.pl', '12356', 'OCULIST', 2);

insert into patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, height)
            values (2, 'Tomek', 'Kowal', '333127552', 'tomek@kowal.pl', '1234', '2012-02-22', 3, 156.4);

insert into visit (id, description, time, doctor_id, patient_id)
            values (3, 'przeziebienie', '2023-02-05T23:20:10', 2, 2),
             (4, 'przeziebienie', '2023-02-05T23:20:10', 1, 1);