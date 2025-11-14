/**
 * PhotoPost.java
 * 
 * Kelas PhotoPost merupakan kelas turunan dari Post dan mengimplementasikan Engageable serta Shareable
 */
public class PhotoPost extends Post implements Engageable, Shareable{

    private int hashtagCount;
    private boolean useAI;
    private boolean useMusic;
  
    /**
     * Membuat objek PhotoPost baru.
     * Menginisialisasi author, caption, jumlah hashtag, dan status penggunaan AI/musik.
     *
     * @param author      nama pembuat postingan
     * @param caption     teks caption
     * @param hashtagCount jumlah hashtag yang digunakan
     * @param useAI       apakah menggunakan AI
     * @param useMusic    apakah menggunakan musik
     */
    public PhotoPost(String author, String caption, int hashtagCount, boolean useAI, boolean useMusic) {
      super(author, caption);
      this.hashtagCount = hashtagCount;
      this.useAI = useAI;
      this.useMusic = useMusic;
    }
  
    /**
     * Mengembalikan jumlah hashtag pada postingan.
     * 
     * @return jumlah hashtag
     */
    public int getHashtagCount() {
      return hashtagCount;

    }
  
    /**
     * Mengecek apakah postingan menggunakan AI.
     * 
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {
      return useAI;
    }
  
    /**
     * Mengecek apakah postingan menggunakan musik.
     * 
     * @return true jika menggunakan musik, false jika tidak
     */
    public boolean isUseMusic() {
      return useMusic;
    }

    /**
   * Menghitung skor engagement total untuk postingan foto.
   * Perhitungan: baseScore ditambah 2 kali hashtagCount, dikurangi 10 jika useAI, ditambah 5 jika useMusic
   *
   * @return skor total engagement
   */
    private int totalScore() {
      return baseScore() + (2 * hashtagCount) - ((useAI) ? 10: 0) + ((useMusic) ? 5 : 0);
    }
  
    /**
     * Membandingkan engagement (totalScore) antara postingan ini dengan postingan lain.
     * 
     * @param other postingan lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {
      if (other instanceof PhotoPost){
        PhotoPost otherPhoto = (PhotoPost) other;
        
        int thisScore = this.totalScore();
        int otherScore = otherPhoto.totalScore();

        if (thisScore < otherScore){
          return -1;
        }
        else if (thisScore > otherScore){
          return 1;
        }
        else {
          return 0;
        }
      }

      return 0;
    }
  
    /**
     * Membagikan postingan ke target tertentu.
     * Menampilkan pesan "Photo by @[author] shared to [target]".
     * Setelah itu, share dari Post tersebut juga akan bertambah satu.
     *
     * @param target tujuan share (user tertentu)
     */
    @Override
    public void shareTo(String target) {
      System.out.println("Photo by @" + getAuthor() + " shared to " + target);
      share();
    }
  }
  