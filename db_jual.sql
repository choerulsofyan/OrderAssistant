-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 30 Jan 2018 pada 04.27
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 7.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_jual`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `kode_barang` varchar(5) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok_barang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`kode_barang`, `nama_barang`, `harga`, `stok_barang`) VALUES
('B001', 'VGA Nvdia GT740', 2500000, 100),
('B002', 'VGA ATi Radeon', 1800000, 50),
('B003', 'Processor Core i3 ', 3000000, 8),
('B004', 'Mouse Logitech', 75000, 18),
('B0044', 'Switch TP-LINK', 59500000, 7),
('B005', 'Keyboard Genius', 128000, 3),
('B006', 'Casing PC Dazumba', 120000, 85),
('B0077', 'Mouse Genius', 75000, 18),
('B009', 'Mouse Pad ', 27000, 54),
('B010', 'Router D-Link', 376000, 80),
('B011', 'Mouse Votre', 35000, 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detailjual`
--

CREATE TABLE `detailjual` (
  `no_faktur` varchar(20) NOT NULL,
  `kode_barang` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detailjual`
--

INSERT INTO `detailjual` (`no_faktur`, `kode_barang`, `jumlah`) VALUES
('FJ001', 'M002', 3),
('FJ002', 'M001', 2),
('FJ002', 'K001', 2),
('FJ003', 'M001', 4),
('PO-20171020-6', 'B001', 1),
('PO-20171020-6', 'B003', 2),
('PO-20171020-6', 'B002', 7),
('PO-20171020-7', 'B003', 3),
('PO-20171020-7', 'B002', 2),
('PO-20171020-7', 'B002', 3),
('PO-20171020-7', 'B003', 3),
('PO-20171020-7', 'B002', 1),
('PO-20171020-7', 'B002', 3),
('PO-20171020-8', 'B003', 4),
('PO-20171020-8', 'B001', 2),
('PO-20171020-9', 'B003', 3),
('PO-20171020-9', 'B002', 3),
('PO-20171020-10', 'B002', 3),
('PO-20171020-10', 'B003', 3),
('PO-20171020-11', 'B003', 4),
('PO-20171020-11', 'B005', 2),
('PO-20171021-12', 'B003', 4),
('PO-20171021-12', 'B003', 2),
('PO-20171117-14', 'B005', 4),
('PO-20171117-14', 'B003', 2),
('PO-20171117-15', 'B004', 4),
('PO-20171117-15', 'B003', 3),
('PO-20171117-15', 'B003', 3),
('PO-20171117-15', 'B005', 2),
('PO-20171117-16', 'B004', 3),
('PO-20171117-16', 'B008', 3),
('PO-20171118-18', 'B006', 2),
('PO-20171118-18', 'B003', 4),
('PO-2018022-20', 'B005', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `login`
--

CREATE TABLE `login` (
  `user` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jk` varchar(15) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `notlp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama`, `jk`, `alamat`, `notlp`) VALUES
('P002', 'Sofyan', 'Pria', 'Jl. Pasir Koja', '022768987654'),
('P003', 'Maimumah', 'Wanita', 'Jl. Gamelan', '02275678890'),
('P004', 'Maisaroh', 'Wanita', 'Jl. Kebon Jati', '0898446789'),
('P005', 'Eman', 'Pria', 'Jl. Dipatiukur', '0411'),
('P006', 'Ajat', 'Pria', 'Jl. Dipatiukur', '021');

-- --------------------------------------------------------

--
-- Struktur dari tabel `penjualan`
--

CREATE TABLE `penjualan` (
  `no_faktur` varchar(20) NOT NULL,
  `tgl_penjualan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `penjualan`
--

INSERT INTO `penjualan` (`no_faktur`, `tgl_penjualan`) VALUES
('FJ001', '2010-03-19'),
('FJ002', '2010-03-21'),
('FJ003', '2010-03-21'),
('PO-20171019-4', '2017-11-19'),
('PO-20171019-5', '2017-11-19'),
('PO-20171020-6', '2017-11-20'),
('PO-20171020-7', '2017-11-20'),
('PO-20171020-8', '2017-11-20'),
('PO-20171020-9', '2017-11-20'),
('PO-20171020-10', '2017-11-20'),
('PO-20171020-11', '2017-11-20'),
('PO-20171021-12', '2017-11-21'),
('PO-20171116-13', '2017-12-16'),
('PO-20171117-14', '2017-12-17'),
('PO-20171117-15', '2017-12-17'),
('PO-20171117-16', '2017-12-17'),
('PO-20171118-17', '2017-12-18'),
('PO-20171118-18', '2017-12-18'),
('PO-2018022-19', '2018-01-22');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `userid` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`userid`, `password`) VALUES
('choerul', 'kerul'),
('sofyan', 'kerul');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
