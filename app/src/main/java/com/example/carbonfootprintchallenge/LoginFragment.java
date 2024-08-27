package com.example.carbonfootprintchallenge;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carbonfootprintchallenge.dao.UserDao;
import com.example.carbonfootprintchallenge.entity.User;

public class LoginFragment extends Fragment {
    private MyDatabase db;
    private UserDao userDao;
    private EditText emailEditText;
    private EditText senhaEditText;
    private Button login_button;
    private TextView registerLink;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        db = Room.databaseBuilder(getActivity(), MyDatabase.class, "db_teste1")
                .allowMainThreadQueries()
                .build();
        userDao = db.userDao();

        emailEditText = view.findViewById(R.id.email_edit_text);
        senhaEditText = view.findViewById(R.id.senha_edit_text);
        login_button = view.findViewById(R.id.login_button);
        registerLink = view.findViewById(R.id.register_link);

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new RegisterUserFragment())
                        .commit();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                User user = userDao.findUserByCredentials(email, senha);

                if (user != null) {
                    // Login bem-sucedido, redirecionar para a próxima tela
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", user);

                    ViewFragment viewFragment = new ViewFragment();
                    viewFragment.setArguments(bundle);

                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, viewFragment)
                            .commit();
                    Toast.makeText(getActivity(), "Logado com sucesso, " + user.getUserName(), Toast.LENGTH_SHORT).show();
                } else {
                    // Login falhou, mostrar mensagem de erro
                    Toast.makeText(getActivity(), "Credenciais inválidas", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}