package pe.edu.upn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.model.entity.Consumidor;
import pe.edu.upn.model.entity.Menu;
import pe.edu.upn.model.entity.Plato;
import pe.edu.upn.model.entity.Reserva;
import pe.edu.upn.service.ConsumidorService;
import pe.edu.upn.service.ReservaService;

@Controller
@RequestMapping("/consumidor")
@SessionAttributes( {"consumidor", "reserva"} )
public class ConsumidorController {
	@Autowired
	private ConsumidorService consumidorService;
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping
public String inicio(Model model) {
	try {
		List<Consumidor> consumidores = consumidorService.findAll();
		model.addAttribute("consumidores", consumidores);
	} catch (Exception e) {
		// TODO: handle exception
	}
	return "/consumidor/inicio";
}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
			Consumidor consumidor = new Consumidor();
		model.addAttribute("consumidor",consumidor);
		
		return "/consumidor/nuevo";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("consumidor") Consumidor consumidor, 
			Model model, SessionStatus status) {
		try {
			consumidorService.save(consumidor);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/consumidor";
	}	
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Consumidor> consumidor = consumidorService.findById(id);
			if(consumidor.isPresent()) {
				model.addAttribute("consumidor", consumidor.get());
			} else {
				return "redirect:/consumidor";
			}
		} catch (Exception e) {

		}	
		
		return "/consumidor/info";
	}
	@GetMapping("/{id}/nuevoreserva")
	public String nuevoReserva(@PathVariable("id") int id, Model model) {
		Reserva reserva = new Reserva();
		try {
			Optional<Consumidor> consumidor = consumidorService.findById(id);
			if(consumidor.isPresent()) {
				reserva.setConsumidor(consumidor.get());
				model.addAttribute("reserva", reserva);
			} else {
				return "redirect:/consumidor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/consumidor/nuevoreserva";
	}
	@PostMapping("/savereserva")
	public String saveReserva(@ModelAttribute("reserva") Reserva reserva,
			Model model, SessionStatus status) {
		try {
			reservaService.save(reserva);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/consumidor/info/" + reserva.getConsumidor().getConsumidorCod();
	}
}
