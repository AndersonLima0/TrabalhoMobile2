package com.example.trabalho2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Livro> livros;
    ListView listLivros;
    ArrayAdapter adapter;

    String autorText, nomeLivroText;
    EditText autor, nomeLivro,id;

    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        livros = new ArrayList<>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,livros);

        listLivros = findViewById(R.id.listView);
        listLivros.setAdapter(adapter);

        autor = findViewById(R.id.autor);
        nomeLivro = findViewById(R.id.nomeLivro);

        id = findViewById(R.id.id);

        imageButton = findViewById(R.id.btnEdit);

        //edita
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idText = Integer.parseInt(id.getText().toString());

                Intent intent = new Intent(MainActivity.this, Edita.class);
                for(int i = 0; i < livros.size();i++){
                    if(idText == livros.get(i).getId()){
                        intent.putExtra("user",livros.get(idText));
                        startActivityForResult(intent,101);
                        break;

                    }else{
                        Toast.makeText(MainActivity.this,"ID inválido",Toast.LENGTH_LONG).show();
                    }
                }


            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){
            if(resultCode == MainActivity.RESULT_OK){
                Livro l = (Livro)data.getSerializableExtra("userEdit");
                livros.get(l.getId()).setAutor(l.getAutor());
                livros.get(l.getId()).setnomeLivro(l.getnomeLivro());

                adapter.notifyDataSetChanged();
            }
        }
    }

    //adicionajj
    public void AdicionaLivro(View v){
        autorText = autor.getText().toString();
        nomeLivroText = nomeLivro.getText().toString();
        int id = livros.size();

        Livro l = new Livro(autorText,nomeLivroText,id);

        livros.add(l);
        autor.setText("");
        nomeLivro.setText("");
    }


}