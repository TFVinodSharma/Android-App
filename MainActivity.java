package tris.list;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String[] shannyTitles;
    String[] shannyDescription;
    int[] images={R.drawable.imagesss,R.drawable.download,R.drawable.downloads,R.drawable.download,R.drawable.downloadss,R.drawable.girls,
    R.drawable.girlss,R.drawable.photos,R.drawable.photot,R.drawable.downloadss};
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);     // for back button on actionbar

        // find id's of textview for receving the data from previous activity

        TextView textView=(TextView)findViewById(R.id.date);
        TextView textView1=(TextView)findViewById(R.id.time);
        TextView textView2=(TextView)findViewById(R.id.enddate);

        // data are placed from previous activity i.e Second_Search activity

        Bundle bundle=getIntent().getExtras();
        String a=bundle.getString("date");
        String b=bundle.getString("time");
        String c=bundle.getString("time1");
        textView.setText(a);
        textView1.setText(b);
        textView2.setText(c);


        Resources res= getResources();// this method returns the object type.

        shannyTitles=  res.getStringArray(R.array.title);
        shannyDescription=res.getStringArray(R.array.Description);
        list= (ListView) findViewById(R.id.listview);
        Adapter adapter=new Adapter(this,shannyTitles,images,shannyDescription);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(MainActivity.this,Book_Nanny.class);
               // textViewName.getText().toString().equalsIgnoreCase("title");
                intent.putExtra("title",list.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });

    }

}
class Adapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[]  titleArray;
    String[] descriptionArray;

    public Adapter(@NonNull Context context, String[] titles,int imgs[],String[] desc) {
        super(context,R.layout.single_row,R.id.textview1,titles);
        this.context=context;
        this.images=imgs;
        this.titleArray=titles;
        this.descriptionArray=desc;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View row= inflater.inflate(R.layout.single_row,parent,false);// row represent relative layout.

       ImageView myImage= row.findViewById(R.id.imageview);
        TextView myTitles= row.findViewById(R.id.textview1);
        TextView myDescription= row.findViewById(R.id.textview2);

        myImage.setImageResource(images[position]);
        myTitles.setText(titleArray[position]);
        myDescription.setText(descriptionArray[position]);



        return row;

    }
}
