-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: teszt
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

USE teszt;   
 
INSERT INTO rendelesek VALUES
	(10047816, 'kesszifs04', 'tablet', 'keszpenz'),
	(10047817, 'kesszifs05', 'gumino', 'bankartya'),
	(10047818, 'kesszifs06', 'pipa', 'utalvany'),
	(10047819, 'kesszifs07', 'grp', 'bonuszkod');
		
INSERT INTO vasarlo VALUES
	(1, 'Sandor Jozsef', 11, 13000, 'kesszifs04'),
	(2, 'Pok Malac', 24, 10000, 'kesszifs05'),
	(3, 'Bak Kecske', 10, 22000, 'kesszifs06'),
	(4, 'Vihar Mano', 20, 10000, 'kesszifs07');
