import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("members", Member.getAvailableMembers());
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team newTeam = new Team(request.queryParams("name"));
      String[] selectedMembers = request.queryParamsValues("members");
      try {
        for (String member : selectedMembers) {
          newTeam.addTeamMember(Member.getMember(member));
        }
      } catch (NullPointerException e) {
        System.out.println("no memers availale");
      }
      model.put("teams", Team.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}


// /                                 index              -- list of all teams
// /teams                            index              -- list of all teams
// /teams/new                        team-form         -- form to add a team
// /teams/:teamid                    team               -- details for individual team
// /teams/:teamid/members/new        available-members  -- form to add a member to a team
// /teams/:teamid/members/:memberid  member             -- profile page for a team member
// /members/new                      member-form        -- form to sign up a member to the event

// index
//   list of teams
//   link to member-form
//   link to team-form
// team
//   link to teams
//   link to available-members
//   link to member
// member
//   link to team
