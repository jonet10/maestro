package androidx.datastore.core;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i);

    public final native int nativeGetCounterValue(long j);

    public final native int nativeIncrementAndGetCounterValue(long j);

    public final native int nativeTruncateFile(int i);
}
