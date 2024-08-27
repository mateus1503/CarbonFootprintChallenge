package com.example.carbonfootprintchallenge.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.carbonfootprintchallenge.entity.User;

@Dao
public interface UserDao {
    @Insert
    Long insertUser(User user);

    @Query("SELECT * FROM users WHERE user_email = :email AND user_password = :senha")
    User findUserByCredentials(String email, String senha);
}
