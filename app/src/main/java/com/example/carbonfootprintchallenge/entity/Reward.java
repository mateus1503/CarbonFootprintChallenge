package com.example.carbonfootprintchallenge.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "rewards")
public class Reward {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "reward_id")
    private Long rewardId;

    @NonNull
    @ColumnInfo(name = "reward_name")
    private String rewardName;

    @NonNull
    @ColumnInfo(name = "reward_description")
    private String rewardDescription;

    @NonNull
    @ColumnInfo(name = "reward_progress")
    private int rewardProgress;

    @NonNull
    @ColumnInfo(name = "user_id")
    private Long userId;

    public Reward() {
    }

    public Reward(@NonNull String rewardName, @NonNull String rewardDescription, @NonNull int rewardProgress, @NonNull Long userId) {
        this.rewardName = rewardName;
        this.rewardDescription = rewardDescription;
        this.rewardProgress = rewardProgress;
        this.userId = userId;
    }

    public Long getRewardId() {
        return rewardId;
    }

    public void setRewardId(Long rewardId) {
        this.rewardId = rewardId;
    }

    @NonNull
    public String getRewardName() {
        return rewardName;
    }

    public void setRewardName(@NonNull String rewardName) {
        this.rewardName = rewardName;
    }

    @NonNull
    public String getRewardDescription() {
        return rewardDescription;
    }

    public void setRewardDescription(@NonNull String rewardDescription) {
        this.rewardDescription = rewardDescription;
    }

    @NonNull
    public int getRewardProgress() {
        return rewardProgress;
    }

    public void setRewardProgress(@NonNull int rewardProgress) {
        this.rewardProgress = rewardProgress;
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }
}
