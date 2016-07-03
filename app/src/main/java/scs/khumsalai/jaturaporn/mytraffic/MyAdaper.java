package scs.khumsalai.jaturaporn.mytraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nicotinman on 7/3/2016.
 */
public class MyAdaper extends BaseAdapter {

    // Explicit
    private Context context;
    private int[] iconInts;     // สร้าง Array
    private String[] namesStrings, detailStrings;

    // กด Alt + Insert


    public MyAdaper(Context context, int[] iconInts, String[] namesStrings, String[] detailStrings) {
        this.context = context;
        this.iconInts = iconInts;
        this.namesStrings = namesStrings;
        this.detailStrings = detailStrings;
    }


    @Override
    public int getCount() {
        return iconInts.length;   // ทำการนับว่า ต้องการให้มีรายการกี่ชุด จากเดิม return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        // Open Service
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);       //  สร้างตัวแปรเสมือน


        View view1 = layoutInflater.inflate(R.layout.my_listview, viewGroup, false);    //สร้างวิวใหม่


        //Bild Widget
        ImageView iconImageView = (ImageView) view1.findViewById(R.id.imageView);
        TextView nameTextView = (TextView) view1.findViewById(R.id.textView2);
        TextView detailTextView = (TextView) view1.findViewById(R.id.textView3);


        // Show View
        iconImageView.setImageResource(iconInts[i]);
        nameTextView.setText(namesStrings[i]);
        detailTextView.setText(detailStrings[i]);


        return view1; // return view1;
    }

}   // end of Main Class
