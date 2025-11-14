public class Linux extends OperatingSystem{
    public enum Distro { UBUNTU, FEDORA, ARCH, DEBIAN};

    private Distro distroType;

    public Linux (String name, String version, String kernelType, double baseScore, Distro distroType){
        super(name, version, kernelType, baseScore);
        this.distroType = (distroType == null) ? Distro.UBUNTU : distroType;
    }

    public Distro getDistroType(){
        return distroType;
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 0.0;
        switch (usage) {
            case SERVER:
                multiplier = 0.20;
                break;
            case DEVELOPMENT:
                multiplier = 0.10;
                break;
            case GAMING:
                multiplier = -0.15;
                break;
        }
        double score = getBaseScore() + multiplier * getBaseScore();
        return clampScore(score);
    }

    @Override
    protected String getAdditionalInfo(){
        return "Distribution: " + distroType.name();
    }
}