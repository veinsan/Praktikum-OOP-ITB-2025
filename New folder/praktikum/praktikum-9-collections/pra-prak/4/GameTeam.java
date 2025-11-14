import java.util.*;

public class GameTeam implements Team {
    private String teamName;
    
    // TODO: Gunakan List untuk menyimpan urutan anggota team
    private List<TeamMember> members;
    
    // TODO: Gunakan Map untuk quick lookup member berdasarkan nama
    private Map<String, TeamMember> memberMap;
    
    public GameTeam(String teamName) {
        this.teamName = teamName;
        this.members = new ArrayList<>();
        this.memberMap = new HashMap<>();
    }
    
    // TODO: Implement addMember
    // Tambahkan member ke List dan Map
    // Tambahkan role "Player" ke Set
    public void addMember(TeamMember member){
        members.add(member);
        memberMap.put(member.getName(), member);
    }
    
    // TODO: Implement removeMember
    // Cari dan hapus member dari List menggunakan iterator
    // Hapus dari Map juga
    public void removeMember(String memberName){
        TeamMember memberToRemove = null;
        for (TeamMember member : members){
            if (memberName.equals(member.getName())){
                memberToRemove = member;
                break;
            }
        }
        if (memberToRemove != null){
            members.remove(memberToRemove);
        }
        memberMap.remove(memberName);
    }
    
    // TODO: Implement findMember
    // Gunakan Map untuk quick lookup
    public TeamMember findMember(String memberName){
        return memberMap.get(memberName);
    }
    
    // TODO: Buat method getAllMembers() return List<TeamMember>
    public List<TeamMember> getAllMembers(){
        return members;
    }
    
    // TODO: Buat method getTeamSize() return int
    public int getTeamSize(){
        return members.size();
    }
    
    // TODO: Buat method getTopSkillPlayer() return TeamMember
    // Loop melalui List dan cari player dengan skill tertinggi
    public TeamMember getTopSkillPlayer(){
        int max = 0;
        TeamMember topSkillPlayer = null;
        for (TeamMember tm : members){
            if (tm.getSkillLevel() > max){
                topSkillPlayer = tm;
                max = tm.getSkillLevel();
            }
        }
        return topSkillPlayer;
    }
    
    // TODO: Buat method getPlayersBySkillLevel(int minSkill) return List<TeamMember>
    // Filter players yang skill-nya >= minSkill
    public List<TeamMember> getPlayersBySkillLevel(int minSkill){
        List<TeamMember> players = new ArrayList<>();
        for (TeamMember tm : members){
            if (tm.getSkillLevel() >= minSkill){
                players.add(tm);
            }
        }
        return players;
    }
    // TODO: Buat method getTeamName() return String
    public String getTeamName(){
        return teamName;
    }
}