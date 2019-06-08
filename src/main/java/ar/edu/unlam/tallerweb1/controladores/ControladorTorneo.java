package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTorneo {
	@Inject
	private ServicioTorneo servicioTorneo;
	/*
	@RequestMapping(path = "/torneo", method = RequestMethod.GET)
	public ModelAndView irAHome() {
		return new ModelAndView("torneo/publicacion");
	}
	*/
	@RequestMapping(path = "/torneo/{id}", method = RequestMethod.GET)
	public ModelAndView irAHome(@PathVariable("id") String id) {
		Torneo torneoBuscado = servicioTorneo.consultarTorneoPorId(Long.parseLong(id));
		
		ModelMap model = new ModelMap();

		if (torneoBuscado != null) {
			Usuario organizador = torneoBuscado.getOrganizador();
			Sala sala = servicioTorneo.consultarSala(torneoBuscado);
			if(sala != null) {
				String link = sala.getLinkDeLaSala();
				model.put("sala", link);
			}
			
			model.put("organizador", organizador);
			model.put("torneo", torneoBuscado);
			model.put("horario",torneoBuscado.getHorarioHHss());
			model.put("fecha", torneoBuscado.getFechaDDMMAAAA());
		} else {
			model.put("error", "Torneo no encontrado!");
		}
		
		return new ModelAndView("torneo/publicacion",model);
	}

}
