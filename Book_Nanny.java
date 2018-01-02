package tris.list;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Dell on 11/13/2017.
 */

public class Book_Nanny extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_nanny);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);     // for back button on actionbar
        TextView textViewName = (TextView) findViewById(R.id.textName);
        // textViewName.getResources().getStringArray(R.array.title);
        //textViewName.getText().toString().equalsIgnoreCase("title");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textViewName.setText(bundle.getString("title"));
            textViewName.getText().toString().equalsIgnoreCase("title");

        }

        Button b11 = (Button) findViewById(R.id.b1);
        Button b22 = (Button) findViewById(R.id.addtolist);
        TextView text_call=(TextView)findViewById(R.id.callDialer);
        TextView text_message=(TextView)findViewById(R.id.message_view);

        text_call.setOnClickListener((View.OnClickListener) this);
        text_message.setOnClickListener((View.OnClickListener) this);
        b11.setOnClickListener((View.OnClickListener) this);
        b22.setOnClickListener((View.OnClickListener) this);


    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.b1)
        {
            Toast.makeText(this, "  Successfully Booked", Toast.LENGTH_SHORT).show();
        }
        if(v.getId()==R.id.addtolist)
        {
            Intent i= new Intent(Book_Nanny.this,Search_Nanny.class);
            startActivity(i);

        }
        if (v.getId()==R.id.r1)
        { RatingBar R1 = (RatingBar) findViewById(R.id.r1);
            Toast.makeText(this, "you have submitted" +String.valueOf(R1.getRating()), Toast.LENGTH_SHORT).show();

        }
        if (v.getId()==R.id.callDialer)
        {
            Intent i=new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:0123456789"));
            startActivity(i);
        }
        if (v.getId()==R.id.message_view)
        {
            Intent i= new Intent(Book_Nanny.this,Message.class);
            startActivity(i);

        }

    }

}
