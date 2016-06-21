SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database :  `lorann`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `Add_player`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Add_player` (IN `p_Player_Name` VARCHAR(8))  BEGIN

	INSERT INTO Player (Player_Name, Player_Score)
	VALUES (p_Player_Name, 0);

	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Id ASC;

END$$

DROP PROCEDURE IF EXISTS `Delete_player`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Delete_player` (IN `p_Player_Id` INT)  BEGIN

	DELETE FROM Player_High_Scores
	WHERE Player_Id = p_Player_Id;

	DELETE FROM Player
	WHERE Player_Id = p_Player_Id;

	DELETE FROM High_Scores;

	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Id ASC;


END$$

DROP PROCEDURE IF EXISTS `Give_eleven_lives_to_Lorann`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Give_eleven_lives_to_Lorann` (IN `p_Player_Id` INT)  BEGIN

	UPDATE Main_Character
	SET Life = 11;

	UPDATE Player
	SET Player_Score = 0
	WHERE Player_Id = p_Player_Id;
	
	SELECT Player_Id, Player_Name, Player_Score
	FROM Player
	ORDER BY Player_Score DESC;

END$$

DROP PROCEDURE IF EXISTS `High_scores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `High_scores` (IN `p_Player_Id` INT, IN `p_Player_Score` INT)  BEGIN

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

END$$

DROP PROCEDURE IF EXISTS `Level_won_give_two_lives_to_Lorann`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Level_won_give_two_lives_to_Lorann` ()  BEGIN

	UPDATE Main_Character
	SET Life = Life + 2;

END$$

DROP PROCEDURE IF EXISTS `MapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MapById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM map WHERE id = p_id$$

DROP PROCEDURE IF EXISTS `MapByKey`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `MapByKey` (IN `p_key` VARCHAR(2))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM jpublankproject.map where `keywords`=p_key$$

DROP PROCEDURE IF EXISTS `Reset_scores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Reset_scores` ()  BEGIN

	UPDATE Player
	SET Player_Score = 0;

	TRUNCATE TABLE Player_High_Scores;
    
    DELETE FROM High_Scores;

END$$

DROP PROCEDURE IF EXISTS `Take_a_life_to_Lorann`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `Take_a_life_to_Lorann` ()  BEGIN

	UPDATE Main_Character
	SET Life = Life - 1
	WHERE Life > 0;

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure of the table `high_scores`
--

DROP TABLE IF EXISTS `high_scores`;
CREATE TABLE IF NOT EXISTS `high_scores` (
  `High_Score_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Player_High_Score` int(11) NOT NULL,
  PRIMARY KEY (`High_Score_Id`,`Player_High_Score`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure of the table `main_character`
--

DROP TABLE IF EXISTS `main_character`;
CREATE TABLE IF NOT EXISTS `main_character` (
  `Character_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Life` int(11) NOT NULL,
  PRIMARY KEY (`Character_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Table contents `main_character`
--

INSERT INTO `main_character` (`Character_Id`, `Name`, `Life`) VALUES
(1, 'Lorann', 11);

-- --------------------------------------------------------

--
-- Structure of the table : `map`
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
-- Table contents `map`
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
-- Structure of the the : `player`
--

DROP TABLE IF EXISTS `player`;
CREATE TABLE IF NOT EXISTS `player` (
  `Player_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Player_Name` varchar(8) NOT NULL,
  `Player_Score` int(11) NOT NULL,
  PRIMARY KEY (`Player_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Table contents `player`
--

INSERT INTO `player` (`Player_Id`, `Player_Name`, `Player_Score`) VALUES
(1, 'Axel', 0),
(2, 'Florent', 0),
(3, 'Luc', 0),
(4, 'Romain', 0);

-- --------------------------------------------------------

--
-- Structure of the table : `player_high_scores`
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
