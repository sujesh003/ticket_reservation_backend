SET
IDENTITY_INSERT ticket ON;
INSERT INTO ticket (id, description, payment, price, reserved)
VALUES ('1', 'Movie Ticket', 0, 230.0, 0),
       ('2', 'Flight Ticket', 0, 45000, 0),
       ('3', 'Heli Ticket', 0, 175000, 0);

SET
IDENTITY_INSERT product_mode OFF;
