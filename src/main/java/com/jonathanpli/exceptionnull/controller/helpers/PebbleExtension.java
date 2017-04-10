package com.jonathanpli.exceptionnull.controller.helpers;

import com.mitchellbosecke.pebble.extension.AbstractExtension;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by Jonathan on 4/9/17.
 */
public class PebbleExtension extends AbstractExtension {
    private Map<String, Object> globals;

    public PebbleExtension() {
        globals = new HashMap<>();
    }

    @Override
    public Map<String, Object> getGlobalVariables() {
        globals.put("paths", getPaths());
        return globals;
    }

    private String[][] getPaths() {
        String[][] paths = {
            { "/", "Home" },
            { "/arena", "Arena" }
        };

        return paths;
    }
}
