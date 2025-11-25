import org.example.library.Book;
import org.example.library.Library;
import org.example.library.Shelf;
import org.example.library.person.Author;
import org.example.library.person.LibraryStuff;

public class Main {
    
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Library library = Library.getInstance();
        library.addBook(new org.example.library.Book("Sample Book", org.example.library.Type.HISTORY, new org.example.library.person.Author("Sample Author", "Author"), 1, new org.example.library.Shelf(1), java.time.LocalDate.now(), true));
        
            for (int i = 1; i < 50; i++) {
         library.addBook(new org.example.library.Book("Sample Book" + i, org.example.library.Type.HISTORY, new org.example.library.person.Author("Sample Author", "Author"), i+1, new org.example.library.Shelf(1), java.time.LocalDate.now(), true));        
            }

        System.out.println("----------------------------------------------------------");

        System.out.println("----------------------------------------------------------");

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
               while (true) {
                    System.out.println("\n--- ÜYE MENÜSÜ ---");
                    System.out.println("1 - Kitap Arama"); // library.searchBooksByTitle(), searchBooksByAuthor(), searchBooksByType(), searchBooksById() gibi metotlar
                    System.out.println("2 - Ödünç Alınan Kitaplar"); // library.listBorrowedBooksByMember(memberId)
                    System.out.println("3 - Kitap Ödünç Alma"); // library.borrowBook(memberId, bookId)
                    System.out.println("4 - Kitap İade"); // library.returnBook(memberId, bookId)
                    System.out.println("5 - Kitap Bağışı"); // library.donateBook(memberId, Book)
                    System.out.println("6 - Cezaları Görüntüle"); // library.listPenaltiesByMember(memberId)
                    System.out.println("0 - Ana Menüye Dön");
                    System.out.print("Seçiminiz: ");
                    String usecim = scanner.nextLine();
                    if (usecim.equals("0")) break;
                    if (usecim.equals("1")) {
                        // Örnek: Başlığa göre kitap arama
                        System.out.print("Aranacak kitap başlığı: ");
                        String title = scanner.nextLine();
                        System.out.println(library.searchBooks(title));
                        continue;
                    }
               }
            } else if (secim.equals("2")) {
                System.out.println("Personel menüsüne yönlendiriliyorsunuz...");
                while (true) {
                    System.out.println("\n--- PERSONEL MENÜSÜ ---");
                    System.out.println("1 - Kitap İşlemleri");
                    System.out.println("2 - Üye İşlemleri");
                    System.out.println("3 - Personel İşlemleri");
                    System.out.println("0 - Ana Menüye Dön");
                    System.out.print("Seçiminiz: ");
                    String psecim = scanner.nextLine();
                    if (psecim.equals("1")) {                    
                        while (true) {
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
                           
                            // Kitap işlemleri alt menüsü
                            // 1 - Kitap Ekle: library.addBook(Book)
                            // 2 - Kitap Sil: library.removeBook(bookId)
                            // 3 - Kitap Güncelle: library.updateBook(bookId, ...)
                            // 4 - Tüm Kitapları Listele: library.listAllBooks()
                            // 5 - Kitap Ara (Başlık): library.searchBooksByTitle(title)
                            // 6 - Kitap Ara (ID): library.searchBooksById(bookId)
                            // 7 - Kitap Ara (Yazar): library.searchBooksByAuthor(authorName)
                            // 8 - Kitap Ara (Tür): library.searchBooksByType(type)
                            // 9 - Rafta Bulunan Kitapları Listele: library.listBooksOnShelf(shelfId)
                            if (kitapSecim.equals("1")) {
                                try {
                                    // library.addBook(Book) çağrısı burada
                                    System.out.print("Kitap başlığı: ");
                                    String title = scanner.nextLine();
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
                                    org.example.library.Book book = new org.example.library.Book(title, type, author, bookId, shelf, addedTime, isEnableBorrow);
                                    library.addBook(book);
                                    System.out.println("Kitap başarıyla eklendi!");
                                } catch (Exception e) {
                                    System.out.println("Kitap eklenirken hata: " + e.getMessage());
                                }
                            } else if (kitapSecim.equals("2")) {
                                try {                                    
                                    System.out.print("Silinecek kitap ID'si: ");
                                    int bookId = Integer.parseInt(scanner.nextLine());
                                    library.removeBook(bookId);
                                    System.out.println("Kitap başarıyla silindi!");
                                } catch (Exception e) {
                                    System.out.println("Kitap silinirken hata: " + e.getMessage());
                                }
                                
                            } else if (kitapSecim.equals("3")) {
                                try {
                                    System.out.print("Güncellenecek kitap ID'si: ");
                                    int bookId = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Yeni kitap başlığı: ");
                                    String newTitle = scanner.nextLine();
                                    System.out.println("Kitap türünü seçin:");
                                    org.example.library.Type[] types = org.example.library.Type.values();
                                    for (int i = 0; i < types.length; i++) {
                                        System.out.println((i + 1) + ". " + types[i]);
                                    }
                                    System.out.print("Tür numarası: ");
                                    int typeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                                    if (typeIndex < 0 || typeIndex >= types.length) throw new IllegalArgumentException("Geçersiz tür seçimi!");
                                    org.example.library.Type type = types[typeIndex];
                                    System.out.print("Yeni yazar adı: ");
                                    String authorName = scanner.nextLine();
                                    org.example.library.person.Author author = new org.example.library.person.Author(authorName, "Author");
                                    System.out.print("Yeni raf numarası: ");
                                    int shelfId = Integer.parseInt(scanner.nextLine());
                                    org.example.library.Shelf shelf = new org.example.library.Shelf(shelfId);                                   
                                    java.time.LocalDate addedTime = java.time.LocalDate.now();
                                    boolean isEnableBorrow = true; 
                                    org.example.library.Book updatedBook = new org.example.library.Book(newTitle, type, author, bookId, shelf, addedTime, isEnableBorrow);
                                    library.updateBook(bookId, updatedBook);
                                    System.out.println("Kitap başarıyla güncellendi!");
                                } catch (Exception e) {
                                    System.out.println("Kitap güncellenirken hata: " + e.getMessage());
                                }
                            } else if (kitapSecim.equals("4")) {
                                System.out.println("Kütüphanedeki tüm kitaplar:");
                                library.listAllBooks().forEach(System.out::println);
                            } else if (kitapSecim.equals("5")) {
                                System.out.print("Aranacak kitap başlığı: ");
                                String title = scanner.nextLine();
                                System.out.println("Arama sonuçları:");
                                System.out.println(library.searchBooks(title));
                            } else if (kitapSecim.equals("6")) {
                                System.out.println("Kitap ID'si giriniz:");
                                int bookId = Integer.parseInt(scanner.nextLine());
                                try {
                                    var book = library.findBookById(bookId);
                                    System.out.println("--- Kitap Bilgileri ---");
                                    System.out.println("Başlık: " + book.getTitle());
                                    System.out.println("Yazar: " + book.getAuthor().getName());
                                    System.out.println("Tür: " + book.getType());
                                    System.out.println("Kitap ID: " + book.getBookId());
                                    System.out.println("Raf ID: " + book.getShelf().getShelfId());
                                    System.out.println("Eklenme Tarihi: " + book.getAddedTime());
                                    System.out.println("Ödünç Alınabilir mi: " + (book.isEnableBorrow() ? "Evet" : "Hayır"));
                                } catch (Exception e) {
                                    System.out.println("Kitap bulunamadı: " + e.getMessage());
                                }

                            } else if (kitapSecim.equals("7")) {
                                    System.out.println("Yazar adı giriniz:");
                                    Author searchedAuthor = new Author("isim", "Author");
                                    searchedAuthor.setName(scanner.nextLine());
                                    System.out.println("Arama sonuçları:");
                                    System.out.println(library.findBooksByAuthor(searchedAuthor));
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
                                System.out.println(library.findBooksByType(type));
                            } else if (kitapSecim.equals("9")) {
                               int shelfId = Integer.parseInt(scanner.nextLine());
                               Shelf shelf = new Shelf(shelfId);
                               System.out.println("Rafta bulunan kitaplar:");
                               System.out.println(library.findBooksByShelf(shelf));
                            } else {
                               System.out.println("(Kitap işlemi: " + kitapSecim + ")");
                            }
                        }
                    } else if (psecim.equals("2")) {
                        // Üye işlemleri alt menüsü
                        while (true) {
                            System.out.println("\n--- ÜYE İŞLEMLERİ ---");
                            System.out.println("1 - Yeni Üye Ekle"); // library.addMember(Member)
                            System.out.println("2 - Üye Sil"); // library.removeMember(memberId)
                            System.out.println("3 - Üye Bilgilerini Güncelle"); // library.updateMember(memberId, ...)
                            System.out.println("4 - Üyeleri Listele"); // library.listAllMembers()
                            System.out.println("5 - Üye Ara (ID)"); // library.searchMemberById(memberId)
                            System.out.println("6 - Üye Ara (İsim)"); // library.searchMemberByName(name)
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
                                System.out.print("Rol: ");
                                String role = scanner.nextLine();
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
                                try {
                                    library.removeMember(memberId);
                                    System.out.println("Üye başarıyla silindi!");
                                } catch (Exception e) {
                                    System.out.println("Üye silinirken hata: " + e.getMessage());
                                }
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
                                System.out.print("Yeni rol: ");
                                String role = scanner.nextLine();
                                java.util.List<org.example.library.Book> borrowedBooks = new java.util.ArrayList<>();
                                double totalPenalty = 0.0;
                                org.example.library.person.Member updatedMember = new org.example.library.person.Member(
                                    memberId, name, address, phoneNumber, email, role, borrowedBooks, totalPenalty);
                                try {
                                    library.updateMember(memberId, updatedMember);
                                    System.out.println("Üye başarıyla güncellendi!");
                                } catch (Exception e) {
                                    System.out.println("Üye güncellenirken hata: " + e.getMessage());
                                }
                            } else if (uyeSecim.equals("4")) {
                                System.out.println("Kütüphanedeki tüm üyeler:");
                                library.listAllMembers().forEach(System.out::println);
                            } else if (uyeSecim.equals("5")) {
                                System.out.print("Aranacak üye ID'si: ");
                                long memberId = Long.parseLong(scanner.nextLine());
                                try {
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
                                } catch (Exception e) {
                                    System.out.println("Üye bulunamadı: " + e.getMessage());
                                }
                            } else if (uyeSecim.equals("6")) {
                                System.out.print("Aranacak üye adı: ");
                                String name = scanner.nextLine();
                                System.out.println("Arama sonuçları:");
                                System.out.println(library.findMemberByName(name));
                            } else {
                                System.out.println("(Üye işlemi: " + uyeSecim + ")");
                            }
                        }
                    } else if (psecim.equals("3")) {
                        // Personel işlemleri alt menüsü
                        while (true) {
                            System.out.println("\n--- PERSONEL İŞLEMLERİ ---");
                            System.out.println("1 - Personel Ekle"); // library.addStaff(Staff)
                            System.out.println("2 - Personel Sil"); // library.removeStaff(staffId)
                            System.out.println("3 - Personel Bilgilerini Güncelle"); // library.updateStaff(staffId, ...)
                            System.out.println("4 - Personelleri Listele"); // library.listAllStaff()
                            System.out.println("5 - Personel Ara (ID)"); // library.searchStaffById(staffId)
                            System.out.println("6 - Personel Ara (İsim)"); // library.searchStaffByName(name)
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
                                System.out.print("Rol: ");
                                String role = scanner.nextLine();
                                org.example.library.person.LibraryStuff staff = new org.example.library.person.LibraryStuff(
                                    staffId, name, address, phoneNumber, email, role);
                                library.addLibraryStuff(staff);
                                System.out.println("Personel başarıyla eklendi!");
                                continue;
                            } else if (persSecim.equals("2")) {
                                System.out.println("Personel silme işlemi seçildi. Silmek istediğiniz personelin ID'sini giriniz:");
                                long staffId = Long.parseLong(scanner.nextLine());
                                try {
                                        LibraryStuff staff = new LibraryStuff(staffId, "", "", "", "", "");
                                        library.removeLibraryStuff(staff);
                                    System.out.println("Personel başarıyla silindi!");
                                } catch (Exception e) {
                                    System.out.println("Personel silinirken hata: " + e.getMessage());
                                }
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
                                System.out.print("Yeni rol: ");
                                String role = scanner.nextLine();                                
                                org.example.library.person.LibraryStuff updatedStaff = new org.example.library.person.LibraryStuff(
                                    staffId, name, address, phoneNumber, email, role);
                                try {
                                    library.updateLibraryStuff(staffId, updatedStaff);
                                    System.out.println("Personel başarıyla güncellendi!");
                                } catch (Exception e) {
                                    System.out.println("Personel güncellenirken hata: " + e.getMessage());
                                }
                            } else if (persSecim.equals("4")) {
                                System.out.println("Kütüphanedeki tüm personeller:");
                                library.listAllLibraryStaff().forEach(System.out::println);
                            } else if (persSecim.equals("5")) {
                                System.out.print("Aranacak personel ID'si: ");
                                long staffId = Long.parseLong(scanner.nextLine());
                                try {
                                    var staff = library.findLibraryStuffById(staffId);
                                    System.out.println("--- Personel Bilgileri ---");
                                    System.out.println("ID: " + staff.getStuffId());
                                    System.out.println("Adı: " + staff.getName());
                                    System.out.println("Adres: " + staff.getAddress());
                                    System.out.println("Telefon: " + staff.getPhoneNumber());
                                } catch (Exception e) {
                                    System.out.println("Personel bulunamadı: " + e.getMessage());
                                }
                                    System.out.println("(Personel işlemi: " + persSecim + ")");
                                } else if (persSecim.equals("6")) {
                                    System.out.print("Aranacak personel adı: ");
                                    String name = scanner.nextLine();
                                    System.out.println("Arama sonuçları:");
                                    System.out.println(library.findLibraryStuffByName(name));
                            }
                        }
                        } else if (psecim.equals("0")) {
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



