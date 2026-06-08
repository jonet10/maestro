package g4;

import android.net.Uri;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public Uri f5220a;

    /* renamed from: b, reason: collision with root package name */
    public String f5221b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f5222l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5223m;

    /* renamed from: n, reason: collision with root package name */
    public int f5224n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(InstallerActivity installerActivity, v6.c cVar) {
        super(cVar);
        this.f5223m = installerActivity;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f5222l = obj;
        this.f5224n |= Integer.MIN_VALUE;
        return InstallerActivity.C(this.f5223m, null, null, this);
    }
}
