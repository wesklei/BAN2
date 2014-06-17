-- phpMyAdmin SQL Dump
-- version 4.2.3
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 16, 2014 at 11:53 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ban2_trabalho`
--
CREATE DATABASE IF NOT EXISTS `ban2_trabalho` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ban2_trabalho`;

DELIMITER $$
--
-- Functions
--
DROP FUNCTION IF EXISTS `carga_horario_periodo`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `carga_horario_periodo`(id_periodo INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE total INT;
	SELECT SUM(chTotal) INTO total FROM disciplina,plano,periodo WHERE disciplina.idDisciplina = plano.Disciplina_idDisciplina AND plano.idPlano=periodo.Plano_idPlano AND idPeriodo = id_periodo;
	RETURN total;
END$$

DROP FUNCTION IF EXISTS `todosPrerequisitos`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `todosPrerequisitos`(id_disciplina INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE allPrerequisitos varchar(1000);
	SELECT GROUP_CONCAT(PreRequisitos_idPreRequisitos) INTO allPrerequisitos FROM disciplina_has_prerequisitos WHERE disciplina_has_prerequisitos.Disciplina_idDisciplina =  id_disciplina AND disciplina_has_prerequisitos.PreRequisitos_idPreRequisitos=PreRequisitos_idPreRequisitos;
	RETURN allPrerequisitos;
END$$

DROP FUNCTION IF EXISTS `todos_prerequisito`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `todos_prerequisito`(id_disciplina INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE allPrerequisitos varchar(1000);
	SELECT GROUP_CONCAT(PreRequisitos_idPreRequisitos) INTO allPrerequisitos FROM disciplina_has_prerequisitos WHERE disciplina_has_prerequisitos.Disciplina_idDisciplina =  id_disciplina AND disciplina_has_prerequisitos.PreRequisitos_idPreRequisitos=PreRequisitos_idPreRequisitos;
	RETURN allPrerequisitos;
END$$

DROP FUNCTION IF EXISTS `todos_prerequisitos`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `todos_prerequisitos`(id_disciplina INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE allPrerequisitos varchar(1000);
	SELECT GROUP_CONCAT(PreRequisitos_idPreRequisitos) INTO allPrerequisitos FROM disciplina_has_prerequisitos WHERE disciplina_has_prerequisitos.Disciplina_idDisciplina =  id_disciplina AND disciplina_has_prerequisitos.PreRequisitos_idPreRequisitos=PreRequisitos_idPreRequisitos;
	RETURN total;
END$$

DROP FUNCTION IF EXISTS `todo_pprerequisitos`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `todo_pprerequisitos`(id_disciplina INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE allPrerequisitos varchar(1000);
	SELECT PreRequisitos_idPreRequisitos INTO allPrerequisitos FROM disciplina_has_prerequisitos WHERE disciplina_has_prerequisitos.Disciplina_idDisciplina =  id_disciplina AND disciplina_has_prerequisitos.PreRequisitos_idPreRequisitos=PreRequisitos_idPreRequisitos;
	RETURN allPrerequisitos;
END$$

DROP FUNCTION IF EXISTS `todo_Prerequisitos`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `todo_Prerequisitos`(id_disciplina INT ) RETURNS int(11)
    DETERMINISTIC
BEGIN
	DECLARE allPrerequisitos varchar(1000);
	SELECT GROUP_CONCAT(PreRequisitos_idPreRequisitos),PreRequisitos_idPreRequisitos INTO allPrerequisitos FROM disciplina_has_prerequisitos WHERE disciplina_has_prerequisitos.Disciplina_idDisciplina =  id_disciplina AND disciplina_has_prerequisitos.PreRequisitos_idPreRequisitos=PreRequisitos_idPreRequisitos;
	RETURN allPrerequisitos;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bibliografiacomplementar`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `bibliografiacomplementar`;
CREATE TABLE IF NOT EXISTS `bibliografiacomplementar` (
`idBibliografiaComplementar` int(11) NOT NULL,
  `Plano_idPlano` int(11) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `titulo` varchar(80) NOT NULL,
  `ano` int(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `bibliografiacomplementar`
--

INSERT INTO `bibliografiacomplementar` (`idBibliografiaComplementar`, `Plano_idPlano`, `autor`, `titulo`, `ano`) VALUES(0, 0, 'BRUSILOVSKY', 'BIG DATA', 2001);
INSERT INTO `bibliografiacomplementar` (`idBibliografiaComplementar`, `Plano_idPlano`, `autor`, `titulo`, `ano`) VALUES(1, 0, 'a', 'a', 2000);

--
-- Triggers `bibliografiacomplementar`
--
DROP TRIGGER IF EXISTS `mesma_bibliografia_complementar`;
DELIMITER //
CREATE TRIGGER `mesma_bibliografia_complementar` BEFORE INSERT ON `bibliografiacomplementar`
 FOR EACH ROW BEGIN
    IF (SELECT COUNT(*) FROM bibliografiacomplementar WHERE autor = NEW.autor AND titulo = NEW.titulo AND ano = NEW.ano) > 0 THEN
       SET NEW='Erro: Bibliografia Comnplementar já existe';
       # apenas para teste
       INSERT INTO bibliografiacomplementar VALUES (NULL, 'ERRO', 999);
    END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `bibliografiageral`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `bibliografiageral`;
CREATE TABLE IF NOT EXISTS `bibliografiageral` (
`idBibliografiaGeral` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `autor` varchar(40) NOT NULL,
  `titulo` varchar(40) NOT NULL,
  `ano` int(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `bibliografiageral`
--

INSERT INTO `bibliografiageral` (`idBibliografiaGeral`, `Disciplina_idDisciplina`, `autor`, `titulo`, `ano`) VALUES(0, 0, 'GASPARINI', 'Modelagem do Usuário no Contexto Educaci', 2011);
INSERT INTO `bibliografiageral` (`idBibliografiaGeral`, `Disciplina_idDisciplina`, `autor`, `titulo`, `ano`) VALUES(2, 0, 'a', 'a', 2000);

--
-- Triggers `bibliografiageral`
--
DROP TRIGGER IF EXISTS `mesma_bibliografia_geral`;
DELIMITER //
CREATE TRIGGER `mesma_bibliografia_geral` BEFORE INSERT ON `bibliografiageral`
 FOR EACH ROW BEGIN
    IF (SELECT COUNT(*) FROM bibliografiageral WHERE autor = NEW.autor AND titulo = NEW.titulo AND ano = NEW.ano) > 0 THEN
        SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Erro: Bibliografia Geral já existe';
    END IF;
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `cronograma`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `cronograma`;
CREATE TABLE IF NOT EXISTS `cronograma` (
`idCronograma` int(11) NOT NULL,
  `Plano_idPlano` int(11) NOT NULL,
  `chParcial` int(2) NOT NULL,
  `conteudo` varchar(250) NOT NULL,
  `avaliacao` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `cronograma`
--

INSERT INTO `cronograma` (`idCronograma`, `Plano_idPlano`, `chParcial`, `conteudo`, `avaliacao`) VALUES(0, 0, 5, 'DIAGRAMA UML', 'A1');

-- --------------------------------------------------------

--
-- Table structure for table `curso`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `curso`;
CREATE TABLE IF NOT EXISTS `curso` (
`idCurso` int(11) NOT NULL,
  `Departamento_idDepartamento` int(11) NOT NULL,
  `nome_curso` varchar(40) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `curso`
--

INSERT INTO `curso` (`idCurso`, `Departamento_idDepartamento`, `nome_curso`) VALUES(1, 0, 'Bacharelado em Ciência da Computação');

-- --------------------------------------------------------

--
-- Table structure for table `departamento`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
`idDepartamento` int(11) NOT NULL,
  `nome_dep` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `departamento`
--

INSERT INTO `departamento` (`idDepartamento`, `nome_dep`) VALUES(0, 'Departamento de Ciência da Computação');

-- --------------------------------------------------------

--
-- Table structure for table `disciplina`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `disciplina`;
CREATE TABLE IF NOT EXISTS `disciplina` (
`idDisciplina` int(11) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL,
  `nome_disc` varchar(40) NOT NULL,
  `sigla` varchar(40) NOT NULL,
  `chTotal` int(3) NOT NULL,
  `chTeorica` int(2) NOT NULL,
  `chPratica` int(2) NOT NULL,
  `ementa` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `disciplina`
--

INSERT INTO `disciplina` (`idDisciplina`, `Curso_idCurso`, `nome_disc`, `sigla`, `chTotal`, `chTeorica`, `chPratica`, `ementa`) VALUES(0, 1, 'Linguagem de Programação', 'LPG0001', 60, 30, 30, 'Conceitos Básicos, Conceitos Avançados');

-- --------------------------------------------------------

--
-- Table structure for table `disciplina_has_prerequisitos`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `disciplina_has_prerequisitos`;
CREATE TABLE IF NOT EXISTS `disciplina_has_prerequisitos` (
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `PreRequisitos_idPreRequisitos` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `disciplina_has_prerequisitos`
--

INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 0);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 0);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 0);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 1);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 2);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 0);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 1);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 2);
INSERT INTO `disciplina_has_prerequisitos` (`Disciplina_idDisciplina`, `PreRequisitos_idPreRequisitos`) VALUES(0, 3);

-- --------------------------------------------------------

--
-- Table structure for table `periodo`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `periodo`;
CREATE TABLE IF NOT EXISTS `periodo` (
`idPeriodo` int(11) NOT NULL,
  `Plano_idPlano` int(11) NOT NULL,
  `ano` int(4) NOT NULL,
  `semestre` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `periodo`
--

INSERT INTO `periodo` (`idPeriodo`, `Plano_idPlano`, `ano`, `semestre`) VALUES(0, 0, 2012, 2);

-- --------------------------------------------------------

--
-- Table structure for table `plano`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `plano`;
CREATE TABLE IF NOT EXISTS `plano` (
`idPlano` int(11) NOT NULL,
  `Disciplina_idDisciplina` int(11) NOT NULL,
  `objetivoGeral` varchar(255) NOT NULL,
  `objetivoEspecifico` varchar(255) NOT NULL,
  `metodologia` varchar(255) NOT NULL,
  `criterios` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `plano`
--

INSERT INTO `plano` (`idPlano`, `Disciplina_idDisciplina`, `objetivoGeral`, `objetivoEspecifico`, `metodologia`, `criterios`) VALUES(0, 0, 'Objetivo dessa disciplina é apresentar diversos...', 'Aprender os conceitos de programação estruturada', 'A metodologia baseia-se em teoria e prática', 'Critérios são: AV1, E2, AV2, E1');

-- --------------------------------------------------------

--
-- Table structure for table `prerequisitos`
--
-- Creation: Jun 17, 2014 at 02:43 AM
--

DROP TABLE IF EXISTS `prerequisitos`;
CREATE TABLE IF NOT EXISTS `prerequisitos` (
`idPreRequisitos` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `prerequisitos`
--

INSERT INTO `prerequisitos` (`idPreRequisitos`) VALUES(0);
INSERT INTO `prerequisitos` (`idPreRequisitos`) VALUES(1);
INSERT INTO `prerequisitos` (`idPreRequisitos`) VALUES(2);
INSERT INTO `prerequisitos` (`idPreRequisitos`) VALUES(3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bibliografiacomplementar`
--
ALTER TABLE `bibliografiacomplementar`
 ADD PRIMARY KEY (`idBibliografiaComplementar`), ADD KEY `Plano_idPlano` (`Plano_idPlano`);

--
-- Indexes for table `bibliografiageral`
--
ALTER TABLE `bibliografiageral`
 ADD PRIMARY KEY (`idBibliografiaGeral`), ADD KEY `Disciplina_idDisciplina` (`Disciplina_idDisciplina`);

--
-- Indexes for table `cronograma`
--
ALTER TABLE `cronograma`
 ADD PRIMARY KEY (`idCronograma`), ADD KEY `Plano_idPlano` (`Plano_idPlano`);

--
-- Indexes for table `curso`
--
ALTER TABLE `curso`
 ADD PRIMARY KEY (`idCurso`), ADD KEY `Departamento_idDepartamento` (`Departamento_idDepartamento`);

--
-- Indexes for table `departamento`
--
ALTER TABLE `departamento`
 ADD PRIMARY KEY (`idDepartamento`);

--
-- Indexes for table `disciplina`
--
ALTER TABLE `disciplina`
 ADD PRIMARY KEY (`idDisciplina`), ADD KEY `Curso_idCurso` (`Curso_idCurso`);

--
-- Indexes for table `disciplina_has_prerequisitos`
--
ALTER TABLE `disciplina_has_prerequisitos`
 ADD KEY `Disciplina_idDisciplina` (`Disciplina_idDisciplina`), ADD KEY `PreRequisitos_idPreRequisitos` (`PreRequisitos_idPreRequisitos`);

--
-- Indexes for table `periodo`
--
ALTER TABLE `periodo`
 ADD PRIMARY KEY (`idPeriodo`), ADD KEY `Plano_idPlano` (`Plano_idPlano`);

--
-- Indexes for table `plano`
--
ALTER TABLE `plano`
 ADD PRIMARY KEY (`idPlano`), ADD KEY `Disciplina_idDisciplina` (`Disciplina_idDisciplina`);

--
-- Indexes for table `prerequisitos`
--
ALTER TABLE `prerequisitos`
 ADD PRIMARY KEY (`idPreRequisitos`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bibliografiacomplementar`
--
ALTER TABLE `bibliografiacomplementar`
MODIFY `idBibliografiaComplementar` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `bibliografiageral`
--
ALTER TABLE `bibliografiageral`
MODIFY `idBibliografiaGeral` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `cronograma`
--
ALTER TABLE `cronograma`
MODIFY `idCronograma` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `curso`
--
ALTER TABLE `curso`
MODIFY `idCurso` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `departamento`
--
ALTER TABLE `departamento`
MODIFY `idDepartamento` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `disciplina`
--
ALTER TABLE `disciplina`
MODIFY `idDisciplina` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `periodo`
--
ALTER TABLE `periodo`
MODIFY `idPeriodo` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `plano`
--
ALTER TABLE `plano`
MODIFY `idPlano` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prerequisitos`
--
ALTER TABLE `prerequisitos`
MODIFY `idPreRequisitos` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `bibliografiacomplementar`
--
ALTER TABLE `bibliografiacomplementar`
ADD CONSTRAINT `bibliografiacomplementar_ibfk_1` FOREIGN KEY (`Plano_idPlano`) REFERENCES `plano` (`idPlano`);

--
-- Constraints for table `bibliografiageral`
--
ALTER TABLE `bibliografiageral`
ADD CONSTRAINT `bibliografiageral_ibfk_1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`);

--
-- Constraints for table `cronograma`
--
ALTER TABLE `cronograma`
ADD CONSTRAINT `cronograma_ibfk_1` FOREIGN KEY (`Plano_idPlano`) REFERENCES `plano` (`idPlano`);

--
-- Constraints for table `curso`
--
ALTER TABLE `curso`
ADD CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`Departamento_idDepartamento`) REFERENCES `departamento` (`idDepartamento`);

--
-- Constraints for table `disciplina`
--
ALTER TABLE `disciplina`
ADD CONSTRAINT `disciplina_ibfk_1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`);

--
-- Constraints for table `disciplina_has_prerequisitos`
--
ALTER TABLE `disciplina_has_prerequisitos`
ADD CONSTRAINT `disciplina_has_prerequisitos_ibfk_1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`),
ADD CONSTRAINT `disciplina_has_prerequisitos_ibfk_2` FOREIGN KEY (`PreRequisitos_idPreRequisitos`) REFERENCES `prerequisitos` (`idPreRequisitos`);

--
-- Constraints for table `periodo`
--
ALTER TABLE `periodo`
ADD CONSTRAINT `periodo_ibfk_1` FOREIGN KEY (`Plano_idPlano`) REFERENCES `plano` (`idPlano`);

--
-- Constraints for table `plano`
--
ALTER TABLE `plano`
ADD CONSTRAINT `plano_ibfk_1` FOREIGN KEY (`Disciplina_idDisciplina`) REFERENCES `disciplina` (`idDisciplina`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
