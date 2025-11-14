public class Windows extends OperatingSystem {
    public enum Edition { HOME, PRO, SERVER };

    private Edition edition;
    
    public Windows (String name, String version, String kernelType, double baseScore, Edition edition){
        super(name, version, kernelType, baseScore);
        this.edition = (edition == null) ? Edition.HOME : edition;
    }

    public Edition getEdition(){
        return edition;
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 0.0;
        switch (usage) {
            case SERVER:
                if (edition == Edition.SERVER) {
                    multiplier = 0.30;
                } else if (edition == Edition.HOME) {
                    multiplier = -0.05;
                }
                break;
            case GAMING:
                multiplier = 0.20;
                break;
            default:
                break;
        }
        double score = getBaseScore() + multiplier * getBaseScore();
        return clampScore(score);
    }   

    @Override
    public String getAdditionalInfo(){
        return "Edition: " + edition.name();
    }
}