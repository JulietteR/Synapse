package fr.synapsegaming.statistiques.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.statistiques.service.StatistiquesService;
import fr.synapsegaming.ui.service.ResourceService;


/**
 * <b>HomeController</b> route every action made from the "Home" page
 * 
 * @author notMeidi
 * 
 */
@Controller("StatistiquesController")
@SessionAttributes(value = { "resources", "userResources" })
@RequestMapping("/stats")
public class StatistiquesController extends AbstractController {

	@Autowired
	ResourceService resourceService;
	
	@Autowired
	StatistiquesService statistiquesService;
   
    /**
     * The default constructor to initialize the page
     * 
     * 
     *            : the HttpRequest sent
     * @return modelAndView
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        page = new ModelAndView();
        page.setViewName("Statistiques");
        page.addObject("resources", resourceService.listMainMenu());
        if (user != null)
            page.addObject("userResources", resourceService.listUserResources(user.getGroup().getId()));
            page.addObject("fiveMostPlayedClasses", statistiquesService.listFiveClassesMostPlayed());
            page.addObject("fiveMostPlayedRaces", statistiquesService.listFiveRacesMostPlayed());
            page.addObject("usersWithDefaultAvatar", statistiquesService.listUsersDefaultAvatar());
        return page;
    }


}
