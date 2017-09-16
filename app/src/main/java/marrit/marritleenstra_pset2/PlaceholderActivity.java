package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class PlaceholderActivity extends AppCompatActivity {

    // add button member
    private Button mButton_To_Story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placeholder);

        // initiate button
        mButton_To_Story = (Button) findViewById(R.id.button_To_Story);

        // set listener on button
        mButton_To_Story.setOnClickListener(new MyListener());
    }
}
