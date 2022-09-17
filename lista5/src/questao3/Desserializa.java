package questao3;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import questao2.Movies;

public class Desserializa {
    public static void main(String[] args) throws Exception {
        File file = new File("arquivo.json");
        ObjectMapper jsonFile = new ObjectMapper();
        Movies movies = jsonFile.readValue(file, Movies.class);
        System.out.println(movies);
    }
}
