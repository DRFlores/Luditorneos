package ar.edu.unlam.tallerweb1.controladores;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Sala;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;

@Controller
public class ControladorTorneo {
	@Inject
	private ServicioTorneo servicioTorneo;

	@RequestMapping(path = "/torneo/{id}", method = RequestMethod.GET)
	public ModelAndView verDetalleDeTorneo(@PathVariable("id") String id, HttpServletRequest request) {

		Torneo torneoBuscado = servicioTorneo.consultarTorneoPorId(Long.parseLong(id));
		Set<Usuario> usuarios = torneoBuscado.getUsuarios();
		HttpSession session = request.getSession();
		Usuario user = (Usuario) session.getAttribute("USER");
		ModelMap model = new ModelMap();

		if (usuarios != null) {
			model.put("usuarios", usuarios);
		}

		if (usuarios.contains(user)) {
			model.put("existeUsuario", true);
		} else {
			model.put("existeUsuario", false);
		}

		if (torneoBuscado != null) {
			
			model.put("torneo", torneoBuscado);
			
			Sala sala = servicioTorneo.consultarSala(torneoBuscado);
			if(sala != null) {
				model.put("sala", sala.getLinkDeLaSala());
			}

		} else {			
			model.put("error", "Torneo no encontrado!");
		}
		
		return new ModelAndView("torneo/publicacion",model);
	}
	
	@RequestMapping(path = {"/torneo","/torneos"}, method = RequestMethod.GET)
	public ModelAndView verProximosTorneos() {
		
		List<Torneo> proximosTorneos = servicioTorneo.consultarProximosTorneos();
		
		ModelMap model = new ModelMap();

		if (!proximosTorneos.isEmpty()) {				
			model.put("torneos", proximosTorneos);
		} else {
			model.put("error", "Lo sentimos! No hay torneos disponibles...");
		}
		
		return new ModelAndView("torneo/proximos-torneos",model);
	}

}
