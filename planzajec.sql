-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Lis 14, 2023 at 09:22 AM
-- Wersja serwera: 10.4.28-MariaDB
-- Wersja PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `planzajec`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupy`
--

CREATE TABLE `grupy` (
  `id` int(11) NOT NULL,
  `grupa` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grupy`
--

INSERT INTO `grupy` (`id`, `grupa`) VALUES
(1, '11A1'),
(2, '11A2'),
(3, '11A3'),
(4, '11B1'),
(5, '11I1'),
(6, '11I2'),
(7, '11K1'),
(8, '11K2'),
(9, '11K3'),
(10, '11L1'),
(11, '11L2'),
(12, '11M1'),
(13, '11M2'),
(14, '11M3'),
(15, '11S1'),
(16, '11S2'),
(17, '11S3'),
(18, '11T1'),
(19, '11T2'),
(20, '11T3'),
(21, '11W1'),
(22, '12A1'),
(23, '12A2'),
(24, '12A3'),
(25, '12B1'),
(26, '12I1'),
(27, '12I2'),
(28, '12K1'),
(29, '12K2'),
(30, '12L1'),
(31, '12L2'),
(32, '12M1'),
(33, '12M2'),
(34, '12S1'),
(35, '12S2'),
(36, '12T1'),
(37, '12T2'),
(38, '12W1'),
(39, '13A1'),
(40, '13A4'),
(41, '13A6'),
(42, '13B1'),
(43, '13I4'),
(44, '13I6'),
(45, '13K1'),
(46, '13K2'),
(47, '13L3'),
(48, '13L4'),
(49, '13M4'),
(50, '13M5'),
(51, '13S1'),
(52, '13S2'),
(53, '13T4'),
(54, '13T8'),
(55, '13W1'),
(56, '14A1'),
(57, '14A4'),
(58, '14A6'),
(59, '14B1'),
(60, '14I4'),
(61, '14I6'),
(62, '14I7'),
(63, '14K1'),
(64, '14K2'),
(65, '14L3'),
(66, '14L4'),
(67, '14M2'),
(68, '14M4'),
(69, '14M5'),
(70, '14S1'),
(71, '14S2'),
(72, '14T4'),
(73, '14T8'),
(74, '14W1'),
(75, '41A4'),
(76, '41A4'),
(77, '41A6'),
(78, '41I1'),
(79, '41I2'),
(80, '41K8'),
(81, '41L3'),
(82, '41L4'),
(83, '41M4'),
(84, '41M5'),
(85, '41S1'),
(86, '41S2'),
(87, '41T4');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `grupygrup`
--

CREATE TABLE `grupygrup` (
  `id` int(11) NOT NULL,
  `idGrupy` int(11) NOT NULL,
  `grupaGrupy` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `grupy`
--
ALTER TABLE `grupy`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `grupygrup`
--
ALTER TABLE `grupygrup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grupy`
--
ALTER TABLE `grupy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=269;

--
-- AUTO_INCREMENT for table `grupygrup`
--
ALTER TABLE `grupygrup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
