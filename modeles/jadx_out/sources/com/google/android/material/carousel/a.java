package com.google.android.material.carousel;

import android.view.View;
import com.google.android.material.navigation.NavigationBarItemView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2965b;

    public /* synthetic */ a(Object obj, int i) {
        this.f2964a = i;
        this.f2965b = obj;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        switch (this.f2964a) {
            case 0:
                ((CarouselLayoutManager) this.f2965b).lambda$new$0(view, i, i6, i10, i11, i12, i13, i14, i15);
                break;
            default:
                ((NavigationBarItemView) this.f2965b).lambda$new$0(view, i, i6, i10, i11, i12, i13, i14, i15);
                break;
        }
    }
}
