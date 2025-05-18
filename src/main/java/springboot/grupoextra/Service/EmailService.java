package springboot.grupoextra.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmailFeedback(String emailDestino) {
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(emailDestino);
        mensagem.setSubject("Feedback Recebido - Obrigado!");
        mensagem.setText("Olá!\n\n" +
                        "Agradecemos por dedicar seu tempo para nos dar seu feedback. " +
                        "Sua opinião é muito importante para continuarmos melhorando nossos produtos e serviços.\n\n" +
                        "Atenciosamente,\n" +
                        "Equipe Lily Shoes");

        emailSender.send(mensagem);
        System.out.println("Email enviado com sucesso para: " + emailDestino);
    }
}
