package com.dabman.WebAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//this controller will be containing HTTP APIs
@RestController
//localhost:8080/sample
//All the APIs for /sample endpoint should come to this controller
@RequestMapping("/sample")
public class sampleController {
    //localhost:8080/sample/sayhello/'name'  //name = path variable
    @GetMapping("/sayhello/{name}")
    public String hi(@PathVariable("name") String name){
        return "Heylo " + name;
    }

    @GetMapping("/saybye")
    public String bye(){
        return "byebye!";
    }
}
