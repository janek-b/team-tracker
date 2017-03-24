import java.util.Map;
import java.util.HashMap;

public class Member {
  private String mName;
  private String mFrom;
  private String mWork;
  private String mSpecialities;
  private String mGoals;

  private static Map<String, Member> instances = new HashMap<String, Member>();

  public Member(String name, String from, String work, String specialities, String goals) {
    mName = name;
    mFrom = from;
    mWork = work;
    mSpecialities = specialities;
    mGoals = goals;
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


  public static Map<String, Member> all() {
    return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public static Member getMember(String name) {
    return instances.get(name);
  }

}
