class Smartwatch implements IMobileDevice {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;

  /* Konstruktor */
  public Smartwatch(String brand, String model, double price) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.isOn = false;
    System.out.println("Smartwatch " + brand + " " + model + " created.");
  }

  @Override
  public void makeCall(String number){
    System.out.println("Calling " + number + " from " + brand + " " + model);
  }

  public void sendMessage(String message){
    System.out.println("Sending message: " + message);
  }

  public void connectToWifi(String networkName){
    System.out.println("Connected to " + networkName);
  }

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