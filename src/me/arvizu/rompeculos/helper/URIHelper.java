///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.helper;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public final class URIHelper
{
    public static String readContent(final URI uri) throws IOException {
        final StringBuilder content = new StringBuilder();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            content.append(currentLine);
        }
        reader.close();
        return content.toString();
    }
    
    private URIHelper() {
    }
}
