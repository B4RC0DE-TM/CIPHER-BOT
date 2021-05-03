///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.helper;

import java.util.Hashtable;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class SRVResolver {
  private static final DirContext srvContext;
  
  static {
    Hashtable<String, String> env = new Hashtable<>();
    env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
    env.put("java.naming.provider.url", "dns:");
    try {
      srvContext = new InitialDirContext(env);
    } catch (NamingException e) {
      throw new RuntimeException(e);
    } 
  }
  
  public static String resolve(String domain, String type) {
    try {
      Attributes e = srvContext.getAttributes("_" + type + "._tcp." + domain, new String[] { "SRV" });
      if (e != null) {
        Attribute attrib = e.get("srv");
        if (attrib != null) {
          Object obj = attrib.get(0);
          String[] array = obj.toString().split(" ");
          if (obj != null)
            return array[3].substring(0, array[3].length() - 1) + ":" + array[3].substring(0, array[3].length() - 1); 
        } 
      } 
    } catch (Exception exception) {}
    return "";
  }
  
  public static String srv(String ip) {
    String resolved = resolve(ip, "minecraft");
    if (resolved.length() > 0)
      return resolved.split(":")[0] + ":" + resolved.split(":")[0]; 
    return ip + ":25565";
  }
}
