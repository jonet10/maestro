package j4;

import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.util.Iterator;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6601a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f6602b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(o oVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6601a = i;
        this.f6602b = oVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6601a) {
            case 0:
                return new f(this.f6602b, cVar, 0);
            case 1:
                return new f(this.f6602b, cVar, 1);
            case 2:
                return new f(this.f6602b, cVar, 2);
            default:
                return new f(this.f6602b, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6601a) {
        }
        return ((f) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6601a) {
            case 0:
                p6.a.e(obj);
                Iterator it = this.f6602b.f6650a.iterator();
                it.getClass();
                long j = 0;
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    j += next instanceof File ? o.h((File) next) : next instanceof DocumentFile ? o.g((DocumentFile) next) : 0L;
                }
                return new Long(j);
            case 1:
                p6.a.e(obj);
                k4.a aVar = this.f6602b.f6652c;
                if (aVar == null) {
                    return null;
                }
                aVar.y();
                return x.f8463a;
            case 2:
                p6.a.e(obj);
                if (this.f6602b.f6652c != null) {
                    return x.f8463a;
                }
                return null;
            default:
                p6.a.e(obj);
                if (this.f6602b.f6652c != null) {
                    return x.f8463a;
                }
                return null;
        }
    }
}
