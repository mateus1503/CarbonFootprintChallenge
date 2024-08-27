package com.example.carbonfootprintchallenge;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.carbonfootprintchallenge.dao.GoalDao;
import com.example.carbonfootprintchallenge.dao.UserDao;
import com.example.carbonfootprintchallenge.dao.UserGoalProgressDao;
import com.example.carbonfootprintchallenge.entity.Goal;
import com.example.carbonfootprintchallenge.entity.User;
import com.example.carbonfootprintchallenge.entity.UserGoalProgress;

@Database(entities = {User.class, UserGoalProgress.class, Goal.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    abstract UserDao userDao();
    abstract UserGoalProgressDao userGoalProgressDao();
    abstract GoalDao goalDao();

    private static volatile MyDatabase INSTANCE;

    public static MyDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyDatabase.class, "db_teste1")
                            .addCallback(roomDatabaseCallback) // Adiciona o callback
                            .allowMainThreadQueries() // Para simplificação, permite operações em MainThread (não recomendado em produção)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // Inserir as metas pré-definidas ao criar o banco de dados
            new Thread(() -> {
                GoalDao goalDao = INSTANCE.goalDao();
                goalDao.insertGoal(new Goal("Usar transporte público"));
                goalDao.insertGoal(new Goal("Separar e reciclar todo o lixo reciclável"));
                goalDao.insertGoal(new Goal("Plantar uma árvore ou cuidar"));
                goalDao.insertGoal(new Goal("Usar sacolas reutilizáveis"));
                goalDao.insertGoal(new Goal("Uso de bicicleta"));
            }).start();
        }
    };
}
