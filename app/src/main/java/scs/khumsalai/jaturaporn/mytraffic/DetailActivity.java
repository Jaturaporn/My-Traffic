package scs.khumsalai.jaturaporn.mytraffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    // Explicit
   TextView nameTextView, detTextView; // การประกาศตัวแปรอย่างย่อ จะเป็น Private อัตโนมัติ
    private ImageView imageView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Bind Widget
        nameTextView = (TextView) findViewById(R.id.textView4);
        detTextView = (TextView) findViewById(R.id.textView5);
        imageView = (ImageView) findViewById(R.id.imageView2);

        //การ Get Value From Intent
        // ประกาศตัวแปรเป็น String ชื่อ strName
        String strName = getIntent().getStringExtra("Name");// ตัวแปร(สีเขียว)ที่ส่งและรับ ต้องชื่อเดียวกัน

        // ประกาศตัวแปรเป็น Integer ชื่อ intIcon รับค่า Icon จากหน้า MainActivity.java ใน Method ชื่อ public void onItemClick
        int intIcon = getIntent().getIntExtra("Icon", R.drawable.traffic_01);// ตัวแปร(สีเขียว)ที่ส่งและรับ ต้องชื่อเดียวกัน

        // ประกาศตัวแปรเป็น Integer ชื่อ Index รับค่า intIndex จากหน้า MainActivity.java ใน Method ชื่อ public void onItemClick
        int intIndex = getIntent().getIntExtra("Index", 0);

        // Check Log
        Log.d("Traffic", "strName ==>" + strName);
        Log.d("Traffic", "intIcon ==>" + intIcon);
        Log.d("Traffic", "intIndex ==>" + intIndex);


        // Show View
        nameTextView.setText(strName);
        imageView.setImageResource(intIcon);

        String[] detailStrings = getResources().getStringArray(R.array.long_data);
        detTextView.setText(detailStrings[intIndex]);

    }   // Main Method





    // ประกาศค่าแบบ ไมต้องส่งค่ากลับ
    public void clickBack(View view) {
        finish();
    }

}   // End of Main Class
