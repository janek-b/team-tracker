import java.util.Map;
import java.util.HashMap;

public class Team {
  private String mName;

  private static Map<String, Team> instances = new HashMap<String, Team>();

  public Team(String name) {
    mName = name;

    instances.put(name, this);
  }

  public String getName() {
    return mName;
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
