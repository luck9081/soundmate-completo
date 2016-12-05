drop database if exists soundmate;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.10-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para soundmate
CREATE DATABASE IF NOT EXISTS `soundmate` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `soundmate`;


-- Volcando estructura para tabla soundmate.banda
CREATE TABLE IF NOT EXISTS `banda` (
  `idbanda` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `bandname` varchar(50) NOT NULL COMMENT 'Nombre de la Banda',
  `idgenero` varchar(50) NOT NULL COMMENT 'FK a Generos',
  PRIMARY KEY (`idbanda`),
  KEY `idgenero` (`idgenero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla soundmate.banda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `banda` DISABLE KEYS */;
/*!40000 ALTER TABLE `banda` ENABLE KEYS */;


-- Volcando estructura para tabla soundmate.genero
CREATE TABLE IF NOT EXISTS `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `nombre` varchar(50) NOT NULL COMMENT 'Nombre del genero',
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla soundmate.genero: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;


-- Volcando estructura para tabla soundmate.instrumento
CREATE TABLE IF NOT EXISTS `instrumento` (
  `idinstrumento` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `nombre` varchar(50) NOT NULL COMMENT 'Nombre del Instrumento',
  PRIMARY KEY (`idinstrumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla soundmate.instrumento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `instrumento` DISABLE KEYS */;
/*!40000 ALTER TABLE `instrumento` ENABLE KEYS */;


-- Volcando estructura para tabla soundmate.publicaciones
CREATE TABLE IF NOT EXISTS `publicaciones` (
  `idpublicacion` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK',
  `descripcion` varchar(250) NOT NULL COMMENT 'descripcion del post',
  `fechapublicacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha en la que se posteo',
  `idusuario` int(11) NOT NULL COMMENT 'FK a usuario creador',
  `idbanda` int(11) NOT NULL COMMENT 'FK a banda donde se posteo',
  PRIMARY KEY (`idpublicacion`),
  KEY `idusuario` (`idusuario`),
  KEY `idbanda` (`idbanda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla soundmate.publicaciones: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `publicaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicaciones` ENABLE KEYS */;


-- Volcando estructura para tabla soundmate.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT COMMENT 'PK ',
  `nombre` varchar(50) NOT NULL COMMENT 'Nombre de Usuario',
  `pass` varchar(50) NOT NULL COMMENT 'Contraseña de usuario',
  `email` varchar(50) NOT NULL COMMENT 'Email de Usuario',
  `instrumento` int(11) NOT NULL COMMENT 'FK a instrumento',
  `localidad` varchar(50) NOT NULL COMMENT 'localidad donde vive',
  `partido` varchar(50) NOT NULL COMMENT 'partido donde vive',
  `provincia` varchar(50) NOT NULL COMMENT 'provincia donde vive',
  `influencia` varchar(50) NOT NULL COMMENT 'artistas que lo influencian',
  PRIMARY KEY (`idusuario`),
  KEY `instrumento` (`instrumento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla soundmate.usuario: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
