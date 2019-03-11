package mum.edu.survey;

import mum.edu.survey.service.AdminAction;
import mum.edu.survey.service.SurveyService;
import mum.edu.survey.config.AuthenticationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;
import java.io.*;

@Controller
public class IndexController extends AuthenticationInfo {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private SurveyService surveyService;

    @Autowired
    public IndexController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping("/")
    public String index(Model model) {

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        if (!checkUserLogged()) {
            model.addAttribute("loggedornot", "netvreegui bna!");
            return "admin";
        } else {
            return "adminIndex";
        }
    }

    @PostMapping("/upload")
    public String uploadSimple(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        AdminAction actions = new AdminAction();
        String msg = actions.readCSV(file);
        surveyService.saveOrUpdateSurvey(actions.saveData());
        model.addAttribute("error", msg);
        return "adminIndex";
    }

    @RequestMapping(value = "/logged", method = RequestMethod.GET)
    public String logged (Model model) {
        if (!checkUserLogged()) {
            model.addAttribute("messages", "Nevtereegui bna");
            return "admin";
        }

        model.addAttribute("messages", "name: " + getUserName() + " : SessionID : " + getSessionID());
        return "adminIndex";
    }
}
