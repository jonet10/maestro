package androidx.datastore.core;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Data<T> extends State<T> {
    private final int hashCode;
    private final T value;

    public Data(T t9, int i, int i6) {
        super(i6, null);
        this.value = t9;
        this.hashCode = i;
    }

    public final void checkHashCode() {
        T t9 = this.value;
        if ((t9 != null ? t9.hashCode() : 0) == this.hashCode) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Data in DataStore was mutated but DataStore is only compatible with Immutable types.");
    }

    public final int getHashCode() {
        return this.hashCode;
    }

    public final T getValue() {
        return this.value;
    }
}
