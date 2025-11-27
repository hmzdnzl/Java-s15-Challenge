import java.lang.reflect.Member;

import org.example.library.Book;
import org.example.library.Library;
import org.example.library.Shelf;
import org.example.library.person.Author;
import org.example.library.person.LibraryStuff;

public class Main {
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Library library = Library.getInstance();
        library.addBook(new org.example.library.Book("Dample" , org.example.library.Type.HISTORY, new org.example.library.person.Author("Sauthor", "Author"), 55, new org.example.library.Shelf(1), java.time.LocalDate.now(), true));        
        
        library.addBook(new org.example.library.Book("Neodampleology" , org.example.library.Type.HISTORY, new org.example.library.person.Author("travolta", "Author"), 300, new org.example.library.Shelf(1), java.time.LocalDate.now(), false));
        
        
        library.addBook(new org.example.library.Book("Sample Book", org.example.library.Type.HISTORY, new org.example.library.person.Author("Sample Author", "Author"), 1, new org.example.library.Shelf(1), java.time.LocalDate.now(), true));
        
            for (int i = 1; i < 50; i++) {
         library.addBook(new org.example.library.Book("Sample Book" + i, org.example.library.Type.HISTORY, new org.example.library.person.Author("Sample Author", "Author"), i+1, new org.example.library.Shelf(1), java.time.LocalDate.now(), true));        
            }

             for (int a = 1; a < 100; a++) {
         library.addBook(new org.example.library.Book("Bample Book" + a, org.example.library.Type.HISTORY, new org.example.library.person.Author("Bample Author", "Author"), 55+a, new org.example.library.Shelf(2), java.time.LocalDate.now(), true));        
            }

            for (int d = 1; d < 75; d++) {
            library.addBook(new org.example.library.Book("Cample Book" + d, org.example.library.Type.HISTORY, new org.example.library.person.Author("Cample Author", "Author"), 165+d, new org.example.library.Shelf(3), java.time.LocalDate.now(), true));        
            }

            for (int b = 1; b < 10; b++) { 
                library.addLibraryStuff(new LibraryStuff(b, "Personel" + b, "Adres" + b, "0555-000-000" + b, "personel" + b + "@kutuphane.com", "Personel"));
            }

             library.addLibraryStuff(new LibraryStuff(10, "Personel", "Adres", "0555-000-000", "personel" + "@kutuphane.com", "Personel"));

            for (int c = 2; c < 100; c++) { 
                library.addMember(new org.example.library.person.Member(c, "Üye" + c, "Adres" + c, "0555-000-000" + c, "uye" + c + "@mail.com", "Üye", new java.util.ArrayList<>(), 0.0));
            }

            library.addMember(new org.example.library.person.Member(1, "Denek", "Adres1", "0555-000-0001", "uye1@mail.com", "Üye", new java.util.ArrayList<>(), 0.0));

             library.addMember(new org.example.library.person.Member(101, "Hasdenekli", "Adres1", "0555-000-0001", "uye1@mail.com", "Üye", new java.util.ArrayList<>(), 10.0));



        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");

        System.out.println("+++++++++++++ KÜTÜPHANE OTOMASYONU +++++++++++++");
        while (true) {
            try {
                System.out.println("\nLütfen rolünüzü seçin:");
                System.out.println("1 - Üye");
                System.out.println("2 - Personel");
                System.out.println("3 - Çıkış");
                System.out.print("Seçiminiz: ");
                String secim = scanner.nextLine();
                if (secim.equals("1")) {
                    System.out.println("Üye menüsüne yönlendiriliyorsunuz...");
                    while (true) {
                        try {
                            System.out.println("\n--- ÜYE MENÜSÜ ---");
                            System.out.println("1 - Kitap Arama");
                            System.out.println("2 - Ödünç Alınan Kitaplar");
                            System.out.println("3 - Kitap Ödünç Alma");
                            System.out.println("4 - Kitap İade");
                            System.out.println("5 - Kitap Bağışı");
                            System.out.println("6 - Cezaları Görüntüle");
                            System.out.println("0 - Ana Menüye Dön");
                            System.out.print("Seçiminiz: ");
                            String usecim = scanner.nextLine();
                            if (usecim.equals("0")) break;
                            if (usecim.equals("1")) {
                                System.out.print("Aranacak kitap başlığı: ");
                                String title = scanner.nextLine();
                                java.util.List<Book> foundBooks = library.searchBooks(title);
                                for (Book book : foundBooks) {
                                    System.out.println(
                                        "Başlık: " + book.getTitle() +
                                        ", Yazar: " + book.getAuthor().getName() +
                                        ", Tür: " + book.getType() +
                                        ", Kitap ID: " + book.getBookId() +
                                        ", Raf: " + book.getShelf().getShelfId() +
                                        ", Ödünç Alınabilir: " + (book.isEnableBorrow() ? "Evet" : "Hayır")
                                    );
                                }
                                continue;
                            } else if (usecim.equals("2")) {
                                System.out.println("Lütfen üye ID'nizi giriniz:");
                                String memberIdInput = scanner.nextLine();
                                long memberId = Long.parseLong(memberIdInput);
                                org.example.library.person.Member member = library.findMemberById(memberId);
                                System.out.println("Ödünç Alınan Kitaplar:");
                                for (Book book : member.getBorrowedBooks()) {
                                    System.out.println(
                                        "Başlık: " + book.getTitle() +
                                        ", Yazar: " + book.getAuthor().getName() +
                                        ", Tür: " + book.getType() +
                                        ", Kitap ID: " + book.getBookId()
                                    );
                                }
                            } else if (usecim.equals("3")) {
                                System.out.println("Lütfen üye ID'nizi giriniz:");
                                String memberIdInput = scanner.nextLine();
                                long memberId = Long.parseLong(memberIdInput);
                                org.example.library.person.Member member = library.findMemberById(memberId);
                                System.out.print("Ödünç almak istediğiniz kitap ID'sini giriniz: ");
                                int bookId = Integer.parseInt(scanner.nextLine());
                                Book bookToBorrow = library.findBookById(bookId);
                                library.lendBook(bookToBorrow.getBookId(), member.getMemberId());
                                System.out.println("Kitap başarıyla ödünç alındı!");
                            } else if (usecim.equals("4")) {
                                System.out.println("Lütfen üye ID'nizi giriniz:");
                                String memberIdInput = scanner.nextLine();
                                long memberId = Long.parseLong(memberIdInput);
                                org.example.library.person.Member member = library.findMemberById(memberId);
                                System.out.print("İade etmek istediğiniz kitap ID'sini giriniz: ");
                                int bookId = Integer.parseInt(scanner.nextLine());
                                Book bookToReturn = library.findBookById(bookId);
                                library.returnBook(bookToReturn.getBookId(), member.getMemberId());
                                System.out.println("Kitap başarıyla iade edildi!");
                            } else if (usecim.equals("5")) {
                                System.out.println("Lütfen bağışlamak istediğiniz kitabın bilgilerini giriniz.");
                                System.out.print("Kitap başlığı: ");
                                String title = scanner.nextLine();
                                if (title.trim().isEmpty()) {
                                    System.out.println("Kitap başlığı boş olamaz!");
                                    continue;
                                }
                                org.example.library.Type[] types = org.example.library.Type.values();
                                System.out.println("Kitap türünü seçin:");
                                for (int i = 0; i < types.length; i++) {
                                    System.out.println((i + 1) + ". " + types[i]);
                                }
                                System.out.print("Tür numarası: ");
                                String typeInput = scanner.nextLine();
                                if (typeInput.trim().isEmpty()) {
                                    System.out.println("Tür numarası boş olamaz!");
                                    continue;
                                }
                                int typeIndex = Integer.parseInt(typeInput) - 1;
                                if (typeIndex < 0 || typeIndex >= types.length) {
                                    System.out.println("Geçersiz tür seçimi!");
                                    continue;
                                }
                                org.example.library.Type type = types[typeIndex];
                                System.out.print("Yazar adı: ");
                                String authorName = scanner.nextLine();
                                if (authorName.trim().isEmpty()) {
                                    System.out.println("Yazar adı boş olamaz!");
                                    continue;
                                }
                                org.example.library.person.Author author = new org.example.library.person.Author(authorName, "Author");
                                System.out.print("Kitap ID: ");
                                String bookIdInput = scanner.nextLine();
                                if (bookIdInput.trim().isEmpty()) {
                                    System.out.println("Kitap ID boş olamaz!");
                                    continue;
                                }
                                int bookId = Integer.parseInt(bookIdInput);
                                System.out.print("Raf numarası: ");
                                String shelfIdInput = scanner.nextLine();
                                if (shelfIdInput.trim().isEmpty()) {
                                    System.out.println("Raf numarası boş olamaz!");
                                    continue;
                                }
                                int shelfId = Integer.parseInt(shelfIdInput);
                                org.example.library.Shelf shelf = new org.example.library.Shelf(shelfId);
                                java.time.LocalDate addedTime = java.time.LocalDate.now();
                                boolean isEnableBorrow = true;
                                org.example.library.Book book = new org.example.library.Book(title, type, author, bookId, shelf, addedTime, isEnableBorrow);
                                library.addBook(book);
                                System.out.println("Kitap başarıyla bağışlandı!");
                            } else if (usecim.equals("6")) {
                                System.out.println("Lütfen üye ID'nizi giriniz:");
                                String memberIdInput = scanner.nextLine();
                                long memberId = Long.parseLong(memberIdInput);
                                org.example.library.person.Member member = library.findMemberById(memberId);
                                System.out.println("Toplam cezanız: " + member.getTotalPenalty() + " TL");
                            }
                        } catch (Exception e) {
                            System.out.println("Bir hata oluştu: " + e.getMessage());
                        }
                    }
                } else if (secim.equals("2")) {
                    System.out.println("Personel menüsüne yönlendiriliyorsunuz...");
                    while (true) {
                        try {
                            System.out.println("\n--- PERSONEL MENÜSÜ ---");
                            System.out.println("1 - Kitap İşlemleri");
                            System.out.println("2 - Üye İşlemleri");
                            System.out.println("3 - Personel İşlemleri");
                            System.out.println("0 - Ana Menüye Dön");
                            System.out.print("Seçiminiz: ");
                            String psecim = scanner.nextLine();
                            if (psecim.equals("1")) {
                                while (true) {
                                    try {
                                        System.out.println("\n--- KİTAP İŞLEMLERİ ---");
                                        System.out.println("1 - Kitap Ekle");
                                        System.out.println("2 - Kitap Sil");
                                        System.out.println("3 - Kitap Güncelle");
                                        System.out.println("4 - Tüm Kitapları Listele");
                                        System.out.println("5 - Kitap Ara (Başlık)");
                                        System.out.println("6 - Kitap Ara (ID)");
                                        System.out.println("7 - Kitap Ara (Yazar)");
                                        System.out.println("8 - Kitap Ara (Tür)");
                                        System.out.println("9 - Rafta Bulunan Kitapları Listele");
                                        System.out.println("0 - Geri");
                                        System.out.print("Seçiminiz: ");
                                        String kitapSecim = scanner.nextLine();
                                        if (kitapSecim.equals("0")) break;
                                        if (kitapSecim.equals("1")) {
                                            System.out.print("Kitap başlığı: ");
                                            String title = scanner.nextLine();
                                            if (title == null || title.trim().isEmpty()) {
                                                System.out.println("Kitap başlığı boş olamaz!");
                                                continue;
                                            }
                                            org.example.library.Type[] types = org.example.library.Type.values();
                                            System.out.println("Kitap türünü seçin:");
                                            for (int i = 0; i < types.length; i++) {
                                                System.out.println((i + 1) + ". " + types[i]);
                                            }
                                            System.out.print("Tür numarası: ");
                                            String typeInput = scanner.nextLine();
                                            if (typeInput == null || typeInput.trim().isEmpty()) {
                                                System.out.println("Tür numarası boş olamaz!");
                                                continue;
                                            }
                                            int typeIndex;
                                            try {
                                                typeIndex = Integer.parseInt(typeInput.trim()) - 1;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Geçersiz tür numarası!");
                                                continue;
                                            }
                                            if (typeIndex < 0 || typeIndex >= types.length) {
                                                System.out.println("Geçersiz tür seçimi!");
                                                continue;
                                            }
                                            org.example.library.Type type = types[typeIndex];
                                            System.out.print("Yazar adı: ");
                                            String authorName = scanner.nextLine();
                                            if (authorName == null || authorName.trim().isEmpty()) {
                                                System.out.println("Yazar adı boş olamaz!");
                                                continue;
                                            }
                                            org.example.library.person.Author author = new org.example.library.person.Author(authorName, "Author");
                                            System.out.print("Kitap ID: ");
                                            String bookIdInput = scanner.nextLine();
                                            if (bookIdInput == null || bookIdInput.trim().isEmpty()) {
                                                System.out.println("Kitap ID boş olamaz!");
                                                continue;
                                            }
                                            int bookId;
                                            try {
                                                bookId = Integer.parseInt(bookIdInput.trim());
                                            } catch (NumberFormatException e) {
                                                System.out.println("Geçersiz kitap ID!");
                                                continue;
                                            }
                                            System.out.print("Raf numarası: ");
                                            String shelfIdInput = scanner.nextLine();
                                            if (shelfIdInput == null || shelfIdInput.trim().isEmpty()) {
                                                System.out.println("Raf numarası boş olamaz!");
                                                continue;
                                            }
                                            int shelfId;
                                            try {
                                                shelfId = Integer.parseInt(shelfIdInput.trim());
                                            } catch (NumberFormatException e) {
                                                System.out.println("Geçersiz raf numarası!");
                                                continue;
                                            }
                                            org.example.library.Shelf shelf = new org.example.library.Shelf(shelfId);
                                            java.time.LocalDate addedTime = java.time.LocalDate.now();
                                            boolean isEnableBorrow = true;
                                            org.example.library.Book book = new org.example.library.Book(title, type, author, bookId, shelf, addedTime, isEnableBorrow);
                                            library.addBook(book);
                                            System.out.println("Kitap başarıyla eklendi!");
                                        } else if (kitapSecim.equals("2")) {
                                            System.out.print("Silinecek kitap ID'si: ");
                                            int bookId = Integer.parseInt(scanner.nextLine());
                                            library.removeBook(bookId);
                                            System.out.println("Kitap başarıyla silindi!");
                                        } else if (kitapSecim.equals("3")) {
                                            System.out.print("Güncellenecek kitap ID'si: ");
                                            int bookId = Integer.parseInt(scanner.nextLine());
                                            Book oldBook = null;
                                            String oldTitle = "";
                                            String oldAuthor = "";
                                            String oldShelf = "";
                                            String oldType = "";
                                            String oldEnableBorrow = "";
                                            try {
                                                oldBook = library.findBookById(bookId);
                                                oldTitle = oldBook.getTitle();
                                                oldAuthor = oldBook.getAuthor().getName();
                                                oldShelf = String.valueOf(oldBook.getShelf().getShelfId());
                                                oldType = String.valueOf(oldBook.getType());
                                                oldEnableBorrow = oldBook.isEnableBorrow() ? "Evet" : "Hayır";
                                            } catch (Exception e) {
                                            }
                                            System.out.print("Yeni kitap başlığı" + (oldTitle.isEmpty() ? "" : " (Mevcut Başlık: " + oldTitle + ")") + ": ");
                                            String newTitle = scanner.nextLine();
                                            System.out.println("Kitap türünü seçin:" + (oldType.isEmpty() ? "" : " (Mevcut Tür: " + oldType + ")"));
                                            org.example.library.Type[] types = org.example.library.Type.values();
                                            for (int i = 0; i < types.length; i++) {
                                                System.out.println((i + 1) + ". " + types[i]);
                                            }
                                            System.out.print("Tür numarası: ");
                                            int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                                            if (typeIndex < 0 || typeIndex >= types.length) throw new IllegalArgumentException("Geçersiz tür seçimi!");
                                            org.example.library.Type type = types[typeIndex];
                                            System.out.print("Yeni yazar adı" + (oldAuthor.isEmpty() ? "" : " (Mevcut Yazar: " + oldAuthor + ")") + ": ");
                                            String authorName = scanner.nextLine();
                                            org.example.library.person.Author author = new org.example.library.person.Author(authorName, "Author");
                                            System.out.print("Yeni raf numarası" + (oldShelf.isEmpty() ? "" : " (Mevcut Raf: " + oldShelf + ")") + ": ");
                                            int shelfId = Integer.parseInt(scanner.nextLine());
                                            org.example.library.Shelf shelf = new org.example.library.Shelf(shelfId);
                                            java.time.LocalDate addedTime = java.time.LocalDate.now();
                                            System.out.print("Ödünç alınabilir mi? (Evet/Hayır)" + (oldEnableBorrow.isEmpty() ? "" : " (Mevcut Durum: " + oldEnableBorrow + ")") + ": ");
                                            String enableBorrowInput = scanner.nextLine().trim().toLowerCase();
                                            boolean isEnableBorrow = enableBorrowInput.equals("evet") || enableBorrowInput.equals("e") || enableBorrowInput.equals("yes") || enableBorrowInput.equals("y");
                                            org.example.library.Book updatedBook = new org.example.library.Book(newTitle, type, author, bookId, shelf, addedTime, isEnableBorrow);
                                            library.updateBook(bookId, updatedBook);
                                            System.out.println("Kitap başarıyla güncellendi!");
                                        } else if (kitapSecim.equals("4")) {
                                            System.out.println("Kütüphanedeki tüm kitaplar:");
                                            library.listAllBooks().forEach(System.out::println);
                                        } else if (kitapSecim.equals("5")) {
                                            System.out.print("Aranacak kitap başlığı: ");
                                            String title = scanner.nextLine();
                                            System.out.println("Arama sonuçları:");
                                            for (Book book : library.searchBooks(title)) {
                                                System.out.println(
                                                    "Başlık: " + book.getTitle() +
                                                    ", Yazar: " + book.getAuthor().getName() +
                                                    ", Tür: " + book.getType() +
                                                    ", Kitap ID: " + book.getBookId() +
                                                    ", Raf: " + book.getShelf().getShelfId() +
                                                    ", Eklenme Tarihi: " + book.getAddedTime() +
                                                    ", Ödünç Alınabilir: " + (book.isEnableBorrow() ? "Evet" : "Hayır")
                                                );
                                            }
                                        } else if (kitapSecim.equals("6")) {
                                            System.out.println("Kitap ID'si giriniz:");
                                            int bookId = Integer.parseInt(scanner.nextLine());
                                            var book = library.findBookById(bookId);
                                            System.out.println("--- Kitap Bilgileri ---");
                                            System.out.println("Başlık: " + book.getTitle());
                                            System.out.println("Yazar: " + book.getAuthor().getName());
                                            System.out.println("Tür: " + book.getType());
                                            System.out.println("Kitap ID: " + book.getBookId());
                                            System.out.println("Raf ID: " + book.getShelf().getShelfId());
                                            System.out.println("Eklenme Tarihi: " + book.getAddedTime());
                                            System.out.println("Ödünç Alınabilir mi: " + (book.isEnableBorrow() ? "Evet" : "Hayır"));
                                        } else if (kitapSecim.equals("7")) {
                                            System.out.println("Yazar adı giriniz:");
                                            String inputAuthorName = scanner.nextLine().trim();
                                            if (inputAuthorName.isEmpty()) {
                                                System.out.println("Yazar adı boş olamaz!");
                                                return;
                                            }
                                            System.out.println("Arama sonuçları:");
                                            String inputLower = inputAuthorName.toLowerCase();
                                            java.util.List<Book> allBooks = library.listAllBooks();
                                            java.util.List<Book> foundBooks = new java.util.ArrayList<>();
                                            for (Book book : allBooks) {
                                                String authorName = book.getAuthor().getName();
                                                if (authorName != null && authorName.toLowerCase().contains(inputLower)) {
                                                    foundBooks.add(book);
                                                }
                                            }
                                            if (foundBooks.isEmpty()) {
                                                System.out.println("Bu yazara ait kitap bulunamadı.");
                                            } else {
                                                for (Book book : foundBooks) {
                                                    System.out.println(
                                                        "Başlık: " + book.getTitle() +
                                                        ", Yazar: " + book.getAuthor().getName() +
                                                        ", Tür: " + book.getType() +
                                                        ", Kitap ID: " + book.getBookId() +
                                                        ", Raf: " + book.getShelf().getShelfId() +
                                                        ", Eklenme Tarihi: " + book.getAddedTime() +
                                                        ", Ödünç Alınabilir: " + (book.isEnableBorrow() ? "Evet" : "Hayır")
                                                    );
                                                }
                                            }
                                        } else if (kitapSecim.equals("8")) {
                                            System.out.println("Kitap türünü seçin:");
                                            org.example.library.Type[] types = org.example.library.Type.values();
                                            for (int i = 0; i < types.length; i++) {
                                                System.out.println((i + 1) + ". " + types[i]);
                                            }
                                            System.out.print("Tür numarası: ");
                                            int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                                            if (typeIndex < 0 || typeIndex >= types.length) {
                                                System.out.println("Geçersiz tür seçimi!");
                                                continue;
                                            }
                                            org.example.library.Type type = types[typeIndex];
                                            System.out.println("Arama sonuçları:");
                                            for (Book book : library.findBooksByType(type)) {
                                                System.out.println(
                                                    "Başlık: " + book.getTitle() +
                                                    ", Yazar: " + book.getAuthor().getName() +
                                                    ", Tür: " + book.getType() +
                                                    ", Kitap ID: " + book.getBookId() +
                                                    ", Raf: " + book.getShelf().getShelfId() +
                                                    ", Eklenme Tarihi: " + book.getAddedTime() +
                                                    ", Ödünç Alınabilir: " + (book.isEnableBorrow() ? "Evet" : "Hayır")
                                                );
                                            }
                                        } else if (kitapSecim.equals("9")) {
                                            System.out.println("Raftaki kitapları listelemek için raf ID'si giriniz:");
                                            int shelfId = Integer.parseInt(scanner.nextLine());
                                            Shelf shelf = new Shelf(shelfId);
                                            System.out.println("Rafta bulunan kitaplar:");
                                            for (Book book : library.findBooksByShelf(shelf)) {
                                                System.out.println(
                                                    "Başlık: " + book.getTitle() +
                                                    ", Yazar: " + book.getAuthor().getName() +
                                                    ", Tür: " + book.getType() +
                                                    ", Kitap ID: " + book.getBookId() +
                                                    ", Raf: " + book.getShelf().getShelfId() +
                                                    ", Eklenme Tarihi: " + book.getAddedTime() +
                                                    ", Ödünç Alınabilir: " + (book.isEnableBorrow() ? "Evet" : "Hayır")
                                                );
                                            }
                                        } else {
                                            System.out.println("(Kitap işlemi: " + kitapSecim + ")");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Bir hata oluştu: " + e.getMessage());
                                    }
                                }
                            } else if (psecim.equals("2")) {
                               
                                while (true) {
                                    try {
                                        System.out.println("\n--- ÜYE İŞLEMLERİ ---");
                                        System.out.println("1 - Yeni Üye Ekle");
                                        System.out.println("2 - Üye Sil");
                                        System.out.println("3 - Üye Bilgilerini Güncelle");
                                        System.out.println("4 - Üyeleri Listele");
                                        System.out.println("5 - Üye Ara (ID)");
                                        System.out.println("6 - Üye Ara (İsim)");
                                        System.out.println("0 - Geri");
                                        System.out.print("Seçiminiz: ");
                                        String uyeSecim = scanner.nextLine();
                                        if (uyeSecim.equals("0")) break;
                                        if (uyeSecim.equals("1")) {
                                            System.out.print("Üye ID: ");
                                            long memberId = Long.parseLong(scanner.nextLine());
                                            System.out.print("Üye adı: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Adres: ");
                                            String address = scanner.nextLine();
                                            System.out.print("Telefon: ");
                                            String phoneNumber = scanner.nextLine();
                                            System.out.print("Email: ");
                                            String email = scanner.nextLine();                                            
                                            String role = "Üye";
                                            java.util.List<org.example.library.Book> borrowedBooks = new java.util.ArrayList<>();
                                            double totalPenalty = 0.0;
                                            org.example.library.person.Member member = new org.example.library.person.Member(
                                                memberId, name, address, phoneNumber, email, role, borrowedBooks, totalPenalty);
                                            library.addMember(member);
                                            System.out.println("Üye başarıyla eklendi!");
                                            continue;
                                        } else if (uyeSecim.equals("2")) {
                                            System.out.println("Üye silme işlemi seçildi. Silmek istediğiniz üyenin ID'sini giriniz:");
                                            long memberId = Long.parseLong(scanner.nextLine());
                                            library.removeMember(memberId);
                                            System.out.println("Üye başarıyla silindi!");
                                        } else if (uyeSecim.equals("3")) {
                                            System.out.println("Üye güncelleme işlemi seçildi. Güncellemek istediğiniz üyenin ID'sini giriniz:");
                                            long memberId = Long.parseLong(scanner.nextLine());
                                            System.out.print("Yeni üye adı: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Yeni adres: ");
                                            String address = scanner.nextLine();
                                            System.out.print("Yeni telefon: ");
                                            String phoneNumber = scanner.nextLine();
                                            System.out.print("Yeni email: ");
                                            String email = scanner.nextLine();                                           
                                            String role = "Üye";
                                            java.util.List<org.example.library.Book> borrowedBooks = new java.util.ArrayList<>();
                                            double totalPenalty = 0.0;
                                            org.example.library.person.Member updatedMember = new org.example.library.person.Member(
                                                memberId, name, address, phoneNumber, email, role, borrowedBooks, totalPenalty);
                                            library.updateMember(memberId, updatedMember);
                                            System.out.println("Üye başarıyla güncellendi!");
                                        } else if (uyeSecim.equals("4")) {
                                            System.out.println("Kütüphanedeki tüm üyeler:");
                                            library.listAllMembers().forEach(System.out::println);
                                        } else if (uyeSecim.equals("5")) {
                                            System.out.print("Aranacak üye ID'si: ");
                                            long memberId = Long.parseLong(scanner.nextLine());
                                            var member = library.findMemberById(memberId);
                                            System.out.println("--- Üye Bilgileri ---");
                                            System.out.println("ID: " + member.getMemberId());
                                            System.out.println("Adı: " + member.getName());
                                            System.out.println("Adres: " + member.getAddress());
                                            System.out.println("Telefon: " + member.getPhoneNumber());
                                            System.out.println("Email: " + member.getEmail());
                                            System.out.println("Rol: " + member.getRole());
                                            System.out.println("Toplam Ceza: " + member.getTotalPenalty());
                                            System.out.println("Ödünç Alınan Kitaplar: " + member.getBorrowedBooks().size());
                                        } else if (uyeSecim.equals("6")) {
                                            System.out.print("Aranacak üye adı: ");
                                            String name = scanner.nextLine();
                                            System.out.println("Arama sonuçları:");
                                            try {
                                                java.util.List<org.example.library.person.Member> foundMembers = library.findMemberByName(name);
                                                for (org.example.library.person.Member member : foundMembers) {
                                                    System.out.println("ID: " + member.getMemberId() + ", Adı: " + member.getName() + ", Email: " + member.getEmail() + ", Telefon: " + member.getPhoneNumber());
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        } else {
                                            System.out.println("(Üye işlemi: " + uyeSecim + ")");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Bir hata oluştu: " + e.getMessage());
                                    }
                                }
                            } else if (psecim.equals("3")) {
                                // Personel işlemleri alt menüsü
                                while (true) {
                                    try {
                                        System.out.println("\n--- PERSONEL İŞLEMLERİ ---");
                                        System.out.println("1 - Personel Ekle");
                                        System.out.println("2 - Personel Sil");
                                        System.out.println("3 - Personel Bilgilerini Güncelle");
                                        System.out.println("4 - Personelleri Listele");
                                        System.out.println("5 - Personel Ara (ID)");
                                        System.out.println("6 - Personel Ara (İsim)");
                                        System.out.println("0 - Geri");
                                        System.out.print("Seçiminiz: ");
                                        String persSecim = scanner.nextLine();
                                        if (persSecim.equals("0")) break;
                                        if (persSecim.equals("1")) {
                                            System.out.print("Personel ID: ");
                                            long staffId = Long.parseLong(scanner.nextLine());
                                            System.out.print("Personel adı: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Adres: ");
                                            String address = scanner.nextLine();
                                            System.out.print("Telefon: ");
                                            String phoneNumber = scanner.nextLine();
                                            System.out.print("Email: ");
                                            String email = scanner.nextLine();
                                            String role = "Personel";
                                            org.example.library.person.LibraryStuff staff = new org.example.library.person.LibraryStuff(
                                                staffId, name, address, phoneNumber, email, role);
                                            library.addLibraryStuff(staff);
                                            System.out.println("Personel başarıyla eklendi!");
                                            continue;
                                        } else if (persSecim.equals("2")) {
                                            System.out.println("Personel silme işlemi seçildi. Silmek istediğiniz personelin ID'sini giriniz:");
                                            long staffId = Long.parseLong(scanner.nextLine());
                                            LibraryStuff staff = new LibraryStuff(staffId, "", "", "", "", "");
                                            library.removeLibraryStuff(staff);
                                            System.out.println("Personel başarıyla silindi!");
                                        } else if (persSecim.equals("3")) {
                                            System.out.println("Personel güncelleme işlemi seçildi. Güncellemek istediğiniz personelin ID'sini giriniz:");
                                            long staffId = Long.parseLong(scanner.nextLine());
                                            System.out.print("Yeni personel adı: ");
                                            String name = scanner.nextLine();
                                            System.out.print("Yeni adres: ");
                                            String address = scanner.nextLine();
                                            System.out.print("Yeni telefon: ");
                                            String phoneNumber = scanner.nextLine();
                                            System.out.print("Yeni email: ");
                                            String email = scanner.nextLine();                                         
                                            String role = "Personel";                              
                                            org.example.library.person.LibraryStuff updatedStaff = new org.example.library.person.LibraryStuff(
                                                staffId, name, address, phoneNumber, email, role);
                                            library.updateLibraryStuff(staffId, updatedStaff);
                                            System.out.println("Personel başarıyla güncellendi!");
                                        } else if (persSecim.equals("4")) {
                                            System.out.println("Kütüphanedeki tüm personeller:");
                                            library.listAllLibraryStaff().forEach(System.out::println);
                                        } else if (persSecim.equals("5")) {
                                            System.out.print("Aranacak personel ID'si: ");
                                            long staffId = Long.parseLong(scanner.nextLine());
                                            var staff = library.findLibraryStuffById(staffId);
                                            System.out.println("--- Personel Bilgileri ---");
                                            System.out.println("ID: " + staff.getStuffId());
                                            System.out.println("Adı: " + staff.getName());
                                            System.out.println("Adres: " + staff.getAddress());
                                            System.out.println("Telefon: " + staff.getPhoneNumber());
                                        } else if (persSecim.equals("6")) {
                                            System.out.print("Aranacak personel adı: ");
                                            String name = scanner.nextLine();
                                            System.out.println("Arama sonuçları:");
                                            try {
                                                java.util.List<org.example.library.person.LibraryStuff> foundStaff = library.findLibraryStuffByName(name);
                                                for (org.example.library.person.LibraryStuff staff : foundStaff) {
                                                    System.out.println("ID: " + staff.getStuffId() + ", Adı: " + staff.getName() + ", Email: " + staff.getEmail() + ", Telefon: " + staff.getPhoneNumber());
                                                }
                                            } catch (Exception e) {
                                                System.out.println(e.getMessage());
                                            }
                                        } else {
                                            System.out.println("(Personel işlemi: " + persSecim + ")");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Bir hata oluştu: " + e.getMessage());
                                    }
                                }
                            } else if (psecim.equals("0")) {
                                break;
                            } else {
                                System.out.println("Geçersiz seçim!");
                            }
                        } catch (Exception e) {
                            System.out.println("Bir hata oluştu: " + e.getMessage());
                        }
                    }
                } else if (secim.equals("3")) {
                    System.out.println("Çıkış yapılıyor. İyi günler!");
                    scanner.close();
                    return;
                } else {
                    System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
                }
            } catch (Exception e) {
                System.out.println("Bir hata oluştu: " + e.getMessage());
            }
        }
    }
}



