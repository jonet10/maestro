package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.File;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SharedCounter {
    public static final Factory Factory = new Factory(null);
    private static final NativeSharedCounter nativeSharedCounter = new NativeSharedCounter();
    private final long mappedAddress;

    private SharedCounter(long j) {
        this.mappedAddress = j;
    }

    public final int getValue() {
        return nativeSharedCounter.nativeGetCounterValue(this.mappedAddress);
    }

    public final int incrementAndGetValue() {
        return nativeSharedCounter.nativeIncrementAndGetCounterValue(this.mappedAddress);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Factory {
        public /* synthetic */ Factory(g gVar) {
            this();
        }

        private final SharedCounter createCounterFromFd(ParcelFileDescriptor parcelFileDescriptor) {
            int fd = parcelFileDescriptor.getFd();
            if (getNativeSharedCounter$datastore_core_release().nativeTruncateFile(fd) != 0) {
                com.google.gson.internal.a.n("Failed to truncate counter file");
                return null;
            }
            long nativeCreateSharedCounter = getNativeSharedCounter$datastore_core_release().nativeCreateSharedCounter(fd);
            if (nativeCreateSharedCounter >= 0) {
                return new SharedCounter(nativeCreateSharedCounter, null);
            }
            com.google.gson.internal.a.n("Failed to mmap counter file");
            return null;
        }

        public final SharedCounter create$datastore_core_release(d7.a aVar) {
            ParcelFileDescriptor parcelFileDescriptor;
            aVar.getClass();
            try {
                parcelFileDescriptor = ParcelFileDescriptor.open((File) aVar.invoke(), 939524096);
                try {
                    SharedCounter createCounterFromFd = createCounterFromFd(parcelFileDescriptor);
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    return createCounterFromFd;
                } catch (Throwable th) {
                    th = th;
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptor = null;
            }
        }

        public final NativeSharedCounter getNativeSharedCounter$datastore_core_release() {
            return SharedCounter.nativeSharedCounter;
        }

        public final void loadLib() {
            System.loadLibrary("datastore_shared_counter");
        }

        private Factory() {
        }
    }

    public /* synthetic */ SharedCounter(long j, g gVar) {
        this(j);
    }
}
