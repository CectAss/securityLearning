package Cectus4.controllers;

import Cectus4.model.Application;
import Cectus4.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class AppController {
   private AppService appService;

   @GetMapping
   public String welcome(){
       return "Welcome to the YOUR APP!";
   }

   @GetMapping("/all-apps")
   public List<Application> getAllApps(){
       return appService.getApps();
   }

   @GetMapping("/{id}")
   public Application getAppById(@PathVariable int id){
       return appService.getAppById(id);
   }

}
