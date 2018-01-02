package tris.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell on 11/13/2017.
 */

public class Forget_Password extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

    }

    public void show(View v)
    {
        EditText ee1 = (EditText) findViewById(R.id.e1);
        String Email = ee1.getText().toString();
        if (Email.equals("") || Email.equals(null))
        {
            Toast.makeText(this, " Empty Field", Toast.LENGTH_SHORT).show();
        } else
        {
            Intent i = new Intent(Forget_Password.this, Set_Password.class);
            startActivity(i);

        }
    }
}