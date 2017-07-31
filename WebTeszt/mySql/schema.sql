-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: teszt
-- ------------------------------------------------------

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

DROP DATABASE IF EXISTS teszt;
CREATE DATABASE IF NOT EXISTS teszt;  

USE teszt;

CREATE TABLE `rendelesek` (
  `rendelesek_id` int(11) NOT NULL,
  `vasarlo_azonsotio` varchar(50) NOT NULL,
  `termek_nev` varchar(50) DEFAULT NULL,
  `fizetesi_mod` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `vasarlo` (
  `vasarlo_id` int(11) NOT NULL,		
  `vasarlo_nev` varchar(50) NOT NULL,
  `vasarlo_pont` int(11) DEFAULT NULL,
  `vasarlot_osszeg` int(11) NOT NULL,
  `vasarlo_adatok` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `rendelesek`
  ADD PRIMARY KEY (`vasarlo_azonsotio`);

ALTER TABLE `vasarlo`
	ADD PRIMARY KEY (`vasarlo_id`),
    ADD KEY `vasarlo_adatok` (`vasarlo_adatok`);

ALTER TABLE `vasarlo`
  ADD CONSTRAINT `vasarlo_ibfk_1` FOREIGN KEY (`vasarlo_adatok`) REFERENCES `rendelesek` (`vasarlo_azonsotio`);
