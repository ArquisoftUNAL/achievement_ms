# Achievements Microservice

The purpose of this microservice is the management of achievements and milestones associated to them.

The endpoints in the microservice are used to create an achievement, get all the achievements associated to a habit,
create a milestone and get all the milestones associated to an achievement.


### Get all achievements by habit:     
###
#### - Path (paginated)

    GET : /api/achievements/{hab_id}/{page}/{per_page}

#### - Path (non-paginated)

    GET : /api/achievements/{hab_id}

#### - Header

    {
        -
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Achievements found",
        data:   [
                    {
                        id: ach_id,
                        name: ach_name,
                        currentStreak: ach_current_streak,
                        highestStreak: ach_highest_streak,
                        lastCollection: ach_last_collection,
                        habit: hab_id
                    },
                    . . .
                ]
    }

### Create an achievement:
###
#### - Path

    POST : /api/achievements/create-ach

#### - Header

    {
        -
    }

#### - Body

    {
        name: ach_name,
        habId: hab_id
    }

#### - Response

    Succesful 201 CREATED
    {
        message: "Achievement created",
        data:   {
                    id: ach_id,
                    name: ach_name,
                    currentStreak: ach_current_streak,
                    highestStreak: ach_highest_streak,
                    lastCollection: ach_last_collection,
                    habit: hab_id
                }
    }


    Error 400 BAD REQUEST
    {
        message: "Error: could not create achievement",
        data: null
    }

### Delete an achievement:
###
#### - Path

    DEL : /api/achievements/del-ach

#### - Header

    {
        ach_id: ach_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Achievement deleted"
    }


    Error 404 NOT FOUND
    {
        message: "Error: achievement does not exist"
    }

### Update an achievement:
###
#### - Path

    PATCH : /api/achievements/patch-ach

#### - Header

    {
        ach_id: ach_id
    }

#### - Body

    {
        name: ach_name,
        currentStreak: ach_current_streak,
        highestStreak: ach_highest_streak
    }

#### - Response

    Succesful 200 OK
    {
        message: "Achievement updated",
        data:   {
                    id: ach_id,
                    name: ach_name,
                    currentStreak: ach_current_streak,
                    highestStreak: ach_highest_streak,
                    lastCollection: ach_last_collection,
                    habit: hab_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: achievement does not exist",
        data: null
    }

### Retain or restart a streak:
###
#### - Path

    PATCH : /api/achievements/patch-streak/{retain_streak}

#### - Header

    {
        ach_id: ach_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Streak updated",
        data:   {
                    id: ach_id,
                    name: ach_name,
                    currentStreak: ach_current_streak,
                    highestStreak: ach_highest_streak,
                    lastCollection: ach_last_collection,
                    habit: hab_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: achievement does not exist",
        data: null
    }

### Patch a habit's streaks:
###
#### - Path

    PATCH : /api/achievements/patch-streak

#### - Header

    {
        -
    }

#### - Body

    {
        hab_id: hab_id,
        freq_type: freq_type,
        streak: {
                    date_start: date_start,
                    date_end: date_end,
                    data: data
                }
    }

#### - Response

    Succesful 200 OK
    {
        message: "Streaks updated",
        data:   {
                    achievementList: achievement_list,
                    milestoneList: milestone_list
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: achievements not found",
        data: null
    }

### find achievement by id:
###
#### - Path

    GET : /api/achievements/find/ach

#### - Header

    {
        ach_id: ach_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Achievement found",
        data:   {
                    id: ach_id,
                    name: ach_name,
                    currentStreak: ach_current_streak,
                    highestStreak: ach_highest_streak,
                    lastCollection: ach_last_collection,
                    habit: hab_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: Achievement does not exist"
    }

### Get all milestones by achievement:
###
#### - Path (paginated)

    GET : /api/milestones/{ach_id}/{page}/{per_page}

#### - Path (non-paginated)

    GET : /api/milestones/{ach_id}

#### - Header

    {
        -
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Milestones found",
        data:   [
                    {
                        id: ach_id,
                        streak: mil_streak,
                        date: mil_date,
                        achievement: ach_id
                    },
                    . . .
                ]
    }

### Create a milestone:
###
#### - Path

    POST : /api/milestones/create-mil

#### - Header

    {
        -
    }

#### - Body

    {
        streak: mil_streak,
        achId: ach_id,
        date: mil_date
    }

#### - Response

    Succesful 201 CREATED
    {
        message: "Milestone created",
        data:   {
                    id: ach_id,
                    streak: mil_streak,
                    date: mil_date,
                    achievement: ach_id
                }
    }


    Error 400 BAD REQUEST
    {
        message: "Error: could not create milestone",
        data: null
    }


    Error 404 NOT FOUND
    {
        message: "Error: achievement not found",
        data: null
    }

### Delete a milestone:
###
#### - Path

    DEL : /api/milestones/del-mil

#### - Header

    {
        mil_id: mil_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Milestone deleted"
    }


    Error 404 NOT FOUND
    {
        message: "Error: milestone does not exist"
    }

### Update a milestone:
###
#### - Path

    PATCH : /api/milestones/patch-mil

#### - Header

    {
        mil_id: mil_id
    }

#### - Body

    {
        streak: mil_streak,
        achId: ach_id,
        date: mil_date
    }

#### - Response

    Succesful 200 OK
    {
        message: "Milestone updated",
        data:   {
                    id: ach_id,
                    streak: mil_streak,
                    date: mil_date,
                    achievement: ach_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: milestone does not exist",
        data: null
    }

### find milestone by id:
###
#### - Path

    GET : /api/milestones/find/mil

#### - Header

    {
        mil_id: mil_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Milestone found",
        data:   {
                    id: ach_id,
                    streak: mil_streak,
                    date: mil_date,
                    achievement: ach_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: Milestone does not exist"
    }

### find achievement by milestone id:
###
#### - Path

    GET : /api/milestones/find-by-mil/ach

#### - Header

    {
        mil_id: mil_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Achievement found",
        data:   {
                    id: ach_id,
                    name: ach_name,
                    currentStreak: ach_current_streak,
                    highestStreak: ach_highest_streak,
                    lastCollection: ach_last_collection,
                    habit: hab_id
                }
    }


    Error 404 NOT FOUND
    {
        message: "Error: Milestone does not exist"
    }


    Error 500 INTERNAL SERVER ERROR
    {
        message: "Error: Milestone found but achievement does not exist"
    }

### find habit by milestone id:
###
#### - Path

    GET : /api/milestones/find-by-mil/hab-id

#### - Header

    {
        mil_id: mil_id
    }

#### - Body

    {
        -
    }

#### - Response

    Succesful 200 OK
    {
        message: "Habit found",
        data: hab_id
    }


    Error 404 NOT FOUND
    {
        message: "Error: Milestone does not exist"
    }


    Error 500 INTERNAL SERVER ERROR
    {
        message: "Error: Milestone found but achievement does not exist"
    }

    {
        message: "Error: Achievement found but no habit associated found"
    }