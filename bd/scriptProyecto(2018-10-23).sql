-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.32-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para quotevent
DROP DATABASE IF EXISTS `quotevent`;
CREATE DATABASE IF NOT EXISTS `quotevent` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `quotevent`;

-- Volcando estructura para tabla quotevent.ciudad
DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE IF NOT EXISTS `ciudad` (
  `id_ciudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.ciudad: ~2 rows (aproximadamente)
DELETE FROM `ciudad`;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`id_ciudad`, `nombre`) VALUES
	(1, 'Bogotá'),
	(2, 'Medellin');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.clasificacion
DROP TABLE IF EXISTS `clasificacion`;
CREATE TABLE IF NOT EXISTS `clasificacion` (
  `id_clasificacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_clasificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.clasificacion: ~2 rows (aproximadamente)
DELETE FROM `clasificacion`;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` (`id_clasificacion`, `nombre`) VALUES
	(1, 'Familiar'),
	(2, 'Corporativo');
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `n_identificacion` bigint(20) NOT NULL,
  `tipo_documento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `ciudad` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`n_identificacion`),
  KEY `FK_cliente_tipo_documento` (`tipo_documento`),
  KEY `FK_cliente_ciudad` (`ciudad`),
  CONSTRAINT `FK_cliente_ciudad` FOREIGN KEY (`ciudad`) REFERENCES `ciudad` (`id_ciudad`),
  CONSTRAINT `FK_cliente_tipo_documento` FOREIGN KEY (`tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.cliente: ~2 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`n_identificacion`, `tipo_documento`, `nombre`, `apellido`, `telefono`, `celular`, `direccion`, `ciudad`, `correo`, `estado`) VALUES
	(11111111, 1, 'Andres', 'Parra', '567890', '3154990765', 'cra 90 g bis No. 43 - 48 s', 1, 'caparra95@misena.edu.co', 'Activo'),
	(1030654523, 1, 'Andres', 'Parra', '567890', '3154990765', 'cra 90 g bis No. 43 - 48 s', 1, 'caparra95@misena.edu.co', 'Activo');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_empleado
DROP TABLE IF EXISTS `detalle_empleado`;
CREATE TABLE IF NOT EXISTS `detalle_empleado` (
  `detalle_empleado` int(11) NOT NULL AUTO_INCREMENT,
  `evento_id_evento` int(11) NOT NULL,
  `empleado_n_identificacion` bigint(20) NOT NULL,
  `calificacion` float NOT NULL,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`detalle_empleado`),
  KEY `FK_detalle_evento_evento` (`evento_id_evento`),
  KEY `FK_detalle_evento_empleado` (`empleado_n_identificacion`),
  CONSTRAINT `FK_detalle_evento_empleado` FOREIGN KEY (`empleado_n_identificacion`) REFERENCES `empleado` (`n_identificacion`),
  CONSTRAINT `FK_detalle_evento_evento` FOREIGN KEY (`evento_id_evento`) REFERENCES `evento` (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_empleado: ~0 rows (aproximadamente)
DELETE FROM `detalle_empleado`;
/*!40000 ALTER TABLE `detalle_empleado` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_empleado` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_paquete_producto
DROP TABLE IF EXISTS `detalle_paquete_producto`;
CREATE TABLE IF NOT EXISTS `detalle_paquete_producto` (
  `id_detalle_paquete_producto` int(11) NOT NULL AUTO_INCREMENT,
  `id_paquete` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_paquete_producto`),
  KEY `id_paquete` (`id_paquete`),
  KEY `id_producto` (`id_producto`),
  CONSTRAINT `FK_detalle_paquete_paquete` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id_paquete`),
  CONSTRAINT `FK_detalle_paquete_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_paquete_producto: ~14 rows (aproximadamente)
DELETE FROM `detalle_paquete_producto`;
/*!40000 ALTER TABLE `detalle_paquete_producto` DISABLE KEYS */;
INSERT INTO `detalle_paquete_producto` (`id_detalle_paquete_producto`, `id_paquete`, `id_producto`, `cantidad`, `estado`) VALUES
	(1, 5, 22, 5, 'Activo'),
	(2, 6, 23, 5, 'Activo'),
	(6, 9, 22, 5, 'Activo'),
	(7, 9, 23, 5, 'Activo'),
	(8, 10, 22, 5, 'Activo'),
	(9, 10, 23, 5, 'Activo'),
	(10, 11, 25, 5, 'Activo'),
	(11, 11, 24, 5, 'Activo'),
	(12, 12, 27, 5, 'Activo'),
	(13, 12, 27, 5, 'Activo'),
	(14, 12, 27, 5, 'Activo'),
	(15, 12, 27, 5, 'Activo'),
	(16, 12, 27, 5, 'Activo'),
	(17, 12, 27, 5, 'Activo'),
	(18, 12, 27, 5, 'Activo'),
	(19, 12, 27, 5, 'Activo');
/*!40000 ALTER TABLE `detalle_paquete_producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_producto_suministro
DROP TABLE IF EXISTS `detalle_producto_suministro`;
CREATE TABLE IF NOT EXISTS `detalle_producto_suministro` (
  `id_detalle_producto_suministro` int(11) NOT NULL AUTO_INCREMENT,
  `id_producto` int(11) DEFAULT NULL,
  `id_suministro` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_producto_suministro`),
  KEY `id_producto` (`id_producto`),
  KEY `id_ingrediente` (`id_suministro`),
  CONSTRAINT `FK_detalle_producto_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `FK_detalle_producto_suministro` FOREIGN KEY (`id_suministro`) REFERENCES `suministro` (`id_suministro`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_producto_suministro: ~16 rows (aproximadamente)
DELETE FROM `detalle_producto_suministro`;
/*!40000 ALTER TABLE `detalle_producto_suministro` DISABLE KEYS */;
INSERT INTO `detalle_producto_suministro` (`id_detalle_producto_suministro`, `id_producto`, `id_suministro`, `cantidad`, `estado`) VALUES
	(1, 22, 11, 5, 'Activo'),
	(2, 22, 10, 5, 'Activo'),
	(3, 23, 9, 5, 'Activo'),
	(4, 23, 10, 5, 'Activo'),
	(5, 24, 12, 5, 'Activo'),
	(6, 24, 13, 5, 'Activo'),
	(7, 24, 14, 5, 'Activo'),
	(8, 25, 12, 5, 'Activo'),
	(9, 25, 13, 5, 'Activo'),
	(10, 25, 14, 5, 'Activo'),
	(11, 26, 15, 5, 'Activo'),
	(12, 26, 16, 5, 'Activo'),
	(15, 27, 16, 5, 'Activo'),
	(17, 27, 11, 5, 'Activo'),
	(18, 27, 15, 5, 'Activo'),
	(22, 27, 10, 5, 'Activo');
/*!40000 ALTER TABLE `detalle_producto_suministro` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.detalle_proveedor
DROP TABLE IF EXISTS `detalle_proveedor`;
CREATE TABLE IF NOT EXISTS `detalle_proveedor` (
  `id_detalle_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `proveedor_id_proveedor` int(11) NOT NULL,
  `producto_id_ingrediente` int(11) NOT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_detalle_proveedor`),
  KEY `FK_detalle_proveedor_proveedor` (`proveedor_id_proveedor`),
  KEY `FK_detalle_proveedor_ingrediente` (`producto_id_ingrediente`),
  CONSTRAINT `FK_detalle_proveedor_ingrediente` FOREIGN KEY (`producto_id_ingrediente`) REFERENCES `suministro` (`id_suministro`),
  CONSTRAINT `FK_detalle_proveedor_proveedor` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.detalle_proveedor: ~0 rows (aproximadamente)
DELETE FROM `detalle_proveedor`;
/*!40000 ALTER TABLE `detalle_proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.empleado
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `n_identificacion` bigint(20) NOT NULL,
  `id_tipo_documento` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `cargo_id_cargo` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `barrio` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`n_identificacion`),
  KEY `FK_empleado_cargo` (`cargo_id_cargo`),
  KEY `FK_empleado_tipo_documento` (`id_tipo_documento`),
  CONSTRAINT `FK_empleado_cargo` FOREIGN KEY (`cargo_id_cargo`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `FK_empleado_tipo_documento` FOREIGN KEY (`id_tipo_documento`) REFERENCES `tipo_documento` (`id_tipo_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.empleado: ~2 rows (aproximadamente)
DELETE FROM `empleado`;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`n_identificacion`, `id_tipo_documento`, `nombre`, `apellido`, `cargo_id_cargo`, `correo`, `direccion`, `telefono`, `barrio`, `estado`) VALUES
	(1030654523, 1, 'camilo andres', 'ochoa', 1, 'caparra95@misena.edu.co', 'calle 89', '5663241', 'britalia', 'Activo'),
	(343534534534, 1, 'anderson', 'parra', 1, 'caparra', 'calle 22', '545454', 'teusaquillo', 'Activo');
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.estado_evento
DROP TABLE IF EXISTS `estado_evento`;
CREATE TABLE IF NOT EXISTS `estado_evento` (
  `id_estado_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_estado_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.estado_evento: ~4 rows (aproximadamente)
DELETE FROM `estado_evento`;
/*!40000 ALTER TABLE `estado_evento` DISABLE KEYS */;
INSERT INTO `estado_evento` (`id_estado_evento`, `nombre`) VALUES
	(1, 'Aprobado'),
	(2, 'Abonado'),
	(3, 'Cancelado'),
	(4, 'Finalizado');
/*!40000 ALTER TABLE `estado_evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.evento
DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `solicitud_id_solicitud` int(11) NOT NULL DEFAULT '0',
  `cliente_id_cliente` bigint(20) NOT NULL DEFAULT '0',
  `tipo_evento` int(11) NOT NULL DEFAULT '0',
  `id_lugar` int(11) NOT NULL DEFAULT '0',
  `cantidad_personas` int(11) NOT NULL DEFAULT '0',
  `cantidad_meseros` int(11) NOT NULL DEFAULT '0',
  `hora_inicio` time NOT NULL DEFAULT '00:00:00',
  `hora_fin` time NOT NULL DEFAULT '00:00:00',
  `fecha` date NOT NULL,
  `precio` double NOT NULL,
  `observaciones` text,
  `estado_evento` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`),
  KEY `FK_evento_solicitud` (`solicitud_id_solicitud`),
  KEY `FK_evento_cliente` (`cliente_id_cliente`),
  KEY `FK_evento_estado` (`estado_evento`),
  KEY `FK_evento_tipo` (`tipo_evento`),
  KEY `id_lugar` (`id_lugar`),
  CONSTRAINT `FK_evento_cliente` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`n_identificacion`),
  CONSTRAINT `FK_evento_estado` FOREIGN KEY (`estado_evento`) REFERENCES `estado_evento` (`id_estado_evento`),
  CONSTRAINT `FK_evento_lugar` FOREIGN KEY (`id_lugar`) REFERENCES `lugar` (`id_lugar`),
  CONSTRAINT `FK_evento_solicitud` FOREIGN KEY (`solicitud_id_solicitud`) REFERENCES `solicitud` (`id_solicitud`),
  CONSTRAINT `FK_evento_tipo` FOREIGN KEY (`tipo_evento`) REFERENCES `tipo_evento` (`id_tipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.evento: ~9 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`id_evento`, `solicitud_id_solicitud`, `cliente_id_cliente`, `tipo_evento`, `id_lugar`, `cantidad_personas`, `cantidad_meseros`, `hora_inicio`, `hora_fin`, `fecha`, `precio`, `observaciones`, `estado_evento`) VALUES
	(1, 3, 1030654523, 1, 1, 250, 250, '13:21:00', '22:00:00', '2018-10-20', 3500000, 'Evento matrimonial ', 1),
	(2, 3, 1030654523, 1, 1, 250, 23, '16:00:00', '23:00:00', '2018-11-15', 2500000, 'prueba', 4),
	(3, 3, 1030654523, 1, 1, 250, 30, '12:18:00', '23:00:00', '2018-09-28', 2500000, 'pruebaaaa', 4),
	(4, 4, 1030654523, 1, 1, 25, 30, '08:35:00', '23:00:00', '2018-09-29', 4000000, 'prueba evento', 1),
	(5, 3, 1030654523, 1, 1, 250, 25, '11:00:00', '06:00:00', '2018-10-26', 500000, 'prueba', 4),
	(6, 3, 1030654523, 1, 1, 250, 25, '08:09:00', '19:00:00', '2018-10-26', 500000, 'pruebaaaa', 4),
	(7, 3, 1030654523, 1, 1, 250, 20, '06:00:00', '23:00:00', '2018-10-19', 5000000, 'pruebaaaaaaa ', 3),
	(8, 3, 1030654523, 1, 1, 250, 20, '10:00:00', '23:00:00', '2018-10-25', 500000, 'pruebaaaaa', 4),
	(9, 4, 11111111, 1, 1, 10, 4, '19:00:00', '04:00:00', '2018-09-29', 2500000, 'Observaciones Observaciones ', 1);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.lugar
DROP TABLE IF EXISTS `lugar`;
CREATE TABLE IF NOT EXISTS `lugar` (
  `id_lugar` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `cantidad_persona_max` int(11) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `ubicacion` varchar(200) DEFAULT NULL,
  `contacto` varchar(100) DEFAULT NULL,
  `telefono_contacto` varchar(50) DEFAULT NULL,
  `id_ciudad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_lugar`),
  KEY `id_ciudad` (`id_ciudad`),
  CONSTRAINT `FK_lugar_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id_ciudad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.lugar: ~0 rows (aproximadamente)
DELETE FROM `lugar`;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` (`id_lugar`, `nombre`, `descripcion`, `cantidad_persona_max`, `direccion`, `ubicacion`, `contacto`, `telefono_contacto`, `id_ciudad`) VALUES
	(1, 'parque los novios', 'parque tematico', 50, 'calle 63 ', 'Bogotá', 'andres lopez', '45456445', 1);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.medida_producto
DROP TABLE IF EXISTS `medida_producto`;
CREATE TABLE IF NOT EXISTS `medida_producto` (
  `id_medida` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.medida_producto: ~9 rows (aproximadamente)
DELETE FROM `medida_producto`;
/*!40000 ALTER TABLE `medida_producto` DISABLE KEYS */;
INSERT INTO `medida_producto` (`id_medida`, `nombre`) VALUES
	(1, 'kilogramos'),
	(2, 'Libras'),
	(3, 'Botellas'),
	(4, 'Litros'),
	(5, 'Gramos'),
	(6, 'Onzas'),
	(7, 'Porcion'),
	(8, 'Unidades'),
	(9, 'Metros ');
/*!40000 ALTER TABLE `medida_producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.paquete
DROP TABLE IF EXISTS `paquete`;
CREATE TABLE IF NOT EXISTS `paquete` (
  `id_paquete` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `clasificacion` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL DEFAULT '',
  `lugar` int(11) DEFAULT NULL,
  `cantidad_personas` int(11) NOT NULL,
  `precio` double NOT NULL,
  `pdf` varchar(50) NOT NULL,
  `foto` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_paquete`),
  KEY `FK_paquete_clasificacion` (`clasificacion`),
  KEY `lugar` (`lugar`),
  CONSTRAINT `FK_paquete_clasificacion` FOREIGN KEY (`clasificacion`) REFERENCES `clasificacion` (`id_clasificacion`),
  CONSTRAINT `FK_paquete_lugar` FOREIGN KEY (`lugar`) REFERENCES `lugar` (`id_lugar`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.paquete: ~5 rows (aproximadamente)
DELETE FROM `paquete`;
/*!40000 ALTER TABLE `paquete` DISABLE KEYS */;
INSERT INTO `paquete` (`id_paquete`, `nombre`, `clasificacion`, `descripcion`, `lugar`, `cantidad_personas`, `precio`, `pdf`, `foto`, `estado`) VALUES
	(5, 'matrimonio', 1, 'matricidio', 1, 20, 2500000, 'matrimonio.jpg', 'matrimonio.jpg', 'Activo'),
	(6, 'bautizo', 1, 'paquete bautizo', 1, 20, 1500000, 'bautizo.jpg', 'bautizo.jpg', 'Activo'),
	(9, 'cumpleaños', 1, 'cumpleaños', 1, 5, 150000, 'cumpleanos.jpg', 'cumpleanos.jpg', 'Activo'),
	(10, 'cumpleaños', 2, 'dasdasd', 1, 23, 233333, 'cumpleanos.jpg', 'cumpleanos.jpg', 'Activo'),
	(11, 'combo cuero', 1, 'cuero', 1, 20, 130000, 'combo cuero.jpg', 'combo cuero.jpg', 'Activo'),
	(12, 'prueba paque', 2, 'descripcion paquete prueba ', 1, 2000, 6000000, '15 años.jpg', '15 años.jpg', 'Activo');
/*!40000 ALTER TABLE `paquete` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.pedido
DROP TABLE IF EXISTS `pedido`;
CREATE TABLE IF NOT EXISTS `pedido` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `producto_id_producto` int(11) NOT NULL DEFAULT '0',
  `proveedor_id_proveedor` int(11) NOT NULL DEFAULT '0',
  `fecha_pedido` date NOT NULL,
  `cantidad` varchar(20) NOT NULL DEFAULT '0',
  `gramaje` int(11) NOT NULL DEFAULT '0',
  `observaciones` varchar(150) DEFAULT '0',
  `fecha_sugerida` varchar(150) DEFAULT '0',
  `estado` varchar(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_pedido`),
  KEY `FK_pedido_producto` (`producto_id_producto`),
  KEY `FK_pedido_proveedor` (`proveedor_id_proveedor`),
  KEY `FK_gramaje_medida_producto` (`gramaje`),
  CONSTRAINT `FK_gramaje_medida_producto` FOREIGN KEY (`gramaje`) REFERENCES `medida_producto` (`id_medida`),
  CONSTRAINT `FK_pedido_producto` FOREIGN KEY (`producto_id_producto`) REFERENCES `producto` (`id_producto`),
  CONSTRAINT `FK_pedido_proveedor` FOREIGN KEY (`proveedor_id_proveedor`) REFERENCES `proveedor` (`id_proveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.pedido: ~0 rows (aproximadamente)
DELETE FROM `pedido`;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.producto
DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `foto` varchar(50) NOT NULL,
  `tipo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `medida` int(11) NOT NULL,
  `precio_unidad` double NOT NULL,
  `observaciones` text,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `FK_producto_medida_producto` (`medida`),
  KEY `FK_producto_tipo_producto` (`tipo`),
  CONSTRAINT `FK_producto_medida_producto` FOREIGN KEY (`medida`) REFERENCES `medida_producto` (`id_medida`),
  CONSTRAINT `FK_producto_tipo_producto` FOREIGN KEY (`tipo`) REFERENCES `tipo_producto` (`id_tipo_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.producto: ~6 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id_producto`, `nombre`, `foto`, `tipo`, `cantidad`, `medida`, `precio_unidad`, `observaciones`, `estado`) VALUES
	(22, 'arroz con pollo', 'arroz-con-pollo.jpg', 1, -250, 7, 5800, 'rico arroz con pollo', 'Activo'),
	(23, 'arroz con leche', 'arroz-con-leche.jpg', 1, 20, 7, 4500, 'rico arroz con leche', 'Activo'),
	(24, 'pantalon negro', 'pantalon cuero.jpg', 5, 200, 8, 50000, 'pantalón negro', 'Activo'),
	(25, 'chaqueta negro', 'pantalon cuero.jpg', 5, 200, 8, 80000, 'chaqueta negra', 'Activo'),
	(26, 'arroz con pollo', 'arroz con pollo.jpg', 1, 20, 1, 4000, 'arroz con pollo', 'Activo'),
	(27, 'arroz con pollo', 'arroz con pollo.jpg', 1, 20, 1, 4000, 'arroz con pollo licoooooooooo', 'Activo');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.proveedor
DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` int(11) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(50) NOT NULL,
  `estado` varchar(20) NOT NULL,
  PRIMARY KEY (`id_proveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.proveedor: ~4 rows (aproximadamente)
DELETE FROM `proveedor`;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` (`id_proveedor`, `razon_social`, `direccion`, `telefono`, `correo`, `estado`) VALUES
	(1, 'Arroz Roa', 'calle 20', '9654781', 'caparra95@misena.edu.co', 'Activo'),
	(2, 'Vinos S.A', 'cra 50 ', '465871', 'caparra95@misena.edu.co', 'Activo'),
	(3, 'Mesas S.A.S', 'calle 40', '7569841', 'caparra95@misena.edu.co', 'Activo'),
	(4, 'Prueba S.A.A', 'CALLE 50', '8787888', 'caparra95@misena.edu.co', 'Activo');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.rol: ~0 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id_rol`, `nombre`) VALUES
	(1, 'Gerente');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.solicitud
DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE IF NOT EXISTS `solicitud` (
  `id_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(50) NOT NULL DEFAULT '0',
  `cantidad_personas` int(11) DEFAULT '0',
  `telefono` varchar(20) DEFAULT '0',
  `email` varchar(50) NOT NULL DEFAULT '0',
  `id_tipo_evento` int(11) NOT NULL DEFAULT '0',
  `id_paquete` int(11) NOT NULL DEFAULT '0',
  `hora` time DEFAULT '00:00:00',
  `fecha` date DEFAULT NULL,
  `observaciones` varchar(150) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT '0',
  `visto` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_solicitud`),
  KEY `FK_solicitud_tipo_evento` (`id_tipo_evento`),
  KEY `id_paquete` (`id_paquete`),
  CONSTRAINT `FK_solicitud_paquete` FOREIGN KEY (`id_paquete`) REFERENCES `paquete` (`id_paquete`),
  CONSTRAINT `FK_solicitud_tipo_evento` FOREIGN KEY (`id_tipo_evento`) REFERENCES `tipo_evento` (`id_tipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.solicitud: ~4 rows (aproximadamente)
DELETE FROM `solicitud`;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` (`id_solicitud`, `nombre_cliente`, `cantidad_personas`, `telefono`, `email`, `id_tipo_evento`, `id_paquete`, `hora`, `fecha`, `observaciones`, `estado`, `visto`) VALUES
	(3, 'camilo', 250, '215454', 'caparra95@misena.edu.co', 1, 5, '00:00:02', '2018-09-28', 'Observaciones Observaciones ', 'Activo', 0),
	(4, 'andres', 10, '2315445', 'caparra95@misena.edu.co', 1, 5, '00:00:03', '2018-09-28', 'Observaciones Observaciones ', 'Inactivo', 0),
	(5, 'andres', 25, '545454', 'caparra95@misena.edu.co', 2, 10, '00:00:02', '2018-09-28', 'Observaciones Observaciones ', 'Activo', 0),
	(6, 'diego', 1, '5456454', 'diego@gmail.com', 1, 11, '00:11:00', '2018-09-28', 'deseo el combo cuero ', 'Activo', 0);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.suministro
DROP TABLE IF EXISTS `suministro`;
CREATE TABLE IF NOT EXISTS `suministro` (
  `id_suministro` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT '0',
  `foto` varchar(50) DEFAULT '0',
  `cantidad` int(11) DEFAULT '0',
  `cantidad_minima` int(11) DEFAULT '0',
  `medida` int(11) DEFAULT '0',
  `precio_unidad` int(11) DEFAULT '0',
  `observaciones` varchar(50) DEFAULT '0',
  `estado` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id_suministro`),
  KEY `medida` (`medida`),
  CONSTRAINT `FK_ingrediente_medida` FOREIGN KEY (`medida`) REFERENCES `medida_producto` (`id_medida`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.suministro: ~9 rows (aproximadamente)
DELETE FROM `suministro`;
/*!40000 ALTER TABLE `suministro` DISABLE KEYS */;
INSERT INTO `suministro` (`id_suministro`, `nombre`, `foto`, `cantidad`, `cantidad_minima`, `medida`, `precio_unidad`, `observaciones`, `estado`) VALUES
	(9, 'leche', 'leche.jpg', 20, 15, 4, 2900, 'leche uno mas', 'Activo'),
	(10, 'arroz', 'arroz.jpg', 25, 115, 1, 3500, 'leche uno mas', NULL),
	(11, 'pollo', 'pollo.jpg', 20, 115, 1, 3500, 'leche uno mas', 'Activo'),
	(12, 'botones', 'botones.jpg', 20, 15, 8, 100, 'unidades de botones', 'Activo'),
	(13, 'cremallera', 'cremallera.jpg', 20, 15, 8, 100, 'unidades de cremalleras', 'Activo'),
	(14, 'cuero negro', 'cuero negro.jpg', 20, 15, 9, 20000, 'cuero negro', 'Activo'),
	(15, 'arroz', 'arroz.jpg', 20, 10, 1, 4000, 'arroz rico y delicioso', NULL),
	(16, 'pollo', 'pollo.jpg', 30, 10, 1, 4000, 'pollo', 'Activo'),
	(17, 'pollo', 'pollo.jpg', 20, 10, 1, 3000, 'prueba', 'Activo');
/*!40000 ALTER TABLE `suministro` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_documento
DROP TABLE IF EXISTS `tipo_documento`;
CREATE TABLE IF NOT EXISTS `tipo_documento` (
  `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_documento` varchar(50) NOT NULL DEFAULT '0',
  `abreviatura` varchar(3) NOT NULL,
  PRIMARY KEY (`id_tipo_documento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_documento: ~2 rows (aproximadamente)
DELETE FROM `tipo_documento`;
/*!40000 ALTER TABLE `tipo_documento` DISABLE KEYS */;
INSERT INTO `tipo_documento` (`id_tipo_documento`, `descripcion_documento`, `abreviatura`) VALUES
	(1, 'Cédula de Ciudadanía', 'CC'),
	(2, 'Tarjeta de Identidad', 'TI');
/*!40000 ALTER TABLE `tipo_documento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_evento
DROP TABLE IF EXISTS `tipo_evento`;
CREATE TABLE IF NOT EXISTS `tipo_evento` (
  `id_tipo_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_tipo_evento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_evento: ~2 rows (aproximadamente)
DELETE FROM `tipo_evento`;
/*!40000 ALTER TABLE `tipo_evento` DISABLE KEYS */;
INSERT INTO `tipo_evento` (`id_tipo_evento`, `nombre`) VALUES
	(1, 'Familiar'),
	(2, 'Corporativo');
/*!40000 ALTER TABLE `tipo_evento` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.tipo_producto
DROP TABLE IF EXISTS `tipo_producto`;
CREATE TABLE IF NOT EXISTS `tipo_producto` (
  `id_tipo_producto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id_tipo_producto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.tipo_producto: ~5 rows (aproximadamente)
DELETE FROM `tipo_producto`;
/*!40000 ALTER TABLE `tipo_producto` DISABLE KEYS */;
INSERT INTO `tipo_producto` (`id_tipo_producto`, `nombre`) VALUES
	(1, 'Alimento'),
	(2, 'Licor'),
	(3, 'Menaje'),
	(4, 'Servicio'),
	(5, 'Producto');
/*!40000 ALTER TABLE `tipo_producto` ENABLE KEYS */;

-- Volcando estructura para tabla quotevent.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `empleado_n_identificacion` bigint(20) NOT NULL DEFAULT '0',
  `usuario` varchar(50) NOT NULL DEFAULT '0',
  `contrasenia` varchar(50) NOT NULL DEFAULT '0',
  `estado` varchar(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_usuario`),
  KEY `FK_usuario_empleado` (`empleado_n_identificacion`),
  CONSTRAINT `FK_usuario_empleado` FOREIGN KEY (`empleado_n_identificacion`) REFERENCES `empleado` (`n_identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla quotevent.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id_usuario`, `empleado_n_identificacion`, `usuario`, `contrasenia`, `estado`) VALUES
	(1, 1030654523, 'gerente', '740d9c49b11f3ada7b9112614a54be41', 'Activo'),
	(6, 343534534534, 'administrador', '099ebea48ea9666a7da2177267983138', 'Activo');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
