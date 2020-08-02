-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2020 at 07:54 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `mail`, `password`) VALUES
(1, 'Nikita', 'nikita@gmail.com', '123'),
(2, 'john', 'john@gmail.com', '123'),
(3, 'admin', 'admin@gmail.com', '123');

-- --------------------------------------------------------

--
-- Table structure for table `score`
--

CREATE TABLE `score` (
  `course_id` varchar(50) DEFAULT NULL,
  `stud_id` int(10) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `surname` text DEFAULT NULL,
  `eng` int(3) NOT NULL DEFAULT 0,
  `math` int(3) NOT NULL DEFAULT 0,
  `sci` int(13) NOT NULL DEFAULT 0,
  `his` int(3) NOT NULL DEFAULT 0,
  `geo` int(3) NOT NULL DEFAULT 0,
  `comp` int(3) NOT NULL DEFAULT 0,
  `total` int(5) NOT NULL,
  `avg` int(11) NOT NULL,
  `grade` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `score`
--

INSERT INTO `score` (`course_id`, `stud_id`, `name`, `surname`, `eng`, `math`, `sci`, `his`, `geo`, `comp`, `total`, `avg`, `grade`) VALUES
('CO3G', 1901, 'Raj', 'Galande', 67, 99, 90, 90, 90, 98, 534, 89, 'A'),
('CO4G', 1903, 'Nikita', 'Yadav', 78, 89, 89, 98, 78, 87, 519, 87, 'A'),
('CO2G', 1904, 'Jim', 'Halpert', 86, 67, 8, 90, 90, 90, 431, 72, 'B'),
('CO3G', 1905, 'Pam', 'Beesly', 67, 87, 67, 89, 67, 98, 475, 79, 'B'),
('CO3G', 1906, 'Jan', 'Levison', 78, 98, 78, 89, 78, 65, 486, 81, 'B'),
('CO3G', 1910, 'Pam', 'Beesly', 67, 56, 67, 45, 87, 45, 367, 61, 'C');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `t_name` varchar(50) DEFAULT NULL,
  `t_mail` varchar(50) NOT NULL,
  `t_phone` varchar(20) DEFAULT NULL,
  `t_pass` varchar(255) DEFAULT NULL,
  `t_id` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`t_name`, `t_mail`, `t_phone`, `t_pass`, `t_id`) VALUES
('Cook', 'cook@gmail.com', '1234567890', '123', '2'),
('Mike', 'michael@gmail.com', '9892043645', '123', '1'),
('Suresh', 'suresh@gmail.com', '1234567654', '123', '3');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `s_id` int(11) NOT NULL,
  `s_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `s_blood` varchar(3) NOT NULL,
  `s_phone` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `pass` int(10) DEFAULT 123
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`s_id`, `s_name`, `surname`, `s_blood`, `s_phone`, `gender`, `pass`) VALUES
(1900, 'Pam', 'Beesly', 'B+', '9892043870', 'Female', 123),
(1901, 'Raj', 'Galande', 'B+', '5862208879', 'Male', 123),
(1902, 'Raj', 'Panchal', 'A+', '2147483647', 'Male', 123),
(1903, 'Nikita', 'Yadav', 'B+', '2147483647', 'Female', 123),
(1904, 'Jim', 'Halpert', 'B+', '1234567789', 'Male', 123),
(1906, 'Jan', 'Levison', 'B+', '1234567789', 'Female', 123),
(1907, 'Ryan', 'Howard', 'B-', '1234509878', 'Male', 123),
(1908, 'Dwight', 'Schrute', 'B+', '1234567890', 'Male', 123),
(1910, 'Pam', 'Beesly', 'B+', '1235467890', 'Female', 123);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `mail` (`mail`);

--
-- Indexes for table `score`
--
ALTER TABLE `score`
  ADD PRIMARY KEY (`stud_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`t_mail`),
  ADD UNIQUE KEY `t_id` (`t_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`s_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
