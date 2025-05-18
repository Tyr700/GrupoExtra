package springboot.grupoextra.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.grupoextra.model.FeedBackModel;
import springboot.grupoextra.repository.FeedBackRepository;

@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepository feedbackRepository;
    
    public FeedBackModel criarFeedback(FeedBackModel feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<FeedBackModel> listarFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<FeedBackModel> buscarFeedbackPorId(Long id) {
        return feedbackRepository.findById(id);
    }
}
