package com.example.carbonfootprintchallenge.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_goal_progress",
        foreignKeys = {
                @ForeignKey(entity = User.class,
                        parentColumns = "user_id",
                        childColumns = "user_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(entity = Goal.class,
                        parentColumns = "goal_id",
                        childColumns = "goal_id",
                        onDelete = ForeignKey.CASCADE)
        })
public class UserGoalProgress {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @NonNull
    @ColumnInfo(name = "user_id")
    private Long userId;

    @NonNull
    @ColumnInfo(name = "goal_id")
    private Long goalId;

    @NonNull
    @ColumnInfo(name = "goal_progress")
    private int goalProgress;

    public UserGoalProgress() {
    }

    public UserGoalProgress(@NonNull Long userId, @NonNull Long goalId, @NonNull int goalProgress) {
        this.userId = userId;
        this.goalId = goalId;
        this.goalProgress = goalProgress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    @NonNull
    public Long getGoalId() {
        return goalId;
    }

    public void setGoalId(@NonNull Long goalId) {
        this.goalId = goalId;
    }

    @NonNull
    public int getGoalProgress() {
        return goalProgress;
    }

    public void setGoalProgress(@NonNull int goalProgress) {
        this.goalProgress = goalProgress;
    }
}
