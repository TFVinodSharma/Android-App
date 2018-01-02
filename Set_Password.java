package tris.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Thread.sleep;

/**
 * Created by Dell on 11/13/2017.
 */

public class Set_Password extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_password);

    }

    public void doit(View v) throws InterruptedException
    {
        EditText ee1 = (EditText) findViewById(R.id.e1);
        String Pass = ee1.getText().toString();
        if (Pass.equals("") || Pass.equals(null))
        {
            Toast.makeText(this, " Please Fill Password ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Your Password Update ", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(Set_Password.this, LoginPage.class);

            startActivity(i);
            sleep(1000);
        }

    }
}