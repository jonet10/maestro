package b5;

import android.content.Context;
import c4.k0;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import d7.p;
import j5.v;
import java.io.File;
import java.util.ArrayList;
import o7.a0;
import p6.x;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1044a;

    /* renamed from: b, reason: collision with root package name */
    public int f1045b;

    /* renamed from: l, reason: collision with root package name */
    public Object f1046l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1047m;

    /* renamed from: n, reason: collision with root package name */
    public Object f1048n;

    /* renamed from: o, reason: collision with root package name */
    public Object f1049o;

    /* renamed from: p, reason: collision with root package name */
    public Object f1050p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1051q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, ArrayList arrayList, j5.a aVar, t6.c cVar) {
        super(2, cVar);
        this.f1044a = 3;
        this.f1050p = context;
        this.f1048n = arrayList;
        this.f1051q = aVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1044a) {
            case 0:
                return new j((m) this.f1051q, cVar);
            case 1:
                return new j((MainActivity) this.f1049o, (String) this.f1050p, (x4.k) this.f1051q, cVar, 1);
            case 2:
                return new j((MyDownloads) this.f1049o, (String) this.f1050p, (File) this.f1051q, cVar, 2);
            case 3:
                return new j((Context) this.f1050p, (ArrayList) this.f1048n, (j5.a) this.f1051q, cVar);
            case 4:
                j jVar = new j((s) this.f1051q, (v) this.f1046l, cVar, 4);
                jVar.f1050p = obj;
                return jVar;
            default:
                j jVar2 = new j((s4.s) this.f1051q, (v) this.f1046l, cVar, 5);
                jVar2.f1050p = obj;
                return jVar2;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1044a) {
        }
        return ((j) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x022f, code lost:
    
        if (r8 == r9) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x02b7, code lost:
    
        if (r6 == r9) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x03d6, code lost:
    
        if (r7 == r9) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (r2.s(r20) == r9) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a4, code lost:
    
        if (r3.s(r20) == r9) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0169, code lost:
    
        if (r2.s(r20) == r9) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0158, code lost:
    
        if (r3.s(r20) == r9) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f7  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 1050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, t6.c cVar) {
        super(2, cVar);
        this.f1044a = 0;
        this.f1051q = mVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(k0 k0Var, String str, Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f1044a = i;
        this.f1049o = k0Var;
        this.f1050p = str;
        this.f1051q = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Object obj, v vVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f1044a = i;
        this.f1051q = obj;
        this.f1046l = vVar;
    }
}
