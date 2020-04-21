package comkoeftespiess;

import java.util.ArrayList;

public class Cinema {

    ArrayList<Movie> movies = new ArrayList<Movie>();

    public void addMovie(Movie movie) {

        movies.add(movie);

        for (int i = 0; i < movies.size(); i++){
            System.out.println(movies.get(i).getMovieName() + "\n" + movies.get(i).getMovieDescription() + "\n" + movies.get(i).getMovieLength());
        }

    }

    public ArrayList<Movie> getMovies() {

        return movies;

    }

}
