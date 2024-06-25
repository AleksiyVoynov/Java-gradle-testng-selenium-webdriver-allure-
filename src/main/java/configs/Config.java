package configs;

import configs.browsers.Browser;
import configs.browsers.Firefox;

public class Config {
    /**
     * Example for Chrome:
     * * public Browser browser = new Chrome();
     * or
     * Example for Safari:
     * public Browser browser = new Safari();
     * or
     * Example for Firefox:
     * public Browser browser = new Firefox();
     */

    public static Browser browser = new Firefox();
}