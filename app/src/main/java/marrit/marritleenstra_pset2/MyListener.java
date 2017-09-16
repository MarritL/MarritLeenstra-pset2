package marrit.marritleenstra_pset2;

import android.content.Intent;
import android.view.View;

/**
 * Created by Marrit on 14-9-2017.
 */

public class MyListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        //start PlaceholderActivity
        Intent intent = new Intent(view.getContext(), PlaceholderActivity.class);
        view.getContext().startActivity(intent);
    }

}
