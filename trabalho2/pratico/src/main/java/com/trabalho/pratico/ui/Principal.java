package com.trabalho.pratico.ui;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.trabalho.pratico.entity.Actor;
import com.trabalho.pratico.entity.Movie;
import com.trabalho.pratico.repository.ActorRepository;
import com.trabalho.pratico.repository.MovieRepository;

@SpringBootApplication
@EntityScan("com.trabalho.pratico")
@EnableJpaRepositories("com.trabalho.pratico")
public class Principal implements CommandLineRunner {
  
  @Autowired
  MovieRepository movieRepository;
  @Autowired
  ActorRepository actorRepository;
  @PersistenceContext
  private EntityManager em;
  
  public static void main(String[] args) {
    SpringApplicationBuilder builder = new SpringApplicationBuilder(Principal.class);
    builder.headless(false).run(args);
  }

  public static void getActorInfo(Actor actor) throws HeadlessException, ParseException {
    String name = JOptionPane.showInputDialog("Insert actor name: ", actor.getName());
    Date bornAt = new SimpleDateFormat("dd/MM/yyyy").parse(JOptionPane.showInputDialog("Insert date of birth (dd/MM/yyyy): ", actor.getBornAt()));
    actor.setName(name);
    actor.setBornAt(bornAt);
  }

  public static void getMovieInfo(Movie movie) {
    String title = JOptionPane.showInputDialog("Insert movie title: ", movie.getTitle());
    int release = Integer.parseInt(JOptionPane.showInputDialog("Insert year of release: ", movie.getRelease()));
    movie.setTitle(title);
    movie.setRelease(release);
  }

  public void insertActorInMovie(Actor actor, Movie movie) {
    List<Actor> listing = movieRepository.findAllActors(movie.getId());

    listing.add(actor);
    movie.setActors(listing);
    
    if (movie.getId() != null) {
      actorRepository.save(actor);
      movieRepository.save(movie);
    } else if (actor.getId() != null) {
      movieRepository.save(movie);
      actorRepository.save(actor);
    }
  }

  public StringBuilder listMovies(List<Movie> movies) {
    StringBuilder listing = new StringBuilder();
		
    for (Movie m : movies) {
			listing.append(m).append("\n");
		}

		return listing;
  }

  public StringBuilder listActors(List<Actor> actors) {
    StringBuilder listing = new StringBuilder();
		
    for (Actor a : actors) {
			listing.append(a).append("\n");
		}

		return listing;
  }

  public void viewMenu() {
    char in;
    Movie movie;
    Actor actor;

    do {
      in = JOptionPane.showInputDialog("Choose an option:\n1 - View all movies\n2 - View an movie\n3 - View all actors\n4 - View an actor\n0 - Close menu").charAt(0);
      StringBuilder listing;
      switch (in) {
        case '1':
          listing = listMovies(findAllMovies());
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "Empty list" : listing);
          break;
        case '2':
          Integer movieId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the movie: "));
          movie = movieRepository.findFirstById(movieId);
          if (movie != null) {
            JOptionPane.showMessageDialog(null, movie + "\nActors:\n" + listActors(movieRepository.findAllActors(movieId)));
          }
          else {
            JOptionPane.showMessageDialog(null, "Error: Movie not found");
          }
          break;
        case '3':
          listing = listActors(findAllActors());
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "Empty list" : listing);
          break;
        case '4':
          Integer actorId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the actor: "));
          actor = actorRepository.findFirstById(actorId);
          if (actor != null) {
            JOptionPane.showMessageDialog(null, actor + "\nMovies:\n" + listMovies(actorRepository.findAllMovies(actorId)));
          }
          else {
            JOptionPane.showMessageDialog(null, "Error: Actor not found");
          }
          break;
        case '0':
          JOptionPane.showMessageDialog(null, "This submenu will close now...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option! Try again");
          break;
      }
    } while(in != '0');
  }

  public void updateMenu() throws HeadlessException, ParseException {
    char in;
    Movie movie;
    Actor actor;

    do {
      in = JOptionPane.showInputDialog("Choose an option:\n1 - Update movie\n2 - Update actor\n0 - Close menu").charAt(0);
      switch (in) {
        case '1':
          Integer movieId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the movie: "));
          movie = movieRepository.findFirstById(movieId);
          if (movie != null) {
            getMovieInfo(movie);
            movieRepository.save(movie);
          }
          else {
            JOptionPane.showMessageDialog(null, "Error: Movie not found");
          }
          break;

        case '2':
          Integer actorId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the actor: "));
          actor = actorRepository.findFirstById(actorId);
          if (actor != null) {
            getActorInfo(actor);
            actorRepository.save(actor);
          }
          else {
            JOptionPane.showMessageDialog(null, "Error: Actor not found");
          }
          break;

        case '0':
          JOptionPane.showMessageDialog(null, "This submenu will close now...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option! Try again");
          break;
      }
    } while(in != '0');
  }

  public void deleteMenu() {
    char in;
    Movie movie;
    Actor actor;

    do {
      in = JOptionPane.showInputDialog("Choose an option:\n1 - Delete an movie\n2 - Delete an actor\n0 - Close menu").charAt(0);
      switch (in) {
        case '1':
          Integer movieId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the movie: "));
          movie = movieRepository.findFirstById(movieId);
          if (movie != null) movieRepository.deleteById(movie.getId());
          else JOptionPane.showMessageDialog(null, "Error: Movie not found");
          break;

        case '2':
          Integer actorId = Integer.parseInt(JOptionPane.showInputDialog("Insert ID of the actor: "));
          actor = actorRepository.findFirstById(actorId);
          if (actor != null) actorRepository.deleteById(actor.getId());
          else JOptionPane.showMessageDialog(null, "Error: Actor not found");
          break;

        case '0':
          JOptionPane.showMessageDialog(null, "This submenu will close now...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option! Try again");
          break;
      }
    } while(in != '0');
  }

  public void insertMenu() throws HeadlessException, ParseException {
    Movie movie;
    Actor actor;
    int chose;
    int in;

    do {
      in = JOptionPane.showInputDialog("Choose an option:\n1 - Insert an movie\n2 - Insert an actor\n0 - Close menu").charAt(0);
      switch (in) {
        case '1':
          movie = new Movie();
          getMovieInfo(movie);
          movieRepository.save(movie);
          chose = JOptionPane.showConfirmDialog(null, "Will you insert any actors?");
          do {
            in = JOptionPane.showConfirmDialog(null, "This actor already exists?");
            if (in == 0) {
              listActors(actorRepository.findAll());
              Integer actorId = Integer.parseInt(JOptionPane.showInputDialog("Insert actor ID:"));
              actor = actorRepository.findFirstById(actorId);
              if (actor != null) {
                insertActorInMovie(actor, movie);
              } else {
                JOptionPane.showMessageDialog(null, "Error: Actor not found");
              }
            } else {
              actor = new Actor();
              getActorInfo(actor);
              insertActorInMovie(actor, movie);
            }
            chose = JOptionPane.showConfirmDialog(null, "Will you insert another one?");
          } while (chose != 1 && chose != 2);
          break;

        case '2':
          actor = new Actor();
          getActorInfo(actor);
          actorRepository.save(actor);
          chose = JOptionPane.showConfirmDialog(null, "Will you insert any movies?");
          do {
            in = JOptionPane.showConfirmDialog(null, "This movie already exists?");
            if (in == 0) {
              listMovies(movieRepository.findAll());
              Integer movieId = Integer.parseInt(JOptionPane.showInputDialog("Insert movie ID:"));
              movie = movieRepository.findFirstById(movieId);
              if (movie != null) {
                insertActorInMovie(actor, movie);
              } else {
                JOptionPane.showMessageDialog(null, "Error: Movie not found");
              }
            } else {
              movie = new Movie();
              getMovieInfo(movie);
              insertActorInMovie(actor, movie);
            }
            chose = JOptionPane.showConfirmDialog(null, "Will you insert another one?");
          } while (chose != 1 && chose != 2);
          break;

        case '0':
          JOptionPane.showMessageDialog(null, "This submenu will close now...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option! Try again");
          break;
      }
    } while(in != '0');
  }

  public List<Actor> findAllActors() {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

    CriteriaQuery<Actor> criteriaQuery = criteriaBuilder.createQuery(Actor.class);
    Root<Actor> root = criteriaQuery.from(Actor.class);

    criteriaQuery.select(root);

    TypedQuery<Actor> typedQuery = em.createQuery(criteriaQuery);

    return typedQuery.getResultList();
  }

  public List<Movie> findAllMovies() {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

    CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
    Root<Movie> root = criteriaQuery.from(Movie.class);

    criteriaQuery.select(root);

    TypedQuery<Movie> typedQuery = em.createQuery(criteriaQuery);

    return typedQuery.getResultList();
  }

  public void exerciseMenu() throws ParseException {
    String menu =
      "Choose an option:\n1 - Find movie by year\n2 - Search movie for string\n3 - Find actors by year of birth\n4 - Count movies\n5 - Get actors of movie\n6 - Get movies of actor\n7 - View Menu\n0 - Close";
    char option;
    List<String> movies;
    List<String> actors;
    StringBuilder listing;

    do {
      option = JOptionPane.showInputDialog(menu).charAt(0);
      switch (option) {
        case '1':
          int year = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert release year:"));
          movies = movieRepository.findAllByYear(year);
          listing = new StringBuilder();
          for (String movie : movies)
            listing.append(movie).append('\n');
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "No movie found!" : listing);
          break;
        case '2':
          String str = JOptionPane.showInputDialog(null, "Insert the string to search for:");
          movies = movieRepository.findAllByString(str);
          listing = new StringBuilder();
          for (String movie : movies)
            listing.append(movie).append('\n');
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "No movie found!" : listing);
          break;
        case '3':
          String birth = JOptionPane.showInputDialog(null, "Insert the year of birth to search for:");
          if (birth.length() == 4) {

            actors = actorRepository.findAllByYear(
              new SimpleDateFormat("yyyy/MM/dd").parse(birth + "/01/01"),
              new SimpleDateFormat("yyyy/MM/dd").parse(birth + "/12/31")
            );
            listing = new StringBuilder();
            for (String actor : actors)
              listing.append(actor).append('\n');
            JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "No actor found!" : listing);
          } else {
            JOptionPane.showMessageDialog(null, "No actor found!");
          }
          break;
        case '4':
          JOptionPane.showMessageDialog(null, "At this moment, we have " + movieRepository.countMovies() + " movies registered!");
          break;
        case '5':
          Integer mId = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert movie ID:"));
          List<Actor> actorsList = movieRepository.findAllActors(mId);
          listing = new StringBuilder();
          for (Actor actor : actorsList)
            if (actor != null) listing.append(actor.getName()).append('\n');
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "No actor found!" : listing);
          break;
        case '6':
          Integer aId = Integer.parseInt(JOptionPane.showInputDialog(null, "Insert actor ID:"));
          List<Movie> moviesList = actorRepository.findAllMovies(aId);
          listing = new StringBuilder();
          for (Movie movie : moviesList)
            if (movie != null) listing.append(movie.getTitle()).append('\n');
          JOptionPane.showMessageDialog(null, listing.length() == 0 || listing == null ? "No movie found!" : listing);
          break;
        case '7':
          viewMenu();
          break;
        case '0':
          JOptionPane.showMessageDialog(null, "This menu will close...");
          break;
        default:
          JOptionPane.showMessageDialog(null, "Invalid option! Try again");
          break;
      }
    } while (option != '0');
  }

  @Override
  public void run(String... args) throws Exception {
    // String menu = "What do you want to do?\n1 - Insert\n2 - Update\n3 - Delete\n4 - View\n5 - Exercise\n0 - Close";
    // char option;

    // do {
    //   option = JOptionPane.showInputDialog(menu).charAt(0);
    //   switch (option) {
    //     case '1': insertMenu(); break;
    //     case '2': updateMenu(); break;
    //     case '3': deleteMenu(); break;
    //     case '4': viewMenu(); break;
    //     case '5': exerciseMenu(); break;
    //     case '0':
    //       JOptionPane.showMessageDialog(null, "This app will close now...");
    //       break;
    //     default:
    //       JOptionPane.showMessageDialog(null, "Invalid option! Try again");
    //       break;
    //   }
    // } while (option != '0');

    exerciseMenu();
  }

}
