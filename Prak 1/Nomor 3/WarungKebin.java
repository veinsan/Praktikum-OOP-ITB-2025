import java.lang.System;
import java.util.Scanner;

public class WarungKebin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // TODO: Baca jumlah pembeli (N)
        // HINT: Perhatikan input setelah N ini
        int N;
        N = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while (i < N) {
            // TODO: Baca data pembeli (nama, nomorMeja, saldo)
            // HINT: Perhatikan input setelah data pembeli ini
            String nama; int nomormeja; double isiSaldo;

            nama = sc.nextLine();
            nomormeja = sc.nextInt();
            isiSaldo = sc.nextDouble();
            
            // TODO: Baca data order makanan (namaMakanan, jumlah, hargaSatuan)
            // HINT: Perhatikan input setelah data order makanan ini
            String makanan; int jumlahbeli; double hargasatuan;

            sc.nextLine();
            makanan = sc.nextLine();
            jumlahbeli = sc.nextInt();
            hargasatuan = sc.nextDouble();
            sc.nextLine();
            // TODO: Buat objek Pembeli dan OrderMakanan
            Pembeli pembeliKeN = new Pembeli(nama, nomormeja, isiSaldo);
            OrderMakanan orderKeN = new OrderMakanan(makanan, jumlahbeli, hargasatuan);

            // TODO: Cek apakah pembeli bisa membayar sendiri pesanannya
            
            // TODO: Jika bisa bayar, kurangi saldo pembeli
            if(pembeliKeN.cekBisaBayar(orderKeN)){
                isiSaldo = isiSaldo - orderKeN.getTotalHarga();
            }
            
            // TODO: Cetak laporan pembeli i
            // HINT: Jika pembeli tidak bisa membayar, tidak perlu tampilkan saldo setelah bayar
            // HINT: Perhatikan lagi format output yang diharapkan
            System.out.println("=== Pembeli " + (i+1) + " ===");
            System.out.println("Nama: " + pembeliKeN.getNamaPembeli() + " (Meja " + pembeliKeN.getNomorMeja() + ")");
            System.out.println("Pesanan: " + orderKeN.getNamaMakanan() + " x " + orderKeN.getcountMakanan() + " @ " + orderKeN.getHargaSatuan());
            System.out.println("Total: " + orderKeN.getTotalHarga());
            if(pembeliKeN.cekBisaBayar(orderKeN)){
                System.out.println("Bisa Bayar: Bisa");
            }
            else {
                System.out.println("Bisa Bayar: Gak Bisa");
            }
            if(pembeliKeN.cekBisaBayar(orderKeN)){
                System.out.println("Saldo setelah bayar: " + isiSaldo);
            }
            System.out.println();
            i++;
        }

        sc.close();
    }
}