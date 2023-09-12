# Achievements Microservice

The purpose of this microservice is the management of achievements and milestones associated to them.

The endpoints in the microservice are used to create an achievement, get all the achievements associated to a habit,
create a milestone and get all the milestones associated to an achievement.

## Paths

#### Create an achievement:          
GET
/api/achievements/{hab_id}

#### Get all achievements by habit:  
POST
/api/achievements/create-ach

#### Create a milestone:
GET
/api/milestones/{ach_id}

#### Get all milestones by achievement:
POST
/api/milestones/create-mil


## Body

#### Get all achievements by habit:  


    {
        name: achievement-name
        habId: habit-id
    }

#### Get all milestones by achievement:


    {
        num: streak-number
        achId: achievement-id
    }