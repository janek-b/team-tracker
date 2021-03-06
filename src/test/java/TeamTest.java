import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {
  private Team testTeam;

  @Before
  public void setUp() {
    testTeam = new Team("team awesome");
  }

  @After
  public void tearDown() {
    testTeam = null;
    assertNull(testTeam);
    Team.clear();
  }

  @Test
  public void team_instantiatesCorrectly() {
    assertTrue(testTeam instanceof Team);
  }

  @Test
  public void getName_returnsTeamNameCorrectly_String() {
    assertEquals("team awesome", testTeam.getName());
  }

  @Test
  public void all_instanceIsIncludedInMap() {
    assertTrue(Team.all().containsValue(testTeam));
  }

  @Test
  public void clear_resetsInstancesCorrectly() {
    assertEquals(1, Team.all().size());
    Team.clear();
    assertEquals(0, Team.all().size());
  }

  @Test
  public void getTeam_returnsCorrectTeam() {
    assertEquals(testTeam, Team.getTeam("team awesome"));
  }

  @Test
  public void getTeamMembers_returnsEmptyHashMap() {
    assertEquals(0, testTeam.getTeamMembers().size());
  }

  @Test
  public void addTeamMember_memberAddedToMemberMap() {
    Member testMember = new Member("person1", "portland", "google", "java expert", "make cool things");
    testTeam.addTeamMember(testMember);
    assertTrue(testTeam.getTeamMembers().containsValue(testMember));
  }

}
