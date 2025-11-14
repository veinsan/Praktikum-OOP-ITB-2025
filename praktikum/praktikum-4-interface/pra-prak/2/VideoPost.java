/**
 * VideoPost.java
 * 
 * Kelas VideoPost merupakan kelas turunan dari Post dan mengimplementasikan Engageable serta Shareable
 */
public class VideoPost extends Post implements Engageable, Shareable{

    private int views;
    private int durationSec;
    private boolean useAI;
  
    /**
     * Membuat objek VideoPost baru.
     * Menginisialisasi author, caption, durasi video, dan status penggunaan AI.
     * Views awal bernilai 0.
     *
     * @param author     nama pembuat postingan
     * @param caption    teks caption
     * @param durationSec durasi video dalam detik
     * @param useAI      apakah menggunakan AI
     */
    public VideoPost(String author, String caption, int durationSec, boolean useAI) {
      super(author, caption);
      this.durationSec = durationSec;
      this.useAI = useAI;
      this.views = 0;
    }
  
    /**
     * Menambah jumlah views sebesar 1.
     */
    public void view() {
      this.views++;
    }
  
    /**
     * Mengambil jumlah views pada video.
     *
     * @return jumlah views
     */
    public int getViews() {
      return this.views;
    }
  
    /**
     * Mengambil durasi video dalam detik.
     *
     * @return durasi video
     */
    public int getDurationSec() {
      return durationSec;
    }
  
    /**
     * Mengecek apakah video menggunakan AI.
     *
     * @return true jika menggunakan AI, false jika tidak
     */
    public boolean isUseAI() {
      return useAI;
    }

    /**
     * Menghitung skor engagement total untuk postingan video.
     * Perhitungan: baseScore ditambah 0.5 kali views, ditambah durationSec / 30, dikurangi 10 jika useAI
     * HINT: Jangan lupa untuk menggunakan casting
     * 
     * @return skor total engagement
     */
    private int totalScore() {
      return (int) (baseScore() + (this.views * 0.5) + (durationSec/30) - ((isUseAI()) ? 10 : 0));
    }
  
    /**
     * Membandingkan engagement (totalScore) antara postingan video ini dengan video lain.
     * 
     * @param other video lain yang akan dibandingkan
     * @return -1 jika lebih rendah, 0 jika sama, 1 jika lebih tinggi
     */
    @Override
    public int compareEngagement(Engageable other) {
      if (other instanceof VideoPost){
        VideoPost otherVideo = (VideoPost) other;

        int thisScore = this.totalScore();
        int otherScore = otherVideo.totalScore();

        if (thisScore < otherScore){
          return -1;
        }
        else if (thisScore > otherScore){
          return 1;
        }
        else{
          return 0;
        }
      }

      return 0;
    }
  
    /**
     * Membagikan video ke target tertentu.
     * Menampilkan pesan "Video by @[author] shared to [target]".
     * Setelah itu, share dari Post tersebut juga akan bertambah satu.
     *
     * @param target tujuan share (user tertentu)
     */
    @Override
    public void shareTo(String target) {
      System.out.println("Video by @" + getAuthor() + " shared to " + target);
      share();
    }
  }
  