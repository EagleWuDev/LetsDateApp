package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



/**
 * Created by ewu1 on 10/24/2015.
 */
public class StartingActivity extends Activity {

    Button activityOne;
    TextView activityOneP;
    TextView activityOneD;
    TextView activityTwoP;
    TextView activityTwoD;
    TextView activityThreeP;
    TextView activityThreeD;
    Button send;
    Bundle filter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_activity);

        activityOneP = (TextView)(findViewById(R.id.activityoneTitle));
        activityOneD = (TextView)(findViewById(R.id.textView5));
        activityTwoP = (TextView)(findViewById(R.id.textView6));
        activityTwoD = (TextView)(findViewById(R.id.textView7));
        activityThreeP = (TextView)(findViewById(R.id.textView8));
        activityThreeD = (TextView)(findViewById(R.id.textView9));
        send =(Button)(findViewById(R.id.Done));

        filter = getIntent().getExtras();

        if(filter != null){
            if (activityOneP.getText().equals("")){
                String yes = filter.getString("value");
                activityOneP.setText(yes);
                String yes2 = filter.getString("value2");
                activityOneD.setText(yes2);
            }

        }
        send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent send = new Intent(getApplicationContext(), text.class);
                    send.putExtra("Title", activityOneP.getText());
                    send.putExtra("Description", activityOneD.getText());
                    startActivity(send);
                }
            });





        activityOne = (Button) (findViewById(R.id.addactivity));
        activityOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activityOneIntent = new Intent(StartingActivity.this, ActivityTypes.class);
                activityOneIntent.putExtra("activityNumber", "activityOne");
                startActivity(activityOneIntent);
            }
        });
    }
}
