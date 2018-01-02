package tris.list;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.N)

public class Search_Nanny extends AppCompatActivity {
    private TextView mDisplayDate;
    private static  String TAG="Search_Nanny";
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    TextView startTime;
    TextView endTime;
    //static final int DIALOG_ID = 0;

    // Get Current time
    final Calendar calender = Calendar.getInstance();
    int hour = calender.get(Calendar.HOUR_OF_DAY);
    int minute = calender.get(Calendar.MINUTE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search__nanny);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);     // for back button on actionbar


        // ShowTimePicker();

        mDisplayDate=(TextView)findViewById(R.id.tv);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month =cal.get(Calendar.MONTH);
                int date=cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog;
                dialog = new DatePickerDialog(Search_Nanny.this,
                        mDateSetListener,
                        year,month,date);
// .parseColor(""); causes the color.java file which is red mark inside it(ColorInt and Size), so remove this red mark  gone.
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));
                dialog.show();

            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet:mm/dd/yy:" + month + "/" + day + "/" + year);
                String date = month+1 + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };



    }
    //  here we give condition  for going from one activity to another activity

    public void search(View v) throws InterruptedException
    {

        if (mDisplayDate.getText().toString().equals("")|| startTime.getText().toString().equals("")|| endTime.getText().toString().equals("") )
        {
            Toast.makeText(this, "choose Date and Time First", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i = new Intent(Search_Nanny.this, MainActivity.class);
            i.putExtra("date",mDisplayDate.getText().toString());
            i.putExtra("time",startTime.getText().toString());
            i.putExtra("time1",endTime.getText().toString());
            startActivity(i);
        }
    }

    // This coding for End Time ..//

    public void ShowTime(View v)
    {
        endTime=(TextView)findViewById(R.id.tv2);
        TimePickerDialog timePickerDialog = new TimePickerDialog(Search_Nanny.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        endTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);
        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));

        // dialog.show();

        timePickerDialog.show();
    }


    // for Start Time

    public void ShowTimePicker(View v)
    {
        startTime=(TextView)findViewById(R.id.tv1);
        TimePickerDialog timePickerDialog = new TimePickerDialog(Search_Nanny.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {

                        startTime.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);



        timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FDD7E4")));

        timePickerDialog.show();
    }



}
