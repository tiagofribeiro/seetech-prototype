package ribeiro.tiago.seetech;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.VideoView;

public class Detalhes extends AppCompatActivity {
    MediaController mediaController;
    public Detalhes() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        FillDetalhes();

        ScrollView scroll = findViewById(R.id.scrollDetalhes);
        scroll.smoothScrollTo(0,0);
    }


    private void FillDetalhes(){
        String nome_extra = getIntent().getStringExtra("NOME_EXTRA");
        String desc_extra = getIntent().getStringExtra("DESC_EXTRA");
        int img_extra = getIntent().getIntExtra("IMG_EXTRA", 0);
        int vid_extra = getIntent().getIntExtra("VID_EXTRA", 0);

        // ----- //

        TextView toolbar = findViewById(R.id.lblTermo);
        toolbar.setText(nome_extra);

        // ----- //

        TextView descricao = findViewById(R.id.txtDesc);
        descricao.setText(desc_extra);
        descricao.setMovementMethod(new ScrollingMovementMethod());

        // ----- //

        ImageView img = findViewById(R.id.imgTermo);
        img.setImageResource(img_extra);

        // ----- //

        final VideoView videoview = findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + vid_extra);
        videoview.setVideoURI(uri);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaController = new MediaController(Detalhes.this);
                videoview.setMediaController(mediaController);
                /*
                 * and set its position on screen
                 */
                mediaController.setAnchorView(videoview);
            }
        });
    }
}
