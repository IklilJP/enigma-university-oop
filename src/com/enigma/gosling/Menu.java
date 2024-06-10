package com.enigma.gosling;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final InventoryServiceImpl service = new InventoryServiceImpl();

    public void displayMenu() {
        System.out.println("Menu Inventory Enigpus:");
        System.out.println("1. Tambah Buku");
        System.out.println("2. Cari Buku Berdasarkan Judul");
        System.out.println("3. Cari Buku Berdasarkan Kode");
        System.out.println("4. Hapus Buku Berdasarkan Kode");
        System.out.println("5. Tampilkan Semua Buku");
        System.out.println("0. Keluar");

        System.out.print("Masukkan pilihan Anda: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                addBook();

            case "2":
                searchBookByTitle();

            case "3":
                searchBookByCode();

            case "4":
                deleteBookByCode();

            case "5":
                displayAllBooks();

            case "0":
                System.out.println("Keluar dari program.");

                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih kembali.");
                displayMenu();
        }
    }


    private void addBook() {
        String bookType;
        int yearPublished;
        String stringYearPublished;
        String publicationPeriod;
        String title;
        String code;
        String publisher;
        String author;
        do {
            System.out.print("Masukkan jenis buku (novel/majalah): ");
            bookType = scanner.nextLine();
        } while (!bookType.equalsIgnoreCase("novel") && !bookType.equalsIgnoreCase("majalah"));

        if (bookType.equalsIgnoreCase("novel")) {
            do {
                System.out.print("Masukkan judul novel: ");
                title = scanner.nextLine();
                title = title.trim();
                if (title.isEmpty()) {
                    System.out.println("Judul tidak boleh kosong");
                }
            } while (title.isEmpty());

            do {
                System.out.print("Masukkan penerbit novel: ");
                publisher = scanner.nextLine();
                if (publisher.isEmpty()) {
                    System.out.println("Penerbit tidak boleh kosong");
                }
            } while (publisher.isEmpty());

            do {
                System.out.print("Masukkan tahun terbit novel (angka): ");
                stringYearPublished = scanner.nextLine();
                if (!stringYearPublished.matches("[0-9]+")) {
                    yearPublished = -1;
                    System.out.println("tahun harus berupa angka tidak boleh kosong dan negatif");
                    continue;
                }
                yearPublished = Integer.parseInt(stringYearPublished);
            } while (yearPublished < 0);

            do {
                System.out.print("Masukkan penulis novel: ");
                 author = scanner.nextLine();
                 if (author.isEmpty()) {
                    System.out.println("Penulis tidak boleh kosong");
                }
            }while (author.isEmpty());


            code = InventoryUtil.generateNovelCode(new Novel(stringYearPublished, title, publisher, yearPublished, author));
            Book novel = new Novel(code, title, publisher, yearPublished, author);
            service.addBook(novel);
            System.out.println("Novel berhasil ditambahkan.");

        } else if (bookType.equalsIgnoreCase("majalah")) {

            do {
                System.out.print("Masukkan judul majalah: ");
                title = scanner.nextLine();
                if (title.isEmpty()) {
                    System.out.println("Judul tidak boleh kosong");
                }
            }while (title.isEmpty());

            do {
                System.out.print("Masukkan periode terbit majalah (mingguan/bulanan): ");
                publicationPeriod = scanner.nextLine();
                if (!publicationPeriod.equalsIgnoreCase("mingguan") && !publicationPeriod.equalsIgnoreCase("bulanan")) {
                    System.out.println("Periode harus 'mingguan' atau 'bulanan'");
                }
            } while (!publicationPeriod.equalsIgnoreCase("mingguan") && !publicationPeriod.equalsIgnoreCase("bulanan"));


            do {
                System.out.print("Masukkan tahun terbit majalah (angka): ");
                stringYearPublished = scanner.nextLine();
                if (!stringYearPublished.matches("[0-9]+")) {
                    yearPublished = -1;
                    System.out.println("tahun harus berupa angka tidak boleh kosong dan negatif");
                    continue;
                }
                yearPublished = Integer.parseInt(stringYearPublished);
            } while (yearPublished < 0);

            code = InventoryUtil.generateMagazineCode(new Magazine(stringYearPublished, title, publicationPeriod, yearPublished));
            Book magazine = new Magazine(code, title, publicationPeriod, yearPublished);
            service.addBook(magazine);
            System.out.println("Majalah berhasil ditambahkan.");
        } else {
            System.out.println("Jenis buku tidak valid. Silakan pilih novel atau majalah.");
        }
        displayMenu();
    }

    private void searchBookByTitle() {
        System.out.print("Masukkan judul buku: ");
        String title = scanner.nextLine();
        service.searchBookByTitle(title);
        displayMenu();
    }

    private void searchBookByCode() {
        System.out.print("Masukkan kode buku: ");
        String code = scanner.nextLine();
        service.searchBookByCode(code);
        displayMenu();
    }

    private void deleteBookByCode() {
        System.out.print("Masukkan kode buku: ");
        String code = scanner.nextLine();
        service.deleteBookByCode(code);
        System.out.println("Buku dengan kode tersebut telah dihapus.");
        displayMenu();
    }

    private void displayAllBooks() {
        service.getAllBooks();
        displayMenu();
    }

}
