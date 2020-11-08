-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema estacione_aqui
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema estacione_aqui
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `estacione_aqui` DEFAULT CHARACTER SET utf8 ;
USE `estacione_aqui` ;

-- -----------------------------------------------------
-- Table `estacione_aqui`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`clientes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cpf` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_7wflw78ibh162cmq12ii6ffly` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacione_aqui`.`servicos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`servicos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(255) NULL DEFAULT NULL,
  `preco_por_hora` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacione_aqui`.`vagas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`vagas` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `localizacao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_5c7hh1n2au1l3g7kj4khctboi` (`localizacao` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 15
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacione_aqui`.`veiculos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`veiculos` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cor` VARCHAR(255) NULL DEFAULT NULL,
  `modelo` VARCHAR(255) NULL DEFAULT NULL,
  `observacoes` LONGTEXT NULL DEFAULT NULL,
  `placa` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_ti2seg7u1j0clbvwol5x11jmv` (`placa` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacione_aqui`.`movimentacoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`movimentacoes` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `entrada` DATETIME(6) NOT NULL,
  `saida` DATETIME(6) NULL DEFAULT NULL,
  `valor` DOUBLE NULL DEFAULT NULL,
  `cliente_id` BIGINT NOT NULL,
  `servico_id` BIGINT NOT NULL,
  `vaga_id` BIGINT NOT NULL,
  `veiculo_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKphdle3ph3mg6lxkfi7agcyweg` (`cliente_id` ASC) VISIBLE,
  INDEX `FK5vpxgwro3rvjk02rxvrmxk302` (`servico_id` ASC) VISIBLE,
  INDEX `FKhokbxuh2ly96nd7rkasa07occ` (`vaga_id` ASC) VISIBLE,
  INDEX `FKou0cwh9kquurn0bdgj0x7v33t` (`veiculo_id` ASC) VISIBLE,
  CONSTRAINT `FK5vpxgwro3rvjk02rxvrmxk302`
    FOREIGN KEY (`servico_id`)
    REFERENCES `estacione_aqui`.`servicos` (`id`),
  CONSTRAINT `FKhokbxuh2ly96nd7rkasa07occ`
    FOREIGN KEY (`vaga_id`)
    REFERENCES `estacione_aqui`.`vagas` (`id`),
  CONSTRAINT `FKou0cwh9kquurn0bdgj0x7v33t`
    FOREIGN KEY (`veiculo_id`)
    REFERENCES `estacione_aqui`.`veiculos` (`id`),
  CONSTRAINT `FKphdle3ph3mg6lxkfi7agcyweg`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `estacione_aqui`.`clientes` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `estacione_aqui`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `estacione_aqui`.`usuario` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
