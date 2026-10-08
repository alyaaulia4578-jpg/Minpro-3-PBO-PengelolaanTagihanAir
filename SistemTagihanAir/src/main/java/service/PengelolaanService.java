/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.util.ArrayList;
import model.Warga;
import model.TagihanAir;
import model.Pembayaran;
import model.Petugas;

/**
 *
 * @author MSI MODERN
 */


public class PengelolaanService {
    private ArrayList<Warga> daftarWarga;
    private ArrayList<TagihanAir> daftarTagihan;
    private ArrayList<Pembayaran> daftarPembayaran;
    private ArrayList<Petugas> daftarPetugas;

    public PengelolaanService() {
        daftarWarga = new ArrayList<>();
        daftarTagihan = new ArrayList<>();
        daftarPembayaran = new ArrayList<>();
        daftarPetugas = new ArrayList<>();

        Warga warga1 = new Warga(
                "W1",
                "Ahmad Fauzi",
                "Perumahan Blok A",
                "12");
        daftarWarga.add(warga1);

        TagihanAir tagihan1 = new TagihanAir("T1", warga1, 15);
        daftarTagihan.add(tagihan1);

        Petugas petugas1 = new Petugas("P1", "Budi Santoso", "Admin Perumahan");
        daftarPetugas.add(petugas1);
    }

    public boolean tambahWarga(Warga warga) {
        if (warga == null || cariWarga(warga.getIdUser()) != null) {
            return false;
        }
        daftarWarga.add(warga);
        return true;
    }

    public ArrayList<Warga> getDaftarWarga() {
        return daftarWarga;
    }

    public Warga cariWarga(String id) {
        for (Warga warga : daftarWarga) {
            if (warga.getIdUser().equalsIgnoreCase(id)) {
                return warga;
            }
        }
        return null;
    }

    public boolean tambahTagihan(TagihanAir tagihan) {
        if (tagihan == null || cariTagihan(tagihan.getIdTagihan()) != null) {
            return false;
        }
        daftarTagihan.add(tagihan);
        return true;
    }

    public ArrayList<TagihanAir> getDaftarTagihan() {
        return daftarTagihan;
    }

    public TagihanAir cariTagihan(String id) {
        for (TagihanAir tagihan : daftarTagihan) {
            if (tagihan.getIdTagihan().equalsIgnoreCase(id)) {
                return tagihan;
            }
        }
        return null;
    }

    public boolean tambahPembayaran(Pembayaran pembayaran) {
        if (pembayaran == null || cariPembayaran(pembayaran.getIdPembayaran()) != null) {
            return false;
        }
        TagihanAir tagihan = pembayaran.getTagihan();
        if (tagihan.getTotalTagihan() == 0) {
            return false;
        }
        if ("Lunas".equalsIgnoreCase(tagihan.getStatus())) {
            return false;
        }
        if (pembayaran.getJumlahBayar() != tagihan.getTotalTagihan()) {
            return false;
        }
        daftarPembayaran.add(pembayaran);
        tagihan.setStatus("Lunas");
        return true;
    }

    public ArrayList<Pembayaran> getDaftarPembayaran() {
        return daftarPembayaran;
    }

    public Pembayaran cariPembayaran(String id) {
        for (Pembayaran pembayaran : daftarPembayaran) {
            if (pembayaran.getIdPembayaran().equalsIgnoreCase(id)) {
                return pembayaran;
            }
        }
        return null;
    }

    public ArrayList<Petugas> getDaftarPetugas() {
        return daftarPetugas;
    }

    public boolean sudahAdaPembayaran(TagihanAir tagihan) {
        for (Pembayaran pembayaran : daftarPembayaran) {
            if (pembayaran.getTagihan() == tagihan) {
                return true;
            }
        }
        return false;
    }

    public boolean punyaTagihan(Warga warga) {
        for (TagihanAir tagihan : daftarTagihan) {
            if (tagihan.getWarga() == warga) {
                return true;
            }
        }
        return false;
    }

    public boolean hapusWarga(String id) {
        Warga warga = cariWarga(id);

        if (warga == null || punyaTagihan(warga)) {
            return false;
        }
        return daftarWarga.remove(warga);
    }

    public boolean hapusTagihan(String id) {
        TagihanAir tagihan = cariTagihan(id);
        if (tagihan == null || sudahAdaPembayaran(tagihan)) {
            return false;
        }
        return daftarTagihan.remove(tagihan);
    }
}