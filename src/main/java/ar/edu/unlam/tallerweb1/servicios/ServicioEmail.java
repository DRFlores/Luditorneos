package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Mail;

@Service
public class ServicioEmail {

    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(Mail mail){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(mail.getAsunto());
        message.setText(mail.getContenido());
        message.setTo(mail.getPara());
        message.setFrom(mail.getDesde());

        emailSender.send(message);
    }
}
