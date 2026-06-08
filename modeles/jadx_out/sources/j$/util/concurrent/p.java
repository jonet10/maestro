package j$.util.concurrent;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public l[] f6008a;

    /* renamed from: b, reason: collision with root package name */
    public l f6009b = null;

    /* renamed from: c, reason: collision with root package name */
    public o f6010c;

    /* renamed from: d, reason: collision with root package name */
    public o f6011d;

    /* renamed from: e, reason: collision with root package name */
    public int f6012e;
    public int f;
    public int g;
    public final int h;

    public p(l[] lVarArr, int i, int i6, int i10) {
        this.f6008a = lVarArr;
        this.h = i;
        this.f6012e = i6;
        this.f = i6;
        this.g = i10;
    }

    public final l a() {
        l[] lVarArr;
        int length;
        int i;
        o oVar;
        l lVar = this.f6009b;
        if (lVar != null) {
            lVar = lVar.f6003d;
        }
        while (lVar == null) {
            if (this.f >= this.g || (lVarArr = this.f6008a) == null || (length = lVarArr.length) <= (i = this.f6012e) || i < 0) {
                this.f6009b = null;
                return null;
            }
            l k5 = ConcurrentHashMap.k(lVarArr, i);
            if (k5 == null || k5.f6000a >= 0) {
                lVar = k5;
            } else if (k5 instanceof g) {
                this.f6008a = ((g) k5).f5995e;
                o oVar2 = this.f6011d;
                if (oVar2 == null) {
                    oVar2 = new o();
                } else {
                    this.f6011d = oVar2.f6007d;
                }
                oVar2.f6006c = lVarArr;
                oVar2.f6004a = length;
                oVar2.f6005b = i;
                oVar2.f6007d = this.f6010c;
                this.f6010c = oVar2;
                lVar = null;
            } else {
                lVar = k5 instanceof q ? ((q) k5).f : null;
            }
            if (this.f6010c != null) {
                while (true) {
                    oVar = this.f6010c;
                    if (oVar == null) {
                        break;
                    }
                    int i6 = this.f6012e;
                    int i10 = oVar.f6004a;
                    int i11 = i6 + i10;
                    this.f6012e = i11;
                    if (i11 < length) {
                        break;
                    }
                    this.f6012e = oVar.f6005b;
                    this.f6008a = oVar.f6006c;
                    oVar.f6006c = null;
                    o oVar3 = oVar.f6007d;
                    oVar.f6007d = this.f6011d;
                    this.f6010c = oVar3;
                    this.f6011d = oVar;
                    length = i10;
                }
                if (oVar == null) {
                    int i12 = this.f6012e + this.h;
                    this.f6012e = i12;
                    if (i12 >= length) {
                        int i13 = this.f + 1;
                        this.f = i13;
                        this.f6012e = i13;
                    }
                }
            } else {
                int i14 = i + this.h;
                this.f6012e = i14;
                if (i14 >= length) {
                    int i15 = this.f + 1;
                    this.f = i15;
                    this.f6012e = i15;
                }
            }
        }
        this.f6009b = lVar;
        return lVar;
    }
}
