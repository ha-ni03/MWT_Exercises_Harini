package de.hft.stuttgart.helloworld3.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import java.time.Instant;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/time")
public class TellTheTimeNow
{
    @RequestMapping("/now")
    public static String TellTheTimeNow() {
        return Instant.now().toString();
    }

    @RequestMapping("/jetzt")
    public static String Jetzt() {
        return Instant.now().toString();
    }
}
