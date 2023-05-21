-- MySQL Script generated by MySQL Workbench
-- Sat May 20 17:03:56 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema train_schedule
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `train_schedule` ;

-- -----------------------------------------------------
-- Schema train_schedule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `train_schedule` DEFAULT CHARACTER SET utf8 ;
USE `train_schedule` ;

-- -----------------------------------------------------
-- Table `train_schedule`.`route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`route` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`route` (
  `id_route` INT NOT NULL,
  `name_route` VARCHAR(75) NULL,
  PRIMARY KEY (`id_route`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `train_schedule`.`train`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`train` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`train` (
  `id_train` INT NOT NULL AUTO_INCREMENT,
  `name_train` VARCHAR(80) NOT NULL,
  `type_train` VARCHAR(45) NOT NULL,
  `class_train` INT NOT NULL,
  `status_train` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_train`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `train_schedule`.`station`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`station` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`station` (
  `id_station` INT NOT NULL AUTO_INCREMENT,
  `name_station` VARCHAR(45) NULL,
  PRIMARY KEY (`id_station`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `train_schedule`.`track`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`track` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`track` (
  `id_track` INT NOT NULL AUTO_INCREMENT,
  `track_status` VARCHAR(45) NOT NULL,
  `track_number` INT NOT NULL,
  `id_station` INT NOT NULL,
  PRIMARY KEY (`id_track`),
  INDEX `fk_Track_Station1_idx` (`id_station` ASC) VISIBLE,
  CONSTRAINT `fk_Track_Station1`
    FOREIGN KEY (`id_station`)
    REFERENCES `train_schedule`.`station` (`id_station`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `train_schedule`.`schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`schedule` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`schedule` (
  `id_schedule` INT NOT NULL AUTO_INCREMENT,
  `arrival` TIME NOT NULL,
  `departure` TIME NOT NULL,
  `day_week` VARCHAR(12) NOT NULL,
  `trip` INT NOT NULL,
  `id_route` INT NOT NULL,
  `id_station` INT NOT NULL,
  PRIMARY KEY (`id_schedule`, `day_week`, `trip`),
  INDEX `fk_Schedule_Station1_idx` (`id_station` ASC) VISIBLE,
  INDEX `fk_Schedule_Route1_idx` (`id_route` ASC) VISIBLE,
  CONSTRAINT `fk_Schedule_Station1`
    FOREIGN KEY (`id_station`)
    REFERENCES `train_schedule`.`station` (`id_station`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Schedule_Route1`
    FOREIGN KEY (`id_route`)
    REFERENCES `train_schedule`.`route` (`id_route`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `train_schedule`.`train_has_route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `train_schedule`.`train_has_route` ;

CREATE TABLE IF NOT EXISTS `train_schedule`.`train_has_route` (
  `id_train` INT NOT NULL,
  `id_route` INT NOT NULL,
  INDEX `fk_Train_has_Route_Route1_idx` (`id_route` ASC) VISIBLE,
  INDEX `fk_Train_has_Route_Train1_idx` (`id_train` ASC) VISIBLE,
  PRIMARY KEY (`id_route`, `id_train`),
  CONSTRAINT `fk_Train_has_Route_Train1`
    FOREIGN KEY (`id_train`)
    REFERENCES `train_schedule`.`train` (`id_train`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Train_has_Route_Route1`
    FOREIGN KEY (`id_route`)
    REFERENCES `train_schedule`.`route` (`id_route`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
