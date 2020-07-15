package tacos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  기능이 없어서 WebConfig로 생성함
 */
@Deprecated
//@Controller
public class HomeController {

    //@GetMapping("/")
    public String home() {
        return "home";
    }
}
