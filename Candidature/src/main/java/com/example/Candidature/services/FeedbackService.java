package com.example.Candidature.services;

import com.example.Candidature.client.DataFeedback;
import com.example.Candidature.model.Feedback;
import com.netflix.appinfo.ApplicationInfoManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FeedbackService {

    private DataFeedback client;

    public List<Feedback> getAllFeedbacks() {
        return client.findAll();
    }

    public Optional<Feedback> getById(long id) {
        return client.findById(id);
    }

    public Feedback save(Feedback feedback) {
        return client.save(feedback,feedback.getEntreprise().getId());
    }

    public void delete(long id) {
        client.deleteById(id);
    }
}
