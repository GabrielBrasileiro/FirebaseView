package universodoandroid.firebaseview;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private FirebaseAuth mAuth;

    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Get Firebase auth instance
        mAuth = FirebaseAuth.getInstance();

        // Esse processo declara a barra de dialogo
        mProgress = new ProgressDialog(this);

        btnSignIn = (Button) findViewById(R.id.voltar_menu_btn);
        btnSignUp = (Button) findViewById(R.id.cadastrar_btn);
        inputEmail = (EditText) findViewById(R.id.email_menu_cadastro);
        inputPassword = (EditText) findViewById(R.id.senha_menu_cadastro);

//        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);

//        btnResetPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignUpActivity.this, ResetPasswordActivity.class));
//            }
//        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Insira o seu E-mail", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Insira a sua senha", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "A senha está pequena, deve coner no mínimo 6 dgitos", Toast.LENGTH_SHORT).show();
                    return;
                }

                mProgress.setMessage("Realizando o cadastro...");
                mProgress.setCancelable(false);
                mProgress.show();

                //create user
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                mProgress.dismiss();

                                // Se o cadastro funcionar irá aparecer a mensagem acima, porém se der certo
                                // Um toast de sucesso irá aparecer e após isso vai ser chamada a activity principal

                                if (!task.isSuccessful()) {

                                    Toast.makeText(SignUpActivity.this, "A autenticação falhou", Toast.LENGTH_SHORT).show();

                                } else {

                                    Toast.makeText(SignUpActivity.this, "Criação de usuário completa" , Toast.LENGTH_SHORT).show();
                                    finish();

                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
