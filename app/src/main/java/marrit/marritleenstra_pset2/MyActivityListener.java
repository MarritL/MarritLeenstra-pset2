package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;


/**
 * Created by Marrit on 14-9-2017.
 */

public class MyActivityListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Intent intent;

        // check which element is clicked
        if (view == view.findViewById(R.id.button_start)) {
            // start PlaceholderActivity
            intent = new Intent(view.getContext(), PlaceholderActivity.class);
                    }
        else if (view == view.findViewById(R.id.button_To_Story)) {
            // start StoryActivity
            intent = new Intent(view.getContext(), StoryActivity.class);
            // put story as intent Extra
            intent.putExtra(PlaceholderActivity.EXTRA_PASS_STORY,PlaceholderActivity.mSimple.toString());
            Log.d(PlaceholderActivity.TAG, "something went wrong at intent.putExtra");
        }
        else  {
            // go back to MainActivity
            intent = new Intent (view.getContext(), MainActivity.class);
        }

        view.getContext().startActivity(intent);
    }



}


