-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-02-2016 a las 03:43:35
-- Versión del servidor: 5.6.26
-- Versión de PHP: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `CEDULA` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`CEDULA`, `NOMBRE`, `APELLIDO`, `DIRECCION`) VALUES
('18473445', 'JOSE', 'AGRAZ', 'VALENCIA EDO. CARABOBO'),
('20230011', 'MIGUEL', 'GUEVARA', 'SAN JUAN DE LOS MORROS URB BELLA VISTA'),
('24390246', 'ANDERSON', 'GUERERRO', 'VIRGEN DE FATIMA\n'),
('25583670', 'JORGE LEONARDO', 'HENRIQUEZ PADRON', 'FATIMA'),
('26954043', 'SAMUEL', 'GUERRERO', 'XXX'),
('4396654', 'JOSE', 'AGRAZ', 'MARACAY');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE IF NOT EXISTS `configuracion` (
  `ID` varchar(5) NOT NULL,
  `RIF` varchar(30) NOT NULL,
  `EMPRESA` varchar(50) NOT NULL,
  `IVA` varchar(10) NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `TELEFONO` varchar(30) NOT NULL,
  `TELEFONO2` varchar(30) NOT NULL,
  `TELEFONO3` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`ID`, `RIF`, `EMPRESA`, `IVA`, `CORREO`, `TELEFONO`, `TELEFONO2`, `TELEFONO3`, `DIRECCION`) VALUES
('01', 'J-30774187-2', 'TOP.CO.AGRI.C.A.', '9.00', 'topcoagri@gmail.com', '0246-4317-201', '0034-6926-15652', '0424-3560-466', 'Urb. Antonio Miguel Martinez\nCalle Farriar Quinta Camoruco\nSan Juan Edo. Guarico.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturacion`
--

CREATE TABLE IF NOT EXISTS `facturacion` (
  `COD_FAC` smallint(8) unsigned zerofill NOT NULL,
  `CLIENTE` varchar(30) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `IVA` varchar(15) NOT NULL,
  `USUARIO` varchar(30) NOT NULL,
  `ESTADO` varchar(5) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturacion`
--

INSERT INTO `facturacion` (`COD_FAC`, `CLIENTE`, `FECHA`, `HORA`, `IVA`, `USUARIO`, `ESTADO`) VALUES
(00000011, '20230011', '03/02/2016', '13:43:39', '9.00', 'ADMINISTRADOR', '1'),
(00000012, '18473445', '03/02/2016', '14:39:11', '9.00', 'ADMINISTRADOR', '1'),
(00000013, '18473445', '10/02/2016', '20:06:58', '9.00', 'ADMINISTRADOR', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `fac_prod`
--

CREATE TABLE IF NOT EXISTS `fac_prod` (
  `id` int(11) NOT NULL,
  `COD_FACT` smallint(8) unsigned zerofill NOT NULL,
  `COD_PRO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `estado` varchar(2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `fac_prod`
--

INSERT INTO `fac_prod` (`id`, `COD_FACT`, `COD_PRO`, `CANTIDAD`, `COSTO`, `estado`) VALUES
(9, 00000011, '005', '1:UD', '87100.00', '1'),
(10, 00000012, '001', '1:UD', '201500.00', '1'),
(11, 00000013, '002', '1:UD', '17550.00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `CODIGO` varchar(50) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `MARCA` varchar(30) NOT NULL,
  `MODELO` varchar(30) NOT NULL,
  `DESCRIPCION` varchar(100) NOT NULL,
  `COSTO_COMPRA` varchar(30) NOT NULL,
  `COSTO_VENTA` varchar(30) NOT NULL,
  `DEPARTAMENTO` varchar(100) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL,
  `COD_PROVEEDOR` varchar(30) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `stock_min` varchar(30) NOT NULL,
  `stock_max` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`CODIGO`, `NOMBRE`, `MARCA`, `MODELO`, `DESCRIPCION`, `COSTO_COMPRA`, `COSTO_VENTA`, `DEPARTAMENTO`, `CANTIDAD`, `COD_PROVEEDOR`, `FECHA`, `stock_min`, `stock_max`) VALUES
('001', 'ESPARCIDORA DE SEMILLAS', 'SHINDAIWA', 'RS76', 'ESPARCIDOR DE SEMILLAS', '155000.00', '201500.00', 'AGRICULTURA', '46:UD', 'P-001', '11/11/2015', '20', '40'),
('002', 'ASPERJADORA', 'EUROPARD', 'EUROPARD 16LTS', 'FUMIGADORA AGRICOLA DE ESPALDA', '13500.00', '17550.00', 'AGRICULTURA', '34:UD', 'P-001', '11/11/2015', '20', '40'),
('003', 'CAÑÓN DE RIEGO', 'MARINER ITALIANO', 'MARINER ITALIANO 2 .1/2 ', 'CAÑÓN PARA RIEGO', '350.00', '455.00', 'AGRICULTURA', '35:UD', 'P-004', '02/12/2015', '20', '40'),
('004', 'LAMINA DE LOSACERO', 'LAMINA DE LOSACERO', '6,10 X 0,90', 'LAMINA DE LOSACERO ANCHO = 0,78 CM, LARGO  = 6,10 M, CALIBRE = 0 .20 ', '28000.00', '36400.00', 'CONSTRUCTORA', '1010:UD', 'P-006', '15/01/2015', '100', '1500'),
('005', 'EMPLASTICADO AGRICOLA', 'MULCHING', 'MULCHING 1.30*500M', 'PLASTICO AGRICOLA PARA MULCHING, BOBINAS DE 1.30*500M.', '67000.00', '87100.00', 'AGRICULTURA', '39:UD', 'P-002', '15/01/2015', '15', '50'),
('006', 'LAMINA LISA', 'GALVANIZADA', 'GALVANIZADA', 'LAMINA LISA GALVANIZADA MEDIDAS 1,2X2,4 M, CALIBRE 24 (0,6 MM', '8900.00', '11570.00', 'CONSTRUCTORA', '370:UD', 'P-005', '15/01/2015', '100', '400'),
('007', 'CABILLA', 'CABILLA', 'CABILLA LIZA', 'BARRA LISA DE CALIBRE 1/2', '2950.00', '3835.00', 'CONSTRUCTORA', '750:UD', 'P-005', '02/01/2015', '100', '1000'),
('008', 'PINTURA PARA MANTO', 'IMPERCAPA', 'ELASTOMENICA', 'PINTURA ELASTOMENICA PARA MANTOS', '19500.00', '25350.00', 'CONSTRUCTORA', '500:UD', 'P-005', '20/01/2016', '100', '1000'),
('009', 'MANTO PARA PLACA', 'NOVACAPA 3.5', '3.5', 'MANTO PARA PLACA', '8000.00', '10400.00', 'CONSTRUCTORA', '40:UD', 'P-005', '20/01/2016', '15', '50'),
('010', 'LAMINAS DE ZINC', 'VENCHI UNION', 'ZINC', 'LAMINAS DE ZINC PARA TECHOS', '4900.00', '6370.00', 'CONSTRUCTORA', '900:UD', 'P-005', '20/01/2016', '200', '1000'),
('011', 'TUBO PLASTICO', 'PLASTIVEN', '6 PULGADAS', 'TUBO  DE PLASTICO', '3200.00', '4160.00', 'AGRICULTURA', '470:UD', 'P-003', '07/12/2015', '100', '500'),
('012', 'MALLA POLISOMBRA', 'RAFIA ZARAN', 'MALLA POLISOMBRA 65%', 'MALLA POLISOMBRA PARA CULTIVOS AGRICULTURA ANCHO 4 MTS, LARGO 100 MT\n', '2900.00', '3770.00', 'AGRICULTURA', '320:UD', 'P-004', '07/12/2015', '100', '350'),
('013', 'DESMALESADORA', 'DESBROZADORA', 'KA 85R', 'DESMALESADORA - MOTOGUADAÑA DESBROZADORA KA 85R', '12000.00', '15600.00', 'AGRICULTURA', '35:UD', 'P-001', '02/01/2015', '10', '40'),
('014', 'BOMBA AGUA', 'STREAM', '1 HP 110V/220V', 'BOMBA CENTRIFUGA DE AGUA STREAM 1 HP 110V/220V', '76500.00', '99450.00', 'AGRICULTURA', '35:UD', 'P-001', '02/01/2015', '10', '40'),
('015', 'HIDROJET', 'LAND', '1900PSI 120V HP9160 1600W 6L/M', 'HIDROJET HIDROLAVADORA LAND 1900PSI 120V HP9160 1600W 6L/M', '67000.00', '87100.00', 'AGRICULTURA', '35:UD', 'P-002', '12/01/2015', '10', '40');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE IF NOT EXISTS `proveedores` (
  `CODIGO` varchar(30) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `DIRECCION` text NOT NULL,
  `CORREO` varchar(50) NOT NULL,
  `CODIGO_POSTAL` varchar(30) NOT NULL,
  `FAX` varchar(30) NOT NULL,
  `NOMBRE_VEND` varchar(30) NOT NULL,
  `RIF` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`CODIGO`, `NOMBRE`, `DIRECCION`, `CORREO`, `CODIGO_POSTAL`, `FAX`, `NOMBRE_VEND`, `RIF`) VALUES
('P-001', 'AGRINOVA C.A.', 'MARACAY, ARAGUA', 'agrinova@hotmail.com', '2103', '02432334566', 'JUAN LOPEZ', 'J-2'),
('P-002', 'AGRICOLA TANAUSU C.A.', 'CAGUA, ARAGUA.', 'agricolatanasu@yahoo.com', '2122', '02444556788', 'ANDRES HERNANDEZ', 'J-299031766'),
('P-003', 'AGROBICA, C.A.', 'VALENCIA, CARABOBO', 'agrobica@hotmail.com', '2001', '02410099234', 'ALEXANDER FLORES', 'J-329037755'),
('P-004', 'FERBASA S.A.', 'VILLA DE CURA, ARAGUA.', 'ferbasa@gmail.com', '2126', '02441126543', 'JOSE APONTE', 'J-449031755'),
('P-005', 'TECHOMAT METROPOLITANO CA', 'MARACAY, AV. INTERCOMUNAL SANTIAGO MARIÑO, GALPÓN TECHOMAT, NIVEL PB, LOCAL 01, SECTOR LA PROVIDENCIA', 'techomatmetropolitano@gmail.com', '2103', '02431240981', 'JOSE MORENO', 'J-299031000'),
('P-006', ' LÁMINAS Y VIGAS A-36', 'CARACAS, CL. PIEDRA AZUL, GALPÓN 26, PISO PB, LOCAL SN, URBANIZACIÓN BELLA VISTA', 'laminas_vigas_a-36@gmail.com', '1050', '02122347654', 'RUBEN NIEVEZ', 'J-299035571'),
('P-007', 'OXÍGENOS TOCUYITO, C.A.', 'UBICADA EN EL ESTADO CARABOBO. URBANIZACIÓN LOS CHORRITOS. ', 'oxigenostocuyito@yahoo.com', '2001', '02431100123', 'MOISES TORRES', 'J-199031755');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepciones`
--

CREATE TABLE IF NOT EXISTS `recepciones` (
  `COD_RECEP` smallint(5) unsigned zerofill NOT NULL,
  `COD_PRO` varchar(50) NOT NULL,
  `COD_PROD` varchar(50) NOT NULL,
  `FECHA` varchar(15) NOT NULL,
  `HORA` varchar(15) NOT NULL,
  `COSTO` varchar(30) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `recepciones`
--

INSERT INTO `recepciones` (`COD_RECEP`, `COD_PRO`, `COD_PROD`, `FECHA`, `HORA`, `COSTO`, `CANTIDAD`) VALUES
(00014, 'P-001', '001', '03/02/2016', '11:07:52', '155000.00', '35:UD'),
(00015, 'P-001', '002', '03/02/2016', '11:12:47', '13500.00', '32:UD'),
(00016, 'P-004', '003', '03/02/2016', '11:16:13', '350.00', '50:UD'),
(00017, 'P-006', '004', '03/02/2016', '11:19:31', '28000.00', '1000:UD'),
(00018, 'P-002', '005', '03/02/2016', '11:24:29', '67000.00', '40:UD'),
(00019, 'P-005', '006', '03/02/2016', '11:30:25', '8900.00', '200:UD'),
(00020, 'P-005', '007', '03/02/2016', '11:33:56', '2950.00', '750:UD'),
(00021, 'P-005', '008', '03/02/2016', '11:36:08', '19500.00', '500:UD'),
(00022, 'P-005', '009', '03/02/2016', '11:38:15', '8000.00', '40:UD'),
(00023, 'P-005', '010', '03/02/2016', '11:40:32', '4900.00', '900:UD'),
(00024, 'P-003', '011', '03/02/2016', '11:43:00', '3200.00', '350:UD'),
(00025, 'P-004', '012', '03/02/2016', '11:46:19', '2900.00', '220:UD'),
(00026, 'P-001', '013', '03/02/2016', '11:50:47', '12000.00', '15:UD'),
(00027, 'P-001', '014', '03/02/2016', '11:53:17', '76500.00', '17:UD'),
(00028, 'P-002', '015', '03/02/2016', '11:55:39', '67000.00', '10:UD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE IF NOT EXISTS `telefonos` (
  `Id` varchar(30) NOT NULL,
  `telefono` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`Id`, `telefono`) VALUES
('P-001', '0244-1234567'),
('P-001', '0244-7654321'),
('P-001', ' 0243-2320945'),
('P-002', '0244-3954955'),
('003', '0241-8716-549'),
('P-004', '0244-4170049'),
('005', '0243-2691180'),
('006', '0212-4715187'),
('007', '0241-8530105');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_pago`
--

CREATE TABLE IF NOT EXISTS `tipo_pago` (
  `id` int(11) NOT NULL,
  `COD_FACT` smallint(8) unsigned zerofill NOT NULL,
  `TIPO_PAGO` varchar(20) NOT NULL,
  `CANTIDAD` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_pago`
--

INSERT INTO `tipo_pago` (`id`, `COD_FACT`, `TIPO_PAGO`, `CANTIDAD`) VALUES
(9, 00000011, 'EFECTIVO', '94939.00'),
(10, 00000012, 'EFECTIVO', '219635.00'),
(11, 00000013, 'EFECTIVO', '19130.00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `USUARIO` varchar(30) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `INVENTARIO` tinyint(1) NOT NULL,
  `FACTURAS` tinyint(1) NOT NULL,
  `FACTURACION` tinyint(1) NOT NULL,
  `CLIENTES` tinyint(1) NOT NULL,
  `CONFIGURACION` tinyint(1) NOT NULL,
  `PROVEEDORES` tinyint(1) NOT NULL,
  `pass_2` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`USUARIO`, `PASSWORD`, `INVENTARIO`, `FACTURAS`, `FACTURACION`, `CLIENTES`, `CONFIGURACION`, `PROVEEDORES`, `pass_2`) VALUES
('ADMINISTRADOR', '567a', 1, 1, 1, 1, 1, 1, 'nlup|zd'),
('INVENTARIO', '456`', 1, 0, 0, 0, 0, 0, '789c');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`CEDULA`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indices de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  ADD PRIMARY KEY (`COD_FAC`);

--
-- Indices de la tabla `fac_prod`
--
ALTER TABLE `fac_prod`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  ADD PRIMARY KEY (`COD_RECEP`);

--
-- Indices de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`USUARIO`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `facturacion`
--
ALTER TABLE `facturacion`
  MODIFY `COD_FAC` smallint(8) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `fac_prod`
--
ALTER TABLE `fac_prod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `recepciones`
--
ALTER TABLE `recepciones`
  MODIFY `COD_RECEP` smallint(5) unsigned zerofill NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT de la tabla `tipo_pago`
--
ALTER TABLE `tipo_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
