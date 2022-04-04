---------------------Usuarios--------------------
insert into usuario values ("234", "marta@email.com", "Marta Wayne", "345");
insert into usuario values ("345", "pepe@email.com", "Pepe Perez", "654");
insert into usuario values ("456", "pedro@email.com", "Pedro Martinez", "342");

---------------------Camas--------------------
INSERT INTO cama (tipo) VALUES ("Doble");
INSERT INTO cama (tipo) VALUES ("Cama unica");
INSERT INTO cama (tipo) VALUES ("Cama 3 personas");

---------------------Ciudades--------------------
INSERT INTO ciudad (nombre) VALUES ("Armenia");
INSERT INTO ciudad (nombre) VALUES ("Bogota");
INSERT INTO ciudad (nombre) VALUES ("Cartagena");
INSERT INTO ciudad (nombre) VALUES ("Manizales");
INSERT INTO ciudad (nombre) VALUES ("Pereira");

---------------------Vuelos--------------------
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Avianca", "A", "1");
INSERT INTO vuelo (aerolinea, estado, ciudad_codigo) VALUES ("Viva Air", "A", "1");

---------------------Sillas--------------------
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A1", "5000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A2", "5000", "1");
INSERT INTO silla (posicion, precio, vuelo_codigo) VALUES ("A3", "5000", "1");

---------------------Hoteles--------------------
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 1","Calle 1 # 24-55", "4", "23343234", "1");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 2","Calle 32 # 66-45", "2", "23343234", "1");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 3","Calle 15 # 23-45", "5", "23343234", "1");
INSERT INTO hotel (nombre, direccion, numero_estrellas, telefono, ciudad_codigo) VALUES ("Hotel 4","Calle 17 # 17-46", "7", "23343234", "1");