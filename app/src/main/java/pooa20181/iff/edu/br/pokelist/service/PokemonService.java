package pooa20181.iff.edu.br.pokelist.service;

import pooa20181.iff.edu.br.pokelist.model.Pokemon;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonService {
    @GET("pokemon/{id}/")
    Call<Pokemon> buscarPokemon(@Path("id") int id);
}
