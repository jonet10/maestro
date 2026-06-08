package com.uptodown.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.d;
import c4.k0;
import com.uptodown.UptodownApp;
import f4.c;
import java.util.ArrayList;
import p6.m;
import t4.q;
import t4.w;
import u4.z1;
import x4.g;
import x4.j;
import x4.v1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MoreInfo extends k0 {
    public static final /* synthetic */ int V = 0;
    public g Q;
    public ArrayList R;
    public ArrayList S;
    public ArrayList T;
    public final LifecycleCoroutineScope O = LifecycleOwnerKt.getLifecycleScope(this);
    public final m P = new m(new androidx.room.g(this, 23));
    public final int U = 2;

    public static final void A0(MoreInfo moreInfo, ArrayList arrayList, LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        arrayList.getClass();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = ((v1) arrayList.get(i)).f11421a;
            if (str != null && str.length() != 0) {
                q a8 = q.a(LayoutInflater.from(moreInfo.getApplicationContext()));
                View view = a8.f10060b;
                TextView textView = a8.f10061l;
                view.setLayoutParams(layoutParams);
                textView.setTypeface(c.f4883x);
                textView.setText(((v1) arrayList.get(i)).f11421a);
                textView.setOnClickListener(new d(a8, 7));
                linearLayout.addView(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (o7.c0.C(r3, r8, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0050, code lost:
    
        if (o7.c0.C(r6, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object y0(com.uptodown.activities.MoreInfo r7, v6.c r8) {
        /*
            boolean r0 = r8 instanceof c4.y3
            if (r0 == 0) goto L13
            r0 = r8
            c4.y3 r0 = (c4.y3) r0
            int r1 = r0.f2340m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f2340m = r1
            goto L18
        L13:
            c4.y3 r0 = new c4.y3
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f2338b
            int r1 = r0.f2340m
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            p6.a.e(r8)
            goto L67
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r7)
            return r4
        L31:
            kotlin.jvm.internal.x r1 = r0.f2337a
            p6.a.e(r8)
            goto L53
        L37:
            p6.a.e(r8)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            v7.e r8 = o7.m0.f8288a
            v7.d r8 = v7.d.f10884a
            c4.z3 r6 = new c4.z3
            r6.<init>(r7, r1, r4)
            r0.f2337a = r1
            r0.f2340m = r3
            java.lang.Object r8 = o7.c0.C(r6, r8, r0)
            if (r8 != r5) goto L53
            goto L66
        L53:
            v7.e r8 = o7.m0.f8288a
            p7.c r8 = t7.n.f10348a
            c4.z3 r3 = new c4.z3
            r3.<init>(r1, r7, r4)
            r0.f2337a = r4
            r0.f2340m = r2
            java.lang.Object r7 = o7.c0.C(r3, r8, r0)
            if (r7 != r5) goto L67
        L66:
            return r5
        L67:
            p6.x r7 = p6.x.f8463a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.y0(com.uptodown.activities.MoreInfo, v6.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        if (o7.c0.C(r3, r9, r0) == r6) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        if (o7.c0.C(r4, r9, r0) != r6) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object z0(com.uptodown.activities.MoreInfo r8, v6.c r9) {
        /*
            boolean r0 = r9 instanceof c4.a4
            if (r0 == 0) goto L13
            r0 = r9
            c4.a4 r0 = (c4.a4) r0
            int r1 = r0.f1375m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1375m = r1
            goto L18
        L13:
            c4.a4 r0 = new c4.a4
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f1373b
            int r1 = r0.f1375m
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            u6.a r6 = u6.a.f10762a
            if (r1 == 0) goto L40
            if (r1 == r4) goto L3a
            if (r1 == r3) goto L34
            if (r1 != r2) goto L2e
            p6.a.e(r9)
            goto L85
        L2e:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r8)
            return r5
        L34:
            kotlin.jvm.internal.v r1 = r0.f1372a
            p6.a.e(r9)
            goto L71
        L3a:
            kotlin.jvm.internal.v r1 = r0.f1372a
            p6.a.e(r9)
            goto L5d
        L40:
            p6.a.e(r9)
            kotlin.jvm.internal.v r9 = new kotlin.jvm.internal.v
            r9.<init>()
            v7.e r1 = o7.m0.f8288a
            p7.c r1 = t7.n.f10348a
            c4.w3 r7 = new c4.w3
            r7.<init>(r8, r5, r4)
            r0.f1372a = r9
            r0.f1375m = r4
            java.lang.Object r1 = o7.c0.C(r7, r1, r0)
            if (r1 != r6) goto L5c
            goto L84
        L5c:
            r1 = r9
        L5d:
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            c4.b4 r4 = new c4.b4
            r4.<init>(r8, r1, r5)
            r0.f1372a = r1
            r0.f1375m = r3
            java.lang.Object r9 = o7.c0.C(r4, r9, r0)
            if (r9 != r6) goto L71
            goto L84
        L71:
            v7.e r9 = o7.m0.f8288a
            p7.c r9 = t7.n.f10348a
            c4.b4 r3 = new c4.b4
            r3.<init>(r1, r8, r5)
            r0.f1372a = r5
            r0.f1375m = r2
            java.lang.Object r8 = o7.c0.C(r3, r9, r0)
            if (r8 != r6) goto L85
        L84:
            return r6
        L85:
            p6.x r8 = p6.x.f8463a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.z0(com.uptodown.activities.MoreInfo, v6.c):java.lang.Object");
    }

    public final w B0() {
        return (w) this.P.getValue();
    }

    public final void C0(j jVar) {
        jVar.getClass();
        if (T()) {
            z1 z1Var = new z1();
            z1Var.f10683m = jVar;
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            float f = UptodownApp.I;
            beginTransaction.getClass();
            b4.d.C(beginTransaction, this);
            beginTransaction.add(B0().D.getId(), z1Var, (String) null).addToBackStack(String.valueOf(jVar.f11224a)).commit();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0459, code lost:
    
        if (r0.equals("in") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0462, code lost:
    
        if (r0.equals("id") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x046e, code lost:
    
        if (r0.equals("fr") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0475, code lost:
    
        if (r0.equals("es") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0481, code lost:
    
        if (r0.equals("de") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x048a, code lost:
    
        if (r0.equals("cn") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0493, code lost:
    
        if (r0.equals("ar") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x03fa, code lost:
    
        if (r0.equals("zh") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x03fe, code lost:
    
        r13 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0407, code lost:
    
        if (r0.equals("vi") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x040b, code lost:
    
        r13 = ".";
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0415, code lost:
    
        if (r0.equals("tr") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0426, code lost:
    
        if (r0.equals("ru") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x042a, code lost:
    
        r13 = " ";
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0434, code lost:
    
        if (r0.equals("ro") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x043e, code lost:
    
        if (r0.equals("pt") == false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0450, code lost:
    
        if (r0.equals("it") == false) goto L152;
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0664  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x06e6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0752  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x060b  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04a6 A[LOOP:0: B:183:0x04a0->B:185:0x04a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03e7  */
    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r19) {
        /*
            Method dump skipped, instructions count: 2106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MoreInfo.onCreate(android.os.Bundle):void");
    }
}
