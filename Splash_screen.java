package tris.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Dell on 11/13/2017.
 */

public class Splash_screen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread th=new Thread()
        {
            @Override
            public void run()
            {
                try{
                    sleep(2000);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent i=new Intent(Splash_screen.this,LoginPage.class);
                    startActivity(i);
                }
            }
        };
        th.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();

    }

}
