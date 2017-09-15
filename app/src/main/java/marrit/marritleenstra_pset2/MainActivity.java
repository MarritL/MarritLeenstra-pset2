package marrit.marritleenstra_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // add button member
    private Button mButton_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initiate button
        mButton_start = (Button) findViewById(R.id.button_start);

        // set MyListener on button
        mButton_start.setOnClickListener(new MyListener());
    }
}
