package e1;

import android.content.Context;
import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m2 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4115a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f4116b;

    /* renamed from: c, reason: collision with root package name */
    public final long f4117c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.u0 f4118d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4119e;
    public final Long f;
    public final String g;

    public m2(Context context, com.google.android.gms.internal.measurement.u0 u0Var, Long l10) {
        this.f4119e = true;
        k0.y.g(context);
        Context applicationContext = context.getApplicationContext();
        k0.y.g(applicationContext);
        this.f4115a = applicationContext;
        this.f = l10;
        if (u0Var != null) {
            this.f4118d = u0Var;
            this.f4119e = u0Var.f2816l;
            this.f4117c = u0Var.f2815b;
            this.g = u0Var.f2818n;
            Bundle bundle = u0Var.f2817m;
            if (bundle != null) {
                this.f4116b = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
