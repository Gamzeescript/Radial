-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 14-12-2019 a las 11:57:02
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `radio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargo`
--

DROP TABLE IF EXISTS `cargo`;
CREATE TABLE IF NOT EXISTS `cargo` (
  `idcargo` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecargo` varchar(100) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`idcargo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargo`
--

INSERT INTO `cargo` (`idcargo`, `nombrecargo`, `descripcion`) VALUES
(1, 'Locutor', 'Un locutor es un profesional de la comunicacion. Sus funciones abarcan desde presentar programas y narrar diferentes textos (noticias, informes, documentales, etc.)'),
(2, 'Director', 'dirige el guion y los programas de radio'),
(3, 'Guionista', 'escribe los guiones y revisa los de los locutores y se los informa al director'),
(5, 'Efectos', 'Maneja efectos de sonido '),
(6, 'Jefe tecnico', 'Maneja todo lo relacionado con sonido e instrumentos que se utilizan');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cargoxempleado`
--

DROP TABLE IF EXISTS `cargoxempleado`;
CREATE TABLE IF NOT EXISTS `cargoxempleado` (
  `idempleado` int(11) NOT NULL,
  `idcargo` int(11) NOT NULL,
  KEY `fk_empleado_ce` (`idempleado`),
  KEY `fk_cargo_Ce` (`idcargo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cargoxempleado`
--

INSERT INTO `cargoxempleado` (`idempleado`, `idcargo`) VALUES
(1, 2),
(2, 5),
(1, 2),
(4, 3),
(1, 2),
(2, 5),
(1, 2),
(4, 1),
(1, 2),
(2, 5),
(1, 2),
(4, 1),
(5, 3),
(1, 2),
(1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consorcio`
--

DROP TABLE IF EXISTS `consorcio`;
CREATE TABLE IF NOT EXISTS `consorcio` (
  `idconsorcio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreconsorcio` varchar(100) NOT NULL,
  `rfc` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  PRIMARY KEY (`idconsorcio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `consorcio`
--

INSERT INTO `consorcio` (`idconsorcio`, `nombreconsorcio`, `rfc`, `telefono`) VALUES
(1, 'CRN', 'RCN-123-0', '2294-5578'),
(2, 'Consorcio de El Salvador', 'SV-12-0', '2212-8977'),
(3, 'Consorcio de Centroamerica', 'CA-456-0', '2222-6698');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emision`
--

DROP TABLE IF EXISTS `emision`;
CREATE TABLE IF NOT EXISTS `emision` (
  `idemision` int(11) NOT NULL AUTO_INCREMENT,
  `idprograma` int(11) NOT NULL,
  `fechainicio` date NOT NULL,
  `horainicio` time NOT NULL,
  `fechafin` date NOT NULL,
  `horafin` time NOT NULL,
  `duracion` varchar(9) NOT NULL,
  `repeticion` tinyint(1) NOT NULL,
  PRIMARY KEY (`idemision`),
  KEY `fk_programa_em` (`idprograma`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `emision`
--

INSERT INTO `emision` (`idemision`, `idprograma`, `fechainicio`, `horainicio`, `fechafin`, `horafin`, `duracion`, `repeticion`) VALUES
(1, 2, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(2, 2, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(3, 2, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(4, 1, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(5, 2, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(6, 3, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 0),
(8, 4, '2019-05-12', '12:30:00', '2019-05-12', '13:30:00', '60min', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(300) NOT NULL,
  `cedula` varchar(11) NOT NULL,
  `idproductora` int(11) NOT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `fk_productora_em` (`idproductora`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombre`, `cedula`, `idproductora`) VALUES
(1, 'Laura Manuela Henriquez Chevez', 'LH07-AA-LR', 1),
(2, 'Marlon Alberto Torres Garcia', 'MT-A18-IT', 4),
(4, 'Wilfredo Armando Reyes Carranza', 'WR-AA16-LC', 4),
(5, 'Marvin Orlando Ruiz Menjivar', 'MR-0FR18-DC', 3),
(6, 'Marvin Orlando Ruiz Menjivar', 'MR-0FR18-DC', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuesta`
--

DROP TABLE IF EXISTS `encuesta`;
CREATE TABLE IF NOT EXISTS `encuesta` (
  `idencuesta` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `idprograma` int(11) NOT NULL,
  `idrating` int(11) NOT NULL,
  PRIMARY KEY (`idencuesta`),
  KEY `fk_usuario_en` (`idusuario`),
  KEY `fk_programa_en` (`idprograma`),
  KEY `fk_rating_en` (`idrating`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `encuesta`
--

INSERT INTO `encuesta` (`idencuesta`, `idusuario`, `idprograma`, `idrating`) VALUES
(1, 1, 1, 3),
(2, 2, 5, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `frecuencia`
--

DROP TABLE IF EXISTS `frecuencia`;
CREATE TABLE IF NOT EXISTS `frecuencia` (
  `idfrecuencia` int(11) NOT NULL AUTO_INCREMENT,
  `nombrefrecuencia` varchar(5) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `frecuencia` varchar(100) NOT NULL,
  `idtransmision` int(11) NOT NULL,
  PRIMARY KEY (`idfrecuencia`),
  KEY `fk_transmision` (`idtransmision`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `frecuencia`
--

INSERT INTO `frecuencia` (`idfrecuencia`, `nombrefrecuencia`, `descripcion`, `frecuencia`, `idtransmision`) VALUES
(1, 'LF', 'Baja frecuencia', '30 -300 kHz', 1),
(2, 'MF', 'Media frecuencia', '300 -3.000 kHz', 1),
(3, 'VHF', 'Muy alta frecuencia', '30-300 MHz', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

DROP TABLE IF EXISTS `genero`;
CREATE TABLE IF NOT EXISTS `genero` (
  `idgenero` int(11) NOT NULL AUTO_INCREMENT,
  `nombregenero` varchar(100) NOT NULL,
  PRIMARY KEY (`idgenero`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`idgenero`, `nombregenero`) VALUES
(1, 'Resumen'),
(2, 'Podcast'),
(3, 'Dramatico'),
(4, 'Periodistico'),
(5, 'Entrevistas'),
(6, 'Musical');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `produccion`
--

DROP TABLE IF EXISTS `produccion`;
CREATE TABLE IF NOT EXISTS `produccion` (
  `idproduccion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreproduccion` varchar(100) NOT NULL,
  `idproductora` int(11) NOT NULL,
  PRIMARY KEY (`idproduccion`),
  KEY `fk_productora_p` (`idproductora`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `produccion`
--

INSERT INTO `produccion` (`idproduccion`, `nombreproduccion`, `idproductora`) VALUES
(1, 'Manianas con Vox', 1),
(2, 'La jugada', 3),
(3, 'Minuto de Maria', 1),
(4, 'Conceptos con Aida', 3),
(5, 'Asi estamos SV - edicion tarde', 1),
(7, 'Noticias de las 11', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productora`
--

DROP TABLE IF EXISTS `productora`;
CREATE TABLE IF NOT EXISTS `productora` (
  `idproductora` int(11) NOT NULL AUTO_INCREMENT,
  `nombreproductora` varchar(100) NOT NULL,
  `rfc` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `idconsorcio` int(11) NOT NULL,
  PRIMARY KEY (`idproductora`),
  KEY `fk_consorcio` (`idconsorcio`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productora`
--

INSERT INTO `productora` (`idproductora`, `nombreproductora`, `rfc`, `telefono`, `idconsorcio`) VALUES
(1, 'ProductoraR sv', 'PRR-sv-0910', '2212-4578', 1),
(3, 'Producciones M', 'PM-09-121', '2245-3412', 2),
(4, 'Radiodifusora cadena radial', 'RP-PP-012-0', '2045-6369', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `programa`
--

DROP TABLE IF EXISTS `programa`;
CREATE TABLE IF NOT EXISTS `programa` (
  `idprograma` int(11) NOT NULL AUTO_INCREMENT,
  `nombreprograma` varchar(300) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `idgenero` int(11) NOT NULL,
  `idradio` int(11) NOT NULL,
  PRIMARY KEY (`idprograma`),
  KEY `fk_genero_p` (`idgenero`),
  KEY `fk_radio_p` (`idradio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `programa`
--

INSERT INTO `programa` (`idprograma`, `nombreprograma`, `descripcion`, `idgenero`, `idradio`) VALUES
(1, 'Cronicas de economia', 'Balances de la economia del aos', 4, 4),
(2, 'Resumen \"asi estamos sv\"', 'coyuntura politica y social de la semana', 1, 1),
(3, 'Programa amigos', 'programa con la Psicologa Schmidt', 1, 1),
(4, 'resumen de la coyuntura', 'resumen de las leyes que se discuten en la asamblea', 1, 1),
(5, 'chacharas con Ale Munjia', 'sdsd', 1, 1),
(6, 'programa de prueba', 'ddd', 1, 1),
(7, 'minuto de cultura', 'dddd', 1, 1),
(8, 'Pencho y Aida', 'dddddd', 1, 1),
(9, 'Boleros', 'ddddd', 1, 1),
(10, 'los 40 principales', 'dddddddddd', 1, 1),
(11, 'test', 'aqio', 1, 1),
(12, 'aqui hay un programa', 'ddddddddd', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `radio`
--

DROP TABLE IF EXISTS `radio`;
CREATE TABLE IF NOT EXISTS `radio` (
  `idradio` int(11) NOT NULL AUTO_INCREMENT,
  `nombreradio` varchar(300) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `idfrecuencia` int(11) NOT NULL,
  `idconsorcio` int(11) NOT NULL,
  PRIMARY KEY (`idradio`),
  KEY `fk_consorcio_r` (`idconsorcio`),
  KEY `fk_frecuencia_r` (`idfrecuencia`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `radio`
--

INSERT INTO `radio` (`idradio`, `nombreradio`, `descripcion`, `idfrecuencia`, `idconsorcio`) VALUES
(1, 'Radio corazon', 'radio de canciones romanticas de informacion nacional', 1, 2),
(2, 'YSAL Radio Asamblea', 'radio dedicada a transmitir los procesos de ley que se llevan a cabo en la Asamblea', 2, 2),
(4, 'Radio KL', 'prueba', 3, 1),
(5, 'Radio Urbana', 'musica para jovenes y el joven adulto', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rating`
--

DROP TABLE IF EXISTS `rating`;
CREATE TABLE IF NOT EXISTS `rating` (
  `idrating` int(11) NOT NULL AUTO_INCREMENT,
  `nombrerating` varchar(40) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`idrating`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rating`
--

INSERT INTO `rating` (`idrating`, `nombrerating`, `descripcion`) VALUES
(1, 'madera', 'no esta siendo sintonizado por el target'),
(2, 'Bronce', 'Consigue el rating pero no es un programa que alcance el target'),
(3, 'Plata', 'Lo estan sintonizando y es de calidad buena'),
(4, 'Oro', 'El target ha sido captado por los oyentes y esta siendo un exito'),
(5, 'Diamante', 'el programa de radio como la radio y emisora son un exito total');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `transmision`
--

DROP TABLE IF EXISTS `transmision`;
CREATE TABLE IF NOT EXISTS `transmision` (
  `idtransmision` int(11) NOT NULL AUTO_INCREMENT,
  `nombretransmision` varchar(5) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  PRIMARY KEY (`idtransmision`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `transmision`
--

INSERT INTO `transmision` (`idtransmision`, `nombretransmision`, `descripcion`) VALUES
(1, 'AM', ' amplitud modulada (AM). Radio AM tambien se refiere al receptor que permite escuchar las emisiones.'),
(2, 'FM', 'se basa en tecnologia analogica. Esta banda de frecuencias empezo a utilizarse a partir de los anios 60. Durante las ultimas decadas la tecnologia ha ido aportando mejoras en la radio analalogica como el sonido estereo ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `apellido` varchar(200) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pass` int(100) NOT NULL,
  `email` varchar(300) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `apellido`, `usuario`, `pass`, `email`, `telefono`) VALUES
(1, 'Luis Eduardo', 'Alvarez ', 'LuisExMachina', 12345, 'luisluisprueba@gmail.com', '2212-4578'),
(2, 'Ana Maria', 'Penia', 'ana.p_1997', 12345, 'anamaria.p@gmail.com', '7755-1412'),
(3, 'L Michelle', 'Giron', 'Gamzeescript', 12345, 'gamzeescript@outlook.com', 'NA'),
(4, 'Amanda', 'Vaquerano', 'amandav', 12345, 'amanda.vp@outlook.com', '7448-3615'),
(5, 'Victor Eduardo', 'Mendoza Osuna', 'vnoir', 12345, 'sombradeldestino@gmail.com', '2236-9696');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cargoxempleado`
--
ALTER TABLE `cargoxempleado`
  ADD CONSTRAINT `fk_cargo_Ce` FOREIGN KEY (`idcargo`) REFERENCES `cargo` (`idcargo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_empleado_ce` FOREIGN KEY (`idempleado`) REFERENCES `empleado` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `emision`
--
ALTER TABLE `emision`
  ADD CONSTRAINT `fk_programa_em` FOREIGN KEY (`idprograma`) REFERENCES `programa` (`idprograma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_productora_em` FOREIGN KEY (`idproductora`) REFERENCES `productora` (`idproductora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `encuesta`
--
ALTER TABLE `encuesta`
  ADD CONSTRAINT `fk_programa_en` FOREIGN KEY (`idprograma`) REFERENCES `programa` (`idprograma`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_rating_en` FOREIGN KEY (`idrating`) REFERENCES `rating` (`idrating`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_en` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `frecuencia`
--
ALTER TABLE `frecuencia`
  ADD CONSTRAINT `fk_transmision` FOREIGN KEY (`idtransmision`) REFERENCES `transmision` (`idtransmision`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `produccion`
--
ALTER TABLE `produccion`
  ADD CONSTRAINT `fk_productora_p` FOREIGN KEY (`idproductora`) REFERENCES `productora` (`idproductora`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `productora`
--
ALTER TABLE `productora`
  ADD CONSTRAINT `fk_consorcio` FOREIGN KEY (`idconsorcio`) REFERENCES `consorcio` (`idconsorcio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `programa`
--
ALTER TABLE `programa`
  ADD CONSTRAINT `fk_genero_p` FOREIGN KEY (`idgenero`) REFERENCES `genero` (`idgenero`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_radio_p` FOREIGN KEY (`idradio`) REFERENCES `radio` (`idradio`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `radio`
--
ALTER TABLE `radio`
  ADD CONSTRAINT `fk_consorcio_r` FOREIGN KEY (`idconsorcio`) REFERENCES `consorcio` (`idconsorcio`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_frecuencia_r` FOREIGN KEY (`idfrecuencia`) REFERENCES `frecuencia` (`idfrecuencia`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
