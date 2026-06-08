package a4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f141a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap f142b;

    /* renamed from: c, reason: collision with root package name */
    public final w8.g0 f143c;

    /* renamed from: d, reason: collision with root package name */
    public final int f144d;

    public m0(Bitmap bitmap, w8.g0 g0Var, int i, int i6) {
        if ((bitmap != null) == (g0Var != null)) {
            throw new AssertionError();
        }
        this.f142b = bitmap;
        this.f143c = g0Var;
        if (i == 0) {
            com.google.gson.internal.a.i("loadedFrom == null");
        }
        this.f141a = i;
        this.f144d = i6;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m0(w8.g0 g0Var, int i) {
        this(null, g0Var, i, 0);
        StringBuilder sb = t0.f177a;
        if (g0Var != null) {
        } else {
            com.google.gson.internal.a.i("source == null");
            throw null;
        }
    }
}
