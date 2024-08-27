package com.example.carbonfootprintchallenge.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "goals")
public class Goal {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "goal_id")
    private Long goalId;

    @NonNull
    @ColumnInfo(name = "goal_name")
    private String goalName;

    public Goal() {
    }

    public Goal(@NonNull String goalName) {
        this.goalName = goalName;
    }

    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    @NonNull
    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(@NonNull String goalName) {
        this.goalName = goalName;
    }
}
