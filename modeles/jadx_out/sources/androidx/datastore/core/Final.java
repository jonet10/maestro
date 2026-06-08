package androidx.datastore.core;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Final<T> extends State<T> {
    private final Throwable finalException;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Final(Throwable th) {
        super(Integer.MAX_VALUE, null);
        th.getClass();
        this.finalException = th;
    }

    public final Throwable getFinalException() {
        return this.finalException;
    }
}
