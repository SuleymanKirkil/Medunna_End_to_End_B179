package hooks;

import basurls.MedunnaBaseUrl;
import io.cucumber.java.Before;

import static basurls.MedunnaBaseUrl.setUp;

public class Hooks {

    @Before("@api")
    public static void beforeApi(){
        setUp();
    }
}
