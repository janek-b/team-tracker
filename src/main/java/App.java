import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    Member member1 = new Member(capitalize("person1"), "portland", "google", "java expert", "make cool things");
    Member member2 = new Member(capitalize("person2"), "denver", "amazon", "python expert", "have fun");
    Member member3 = new Member(capitalize("person3"), "detroit", "netflix", "css expert", "learn something");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
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
      Team newTeam = new Team(capitalize(request.queryParams("name")));
      String[] selectedMembers = request.queryParamsValues("members");
      try {
        for (String member : selectedMembers) {
          newTeam.addTeamMember(Member.getMember(member));
        }
      } catch (NullPointerException e) {
        System.out.println("no members available");
      }
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("team", Team.getTeam(request.params(":teamID")));
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:teamID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team currentTeam = Team.getTeam(request.params(":teamID"));
      String[] selectedMembers = request.queryParamsValues("members");
      try {
        for (String member : selectedMembers) {
          currentTeam.addTeamMember(Member.getMember(member));
        }
      } catch (NullPointerException e) {
        System.out.println("no members available");
      }
      model.put("team", currentTeam);
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("team", Team.getTeam(request.params(":teamID")));
      model.put("members", Member.getAvailableMembers());
      model.put("template", "templates/available-members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:teamID/members/:memberID", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("team", Team.getTeam(request.params(":teamID")));
      model.put("member", Member.getMember(request.params(":memberID")));
      model.put("template", "templates/member.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = capitalize(request.queryParams("name"));
      String from = request.queryParams("from");
      String work = request.queryParams("work");
      String specialities = request.queryParams("specialities");
      String goals = request.queryParams("goal");
      Member newMember = new Member(name, from, work, specialities, goals);
      model.put("template", "templates/member-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static String capitalize(String sentence) {
    String[] words = sentence.split(" ");
    String newSentence = "";
    for (int i = 0; i < words.length; i++) {
      newSentence = newSentence + Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1).toLowerCase() + " ";
    }
    return newSentence.trim();
  }
}
