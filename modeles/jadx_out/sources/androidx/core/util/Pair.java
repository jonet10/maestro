package androidx.core.util;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s6) {
        this.first = f;
        this.second = s6;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a8, B b7) {
        return new Pair<>(a8, b7);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int hashCode = f == null ? 0 : f.hashCode();
        S s6 = this.second;
        return hashCode ^ (s6 != null ? s6.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
