package s8;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public final w8.a0 f9387b;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9386a = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public b[] f9390e = new b[8];
    public int f = 7;
    public int g = 0;
    public int h = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f9388c = 4096;

    /* renamed from: d, reason: collision with root package name */
    public int f9389d = 4096;

    public c(r rVar) {
        this.f9387b = new w8.a0(rVar);
    }

    public final int a(int i) {
        int i6;
        int i10 = 0;
        if (i > 0) {
            int length = this.f9390e.length;
            while (true) {
                length--;
                i6 = this.f;
                if (length < i6 || i <= 0) {
                    break;
                }
                int i11 = this.f9390e[length].f9385c;
                i -= i11;
                this.h -= i11;
                this.g--;
                i10++;
            }
            b[] bVarArr = this.f9390e;
            System.arraycopy(bVarArr, i6 + 1, bVarArr, i6 + 1 + i10, this.g);
            this.f += i10;
        }
        return i10;
    }

    public final w8.k b(int i) {
        if (i >= 0) {
            b[] bVarArr = d.f9391a;
            if (i <= bVarArr.length - 1) {
                return bVarArr[i].f9383a;
            }
        }
        int length = this.f + 1 + (i - d.f9391a.length);
        if (length >= 0) {
            b[] bVarArr2 = this.f9390e;
            if (length < bVarArr2.length) {
                return bVarArr2[length].f9383a;
            }
        }
        throw new IOException("Header index too large " + (i + 1));
    }

    public final void c(b bVar) {
        this.f9386a.add(bVar);
        int i = bVar.f9385c;
        int i6 = this.f9389d;
        if (i > i6) {
            Arrays.fill(this.f9390e, (Object) null);
            this.f = this.f9390e.length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i6);
        int i10 = this.g + 1;
        b[] bVarArr = this.f9390e;
        if (i10 > bVarArr.length) {
            b[] bVarArr2 = new b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.f = this.f9390e.length - 1;
            this.f9390e = bVarArr2;
        }
        int i11 = this.f;
        this.f = i11 - 1;
        this.f9390e[i11] = bVar;
        this.g++;
        this.h += i;
    }

    public final w8.k d() {
        w8.a0 a0Var = this.f9387b;
        byte readByte = a0Var.readByte();
        int i = readByte & 255;
        boolean z9 = (readByte & 128) == 128;
        int e10 = e(i, 127);
        if (!z9) {
            return a0Var.g(e10);
        }
        y yVar = y.f9480d;
        long j = e10;
        a0Var.t(j);
        byte[] i6 = a0Var.f10934b.i(j);
        yVar.getClass();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        g0.o oVar = yVar.f9481a;
        g0.o oVar2 = oVar;
        int i10 = 0;
        int i11 = 0;
        for (byte b7 : i6) {
            i10 = (i10 << 8) | (b7 & 255);
            i11 += 8;
            while (i11 >= 8) {
                oVar2 = ((g0.o[]) oVar2.f5104c)[(i10 >>> (i11 - 8)) & 255];
                if (((g0.o[]) oVar2.f5104c) == null) {
                    byteArrayOutputStream.write(oVar2.f5102a);
                    i11 -= oVar2.f5103b;
                    oVar2 = oVar;
                } else {
                    i11 -= 8;
                }
            }
        }
        while (i11 > 0) {
            g0.o oVar3 = ((g0.o[]) oVar2.f5104c)[(i10 << (8 - i11)) & 255];
            g0.o[] oVarArr = (g0.o[]) oVar3.f5104c;
            int i12 = oVar3.f5103b;
            if (oVarArr != null || i12 > i11) {
                break;
            }
            byteArrayOutputStream.write(oVar3.f5102a);
            i11 -= i12;
            oVar2 = oVar;
        }
        return w8.k.n(byteArrayOutputStream.toByteArray());
    }

    public final int e(int i, int i6) {
        int i10 = i & i6;
        if (i10 < i6) {
            return i10;
        }
        int i11 = 0;
        while (true) {
            byte readByte = this.f9387b.readByte();
            int i12 = readByte & 255;
            if ((readByte & 128) == 0) {
                return i6 + (i12 << i11);
            }
            i6 += (readByte & Byte.MAX_VALUE) << i11;
            i11 += 7;
        }
    }
}
