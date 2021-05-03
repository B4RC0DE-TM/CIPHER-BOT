///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import me.arvizu.rompeculos.option.Options;

public class RompeCulosLauncher {
  public static void main(String... args) throws IOException {
    final RompeCulos breaker = new RompeCulos(Options.Builder.of(args));
        breaker.launch();
    }
}
    
    
