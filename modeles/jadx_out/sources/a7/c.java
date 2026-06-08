package a7;

import b2.t1;
import com.google.android.gms.internal.measurement.i5;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c extends i5 {
    public static void h0(File file, File file2) {
        if (!file.exists()) {
            throw new a(file, null, "The source file doesn't exist.");
        }
        if (file2.exists() && !file2.delete()) {
            throw new a(file, file2, "Tried to overwrite the destination, but failed to delete it.");
        }
        if (file.isDirectory()) {
            if (!file2.mkdirs()) {
                throw new b(file, file2, "Failed to create target directory.");
            }
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                t1.t(fileInputStream, fileOutputStream);
                fileOutputStream.close();
                fileInputStream.close();
            } finally {
            }
        } finally {
        }
    }

    public static final void i0(FileOutputStream fileOutputStream, String str, Charset charset) {
        charset.getClass();
        if (str.length() < 16384) {
            byte[] bytes = str.getBytes(charset);
            bytes.getClass();
            fileOutputStream.write(bytes);
            return;
        }
        CharsetEncoder newEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        CharsetEncoder onUnmappableCharacter = newEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction);
        CharBuffer allocate = CharBuffer.allocate(8192);
        onUnmappableCharacter.getClass();
        ByteBuffer allocate2 = ByteBuffer.allocate(8192 * ((int) Math.ceil(onUnmappableCharacter.maxBytesPerChar())));
        allocate2.getClass();
        int i = 0;
        int i6 = 0;
        while (i < str.length()) {
            int min = Math.min(8192 - i6, str.length() - i);
            int i10 = i + min;
            char[] array = allocate.array();
            array.getClass();
            str.getChars(i, i10, array, i6);
            allocate.limit(min + i6);
            i6 = 1;
            if (!onUnmappableCharacter.encode(allocate, allocate2, i10 == str.length()).isUnderflow()) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Check failed.");
                return;
            }
            fileOutputStream.write(allocate2.array(), 0, allocate2.position());
            if (allocate.position() != allocate.limit()) {
                allocate.put(0, allocate.get());
            } else {
                i6 = 0;
            }
            allocate.clear();
            allocate2.clear();
            i = i10;
        }
    }
}
