# DLL BASE DE DATOS ADMINISTRACION DE USUARIOS
CREATE TABLE administradorUsuarios.TIPO_IDENTIFICACION (
	TIPO varchar(150) NOT NULL,
	PREFIJO varchar(10) NOT NULL,
	ID INT auto_increment NOT NULL,
	CONSTRAINT TIPO_IDENTIFICACION_pk PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;
########

CREATE TABLE `persona` (
  `ID_TIPO_IDENTIFICACION` int(11) NOT NULL,
  `NUMERO_IDENTIFICACION` varchar(100) NOT NULL,
  `NOMBRES` varchar(150) DEFAULT NULL,
  `APELLIDOS` varchar(150) DEFAULT NULL,
  `EDAD` int(11) DEFAULT NULL,
  `SEXO` varchar(2) DEFAULT NULL,
  `NUMERO_HIJOS` int(11) DEFAULT NULL,
  `PROFESION` varchar(100) DEFAULT NULL,
  `FECHA NACIMIENTO` date DEFAULT NULL,
  `ESTADO_CIVIL` varchar(100) DEFAULT NULL,
  `FECHA_CREACION` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`NUMERO_IDENTIFICACION`,`ID_TIPO_IDENTIFICACION`),
  CONSTRAINT `Persona_FK` FOREIGN KEY (`ID_TIPO_IDENTIFICACION`) REFERENCES `tipo_identificacion` (`ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3

######
CREATE TABLE administradorUsuarios.USUARIO (
	ID BIGINT auto_increment NOT NULL,
	ID_TIPO_IDENTIFICACION INT NOT NULL,
	NUMERO_IDENTIFICACION varchar(100) NOT NULL,
	USERNAME varchar(100) NULL,
	EMAIL varchar(100) NULL,
	MOVIL varchar(100) NULL,
	FECHA_CREACION TIMESTAMP NULL,
	CONSTRAINT USUARIO_pk2 PRIMARY KEY (ID,ID_TIPO_IDENTIFICACION,NUMERO_IDENTIFICACION),
	CONSTRAINT USUARIO_FK FOREIGN KEY (NUMERO_IDENTIFICACION,ID_TIPO_IDENTIFICACION) REFERENCES administradorUsuarios.persona(NUMERO_IDENTIFICACION,ID_TIPO_IDENTIFICACION) ON DELETE RESTRICT ON UPDATE CASCADE
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

##
CREATE TABLE administradorUsuarios.SYSTEMA (
	ID INT auto_increment NULL,
	NOMBRE varchar(100) NOT NULL,
	CONSTRAINT SYSTEMA_pk PRIMARY KEY (ID)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;

######
CREATE TABLE administradorUsuarios.ROLES_SISTEMAS (
	ID BIGINT auto_increment NOT NULL,
	ID_SISTEMA INT NOT NULL,
	NOMBRE_ROL varchar(100) NULL,
	FECHA_CREACION TIMESTAMP DEFAULT CURRENT_TIMESTAMP() NULL,
	CONSTRAINT ROLES_SISTEMAS_pk PRIMARY KEY (ID,ID_SISTEMA,NOMBRE_ROL)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb3
COLLATE=utf8mb3_general_ci;
#####
CREATE TABLE `roles_usuario` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_ROL_SISTEMA` bigint(20) NOT NULL,
  `ID_SISTEMA` int(11) NOT NULL,
  `NOMBRE_ROL` varchar(100) NOT NULL,
  `ID_USUARIO` bigint(20) NOT NULL,
  `ID_TIPO_IDENTIFICACION` int(11) NOT NULL,
  `NUMERO_IDENTIFICACION` varchar(100) NOT NULL,
  `FECHA_CREACION` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ID`,`ID_ROL_SISTEMA`,`ID_SISTEMA`,`NOMBRE_ROL`,`ID_USUARIO`,`ID_TIPO_IDENTIFICACION`,`NUMERO_IDENTIFICACION`),
  KEY `ROLES_USUARIO_FK` (`ID_ROL_SISTEMA`,`ID_SISTEMA`,`NOMBRE_ROL`),
  KEY `roles_usuario_FK2` (`ID_USUARIO`,`ID_TIPO_IDENTIFICACION`,`NUMERO_IDENTIFICACION`),
  CONSTRAINT `ROLES_USUARIO_FK` FOREIGN KEY (`ID_ROL_SISTEMA`, `ID_SISTEMA`, `NOMBRE_ROL`) REFERENCES `roles_sistemas` (`ID`, `ID_SISTEMA`, `NOMBRE_ROL`) ON UPDATE CASCADE,
  CONSTRAINT `roles_usuario_FK2` FOREIGN KEY (`ID_USUARIO`, `ID_TIPO_IDENTIFICACION`, `NUMERO_IDENTIFICACION`) REFERENCES `usuario` (`ID`, `ID_TIPO_IDENTIFICACION`, `NUMERO_IDENTIFICACION`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3

######














