package com.uptodown.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.room.g;
import c4.k0;
import com.uptodown.activities.ContactUsActivity;
import f4.c;
import p6.m;
import t4.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ContactUsActivity extends k0 {
    public static final /* synthetic */ int Q = 0;
    public final m O = new m(new g(this, 12));
    public boolean P;

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = y0().f9833a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        if (drawable != null) {
            y0().f9837n.setNavigationIcon(drawable);
            y0().f9837n.setNavigationContentDescription(getString(2131951735));
        }
        final int i = 0;
        y0().f9837n.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.l0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f1812b;

            {
                this.f1812b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = i;
                ContactUsActivity contactUsActivity = this.f1812b;
                switch (i6) {
                    case 0:
                        int i10 = ContactUsActivity.Q;
                        contactUsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        if (!contactUsActivity.P) {
                            contactUsActivity.y0().f9836m.setVisibility(0);
                            contactUsActivity.P = true;
                            Editable text = contactUsActivity.y0().f9834b.getText();
                            if (text != null && text.length() != 0) {
                                Editable text2 = contactUsActivity.y0().f9835l.getText();
                                if (text2 != null && text2.length() != 0) {
                                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(contactUsActivity);
                                    v7.e eVar = o7.m0.f8288a;
                                    o7.c0.s(lifecycleScope, v7.d.f10884a, null, new b.s(contactUsActivity, (t6.c) null, 4), 2);
                                    break;
                                } else {
                                    String string = contactUsActivity.getString(2131952020);
                                    string.getClass();
                                    contactUsActivity.A(string);
                                }
                            } else {
                                String string2 = contactUsActivity.getString(2131952019);
                                string2.getClass();
                                contactUsActivity.A(string2);
                            }
                            contactUsActivity.P = false;
                            contactUsActivity.y0().f9836m.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        });
        y0().f9839p.setTypeface(c.f4882w);
        y0().f9834b.setTypeface(c.f4883x);
        y0().f9834b.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: c4.m0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f1850b;

            {
                this.f1850b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i6 = i;
                ContactUsActivity contactUsActivity = this.f1850b;
                switch (i6) {
                    case 0:
                        int i10 = ContactUsActivity.Q;
                        if (!z9) {
                            contactUsActivity.y0().f9834b.setHint(contactUsActivity.getString(2131952062));
                            break;
                        } else {
                            contactUsActivity.y0().f9834b.setHint("");
                            break;
                        }
                    default:
                        int i11 = ContactUsActivity.Q;
                        if (!z9) {
                            contactUsActivity.y0().f9835l.setHint(contactUsActivity.getString(2131952066));
                            break;
                        } else {
                            contactUsActivity.y0().f9835l.setHint("");
                            break;
                        }
                }
            }
        });
        y0().f9835l.setTypeface(c.f4883x);
        final int i6 = 1;
        y0().f9835l.setOnFocusChangeListener(new View.OnFocusChangeListener(this) { // from class: c4.m0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f1850b;

            {
                this.f1850b = this;
            }

            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z9) {
                int i62 = i6;
                ContactUsActivity contactUsActivity = this.f1850b;
                switch (i62) {
                    case 0:
                        int i10 = ContactUsActivity.Q;
                        if (!z9) {
                            contactUsActivity.y0().f9834b.setHint(contactUsActivity.getString(2131952062));
                            break;
                        } else {
                            contactUsActivity.y0().f9834b.setHint("");
                            break;
                        }
                    default:
                        int i11 = ContactUsActivity.Q;
                        if (!z9) {
                            contactUsActivity.y0().f9835l.setHint(contactUsActivity.getString(2131952066));
                            break;
                        } else {
                            contactUsActivity.y0().f9835l.setHint("");
                            break;
                        }
                }
            }
        });
        y0().f9838o.setTypeface(c.f4882w);
        y0().f9838o.setOnClickListener(new View.OnClickListener(this) { // from class: c4.l0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ContactUsActivity f1812b;

            {
                this.f1812b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                ContactUsActivity contactUsActivity = this.f1812b;
                switch (i62) {
                    case 0:
                        int i10 = ContactUsActivity.Q;
                        contactUsActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    default:
                        if (!contactUsActivity.P) {
                            contactUsActivity.y0().f9836m.setVisibility(0);
                            contactUsActivity.P = true;
                            Editable text = contactUsActivity.y0().f9834b.getText();
                            if (text != null && text.length() != 0) {
                                Editable text2 = contactUsActivity.y0().f9835l.getText();
                                if (text2 != null && text2.length() != 0) {
                                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(contactUsActivity);
                                    v7.e eVar = o7.m0.f8288a;
                                    o7.c0.s(lifecycleScope, v7.d.f10884a, null, new b.s(contactUsActivity, (t6.c) null, 4), 2);
                                    break;
                                } else {
                                    String string = contactUsActivity.getString(2131952020);
                                    string.getClass();
                                    contactUsActivity.A(string);
                                }
                            } else {
                                String string2 = contactUsActivity.getString(2131952019);
                                string2.getClass();
                                contactUsActivity.A(string2);
                            }
                            contactUsActivity.P = false;
                            contactUsActivity.y0().f9836m.setVisibility(8);
                            break;
                        }
                        break;
                }
            }
        });
    }

    public final h y0() {
        return (h) this.O.getValue();
    }
}
