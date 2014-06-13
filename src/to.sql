-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Hoszt: 127.0.0.1
-- Létrehozás ideje: 2014. jún. 12. 16:54
-- Szerver verzió: 5.5.27
-- PHP verzió: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Adatbázis: `torpedo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet: `relationship`
--

CREATE TABLE IF NOT EXISTS `relationship` (
  `user1` varchar(20) NOT NULL,
  `user2` varchar(20) NOT NULL,
  PRIMARY KEY (`user1`,`user2`),
  KEY `user1` (`user1`),
  KEY `user2` (`user2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- A tábla adatainak kiíratása `relationship`
--

INSERT INTO `relationship` (`user1`, `user2`) VALUES
('a', '12122'),
('a', 'dfg'),
('asd', 'a'),
('fdfgdf', 'a');

-- --------------------------------------------------------

--
-- Tábla szerkezet: `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  `country` varchar(30) NOT NULL,
  `win` int(11) NOT NULL DEFAULT '0',
  `lose` int(11) NOT NULL DEFAULT '0',
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`,`nickname`),
  KEY `username_2` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=24 ;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `username`, `nickname`, `pwd`, `country`, `win`, `lose`, `status`, `date`) VALUES
(1, 'asd', 'asda', 'asdas', 'asda', 0, 0, 1, '0000-00-00'),
(2, 'fdg', 'fdg', 'dfg', 'Value 2', 0, 0, 0, '0000-00-00'),
(3, 'fdgdfg', 'fdgdfg', 'dgdfg', 'Value 0', 0, 0, 0, '1990-01-21'),
(4, '56565656', '56565656', '456456', 'Value 4', 0, 0, 0, '2014-05-10'),
(5, 'dfg', 'dfg', 'gdg', 'Value 0', 0, 0, 1, '2014-05-10'),
(6, 'a', 'a', 'a', 'Value 0', 0, 0, 0, '2014-05-10'),
(7, 'dfdsf', 'dfdsf', 'dsdfsd', 'Value 0', 0, 0, 0, '2014-05-11'),
(9, '12122', '12122', 'dsdfsd', 'Value 0', 0, 0, 0, '2014-05-11'),
(13, 'fdfgdf', 'fdfgdf', 'dfgdg', 'Value 0', 0, 0, 1, '2014-05-11'),
(14, 'ssssss3', 'ssssss', 'asdsss', 'Value 0', 0, 0, 0, '2014-05-11'),
(23, 'ssssss3', 'sssdsdsdsds', '12345', 'Value 0', 0, 0, 0, '2014-05-11');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
