package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Actor;
import MingesoTingeso.demo.Models.Film;

import MingesoTingeso.demo.Repositories.ActorRepository;
import MingesoTingeso.demo.Repositories.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActorRepository actorRepository;

    /**
    * @brief This GET service returns all the films in the db. To use, access with the route /films
    *
    * @return A list with the films found on the db.
    */    
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }


    /**
    * @brief This GET service returns all the actors who participate on a specific movie. 
    *        To use, access with route /films/{id}/actors
    *
    * @param id Long integer given on the route. Represents the ID of the film on the DB.
    *
    * @return the actors of the film with the given id.
    */
    @GetMapping("{id}/actors")
    @ResponseBody
    public Set<Actor> actorsOnTheMovie (@PathVariable("id") Long id){
        return  filmRepository.findFilmsById(id).getActors();

    }

    /**
    * @brief this POST service set a specific actor to a specific film, both with their given ID's. To use, 
    *        access with the route /films/{idFilm}/actors/{idActor}.
    *
    * @param idFilm Long integer given on the route. Represents the ID of the film on the DB.
    * @param idActor Long integer given on the route. Represents the ID of the actor on the DB to link.
    *
    * @return "OK" if the actor where correctly linked to the film. "NOT_ACCEPTABLE" if the film or the actor given 
    *          doesn't exists on the DB. 
    *
    */
    @PostMapping("{idFilm}/actors/{idActor}")
    @ResponseBody
    public HttpStatus linkActorToFilm(@PathVariable("idFilm") Long idFilm, @PathVariable("idActor") Long  idActor){
        Actor actor = actorRepository.findActorById(idActor);
        Film film = filmRepository.findFilmsById(idFilm);
        if(actor != null && film != null){
            film.getActors().add(actor);
            actor.getFilms().add(film);
            filmRepository.save(film);
            return HttpStatus.OK;
        }
        else
            return HttpStatus.NOT_ACCEPTABLE;

    }

    /**
    * @brief This POST service creates a new film on the DB. To use, access with the route /films/create. Tested sending a json.
    *
    * @param resource json with the fillables attributes of a film (title).
    *
    * @return created film.
    *
    */
    @PostMapping("/create")
    @ResponseBody
    public Film create(@RequestBody Film resource)  {

        return filmRepository.save(resource);
    }


}