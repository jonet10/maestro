package g4;

import android.net.Uri;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5210a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f5211b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5212l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5213m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Uri f5214n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(InstallerActivity installerActivity, Uri uri, String str, t6.c cVar) {
        super(2, cVar);
        this.f5213m = installerActivity;
        this.f5214n = uri;
        this.f5212l = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5210a) {
            case 0:
                return new l0(this.f5213m, this.f5214n, this.f5212l, cVar);
            default:
                return new l0(this.f5212l, this.f5213m, this.f5214n, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5210a) {
        }
        return ((l0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0083  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.l0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(String str, InstallerActivity installerActivity, Uri uri, t6.c cVar) {
        super(2, cVar);
        this.f5212l = str;
        this.f5213m = installerActivity;
        this.f5214n = uri;
    }
}
