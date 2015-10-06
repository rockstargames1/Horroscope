package f3.listapp.thirdapp.kishlay.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        list = (ListView)findViewById(R.id.list);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



       final String m[] = {"Aries",
                "Taurus",
                "Gemini",
                "Cancer",
                "Leo",
                "Virgo",
                "Libra",
                "Scorpio",
                "Sagittarius",
                "Capricorn",
                "Aquarius",
                "Pisces"};
        List<String> months = new ArrayList<String>(Arrays.asList(m));
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this,R.layout.row_layout,R.id.textView,months);
        list.setAdapter(monthsAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch(position)
                {
                    case 0:
                    intent = new Intent(MainActivity.this,Zodiac.class);
                    intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a0));
                    startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a1));
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a2));
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image", Integer.toString(R.drawable.a3));
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign", "Hello " + m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a4));
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign", "Hello " + m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a5));
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a6));
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a7));
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a8));
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a9));
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a10));
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(MainActivity.this,Zodiac.class);
                        intent.putExtra("sign","Hello "+ m[position]);
                        intent.putExtra("image",Integer.toString(R.drawable.a11));
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
