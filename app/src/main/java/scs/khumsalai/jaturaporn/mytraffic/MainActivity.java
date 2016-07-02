package scs.khumsalai.jaturaporn.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {



    // Explicit  การประกาศตัวแปร เพื่อให้ Android รู้ว่าจะต้องใช้ทรัพยากรเท่าไหร่
    private ListView trafficListView;
    private Button aboutmeButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BInd Widget เป็นการผูกความสัมพันธ์ระหว่าง Object
        trafficListView = (ListView) findViewById(R.id.listView);

        //aboutmeButton = (Button) findViewById(R.id.button);
        aboutmeButton = (Button) findViewById(R.id.button);

                // controller for Button
                // ดึง Class สำเร็จรูปมาใช้เลย ง่ายดี
                aboutmeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Sound Effect
                        MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),R.raw.sheep);
                        mediaPlayer.start();

                        // ทำ Webview
                        Intent intent = new Intent(Intent.ACTION_VIEW); // ACTION ตัวใหญ่
                        intent.setData(Uri.parse("https://youtu.be/ux8-n8yyoW0"));
                        startActivity(intent);


                    }   // OnClick
                });



    }   // End of Main Method

}   // End of Main Class
