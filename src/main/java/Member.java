import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Member {
  private String mName;
  private String mFrom;
  private String mWork;
  private String mSpecialities;
  private String mGoals;
  private boolean mOnTeam;

  private static Map<String, Member> instances = new HashMap<String, Member>();

  public Member(String name, String from, String work, String specialities, String goals) {
    mName = name;
    mFrom = from;
    mWork = work;
    mSpecialities = specialities;
    mGoals = goals;
    mOnTeam = false;
    instances.put(name, this);
  }

  public String getName() {
    return mName;
  }

  public String getFrom() {
    return mFrom;
  }

  public String getWork() {
    return mWork;
  }

  public String getSpecialities() {
    return mSpecialities;
  }

  public String getGoals() {
    return mGoals;
  }

  public void recruitMember() {
    mOnTeam = true;
  }


  public static Map<String, Member> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Member getMember(String name) {
    return instances.get(name);
  }

  public static List<Member> getAvailableMembers() {
    List<Member> availableMembers = new ArrayList<Member>();
    for (String name : instances.keySet()) {
      if (!(instances.get(name).mOnTeam)) {
        availableMembers.add(instances.get(name));
      }
    }
    return availableMembers;
  }

}
