package a4;

import android.net.Uri;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f126a;

    /* renamed from: b, reason: collision with root package name */
    public Object f127b;

    /* renamed from: c, reason: collision with root package name */
    public int f128c;

    /* renamed from: d, reason: collision with root package name */
    public int f129d;

    /* renamed from: e, reason: collision with root package name */
    public int f130e;
    public boolean f;
    public int g;
    public int h;
    public Object i;

    public k0(Uri uri, int i, ArrayList arrayList, int i6, int i10, boolean z9, int i11, int i12) {
        this.f126a = 1;
        this.f127b = uri;
        this.f128c = i;
        if (arrayList == null) {
            this.i = null;
        } else {
            this.i = DesugarCollections.unmodifiableList(arrayList);
        }
        this.f129d = i6;
        this.f130e = i10;
        this.f = z9;
        this.g = i11;
        this.h = i12;
    }

    public void a(int i) {
        int i6;
        if (i > 0) {
            int length = ((s8.b[]) this.i).length - 1;
            int i10 = 0;
            while (true) {
                i6 = this.f130e;
                if (length < i6 || i <= 0) {
                    break;
                }
                int i11 = ((s8.b[]) this.i)[length].f9385c;
                i -= i11;
                this.h -= i11;
                this.g--;
                i10++;
                length--;
            }
            s8.b[] bVarArr = (s8.b[]) this.i;
            int i12 = i6 + 1;
            System.arraycopy(bVarArr, i12, bVarArr, i12 + i10, this.g);
            s8.b[] bVarArr2 = (s8.b[]) this.i;
            int i13 = this.f130e + 1;
            Arrays.fill(bVarArr2, i13, i13 + i10, (Object) null);
            this.f130e += i10;
        }
    }

    public boolean b() {
        return (this.f129d == 0 && this.f130e == 0) ? false : true;
    }

    public void c(s8.b bVar) {
        int i = bVar.f9385c;
        int i6 = this.f129d;
        if (i > i6) {
            Arrays.fill((s8.b[]) this.i, (Object) null);
            this.f130e = ((s8.b[]) this.i).length - 1;
            this.g = 0;
            this.h = 0;
            return;
        }
        a((this.h + i) - i6);
        int i10 = this.g + 1;
        s8.b[] bVarArr = (s8.b[]) this.i;
        if (i10 > bVarArr.length) {
            s8.b[] bVarArr2 = new s8.b[bVarArr.length * 2];
            System.arraycopy(bVarArr, 0, bVarArr2, bVarArr.length, bVarArr.length);
            this.f130e = ((s8.b[]) this.i).length - 1;
            this.i = bVarArr2;
        }
        int i11 = this.f130e;
        this.f130e = i11 - 1;
        ((s8.b[]) this.i)[i11] = bVar;
        this.g++;
        this.h += i;
    }

    public boolean d() {
        return b();
    }

    public void e(int i, int i6) {
        if (i < 0) {
            com.google.gson.internal.a.p("Width must be positive number or 0.");
            return;
        }
        if (i6 < 0) {
            com.google.gson.internal.a.p("Height must be positive number or 0.");
        } else if (i6 == 0 && i == 0) {
            com.google.gson.internal.a.p("At least one dimension has to be positive number.");
        } else {
            this.f129d = i;
            this.f130e = i6;
        }
    }

    public void f(w8.k kVar) {
        w8.h hVar = (w8.h) this.f127b;
        s8.y.f9480d.getClass();
        long j = 0;
        long j6 = 0;
        for (int i = 0; i < kVar.f(); i++) {
            j6 += s8.y.f9479c[kVar.k(i) & 255];
        }
        if (((int) ((j6 + 7) >> 3)) >= kVar.f()) {
            g(kVar.f(), 127, 0);
            hVar.y(kVar);
            return;
        }
        w8.h hVar2 = new w8.h();
        s8.y.f9480d.getClass();
        int i6 = 0;
        for (int i10 = 0; i10 < kVar.f(); i10++) {
            int k5 = kVar.k(i10) & 255;
            int i11 = s8.y.f9478b[k5];
            byte b7 = s8.y.f9479c[k5];
            j = (j << b7) | i11;
            i6 += b7;
            while (i6 >= 8) {
                i6 -= 8;
                hVar2.A((int) (j >> i6));
            }
        }
        if (i6 > 0) {
            hVar2.A((int) ((j << (8 - i6)) | (255 >>> i6)));
        }
        w8.k g = hVar2.g(hVar2.f10961b);
        g(g.f(), 127, 128);
        hVar.y(g);
    }

    public void g(int i, int i6, int i10) {
        w8.h hVar = (w8.h) this.f127b;
        if (i < i6) {
            hVar.A(i | i10);
            return;
        }
        hVar.A(i10 | i6);
        int i11 = i - i6;
        while (i11 >= 128) {
            hVar.A(128 | (i11 & 127));
            i11 >>>= 7;
        }
        hVar.A(i11);
    }

    public String toString() {
        switch (this.f126a) {
            case 1:
                int i = this.f129d;
                List<q0> list = (List) this.i;
                StringBuilder sb = new StringBuilder("Request{");
                int i6 = this.f128c;
                if (i6 > 0) {
                    sb.append(i6);
                } else {
                    sb.append((Uri) this.f127b);
                }
                if (list != null && !list.isEmpty()) {
                    for (q0 q0Var : list) {
                        sb.append(' ');
                        sb.append(q0Var.b());
                    }
                }
                if (i > 0) {
                    sb.append(" resize(");
                    sb.append(i);
                    sb.append(',');
                    sb.append(this.f130e);
                    sb.append(')');
                }
                if (this.f) {
                    sb.append(" centerCrop");
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public k0(w8.h hVar) {
        this.f126a = 2;
        this.f128c = Integer.MAX_VALUE;
        this.i = new s8.b[8];
        this.f130e = 7;
        this.g = 0;
        this.h = 0;
        this.f129d = 4096;
        this.f127b = hVar;
    }
}
