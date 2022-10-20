package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

public class Edita extends AppCompatActivity implements Serializable {

    EditText autor,nomeLivro;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edita);

        autor = findViewById(R.id.edtAutor);
        nomeLivro = findViewById(R.id.edtNomeLivro);
        button = findViewById(R.id.btnEdt);

        Intent intent = getIntent();
        Livro l = (Livro) intent.getSerializableExtra("user");

        iniciaComponents(l);


    }
    public void enviar(Livro livro){
        Intent intent = new Intent();
        intent.putExtra("userEdit",livro);

        setResult(RESULT_OK,intent);
        finish();
    }
    public void iniciaComponents(Livro l){
        autor.setText(l.getAutor());
        nomeLivro.setText(l.getnomeLivro());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit(l);
            }
        });
    }
    public void edit(Livro l){

        String autorText = autor.getText().toString();
        String nomeText = nomeLivro.getText().toString();
        int id = l.getId();

        Livro livroEdit = new Livro(autorText,nomeText,id);

        enviar(livroEdit);
    }

}