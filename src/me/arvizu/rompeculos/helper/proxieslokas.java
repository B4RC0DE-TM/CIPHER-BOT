///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //

package me.arvizu.rompeculos.helper;

import java.nio.channels.ReadableByteChannel;
import java.io.FileOutputStream;
import java.nio.channels.Channels;
import java.net.URL;
import me.arvizu.rompeculos.proxy.Proxies;

public class proxieslokas
{
    public static void downloadFile(final Proxies proxies) {
        try {
            final URL website = new URL("https://api.proxyscrape.com/?request=getproxies&proxytype=socks4&timeout=500&country=all&anonymity=elite&ssl=yes");
            final ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            final FileOutputStream fos = new FileOutputStream("cipher-bot.txt");
            fos.getChannel().transferFrom(rbc, 0L, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        }
        catch (Exception ex) {}
    }
}
