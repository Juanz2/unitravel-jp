---------------------Usuarios--------------------
insert into usuario values ("1094975931", "marta@email.com", "Marta Wayne", "1094969178");
insert into usuario values ("1094969178", "pepe@email.com", "Pepe Perez", "654");
insert into usuario values ("89004116", "pedro@email.com", "Pedro Martinez", "342");

---------------------Usuarios telefonos----------------

INSERT INTO USUARIO_TELEFONO VALUES ("1094975931", "8172281123");
INSERT INTO USUARIO_TELEFONO VALUES ("1094969178", "3182762734");
INSERT INTO USUARIO_TELEFONO VALUES ("89004116", "3128716334");

---------------------Camas--------------------
INSERT INTO cama (codigo, tipo) VALUES (1,"Doble");
INSERT INTO cama (codigo, tipo) VALUES (2,"Cama unica");
INSERT INTO cama (codigo, tipo) VALUES (3,"Cama 3 personas");
INSERT INTO cama (codigo, tipo) VALUES (4,"Cama 2 personas");
INSERT INTO cama (codigo, tipo) VALUES (5,"Cama 4 personas");

---------------------Ciudades--------------------
INSERT INTO ciudad (codigo, nombre) VALUES (1, "Armenia");
INSERT INTO ciudad (codigo, nombre) VALUES (2, "Bogota");
INSERT INTO ciudad (codigo, nombre) VALUES (3, "Cartagena");
INSERT INTO ciudad (codigo, nombre) VALUES (4, "Manizales");
INSERT INTO ciudad (codigo, nombre) VALUES (5, "Pereira");

---------------------Vuelos--------------------
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Avianca", "A", "1");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Viva Air", "A", "3");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("EasyFly", "A", "4");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("LATAM (Colombia)", "A", "3");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Wingo", "A", "1");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Cosmos S.A", "A", "5");

---------------------Sillas--------------------
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A1", "5000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A2", "5000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A3", "5000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B1", "15000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B2", "15000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B3", "15000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C1", "25000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C2", "25000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C3", "25000", "1");

INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A1", "5000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A2", "5000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A3", "5000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B1", "15000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B2", "15000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("B3", "15000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C1", "25000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C2", "25000", "2");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("C3", "25000", "2");

---------------------Hoteles--------------------
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 1","Calle 1 # 24-55", "4", "7467833", "1");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 2","Calle 32 # 66-45", "2", "318278233", "2");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 3","Calle 15 # 23-45", "5", "781633344", "3");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 4","Calle 17 # 17-46", "3", "3109874567", "4");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel Happy","Calle 17 # 17-46", "3", "3109874567", "4");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel Eco","Calle 22 # 34-46", "3", "3109874567", "1");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel Start","Calle 12 # 45-34", "5", "73652344", "4");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel Mocawa","Calle 17 # 76-78", "5", "62827663", "1");

------------------Habitaciones--------------------
INSERT INTO habitacion VALUES (1, 2, 50000,1);
INSERT INTO habitacion VALUES (2, 2, 20000,1);
INSERT INTO habitacion VALUES (3, 2, 15000,2);
INSERT INTO habitacion VALUES (4, 2, 25000,3);
INSERT INTO habitacion VALUES (5, 2, 84000,1);

-------------------cama habitaciones--------------
INSERT INTO cama_habitaciones VALUES (1,1);
INSERT INTO cama_habitaciones VALUES (2,2);
INSERT INTO cama_habitaciones VALUES (3,3);
INSERT INTO cama_habitaciones VALUES (1,4);
INSERT INTO cama_habitaciones VALUES (3,5);

-----------------------Reserva---------------------
INSERT INTO RESERVA VALUES (1, 4, "A", "2022-04-22", "2022-01-01", 500000, "89004116");
INSERT INTO RESERVA VALUES (2, 3, "A", "2022-04-23", "2022-01-11", 300000, "1094975931");
INSERT INTO RESERVA VALUES (3, 2, "A", "2022-04-18", "2022-02-15", 500000, "1094975931");
INSERT INTO RESERVA VALUES (4, 1, "A", "2022-04-12", "2022-02-16", 250000, "1094969178");
INSERT INTO RESERVA VALUES (5, 7, "A", "2022-04-11", "2022-02-20", 500000, "89004116");
INSERT INTO RESERVA VALUES (6, 2, "A", "2022-04-25", "2022-02-12", 190000, "1094969178");
INSERT INTO RESERVA VALUES (7, 1, "A", "2022-04-30", "2022-02-16", 120000, "1094975931");
INSERT INTO RESERVA VALUES (8, 8, "A", "2022-04-12", "2022-02-27", 890111, "89004116");
INSERT INTO RESERVA VALUES (9, 2, "A", "2022-04-12", "2022-01-13", 7452200, "1094969178");
INSERT INTO RESERVA VALUES (10, 2, "A", "2022-02-12", "2022-01-05", 500000, "1094969178");
INSERT INTO RESERVA VALUES (11, 2, "A", "2022-02-15", "2022-01-10", 3290883, "89004116");
INSERT INTO RESERVA VALUES (12, 2, "A", "2022-02-25", "2022-01-30", 1450000, "1094969178");

-----------------------Reserva silla---------------------
INSERT INTO RESERVA_SILLAS VALUES (1, 1);
INSERT INTO RESERVA_SILLAS VALUES (1, 2);
INSERT INTO RESERVA_SILLAS VALUES (1, 3);
INSERT INTO RESERVA_SILLAS VALUES (1, 4);
INSERT INTO RESERVA_SILLAS VALUES (1, 5);
INSERT INTO RESERVA_SILLAS VALUES (1, 6);
INSERT INTO RESERVA_SILLAS VALUES (2, 1);
INSERT INTO RESERVA_SILLAS VALUES (2, 2);
INSERT INTO RESERVA_SILLAS VALUES (2, 3);
INSERT INTO RESERVA_SILLAS VALUES (2, 4);

-------------------Reserva habitaciones-------------------
INSERT INTO RESERVA_HABITACIONES VALUES (1, 5);
INSERT INTO RESERVA_HABITACIONES VALUES (2, 1);
INSERT INTO RESERVA_HABITACIONES VALUES (3, 5);
INSERT INTO RESERVA_HABITACIONES VALUES (4, 2);
INSERT INTO RESERVA_HABITACIONES VALUES (5, 4);
INSERT INTO RESERVA_HABITACIONES VALUES (6, 3);
INSERT INTO RESERVA_HABITACIONES VALUES (7, 1);
INSERT INTO RESERVA_HABITACIONES VALUES (8, 2);

-------------------------Comentarios-----------------------
INSERT INTO COMENTARIO VALUES (1, "5", "Es un buen hotel","2022-01-01", "1094975931");
INSERT INTO COMENTARIO VALUES (2, "4", "Buena atención","2022-01-20", "1094975931");
INSERT INTO COMENTARIO VALUES (3, "3", "No me gustó la comida","2022-01-15", "89004116");
INSERT INTO COMENTARIO VALUES (4, "5", "Excelente la atención","2022-01-11", "1094969178");


----------------------Comentario hoteles---------------------

INSERT INTO COMENTARIO_HOTELES VALUES (1, 1);
INSERT INTO COMENTARIO_HOTELES VALUES (2, 2);
INSERT INTO COMENTARIO_HOTELES VALUES (3, 3);
INSERT INTO COMENTARIO_HOTELES VALUES (4, 4);

