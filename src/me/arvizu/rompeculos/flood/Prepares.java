///Created by Daniel.Arvizu.Rosselli ///
// Free Use | No Licence //
// Made For Educational Purposes | Enjoy :D //

package me.arvizu.rompeculos.flood;

import java.io.IOException;
import org.apache.commons.lang3.ArrayUtils;
import java.nio.charset.StandardCharsets;
import me.arvizu.rompeculos.helper.VarHelper;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

public class Prepares
{
    private static byte[] loginPreparedBytes;
    private static byte[] motdPreparedBytes;
    private static byte[] legacy_motdPrepradBytes;
    
    public static byte[] getLoginPreparedBytes() {
        return Prepares.loginPreparedBytes;
    }
    
    public static byte[] getMotdPreparedBytes() {
        return Prepares.motdPreparedBytes;
    }
    
    public static byte[] getLegacy_motdPrepradBytes() {
        return Prepares.legacy_motdPrepradBytes;
    }
    
    public static void loadUniversalLoginBytes(final int protocol, final byte nickname_sizes) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            DataOutputStream output = new DataOutputStream(buffer);
            output.writeByte(0);
            VarHelper.writeVarInt(output, protocol);
            VarHelper.writeString(output, "localhost", StandardCharsets.UTF_8);
            output.writeShort(25565);
            VarHelper.writeVarInt(output, 2);
            final byte[] handshake_data = buffer.toByteArray();
            buffer = new ByteArrayOutputStream();
            output = new DataOutputStream(buffer);
            VarHelper.writeVarInt(output, handshake_data.length);
            final byte[] handshake_length = buffer.toByteArray();
            final byte[] handshakePacket = ArrayUtils.addAll(handshake_length, handshake_data);
            final byte[] loginStart_pre_data = { (byte)(nickname_sizes + 2), 0, nickname_sizes };
            Prepares.loginPreparedBytes = ArrayUtils.addAll(handshakePacket, loginStart_pre_data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadUniversalMotdBytes(final int protocol) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            DataOutputStream output = new DataOutputStream(buffer);
            output.writeByte(0);
            VarHelper.writeVarInt(output, protocol);
            VarHelper.writeString(output, "localhost", StandardCharsets.UTF_8);
            output.writeShort(25565);
            VarHelper.writeVarInt(output, 1);
            final byte[] handshake_data = buffer.toByteArray();
            buffer = new ByteArrayOutputStream();
            output = new DataOutputStream(buffer);
            VarHelper.writeVarInt(output, handshake_data.length);
            final byte[] handshake_length = buffer.toByteArray();
            final byte[] handshakePacket = ArrayUtils.addAll(handshake_length, handshake_data);
            final byte[] motdPacket = { 1, 0 };
            Prepares.motdPreparedBytes = ArrayUtils.addAll(handshakePacket, motdPacket);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void loadUniversalLegacyMotdBytes(final int protocol) {
        try {
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            DataOutputStream output = new DataOutputStream(buffer);
            output.writeByte(0);
            VarHelper.writeVarInt(output, protocol);
            VarHelper.writeString(output, "localhost", StandardCharsets.UTF_8);
            output.writeShort(25565);
            VarHelper.writeVarInt(output, 1);
            final byte[] handshake_data = buffer.toByteArray();
            buffer = new ByteArrayOutputStream();
            output = new DataOutputStream(buffer);
            VarHelper.writeVarInt(output, handshake_data.length);
            final byte[] handshake_length = buffer.toByteArray();
            final byte[] handshakePacket = ArrayUtils.addAll(handshake_length, handshake_data);
            buffer = new ByteArrayOutputStream();
            output = new DataOutputStream(buffer);
            output.write(new byte[] { -2, 1 });
            final byte[] motdRequest = buffer.toByteArray();
            final byte[] motdRequest_length = { (byte)motdRequest.length };
            final byte[] motdPacket = ArrayUtils.addAll(motdRequest_length, motdRequest);
            Prepares.legacy_motdPrepradBytes = ArrayUtils.addAll(handshakePacket, motdPacket);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
