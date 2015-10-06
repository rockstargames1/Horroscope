package f3.listapp.thirdapp.kishlay.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kishl_000 on 10/6/2015.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    List<String> mlist;
    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mlist = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater.from(getContext()));
        convertView = inflater.inflate(R.layout.row_layout, null);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        ImageView imageView2 = (ImageView) convertView.findViewById(R.id.imageView2);
        switch (position) {
            case 0:
            textView.setText(mlist.get(position));
            imageView2.setImageResource(R.drawable.b0);
            break;
            case 1:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b1);
                break;
            case 2:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b2);
                break;
            case 3:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b3);
                break;
            case 4:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b4);
                break;
            case 5:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b5);
                break;
            case 6:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b6);
                break;
            case 7:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b7);
                break;
            case 8:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b8);
                break;
            case 9:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b9);
                break;
            case 10:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b10);
                break;
            case 11:
                textView.setText(mlist.get(position));
                imageView2.setImageResource(R.drawable.b11);
                break;
        }
        return convertView;
    }
}