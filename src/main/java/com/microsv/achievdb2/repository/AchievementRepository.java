package com.microsv.achievdb2.repository;

import com.microsv.achievdb2.model.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<Achievement, String> {

    @Query(value = "Select * FROM Achievement u WHERE u.hab_id = :hab_id ORDER BY ach_id OFFSET :off_set ROWS FETCH NEXT :per_page ROWS ONLY", nativeQuery = true)
    List<Achievement> getAllAchievementsByHabit(@Param(value = "hab_id") String hab_id, @Param(value = "off_set") int off_set, @Param(value = "per_page") int per_page);
}
