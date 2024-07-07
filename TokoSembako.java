/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokosembako;

/**
 *
 * @author ADMIN
 */

import java.util.Arrays;

public class TokoSembako {
    // Atribut (Array)
    private Produk[] daftarProduk;
    private int jumlahProduk;

    // Constructor
    public TokoSembako() {
        daftarProduk = new Produk[10]; // Inisialisasi dengan kapasitas awal 10 produk
        jumlahProduk = 0;
    }

    // Method untuk menambah produk
    public void tambahProduk(Produk produk) {
        if (jumlahProduk < daftarProduk.length) {
            daftarProduk[jumlahProduk] = produk;
            jumlahProduk++;
        } else {
            // kalo array penuh, tambahkan kapasitas array
            daftarProduk = Arrays.copyOf(daftarProduk, daftarProduk.length * 2);
            daftarProduk[jumlahProduk] = produk;
            jumlahProduk++;
        }
    }

    // Method untuk menampilkan semua produk
    public void tampilkanProduk() {
        // Perulangan
        System.out.println("========================================");
        System.out.println("==Daftar Produk Toko Sembako Pak Kumis==");
        System.out.println("========================================");
        for (int i = 0; i < jumlahProduk; i++) {
            System.out.println(daftarProduk[i]);
        }
        System.out.println("=======================================");
    }

    // Method untuk mencari produk berdasarkan nama
    public Produk cariProduk(String nama) {
        // Perulangan
        for (int i = 0; i < jumlahProduk; i++) {
            // Seleksi
            if (daftarProduk[i].getNama().equalsIgnoreCase(nama)) {
                return daftarProduk[i];
            }
        }
        return null;
    }
}
