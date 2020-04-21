package comkoeftespiess;

public class Movie {

    private String movieName;
    private String movieDescription;
    private String movieLength;

    public Movie(String movieName, String movieDescription, String movieLength) {

        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieLength = movieLength;

    }

    public String getMovieName() {
        return this.movieName;
    }

    public String getMovieDescription() {
        return this.movieDescription;
    }

    public String getMovieLength() {
        return this.movieLength;
    }

}
