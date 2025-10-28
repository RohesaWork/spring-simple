package com.example.crud.data_siswa.service;

import java.util.List;

import com.example.crud.data_siswa.entity.Siswa;

public interface SiswaService {
    Siswa createSiswa(Siswa siswa);
    Siswa getSiswaById(Long id);
    List<Siswa> getAllSiswa();
    Siswa updateSiswa(Long id, Siswa siswa);
    void deleteSiswa(Long id);
}
