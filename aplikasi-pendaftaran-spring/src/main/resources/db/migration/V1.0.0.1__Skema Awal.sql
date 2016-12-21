CREATE TABLE `sekolah` (
  `id` varchar(255) NOT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `kode` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`kode`)
) ;

CREATE TABLE `siswa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `id_sekolah_asal` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`email`),
  FOREIGN KEY (`id_sekolah_asal`) REFERENCES `sekolah` (`id`)
);

CREATE TABLE `soal` (
  `id` varchar(255) NOT NULL,
  `kode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`kode`)
) ;

CREATE TABLE `pertanyaan` (
  `id` varchar(255) NOT NULL,
  `isi` varchar(255) DEFAULT NULL,
  `jawaban` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `paket_soal_pertanyaan` (
  `id_soal` varchar(255) NOT NULL,
  `id_pertanyaan` varchar(255) NOT NULL,
  FOREIGN KEY (`id_pertanyaan`) REFERENCES `pertanyaan` (`id`),
  FOREIGN KEY (`id_soal`) REFERENCES `soal` (`id`)
);

CREATE TABLE `pilihan` (
  `id` varchar(255) NOT NULL,
  `isi` varchar(255) DEFAULT NULL,
  `id_pertanyaan` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_pertanyaan`) REFERENCES `pertanyaan` (`id`)
) ;

CREATE TABLE `hasil_ujian` (
  `id` varchar(255) NOT NULL,
  `lulus` bit(1) DEFAULT NULL,
  `nilai` decimal(19,2) DEFAULT NULL,
  `tanggal_ujian` date NOT NULL,
  `id_siswa` bigint(20) NOT NULL,
  `id_soal` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_siswa`) REFERENCES `siswa` (`id`),
  FOREIGN KEY (`id_soal`) REFERENCES `soal` (`id`)
);