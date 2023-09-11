package com.microsv.achievdb2.repository;

import com.microsv.achievdb2.model.Achievement;
import com.microsv.achievdb2.model.Milestone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MilestoneRepository extends JpaRepository<Milestone, Long> {

    @Query(value = "SELECT u FROM Milestone u WHERE u.ach_id = :ach_id", nativeQuery = true)
    List<Milestone> getAllMilestonesByAchievement(@Param("ach_id") long ach_id);
}
