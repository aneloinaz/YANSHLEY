Create database UsusrbilTex_DB;
use UsusrbilTex_DB;

create table Categoria(
ID_categoria int primary key,
nombre varchar (100),
descripcion varchar (250)
);

create table Producto (
ID_producto int primary key,
nombre varchar (100),
descripcion varchar (250),
precio float,
stock int,
fecha_creacion date,
imagen varchar (80),
ID_categoria int
);
ALTER TABLE Producto MODIFY COLUMN fecha_creacion datetime;
alter table Producto modify column imagen varchar (250);


create table Pedido (
ID_pedido int primary key,
fecha_pedido date,
monto_total float,
estado varchar (100),
ID_usuario int
);
ALTER TABLE Pedido MODIFY COLUMN fecha_pedido datetime;


create table Usuario(
ID_usuario int primary key,
DNI varchar (10),
nombre_usuario varchar(100),
correo_electronico varchar(150),
pass varchar (50),
telf int,
direccion varchar (150),
nombre_completo varchar (100),
fecha_registro date
);
alter table Usuario modify column pass varchar (250);
create table Detalle_pedido(
ID_detalle int,
ID_producto int,
ID_pedido int,
precio float,
cantidad int
);

SET FOREIGN_KEY_CHECKS = 0;
SET FOREIGN_KEY_CHECKS = 1;

truncate table Detalle_pedido;

alter table Usuario add rol varchar (15);
alter table Pedido add foreign key Pedido (ID_usuario) references Usuario (ID_usuario) on delete cascade on update cascade;
alter table Detalle_pedido add foreign key Detalle_pedido (ID_producto) references Producto (ID_producto) on delete cascade on update cascade;
ALTER TABLE Detalle_pedido 
ADD CONSTRAINT fk_detalle_pedido 
FOREIGN KEY (ID_pedido) REFERENCES Pedido (ID_pedido) 
ON DELETE CASCADE ON UPDATE CASCADE;
alter table Producto add foreign key Producto (ID_categoria) references Categoria (ID_categoria) on delete cascade on update cascade;

INSERT INTO `categoria` (`id_categoria`, `nombre`, `descripcion`) VALUES
(1, 'Pantalones', 'Variedad de pantalones para todas las ocasiones'),
(2, 'Sudaderas', 'Sudaderas cómodas y con estilo'),
(3, 'Camisetas', 'Camisetas de diferentes colores y estilos'),
(4, 'Camisas', 'Camisas formales e informales'),
(5, 'Chaquetas', 'Chaquetas para todas las estaciones');




--
-- consultas 

SELECT SUM(monto_total) AS ganancias_total
FROM Pedido;

select nombre, stock
from Producto
where stock < 5;

