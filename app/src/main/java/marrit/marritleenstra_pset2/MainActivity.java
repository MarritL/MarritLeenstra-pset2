package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //for debugging
    public static final String TAG = "StoryApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate button
        Button mButton_start = (Button) findViewById(R.id.button_start);

        // set MyListener on button
        mButton_start.setOnClickListener(new MyActivityListener());
        Log.d(TAG, "Listener on button_start set");
    }
}
