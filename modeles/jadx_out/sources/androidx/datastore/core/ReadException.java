package androidx.datastore.core;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ReadException<T> extends State<T> {
    private final Throwable readException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadException(Throwable th, int i) {
        super(i, null);
        th.getClass();
        this.readException = th;
    }

    public final Throwable getReadException() {
        return this.readException;
    }
}
