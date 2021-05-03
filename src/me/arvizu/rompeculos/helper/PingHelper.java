///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.helper;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class PingHelper {
  public static void testPing(InetSocketAddress address, String host, int port) {
    try {
      Socket socket = new Socket();
      System.out.println("Connecting...");
      socket.connect(address, 3000);
      System.out.println("Done!");
      DataOutputStream output = new DataOutputStream(socket.getOutputStream());
      DataInputStream input = new DataInputStream(socket.getInputStream());
      System.out.println("connecting to database: www.cipher-bot.me");
      System.out.println("Trying & sending Hanshake... " + address.toString());
      System.out.println("");
    } catch (Exception exception) {}
  }
}
