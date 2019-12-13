-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2018 at 10:37 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `new_schema`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Email` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Phone No` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Email`, `Password`, `Phone No`, `Name`) VALUES
('admin', '123', '9646660981', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `coursename` varchar(45) NOT NULL,
  `departmentname` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`coursename`, `departmentname`, `description`) VALUES
('auto machinery', 'MECHANICAL', 'bikes'),
('auto mobiles', 'MECHANICAL', 'cars'),
('B. Pharmacy', 'MBBS', 'BAMS'),
('bridges', 'CIVIL', 'road and bridges'),
('Builder', 'CIVIL', 'very hard working'),
('coders', 'CSE', 'java professionals'),
('D.Pharmacy', 'MBBS', 'BDS'),
('Pharmacy', 'MBBS', 'logical'),
('RDBMS', 'CSE', 'database management system');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `departmentname` varchar(45) NOT NULL,
  `description` varchar(100) NOT NULL,
  `departmenthead` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phoneno` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`departmentname`, `description`, `departmenthead`, `email`, `phoneno`) VALUES
('CIVIL', 'Civil', 'samjh sir', 'samjh@.gmail.com', '412854125'),
('CSE', 'Computer Science', 'mr.soch', 'samjh@gmail.com', '89765463467'),
('MBBS', 'Doctors', 'sukhman preet', 'sukhmanpreet@gmail.com', '57874165767'),
('MECHANICAL', 'Auto mechanics', 'RK.mangotra', 'rk@gmail.com', '56456854185');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `departmentname` varchar(45) NOT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `experience` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`Username`, `Password`, `departmentname`, `coursename`, `email`, `phone`, `address`, `qualification`, `experience`, `photo`) VALUES
('kapil', '123', 'CSE', 'coders', 'muskankhatri@gmail.com', '9646660981', 'lajpat nagar,delhi', 'M.tech', '5', 'src/content/1532682372050.png'),
('khatrimuskan', '8246', 'CIVIL', 'Builder', 'khatrimuskan@gmail.com', '9878765476', 'Khazana Gate ,Amritsar.', 'engeenier', '5', 'src/content/1532598984639.jpeg'),
('KS.sharma', '9556', 'MECHANICAL', 'auto machinery', 'ks@gmail.com', '1452144552', 'lohri gate,asr', 'mechanical', '1', 'src/content/1532515882450.jpg'),
('mk.khatri', '2816', 'MBBS', 'B. Pharmacy', 'mk@gmail.com', '12541254', 'lohgarh,asr', 'MBBS', '4', 'src/content/1532515640773.jpg'),
('raman kumar', '3525', 'MBBS', 'D.Pharmacy', 'ramankumar@gmail.com', '574856', '26_a, basant avenue', 'mbbs(ftcm)', '6', 'src/content/1532601902651.jpg'),
('ravi', '1675', 'CIVIL', 'Builder', '', '', '', '', '', 'src/content/1532599016056.jpeg'),
('ravikant', '2644', 'CIVIL', 'Builder', 'ravi@yahoo.com', '123654', 'rani bagh', 'faltu', '0', 'src/content/1532508845043.jpg'),
('Rk.gautam', '5905', 'MBBS', 'D.Pharmacy', 'rk.gautam@gmail.com', '145214521', 'rani ka bagh,asr', 'MBBS', '2', 'src/content/1532515756435.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `notedetails`
--

CREATE TABLE `notedetails` (
  `ndid` int(11) NOT NULL,
  `rollno` int(11) NOT NULL,
  `nid` int(11) NOT NULL,
  `datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notedetails`
--

INSERT INTO `notedetails` (`ndid`, `rollno`, `nid`, `datetime`) VALUES
(1, 107223, 3, '2018-08-01 17:00:00'),
(3, 107223, 5, '2018-07-26 10:48:34'),
(4, 107223, 6, '2018-07-26 10:51:45'),
(5, 107223, 7, '2018-07-26 10:52:35'),
(6, 41254, 8, '2018-07-27 09:08:00');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `nid` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `description` varchar(45) NOT NULL,
  `type` varchar(45) NOT NULL,
  `file` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`nid`, `title`, `username`, `description`, `type`, `file`) VALUES
(3, 'vgv', 'kapil', 'fvt', 'images', 'src/content/1532522163013.jpg'),
(5, 'jar files completion', 'kapil', 'prepare jar file for to your project', 'images', 'src/content/1532602114276.jpg'),
(6, 'dsfd', 'kapil', 'dfsdf', 'images', 'src/content/1532602305427.jpg'),
(7, 'fdfg', 'kapil', 'fgfdg', 'images', 'src/content/1532602355146.jpg'),
(8, 'computer homework', 'kapil', 'complete the project  by tommorrow', 'images', 'src/content/1532682480728.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `rollnumber` int(11) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phonenumber` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `departmentname` varchar(45) DEFAULT NULL,
  `coursename` varchar(45) DEFAULT NULL,
  `photo` varchar(45) DEFAULT NULL,
  `semester` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`rollnumber`, `password`, `email`, `phonenumber`, `address`, `departmentname`, `coursename`, `photo`, `semester`) VALUES
(4545, '7974', 'roohi@gmail.com', '7986301319', 'delhi', 'MECHANICAL', 'auto mobiles', 'src/content/1532677912136.png', 3),
(6564, '4829', 'anukhatri@gmail.com', '541214512', 'lohgarh,asr', 'CSE', 'RDBMS', 'src/content/1532677169369.png', 3),
(7458, '3257', 'muskan@gmail.com', '6283200852', 'khazana gate ,asr', 'CIVIL', 'Builder', 'src/content/1532676853282.jpeg', 2),
(8547, '8996', 'ridhimasharma@gmail.com', '7888516561', 'Hathi Gate,asr', 'MBBS', 'D.Pharmacy', 'src/content/1532677590570.jpg', 2),
(12121, '8293', 'riya@gmail.com', '7901737512', 'Navankot,jalandher', 'MECHANICAL', 'auto machinery', 'src/content/1532677813853.png', 1),
(12456, '6421', 'madhurkhatri@gmail.com', '4125412541', 'khazana gate ,asr', 'MBBS', 'B. Pharmacy', 'src/content/1532676337689.jpg', 2),
(41254, '4594', 'lalitkumar@gmail.com', '6283200852', 'Hall gate,asr', 'CSE', 'coders', 'src/content/1532677334038.png', 3),
(45445, '1136', 'lalit@gamil.com', '7837555377', 'Lohgarh,asr', 'MBBS', 'Pharmacy', 'src/content/1532677679964.jpg', 1),
(74125, '6044', 'ravikant@gmail.com', '7854745812', 'lohrigate,asr', 'CIVIL', 'bridges', 'src/content/1532676720831.png', 4),
(74585, '6828', 'ishikabhatia@gmail.com', '8054350299', 'Lajpat nagar,delhi', 'MBBS', 'B. Pharmacy', 'src/content/1532677446441.jpg', 2),
(107223, '12', 'gaganmehra@gmail.com', '6283200852', 'modeltown', 'CSE', 'coders', 'src/content/1532343933099.jpg', 2);

-- --------------------------------------------------------

--
-- Table structure for table `viewnotes`
--

CREATE TABLE `viewnotes` (
  `title` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`Email`);

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`coursename`),
  ADD KEY `departmentname` (`departmentname`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`departmentname`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`Username`),
  ADD KEY `fkey1` (`departmentname`),
  ADD KEY `fkey2` (`coursename`);

--
-- Indexes for table `notedetails`
--
ALTER TABLE `notedetails`
  ADD PRIMARY KEY (`ndid`),
  ADD KEY `fk5` (`nid`),
  ADD KEY `fk6` (`rollno`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`nid`),
  ADD KEY `fk4` (`username`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`rollnumber`),
  ADD KEY `fk1` (`departmentname`),
  ADD KEY `fk2` (`coursename`);

--
-- Indexes for table `viewnotes`
--
ALTER TABLE `viewnotes`
  ADD PRIMARY KEY (`title`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notedetails`
--
ALTER TABLE `notedetails`
  MODIFY `ndid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `departmentname` FOREIGN KEY (`departmentname`) REFERENCES `department` (`departmentname`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `faculty`
--
ALTER TABLE `faculty`
  ADD CONSTRAINT `fkey1` FOREIGN KEY (`departmentname`) REFERENCES `department` (`departmentname`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fkey2` FOREIGN KEY (`coursename`) REFERENCES `courses` (`coursename`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notedetails`
--
ALTER TABLE `notedetails`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`nid`) REFERENCES `notes` (`nid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk6` FOREIGN KEY (`rollno`) REFERENCES `student` (`rollnumber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `fk4` FOREIGN KEY (`username`) REFERENCES `faculty` (`Username`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`departmentname`) REFERENCES `department` (`departmentname`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`coursename`) REFERENCES `courses` (`coursename`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
