package com.microsv.achievdb2.repository;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import com.microsv.achievdb2.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    @Query("Select u FROM Milestone WHERE u.ach_id = :ach_id")
    List<Milestone> getAllMilestonesByAchievement(long ach_id);
}
