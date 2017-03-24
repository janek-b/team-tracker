import java.util.Map;
import java.util.HashMap;

public class Team {
  private String mName;
  private Map<String, Member> mTeamMembers;
  private static Map<String, Team> instances = new HashMap<String, Team>();

  public Team(String name) {
    mName = name;
    mTeamMembers = new HashMap<String, Member>();
    instances.put(name, this);
  }

  public String getName() {
    return mName;
  }

  public Map<String, Member> getTeamMembers() {
    return mTeamMembers;
  }

  public void addTeamMember(Member newMember) {
    mTeamMembers.put(newMember.getName(), newMember);
  }


  public static Map<String, Team> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Team getTeam(String name) {
    return instances.get(name);
  }

}
