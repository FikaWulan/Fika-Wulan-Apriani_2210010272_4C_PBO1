/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tokosembako;

/**
 *
 * @author ADMIN
 */

// Class
public final class Transaksi {
    // Atribut
    private final Produk produk;
    private final int jumlah;
    private final double diskon;
    private final double total;
    private double uangDiberikan;
    private double kembalian;

    // Constructor
    public Transaksi(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
        this.diskon = hitungDiskon();
        this.total = hitungTotal();
    }

    // Method untuk menghitung total harga
    public double hitungTotal() {
        return produk.getHarga() * jumlah * (1 - diskon);
    }

    // Method untuk menghitung diskon
    private double hitungDiskon() {
        if (jumlah > 5) {
            return 0.1; // diskon 10%
        }
        return 0;
    }

    public void prosesTransaksi(double uangDiberikan) {
        this.uangDiberikan = uangDiberikan;
        // Seleksi
        if (produk.getStok() >= jumlah) {
            if (uangDiberikan >= total) {
                produk.kurangiStok(jumlah);
                this.kembalian = uangDiberikan - total;
                cetakStruk();
            } else {
                System.out.println("\n=======================================");
                System.out.println("Transaksi gagal: Uang yang diberikan tidak mencukupi");
                System.out.println("=======================================");
            }
        } else {
            System.out.println("\n=======================================");
            System.out.println("Transaksi gagal: Stok tidak mencukupi");
            System.out.println("=======================================");
        }
    }

    // Method untuk mencetak struk pembelian
    private void cetakStruk() {
        System.out.println("\n========================================");
        System.out.println("=============Struk Pembelian============");
        System.out.println("========================================");
        System.out.println("Produk: " + produk.getNama());
        System.out.println("Harga Satuan: " + formatHarga(produk.getHarga()));
        System.out.println("Jumlah: " + jumlah);
        System.out.println("Diskon: " + (diskon * 100) + "%");
        System.out.println("Total Bayar: " + formatHarga(total));
        System.out.println("Uang Diberikan: " + formatHarga(uangDiberikan));
        System.out.println("Kembalian: " + formatHarga(kembalian));
        System.out.println("========================================");
    }

    private String formatHarga(double harga) {
        return "Rp" + String.format("%,.0f", harga);
    }
}
