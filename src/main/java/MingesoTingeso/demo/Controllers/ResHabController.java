package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MingesoTingeso.demo.Models.ReservaHabitacion;
import MingesoTingeso.demo.Repositories.ResHabRepository;

//Evaluacion 07-mayo-2019

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
public class ResHabController {
	@Autowired
	ResHabRepository reshabRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ReservaHabitacion> getAllReservas() {
        return reshabRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
      @ResponseBody
      public ReservaHabitacion getReservasHabitacionesById(@PathVariable Long id) {
          return reshabRepository.findReservaHabitacionById(id);
      }


}
