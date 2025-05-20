package springboot.grupoextra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.grupoextra.Service.EmailService;
import springboot.grupoextra.Service.FeedBackService;
import springboot.grupoextra.model.FeedBackModel;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedbackService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/feedback")
    public ResponseEntity<FeedBackModel> criarFeedback(@RequestBody FeedBackModel feedback) {
        try {
            FeedBackModel novoFeedback = feedbackService.criarFeedback(feedback);
            emailService.enviarEmailFeedback(feedback.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).body(novoFeedback);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/")
    public ResponseEntity<String> receberFeedback(@RequestBody FeedBackModel feedback) {
        try {
            emailService.enviarEmailFeedback(feedback.getEmail());
            return ResponseEntity.ok("Feedback recebido com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao processar feedback: " + e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FeedBackModel>> listarFeedbacks() {
        List<FeedBackModel> feedbacks = feedbackService.listarFeedbacks();
        return ResponseEntity.ok(feedbacks);
    }
    
    
    
    
    

}
