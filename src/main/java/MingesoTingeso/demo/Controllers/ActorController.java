package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Actor;
import MingesoTingeso.demo.Models.Film;

import MingesoTingeso.demo.Repositories.ActorRepository;
import MingesoTingeso.demo.Repositories.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

import java.text.ParseException;

import java.util.Date;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private FilmRepository filmRepository;

    /**
    * @brief This GET service returns all the actors in the db. To use, access with the route /actors
    *
    * @return A list with the actors found on the db.
    */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    /**
    * @brief This GET service returns a specific actor on the db. To use, access with route /actors/{id}
    *
    * @param id Long integer given on the route. Represents the ID of the actor on the DB.
    *
    * @return the actor with the given id.
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Actor getActorById(@PathVariable Long id) {
        return actorRepository.findActorById(id);
    }

    /**
    * @brief this GET service returns all the movies of an specific actor. To use, access with the route /actors/{id}/films
    * 
    * @param id Long integer given on the route. Represents the ID of the actor on the DB.
    *
    * @return the list with the films linked to the actor with the given id.
    *
    */
    @RequestMapping(value = "/{id}/films", method = RequestMethod.GET)
    @ResponseBody
    public Set<Film> moviesOfTheActor (@PathVariable("id") Long id) {
        return actorRepository.findActorById(id).getFilms();
    }

    /**
    * @brief this POST service set a specific movie to a specific actor, both with their given ID's. To use, 
    *        access with the route /actors/{id}/films/{idFilms}.
    *
    * @param id Long integer given on the route. Represents the ID of the actor on the DB.
    * @param idFilms Long integer given on the route. Represents the ID of the film on the DB to link.
    *
    * @return "OK" if the film where correctly linked to the actor. "NOT_ACCEPTABLE" if the actor or the film given 
    *          doesn't exists on the DB. 
    *
    */
    @PostMapping("/{id}/films/{idFilms}")
    @ResponseBody
    public HttpStatus linkFilmToActor (@PathVariable("id") Long id, @PathVariable("idFilms") Long idFilms) {

        Actor actor = actorRepository.findActorById(id);
        Film film = filmRepository.findFilmsById(idFilms);
        if ( film != null && actor != null ) {
            actor.getFilms().add(film);
            film.getActors().add(actor);
            actorRepository.save(actor);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;
    }

    /**
    * @brief This POST service creates a new actor on the DB. To use, access with the route /actors/create. Tested sending a json.
    *
    * @param resource json with the fillables attributes of an actor (firstName and lastName).
    *
    * @return created actor.
    *
    */
    @PostMapping("/create")
    @ResponseBody
    public Actor create(@RequestBody Actor resource) throws ParseException {
        Date date = new Date();
        long time = date.getTime();
        new Timestamp(time);
        resource.setLastUpdate(new Timestamp(time));
        return actorRepository.save(resource);
    }
}