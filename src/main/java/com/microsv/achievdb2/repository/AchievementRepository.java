package com.microsv.achievdb2.repository;

import com.microsv.achievdb2.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Query(value = "Select u FROM Achievement u WHERE u.hab_id = :hab_id", nativeQuery = true)
    List<Achievement> getAllAchievementsByHabit(@Param("hab_id") String hab_id);
}
