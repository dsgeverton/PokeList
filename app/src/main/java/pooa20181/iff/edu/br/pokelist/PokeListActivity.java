package pooa20181.iff.edu.br.pokelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class PokeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokelist);

        TextView welcome = findViewById(R.id.welcome);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        welcome.setText("Bem vindo, "+account.getFamilyName()+"!");
        Toast.makeText(this, account.getDisplayName().toString(), Toast.LENGTH_LONG).show();
    }
}