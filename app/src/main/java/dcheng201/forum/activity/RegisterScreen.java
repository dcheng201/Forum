package dcheng201.forum.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import dcheng201.forum.R;

public class RegisterScreen extends AppCompatActivity {
    EditText password2, password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);
        password2 = (EditText) findViewById(R.id.password);
        password1 = (EditText) findViewById(R.id.confirm);
    }
    public void RegisterHere(View view){
        String passw = password1.getText().toString();
        String password = password2.getText().toString();
        String email = ((EditText) findViewById(R.id.eMail)).getText().toString();
        String username = ((EditText) findViewById(R.id.Username)).getText().toString();
        String type = "register";
        if(password.equals(passw)&& !email.equals("")&& !username.equals("")) {
            Log.i("Execution","executed");
            ServiceHandler background = new ServiceHandler(this);
            background.execute(type, email,username, password);
        }else{
            Log.i("Execution"," not executed");

        }

    }
}
