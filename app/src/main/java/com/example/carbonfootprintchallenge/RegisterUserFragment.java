package com.example.carbonfootprintchallenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.carbonfootprintchallenge.dao.UserDao;
import com.example.carbonfootprintchallenge.entity.User;

public class RegisterUserFragment extends Fragment {
    private MyDatabase db;
    private UserDao userDao;
    private TextView login_link;
    private EditText nomeEditText;
    private EditText emailEditText;
    private EditText senhaEditText;
    private Button cadastrarButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_user, container, false);

        db = Room.databaseBuilder(getContext(), MyDatabase.class, "db_teste1")
                .allowMainThreadQueries()
                .build();
        userDao = db.userDao();

        login_link = view.findViewById(R.id.login_link);
        nomeEditText = view.findViewById(R.id.nome_edit_text);
        emailEditText = view.findViewById(R.id.email_edit_text);
        senhaEditText = view.findViewById(R.id.senha_edit_text);
        cadastrarButton = view.findViewById(R.id.cadastrar_button);

        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = nomeEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                    Toast.makeText(getContext(), "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = new User(nome, email, senha);
                long userId = userDao.insertUser(user);

                if (userId != -1) {
                    Toast.makeText(getContext(), "Usuário criado", Toast.LENGTH_SHORT).show();
                    nomeEditText.setText("");
                    emailEditText.setText("");
                    senhaEditText.setText("");
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, new LoginFragment())
                            .commit();
                } else {
                    Toast.makeText(getContext(), "Erro ao criar usuário", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new LoginFragment())
                        .commit();
            }
        });

        return view;
    }
}