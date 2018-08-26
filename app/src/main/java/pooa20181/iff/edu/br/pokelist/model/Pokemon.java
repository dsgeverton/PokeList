package pooa20181.iff.edu.br.pokelist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"weight","stats","moves","sprites","order","species","is_default","held_items","location_area_encounters","game_indices","forms", "abilities", "types", "base_experience"})
public class Pokemon {

    private int id;
    private String name;
    private int height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
