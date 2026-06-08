package s7;

import java.util.Arrays;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public d[] f9345a;

    /* renamed from: b, reason: collision with root package name */
    public int f9346b;

    /* renamed from: l, reason: collision with root package name */
    public int f9347l;

    public final d b() {
        d dVar;
        synchronized (this) {
            try {
                d[] dVarArr = this.f9345a;
                if (dVarArr == null) {
                    dVarArr = d();
                    this.f9345a = dVarArr;
                } else if (this.f9346b >= dVarArr.length) {
                    Object[] copyOf = Arrays.copyOf(dVarArr, dVarArr.length * 2);
                    this.f9345a = (d[]) copyOf;
                    dVarArr = (d[]) copyOf;
                }
                int i = this.f9347l;
                do {
                    dVar = dVarArr[i];
                    if (dVar == null) {
                        dVar = c();
                        dVarArr[i] = dVar;
                    }
                    i++;
                    if (i >= dVarArr.length) {
                        i = 0;
                    }
                } while (!dVar.a(this));
                this.f9347l = i;
                this.f9346b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public abstract d c();

    public abstract d[] d();

    public final void e(d dVar) {
        int i;
        t6.c[] b7;
        synchronized (this) {
            try {
                int i6 = this.f9346b - 1;
                this.f9346b = i6;
                if (i6 == 0) {
                    this.f9347l = 0;
                }
                dVar.getClass();
                b7 = dVar.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (t6.c cVar : b7) {
            if (cVar != null) {
                cVar.resumeWith(x.f8463a);
            }
        }
    }
}
