package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by ewu1 on 10/24/2015.
 */
public class StartActivity extends AppCompatActivity {

    Button startButton;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        startButton = (Button)(findViewById(R.id.buttonStart));

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(StartActivity.this, StartingActivity.class);
                startActivity(startIntent);
            }
        });
    }
}
