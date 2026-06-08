package e1;

import j$.util.Objects;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4446a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final URL f4447b;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f4448l;

    /* renamed from: m, reason: collision with root package name */
    public final String f4449m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f4450n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f4451o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ d2 f4452p;

    public z0(a1 a1Var, String str, URL url, byte[] bArr, Map map, y0 y0Var) {
        Objects.requireNonNull(a1Var);
        this.f4452p = a1Var;
        k0.y.d(str);
        k0.y.g(url);
        this.f4447b = url;
        this.f4448l = bArr;
        this.f4451o = y0Var;
        this.f4449m = str;
        this.f4450n = map;
    }

    public void a(final int i, final IOException iOException, final byte[] bArr, final Map map) {
        q1 q1Var = ((f3) this.f4452p).f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new Runnable() { // from class: e1.e3
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                z0 z0Var = z0.this;
                ((d3) z0Var.f4451o).c(z0Var.f4449m, i, iOException, bArr, map);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027c: MOVE (r11 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:637), block:B:177:0x027a */
    /* JADX WARN: Not initialized variable reg: 13, insn: 0x027f: MOVE (r12 I:??[OBJECT, ARRAY]) = (r13 I:??[OBJECT, ARRAY]) (LINE:640), block:B:174:0x027e */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x015c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v25, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v26, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v35, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v42, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v49 */
    /* JADX WARN: Type inference failed for: r8v50 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.z0.run():void");
    }

    public z0(f3 f3Var, String str, URL url, byte[] bArr, HashMap hashMap, d3 d3Var) {
        Objects.requireNonNull(f3Var);
        this.f4452p = f3Var;
        k0.y.d(str);
        this.f4447b = url;
        this.f4448l = bArr;
        this.f4451o = d3Var;
        this.f4449m = str;
        this.f4450n = hashMap;
    }
}
