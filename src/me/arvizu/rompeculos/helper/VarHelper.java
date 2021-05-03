///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //
package me.arvizu.rompeculos.helper;

import java.io.DataInputStream;
import java.nio.charset.Charset;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

public final class VarHelper
{
    public static byte[] createHandshakeMessage(final String host, final int port) throws IOException {
        final ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        final DataOutputStream handshake = new DataOutputStream(buffer);
        handshake.writeByte(0);
        handshake.write(1000);
        writeVarInt(handshake, 47);
        writeString(handshake, host, StandardCharsets.UTF_8);
        handshake.writeShort(port);
        writeVarInt(handshake, 1);
        return buffer.toByteArray();
    }
    
    public static void writeString(final DataOutputStream out, final String string, final Charset charset) throws IOException {
        final byte[] bytes = string.getBytes(charset);
        writeVarInt(out, bytes.length);
        out.write(bytes);
    }
    
    public static void writeVarInt(final DataOutputStream out, int paramInt) throws IOException {
        while ((paramInt & 0xFFFFFF80) != 0x0) {
            out.writeByte((paramInt & 0x7F) | 0x80);
            paramInt >>>= 7;
        }
        out.writeByte(paramInt);
    }
    
    public static void writeVarInt2(final DataOutputStream out, int value) throws IOException {
        do {
            byte temp = (byte)(value & 0x7F);
            value >>>= 7;
            if (value != 0) {
                temp |= (byte)128;
            }
            out.writeByte(temp);
        } while (value != 0);
    }
    
    public static int readVarInt(final DataInputStream in) throws IOException {
        int i = 0;
        int j = 0;
        byte k;
        do {
            k = in.readByte();
            i |= (k & 0x7F) << j++ * 7;
            if (j > 5) {
                throw new RuntimeException("VarInt too big");
            }
        } while ((k & 0x80) == 0x80);
        return i;
    }
}
