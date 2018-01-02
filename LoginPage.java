package tris.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Dell on 11/13/2017.
 */

public class LoginPage extends AppCompatActivity  implements View.OnClickListener{

    EditText ee1,ee2;
    Button butSignIn,b22;
    TextView t11,t22;

    // FireBase

    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        // FireBase

        database=FirebaseDatabase.getInstance();
        users=database.getReference("Users");


        butSignIn= (Button) findViewById(R.id.b1);
         b22 = (Button) findViewById(R.id.b2);

         t11 = (TextView) findViewById(R.id.t1);
         t22 = (TextView) findViewById(R.id.t2);

        ee1=(EditText)findViewById(R.id.e1);
        ee2=(EditText)findViewById(R.id.e2);

       /* butSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn(ee1.getText().toString(),ee2.getText().toString());
            }
        });
*/
       butSignIn.setOnClickListener(this);
        b22.setOnClickListener(this);
        t11.setOnClickListener(this);
        t22.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        EditText ee1=(EditText)findViewById(R.id.e1);
        EditText ee2=(EditText)findViewById(R.id.e2);
         if(v.getId()==R.id.b1)
        {
            if (ee1.getText().toString().equals("admin") && ee2.getText().toString().equals("admin"))
            {
                Intent i = new Intent(LoginPage.this, Navigation_Bar.class);
                startActivity(i);
            }
            else
            {
                Toast.makeText(this, "Incorrect user name or password", Toast.LENGTH_SHORT).show();
            }


        }
       /*else if (v.getId()==R.id.b2)
        {
            Intent i=new Intent(LoginPage.this,FaceBook_Login.class);
            startActivity(i);
        }*/

        if(v.getId()==R.id.t1)
        {
            Intent i=new Intent(LoginPage.this,Forget_Password.class);
            startActivity(i);
        }
        else if (v.getId()==R.id.t2)
        {
            Intent i=new Intent(LoginPage.this,Signup_Page.class);
            startActivity(i);
        }

    }

   /*private  void signIn(final String name, final String password) {
        users.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(name).exists())
                {
                    if (!name.isEmpty())
                    {
                        UserInformation login=dataSnapshot.child(name).getValue(UserInformation.class);
                        if (login.getPassword().equals(password))
                        {
                            Toast.makeText(LoginPage.this, "Success login", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(LoginPage.this, "Password is wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                        Toast.makeText(LoginPage.this, "Email is not Registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // custom code here
            }
        });
    }
*/

}
