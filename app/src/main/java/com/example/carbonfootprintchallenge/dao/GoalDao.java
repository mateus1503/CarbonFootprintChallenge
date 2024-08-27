package com.example.carbonfootprintchallenge.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.carbonfootprintchallenge.entity.Goal;

import java.util.List;

@Dao
public interface GoalDao {
    @Insert
    void insertGoal(Goal goal);

    @Query("SELECT * FROM goals")
    List<Goal> getAllGoals();
}
