package com.example.carbonfootprintchallenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.carbonfootprintchallenge.dao.GoalDao;
import com.example.carbonfootprintchallenge.entity.Goal;

import java.util.List;

public class WeeklyGoalsFragment extends Fragment {

    private RecyclerView recyclerView;
    private GoalsAdapter goalsAdapter;
    private MyDatabase db = MyDatabase.getDatabase(getContext());
    private GoalDao goalDao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weekly_goals, container, false);

        // RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_goals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        db = Room.databaseBuilder(getActivity(), MyDatabase.class, "db_teste1")
                .allowMainThreadQueries()
                .build();
        goalDao = db.goalDao();

        List<Goal> goals = goalDao.getAllGoals();
        goalsAdapter = new GoalsAdapter(goals);
        recyclerView.setAdapter(goalsAdapter);

        return view;
    }
}
