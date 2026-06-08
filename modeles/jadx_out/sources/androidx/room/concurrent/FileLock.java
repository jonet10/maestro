package androidx.room.concurrent;

import a4.x;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FileLock {
    private FileChannel lockChannel;
    private final String lockFilename;

    public FileLock(String str) {
        str.getClass();
        this.lockFilename = str.concat(".lck");
    }

    public final void lock() {
        if (this.lockChannel != null) {
            return;
        }
        try {
            File file = new File(this.lockFilename);
            File parentFile = file.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileChannel channel = new FileOutputStream(file).getChannel();
            this.lockChannel = channel;
            if (channel != null) {
                channel.lock();
            }
        } catch (Throwable th) {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
            this.lockChannel = null;
            throw new IllegalStateException(x.n(new StringBuilder("Unable to lock file: '"), this.lockFilename, "'."), th);
        }
    }

    public final void unlock() {
        FileChannel fileChannel = this.lockChannel;
        if (fileChannel == null) {
            return;
        }
        try {
            fileChannel.close();
        } finally {
            this.lockChannel = null;
        }
    }
}
