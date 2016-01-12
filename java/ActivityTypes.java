package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ewu1 on 10/24/2015.
 */
public class ActivityTypes extends Activity  {


    Button dining;
    Button entertainment;
    Button outdoors;
    Bundle activityNumber;
    public String activityNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        activityNumber = getIntent().getExtras();

        dining = (Button) (findViewById(R.id.Dining));
        dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(activityNumber != null){
                    activityNum = activityNumber.getString("activityNumber");
                }
            Intent diningIntent = new Intent(ActivityTypes.this, MainActivity.class);
            diningIntent.putExtra("activityType", "Dining");
            diningIntent.putExtra("activityNum", activityNum);
            startActivity(diningIntent);}
        });

        entertainment = (Button) (findViewById(R.id.Entertainment));
        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent entertainmentIntent = new Intent(ActivityTypes.this, MainActivity.class);
                entertainmentIntent.putExtra("activityType", "Entertainment");

                if(activityNumber != null){
                    activityNum = activityNumber.getString("activityNumber");
                }
                entertainmentIntent.putExtra("activityNum", activityNum);
                startActivity(entertainmentIntent);
            }
        });

        outdoors = (Button) (findViewById(R.id.Outdoor));
        outdoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outdoorIntent = new Intent(ActivityTypes.this, MainActivity.class);
                outdoorIntent.putExtra("activityType", "Outdoor");

                if(activityNumber != null){
                    activityNum = activityNumber.getString("activityNumber");
                }
                outdoorIntent.putExtra("activityNum", activityNum);
                startActivity(outdoorIntent);
            }
        });


    }

}
