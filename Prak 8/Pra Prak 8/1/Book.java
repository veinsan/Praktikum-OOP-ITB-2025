/* TODO: Lengkapi class Book dengan validasi ISBN dan exception handling

   Fields:
   - title (String)
   - author (String)
   - isbn (String): ISBN-10 atau ISBN-13
   - publicationYear (int)
   - copies (int): total copies
   - availableCopies (int): copies yang tersedia

   Constructor:
   - Book(String title, String author, String isbn, int publicationYear, int copies)
     throws InvalidBookException

     Validasi (throw InvalidBookException dengan bookTitle, invalidField, dan optional invalidValue):
     1. title tidak boleh null/kosong (trim)
     2. author tidak boleh null/kosong (trim)
     3. author harus minimal 2 kata (pisahkan dengan split("\\s+"))
     4. publicationYear harus antara 1000 dan tahun sekarang (gunakan java.time.Year.now().getValue())
     5. copies tidak boleh negatif
     6. ISBN harus valid (panggil isValidISBN)

     Jika semua valid:
     - Set semua fields (trim untuk String)
     - Set availableCopies = copies

   Private Helper Methods untuk ISBN Validation:

   - boolean isValidISBN(String isbn)
     * Return false jika isbn null
     * Remove hyphens dan spaces: cleanISBN = isbn.replaceAll("[\\s-]", "")
     * Jika length 10: return isValidISBN10(cleanISBN)
     * Jika length 13: return isValidISBN13(cleanISBN)
     * Otherwise: return false

   - boolean isValidISBN10(String isbn)
     * ISBN-10 checksum algorithm:
       - Sum = (digit1 × 10) + (digit2 × 9) + ... + (digit9 × 2) + check_digit
       - Check digit bisa 'X' (nilai 10) atau digit 0-9
       - Valid jika Sum % 11 == 0
     * Gunakan try-catch untuk handle exceptions, return false jika error

   - boolean isValidISBN13(String isbn)
     * ISBN-13 checksum algorithm:
       - Sum = digit1 + (digit2 × 3) + digit3 + (digit4 × 3) + ... + digit13
       - Digit ganjil (index 0,2,4...) × 1, digit genap (index 1,3,5...) × 3
       - Valid jika Sum % 10 == 0
     * Gunakan try-catch, return false jika error

   Public Methods:

   - getters untuk semua fields (getTitle, getAuthor, getIsbn, getPublicationYear, getCopies, getAvailableCopies)

   - void borrowBook() throws BookNotAvailableException
     * Jika availableCopies <= 0: throw BookNotAvailableException dengan detail (title, requestedCopies=1, availableCopies)
     * Kurangi availableCopies

   - void returnBook() throws InvalidBookException
     * Jika availableCopies >= copies: throw InvalidBookException
     * Tambah availableCopies

   - toString(): return format string
     * Format EXACT (abaikan simbol <>): "<title> by <author> (<year>) [ISBN: <isbn>] - Available: <avail>/<total>"
     * <title> = judul buku
     * <author> = nama penulis
     * <year> = tahun publikasi
     * <isbn> = ISBN (dengan hyphens/spaces seperti input asli)
     * <avail> = availableCopies
     * <total> = copies
     * Contoh: "Clean Code by Robert Martin (2008) [ISBN: 0-13-235088-2] - Available: 3/5"
     * Contoh: "Design Patterns by Gang of Four (1994) [ISBN: 978-0-201-63361-0] - Available: 2/2"
*/

public class Book {
    // TODO: Declare fields
    private String title;
    private String author;
    private String isbn;
    private int publicationYear;
    private int copies;
    private int availableCopies;

    // TODO: Implement constructor dengan validasi lengkap
    public Book(String title, String author, String isbn, int publicationYear, int copies)
      throws InvalidBookException {
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidBookException("Title tidak boleh null/kosong.", title, "title");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new InvalidBookException("Author tidak boleh null/kosong.", title, "author");
        }
        String[] words = author.trim().split("\\s+");
        if (words.length < 2) {
            throw new InvalidBookException("Author harus minimal 2 kata.", title, "author", author);
        }
        int currentYear = java.time.Year.now().getValue();
        if (publicationYear < 1000 || publicationYear > currentYear) {
            throw new InvalidBookException("Publication Year harus antara 1000 dan tahun sekarang.", title, "publicationYear", String.valueOf(publicationYear));
        }
        if (copies < 0) {
            throw new InvalidBookException("Copies tidak boleh negatif.", title, "copies", String.valueOf(copies));
        }
        if (!isValidISBN(isbn)) {
            throw new InvalidBookException("ISBN harus valid.", title, "isbn", isbn);
        }
        this.title = title.trim();
        this.author = author.trim();
        this.isbn = isbn.trim();
        this.publicationYear = publicationYear;
        this.copies = copies;
        this.availableCopies = copies;
    }

    // TODO: Implement private helper methods untuk ISBN validation
    private boolean isValidISBN(String isbn) {
      if (isbn == null) return false;
      String cleanISBN = isbn.replaceAll("[\\s-]", "");
      if (cleanISBN.length() == 10) {
        return isValidISBN10(cleanISBN);
      } else if (cleanISBN.length() == 13) {
        return isValidISBN13(cleanISBN);
      } else {
        return false;
      }
    }

    private boolean isValidISBN10(String isbn) {
        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                char c = isbn.charAt(i);
                if (!Character.isDigit(c)) {
                    return false;
                }
                int digit = Character.getNumericValue(c);
                sum += (10 - i) * digit;
            }
            char lastChar = isbn.charAt(9);
            int checkDigit;
            if (lastChar == 'X' || lastChar == 'x') {
                checkDigit = 10;
            } else if (Character.isDigit(lastChar)) {
                checkDigit = Character.getNumericValue(lastChar);
            } else {
                return false;
            }
            sum += checkDigit;
            return sum % 11 == 0;
        } 
        catch (Exception e) {
            return false;
        }
    }

    private boolean isValidISBN13(String isbn) {
        try {
            int sum = 0;

            for (int i = 0; i < 13; i++) {
                char c = isbn.charAt(i);
                if (!Character.isDigit(c)) return false;
                int digit = Character.getNumericValue(c);
                if (i % 2 == 0) {
                    sum += digit;
                } else {
                    sum += digit * 3;
                }
            }
            return sum % 10 == 0;
        }
        catch (Exception e) {
            return false;
        }
    }

    // TODO: Implement getters
    public String getTitle(){
      return title;
    }

    public String getAuthor(){
      return author;
    }

    public String getIsbn(){
      return isbn;
    }

    public int getPublicationYear(){
      return publicationYear;
    }
    public int getCopies(){
      return copies;
    }
    public int getAvailableCopies(){
      return availableCopies;
    }

    // TODO: Implement borrowBook()
    public void borrowBook() throws BookNotAvailableException {
      if (availableCopies <= 0) {
        throw new BookNotAvailableException("Buku tidak tersedia.", title, 1, availableCopies);
      }
      availableCopies--;
    }

    // TODO: Implement returnBook()
    public void returnBook() throws InvalidBookException {
      if (availableCopies >= copies) {
        throw new InvalidBookException("Tidak bisa mengembalikan buku.", title, "availableCopies", String.valueOf(availableCopies));
      }
      availableCopies++;
    }

    // TODO: Implement toString()
    public String toString() {
    return title + " by " + author + " (" + publicationYear + ") [ISBN: " + isbn + "] - Available: " + availableCopies + "/" + copies;
    }
}
