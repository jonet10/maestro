package a4;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends n0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f75a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f76b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public AssetManager f77c;

    public c(Context context) {
        this.f75a = context;
    }

    @Override // a4.n0
    public final boolean b(k0 k0Var) {
        Uri uri = (Uri) k0Var.f127b;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // a4.n0
    public final m0 e(k0 k0Var, int i) {
        if (this.f77c == null) {
            synchronized (this.f76b) {
                try {
                    if (this.f77c == null) {
                        this.f77c = this.f75a.getAssets();
                    }
                } finally {
                }
            }
        }
        return new m0(i5.M(this.f77c.open(((Uri) k0Var.f127b).toString().substring(22))), 2);
    }
}
