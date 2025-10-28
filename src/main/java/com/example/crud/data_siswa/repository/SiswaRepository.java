package com.example.crud.data_siswa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.data_siswa.entity.Siswa;

@Repository
public interface SiswaRepository extends JpaRepository<Siswa, Long> {}
