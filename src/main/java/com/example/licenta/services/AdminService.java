package com.example.licenta.services;

import com.example.licenta.entities.SubjectEntity;
import com.example.licenta.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public AdminService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void addSubject(SubjectEntity subject) {
        subjectRepository.save(subject);
    }
}
