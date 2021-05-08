-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2021 at 06:23 PM
-- Server version: 10.4.18-MariaDB
-- PHP Version: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electricity`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminstration`
--

CREATE TABLE `adminstration` (
  `adminstratedid` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `number` bigint(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminstration`
--

INSERT INTO `adminstration` (`adminstratedid`, `name`, `email`, `number`, `address`, `gender`, `password`) VALUES
(1, 'Gourav patel', 'gouravpatel2798@gmail.com', 7470705945, 'Jabalpur', 'Male', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerid` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `number` bigint(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `meterno` varchar(100) NOT NULL,
  `email` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerid`, `name`, `number`, `address`, `meterno`, `email`) VALUES
(2, 'Gourav Patel', 7470705945, 'Jabalpur,(M.P.)', 'ME101', 'gouravpatel2798@gmail.com'),
(3, 'Gourav patel', 7649890352, 'Jabalpur,(M.P)', 'ME102', 'gourabhpatel2798@gmail.com'),
(4, 'Shubham Patel ', 6263992831, 'Jabalpur', 'MT103', 'shubhampatel2198@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `empolyee`
--

CREATE TABLE `empolyee` (
  `empolyeeid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `number` bigint(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `empolyee`
--

INSERT INTO `empolyee` (`empolyeeid`, `name`, `number`, `email`, `gender`, `address`, `password`) VALUES
(1, 'Gourav patel', 7470705945, 'gourabhpatel2798@gmail.com', 'Male', 'Jabalpur', '12345'),
(3, 'Atul Patel', 9171172717, 'atulpatel2898@gmail.com', 'Male', 'Jabalpur', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `transction`
--

CREATE TABLE `transction` (
  `transctionid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `month` varchar(30) NOT NULL,
  `paid` double NOT NULL,
  `totalamount` double NOT NULL,
  `currentunit` bigint(20) NOT NULL,
  `lastunit` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminstration`
--
ALTER TABLE `adminstration`
  ADD PRIMARY KEY (`adminstratedid`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerid`);

--
-- Indexes for table `empolyee`
--
ALTER TABLE `empolyee`
  ADD PRIMARY KEY (`empolyeeid`);

--
-- Indexes for table `transction`
--
ALTER TABLE `transction`
  ADD PRIMARY KEY (`transctionid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adminstration`
--
ALTER TABLE `adminstration`
  MODIFY `adminstratedid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customerid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `empolyee`
--
ALTER TABLE `empolyee`
  MODIFY `empolyeeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `transction`
--
ALTER TABLE `transction`
  MODIFY `transctionid` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
