package j5;

import android.content.Context;
import c4.t8;
import com.google.android.gms.internal.measurement.z3;
import java.util.Arrays;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicLong;
import o7.c0;
import o7.m0;
import o7.u1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicLong[][] f6693a;

    /* renamed from: b, reason: collision with root package name */
    public static Context f6694b;

    /* renamed from: c, reason: collision with root package name */
    public static final t7.c f6695c;

    static {
        AtomicLong[][] atomicLongArr = new AtomicLong[2][];
        for (int i = 0; i < 2; i++) {
            AtomicLong[] atomicLongArr2 = new AtomicLong[4];
            for (int i6 = 0; i6 < 4; i6++) {
                atomicLongArr2[i6] = new AtomicLong(0L);
            }
            atomicLongArr[i] = atomicLongArr2;
        }
        f6693a = atomicLongArr;
        u1 d10 = c0.d();
        v7.e eVar = m0.f8288a;
        f6695c = c0.b(a.a.L(d10, v7.d.f10884a));
    }

    public static void a(int i, long j) {
        if (i < 0 || i > 3) {
            return;
        }
        boolean z9 = z3.f;
        if (i != 0 && i != 1) {
            c(j, i, z9 ? 1 : 0);
            return;
        }
        AtomicLong[][] atomicLongArr = f6693a;
        if (atomicLongArr[z9 ? 1 : 0][i].addAndGet(j) >= 1048576) {
            long andSet = atomicLongArr[z9 ? 1 : 0][i].getAndSet(0L);
            if (andSet > 0) {
                c(andSet, i, z9 ? 1 : 0);
            }
        }
    }

    public static void b(int i) {
        if (i == 0 || i == 1) {
            for (int i6 = 0; i6 < 2; i6++) {
                long andSet = f6693a[i6][i].getAndSet(0L);
                if (andSet > 0) {
                    c(andSet, i, i6);
                }
            }
        }
    }

    public static void c(long j, int i, int i6) {
        Context context = f6694b;
        if (context == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        c0.s(f6695c, null, null, new t8(context, String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5))}, 3)), i, i6, j, null), 3);
    }
}
