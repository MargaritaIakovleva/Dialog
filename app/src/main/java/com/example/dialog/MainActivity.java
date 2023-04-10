package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button bgButton;
    public ConstraintLayout relativeLayout;
    Context context;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bgButton = (Button)findViewById(R.id.button_fon);
        relativeLayout = (ConstraintLayout)findViewById(R.id.ConstraitLayout);
        context = MainActivity.this;

        bgButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);
        final CharSequence[] item = {getText(R.string.red), getText(R.string.yellow), getText(R.string.green)};
        builder.setItems(item, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                        relativeLayout.setBackgroundResource(R.color.redColor);
                        break;
                    case 1:
                        Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                        relativeLayout.setBackgroundResource(R.color.yellowColor);
                        break;
                    case 2:
                        Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                        relativeLayout.setBackgroundResource(R.color.greenColor);
                        break;
                }

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}