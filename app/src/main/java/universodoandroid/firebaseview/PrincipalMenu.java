package universodoandroid.firebaseview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class PrincipalMenu extends AppCompatActivity {

    private Button Logout_btn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_menu);

        mAuth = FirebaseAuth.getInstance();

        //Logout_btn = (Button) findViewById(R.id.btn_sair);



    }

//    public void Btn_Sair(View view) {
//        mAuth.signOut();
//
//    }

}
