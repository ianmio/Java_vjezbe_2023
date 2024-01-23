package controllers;


import entities.DeviceMeasure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;


@Controller
public class DeviceMeasureController {
    @Autowired
    RestTemplate restTemplate=new RestTemplate();

    @GetMapping("/measures")
    public String showMeasures(Model model) {
        DeviceMeasure[] response=restTemplate.getForObject("http://localhost:8082/listmeasures/",DeviceMeasure[].class);
        for (DeviceMeasure m:response) {
            System.out.println(m);
        }
        model.addAttribute("measures", response);
        return "frontpage";
    }

    @GetMapping("/addmeasure")
    public String showNewMeasureForm(Model model) {
        var measure=new DeviceMeasure();
        model.addAttribute("measure",measure);
        return "newmeasure";
    }

}
