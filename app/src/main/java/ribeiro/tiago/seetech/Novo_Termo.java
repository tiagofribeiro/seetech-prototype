package ribeiro.tiago.seetech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Novo_Termo extends AppCompatActivity implements View.OnClickListener{
    Button btnSalvar;
    EditText txtNome, txtDesc;

    SharedPreferences myPrefs;
    public Novo_Termo() { }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo);

        txtNome = findViewById(R.id.txtNome);
        txtDesc = findViewById(R.id.txtDesc);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnSalvar) {
            if (txtNome.getText().toString().matches("")) {
                Toast.makeText(this, "Insira um nome para o termo!", Toast.LENGTH_SHORT).show();
                return;
            } else if (txtDesc.getText().toString().matches("")) {
                Toast.makeText(this, "Insira uma descrição para o termo!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
                myPrefs = getSharedPreferences("LocalSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.putInt("sizeKey", 4);
                editor.putString("nomeKey", txtNome.getText().toString());
                editor.putString("descKey", txtDesc.getText().toString());
                editor.apply();

                this.finish();
            }
        }
    }

}
