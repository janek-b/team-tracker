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
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}


// /                                 index              -- list of all teams
// /teams                            index              -- list of all teams
// /teams/new                        teams-form         -- form to add a team
// /teams/:teamid                    team               -- details for individual team
// /teams/:teamid/members/new        available-members  -- form to add a member to a team
// /teams/:teamid/members/:memberid  member             -- profile page for a team member
// /members/new                      member-form        -- form to sign up a member to the event
