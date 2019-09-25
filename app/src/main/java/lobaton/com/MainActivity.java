package lobaton.com;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username, password;
    EditText etUsername, etPassword;
    int formSuccess = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.username);
        etPassword = findViewById(R.id.password);

        Button loginButton = findViewById(R.id.login_button);
        TextView registerTextView = findViewById(R.id.register_textView);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                formSuccess = 2;

                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formSuccess--;
                }

                // validate password
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formSuccess--;
                }

                // form successfully validated
                if (formSuccess == 2) {
                    Toast.makeText(getApplicationContext(), "Form successfully validated", Toast.LENGTH_LONG).show();
                }
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnSave:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                formSuccess = 2;

                // validate username
                if (username.equals("")) {
                    etUsername.setError("This field is required");
                    formSuccess--;
                }

                // validate password
                if (password.equals("")) {
                    etPassword.setError("This field is required");
                    formSuccess--;
                }

                // form successfully validated
                if (formSuccess == 2) {
                    Toast.makeText(this, "Form successfully validated", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.btnCancel:
                this.finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
