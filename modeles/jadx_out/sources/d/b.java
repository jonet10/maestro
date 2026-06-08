package d;

import androidx.lifecycle.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f3503a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3504b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3505c;

    public b(int i, int i6, byte[] bArr) {
        this.f3503a = i;
        this.f3504b = i6;
        this.f3505c = bArr;
    }

    public static b a(long j, ByteOrder byteOrder) {
        long[] jArr = {j};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[e.f3519r[4]]);
        wrap.order(byteOrder);
        wrap.putInt((int) jArr[0]);
        return new b(4, 1, wrap.array());
    }

    public static b b(d dVar, ByteOrder byteOrder) {
        d[] dVarArr = {dVar};
        ByteBuffer wrap = ByteBuffer.wrap(new byte[e.f3519r[5]]);
        wrap.order(byteOrder);
        d dVar2 = dVarArr[0];
        wrap.putInt((int) dVar2.f3510a);
        wrap.putInt((int) dVar2.f3511b);
        return new b(5, 1, wrap.array());
    }

    public static b c(int i, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[e.f3519r[3]]);
        wrap.order(byteOrder);
        wrap.putShort((short) new int[]{i}[0]);
        return new b(3, 1, wrap.array());
    }

    public final double d(ByteOrder byteOrder) {
        Object g = g(byteOrder);
        if (g == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (g instanceof String) {
            return Double.parseDouble((String) g);
        }
        if (g instanceof long[]) {
            if (((long[]) g).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (g instanceof int[]) {
            if (((int[]) g).length == 1) {
                return r5[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (g instanceof double[]) {
            double[] dArr = (double[]) g;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(g instanceof d[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        d[] dVarArr = (d[]) g;
        if (dVarArr.length != 1) {
            throw new NumberFormatException("There are more than one component");
        }
        d dVar = dVarArr[0];
        return dVar.f3510a / dVar.f3511b;
    }

    public final int e(ByteOrder byteOrder) {
        Object g = g(byteOrder);
        if (g == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (g instanceof String) {
            return Integer.parseInt((String) g);
        }
        if (g instanceof long[]) {
            long[] jArr = (long[]) g;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(g instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) g;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public final String f(ByteOrder byteOrder) {
        Object g = g(byteOrder);
        if (g == null) {
            return null;
        }
        if (g instanceof String) {
            return (String) g;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (g instanceof long[]) {
            long[] jArr = (long[]) g;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (g instanceof int[]) {
            int[] iArr = (int[]) g;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (g instanceof double[]) {
            double[] dArr = (double[]) g;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(g instanceof d[])) {
            return null;
        }
        d[] dVarArr = (d[]) g;
        while (i < dVarArr.length) {
            sb.append(dVarArr[i].f3510a);
            sb.append('/');
            sb.append(dVarArr[i].f3511b);
            i++;
            if (i != dVarArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0032: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:51), block:B:100:0x0032 */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v19, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v24, types: [long[]] */
    /* JADX WARN: Type inference failed for: r14v25, types: [d.d[]] */
    /* JADX WARN: Type inference failed for: r14v26, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v27, types: [int[]] */
    /* JADX WARN: Type inference failed for: r14v28, types: [d.d[]] */
    /* JADX WARN: Type inference failed for: r14v29, types: [double[]] */
    /* JADX WARN: Type inference failed for: r14v30, types: [java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r14v31, types: [double[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.io.Serializable g(java.nio.ByteOrder r14) {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.g(java.nio.ByteOrder):java.io.Serializable");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(e.f3518q[this.f3503a]);
        sb.append(", data length:");
        return l.x(sb, ")", this.f3505c.length);
    }
}
