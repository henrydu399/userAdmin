/*
Navicat MySQL Data Transfer

Source Server         : SERVERHOME
Source Server Version : 50505
Source Host           : 192.168.1.150:3306
Source Database       : users

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-01-31 15:43:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for u_datos_contacto
-- ----------------------------
DROP TABLE IF EXISTS `u_datos_contacto`;
CREATE TABLE `u_datos_contacto` (
  `dc_id` bigint(20) NOT NULL,
  `dc_direccion` varchar(100) DEFAULT NULL,
  `dc_tel_movil` varchar(50) DEFAULT NULL,
  `dc_tel_fijo` varchar(50) DEFAULT NULL,
  `dc_estado` bit(1) NOT NULL,
  `dc_id_tipo_identificacion` tinyint(4) NOT NULL,
  `dc_numero_identificacion` varchar(15) NOT NULL,
  PRIMARY KEY (`dc_id`,`dc_id_tipo_identificacion`,`dc_numero_identificacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of u_datos_contacto
-- ----------------------------

-- ----------------------------
-- Table structure for u_estado_civiles
-- ----------------------------
DROP TABLE IF EXISTS `u_estado_civiles`;
CREATE TABLE `u_estado_civiles` (
  `ec_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `ec_bombre` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`ec_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

-- ----------------------------
-- Records of u_estado_civiles
-- ----------------------------
INSERT INTO `u_estado_civiles` VALUES ('1', 'SOLTERO');
INSERT INTO `u_estado_civiles` VALUES ('2', 'CASADO');
INSERT INTO `u_estado_civiles` VALUES ('3', 'DIVORCIADO');
INSERT INTO `u_estado_civiles` VALUES ('4', 'UNION LIBRE');

-- ----------------------------
-- Table structure for u_funciones
-- ----------------------------
DROP TABLE IF EXISTS `u_funciones`;
CREATE TABLE `u_funciones` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_nombre` varchar(255) DEFAULT NULL,
  `f_descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of u_funciones
-- ----------------------------

-- ----------------------------
-- Table structure for u_personas
-- ----------------------------
DROP TABLE IF EXISTS `u_personas`;
CREATE TABLE `u_personas` (
  `p_primer_nombre` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `p_segundo_nombre` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `p_primer_apellido` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `p_segundo_apellido` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `p_numero_identificacion` varchar(15) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `p_id_tipo_identificacion` tinyint(4) NOT NULL,
  `p_id_estado_civil` tinyint(4) DEFAULT NULL,
  `p_edad` int(11) DEFAULT NULL,
  `p_fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `p_telefono_celular` varchar(50) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `P_fecha_nacimiento` date DEFAULT NULL,
  `P_hijos` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`p_id_tipo_identificacion`,`p_numero_identificacion`),
  KEY `juz_persona_estado_civil` (`p_id_estado_civil`),
  CONSTRAINT `juz_persona_estado_civil` FOREIGN KEY (`p_id_estado_civil`) REFERENCES `u_estado_civiles` (`ec_id`) ON UPDATE CASCADE,
  CONSTRAINT `juz_persona_ibfk_1` FOREIGN KEY (`p_id_tipo_identificacion`) REFERENCES `u_tipo_documentos` (`td_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

-- ----------------------------
-- Records of u_personas
-- ----------------------------
INSERT INTO `u_personas` VALUES ('JOSE', 'HENRY', 'DUARTE', 'CASTELLANOS', '1090472353', '1', '1', '28', '2022-01-31 15:37:16', '3003681463', '1993-10-29', null);

-- ----------------------------
-- Table structure for u_roles
-- ----------------------------
DROP TABLE IF EXISTS `u_roles`;
CREATE TABLE `u_roles` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_nombre` varchar(100) NOT NULL,
  `r_descripcion` varchar(500) DEFAULT NULL,
  `r_sistema` int(11) NOT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of u_roles
-- ----------------------------
INSERT INTO `u_roles` VALUES ('1', 'ADMIN', 'ADMIN DEL SISTEMA', '1');

-- ----------------------------
-- Table structure for u_sistemas
-- ----------------------------
DROP TABLE IF EXISTS `u_sistemas`;
CREATE TABLE `u_sistemas` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `s_nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of u_sistemas
-- ----------------------------
INSERT INTO `u_sistemas` VALUES ('1', 'ADMINISTRADOR_USUARIOS');
INSERT INTO `u_sistemas` VALUES ('2', null);

-- ----------------------------
-- Table structure for u_sub_funciones
-- ----------------------------
DROP TABLE IF EXISTS `u_sub_funciones`;
CREATE TABLE `u_sub_funciones` (
  `subf_id` int(11) NOT NULL AUTO_INCREMENT,
  `subf_nombre` varchar(100) DEFAULT NULL,
  `subf_id_funcion` int(11) NOT NULL,
  PRIMARY KEY (`subf_id`,`subf_id_funcion`),
  KEY `subf_id_funcion` (`subf_id_funcion`),
  CONSTRAINT `u_sub_funciones_ibfk_1` FOREIGN KEY (`subf_id_funcion`) REFERENCES `u_funciones` (`f_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of u_sub_funciones
-- ----------------------------

-- ----------------------------
-- Table structure for u_tipo_documentos
-- ----------------------------
DROP TABLE IF EXISTS `u_tipo_documentos`;
CREATE TABLE `u_tipo_documentos` (
  `td_id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `td_tipo` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `td_prefijo` varchar(5) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`td_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

-- ----------------------------
-- Records of u_tipo_documentos
-- ----------------------------
INSERT INTO `u_tipo_documentos` VALUES ('1', 'CEDULA', 'CC');
INSERT INTO `u_tipo_documentos` VALUES ('2', 'TARJETA IDENTIDAD', 'TI');
INSERT INTO `u_tipo_documentos` VALUES ('3', 'PASAPORTE', 'PP');
INSERT INTO `u_tipo_documentos` VALUES ('4', 'NIT', 'NIT');
INSERT INTO `u_tipo_documentos` VALUES ('5', 'REGISTRO CIVIL', 'RE');

-- ----------------------------
-- Table structure for u_users
-- ----------------------------
DROP TABLE IF EXISTS `u_users`;
CREATE TABLE `u_users` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_email` varchar(150) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `u_id_rol` int(11) DEFAULT NULL,
  `u_token_security` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `u_id_tipo_identificacion` tinyint(4) NOT NULL,
  `u_numero_identificacion` varchar(15) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `u_id_sistema` int(11) NOT NULL,
  PRIMARY KEY (`u_id`,`u_id_tipo_identificacion`,`u_numero_identificacion`),
  KEY `u_user_personas` (`u_id_tipo_identificacion`,`u_numero_identificacion`),
  KEY `u_id_sistema` (`u_id_sistema`),
  KEY `u_id_rol` (`u_id_rol`),
  CONSTRAINT `u_user_personas` FOREIGN KEY (`u_id_tipo_identificacion`, `u_numero_identificacion`) REFERENCES `u_personas` (`p_id_tipo_identificacion`, `p_numero_identificacion`) ON UPDATE CASCADE,
  CONSTRAINT `u_users_ibfk_1` FOREIGN KEY (`u_id_sistema`) REFERENCES `u_sistemas` (`s_id`) ON UPDATE CASCADE,
  CONSTRAINT `u_users_ibfk_2` FOREIGN KEY (`u_id_rol`) REFERENCES `u_roles` (`r_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;

-- ----------------------------
-- Records of u_users
-- ----------------------------
