//: io/BufferToText.java
// Получение текста из буфера ByteBuffers и обратно
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel fc =
                new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("Some text".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
        fc.read(buffer);
        buffer.flip();

        // Doesn't work:
        System.out.println(buffer.asCharBuffer());
        // Decode using this system's default Charset:
        buffer.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": "
                + Charset.forName(encoding).decode(buffer));

        // Or, we could encode with something that will print:
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap(
                "Some text".getBytes("UTF-16BE")
        ));
        fc.close();

        // Now try reading again:
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        buffer.flip();
        System.out.println(buffer.asCharBuffer());

        // Use a CharBuffer to write through:
        fc = new FileOutputStream("data2.txt").getChannel();
        buffer = ByteBuffer.allocate(24); // More than needed
        buffer.asCharBuffer().put("Some text");
        fc.write(buffer);
        fc.close();

        // Read and display:
        fc = new FileInputStream("data2.txt").getChannel();
        buffer.clear();
        fc.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
    }
}
