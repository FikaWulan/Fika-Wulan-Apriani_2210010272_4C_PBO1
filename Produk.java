/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tokosembako;

/**
 *
 * @author ADMIN
 */

// Class
public class Produk {
    // Atribut
    private String nama;
    private double harga;
    private int stok;

    // Constructor
    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Accessor
    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Mutator
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) {
            stok -= jumlah;
        } else {
            System.out.println("\n=======================================");
            System.out.println("Stok tidak mencukupi");
            System.out.println("\n=======================================");
        }
    }

    @Override
    public String toString() {
        String formattedHarga = String.format("Rp%,.0f", harga);
        return nama + " -> Harga: " + formattedHarga + " -> Stok: " + stok;
    }
}
