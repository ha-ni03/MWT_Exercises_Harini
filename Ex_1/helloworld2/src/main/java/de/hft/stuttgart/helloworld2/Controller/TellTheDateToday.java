package de.hft.stuttgart.helloworld2.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;

@RestController
@RequestMapping("/date")
public class TellTheDateToday
{
    String ReturnString;
    @RequestMapping("/today")
    public String TellTheDateToday() {
        this.ReturnString =  LocalDate.now().toString();
        return this.ReturnString;
    }

    @RequestMapping("/heute")
    public String HeutigesDatum() {
        this.ReturnString =  LocalDate.now().toString();
        return this.ReturnString;
    }


}
