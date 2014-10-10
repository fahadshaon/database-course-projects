-- phpMyAdmin SQL Dump
-- version 4.2.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 10, 2014 at 01:27 AM
-- Server version: 5.6.15
-- PHP Version: 5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
`item_id` int(11) NOT NULL,
  `title` text,
  `item_type` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `task_id` int(11) DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=71 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`item_id`, `title`, `item_type`, `order`, `task_id`) VALUES
(1, 'Item 1 of task 1', 0, 1, 1),
(2, 'Item 2 of task 1', 1, 2, 1),
(3, 'Item 3 of task 1', 0, 3, 1),
(4, 'Item 4 of task 1', 1, 4, 1),
(5, 'Item 5 of task 1', 0, 5, 1),
(6, 'Item 6 of task 1', 1, 6, 1),
(7, 'Item 7 of task 1', 0, 7, 1),
(8, 'Item 1 of task 2', 0, 1, 2),
(9, 'Item 2 of task 2', 1, 2, 2),
(10, 'Item 3 of task 2', 0, 3, 2),
(11, 'Item 4 of task 2', 1, 4, 2),
(12, 'Item 5 of task 2', 0, 5, 2),
(13, 'Item 6 of task 2', 1, 6, 2),
(14, 'Item 7 of task 2', 0, 7, 2),
(15, 'Item 1 of task 3', 0, 1, 3),
(16, 'Item 2 of task 3', 1, 2, 3),
(17, 'Item 3 of task 3', 0, 3, 3),
(18, 'Item 4 of task 3', 1, 4, 3),
(19, 'Item 5 of task 3', 0, 5, 3),
(20, 'Item 6 of task 3', 1, 6, 3),
(21, 'Item 7 of task 3', 0, 7, 3),
(22, 'Item 1 of task 4', 0, 1, 4),
(23, 'Item 2 of task 4', 1, 2, 4),
(24, 'Item 3 of task 4', 0, 3, 4),
(25, 'Item 4 of task 4', 1, 4, 4),
(26, 'Item 5 of task 4', 0, 5, 4),
(27, 'Item 6 of task 4', 1, 6, 4),
(28, 'Item 7 of task 4', 0, 7, 4),
(29, 'Item 1 of task 5', 0, 1, 5),
(30, 'Item 2 of task 5', 1, 2, 5),
(31, 'Item 3 of task 5', 0, 3, 5),
(32, 'Item 4 of task 5', 1, 4, 5),
(33, 'Item 5 of task 5', 0, 5, 5),
(34, 'Item 6 of task 5', 1, 6, 5),
(35, 'Item 7 of task 5', 0, 7, 5),
(36, 'Item 1 of task 6', 0, 1, 6),
(37, 'Item 2 of task 6', 1, 2, 6),
(38, 'Item 3 of task 6', 0, 3, 6),
(39, 'Item 4 of task 6', 1, 4, 6),
(40, 'Item 5 of task 6', 0, 5, 6),
(41, 'Item 6 of task 6', 1, 6, 6),
(42, 'Item 7 of task 6', 0, 7, 6),
(43, 'Item 1 of task 7', 0, 1, 7),
(44, 'Item 2 of task 7', 1, 2, 7),
(45, 'Item 3 of task 7', 0, 3, 7),
(46, 'Item 4 of task 7', 1, 4, 7),
(47, 'Item 5 of task 7', 0, 5, 7),
(48, 'Item 6 of task 7', 1, 6, 7),
(49, 'Item 7 of task 7', 0, 7, 7),
(50, 'Item 1 of task 8', 0, 1, 8),
(51, 'Item 2 of task 8', 1, 2, 8),
(52, 'Item 3 of task 8', 0, 3, 8),
(53, 'Item 4 of task 8', 1, 4, 8),
(54, 'Item 5 of task 8', 0, 5, 8),
(55, 'Item 6 of task 8', 1, 6, 8),
(56, 'Item 7 of task 8', 0, 7, 8),
(57, 'Item 1 of task 9', 0, 1, 9),
(58, 'Item 2 of task 9', 1, 2, 9),
(59, 'Item 3 of task 9', 0, 3, 9),
(60, 'Item 4 of task 9', 1, 4, 9),
(61, 'Item 5 of task 9', 0, 5, 9),
(62, 'Item 6 of task 9', 1, 6, 9),
(63, 'Item 7 of task 9', 0, 7, 9),
(64, 'Item 1 of task 10', 0, 1, 10),
(65, 'Item 2 of task 10', 1, 2, 10),
(66, 'Item 3 of task 10', 0, 3, 10),
(67, 'Item 4 of task 10', 1, 4, 10),
(68, 'Item 5 of task 10', 0, 5, 10),
(69, 'Item 6 of task 10', 1, 6, 10),
(70, 'Item 7 of task 10', 0, 7, 10);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE IF NOT EXISTS `task` (
`task_id` int(11) NOT NULL,
  `title` text,
  `created_at` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`task_id`, `title`, `created_at`) VALUES
(1, 'Task title 1', '2014-10-10 06:20:12'),
(2, 'Task title 2', '2014-10-10 06:20:12'),
(3, 'Task title 3', '2014-10-10 06:20:12'),
(4, 'Task title 4', '2014-10-10 06:20:12'),
(5, 'Task title 5', '2014-10-10 06:20:12'),
(6, 'Task title 6', '2014-10-10 06:20:12'),
(7, 'Task title 7', '2014-10-10 06:20:12'),
(8, 'Task title 8', '2014-10-10 06:20:12'),
(9, 'Task title 9', '2014-10-10 06:20:12'),
(10, 'Task title 10', '2014-10-10 06:20:12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
 ADD PRIMARY KEY (`item_id`), ADD KEY `dj_item_task` (`task_id`);

--
-- Indexes for table `task`
--
ALTER TABLE `task`
 ADD PRIMARY KEY (`task_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item`
--
ALTER TABLE `item`
MODIFY `item_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=71;
--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
MODIFY `task_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `item`
--
ALTER TABLE `item`
ADD CONSTRAINT `dj_item_task` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
