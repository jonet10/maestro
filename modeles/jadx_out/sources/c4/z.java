package c4;

import com.uptodown.activities.PasswordRecoveryActivity;
import java.io.File;
import java.io.Serializable;
import java.util.zip.ZipOutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2370a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f2371b;

    /* renamed from: l, reason: collision with root package name */
    public Object f2372l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Serializable f2373m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f2374n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f2375o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Serializable f2376p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(k0 k0Var, String str, x4.r rVar, File file, String str2, t6.c cVar) {
        super(2, cVar);
        this.f2372l = k0Var;
        this.f2373m = str;
        this.f2375o = rVar;
        this.f2376p = file;
        this.f2374n = str2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2370a) {
            case 0:
                return new z((k0) this.f2372l, (String) this.f2373m, (x4.r) this.f2375o, (File) this.f2376p, (String) this.f2374n, cVar);
            case 1:
                return new z((PasswordRecoveryActivity) this.f2372l, (kotlin.jvm.internal.x) this.f2373m, (kotlin.jvm.internal.x) this.f2374n, (kotlin.jvm.internal.x) this.f2375o, (kotlin.jvm.internal.v) this.f2376p, cVar);
            default:
                return new z((File) this.f2376p, (String) this.f2373m, (ZipOutputStream) this.f2374n, (a2.n) this.f2375o, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2370a) {
        }
        return ((z) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x00b2, code lost:
    
        if (r2 != r4) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0082  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.z.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(PasswordRecoveryActivity passwordRecoveryActivity, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.x xVar2, kotlin.jvm.internal.x xVar3, kotlin.jvm.internal.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f2372l = passwordRecoveryActivity;
        this.f2373m = xVar;
        this.f2374n = xVar2;
        this.f2375o = xVar3;
        this.f2376p = vVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(File file, String str, ZipOutputStream zipOutputStream, a2.n nVar, t6.c cVar) {
        super(2, cVar);
        this.f2376p = file;
        this.f2373m = str;
        this.f2374n = zipOutputStream;
        this.f2375o = nVar;
    }
}
