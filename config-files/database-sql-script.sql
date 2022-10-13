-- MySQL Workbench Synchronization
-- Generated: 2022-10-13 15:07
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Henrique

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `mydb`.`table_registro_medico` (
  `registro_medico_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NOT NULL,
  `nome_completo` VARCHAR(45) NOT NULL,
  `area_atuante` VARCHAR(45) NOT NULL,
  `endereco_endereco_ID` INT(11) NOT NULL,
  `senha` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`registro_medico_ID`, `cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`telefone_medico` (
  `telefone_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `telefone` MEDIUMINT(12) NULL DEFAULT NULL,
  `table_registro_medico_registro_medico_ID` INT(11) NOT NULL,
  `table_registro_medico_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`telefone_ID`),
  INDEX `fk_telefone_medico_table_registro_medico1_idx` (`table_registro_medico_registro_medico_ID` ASC, `table_registro_medico_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_medico_table_registro_medico1`
    FOREIGN KEY (`table_registro_medico_registro_medico_ID` , `table_registro_medico_cpf`)
    REFERENCES `mydb`.`table_registro_medico` (`registro_medico_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`endereco_medico` (
  `endereco_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(8) NOT NULL,
  `rua` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(5) NULL DEFAULT NULL,
  `table_registro_medico_registro_medico_ID` INT(11) NOT NULL,
  `table_registro_medico_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`endereco_ID`),
  INDEX `fk_endereco_medico_table_registro_medico_idx` (`table_registro_medico_registro_medico_ID` ASC, `table_registro_medico_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_medico_table_registro_medico`
    FOREIGN KEY (`table_registro_medico_registro_medico_ID` , `table_registro_medico_cpf`)
    REFERENCES `mydb`.`table_registro_medico` (`registro_medico_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`table_conveniado` (
  `conveniado_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(14) NOT NULL,
  `nomeCompleto` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`conveniado_ID`, `cpf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`table_consulta` (
  `cod_consulta_ID` INT(11) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `hora` VARCHAR(5) NOT NULL,
  `table_conveniado_conveniado_ID` INT(11) NOT NULL,
  `table_conveniado_cpf` VARCHAR(14) NOT NULL,
  `table_registro_medico_registro_medico_ID` INT(11) NOT NULL,
  `table_registro_medico_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`cod_consulta_ID`),
  INDEX `fk_table_consulta_table_conveniado1_idx` (`table_conveniado_conveniado_ID` ASC, `table_conveniado_cpf` ASC) VISIBLE,
  INDEX `fk_table_consulta_table_registro_medico1_idx` (`table_registro_medico_registro_medico_ID` ASC, `table_registro_medico_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_table_consulta_table_conveniado1`
    FOREIGN KEY (`table_conveniado_conveniado_ID` , `table_conveniado_cpf`)
    REFERENCES `mydb`.`table_conveniado` (`conveniado_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table_consulta_table_registro_medico1`
    FOREIGN KEY (`table_registro_medico_registro_medico_ID` , `table_registro_medico_cpf`)
    REFERENCES `mydb`.`table_registro_medico` (`registro_medico_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`table_ficha_medica` (
  `cod_ficha_medica_ID` INT(11) NOT NULL,
  `table_conveniado_conveniado_ID` INT(11) NOT NULL,
  `table_conveniado_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`cod_ficha_medica_ID`),
  INDEX `fk_table_ficha_medica_table_conveniado1_idx` (`table_conveniado_conveniado_ID` ASC, `table_conveniado_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_table_ficha_medica_table_conveniado1`
    FOREIGN KEY (`table_conveniado_conveniado_ID` , `table_conveniado_cpf`)
    REFERENCES `mydb`.`table_conveniado` (`conveniado_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`table_doencas_registradas` (
  `doenca_registrada` VARCHAR(45) NOT NULL,
  `table_ficha_medica_cod_ficha_medica_ID` INT(11) NOT NULL,
  INDEX `fk_table_doencas_registradas_table_ficha_medica1_idx` (`table_ficha_medica_cod_ficha_medica_ID` ASC) VISIBLE,
  CONSTRAINT `fk_table_doencas_registradas_table_ficha_medica1`
    FOREIGN KEY (`table_ficha_medica_cod_ficha_medica_ID`)
    REFERENCES `mydb`.`table_ficha_medica` (`cod_ficha_medica_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`table_ultima_consulta` (
  `cod_ultima_consulta_ID` INT(11) NOT NULL,
  `data` VARCHAR(10) NOT NULL,
  `especialidade` VARCHAR(45) NOT NULL,
  `table_ficha_medica_cod_ficha_medica_ID` INT(11) NOT NULL,
  PRIMARY KEY (`cod_ultima_consulta_ID`),
  INDEX `fk_table_ultima_consulta_table_ficha_medica1_idx` (`table_ficha_medica_cod_ficha_medica_ID` ASC) VISIBLE,
  CONSTRAINT `fk_table_ultima_consulta_table_ficha_medica1`
    FOREIGN KEY (`table_ficha_medica_cod_ficha_medica_ID`)
    REFERENCES `mydb`.`table_ficha_medica` (`cod_ficha_medica_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`endereco_conveniado` (
  `endereco_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(8) NOT NULL,
  `rua` VARCHAR(45) NULL DEFAULT NULL,
  `numero` INT(5) NULL DEFAULT NULL,
  `table_conveniado_conveniado_ID` INT(11) NOT NULL,
  `table_conveniado_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`endereco_ID`),
  INDEX `fk_endereco_conveniado_table_conveniado1_idx` (`table_conveniado_conveniado_ID` ASC, `table_conveniado_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_conveniado_table_conveniado1`
    FOREIGN KEY (`table_conveniado_conveniado_ID` , `table_conveniado_cpf`)
    REFERENCES `mydb`.`table_conveniado` (`conveniado_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `mydb`.`telefone_conveniado` (
  `telefone_ID` INT(11) NOT NULL AUTO_INCREMENT,
  `telefone` MEDIUMINT(12) NULL DEFAULT NULL,
  `table_conveniado_conveniado_ID` INT(11) NOT NULL,
  `table_conveniado_cpf` VARCHAR(14) NOT NULL,
  PRIMARY KEY (`telefone_ID`),
  INDEX `fk_telefone_conveniado_table_conveniado1_idx` (`table_conveniado_conveniado_ID` ASC, `table_conveniado_cpf` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_conveniado_table_conveniado1`
    FOREIGN KEY (`table_conveniado_conveniado_ID` , `table_conveniado_cpf`)
    REFERENCES `mydb`.`table_conveniado` (`conveniado_ID` , `cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
