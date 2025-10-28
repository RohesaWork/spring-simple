package com.example.crud.data_siswa.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.crud.data_siswa.entity.Siswa;
import com.example.crud.data_siswa.repository.SiswaRepository;

@Service
public class SiswaServiceImpl implements SiswaService {
    private final SiswaRepository siswaRepository;

    public SiswaServiceImpl(SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Override
    public Siswa createSiswa(Siswa siswa) {
        return siswaRepository.save(siswa);
    }
    @Override
    public Siswa getSiswaById(Long id) {
        Optional<Siswa> siswa = siswaRepository.findById(id);
        return siswa.orElse(null);
    }
    
    @Override
    public List<Siswa> getAllSiswa() {
        return siswaRepository.findAll();
    }

    @Override
    public Siswa updateSiswa(Long id, Siswa siswaDetails) {
        Siswa siswa = getSiswaById(id);
        if (siswa!= null) {
            siswa.setNama(siswaDetails.getNama());
            siswa.setNis(siswaDetails.getNis());
            siswa.setJurusan(siswaDetails.getJurusan());
            return siswaRepository.save(siswa);
        }
        return null;
    }

    @Override
    public void deleteSiswa(Long id) {
        siswaRepository.deleteById(id);
    }
}
