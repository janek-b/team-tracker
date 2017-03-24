import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {
  private Member testMember;

  @Before
  public void setUp() {
    testMember = new Member("person1", "portland", "google", "java expert", "make cool things");
  }

  @After
  public void tearDown() {
    testMember = null;
    assertNull(testMember);
  }

  @Test
  public void member_instantiatesCorrectly() {
    assertTrue(testMember instanceof Member);
  }

  @Test
  public void getName_returnsMemberNameCorrectly_String() {
    assertEquals("person1", testMember.getName());
  }

  @Test
  public void getFrom_returnsWhereTheMemberIsFrom_String() {
    assertEquals("portland", testMember.getFrom());
  }

  @Test
  public void getWork_returnsWhereTheMemberWorks_String() {
    assertEquals("google", testMember.getWork());
  }

  @Test
  public void getSpecialities_returnsTheMembersCodingSpecialities_String() {
    assertEquals("java expert", testMember.getSpecialities());
  }

  @Test
  public void getGoals_returnsTheMembersGoalsForTheEvent_String() {
    assertEquals("make cool things", testMember.getGoals());
  }

  @Test
  public void all_includesTestMemberInstance() {
    assertTrue(Member.all().containsValue(testMember));
  }

  @Test
  public void clear_resetsInstancesCorrectly() {
    assertEquals(1, Member.all().size());
    Member.clear();
    assertEquals(0, Member.all().size());
  }

  @Test
  public void getMember_returnsCorrectMember() {
    assertEquals(testMember, Member.getMember("person1"));
  }

}
