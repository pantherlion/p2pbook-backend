-- MySQL Script generated by MySQL Workbench
-- Tue Apr 24 14:50:21 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema p2pbook
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `p2pbook` ;

-- -----------------------------------------------------
-- Schema p2pbook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `p2pbook` DEFAULT CHARACTER SET utf8 ;
USE `p2pbook` ;

-- -----------------------------------------------------
-- Table `p2pbook`.`t_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `p2pbook`.`t_user` ;

CREATE TABLE IF NOT EXISTS `p2pbook`.`t_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `identity` VARCHAR(45) NULL,
  `address` VARCHAR(60) NULL,
  `tel` CHAR(11) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `p2pbook`.`t_admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `p2pbook`.`t_admin` ;

CREATE TABLE IF NOT EXISTS `p2pbook`.`t_admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
