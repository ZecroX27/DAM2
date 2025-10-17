-- --------------------------------------------------------
-- Estructura de taula per a la taula `articulos`
-- 

DROP TABLE IF EXISTS "articulos" CASCADE;
CREATE TABLE "articulos" (
  "id" SERIAL NOT NULL,
  "nombre" varchar(30) NOT NULL DEFAULT '',
  "precio" float NOT NULL DEFAULT 0,
  "codigo" varchar(7) NOT NULL DEFAULT '',
  "grupo" int NOT NULL DEFAULT 0,
  PRIMARY KEY ("id")
);

CREATE INDEX ON "articulos" ("grupo");

-- 
-- Volcar la base de dades per a la taula `articulos`
-- 

INSERT INTO "articulos" ("id", "nombre", "precio", "codigo", "grupo") VALUES 
(1, 'Monitor 16', 178, 'mon16', 1),
(2, 'Monitor 20', 200, 'mon20', 1),
(3, 'Monitor 22', 220, 'mon22', 1),
(4, 'Motherboard FX', 99, 'mthFX', 1),
(5, 'Papel A4-500', 5, 'PA4500', 2),
(6, 'Diskettes 10', 4, 'D10', 2),
(7, 'Diskettes 20', 8, 'D20', 2);

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `clientes`
-- 

DROP TABLE IF EXISTS "clientes" CASCADE;
CREATE TABLE "clientes" (
  "id" SERIAL NOT NULL,
  "nombre" varchar(60) NOT NULL DEFAULT '',
  "direccion" varchar(80) DEFAULT NULL,
  PRIMARY KEY ("id")
);

-- 
-- Volcar la base de dades per a la taula `clientes`
-- 

INSERT INTO "clientes" ("id", "nombre", "direccion") VALUES 
(1, 'Matt Design', NULL),
(2, 'Diana Perez', 'Brito del Pino 1120'),
(3, 'John Smith', 'Zum Felde 2024');

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `facturas`
-- 

DROP TABLE IF EXISTS "facturas" CASCADE;
CREATE TABLE "facturas" (
  "id" SERIAL NOT NULL,
  "serie" char(1) NOT NULL DEFAULT '',
  "numero" int NOT NULL DEFAULT 0,
  "fecha" date DEFAULT NULL,
  "cliente" int NOT NULL DEFAULT 0,
  "vendedor" int NOT NULL,
  PRIMARY KEY ("id")
);

CREATE INDEX ON "facturas" ("cliente");
CREATE INDEX ON "facturas" ("vendedor");

-- 
-- Volcar la base de dades per a la taula `factures`
-- 

INSERT INTO "facturas" ("id", "serie", "numero", "fecha", "cliente", "vendedor") VALUES 
(1, 'A', 1020, '2007-03-18', 1, 1),
(2, 'A', 1022, '2007-03-18', 2, 2),
(3, 'A', 1025, '2007-04-20', 3, 1),
(4, 'A', 1020, '2007-03-18', 1, 1);

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `grupos`
-- 

DROP TABLE IF EXISTS "grupos" CASCADE;
CREATE TABLE "grupos" (
  "id" SERIAL NOT NULL,
  "descripcion" varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY ("id")
);

-- 
-- Volcar la base de dades per a la taula `grups`
-- 

INSERT INTO "grupos" ("id", "descripcion") VALUES 
(1, 'Hardware'),
(2, 'Suministros');

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `lineas_factura`
-- 

DROP TABLE IF EXISTS "lineas_factura" CASCADE;
CREATE TABLE "lineas_factura" (
  "id" SERIAL NOT NULL,
  "factura" int NOT NULL DEFAULT 0,
  "importe" float NOT NULL DEFAULT 0,
  "articulo" int NOT NULL,
  "cantidad" int NOT NULL,
  "fecha" date NOT NULL DEFAULT '1970-01-01',
  "sucursal" int NOT NULL DEFAULT 0,
  PRIMARY KEY ("id")
);

CREATE INDEX ON "lineas_factura" ("sucursal");
CREATE INDEX ON "lineas_factura" ("articulo");
CREATE INDEX ON "lineas_factura" ("factura");

-- 
-- Volcar la base de dades per a la taula `lineas_factura`
-- 

INSERT INTO "lineas_factura" ("id", "factura", "importe", "articulo", "cantidad", "fecha", "sucursal") VALUES 
(1, 1, 178, 1, 1, '2007-03-14', 1),
(2, 1, 200, 2, 1, '2007-03-14', 1),
(3, 1, 220, 3, 1, '2007-03-14', 1),
(4, 2, 199, 4, 2, '2007-03-18', 2),
(5, 3, 22, 5, 4, '2007-04-20', 1),
(6, 1, 99, 1, 1, '2007-03-18', 1);

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `sucursales`
-- 

DROP TABLE IF EXISTS "sucursales" CASCADE;
CREATE TABLE "sucursales" (
  "id" SERIAL NOT NULL,
  "descripcion" varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY ("id")
);

-- 
-- Volcar la base de dades per a la taula `sucursals`
-- 

INSERT INTO "sucursales" ("id", "descripcion") VALUES 
(1, 'Centro'),
(2, 'Unión'),
(3, 'Malvín');

-- --------------------------------------------------------

-- 
-- Estructura de taula per a la taula `vendedores`
-- 

DROP TABLE IF EXISTS "vendedores" CASCADE;
CREATE TABLE "vendedores" (
  "id" SERIAL NOT NULL,
  "nombre" varchar(50) NOT NULL DEFAULT '',
  "fecha_ingreso" date NOT NULL DEFAULT '1970-01-01',
  "salario" float NOT NULL DEFAULT 0,
  PRIMARY KEY ("id")
);

-- 
-- Volcar la base de dades per a la taula `vendedors`
-- 

INSERT INTO "vendedores" ("id", "nombre", "fecha_ingreso", "salario") VALUES 
(1, 'Carlos Zaltzman', '2007-01-01', 12000),
(2, 'Juan Fernández', '2007-01-01', 12000);

-- --------------------------------------------------------

-- 
-- Restriccions per a la taula `articulos`
-- 
ALTER TABLE "articulos"
  ADD CONSTRAINT "articulos_ibfk_1" FOREIGN KEY ("grupo") REFERENCES "grupos" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Restriccions per a la taula `facturas`
-- 
ALTER TABLE "facturas"
  ADD CONSTRAINT "facturas_ibfk_4" FOREIGN KEY ("vendedor") REFERENCES "vendedores" ("id") ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT "facturas_ibfk_3" FOREIGN KEY ("cliente") REFERENCES "clientes" ("id") ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Restriccions per a la taula `lineas_factura`
-- 
ALTER TABLE "lineas_factura"
  ADD CONSTRAINT "lineas_factura_ibfk_6" FOREIGN KEY ("sucursal") REFERENCES "sucursales" ("id") ON UPDATE CASCADE,
  ADD CONSTRAINT "lineas_factura_ibfk_4" FOREIGN KEY ("factura") REFERENCES "facturas" ("id") ON UPDATE CASCADE,
  ADD CONSTRAINT "lineas_factura_ibfk_5" FOREIGN KEY ("articulo") REFERENCES "articulos" ("id");