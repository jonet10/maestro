package d8;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final s f3702a = new s();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f3703b = new u0("kotlin.time.Duration", b8.d.f1111p);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        int i = m7.a.f7657m;
        String decodeString = eVar.decodeString();
        decodeString.getClass();
        try {
            return new m7.a(i5.f(decodeString));
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(androidx.lifecycle.l.w("Invalid ISO duration string format: '", decodeString, "'."), e10);
        }
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3703b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        long j;
        long j6;
        int g;
        long j10 = ((m7.a) obj).f7658a;
        int i = m7.a.f7657m;
        StringBuilder sb = new StringBuilder();
        if (j10 < 0) {
            sb.append('-');
        }
        sb.append("PT");
        boolean z9 = true;
        if (j10 < 0) {
            j = ((-(j10 >> 1)) << 1) + (((int) j10) & 1);
            int i6 = m7.b.f7659a;
        } else {
            j = j10;
        }
        long g3 = m7.a.g(j, m7.c.HOURS);
        if (m7.a.e(j)) {
            j6 = 0;
            g = 0;
        } else {
            j6 = 0;
            g = (int) (m7.a.g(j, m7.c.MINUTES) % 60);
        }
        int g10 = m7.a.e(j) ? 0 : (int) (m7.a.g(j, m7.c.SECONDS) % 60);
        int d10 = m7.a.d(j);
        if (m7.a.e(j10)) {
            g3 = 9999999999999L;
        }
        boolean z10 = g3 != j6;
        boolean z11 = (g10 == 0 && d10 == 0) ? false : true;
        if (g == 0 && (!z11 || !z10)) {
            z9 = false;
        }
        if (z10) {
            sb.append(g3);
            sb.append('H');
        }
        if (z9) {
            sb.append(g);
            sb.append('M');
        }
        if (z11 || (!z10 && !z9)) {
            m7.a.b(sb, g10, d10, 9, ExifInterface.LATITUDE_SOUTH, true);
        }
        fVar.encodeString(sb.toString());
    }
}
