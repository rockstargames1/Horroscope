package f3.listapp.thirdapp.kishlay.myapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Zodiac extends AppCompatActivity {
TextView textView2,textView3;
    LinearLayout linearLayout;
    ImageView imageView;static String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        textView3 = (TextView) findViewById(R.id.textView3);
        textView2 = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        Intent intent = this.getIntent();
        String s = intent.getStringExtra("sign");
        s1 = s;
        textView2.setText(s);
        new HttpGetTask().execute();
        imageView.setImageResource(Integer.parseInt(intent.getStringExtra("image")));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    private class HttpGetTask extends AsyncTask<Void, Void, String> {

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p/>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param params The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        String dispdata=null;
        final String HOROSCOPE_TAG = "horoscope";
        final String SIGN_TAG = "sign";
        @Override
        protected String doInBackground(Void... params) {
            try {
                URL url = new URL("http://widgets.fabulously40.com/horoscope.json?sign=" + Zodiac.s1.toLowerCase());
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuffer str = new StringBuffer();
                String line = null;
                while((line = bufferedReader.readLine()) != null)
                {
                    str.append(line);
                }
                JSONObject horoscope = (JSONObject) new JSONTokener(str.toString()).nextValue();
                JSONObject details = horoscope.getJSONObject(HOROSCOPE_TAG);
                dispdata = details.getString(HOROSCOPE_TAG);
                return dispdata;
            } catch (MalformedURLException m) {
                dispdata = "Wrong URL";
                return dispdata;
            } catch (IOException e) {
                dispdata = "Sorry!!!Connection Down";
                e.printStackTrace();
                return dispdata;
            }
            catch (JSONException e)
            {
                return null;
            }
        }
        protected void onPostExecute(String result)
        {
            if(dispdata.equals("Sorry!!!Connection Down"))
            {
                imageView.setVisibility(View.INVISIBLE);
                textView2.setVisibility(View.INVISIBLE);
                textView3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24);
                textView3.setGravity(Gravity.CENTER_HORIZONTAL);
                textView3.setTypeface(null, Typeface.BOLD);
                linearLayout.setBackgroundColor(Color.LTGRAY);
            }
            textView3.setText(dispdata);
        }
    }

}
