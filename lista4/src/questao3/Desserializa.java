package questao3;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import questao2.Movies;

public class Desserializa {
    public static void main(String[] args) throws Exception {
        File file = new File("arquivo.xml");
        XmlMapper xmlMapper = new XmlMapper();
        Movies movies = xmlMapper.readValue(file, Movies.class);
        System.out.println(movies);
    }
}
