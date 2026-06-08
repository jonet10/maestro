package com.google.android.material.search;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f3029b;

    public /* synthetic */ g(SearchView searchView, int i) {
        this.f3028a = i;
        this.f3029b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3028a) {
            case 0:
                this.f3029b.lambda$setUpClearButton$2(view);
                break;
            case 1:
                this.f3029b.lambda$setupWithSearchBar$7(view);
                break;
            default:
                this.f3029b.lambda$setUpBackButton$1(view);
                break;
        }
    }
}
