package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Mail;
import ar.edu.unlam.tallerweb1.servicios.ServicioEmail;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class ControladorEmail {

    @Inject
    private ServicioEmail servicioEmail;

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public ModelAndView sendMail () {

        Mail mail = new Mail();
        mail.setTo("pds.gomez@gmail.com");
        mail.setContent("pablo test");
        mail.setSubject("pablo test");
        servicioEmail.sendSimpleMessage(mail);
        return new ModelAndView("mail/succesful");
    }

}
