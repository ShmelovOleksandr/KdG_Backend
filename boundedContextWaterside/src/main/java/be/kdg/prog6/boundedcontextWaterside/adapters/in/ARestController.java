package be.kdg.prog6.boundedcontextA.adapters.in;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ARestController {


    @GetMapping("/helloa")
    public void sayHelloA(){
        System.out.println("Hello BoundedContext A");
    }

}
