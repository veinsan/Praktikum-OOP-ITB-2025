class TabletDevice implements ITablet {
  private String brand;
  private String model;
  private double price;
  private boolean isOn;
  private String operatingSystem;

  /* Konstruktor */
  public TabletDevice(String brand, String model, double price, String operatingSystem) {
    this.brand = brand;
    this.model = model;
    this.price = price;
    this.operatingSystem = operatingSystem;
    this.isOn = false;
    System.out.println("Tablet " + brand + " " + model + " created.");
  }

  public void usePen(){
    System.out.println("Using pen on " + brand + " " + model);
  }

  public void rotateScreen(){
    System.out.println("Screen rotated on " + brand + " " + model);
  }

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

  public void installSoftware(String softwareName){
    System.out.println("Installing " + softwareName + " on " + brand + " " + model);
  }

  public void openApplication(String appName){
    System.out.println("Opening " + appName);
  }

  public String getOperatingSystem(){
    return operatingSystem;
  }

}