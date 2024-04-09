package org.example.mongorestapi.service.impl;

import org.example.mongorestapi.collection.Forms;
import org.example.mongorestapi.repository.FormsRepository;
import org.example.mongorestapi.service.FormsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class FormsServiceImpl implements FormsService {

    @Autowired
    private FormsRepository formsRepository;
    private MongoTemplate mongoTemplate;

    @Override
    public Object getForms() {
        return formsRepository.findAll();
    };

    @Override
    public void addForm(Forms form) {
        formsRepository.save(form);
    };

    @Override
    public void updateForm(String id, Forms form) {
        formsRepository.save(form);
    };

    @Override
    public Object getFormById(String id) {
        return formsRepository.findById(id);
    };

    @Override
    public void deleteForm(String id) {
        formsRepository.deleteById(id);
    };

}
