package comd.example.thearchitect.e_bid;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void showToast(View view)
    {
        Snackbar.make(view,"Hey! Login Button clicked",Snackbar.LENGTH_LONG)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            
                    }
                })
                .show();
    }

    public void registerNew(View view)
    {
        Toast.makeText(this, "Kindly wait as we register you!", Toast.LENGTH_SHORT).show();
    }

    public void forgotPassword(View view)
    {
        Toast.makeText(this, "Don't worry we got you.", Toast.LENGTH_SHORT).show();
    }
}
