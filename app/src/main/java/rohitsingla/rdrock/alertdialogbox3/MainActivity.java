package rohitsingla.rdrock.alertdialogbox3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements DialogForm.DialogFormListener {

    TextView textViewUsername, textViewPassword;
    Button buttonOpenDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        textViewUsername = (TextView)findViewById(R.id.textViewUsername);
        textViewPassword = (TextView)findViewById(R.id.textViewPassword);
        buttonOpenDialog = (Button) findViewById(R.id.buttonOpenDialog);

        buttonOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();

            }
        });
    }
    void openDialog(){
        DialogForm dialogForm = new DialogForm();
        dialogForm.show(getSupportFragmentManager(),"Dialog Form");
    }

    @Override
    public void applyText(String username, String password) {

        textViewUsername.setText(username);
        textViewPassword.setText(password);


    }
}
