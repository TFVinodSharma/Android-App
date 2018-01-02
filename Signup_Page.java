package tris.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Dell on 11/13/2017.
 */

public class Signup_Page extends AppCompatActivity implements View.OnClickListener {
    EditText eName,eEmail,ePassword,eMobile,eAddress;
    Button saveData;
    FirebaseDatabase database;
    DatabaseReference users;
    TextView textLogin ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);


        database=FirebaseDatabase.getInstance();
        users=database.getReference("Users");



        eName = (EditText) findViewById(R.id.e1);

        eEmail = (EditText) findViewById(R.id.e2);
        ePassword = (EditText) findViewById(R.id.e5);
        eMobile = (EditText) findViewById(R.id.e6);
        eAddress = (EditText) findViewById(R.id.e3);
        saveData = (Button) findViewById(R.id.btn);
        textLogin=(TextView)findViewById(R.id.t1) ;
        
        saveData.setOnClickListener(this);
        textLogin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view==saveData)
        {
            final UserInformation user = new UserInformation(eName.getText().toString(),
                    eEmail.getText().toString(),
                    eAddress.getText().toString(),
                    eMobile.getText().toString(),
                    ePassword .getText().toString());
            users.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(user.getName()).exists())
                        Toast.makeText(Signup_Page.this, "The User is Already Exits or Fields are Empty", Toast.LENGTH_SHORT).show();
                    else {
                        users.child(user.getName()).setValue(user);
                        Toast.makeText(Signup_Page.this, "Success Register", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(Signup_Page.this,LoginPage.class);
                        startActivity(i);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // add your custom code

                }
            });
        }
        if (view ==textLogin)
        {
            Intent i=new Intent(Signup_Page.this,LoginPage.class);
            startActivity(i);


        }
    }
    /*private void saveUserInformation()
    {
        String name=eName.getText().toString().trim();
        String email=eEmail.getText().toString().trim();
        String pass=ePassword.getText().toString().trim();
        String mob=eMobile.getText().toString().trim();
        String add=eAddress.getText().toString().trim();


        if (!TextUtils.isEmpty(name)||!TextUtils.isEmpty(email)||!TextUtils.isEmpty(pass)||!TextUtils.isEmpty(mob)
                ||!TextUtils.isEmpty(add))
        {
            String id= databaseReference.push().getKey();
            UserInformation userinformation=new UserInformation(id,name,email,add,mob,pass);
            databaseReference.child(id).setValue(userinformation);
            Toast.makeText(this, "Information Added", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "you should enter whole values", Toast.LENGTH_SHORT).show();
        }


    }


    @Override
    public void onClick(View v) {
        if (v==saveData)

        {
            saveUserInformation();
        }
        if (v==textLogin)
        {
            Intent i=new Intent(Signup_Page.this,LoginPage.class);
            startActivity(i);

        }



    }
*/

}
