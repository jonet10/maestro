package o8;

import a2.t;
import com.google.android.gms.internal.measurement.i5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import w8.g0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f8346a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f8347b;

    /* renamed from: c, reason: collision with root package name */
    public final File[] f8348c;

    /* renamed from: d, reason: collision with root package name */
    public final File[] f8349d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8350e;
    public t f;
    public long g;
    public final /* synthetic */ f h;

    public d(f fVar, String str) {
        this.h = fVar;
        this.f8346a = str;
        int i = fVar.f8362q;
        File file = fVar.f8356b;
        this.f8347b = new long[i];
        this.f8348c = new File[i];
        this.f8349d = new File[i];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i6 = 0; i6 < i; i6++) {
            sb.append(i6);
            this.f8348c[i6] = new File(file, sb.toString());
            sb.append(".tmp");
            this.f8349d[i6] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final e a() {
        f fVar = this.h;
        int i = fVar.f8362q;
        if (!Thread.holdsLock(fVar)) {
            throw new AssertionError();
        }
        g0[] g0VarArr = new g0[i];
        for (int i6 = 0; i6 < fVar.f8362q; i6++) {
            try {
                t8.a aVar = fVar.f8355a;
                File file = this.f8348c[i6];
                aVar.getClass();
                g0VarArr[i6] = i5.L(file);
            } catch (FileNotFoundException unused) {
                for (int i10 = 0; i10 < i; i10++) {
                    g0 g0Var = g0VarArr[i10];
                    if (g0Var != null) {
                        n8.c.c(g0Var);
                    }
                }
                try {
                    fVar.u(this);
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            }
        }
        return new e(fVar, this.f8346a, this.g, g0VarArr);
    }
}
