///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.option;

import java.util.HashMap;
import java.util.Map;

public class Options
{
    private final Map<String, Object> options;
    
    public Options() {
        this.options = new HashMap<String, Object>();
    }
    
    public boolean isOption(final String id) {
        return this.options.containsKey(id);
    }
    
    public <T> T getOption(final String id, final T defaultValue) {
        return (T)this.options.getOrDefault(id, defaultValue);
    }
    
    public Map<String, Object> getOptions() {
        return this.options;
    }
    
    public static class Builder
    {
        public static Options of(final String... args) {
            final Options options = new Options();
            for (final String arg : args) {
                final String[] part = arg.split("=");
                if (part.length > 1) {
                    Object value = part[1];
                    try {
                        value = Integer.parseInt((String)value);
                    }
                    catch (Exception ex) {}
                    Label_0114: {
                        if (!(value instanceof String) || !value.equals("true")) {
                            if (!value.equals("false")) {
                                break Label_0114;
                            }
                        }
                        try {
                            value = Boolean.parseBoolean((String)value);
                        }
                        catch (Exception ex2) {}
                    }
                    options.options.put(part[0].replace("=", ""), value);
                }
            }
            return options;
        }
    }
}
