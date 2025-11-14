public abstract class OperatingSystem{
    
    private String name;
    private String version;
    private String kernelType;
    private double baseScore;

    public OperatingSystem(String name, String version, String kernelType, double baseScore){
        this.name = (name == null || name.isEmpty()) ? "Unknown OS" : name;
        this.version = (version == null || version.isEmpty()) ? "Unknown Version" : version;
        this.kernelType = (kernelType == null || kernelType.isEmpty()) ? "Unknown Kernel" : kernelType;
        this.baseScore = (baseScore<=0 || baseScore>100) ? 0 : baseScore;
    }

    public abstract double calculateCompatibility(UsageType usage);
    protected abstract String getAdditionalInfo();

    protected double clampScore(double score){
        return Math.max(0, Math.min(100, score));
    }

    public void printInfo(UsageType usage){
        System.out.println("Name: " + name);
        System.out.println("Version: " + version);
        System.out.println("Kernel Type: " + kernelType);
        String additionalInfo = getAdditionalInfo();
        if (additionalInfo != null && !additionalInfo.isEmpty()){
            System.out.println(additionalInfo);
        }
        System.out.printf("Base Score: %.2f\n", baseScore);
        double compatibilityScore = calculateCompatibility(usage);
        System.out.printf("Compatibility for %s: %.2f\n", usage.name(), compatibilityScore);
    
    }

    public String getName(){
        return name;
    }

    public String getVersion(){
        return version;
    }

    public String getKernelType(){
        return kernelType;
    }

    public double getBaseScore(){
        return baseScore;
    }
}