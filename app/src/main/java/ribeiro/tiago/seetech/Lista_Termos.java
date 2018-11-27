package ribeiro.tiago.seetech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import ribeiro.tiago.seetech.Classes.Termos;
import ribeiro.tiago.seetech.Classes.TermosListAdapter;

public class Lista_Termos extends AppCompatActivity {

    ListView listTermos;
    public static ArrayList<Termos> termosArrayList;
    Context context;

    public Lista_Termos() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        context = this;

        termosArrayList = new ArrayList<>();
        listTermos = findViewById(R.id.termos_list);

        AddTermos();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent novo = new Intent(context, Novo_Termo.class);
                startActivity(novo);
            }
        });

        TermosListAdapter adapter = new TermosListAdapter(
                getApplicationContext(),
                R.layout.custom_list,
                termosArrayList);
        listTermos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listTermos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Seu codigo aqui
                Intent intent = new Intent(context, Detalhes.class);
                intent.putExtra("NOME_EXTRA", termosArrayList.get(position).getNome());
                intent.putExtra("DESC_EXTRA", termosArrayList.get(position).getDescricao());
                intent.putExtra("IMG_EXTRA", termosArrayList.get(position).getImg());
                intent.putExtra("VID_EXTRA", termosArrayList.get(position).getVideo());
                startActivity(intent);

                //R.raw.hd_libras
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        termosArrayList = new ArrayList<>();
        listTermos = findViewById(R.id.termos_list);

        AddTermos();

        TermosListAdapter adapter = new TermosListAdapter(
                getApplicationContext(),
                R.layout.custom_list,
                termosArrayList);
        listTermos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listTermos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Seu codigo aqui
                Intent intent = new Intent(context, Detalhes.class);
                intent.putExtra("NOME_EXTRA", termosArrayList.get(position).getNome());
                intent.putExtra("DESC_EXTRA", termosArrayList.get(position).getDescricao());
                intent.putExtra("IMG_EXTRA", termosArrayList.get(position).getImg());
                intent.putExtra("VID_EXTRA", termosArrayList.get(position).getVideo());
                startActivity(intent);
            }
        });
    }



    private void AddTermos(){
        Termos hd = new Termos("HD - Hard Disk","Conhecido como 'memória secundária', a parte do computador onde são armazenados os dados.", R.drawable.hd, R.raw.hd_libras);
        Termos motherboard = new Termos("Placa-mãe","A parte do computador responsável por conectar e interligar todos os componentes.", R.drawable.motherboard, R.raw.hd_libras );
        Termos bpmn = new Termos("BPMN - Business Process Model and Notation","Uma notação da metodologia de gerenciamento de processos de negócio e trata-se de uma série de ícones padrões para o desenho de processos, o que facilita o entendimento do usuário..", R.drawable.bpmn, R.raw.hd_libras);

        Termos var;
        SharedPreferences myPrefs = getSharedPreferences("LocalSave", Context.MODE_PRIVATE);

        if(myPrefs.getInt("sizeKey",0) == 4){
            var = new Termos(myPrefs.getString("nomeKey",""), myPrefs.getString("descKey",""), R.drawable.seetech_logo, R.raw.hd_libras);
            termosArrayList.add(var);
        }

//        termosArrayList = new ArrayList<Termos>();
        termosArrayList.add(hd);
        termosArrayList.add(motherboard);
        termosArrayList.add(bpmn);
    }
}
