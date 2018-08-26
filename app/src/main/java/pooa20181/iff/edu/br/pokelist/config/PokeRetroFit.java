package pooa20181.iff.edu.br.pokelist.config;

import pooa20181.iff.edu.br.pokelist.service.PokemonService;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class PokeRetroFit {

    private final Retrofit retrofit;

    public PokeRetroFit(){
        this.retrofit = new Retrofit.Builder()
        .baseUrl("http://pokeapi.co/api/v2/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build();
        }

        public PokemonService getPokemonService(){
            return this.retrofit.create(PokemonService.class);
        }
}
