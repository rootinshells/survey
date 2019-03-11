package com.hellokoding.springboot.service;

import com.hellokoding.springboot.model.Survey;

import java.util.List;

public interface SurveyService {

    public List getAllSurveys();

    public Survey getSurveyById(Long id);

    public boolean saveOrUpdateSurvey(Survey survey);

    public boolean deleteSurveyById(Long id);

}