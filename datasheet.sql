-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2023 at 10:52 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `appointmentmanagementsystem`
--

-- --------------------------------------------------------

--
-- Table structure for table `datasheet`
--

CREATE TABLE `datasheet` (
  `ID` int(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Number` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Type` varchar(255) NOT NULL,
  `Date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `datasheet`
--

INSERT INTO `datasheet` (`ID`, `Name`, `Number`, `Email`, `Type`, `Date`) VALUES
(5, 'nirwisha radanakaya', '5456465', 'dssdfsfsdfs', 'Type A', '2023-11-22'),
(6, 'Bhathiya', '23423', '23423', 'Type A', '2023-11-07'),
(8, 'gfnfgnfgf', '21312', '123123', 'Type C', '2023-11-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `datasheet`
--
ALTER TABLE `datasheet`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `datasheet`
--
ALTER TABLE `datasheet`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
