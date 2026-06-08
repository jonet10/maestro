package j$.util;

import java.util.RandomAccess;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class v extends p implements RandomAccess {
    private static final long serialVersionUID = -2542308836966382001L;

    @Override // j$.util.p, java.util.List
    public final java.util.List subList(int i, int i6) {
        return new v(this.f6101b.subList(i, i6));
    }

    private Object writeReplace() {
        return new p(this.f6101b);
    }
}
