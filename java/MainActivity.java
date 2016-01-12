package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity {

    private ListView listView;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle list;

        list = getIntent().getExtras();

        if (list != null) {
            String type = list.getString("activityType");
            showDetails(type);
        }
    }

        public void showDetails (String type) {

            ArrayList<HashMap<String, String>> List = new ArrayList<>();
            String[] title = {"The Local", "Bertucci's", "Pizza", "Moar Pizza", "Doge", "Car", "Truck"};
            String[] description = {"The local is a wellesley restuarant that serves local foods", "Bertuccis sells ice cream", "Pizza TIME", "MOAR PIZZAAAA", "Doge", "Car", "Truck"};
            String[] entertainment = {"The Martian", "Boston Calling", "Book of Mormon", "Black Mass", "Jay-Z Concert", "Bey", "Netflix and Chill"};
            String[] edescription = {"Movie: Matt Damon must be saved, again" , "Music Fest: Firefly in Boston", "Play: From the Creators of South Park", "Movie: Johnny Depp gets serious about his career", "Concert: Jay-Z BABY", "Concert: Beyonce, BABY", "Want to Netflix and Chill?"};
            String[] outdoor = {"Rock Climbing", "Boston Commons", "Wellesley Park", "Golfing", "Tennis", "Skydiving", "Drag Race"};
            String[] odescription = {"Sports: Wellesley Rock Climbing Company" , "Nice Walk Along Boston Commons", "Nice Walk around Wellesley Park", "Sports:Golf at Wellesley Club", "Sports: Tennis at Babson", "Sports: Skydiving", "Sports: Babson Drift"};
            final String[] titleLast = new String[7];
            final String[] descriptionLast = new String[7];



            if(type.equals("Dining")) {
                for (int i = 0; i < 7; i++) {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("title", title[i]);
                    data.put("description", description[i]);
                    titleLast[i] = title[i];
                    descriptionLast[i] = description[i];
                    List.add(data);
                }
            }

            if(type.equals("Entertainment")){
                for (int i =0; i<7; i++){
                    HashMap<String, String> data2 = new HashMap<>();
                    data2.put("title", entertainment[i]);
                    data2.put("description", edescription[i]);
                    titleLast[i] = entertainment[i];
                    descriptionLast[i] = edescription[i];
                    List.add(data2);
                }
            }

            if(type.equals("Outdoor")){
                for (int i = 0; i<7;i++){
                    HashMap<String, String> data3 = new HashMap<>();
                    data3.put("title", outdoor[i]);
                    data3.put("description", odescription[i]);
                    titleLast[i] = outdoor[i];
                    descriptionLast[i] = odescription[i];
                    List.add(data3);

                }
            }

            listView=(ListView) findViewById(R.id.listViewRestaurants);

            customListViewAdapter= new CustomListViewAdapter(getApplicationContext(),List);
            listView.setAdapter(customListViewAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent i = new Intent(MainActivity.this, StartingActivity.class);
                    String title2 = (titleLast[position]);
                    String description = (descriptionLast[position]);
                    i.putExtra("value", title2);
                    i.putExtra("value2", description);
                    startActivity(i);

                }
            });
        }

    }
