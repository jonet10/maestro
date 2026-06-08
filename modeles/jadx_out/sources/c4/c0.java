package c4;

import android.content.Context;
import android.content.Intent;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c0 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1446a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1447b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f1448l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1449m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1450n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1451o;

    public /* synthetic */ c0(Context context, k0 k0Var, w4.g gVar, x4.g gVar2, boolean z9) {
        this.f1449m = context;
        this.f1447b = k0Var;
        this.f1450n = gVar2;
        this.f1451o = gVar;
        this.f1448l = z9;
    }

    @Override // d7.a
    public final Object invoke() {
        switch (this.f1446a) {
            case 0:
                File file = (File) this.f1449m;
                String str = (String) this.f1450n;
                x4.r rVar = (x4.r) this.f1451o;
                file.getClass();
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                k0 k0Var = this.f1447b;
                Intent intent = new Intent(k0Var, (Class<?>) InstallerActivity.class);
                intent.putExtra("realPath", absolutePath);
                intent.putExtra("requireUserAction", this.f1448l);
                intent.putExtra("backgroundInstallation", false);
                intent.addFlags(268435456);
                if (str != null && str.length() != 0) {
                    intent.putExtra("newFeatures", str);
                }
                k0Var.startActivity(intent);
                k0Var.X(rVar);
                break;
            default:
                Context context = (Context) this.f1449m;
                x4.g gVar = (x4.g) this.f1450n;
                d0.b.k(context, this.f1447b, (w4.g) this.f1451o, gVar, this.f1448l);
                break;
        }
        return p6.x.f8463a;
    }

    public /* synthetic */ c0(k0 k0Var, File file, String str, boolean z9, x4.r rVar) {
        this.f1447b = k0Var;
        this.f1449m = file;
        this.f1450n = str;
        this.f1448l = z9;
        this.f1451o = rVar;
    }
}
