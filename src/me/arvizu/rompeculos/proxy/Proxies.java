///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //

package me.arvizu.rompeculos.proxy;

import java.util.Objects;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.net.Proxy;
import java.util.List;

public class Proxies
{
    private final List<Proxy> proxies;
    private int index;
    
    public Proxies() {
        this.proxies = new ArrayList<Proxy>();
        this.index = 0;
    }
    
    public void init(final String fileName, final Proxy.Type type) throws IOException {
        final File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        final Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(" ")) {
                line = line.replace(" ", "");
            }
            if (!line.isEmpty() && !line.startsWith("##")) {
                if (!line.contains(":")) {
                    continue;
                }
                final String[] ip = line.split(":");
                if (ip.length < 1) {
                    return;
                }
                final String hostname = ip[0];
                int port = 80;
                try {
                    port = Integer.parseInt(ip[1]);
                }
                catch (NumberFormatException ex) {}
                final Proxy proxy = new Proxy(type, new InetSocketAddress(hostname, port));
                this.proxies.add(proxy);
            }
        }
    }
    
    public int size() {
        return this.proxies.size();
    }
    
    public Proxy nextProxy() {
        if (this.proxies.size() == 0) {
            return Proxy.NO_PROXY;
        }
        if (this.index >= this.proxies.size()) {
            this.index = 0;
        }
        return Objects.requireNonNull(this.proxies.get(this.index++));
    }
    
    public void removeProxy(final Proxy proxy) {
        this.proxies.remove(proxy);
    }
}
