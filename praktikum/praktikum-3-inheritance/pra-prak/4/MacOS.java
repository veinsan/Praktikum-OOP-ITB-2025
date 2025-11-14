public class MacOS extends OperatingSystem{
    private boolean MSeriesChip;

    public MacOS(String name, String version, String kernelType, double baseScore, boolean MSeriesChip){
        super (name, version, kernelType, baseScore);
        this.MSeriesChip = MSeriesChip;
    }

    public boolean hasMSeriesChip(){
        return MSeriesChip;
    }

    @Override
    public double calculateCompatibility(UsageType usage){
        double multiplier = 0.0;
        switch (usage) {
            case DEVELOPMENT:
                multiplier += 0.25;
                break;
            case GAMING:
                multiplier -= 0.2;
                break;
        }
        if (hasMSeriesChip()){
            multiplier += 0.1;
        }
        double score = getBaseScore() + multiplier * getBaseScore();
        return clampScore(score);
    }

    @Override
    public String getAdditionalInfo(){
        return "Has M-Series Chip: " + (MSeriesChip ? "Yes" : "No");
    }
}