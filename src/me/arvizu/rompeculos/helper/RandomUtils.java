///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.helper;

import java.util.Random;

public final class RandomUtils
{
    public static int nextInt(final int startInclusive, final int endExclusive) {
        return (endExclusive - startInclusive <= 0) ? startInclusive : (startInclusive + new Random().nextInt(endExclusive - startInclusive));
    }
    
    public static double nextDouble(final double startInclusive, final double endInclusive) {
        return (startInclusive != endInclusive && endInclusive - startInclusive > 0.0) ? (startInclusive + (endInclusive - startInclusive) * Math.random()) : startInclusive;
    }
    
    public static float nextFloat(final float startInclusive, final float endInclusive) {
        return (startInclusive != endInclusive && endInclusive - startInclusive > 0.0f) ? ((float)(startInclusive + (endInclusive - startInclusive) * Math.random())) : startInclusive;
    }
    
    public static String randomNumber(final int length) {
        return random(length, "123456789");
    }
    
    public static String randomString(final int length) {
        return random(length, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    }
    
    public static String random(final int length, final String chars) {
        return random(length, chars.toCharArray());
    }
    
    public static String random(final int length, final char[] chars) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            stringBuilder.append(chars[new Random().nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }
    
    public static int randInt(final int min, final int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
}
