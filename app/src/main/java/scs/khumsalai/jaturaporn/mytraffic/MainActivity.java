package scs.khumsalai.jaturaporn.mytraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.sheep);
                mediaPlayer.start();

                // ทำ Webview
                Intent intent = new Intent(Intent.ACTION_VIEW); // ACTION ตัวใหญ่
                intent.setData(Uri.parse("https://youtu.be/ux8-n8yyoW0"));
                startActivity(intent);


            }   // OnClick
        });

        // Create ListView
        //1. การ Setter Array แบบ Simple  แต่ใช้ได้แค่ใน Class นี้เท่านั้น
        final int[] iconInts = new int[20];
        // ใช้ Ctrl+Alt+L เพื่อจัดเรียงข้อความให้ดูง่ายขึ้น
        iconInts[0] = R.drawable.traffic_01;
        iconInts[1] = R.drawable.traffic_02;
        iconInts[2] = R.drawable.traffic_03;
        iconInts[3] = R.drawable.traffic_04;
        iconInts[4] = R.drawable.traffic_05;
        iconInts[5] = R.drawable.traffic_06;
        iconInts[6] = R.drawable.traffic_07;
        iconInts[7] = R.drawable.traffic_08;
        iconInts[8] = R.drawable.traffic_09;
        iconInts[9] = R.drawable.traffic_10;
        iconInts[10] = R.drawable.traffic_11;
        iconInts[11] = R.drawable.traffic_12;
        iconInts[12] = R.drawable.traffic_13;
        iconInts[13] = R.drawable.traffic_14;
        iconInts[14] = R.drawable.traffic_15;
        iconInts[15] = R.drawable.traffic_16;
        iconInts[16] = R.drawable.traffic_17;
        iconInts[17] = R.drawable.traffic_18;
        iconInts[18] = R.drawable.traffic_19;
        iconInts[19] = R.drawable.traffic_20;

        // 2 Call Value From xml   ได้เฉพาะ String เท่านั้น
        final String[] nameStrings = getResources().getStringArray(R.array.name); // ดึงจาก my_data ใน Values


        // 3 Call From Java     // ใช้ดึงได้ทุก Dayatype เลย
        MyData myData = new MyData();   // Create object or instance เพื่อทำการสืบทอดมาทำงาน
        String[] detaStrings = myData.getDetailStrings();

        // Inherriate to MyAdapter
        MyAdaper myAdaper = new MyAdaper(this,iconInts,nameStrings,detaStrings);
        trafficListView.setAdapter(myAdaper);

        // Intent to Detail When Click
        trafficListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetailActivity.class); // เคลื่อนย้ายข้อมูลจาก MainActivity.this ไปที่ DetailActivity.class

                //PutExtra
                intent.putExtra("Name", nameStrings[position]);
                intent.putExtra("Icon", iconInts[position]);
                intent.putExtra("Index", position);
                startActivity(intent);

            }   // onItemClick
        });





    }   // End of Main Method

}   // End of Main Class
