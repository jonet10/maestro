package j$.util;

import java.util.Set;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l extends h implements Set {
    private static final long serialVersionUID = 487447009682186044L;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f6065b) {
            equals = this.f6064a.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int hashCode;
        synchronized (this.f6065b) {
            hashCode = this.f6064a.hashCode();
        }
        return hashCode;
    }
}
