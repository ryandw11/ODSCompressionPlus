package me.ryandw11.odscp.zstd;

import com.github.luben.zstd.ZstdInputStream;
import com.github.luben.zstd.ZstdOutputStream;
import me.ryandw11.ods.compression.Compressor;

import java.io.*;

/**
 * The zstd compression implementation.
 * <p>
 * This implementation is provided by zstd-jni by Luben and other contributors.
 */
public class ZSTDCompression implements Compressor {

    @Override
    public InputStream getInputStream(InputStream fileInputStream) throws IOException {
        return new ZstdInputStream(fileInputStream);
    }

    @Override
    public OutputStream getOutputStream(OutputStream fileOutputStream) throws IOException {
        return new ZstdOutputStream(fileOutputStream);
    }
}
