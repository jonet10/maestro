package com.uptodown.activities;

import android.widget.TextView;
import androidx.room.g;
import c4.b;
import c4.k0;
import java.util.ArrayList;
import p6.m;
import t4.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Gallery extends k0 {
    public static final /* synthetic */ int R = 0;
    public ArrayList P;
    public final m O = new m(new g(this, 16));
    public final b Q = new b(this, 1);

    /* JADX WARN: Removed duplicated region for block: B:17:0x0060  */
    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            t4.n r5 = r4.y0()
            android.widget.RelativeLayout r5 = r5.f10008a
            r5.getClass()
            r4.setContentView(r5)
            androidx.activity.OnBackPressedDispatcher r5 = r4.getOnBackPressedDispatcher()
            c4.b r0 = r4.Q
            r5.addCallback(r4, r0)
            android.content.Intent r5 = r4.getIntent()
            r0 = 0
            if (r5 == 0) goto L4f
            java.lang.String r1 = "bundle"
            android.os.Bundle r5 = r5.getBundleExtra(r1)
            if (r5 == 0) goto L4f
            java.lang.String r1 = "images"
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L42
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 34
            if (r2 < r3) goto L3c
            java.lang.Class<x4.l2> r2 = x4.l2.class
            java.util.ArrayList r1 = r5.getParcelableArrayList(r1, r2)
            goto L40
        L3c:
            java.util.ArrayList r1 = r5.getParcelableArrayList(r1)
        L40:
            r4.P = r1
        L42:
            java.lang.String r1 = "index"
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L4f
            int r5 = r5.getInt(r1)
            goto L50
        L4f:
            r5 = r0
        L50:
            c4.q1 r1 = new c4.q1
            r1.<init>(r4)
            t4.n r2 = r4.y0()
            androidx.viewpager2.widget.ViewPager2 r2 = r2.f10012n
            r2.setAdapter(r1)
            if (r5 <= 0) goto L69
            t4.n r1 = r4.y0()
            androidx.viewpager2.widget.ViewPager2 r1 = r1.f10012n
            r1.setCurrentItem(r5, r0)
        L69:
            t4.n r0 = r4.y0()
            androidx.viewpager2.widget.ViewPager2 r0 = r0.f10012n
            c4.r1 r1 = new c4.r1
            r1.<init>(r4)
            r0.registerOnPageChangeCallback(r1)
            r4.z0(r5)
            t4.n r5 = r4.y0()
            android.widget.TextView r5 = r5.f10011m
            android.graphics.Typeface r0 = f4.c.f4882w
            r5.setTypeface(r0)
            t4.n r5 = r4.y0()
            android.widget.ImageView r5 = r5.f10009b
            c4.n1 r0 = new c4.n1
            r1 = 0
            r0.<init>(r4, r1)
            r5.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.Gallery.onCreate(android.os.Bundle):void");
    }

    public final n y0() {
        return (n) this.O.getValue();
    }

    public final void z0(int i) {
        TextView textView = y0().f10011m;
        Integer valueOf = Integer.valueOf(i + 1);
        ArrayList arrayList = this.P;
        textView.setText(getString(2131952035, valueOf, arrayList != null ? Integer.valueOf(arrayList.size()) : null));
    }
}
