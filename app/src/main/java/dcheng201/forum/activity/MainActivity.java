package dcheng201.forum.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import dcheng201.forum.R;


public class MainActivity extends AppCompatActivity {
    public EditText eusername;
    private EditText epassword;
    private TextView registerScreen;
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    public String outputs;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eusername = (EditText) findViewById(R.id.editText);
        epassword = (EditText) findViewById(R.id.editText2);
        registerScreen = (TextView) findViewById(R.id.textView2);

    }
    public void LOGIN(View view){
        String username = eusername.getText().toString();
        String password = epassword.getText().toString();
        String type = "login";
        ServiceHandler background = (ServiceHandler) new ServiceHandler(new ServiceHandler.AsyncResponse() {
             @Override
             public void processFinish(String output) {
                outputs = output;
             }
         }).execute(type, username, password);
        Log.i("outputs: ",outputs);

    }

    public void RegisterHere(View view){
        Intent i = new Intent(MainActivity.this, RegisterScreen.class);
        startActivity(i);
    }
    public EditText getUserName(){
        return eusername;
    }

}