package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;

    // add tag for debugging
    public static final String TAG = "StoryApp";

    // add story member
    public Story mSimple;

    // add other variables
    private int Count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // initiate button
        mButton_To_Story = (Button) findViewById(R.id.button_To_Story);

        // set listener on button
        mButton_To_Story.setOnClickListener(new MyListener());
        Log.d(TAG, "Listener on Button_To_Story set" );

        // initialise story
        InitialiseStory();


        // check how many placeholders
        Count = mSimple.getPlaceholderCount();
        // TODO check if working
        System.out.println(Count);
    }
    public void InitialiseStory() {
        try {
            mSimple = new Story(getAssets().open("madlib0_simple.txt"));
            Log.d(TAG, "created story");
        }
        catch (IOException e) {
            Log.e(TAG, e.getClass().getName());
        }
    }
    

}
