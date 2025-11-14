class GamingConsole implements IGadget {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;

  /* Konstruktor */
  public GamingConsole(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.isOn = false;
    System.out.println("Gaming Console " + brand + " " + model + " created.");
  }


  // Gaming Console specific method
  /**
   * Memainkan game pada konsol
   * Menampilkan pesan "Playing [gameName] on [brand] [model]"
   * 
   * @param gameName
   */
  public void playGame(String gameName) {
    System.out.println("Playing " + gameName + " on " + brand + " " + model);
  }

  @Override
  public void turnOn(){
    this.isOn = true;
    System.out.println(brand + " " + model + " is now ON");
  }

  public void turnOff(){
    this.isOn = false;
    System.out.println(brand + " " + model + " is now OFF");
  }

  public String getInfo(){
    if (isOn){
      return "[ON] " + brand + " " + model + " - Rp " + price;
    }
    else {
      return "[OFF] " + brand + " " + model + " - Rp " + price;
    }
  }

  public double getPrice(){
    return price;
  }

  public String getBrand(){
    return brand;
  }
}