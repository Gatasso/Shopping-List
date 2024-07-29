-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema db_listaMercado
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema db_listaMercado
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_listaMercado` ;
USE `db_listaMercado` ;

-- -----------------------------------------------------
-- Table `db_listaMercado`.`tb_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_listaMercado`.`tb_product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name_product` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_listaMercado`.`tb_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_listaMercado`.`tb_list` (
  `id_list` INT NOT NULL AUTO_INCREMENT,
  `creation_date` DATE NOT NULL,
  `shop_name` VARCHAR(50) NULL,
  `total` DOUBLE NULL,
  `status` INT NOT NULL,
  PRIMARY KEY (`id_list`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `db_listaMercado`.`tb_list_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_listaMercado`.`tb_list_item` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `quantity` DOUBLE NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `shop_status` INT NOT NULL,
  `tb_product_id_product` INT NOT NULL,
  `tb_list_id_list` INT NOT NULL,
  PRIMARY KEY (`id_item`),
  INDEX `fk_tb_list_item_tb_product_idx` (`tb_product_id_product` ASC) VISIBLE,
  INDEX `fk_tb_list_item_tb_list1_idx` (`tb_list_id_list` ASC) VISIBLE,
  CONSTRAINT `fk_tb_list_item_tb_product`
    FOREIGN KEY (`tb_product_id_product`)
    REFERENCES `db_listaMercado`.`tb_product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_list_item_tb_list1`
    FOREIGN KEY (`tb_list_id_list`)
    REFERENCES `db_listaMercado`.`tb_list` (`id_list`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
