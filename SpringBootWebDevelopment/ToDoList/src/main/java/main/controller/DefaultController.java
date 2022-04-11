package main.controller;

import main.model.Thing;
import main.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Controller
public class DefaultController {

//    @RequestMapping("/")
//
//    public String index(){
//        return "index";
//    }



    @Autowired
   private ThingRepository thingRepository;

    @Value("${someParameter.value}")
    private Integer someParameter;

    public DefaultController() {
    }

    @RequestMapping("/")
    public String index(Model model){

        Iterable<Thing> thingIterable = thingRepository.findAll();
        ArrayList<Thing> thingArrayList = new ArrayList<>();
        for(Thing thing: thingIterable){
            thingArrayList.add(thing);
        }

        model.addAttribute("things",thingArrayList);
        model.addAttribute("thingCount", thingArrayList.size());
        model.addAttribute("someParameter", someParameter);
        return "index";
    }
}
