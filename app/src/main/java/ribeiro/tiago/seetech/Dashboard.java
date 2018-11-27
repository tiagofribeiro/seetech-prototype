package ribeiro.tiago.seetech;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import ribeiro.tiago.seetech.Classes.Termos;

public class Dashboard extends AppCompatActivity implements View.OnClickListener{

    Button btnLista;
    public Dashboard() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnLista = findViewById(R.id.btnLista);
        btnLista.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == btnLista){
            Termos teste = new Termos("Teste - Teste","Conhecido como 'teste', a parte do computador onde são armazenados os testes.", R.drawable.seetech_logo, R.raw.hd_libras);

            Intent dash = new Intent(this, Lista_Termos.class);
            startActivity(dash);
        }
    }

}
