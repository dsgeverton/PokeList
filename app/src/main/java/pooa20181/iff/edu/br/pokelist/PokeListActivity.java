package pooa20181.iff.edu.br.pokelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import pooa20181.iff.edu.br.pokelist.config.PokeRetroFit;
import pooa20181.iff.edu.br.pokelist.model.Pokemon;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokeListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokelist);

        TextView welcome = findViewById(R.id.welcome);
        final EditText pokemon_id = findViewById(R.id.editTextPokemonId);
        Button button_search = findViewById(R.id.buttonSearch);

        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Pokemon> call = new PokeRetroFit().getPokemonService().buscarPokemon(Integer.parseInt(pokemon_id.getText().toString()));

                call.enqueue(new Callback<Pokemon>() {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                        Pokemon pokemon = response.body();
                        Log.i("[POKEMON INFO] ID:", String.valueOf(pokemon.getId()));
                        Log.i("[POKEMON INFO] NOME:", pokemon.getName());
                        Log.i("[POKEMON INFO] HEIGHT:", String.valueOf(pokemon.getHeight()));
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t) {
                        Log.e("PokemonService   ", "Erro ao buscar o pokemon:" + t.getMessage());
                    }
                });
            }
        });

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);

        assert account != null;
        welcome.setText(String.format("Bem vindo, %s!", account.getFamilyName()));
        Toast.makeText(this, account.getDisplayName(), Toast.LENGTH_LONG).show();
    }
}