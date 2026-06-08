package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileUtil {
    @SuppressLint({"LambdaLast"})
    public static final void copy(ReadableByteChannel readableByteChannel, FileChannel fileChannel) throws IOException {
        ReadableByteChannel readableByteChannel2;
        FileChannel fileChannel2;
        readableByteChannel.getClass();
        fileChannel.getClass();
        try {
            try {
                if (Build.VERSION.SDK_INT <= 23) {
                    readableByteChannel2 = readableByteChannel;
                    fileChannel2 = fileChannel;
                    InputStream newInputStream = Channels.newInputStream(readableByteChannel2);
                    OutputStream newOutputStream = Channels.newOutputStream(fileChannel2);
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = newInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            newOutputStream.write(bArr, 0, read);
                        }
                    }
                } else {
                    readableByteChannel2 = readableByteChannel;
                    fileChannel2 = fileChannel;
                    fileChannel2.transferFrom(readableByteChannel2, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                }
                fileChannel2.force(false);
                readableByteChannel2.close();
                fileChannel2.close();
            } catch (Throwable th) {
                th = th;
                Throwable th2 = th;
                readableByteChannel2.close();
                fileChannel2.close();
                throw th2;
            }
        } catch (Throwable th3) {
            th = th3;
            readableByteChannel2 = readableByteChannel;
            fileChannel2 = fileChannel;
        }
    }
}
