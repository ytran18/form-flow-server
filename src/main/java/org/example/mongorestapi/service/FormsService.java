package org.example.mongorestapi.service;

import org.example.mongorestapi.collection.Forms;
import org.example.mongorestapi.dto.master.FormsDto;

public interface FormsService {

    Object getForms();
    Object getFormById(String formId);
    void addForm(Forms form);
    void updateForm(String id, Forms form);
    void deleteForm(String id);
    void renameForm(String id, String name);
    void cloneForm(String id);

}
