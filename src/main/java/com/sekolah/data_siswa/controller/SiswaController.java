package com.sekolah.data_siswa.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sekolah.data_siswa.entity.Siswa;
import com.sekolah.data_siswa.service.SiswaService;

@RestController
@RequestMapping("/api/siswa")
public class SiswaController {
    private final SiswaService siswaService;
    
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping
    public Siswa createSiswa(@RequestBody Siswa siswa) {
        return siswaService.createSiswa(siswa);
    }

    @GetMapping
    public List<Siswa> getAllSiswa() {
        return siswaService.getAllSiswa();
    }

    @GetMapping("/{id}")
    public Siswa getSiswaById(@PathVariable Long id) {
        return siswaService.getSiswaById(id);
    }

    @PutMapping("/{id}")
    public Siswa updateSiswa(@PathVariable Long id, @RequestBody Siswa siswaDetails) {
        return siswaService.updateSiswa(id, siswaDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteSiswa(@PathVariable Long id) {
        siswaService.deleteSiswa(id);
        return "Siswa dengan ID " + id + " berhasil dihapus.";
    }
}
