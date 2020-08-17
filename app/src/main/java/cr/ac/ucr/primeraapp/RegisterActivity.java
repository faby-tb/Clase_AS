package cr.ac.ucr.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etEmail;
    private EditText etPassword;
    private EditText etName;

    Pattern pattern = Patterns.EMAIL_ADDRESS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.et_Email);
        etPassword = findViewById(R.id.et_Password);
        etName = findViewById(R.id.et_Name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                register();
                break;
            case R.id.btn_goto_login:
                gotoLogin();
                break;
            default:
                break;
        }
    }
    private void register() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String name = etName.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError(getString(R.string.email_required));
            return;
        }
        if(password.isEmpty()){
            etPassword.setError(getString(R.string.password_required));
            return;
        }
        if(name.isEmpty()){
            etName.setError(getString(R.string.name_required));
            return;
        }

        if(pattern.matcher(email).matches()) {
            Toast.makeText(this, getString(R.string.registered_in), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else{
            etEmail.setError(getString(R.string.invalid_email));
        }

    }
    private void gotoLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}