package lobaton.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {
    String username, password, fullName;
    EditText etUsername, etPassword, etFullName;
    int formSuccess = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etUsername = findViewById(R.id.input_userName);
        etPassword = findViewById(R.id.input_password);
        etFullName = findViewById(R.id.input_fullName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.btnSave:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();
                fullName = etFullName.getText().toString();
                formSuccess = 3;

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

                if (fullName.equals("")) {
                    etFullName.setError("This field is required");
                    formSuccess--;
                }

                // form successfully validated
                if (formSuccess == 3) {
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
