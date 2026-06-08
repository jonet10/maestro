package e1;

import androidx.collection.ArrayMap;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3739a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3740b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f3741l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ b0 f3742m;

    public a(m3 m3Var, j3 j3Var, long j) {
        this.f3739a = 2;
        this.f3740b = j3Var;
        this.f3741l = j;
        Objects.requireNonNull(m3Var);
        this.f3742m = m3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3739a) {
            case 0:
                y yVar = (y) this.f3742m;
                String str = (String) this.f3740b;
                yVar.g();
                k0.y.d(str);
                ArrayMap arrayMap = yVar.f4409l;
                boolean isEmpty = arrayMap.isEmpty();
                long j = this.f3741l;
                if (isEmpty) {
                    yVar.f4410m = j;
                }
                Integer num = (Integer) arrayMap.get(str);
                if (num == null) {
                    if (arrayMap.size() < 100) {
                        arrayMap.put(str, 1);
                        yVar.f4408b.put(str, Long.valueOf(j));
                        break;
                    } else {
                        w0 w0Var = yVar.f3875a.f4264o;
                        t1.m(w0Var);
                        w0Var.f4342r.b("Too many ads visible");
                        break;
                    }
                } else {
                    arrayMap.put(str, Integer.valueOf(num.intValue() + 1));
                    break;
                }
            case 1:
                y yVar2 = (y) this.f3742m;
                String str2 = (String) this.f3740b;
                yVar2.g();
                k0.y.d(str2);
                ArrayMap arrayMap2 = yVar2.f4409l;
                Integer num2 = (Integer) arrayMap2.get(str2);
                t1 t1Var = yVar2.f3875a;
                if (num2 == null) {
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.c(str2, "Call to endAdUnitExposure for unknown ad unit id");
                    break;
                } else {
                    m3 m3Var = t1Var.f4270u;
                    w0 w0Var3 = t1Var.f4264o;
                    t1.l(m3Var);
                    j3 m10 = m3Var.m(false);
                    int intValue = num2.intValue() - 1;
                    if (intValue != 0) {
                        arrayMap2.put(str2, Integer.valueOf(intValue));
                        break;
                    } else {
                        arrayMap2.remove(str2);
                        ArrayMap arrayMap3 = yVar2.f4408b;
                        Long l10 = (Long) arrayMap3.get(str2);
                        long j6 = this.f3741l;
                        if (l10 == null) {
                            t1.m(w0Var3);
                            w0Var3.f4339o.b("First ad unit exposure time was never set");
                        } else {
                            long longValue = j6 - l10.longValue();
                            arrayMap3.remove(str2);
                            yVar2.l(str2, longValue, m10);
                        }
                        if (arrayMap2.isEmpty()) {
                            long j10 = yVar2.f4410m;
                            if (j10 != 0) {
                                yVar2.k(j6 - j10, m10);
                                yVar2.f4410m = 0L;
                                break;
                            } else {
                                t1.m(w0Var3);
                                w0Var3.f4339o.b("First ad exposure time was never set");
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                m3 m3Var2 = (m3) this.f3742m;
                m3Var2.k((j3) this.f3740b, false, this.f3741l);
                m3Var2.f4122n = null;
                w3 p10 = m3Var2.f3875a.p();
                p10.g();
                p10.h();
                p10.u(new m1.a(p10, (j3) null));
                break;
        }
    }

    public /* synthetic */ a(y yVar, String str, long j, int i) {
        this.f3739a = i;
        this.f3740b = str;
        this.f3741l = j;
        this.f3742m = yVar;
    }
}
