package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mail;
import ar.edu.unlam.tallerweb1.modelo.Torneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioTorneo;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import org.springframework.web.bind.annotation.ModelAttribute;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ControladorEmail {

    @Inject
    private ServicioEmail servicioEmail;

    @Inject
    private ServicioTorneo servicioTorneo;

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public ModelAndView sendMail (@ModelAttribute("torneo") Torneo torneo, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("USER");
        String rol = session.getAttribute("ROL").toString();

        Torneo t = servicioTorneo.consultarTorneoPorId(torneo.getId());

        if (rol != "ORGANIZADOR") {
            Mail mail = new Mail();
            mail.setPara(userName);
            mail.setContenido("Te anotaste para jugar: " + t.getJuego().getDescripcion() + " el día " + t.getFechaDDMMAAAA()
                    + " a las " + t.getHorarioHHss() + "." );
            mail.setAsunto("Te anotaste exitosamente para jugar: " + t.getJuego().getDescripcion());
            servicioEmail.sendSimpleMessage(mail);
        }

        return new ModelAndView("mail/succesful");
    }

}
