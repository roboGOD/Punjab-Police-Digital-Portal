-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 19, 2017 at 09:29 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `punjabpolice`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `username` varchar(50) NOT NULL,
  `password` varchar(16) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('roboGOD', 'password1'),
('roboGOD', 'password1');

-- --------------------------------------------------------

--
-- Table structure for table `criminals`
--

CREATE TABLE `criminals` (
  `serial_no` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(200) NOT NULL,
  `crime` varchar(100) NOT NULL,
  `crime_d` varchar(300) NOT NULL,
  `bounty` varchar(100) NOT NULL,
  `caught` tinyint(1) NOT NULL,
  `image` varchar(300) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `criminals`
--

INSERT INTO `criminals` (`serial_no`, `first_name`, `last_name`, `gender`, `dob`, `address`, `crime`, `crime_d`, `bounty`, `caught`, `image`) VALUES
(3, 'Kisame', 'Hoshigaki', 'Male', '1980-12-15', 'Hidden Mist Village, Land Of Water', 'Murder , Serial Killer', 'Killed Countless Shinobi Without \r\nBreaking a Sweat With Samehada', '2 Million', 0, '/PunjabPolice/Hoshigaki_Kisame.png'),
(2, 'Pablo', 'Escobar', 'Male', '1949-12-01', 'The Honey Valley , Southeast of Medellin', 'Drug Lord , Narco KingPin', 'Colombia Cartel Supplied 80%  of \nCocaine Smuggled Into The US\nTurning Over US $21.9 Billion / Year', '$ 1.4 Million', 0, '/PunjabPolice/Pablo_Escobar.jpg'),
(4, 'Madara', 'Uchiha', 'Male', '1856-02-29', 'Old Land Of Fire Without Hidden Leaf  Village', 'Infinite Tsukoyami', 'Went Against Hashirama Senju\nGot His Cells And Awakened\nRinnegan\nPut The Whole World Under Genjutsu', 'Nobody Can Put Bounty On Madara', 0, '/PunjabPolice/cY968Ugqkhc.jpg'),
(1, 'Orochimaru', ' ', 'Male', '1950-01-19', 'Village  Hidden In The Leaves , Land Of Fire', 'Murder For Experiment', 'Conducted Experiments on Live\nShinobi And Children To Master\nAll Jutsu In The World	', '20 Million', 0, '/PunjabPolice/orochimaru_by_metaknights1luver.jpg'),
(6, 'Light', 'Yagami', 'Male', '1997-09-10', 'Shinigami Kingdom', 'Mass Murder', 'Murder With DeathNote	', 'None', 0, '/PunjabPolice/Kira_Light Yagami.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `missing_persons`
--

CREATE TABLE `missing_persons` (
  `serial_no` int(10) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `height` decimal(10,0) NOT NULL,
  `weight` int(10) NOT NULL,
  `id_marks` varchar(100) NOT NULL,
  `missing_date` date NOT NULL,
  `missing_location` varchar(100) NOT NULL,
  `religion` varchar(100) NOT NULL,
  `district` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `missing_persons`
--

INSERT INTO `missing_persons` (`serial_no`, `first_name`, `last_name`, `gender`, `dob`, `height`, `weight`, `id_marks`, `missing_date`, `missing_location`, `religion`, `district`) VALUES
(1, 'Ram', 'Prasad', 'Male', '1980-08-12', '6', 70, 'None', '2017-07-02', 'Leela Bhawan', 'Hindu', 'Patiala'),
(2, 'Rakesh', 'Dhindsa', 'Male', '1990-10-16', '6', 80, 'Mole On Cheek', '2017-07-05', 'Bus Stand', 'Unknown', 'Patiala');

-- --------------------------------------------------------

--
-- Table structure for table `mobile_theft`
--

CREATE TABLE `mobile_theft` (
  `serial_no` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `father_husband_name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `mobile_comp` varchar(100) NOT NULL,
  `mobile_model` varchar(100) NOT NULL,
  `IMEI_no` varchar(20) NOT NULL,
  `Sim_comp` varchar(100) NOT NULL,
  `mob_no` varchar(100) NOT NULL,
  `theft_date` date NOT NULL,
  `theft_location` varchar(100) NOT NULL,
  `contact` varchar(13) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobile_theft`
--

INSERT INTO `mobile_theft` (`serial_no`, `first_name`, `last_name`, `father_husband_name`, `dob`, `address`, `mobile_comp`, `mobile_model`, `IMEI_no`, `Sim_comp`, `mob_no`, `theft_date`, `theft_location`, `contact`) VALUES
(1, 'Jorawar', 'Singh', 'Ravinder Singh', '1996-12-26', 'vill Bagol Kalan Teh Dasuya Dist Hoshiarpur', 'Oppo', 'F1 Plus', '1242 2948 2219 0957', 'Reliance Jio', '+918947792937', '2017-07-02', 'Eqbal Inn , Patiala', '+917489211034');

-- --------------------------------------------------------

--
-- Table structure for table `senior_citizen`
--

CREATE TABLE `senior_citizen` (
  `serial_no` int(10) NOT NULL,
  `name` varchar(100) NOT NULL,
  `gender` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `spouse` varchar(100) NOT NULL,
  `dor` date NOT NULL,
  `contact` varchar(13) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `senior_citizen`
--

INSERT INTO `senior_citizen` (`serial_no`, `name`, `gender`, `dob`, `spouse`, `dor`, `contact`) VALUES
(1, 'Some1', 'Male', '1950-12-25', 'Some2', '2010-04-10', '+919876543210'),
(2, 'Some3', 'Female', '1947-07-29', 'Some4', '2007-05-10', '+919786534201'),
(3, 'RamLal', 'Male', '1951-09-10', 'Krishna Devi', '2011-12-20', '+919646786534'),
(4, 'Jageer Kaur', 'Female', '1955-05-17', 'Sardara Ram', '2015-10-09', '+917837370923');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_theft`
--

CREATE TABLE `vehicle_theft` (
  `serial_no` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `father_husband_name` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `vehicle_type` varchar(100) NOT NULL,
  `vehicle_comp` varchar(100) NOT NULL,
  `vehicle_model` varchar(100) NOT NULL,
  `vehicle_color` varchar(100) NOT NULL,
  `license_plate_no` varchar(20) NOT NULL,
  `vehicle_id_no` varchar(20) NOT NULL,
  `theft_date` date NOT NULL,
  `theft_location` varchar(100) NOT NULL,
  `contact` varchar(13) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle_theft`
--

INSERT INTO `vehicle_theft` (`serial_no`, `first_name`, `last_name`, `father_husband_name`, `dob`, `address`, `vehicle_type`, `vehicle_comp`, `vehicle_model`, `vehicle_color`, `license_plate_no`, `vehicle_id_no`, `theft_date`, `theft_location`, `contact`) VALUES
(1, 'Naruto', 'Uzumaki', 'Minato Kamikaze', '2000-10-15', 'Village Hidden In The Leaves , Land Of Fire', 'Car', 'Kiba Motors', 'Akamaru Swift', 'White', 'LF 11 HL 7860', '9860 8342 3249 0924', '2017-07-05', 'Hidden Rain Village', 'Killer Bee'),
(2, 'Suraj', 'Singh', 'Thakur Singh', '1996-11-14', 'Ganga Bihar Colony,Patiala', 'MotorBike', 'Hero ', 'Splendor+ 2016', 'Black/Grey', 'PB 11 AX 1225', '0203 3138 1902 2981', '2017-07-03', '22. No. Phatak , Patiala', '+918338492805');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `criminals`
--
ALTER TABLE `criminals`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `missing_persons`
--
ALTER TABLE `missing_persons`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `mobile_theft`
--
ALTER TABLE `mobile_theft`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `senior_citizen`
--
ALTER TABLE `senior_citizen`
  ADD PRIMARY KEY (`serial_no`);

--
-- Indexes for table `vehicle_theft`
--
ALTER TABLE `vehicle_theft`
  ADD PRIMARY KEY (`serial_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `criminals`
--
ALTER TABLE `criminals`
  MODIFY `serial_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `missing_persons`
--
ALTER TABLE `missing_persons`
  MODIFY `serial_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `mobile_theft`
--
ALTER TABLE `mobile_theft`
  MODIFY `serial_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `senior_citizen`
--
ALTER TABLE `senior_citizen`
  MODIFY `serial_no` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `vehicle_theft`
--
ALTER TABLE `vehicle_theft`
  MODIFY `serial_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
