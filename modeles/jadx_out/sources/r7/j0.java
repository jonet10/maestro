package r7;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class j0 extends s7.b implements b0, h, s7.i {

    /* renamed from: m, reason: collision with root package name */
    public final int f8995m;

    /* renamed from: n, reason: collision with root package name */
    public final int f8996n;

    /* renamed from: o, reason: collision with root package name */
    public Object[] f8997o;

    /* renamed from: p, reason: collision with root package name */
    public long f8998p;

    /* renamed from: q, reason: collision with root package name */
    public long f8999q;

    /* renamed from: r, reason: collision with root package name */
    public int f9000r;

    /* renamed from: s, reason: collision with root package name */
    public int f9001s;

    public j0(int i, int i6) {
        this.f8995m = i;
        this.f8996n = i6;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|1|(7:(2:3|(10:5|6|7|(2:9|(1:(1:(7:13|14|15|16|17|(3:18|19|(10:28|(2:33|34)|36|(1:38)|15|16|17|18|19|(0)(1:21))(0))|25)(2:39|40))(5:41|42|17|(3:18|19|(0)(0))|25))(4:43|44|45|46))(1:57)|47|48|16|17|(3:18|19|(0)(0))|25))|47|48|16|17|(3:18|19|(0)(0))|25)|59|6|7|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0036, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x0036, TRY_ENTER, TryCatch #0 {all -> 0x0036, blocks: (B:14:0x002f, B:18:0x0075, B:21:0x007f, B:30:0x0092, B:33:0x0099, B:34:0x009d, B:36:0x009e, B:42:0x0047), top: B:7:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /* JADX WARN: Type inference failed for: r4v1, types: [s7.b] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [r7.j0] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [r7.i] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [s7.d] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [r7.l0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [r7.l0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00ac -> B:15:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void h(r7.j0 r8, r7.i r9, t6.c r10) {
        /*
            boolean r0 = r10 instanceof r7.i0
            if (r0 == 0) goto L13
            r0 = r10
            r7.i0 r0 = (r7.i0) r0
            int r1 = r0.f8988p
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8988p = r1
            goto L18
        L13:
            r7.i0 r0 = new r7.i0
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f8986n
            int r1 = r0.f8988p
            r2 = 3
            r3 = 2
            if (r1 == 0) goto L5a
            r8 = 1
            if (r1 == r8) goto L4b
            if (r1 == r3) goto L3f
            if (r1 != r2) goto L39
            o7.e1 r8 = r0.f8985m
            r7.l0 r9 = r0.f8984l
            r7.i r1 = r0.f8983b
            r7.j0 r4 = r0.f8982a
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L36
        L32:
            r10 = r1
            r1 = r8
            r8 = r4
            goto L72
        L36:
            r8 = move-exception
            goto Lb2
        L39:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            return
        L3f:
            o7.e1 r8 = r0.f8985m
            r7.l0 r9 = r0.f8984l
            r7.i r1 = r0.f8983b
            r7.j0 r4 = r0.f8982a
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L36
            goto L75
        L4b:
            r7.l0 r9 = r0.f8984l
            r7.i r8 = r0.f8983b
            r7.j0 r1 = r0.f8982a
            p6.a.e(r10)     // Catch: java.lang.Throwable -> L57
            r10 = r8
            r8 = r1
            goto L66
        L57:
            r8 = move-exception
            r4 = r1
            goto Lb2
        L5a:
            p6.a.e(r10)
            s7.d r10 = r8.b()
            r7.l0 r10 = (r7.l0) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L66:
            t6.h r1 = r0.getContext()     // Catch: java.lang.Throwable -> Laf
            o7.x r4 = o7.x.f8327b     // Catch: java.lang.Throwable -> Laf
            t6.f r1 = r1.get(r4)     // Catch: java.lang.Throwable -> Laf
            o7.e1 r1 = (o7.e1) r1     // Catch: java.lang.Throwable -> Laf
        L72:
            r4 = r8
            r8 = r1
            r1 = r10
        L75:
            java.lang.Object r10 = r4.q(r9)     // Catch: java.lang.Throwable -> L36
            f8.w r5 = r7.k0.f9005a     // Catch: java.lang.Throwable -> L36
            u6.a r6 = u6.a.f10762a
            if (r10 != r5) goto L90
            r0.f8982a = r4     // Catch: java.lang.Throwable -> L36
            r0.f8983b = r1     // Catch: java.lang.Throwable -> L36
            r0.f8984l = r9     // Catch: java.lang.Throwable -> L36
            r0.f8985m = r8     // Catch: java.lang.Throwable -> L36
            r0.f8988p = r3     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r4.f(r9, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L75
            goto Lae
        L90:
            if (r8 == 0) goto L9e
            boolean r5 = r8.b()     // Catch: java.lang.Throwable -> L36
            if (r5 == 0) goto L99
            goto L9e
        L99:
            java.util.concurrent.CancellationException r8 = r8.j()     // Catch: java.lang.Throwable -> L36
            throw r8     // Catch: java.lang.Throwable -> L36
        L9e:
            r0.f8982a = r4     // Catch: java.lang.Throwable -> L36
            r0.f8983b = r1     // Catch: java.lang.Throwable -> L36
            r0.f8984l = r9     // Catch: java.lang.Throwable -> L36
            r0.f8985m = r8     // Catch: java.lang.Throwable -> L36
            r0.f8988p = r2     // Catch: java.lang.Throwable -> L36
            java.lang.Object r10 = r1.emit(r10, r0)     // Catch: java.lang.Throwable -> L36
            if (r10 != r6) goto L32
        Lae:
            return
        Laf:
            r10 = move-exception
            r4 = r8
            r8 = r10
        Lb2:
            r4.e(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: r7.j0.h(r7.j0, r7.i, t6.c):void");
    }

    @Override // s7.i
    public final h a(t6.h hVar, int i, q7.a aVar) {
        return k0.m(this, hVar, i, aVar);
    }

    @Override // s7.b
    public final s7.d c() {
        l0 l0Var = new l0();
        l0Var.f9013a = -1L;
        return l0Var;
    }

    @Override // r7.h
    public final Object collect(i iVar, t6.c cVar) {
        h(this, iVar, cVar);
        return u6.a.f10762a;
    }

    @Override // s7.b
    public final s7.d[] d() {
        return new l0[2];
    }

    @Override // r7.b0, r7.i
    public final Object emit(Object obj, t6.c cVar) {
        Throwable th;
        t6.c[] k5;
        h0 h0Var;
        if (n(obj)) {
            return p6.x.f8463a;
        }
        o7.l lVar = new o7.l(1, d0.b.I(cVar));
        lVar.s();
        t6.c[] cVarArr = s7.c.f9348a;
        synchronized (this) {
            try {
                if (o(obj)) {
                    try {
                        lVar.resumeWith(p6.x.f8463a);
                        k5 = k(cVarArr);
                        h0Var = null;
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                } else {
                    try {
                        h0 h0Var2 = new h0(this, l() + this.f9000r + this.f9001s, obj, lVar);
                        j(h0Var2);
                        this.f9001s++;
                        if (this.f8996n == 0) {
                            cVarArr = k(cVarArr);
                        }
                        k5 = cVarArr;
                        h0Var = h0Var2;
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        throw th;
                    }
                }
                if (h0Var != null) {
                    lVar.v(new o7.h(h0Var, 2));
                }
                for (t6.c cVar2 : k5) {
                    if (cVar2 != null) {
                        cVar2.resumeWith(p6.x.f8463a);
                    }
                }
                Object r9 = lVar.r();
                u6.a aVar = u6.a.f10762a;
                if (r9 != aVar) {
                    r9 = p6.x.f8463a;
                }
                return r9 == aVar ? r9 : p6.x.f8463a;
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    public final Object f(l0 l0Var, i0 i0Var) {
        o7.l lVar = new o7.l(1, d0.b.I(i0Var));
        lVar.s();
        synchronized (this) {
            try {
                if (p(l0Var) < 0) {
                    l0Var.f9014b = lVar;
                } else {
                    lVar.resumeWith(p6.x.f8463a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object r9 = lVar.r();
        return r9 == u6.a.f10762a ? r9 : p6.x.f8463a;
    }

    public final void g() {
        if (this.f8996n != 0 || this.f9001s > 1) {
            Object[] objArr = this.f8997o;
            objArr.getClass();
            while (this.f9001s > 0) {
                long l10 = l();
                int i = this.f9000r;
                int i6 = this.f9001s;
                if (objArr[((int) ((l10 + (i + i6)) - 1)) & (objArr.length - 1)] != k0.f9005a) {
                    return;
                }
                this.f9001s = i6 - 1;
                k0.d(objArr, l() + this.f9000r + this.f9001s, null);
            }
        }
    }

    public final void i() {
        s7.d[] dVarArr;
        Object[] objArr = this.f8997o;
        objArr.getClass();
        k0.d(objArr, l(), null);
        this.f9000r--;
        long l10 = l() + 1;
        if (this.f8998p < l10) {
            this.f8998p = l10;
        }
        if (this.f8999q < l10) {
            if (this.f9346b != 0 && (dVarArr = this.f9345a) != null) {
                for (s7.d dVar : dVarArr) {
                    if (dVar != null) {
                        l0 l0Var = (l0) dVar;
                        long j = l0Var.f9013a;
                        if (j >= 0 && j < l10) {
                            l0Var.f9013a = l10;
                        }
                    }
                }
            }
            this.f8999q = l10;
        }
    }

    public final void j(Object obj) {
        int i = this.f9000r + this.f9001s;
        Object[] objArr = this.f8997o;
        if (objArr == null) {
            objArr = m(null, 0, 2);
        } else if (i >= objArr.length) {
            objArr = m(objArr, i, objArr.length * 2);
        }
        k0.d(objArr, l() + i, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final t6.c[] k(t6.c[] cVarArr) {
        s7.d[] dVarArr;
        l0 l0Var;
        o7.l lVar;
        int length = cVarArr.length;
        if (this.f9346b != 0 && (dVarArr = this.f9345a) != null) {
            int length2 = dVarArr.length;
            int i = 0;
            cVarArr = cVarArr;
            while (i < length2) {
                s7.d dVar = dVarArr[i];
                if (dVar != null && (lVar = (l0Var = (l0) dVar).f9014b) != null && p(l0Var) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        cVarArr = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                    }
                    cVarArr[length] = lVar;
                    l0Var.f9014b = null;
                    length++;
                }
                i++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    public final long l() {
        return Math.min(this.f8999q, this.f8998p);
    }

    public final Object[] m(Object[] objArr, int i, int i6) {
        if (i6 <= 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i6];
        this.f8997o = objArr2;
        if (objArr != null) {
            long l10 = l();
            for (int i10 = 0; i10 < i; i10++) {
                long j = i10 + l10;
                k0.d(objArr2, j, objArr[((int) j) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean n(Object obj) {
        int i;
        boolean z9;
        t6.c[] cVarArr = s7.c.f9348a;
        synchronized (this) {
            if (o(obj)) {
                cVarArr = k(cVarArr);
                z9 = true;
            } else {
                z9 = false;
            }
        }
        for (t6.c cVar : cVarArr) {
            if (cVar != null) {
                cVar.resumeWith(p6.x.f8463a);
            }
        }
        return z9;
    }

    public final boolean o(Object obj) {
        int i = this.f9346b;
        int i6 = this.f8995m;
        if (i != 0) {
            int i10 = this.f9000r;
            int i11 = this.f8996n;
            if (i10 >= i11 && this.f8999q <= this.f8998p) {
                return false;
            }
            j(obj);
            int i12 = this.f9000r + 1;
            this.f9000r = i12;
            if (i12 > i11) {
                i();
            }
            long l10 = l() + this.f9000r;
            long j = this.f8998p;
            if (((int) (l10 - j)) > i6) {
                r(1 + j, this.f8999q, l() + this.f9000r, l() + this.f9000r + this.f9001s);
            }
        } else if (i6 != 0) {
            j(obj);
            int i13 = this.f9000r + 1;
            this.f9000r = i13;
            if (i13 > i6) {
                i();
            }
            this.f8999q = l() + this.f9000r;
            return true;
        }
        return true;
    }

    public final long p(l0 l0Var) {
        long j = l0Var.f9013a;
        if (j < l() + this.f9000r) {
            return j;
        }
        if (this.f8996n <= 0 && j <= l() && this.f9001s != 0) {
            return j;
        }
        return -1L;
    }

    public final Object q(l0 l0Var) {
        Object obj;
        t6.c[] cVarArr = s7.c.f9348a;
        synchronized (this) {
            try {
                long p10 = p(l0Var);
                if (p10 < 0) {
                    obj = k0.f9005a;
                } else {
                    long j = l0Var.f9013a;
                    Object[] objArr = this.f8997o;
                    objArr.getClass();
                    Object obj2 = objArr[((int) p10) & (objArr.length - 1)];
                    if (obj2 instanceof h0) {
                        obj2 = ((h0) obj2).f8980l;
                    }
                    l0Var.f9013a = p10 + 1;
                    Object obj3 = obj2;
                    cVarArr = s(j);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (t6.c cVar : cVarArr) {
            if (cVar != null) {
                cVar.resumeWith(p6.x.f8463a);
            }
        }
        return obj;
    }

    public final void r(long j, long j6, long j10, long j11) {
        long min = Math.min(j6, j);
        for (long l10 = l(); l10 < min; l10++) {
            Object[] objArr = this.f8997o;
            objArr.getClass();
            k0.d(objArr, l10, null);
        }
        this.f8998p = j;
        this.f8999q = j6;
        this.f9000r = (int) (j10 - min);
        this.f9001s = (int) (j11 - j10);
    }

    public final t6.c[] s(long j) {
        long j6;
        long j10;
        long j11;
        t6.c[] cVarArr;
        t6.c[] cVarArr2;
        s7.d[] dVarArr;
        f8.w wVar = k0.f9005a;
        t6.c[] cVarArr3 = s7.c.f9348a;
        if (j <= this.f8999q) {
            long l10 = l();
            long j12 = this.f9000r + l10;
            int i = this.f8996n;
            if (i == 0 && this.f9001s > 0) {
                j12++;
            }
            int i6 = 0;
            if (this.f9346b != 0 && (dVarArr = this.f9345a) != null) {
                for (s7.d dVar : dVarArr) {
                    if (dVar != null) {
                        long j13 = ((l0) dVar).f9013a;
                        if (j13 >= 0 && j13 < j12) {
                            j12 = j13;
                        }
                    }
                }
            }
            if (j12 > this.f8999q) {
                long l11 = l() + this.f9000r;
                int i10 = this.f9346b;
                int i11 = this.f9001s;
                if (i10 > 0) {
                    j6 = 1;
                    i11 = Math.min(i11, i - ((int) (l11 - j12)));
                } else {
                    j6 = 1;
                }
                long j14 = this.f9001s + l11;
                if (i11 > 0) {
                    Object[] objArr = this.f8997o;
                    objArr.getClass();
                    j10 = l10;
                    t6.c[] cVarArr4 = new t6.c[i11];
                    long j15 = l11;
                    while (true) {
                        if (l11 >= j14) {
                            cVarArr2 = cVarArr4;
                            j11 = j12;
                            break;
                        }
                        cVarArr2 = cVarArr4;
                        Object obj = objArr[((int) l11) & (objArr.length - 1)];
                        if (obj != wVar) {
                            obj.getClass();
                            h0 h0Var = (h0) obj;
                            j11 = j12;
                            int i12 = i6 + 1;
                            cVarArr2[i6] = h0Var.f8981m;
                            k0.d(objArr, l11, wVar);
                            k0.d(objArr, j15, h0Var.f8980l);
                            j15 += j6;
                            if (i12 >= i11) {
                                break;
                            }
                            i6 = i12;
                        } else {
                            j11 = j12;
                        }
                        l11 += j6;
                        cVarArr4 = cVarArr2;
                        j12 = j11;
                    }
                    l11 = j15;
                    cVarArr = cVarArr2;
                } else {
                    j10 = l10;
                    j11 = j12;
                    cVarArr = cVarArr3;
                }
                int i13 = (int) (l11 - j10);
                long j16 = this.f9346b == 0 ? l11 : j11;
                long max = Math.max(this.f8998p, l11 - Math.min(this.f8995m, i13));
                if (i == 0 && max < j14) {
                    Object[] objArr2 = this.f8997o;
                    objArr2.getClass();
                    if (kotlin.jvm.internal.l.a(objArr2[((int) max) & (objArr2.length - 1)], wVar)) {
                        l11 += j6;
                        max += j6;
                    }
                }
                r(max, j16, l11, j14);
                g();
                return cVarArr.length == 0 ? cVarArr : k(cVarArr);
            }
        }
        return cVarArr3;
    }
}
