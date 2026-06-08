package com.google.android.material.bottomappbar;

import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2960a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2961b;

    public /* synthetic */ a(View view, int i) {
        this.f2960a = i;
        this.f2961b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2960a) {
            case 0:
                this.f2961b.requestLayout();
                break;
            default:
                ViewUtils.requestFocusAndShowKeyboard(this.f2961b, false);
                break;
        }
    }
}
