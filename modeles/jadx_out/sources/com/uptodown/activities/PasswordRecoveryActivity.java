package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.e;
import c4.k0;
import c4.w6;
import com.uptodown.activities.PasswordRecoveryActivity;
import f4.c;
import p6.m;
import t4.g0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PasswordRecoveryActivity extends k0 {
    public static final /* synthetic */ int P = 0;
    public final m O = new m(new w6(this, 0));

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0092, code lost:
    
        if (o7.c0.C(r2, r0, r1) != r12) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object y0(com.uptodown.activities.PasswordRecoveryActivity r14, v6.c r15) {
        /*
            boolean r1 = r15 instanceof c4.y6
            if (r1 == 0) goto L13
            r1 = r15
            c4.y6 r1 = (c4.y6) r1
            int r2 = r1.f2353p
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L13
            int r2 = r2 - r3
            r1.f2353p = r2
            goto L18
        L13:
            c4.y6 r1 = new c4.y6
            r1.<init>(r14, r15)
        L18:
            java.lang.Object r0 = r1.f2351n
            int r2 = r1.f2353p
            r9 = 2
            r10 = 1
            r11 = 0
            u6.a r12 = u6.a.f10762a
            if (r2 == 0) goto L41
            if (r2 == r10) goto L32
            if (r2 != r9) goto L2c
            p6.a.e(r0)
            goto L95
        L2c:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r0)
            return r11
        L32:
            kotlin.jvm.internal.x r2 = r1.f2350m
            kotlin.jvm.internal.x r4 = r1.f2349l
            kotlin.jvm.internal.x r5 = r1.f2348b
            kotlin.jvm.internal.v r6 = r1.f2347a
            p6.a.e(r0)
            r7 = r6
            r6 = r5
            r5 = r2
            goto L79
        L41:
            p6.a.e(r0)
            kotlin.jvm.internal.v r0 = new kotlin.jvm.internal.v
            r0.<init>()
            kotlin.jvm.internal.x r3 = new kotlin.jvm.internal.x
            r3.<init>()
            kotlin.jvm.internal.x r5 = new kotlin.jvm.internal.x
            r5.<init>()
            kotlin.jvm.internal.x r6 = new kotlin.jvm.internal.x
            r6.<init>()
            v7.e r2 = o7.m0.f8288a
            p7.c r13 = t7.n.f10348a
            c4.w r2 = new c4.w
            r7 = 0
            r8 = 4
            r4 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.f2347a = r0
            r1.f2348b = r3
            r1.f2349l = r5
            r1.f2350m = r6
            r1.f2353p = r10
            java.lang.Object r2 = o7.c0.C(r2, r13, r1)
            if (r2 != r12) goto L75
            goto L94
        L75:
            r7 = r0
            r4 = r5
            r5 = r6
            r6 = r3
        L79:
            v7.e r0 = o7.m0.f8288a
            v7.d r0 = v7.d.f10884a
            c4.z r2 = new c4.z
            r8 = 0
            r3 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r1.f2347a = r11
            r1.f2348b = r11
            r1.f2349l = r11
            r1.f2350m = r11
            r1.f2353p = r9
            java.lang.Object r0 = o7.c0.C(r2, r0, r1)
            if (r0 != r12) goto L95
        L94:
            return r12
        L95:
            p6.x r0 = p6.x.f8463a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.PasswordRecoveryActivity.y0(com.uptodown.activities.PasswordRecoveryActivity, v6.c):java.lang.Object");
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = z0().f9816a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Toolbar toolbar = (Toolbar) findViewById(2131363556);
        if (toolbar != null) {
            Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
            if (drawable != null) {
                toolbar.setNavigationIcon(drawable);
                toolbar.setNavigationContentDescription(getString(2131951735));
                final int i = 0;
                toolbar.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.x6

                    /* renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ PasswordRecoveryActivity f2306b;

                    {
                        this.f2306b = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i;
                        PasswordRecoveryActivity passwordRecoveryActivity = this.f2306b;
                        switch (i6) {
                            case 0:
                                int i10 = PasswordRecoveryActivity.P;
                                passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
                                break;
                            default:
                                int i11 = PasswordRecoveryActivity.P;
                                if (!l7.u.m0(passwordRecoveryActivity.z0().f9818l.getText().toString(), "", true) && !l7.u.m0(passwordRecoveryActivity.z0().f9817b.getText().toString(), "", true)) {
                                    if (!l7.u.m0(passwordRecoveryActivity.z0().f9818l.getText().toString(), passwordRecoveryActivity.z0().f9817b.getText().toString(), true)) {
                                        String string = passwordRecoveryActivity.getString(2131951997);
                                        if (string != null) {
                                            passwordRecoveryActivity.A(string);
                                            break;
                                        }
                                    } else {
                                        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(passwordRecoveryActivity), null, null, new b.s(passwordRecoveryActivity, (t6.c) null, 12), 3);
                                        break;
                                    }
                                } else {
                                    String string2 = passwordRecoveryActivity.getString(2131951996);
                                    if (string2 != null) {
                                        passwordRecoveryActivity.A(string2);
                                        break;
                                    }
                                }
                                break;
                        }
                    }
                });
            }
            TextView textView = (TextView) findViewById(2131364419);
            if (textView != null) {
                textView.setTypeface(c.f4882w);
            }
        }
        z0().f9818l.setTypeface(c.f4883x);
        z0().f9817b.setTypeface(c.f4883x);
        z0().f9820n.setTypeface(c.f4882w);
        final int i6 = 1;
        z0().f9820n.setOnClickListener(new View.OnClickListener(this) { // from class: c4.x6

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordRecoveryActivity f2306b;

            {
                this.f2306b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                PasswordRecoveryActivity passwordRecoveryActivity = this.f2306b;
                switch (i62) {
                    case 0:
                        int i10 = PasswordRecoveryActivity.P;
                        passwordRecoveryActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        int i11 = PasswordRecoveryActivity.P;
                        if (!l7.u.m0(passwordRecoveryActivity.z0().f9818l.getText().toString(), "", true) && !l7.u.m0(passwordRecoveryActivity.z0().f9817b.getText().toString(), "", true)) {
                            if (!l7.u.m0(passwordRecoveryActivity.z0().f9818l.getText().toString(), passwordRecoveryActivity.z0().f9817b.getText().toString(), true)) {
                                String string = passwordRecoveryActivity.getString(2131951997);
                                if (string != null) {
                                    passwordRecoveryActivity.A(string);
                                    break;
                                }
                            } else {
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(passwordRecoveryActivity), null, null, new b.s(passwordRecoveryActivity, (t6.c) null, 12), 3);
                                break;
                            }
                        } else {
                            String string2 = passwordRecoveryActivity.getString(2131951996);
                            if (string2 != null) {
                                passwordRecoveryActivity.A(string2);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        z0().f9819m.setOnClickListener(new e(16));
    }

    public final g0 z0() {
        return (g0) this.O.getValue();
    }
}
