package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StoryActivity extends AppCompatActivity {

    // add button member
    private Button mButton_Restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        // Inititate button
        mButton_Restart = (Button) findViewById(R.id.button_restart);

        // add listener to butoon
        mButton_Restart.setOnClickListener(new MyListener());
    }
}
