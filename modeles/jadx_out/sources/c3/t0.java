package c3;

import java.util.Locale;
import java.util.UUID;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    public final h1 f1326a;

    /* renamed from: b, reason: collision with root package name */
    public final i1 f1327b;

    public t0(h1 h1Var, i1 i1Var) {
        h1Var.getClass();
        i1Var.getClass();
        this.f1326a = h1Var;
        this.f1327b = i1Var;
    }

    public final n0 a(n0 n0Var) {
        String str;
        this.f1327b.getClass();
        UUID randomUUID = UUID.randomUUID();
        randomUUID.getClass();
        String uuid = randomUUID.toString();
        uuid.getClass();
        String lowerCase = l7.u.o0(uuid, "-", "", false).toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        String str2 = (n0Var == null || (str = n0Var.f1291b) == null) ? lowerCase : str;
        int i = n0Var != null ? n0Var.f1292c + 1 : 0;
        this.f1326a.getClass();
        return new n0(h1.a().f1248b, lowerCase, str2, i);
    }
}
