public class Driver {
    private String name;
    private String licenseNumber;
    private double rating; // rating 0.0 - 5.0

    public Driver(String name, String licenseNumber) {
	/**
	 * TODO: Buatlah konstruktor untuk driver 
	 * 	sesuai dengan attribut yang dimiliki oleh kelas driver,
	 *	Rating diset default ke nol. 	
	 * */
    this.name = name;
    this.licenseNumber = licenseNumber;
    this.rating = 0.0;
    }

    public void introduce() {
 	/**
	 * TODO: Fungsi ini untuk memperkenalkan driver dengan format
	 * 	"Supir: {name} - Lisensi: {license} - Rating: {rating}"
	 * */
    System.out.printf("Supir: %s - Lisensi: %s - Rating: %.1f\n",this.name, this.licenseNumber, this.rating);
    }

    public void updateRating(double newRating) {
   	/**
	 * TODO: Fungsi ini untuk melakukan update pada rating 
	 * 	Jika gagal, output saja "Rating harus antara 0 sampai 5"
	 * */
    if (newRating < 0.0 || newRating > 5.0){
        System.out.println("Rating harus antara 0 sampai 5");
    }else{
        this.rating = newRating;
    }

    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}
