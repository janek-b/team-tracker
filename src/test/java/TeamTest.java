import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {

  private Team testTeam;

  @Before
  public void SetUp() {
    testTeam = new Team("team awesome");
  }

  @After
  public void TearDown() {
    testTeam = null;
    assertNull(testTeam);
  }

  @Test
  public void team_instantiatesCorrectly() {
    // Team testTeam = new Team("team awesome");
    assertTrue(testTeam instanceof Team);
  }

  @Test
  public void getName_returnsTeamNameCorrectly_String() {
    assertEquals("team awesome", testTeam.getName());
  }

}
