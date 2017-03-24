# _Team Tracker_

#### _Team Tracker, 03-24-2017_

#### By _**Janek Brandt**_

## Description
_This project is a website for a Startup weekend or hack-a-thon event. It has a page with details about the event and allows the event coordinator to manage the participating teams and their members. The coordinator is able to view a list of all current teams as well as add more teams. They can also view all members of a team and add additional members to the team._


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
| Add a new team | team | team |
| Get the name of a team | teamName | "team awesome" |
| Get the members of a team | teamMembers | "person1", "person2" |
| Add a member to a team | add teamMember "person3" | "person1", "person2", "person3" |
| Get a team members profile | profile "person3" | "person3", "from Portland", "work at google", "java expert", "make cool things" |


## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 **_Janek Brandt_**

This software is licensed under the MIT license.
