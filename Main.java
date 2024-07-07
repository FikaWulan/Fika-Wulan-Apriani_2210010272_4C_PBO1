/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokosembako;

/**
 *
 * @author ADMIN
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Object
        TokoSembako toko = new TokoSembako();
        // Menambahkan produk ke dalam toko
        try (Scanner scanner = new Scanner(System.in)) {
            // Membuat Produk
            toko.tambahProduk(new Produk("Beras", 10000, 120));
            toko.tambahProduk(new Produk("Gula", 12000, 61));
            toko.tambahProduk(new Produk("Minyak", 15000, 34));
            
            boolean berjalan = true;
            while (berjalan) {
                try {
                    System.out.println("\n=======================================");
                    System.out.println("=======Toko Sembako Pak Kumis==========");
                    System.out.println("=======================================");
                    System.out.println("1. Tampilkan Produk");
                    System.out.println("2. Cari Produk");
                    System.out.println("3. Transaksi");
                    System.out.println("4. Tambah Stok Produk");
                    System.out.println("5. Keluar");
                    System.out.println("=======================================");
                    System.out.print("\nPilih menu: ");
                    // ini IO sederhana ya :>
                    int pilihan = scanner.nextInt();
                    scanner.nextLine(); // membersihkan buffer
                    
                    // Seleksi
                    switch (pilihan) {
                        case 1:
                            toko.tampilkanProduk();
                            break;
                        case 2:
                            System.out.println("=======================================");
                            System.out.print("Masukkan nama produk: ");
                            String namaProduk = scanner.nextLine();
                            Produk produk = toko.cariProduk(namaProduk);
                            if (produk != null) {
                                System.out.println("\n=======================================");
                                System.out.println(produk);
                                System.out.println("=======================================");
                                System.out.print("Apakah Anda ingin melakukan transaksi? (ya/tidak): ");
                                String jawaban = scanner.nextLine();
                                if (jawaban.equalsIgnoreCase("ya")) {
                                    lakukanTransaksi(scanner, produk);
                                }
                            } else {
                                System.out.println("\n=======================================");
                                System.out.println("Produk tidak ditemukan");
                                System.out.println("=======================================");
                            }
                            break;
                        case 3:
                            System.out.println("\n=======================================");
                            System.out.print("Masukkan nama produk: ");
                            String namaProd = scanner.nextLine();
                            Produk prod = toko.cariProduk(namaProd);
                            if (prod != null) {
                                lakukanTransaksi(scanner, prod);
                            } else {
                                System.out.println("\n=======================================");
                                System.out.println("Produk tidak ditemukan");
                                System.out.println("=======================================");
                            }
                            break;
                        case 4:
                            System.out.println("\n=======================================");
                            System.out.print("Masukkan nama produk: ");
                            String namaProdukTambah = scanner.nextLine();
                            Produk produkTambah = toko.cariProduk(namaProdukTambah);
                            if (produkTambah != null) {
                                System.out.println("\n=======================================");
                                System.out.print("Masukkan jumlah stok yang ingin ditambahkan: ");
                                int jumlahTambah = scanner.nextInt();
                                scanner.nextLine(); // membersihkan buffer
                                produkTambah.tambahStok(jumlahTambah);
                                System.out.println("\n=======================================");
                                System.out.println("Stok berhasil ditambahkan. Stok sekarang: " + produkTambah.getStok());
                                System.out.println("=======================================");
                            } else {
                                System.out.println("\n=======================================");
                                System.out.println("Produk tidak ditemukan");
                                System.out.println("=======================================");
                            }
                            break;
                        case 5:
                            berjalan = false;
                            break;
                        default:
                            System.out.println("\n=======================================");
                            System.out.println("Pilihan tidak valid");
                            System.out.println("=======================================");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\n=======================================");
                    System.out.println("Input tidak valid, silakan masukkan angka.");
                    System.out.println("=======================================");
                    scanner.nextLine(); // bersihkan kalo baper
                }
            }
        }
    }

private static void lakukanTransaksi(Scanner scanner, Produk produk) {
    try {
        System.out.println("\n=======================================");
        System.out.print("Masukkan jumlah: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // membersihkan buffer

        // Tampilkan jumlah harga sebelum proses transaksi
        double totalHarga = produk.getHarga() * jumlah;
        System.out.println("\n=======================================");
        System.out.println("Jumlah Harga: " + formatHarga(totalHarga));

        System.out.println("\n=======================================");
        System.out.print("Masukkan jumlah uang yang diberi pelanggan: ");
        double uangDiberikan = scanner.nextDouble();
        scanner.nextLine(); // membersihkan buffer

        // Object
        Transaksi transaksi = new Transaksi(produk, jumlah);
        transaksi.prosesTransaksi(uangDiberikan);
    } catch (InputMismatchException e) {
        System.out.println("\n=======================================");
        System.out.println("Input tidak valid, transaksi dibatalkan.");
        scanner.nextLine(); // membersihkan buffer
    }
}

private static String formatHarga(double harga) {
    return "Rp" + String.format("%,.0f", harga);
}
}
