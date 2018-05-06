package universodoandroid.firebaseview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {

    private Button Logout_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);

        mAuth = FirebaseAuth.getInstance();
        Log.i("Email", mAuth.getCurrentUser().getEmail());

        //Logout_btn = (Button) findViewById(R.id.btn_sair);

    }

//    public void Logout(View view) {
//        mAuth.signOut();
//    }

}
