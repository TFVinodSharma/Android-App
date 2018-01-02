package tris.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Dell on 11/13/2017.
 */

public class Message  extends AppCompatActivity implements View.OnClickListener
{
    Button button;
    EditText editText;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        button=(Button)findViewById(R.id.send_button);
        editText=(EditText)findViewById(R.id.messagebox);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (editText.getText().toString().equals(""))
        {
            Toast.makeText(this, "Leave some message ", Toast.LENGTH_SHORT).show();

        }
        else
        {

            Toast.makeText(this, "Message sending... ", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, " Message sent", Toast.LENGTH_SHORT).show();
            //editText.setText("");
        }


    }
}
