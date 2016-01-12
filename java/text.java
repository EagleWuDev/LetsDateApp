package letsdatealpha1.eagle.com.letsdatealpha1;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by ewu1 on 10/28/2015.
 */
public class text extends Activity{
    TextView title;
    TextView description;
    EditText phoneNo;
    Button send;
    String des;
    String tit;
    String mess;
    String number;
    Bundle yes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.text);

        title = (TextView)(findViewById(R.id.textView10));
        description = (TextView)(findViewById(R.id.textView11));
        phoneNo = (EditText)(findViewById(R.id.mobileNumber));
        send = (Button)(findViewById(R.id.send_text));


        yes = getIntent().getExtras();

        des = yes.getString("Description");
        tit = yes.getString("Title");
        mess = ("Let's Date" + tit + ": " + des);

        title.setText(tit);
        description.setText(des);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number = phoneNo.getText().toString();

                try{
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, mess, null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!", Toast.LENGTH_LONG).show();

                } catch (Exception e){
                    Toast.makeText(getApplicationContext(), "SMS failed, please try again later", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });





    }







}
