package ribeiro.tiago.seetech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Home extends AppCompatActivity implements View.OnClickListener{
    Button btnEntrar;
    SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

        myPrefs = getSharedPreferences("LocalSave", Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        if(v == btnEntrar) {
            SharedPreferences.Editor editor = myPrefs.edit();
            editor.putInt("sizeKey", 3);
            editor.apply();

            Intent dash = new Intent(this, Dashboard.class);
            startActivity(dash);
        }
    }
}
