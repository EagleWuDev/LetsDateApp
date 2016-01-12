package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ewu1 on 10/27/2015.
 */
public class description extends Activity{

    TextView title;
    TextView description;
    ImageView image;
    Button add;
    Bundle id;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description);

        title = (TextView)findViewById(R.id.textView2);
        description = (TextView)findViewById(R.id.textView3);
        image = (ImageView)(findViewById(R.id.imageView2));
        add = (Button)(findViewById(R.id.add));

        id = getIntent().getExtras();
        final String value = id.getString("index");
        final String value2 =id.getString("index2");

        title.setText(value);
        description.setText(value2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loop = new Intent(description.this, StartingActivity.class);
                loop.putExtra("value", value);
                loop.putExtra("value2", value2);
                startActivity(loop);
            }
        });


    }


}
