import org.example.library.Library;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Library library = Library.getInstance();
        System.out.println("+++++++++++++ KÜTÜPHANE OTOMASYONU +++++++++++++");
        while (true) {
            System.out.println("\nLütfen rolünüzü seçin:");
            System.out.println("1 - Üye");
            System.out.println("2 - Personel");
            System.out.println("3 - Çıkış");
            System.out.print("Seçiminiz: ");
            String secim = scanner.nextLine();
            if (secim.equals("1")) {
                System.out.println("Üye menüsüne yönlendiriliyorsunuz...");
                // Üye işlemleri buraya gelecek
            } else if (secim.equals("2")) {
                System.out.println("Personel menüsüne yönlendiriliyorsunuz...");
                // Personel işlemleri menüsü
                while (true) {
                    System.out.println("\n--- PERSONEL MENÜSÜ ---");
                    System.out.println("1 - Kitap Ekle");
                    System.out.println("2 - Ana Menüye Dön");
                    System.out.print("Seçiminiz: ");
                    String psecim = scanner.nextLine();
                    if (psecim.equals("1")) {
                        try {
                            System.out.print("Kitap başlığı: ");
                            String title = scanner.nextLine();
                            // Türleri göster
                            org.example.library.Type[] types = org.example.library.Type.values();
                            System.out.println("Kitap türünü seçin:");
                            for (int i = 0; i < types.length; i++) {
                                System.out.println((i + 1) + ". " + types[i]);
                            }
                            System.out.print("Tür numarası: ");
                            int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                            if (typeIndex < 0 || typeIndex >= types.length) throw new IllegalArgumentException("Geçersiz tür seçimi!");
                            org.example.library.Type type = types[typeIndex];
                            System.out.print("Yazar adı: ");
                            String authorName = scanner.nextLine();
                            org.example.library.person.Author author = new org.example.library.person.Author(authorName, "Author");
                            System.out.print("Kitap ID: ");
                            int bookId = Integer.parseInt(scanner.nextLine());
                            System.out.print("Raf numarası: ");
                            int shelfId = Integer.parseInt(scanner.nextLine());
                            org.example.library.Shelf shelf = new org.example.library.Shelf(shelfId);
                            java.time.LocalDate addedTime = java.time.LocalDate.now();
                            boolean isEnableBorrow = true;
                            org.example.library.Book book = new org.example.library.Book(title, type, author, bookId, shelf, addedTime, isEnableBorrow, false);
                            library.addBook(book);
                            System.out.println("Kitap başarıyla eklendi!");
                        } catch (Exception e) {
                            System.out.println("Kitap eklenirken hata: " + e.getMessage());
                        }
                    } else if (psecim.equals("2")) {
                        break;
                    } else {
                        System.out.println("Geçersiz seçim!");
                    }
                }
            } else if (secim.equals("3")) {
                System.out.println("Çıkış yapılıyor. İyi günler!");
                scanner.close();
                return;
            } else {
                System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
    }
}