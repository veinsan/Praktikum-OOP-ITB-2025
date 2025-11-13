import java.util.*;

public class Tournament {
    private String tournamentName;
    
    // TODO: Gunakan List untuk urutan tim
    private List<GameTeam> teams;
    
    // TODO: Gunakan Map untuk quick lookup tim berdasarkan nama
    private Map<String, GameTeam> teamMap;
    
    // TODO: Gunakan Set untuk track nama-nama tim yang sudah 
    private Set<GameTeam> playedTeams;
    
    public Tournament(String tournamentName) {
        this.tournamentName = tournamentName;
        this.teams = new ArrayList<>();
        this.teamMap = new HashMap<>();
        this.playedTeams = new HashSet<>();
    }
    
    // TODO: Buat method registerTeam(GameTeam team)
    // Tambahkan team ke List dan Map
    public void registerTeam(GameTeam team){
        teams.add(team);
        teamMap.put(team.getTeamName(), team);
    }
    // TODO: Buat method getTeam(String teamName) return GameTeam
    // Gunakan Map untuk lookup
    public GameTeam getTeam(String teamName){
        return teamMap.get(teamName);
    }
    
    // TODO: Buat method recordMatch(String team1Name, String team2Name)
    // Tambahkan kedua tim ke playedTeams Set
    public void recordMatch(String team1Name, String team2Name){
        GameTeam team1 = teamMap.get(team1Name);
        playedTeams.add(team1);
        GameTeam team2 = teamMap.get(team2Name);
        playedTeams.add(team2);
    }
    
    // TODO: Buat method getTotalTeams() return int
    public int getTotalTeams(){
        return teams.size();
    }
    
    // TODO: Buat method getTeamsNotPlayed() return List<String>
    // Return team yang belum bertanding (tidak ada di Set playedTeams)
    public List<String> getTeamsNotPlayed(){
        List<String> result = new ArrayList<>();
        for (GameTeam gt : teams){
            if (!playedTeams.contains(gt)){
                result.add(gt.getTeamName());
            }
        }
        return result;
    }
    
    // TODO: Buat method getAllTeams() return List<GameTeam>
    public List<GameTeam> getAllTeams(){
        return teams;
    }

    public String getTournamentName(){
        return tournamentName;
    }
}