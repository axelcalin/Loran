-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 20 Juin 2016 à 14:24
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lorann`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_player`(IN `p_Player_Name` VARCHAR(8))
BEGIN

	INSERT INTO Player (Player_Name, Player_Score)
	VALUES (p_Player_Name, 0);

	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Id ASC;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `MapById`(IN `p_id` INT)
    READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM map WHERE id = p_id

CREATE DEFINER=`root`@`localhost` PROCEDURE `Get_lives`()
    NO SQL
SELECT Life
FROM main_character

CREATE DEFINER=`root`@`localhost` PROCEDURE `Delete_player`(IN `p_Player_Id` INT)
BEGIN

	DELETE FROM Player_High_Scores
	WHERE Player_Id = p_Player_Id;

	DELETE FROM Player
	WHERE Player_Id = p_Player_Id;

	DELETE FROM High_Scores;

	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Id ASC;


END

CREATE DEFINER=`root`@`localhost` PROCEDURE `High_scores`(IN `p_Player_Id` INT, IN `p_Player_Score` INT)
BEGIN

	INSERT INTO High_Scores (Player_High_Score)
	VALUES (p_Player_Score);

	INSERT INTO Player_High_Scores (Player_Id, Player_High_Score)
	VALUES (p_Player_Id, p_Player_Score);

	UPDATE Player
	SET Player_Score = p_Player_Score
	WHERE Player_Id = p_Player_Id;

	SELECT Player_Id, Player_High_Score
	FROM Player_High_Scores
	ORDER BY Player_High_Score DESC;

	SELECT Player_Id, Player_Name, Player_Score
	FROM Player;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `Give_two_lives`()
BEGIN

	UPDATE Main_Character
	SET Life = Life + 2;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `MapByKey`(IN `p_key` VARCHAR(2))
    READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM jpublankproject.map where `keywords`=p_key

CREATE DEFINER=`root`@`localhost` PROCEDURE `Remove_life`()
BEGIN

	UPDATE Main_Character
	SET Life = Life - 1
	WHERE Life > 0;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `Reset_Lives`(IN `p_Player_Id` INT)
BEGIN

	UPDATE Main_Character
	SET Life = 11;

	UPDATE Player
	SET Player_Score = 0
	WHERE Player_Id = p_Player_Id;
	
	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Score DESC;

END

CREATE DEFINER=`root`@`localhost` PROCEDURE `Reset_scores`()
BEGIN

	UPDATE Player
	SET Player_Score = 0;

	TRUNCATE TABLE Player_High_Scores;
    
    DELETE FROM High_Scores;

END

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `high_scores`
--

DROP TABLE IF EXISTS `high_scores`;
CREATE TABLE IF NOT EXISTS `high_scores` (
  `High_Score_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Player_High_Score` int(11) NOT NULL,
  PRIMARY KEY (`High_Score_Id`,`Player_High_Score`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `main_character`
--

DROP TABLE IF EXISTS `main_character`;
CREATE TABLE IF NOT EXISTS `main_character` (
  `Character_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Life` int(11) NOT NULL,
  PRIMARY KEY (`Character_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `main_character`
--

INSERT INTO `main_character` (`Character_Id`, `Name`, `Life`) VALUES
(1, 'Lorann', 11);

-- --------------------------------------------------------

--
-- Structure de la table `map`
--

DROP TABLE IF EXISTS `map`;
CREATE TABLE IF NOT EXISTS `map` (
  `Map_id` int(11) NOT NULL AUTO_INCREMENT,
  `keywords` varchar(250) NOT NULL,
  `map` varchar(500) NOT NULL,
  PRIMARY KEY (`Map_id`),
  UNIQUE KEY `key_UNIQUE` (`keywords`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `map`
--

INSERT INTO `map` (`Map_id`, `keywords`, `map`) VALUES
(1, 'n1', 'WWWWWWPOPOOOOOOOOOPW\nWWWPOOPUIWWWWWWWWWPP\nWWWIWCWWIWWWWWWWWWWI\nPOOPWWWWIWWWSWWWWWWI\nIWSWPOOOPOOOOOPWWWWP\nISWWZTWWWWWWBWWWLWWD\nIWSWPOOOPOOOOOPWWWWP\nPOOPWWWWIWWWSWWWWWWI\nWWWIWCWWIWWWWWWWWWWI\nWWWPOOPUIWWWWWWWWWPP\nWWWWWWPOPOOOOOOOOOPW\nWWWWWWWWWWWWWWWWWWWW'),
(2, 'n2', 'POOOOOOOOOOOOOOOOOOP\nIWWWWWWWWWWWWTWWWWBI\nIWPOPWZWPOPWWWYWWWWI\nIWWWWWWWWWWWWWWKWWWI\nIWWWPOPWSWPOPWWWAWWI\nIWWWWWWWWWWWWWWWWSWI\nIWWWWWPOPWSWPOPWWWSI\nIWWWWWWWWWWWWWWWWWWI\nIWWWWWWWPOPWSWPOPWWI\nIWWLWWWWWWWWWWWWWWWI\nIDWWWWWWWWPOPWSWPOOP\nPOOOOOOOOOPWPOOOPWWW\n'),
(3, 'n3', 'POOOOOOOOOOOOOOOOOOP\nIYWWWWWWWWWWWWWWWWWI\nPOPDPOPWWWWWWWPOPCPP\nWWWWWWIPSPPPUPIWPOPW\nWWWWWWIWWWLWWWIWWWWW\nWWWWWWIWWWWWWWIWWWWW\nWWWWWWIPSPPPUPIWPOPW\nWWPOPWIWWWPWWWIWIKIW\nPOPBPOPWWWIWWWPOPWPP\nIWWWWWWWWWIWWWWWWWWI\nIAWWWWWWWWIWWWWWWWZI\nPOOOOOOOOOPOOOOOOOOP'),
(4, 'n4', 'WWPPOOOOOOOOOOOOOOOP\nWPPWWWWWWWWWWWWWWWWI\nPPWWWWWWWWWWWWWWWLWI\nPWDWPOOOOOOOPGPWPOOP\nIWWWIWWWWAWWWWIWWWWI\nIWWWIWPOOOOOOOPOOPWI\nIWWWIWWWWYWWWGIWWWWI\nIWWWPOOOOOOOPWIWPOOP\nIWWWIWWWWKWWWGIWWWWI\nPPPWIWPOOOOOOPPOOPWI\nIBWWIWWWWTWWGIGWZWWI\nPOOOPOOOOOOOOPOOOOOP'),
(6, 'n5', 'WWPOOPOOOOOOOOOOOPWW\nWPPWWPWWWWWWWWWWWPPW\nPPWWWWWPGPSPSPGPWZPP\nIWWPPPWPOPOPOPOPPWWI\nIWWPIIWWWWWWWWWIWWWI\nIWWWIPOPWPOOOPWIPWWI\nIWWPIIWWWPOPWWWIWWWI\nIWWWPPLWWPOPWWDIPWWI\nIWWPOOOOPOOOOOOPPWWI\nPPWWPUPUPCPUPUPPKBPP\nWPPWWWWWWYWWTWWAWPPW\nWWPOOOOOOOOOOOOOOPWW'),
(7, 'me', 'POOOOOOOOOOOOOOOOOOP\nIWWWWWWWWWLWWWWWWWWI\nIWWPOPOOOOOOOOPOPWWI\nIWWWWIWWWWWWWWIWWWWI\nPOOPWIWWWWWWWWIWPOOP\nEWWPWIWWWWWWWWIWPWWE\nPPWWWIWWWAWWWWIWWWPP\nPPOOOPWWWWWWWWPOOOPP\nIWWWWIWWWWWWWWIWWWWI\nPOOOOPWWWWWWWWPOOOOP\nIWWWWWWWWWWWWWWWWWWI\nPOOOOOOOOOOOOOOOOOOP'),
(10, 'ha', 'POOOOOOOOOOOOOOOOOOP\r\nIWWWWWWWWWWWWWWWWWWI\r\nEWWWWWWWWWWWWWWWWWWI\r\nIWWWWWWWWWWWWWWWWWWI\r\nEWWWWWWWWWWWWWWWWWWI\r\nIWWWWWWWWWWWWWWWWWWI\r\nEWWWWWWWWWWWWWWWWWWE\r\nIWWWWWWWWWWWWWWWWWWI\r\nEWWWWWWWWWWWWWWWWWWI\r\nIWWWWWWWWWWWWWWWWWWI\r\nEWWWWWWWWWWWWWWWWWWI\r\nIWWWWWWWWWWWWWWWWWWI\r\nPOOOOOOOOOOOOOOOOOOP');

-- --------------------------------------------------------

--
-- Structure de la table `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `Player_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Player_Name` varchar(8) NOT NULL,
  `Player_Score` int(11) NOT NULL,
  PRIMARY KEY (`Player_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `player`
--

INSERT INTO `player` (`Player_Id`, `Player_Name`, `Player_Score`) VALUES
(1, 'Axel', 0),
(2, 'Florent', 0),
(3, 'Luc', 0),
(4, 'Romain', 0);

-- --------------------------------------------------------

--
-- Structure de la table `player_high_scores`
--

DROP TABLE IF EXISTS `player_high_scores`;
CREATE TABLE IF NOT EXISTS `player_high_scores` (
  `Player_Id` int(11) NOT NULL,
  `Player_High_Score` int(11) NOT NULL,
  PRIMARY KEY (`Player_Id`,`Player_High_Score`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
