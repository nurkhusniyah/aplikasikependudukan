-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2019 at 10:36 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aplikasikependudukan`
--

-- --------------------------------------------------------

--
-- Table structure for table `kelahiran`
--

CREATE TABLE `kelahiran` (
  `nama_bayi` varchar(100) NOT NULL,
  `hari` enum('senin','selasa','rabu','kamis','jumat','sabtu','minggu') NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `tempat_lahir` varchar(100) NOT NULL,
  `jk` enum('laki-laki','perempuan','','') NOT NULL,
  `agama` varchar(20) NOT NULL,
  `tempat_kelahiran` varchar(30) NOT NULL,
  `penolong_kelahiran` enum('bidan','dokter kandungan','','') NOT NULL,
  `nama_ibu` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tanggal_lahir_ibu` date NOT NULL,
  `umur_ibu` int(3) NOT NULL,
  `kewarganegaraan_ibu` enum('WNI','WNA','','') NOT NULL,
  `nama_ayah` varchar(50) NOT NULL,
  `tanggal_lahir_ayah` date NOT NULL,
  `umur_ayah` int(3) NOT NULL,
  `kewarganegaraan_ayah` enum('WNI','WNA','','') NOT NULL,
  `no_kk` int(20) NOT NULL,
  `no_ktp_ayah` int(20) NOT NULL,
  `petugas` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelahiran`
--

INSERT INTO `kelahiran` (`nama_bayi`, `hari`, `tanggal_lahir`, `tempat_lahir`, `jk`, `agama`, `tempat_kelahiran`, `penolong_kelahiran`, `nama_ibu`, `alamat`, `tanggal_lahir_ibu`, `umur_ibu`, `kewarganegaraan_ibu`, `nama_ayah`, `tanggal_lahir_ayah`, `umur_ayah`, `kewarganegaraan_ayah`, `no_kk`, `no_ktp_ayah`, `petugas`) VALUES
('lulu', 'minggu', '2019-11-10', 'fht', 'perempuan', 'Islam ', 'Rumah Bersalin', 'dokter kandungan', 'fhyju', 'bnmn', '2019-11-04', 21, 'WNI', 'efdg', '2019-11-11', 25, 'WNI', 567, 765, 'ggggg'),
('nopal', 'jumat', '2019-11-01', 'batang', 'laki-laki', 'Budha', 'Pukesmas', 'bidan', 'minah', 'batang', '2019-11-03', 30, 'WNI', 'kusnoto', '2019-11-09', 31, 'WNI', 67890, 976, 'dawet'),
('ysghjc', 'senin', '2019-11-01', 'sdf', 'perempuan', 'null', 'Pukesmas', 'bidan', 'df', 'null', '2019-11-02', 12, 'WNA', 'dcsdc', '2019-11-05', 23, 'WNI', 22341, 2456, 'gnn'),
('bahtiar', 'jumat', '2019-11-15', 'doro', 'laki-laki', 'Islam ', 'Rumah Sakit', 'dokter kandungan', 'fina', 'purbalingga', '2019-11-08', 24, 'WNI', 'aldy', '2019-11-16', 25, 'WNI', 123, 3210, 'alien'),
('nopal', 'jumat', '2019-11-01', 'batang', 'laki-laki', 'Budha', 'Pukesmas', 'bidan', 'minah', 'batang', '2019-11-03', 30, 'WNI', 'kusnoto', '2019-11-09', 31, 'WNI', 67890, 4567, 'dawet'),
('kadal', 'jumat', '2019-11-02', 'kajen', 'laki-laki', 'Islam ', 'Pukesmas', 'bidan', 'nur', 'kajen', '2019-11-03', 23, 'WNI', 'ahmad', '2019-11-06', 24, 'WNI', 2345, 5432, 'dddd'),
('ayu', 'jumat', '2019-11-03', 'pkl', 'perempuan', 'Katolik', 'Pukesmas', 'bidan', 'kusniyah', 'doro', '2019-11-10', 25, 'WNI', 'kadal', '2019-11-02', 30, 'WNI', 11111, 22222, 'ina'),
('kadal', 'sabtu', '2019-11-16', 'yayasan', 'laki-laki', 'Konghucu', 'Rumah Bersalin', 'dokter kandungan', 'tumirah', 'talun', '2019-11-12', 27, 'WNI', 'rihin', '2019-11-17', 29, 'WNI', 12345, 54321, 'ppppp'),
('ayu', 'selasa', '2019-11-11', 'rttg', 'laki-laki', 'null', 'Pukesmas', 'bidan', 'ffsddf', 'null', '2019-11-01', 23, 'WNI', 'rtrt', '2019-11-02', 24, 'WNI', 12234, 56678, 'hhhhh'),
('ina', 'senin', '2019-11-04', 'karanganyar', 'laki-laki', 'Islam ', 'Rumah Bersalin', 'bidan', 'birri', 'karanganyar', '2019-11-04', 25, 'WNI', 'yah', '2019-11-05', 29, 'WNI', 54321, 123456, 'ppp'),
('rijrgj', 'senin', '2019-11-07', 'eff', 'laki-laki', 'null', 'Rumah Sakit', 'bidan', 'ghghfg', 'null', '2019-11-09', 23, 'WNI', 'cvfv', '2019-11-08', 34, 'WNA', 4567777, 555555, 'fffffffff'),
('dhsdgfhd', 'senin', '2019-11-01', 'sdg', 'perempuan', 'null', 'Rumah Sakit', 'bidan', 'fbhkfdh', 'null', '2019-11-14', 23, 'WNA', 'mhn', '2019-11-14', 65, 'WNA', 24556, 777777, 'dggg');

-- --------------------------------------------------------

--
-- Table structure for table `kematian`
--

CREATE TABLE `kematian` (
  `no_ktp` int(20) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `jk` enum('Laki-laki','perempuan','','') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tgl_kelahiran` date NOT NULL,
  `tgl_kematian` date NOT NULL,
  `hari_kematian` enum('senin','selasa','rabu','kamis','jumat','sabtu','minggu') NOT NULL,
  `umur` int(4) NOT NULL,
  `tempat_kematian` varchar(100) NOT NULL,
  `sebab_kematian` varchar(100) NOT NULL,
  `pekerjaan` varchar(100) NOT NULL,
  `kewarganegaraan` enum('WNI','WNA','','') NOT NULL,
  `agama` enum('islam','kristen','katolik','hindu','budha','konghucu') NOT NULL,
  `status_perkawinan` enum('Kawin','Belum Kawin','Cerai','') NOT NULL,
  `No.KK` int(20) NOT NULL,
  `nama_pelapor` varchar(20) NOT NULL,
  `hub_pelapor` varchar(20) NOT NULL,
  `petugas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kematian`
--

INSERT INTO `kematian` (`no_ktp`, `nama_lengkap`, `jk`, `alamat`, `tgl_kelahiran`, `tgl_kematian`, `hari_kematian`, `umur`, `tempat_kematian`, `sebab_kematian`, `pekerjaan`, `kewarganegaraan`, `agama`, `status_perkawinan`, `No.KK`, `nama_pelapor`, `hub_pelapor`, `petugas`) VALUES
(54321, 'kuykuy', 'Laki-laki', 'doro', '2019-11-01', '2019-11-19', 'rabu', 21, 'rumahsakit', 'kecelakaan ', 'pelajar', 'WNI', 'islam', 'Belum Kawin', 12345, 'bbb', 'Lain-lain', 'ddddd'),
(76321, 'naknak', 'perempuan', 'talun', '2019-11-01', '2019-11-15', 'kamis', 15, 'Rumah sakit', 'sakit', 'pelajar', 'WNI', 'islam', 'Belum Kawin', 12367, 'weh', 'Orang Tua', 'eeee');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(10) NOT NULL,
  `nama_user` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `nama_user`, `pass`) VALUES
(123456, 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kelahiran`
--
ALTER TABLE `kelahiran`
  ADD PRIMARY KEY (`no_ktp_ayah`);

--
-- Indexes for table `kematian`
--
ALTER TABLE `kematian`
  ADD PRIMARY KEY (`no_ktp`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
