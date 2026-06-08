package j$.time;

import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class a extends j$.com.android.tools.r8.a implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f5756b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f5757a;

    public a(ZoneId zoneId) {
        this.f5757a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f5756b = new a(ZoneOffset.UTC);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f5757a.equals(((a) obj).f5757a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5757a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f5757a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }
}
