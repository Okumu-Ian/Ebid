package comd.example.thearchitect.e_bid;

import android.app.Dialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends AppCompatActivity {

    private TextView textView,txtPriceDescription;
    private CountDownTimer countDownTimer;
    long timeRemaining = 300000L;
    long interval= 1000L;
    private double setPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        initUI();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private View createView(final Dialog dialog)
    {
        View view = LayoutInflater.from(this).inflate(R.layout.bid_layout,null,false);
        final TextView username,email,submit,cancel;
        final EditText edt_bid_price;

        username = view.findViewById(R.id.txt_bid_username);
        email = view.findViewById(R.id.txt_bid_user_email);
        submit = view.findViewById(R.id.txt_submit_btn);
        cancel = view.findViewById(R.id.txt_cancel_btn);

        edt_bid_price = view.findViewById(R.id.edt_price_available);

        //int bid_price = Integer.valueOf(edt_bid_price.getText().toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                handleDialogActivity(edt_bid_price);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        return view;

    }

    private void initUI()
    {
        textView = findViewById(R.id.txt_time_remaining_product_details);
        txtPriceDescription = findViewById(R.id.txt_price_description);
        countDownTimer = new CountDownTimer(timeRemaining,interval) {
            @Override
            public void onTick(long millisUntilFinished) {
                String formattedString = String.format("%02d:%02d:%02d", java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)- java.util.concurrent.TimeUnit.HOURS.toMinutes(java.util.concurrent.TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                        java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished)- java.util.concurrent.TimeUnit.MINUTES.toSeconds(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));
                textView.setText(formattedString+" remaining");

            }

            @Override
            public void onFinish() {
                Toast.makeText(ProductDetails.this, "Sold", Toast.LENGTH_SHORT).show();
            }
        };
        countDownTimer.start();
    }

    private void handleDialogActivity(EditText a)
    {


    }

    private void showDialog()
    {
        Dialog dialog = new Dialog(ProductDetails.this);
        dialog.setCancelable(false);
        dialog.setContentView(createView(dialog));
        dialog.show();
    }

}
