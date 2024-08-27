package com.example.carbonfootprintchallenge.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.carbonfootprintchallenge.entity.UserGoalProgress;

import java.util.List;

@Dao
public interface UserGoalProgressDao {
//    @Query("SELECT * FROM user_goal_progress WHERE user_id = :userId")
//    List<UserGoalProgress> getGoalsForUser(Long userId);

    @Insert
    void insertUserGoalProgress(UserGoalProgress userGoalProgress);

//    @Update
//    void updateUserGoalProgress(UserGoalProgress userGoalProgress);
}
