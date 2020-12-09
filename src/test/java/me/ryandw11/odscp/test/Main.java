package me.ryandw11.odscp.test;

import com.github.luben.zstd.ZstdInputStream;
import com.github.luben.zstd.ZstdOutputStream;
import me.ryandw11.ods.ODS;
import me.ryandw11.ods.ObjectDataStructure;
import me.ryandw11.ods.compression.NoCompression;
import me.ryandw11.ods.tags.StringTag;
import me.ryandw11.odscp.zstd.ZSTDCompression;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // Test lots of data.
        ObjectDataStructure ods = new ObjectDataStructure(new File("test.ods"), new ZSTDCompression());
        List<StringTag> data = new ArrayList<>();
        for(int i = 0; i < 200; i ++){
            data.add(new StringTag(i + "test", "This is a test!" + i));
        }

        ods.save(data);

        StringTag jeff = ods.get("3test");
        System.out.println(jeff.getValue());

        // The the output stream itself.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZstdOutputStream zstdOutputStream = new ZstdOutputStream(baos);
        zstdOutputStream.write("This is a test!".getBytes());
        zstdOutputStream.close();
        System.out.println(Arrays.toString(baos.toByteArray()));
    }
}
