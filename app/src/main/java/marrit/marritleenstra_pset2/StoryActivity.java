package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StoryActivity extends AppCompatActivity {

    // add button member
    private Button mButton_Restart;


    // add variables
    private TextView mStoryTextView;
    private String text;

    public static final String TAG = "StoryApp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Log.d(TAG, "Created StoryActivity");

        // Initiate button
        mButton_Restart = (Button) findViewById(R.id.button_restart);

        // add listener to button
        mButton_Restart.setOnClickListener(new MyActivityListener());



       // text = mSimple.toString();
       // Log.d(TAG, "toString");


        // initialise story in layout
        //mStoryTextView = (TextView) findViewById(R.id.Story);

        // Show story on screen
        //mStoryTextView.setText(text);
        //Log.d(TAG, "setText");


    }

}
