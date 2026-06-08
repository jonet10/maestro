package com.uptodown.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelLazy;
import b.s;
import c4.k0;
import c4.p6;
import c4.r6;
import c4.s6;
import c4.v6;
import com.uptodown.activities.PasswordEditActivity;
import f4.c;
import kotlin.jvm.internal.y;
import o7.c0;
import p6.m;
import t4.f0;
import t7.n;
import z7.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PasswordEditActivity extends k0 {
    public static final /* synthetic */ int Q = 0;
    public final ViewModelLazy O = new ViewModelLazy(y.a(v6.class), new s6(this, 0), new r6(this), new s6(this, 1));
    public final m P = new m(new d(this, 1));

    public static final void y0(PasswordEditActivity passwordEditActivity, String str) {
        if (str.length() <= 0 || str.length() < 6) {
            passwordEditActivity.z0().f9786s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231470), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.z0().f9786s.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231315), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.length() <= 0 || str.length() > 99) {
            passwordEditActivity.z0().f9785r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231470), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.z0().f9785r.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231315), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        if (str.equals(passwordEditActivity.z0().f9778b.getText().toString())) {
            passwordEditActivity.z0().f9784q.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231315), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            passwordEditActivity.z0().f9784q.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(passwordEditActivity, 2131231470), (Drawable) null, (Drawable) null, (Drawable) null);
        }
    }

    public final void A0(EditText editText, ImageView imageView) {
        if (editText.getInputType() == 129) {
            editText.setInputType(145);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231404));
            editText.setSelection(editText.length());
        } else {
            editText.setInputType(129);
            imageView.setImageDrawable(ContextCompat.getDrawable(this, 2131231403));
            editText.setSelection(editText.length());
        }
    }

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout relativeLayout = z0().f9777a;
        relativeLayout.getClass();
        setContentView(relativeLayout);
        RelativeLayout relativeLayout2 = z0().f9777a;
        relativeLayout2.getClass();
        setContentView(relativeLayout2);
        Drawable drawable = ContextCompat.getDrawable(this, 2131230922);
        final int i = 0;
        if (drawable != null) {
            z0().f9783p.setNavigationIcon(drawable);
            z0().f9783p.setNavigationContentDescription(getString(2131951735));
            z0().f9783p.setNavigationOnClickListener(new View.OnClickListener(this) { // from class: c4.o6

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ PasswordEditActivity f1952b;

                {
                    this.f1952b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i6 = i;
                    PasswordEditActivity passwordEditActivity = this.f1952b;
                    switch (i6) {
                        case 0:
                            int i10 = PasswordEditActivity.Q;
                            passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                            break;
                        case 1:
                            int i11 = PasswordEditActivity.Q;
                            passwordEditActivity.A0(passwordEditActivity.z0().f9779l, passwordEditActivity.z0().f9781n);
                            break;
                        case 2:
                            int i12 = PasswordEditActivity.Q;
                            passwordEditActivity.A0(passwordEditActivity.z0().f9778b, passwordEditActivity.z0().f9780m);
                            break;
                        default:
                            int i13 = PasswordEditActivity.Q;
                            Activity activity = f4.c.f4875o;
                            PasswordEditActivity passwordEditActivity2 = this.f1952b;
                            t0.f.h(passwordEditActivity2, passwordEditActivity2.z0().f9779l);
                            if (passwordEditActivity2.z0().f9779l.getText().toString().length() != 0 && passwordEditActivity2.z0().f9778b.getText().toString().length() != 0) {
                                if (passwordEditActivity2.z0().f9779l.getText().toString().length() >= 6) {
                                    if (passwordEditActivity2.z0().f9779l.getText().toString().length() <= 99) {
                                        if (!kotlin.jvm.internal.l.a(passwordEditActivity2.z0().f9779l.getText().toString(), passwordEditActivity2.z0().f9778b.getText().toString())) {
                                            String string = passwordEditActivity2.getString(2131952455);
                                            string.getClass();
                                            passwordEditActivity2.A(string);
                                            break;
                                        } else {
                                            v6 v6Var = (v6) passwordEditActivity2.O.getValue();
                                            String obj = passwordEditActivity2.z0().f9779l.getText().toString();
                                            String obj2 = passwordEditActivity2.z0().f9778b.getText().toString();
                                            v6Var.getClass();
                                            obj.getClass();
                                            obj2.getClass();
                                            kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(v6Var);
                                            v7.e eVar = o7.m0.f8288a;
                                            o7.c0.s(viewModelScope, v7.d.f10884a, null, new u6(v6Var, passwordEditActivity2, obj, obj2, xVar, vVar, null), 2);
                                            break;
                                        }
                                    } else {
                                        String string2 = passwordEditActivity2.getString(2131952758);
                                        string2.getClass();
                                        passwordEditActivity2.A(string2);
                                        break;
                                    }
                                } else {
                                    String string3 = passwordEditActivity2.getString(2131952760);
                                    string3.getClass();
                                    passwordEditActivity2.A(string3);
                                    break;
                                }
                            } else {
                                String string4 = passwordEditActivity2.getString(2131951996);
                                string4.getClass();
                                passwordEditActivity2.A(string4);
                                break;
                            }
                            break;
                    }
                }
            });
        }
        z0().f9788u.setTypeface(c.f4882w);
        z0().f9779l.setTypeface(c.f4883x);
        z0().f9778b.setTypeface(c.f4883x);
        z0().f9787t.setTypeface(c.f4882w);
        z0().f9786s.setTypeface(c.f4883x);
        z0().f9785r.setTypeface(c.f4883x);
        z0().f9784q.setTypeface(c.f4883x);
        final int i6 = 1;
        z0().f9781n.setOnClickListener(new View.OnClickListener(this) { // from class: c4.o6

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f1952b;

            {
                this.f1952b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i6;
                PasswordEditActivity passwordEditActivity = this.f1952b;
                switch (i62) {
                    case 0:
                        int i10 = PasswordEditActivity.Q;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i11 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9779l, passwordEditActivity.z0().f9781n);
                        break;
                    case 2:
                        int i12 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9778b, passwordEditActivity.z0().f9780m);
                        break;
                    default:
                        int i13 = PasswordEditActivity.Q;
                        Activity activity = f4.c.f4875o;
                        PasswordEditActivity passwordEditActivity2 = this.f1952b;
                        t0.f.h(passwordEditActivity2, passwordEditActivity2.z0().f9779l);
                        if (passwordEditActivity2.z0().f9779l.getText().toString().length() != 0 && passwordEditActivity2.z0().f9778b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.z0().f9779l.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.z0().f9779l.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.z0().f9779l.getText().toString(), passwordEditActivity2.z0().f9778b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(2131952455);
                                        string.getClass();
                                        passwordEditActivity2.A(string);
                                        break;
                                    } else {
                                        v6 v6Var = (v6) passwordEditActivity2.O.getValue();
                                        String obj = passwordEditActivity2.z0().f9779l.getText().toString();
                                        String obj2 = passwordEditActivity2.z0().f9778b.getText().toString();
                                        v6Var.getClass();
                                        obj.getClass();
                                        obj2.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(v6Var);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new u6(v6Var, passwordEditActivity2, obj, obj2, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string2 = passwordEditActivity2.getString(2131952758);
                                    string2.getClass();
                                    passwordEditActivity2.A(string2);
                                    break;
                                }
                            } else {
                                String string3 = passwordEditActivity2.getString(2131952760);
                                string3.getClass();
                                passwordEditActivity2.A(string3);
                                break;
                            }
                        } else {
                            String string4 = passwordEditActivity2.getString(2131951996);
                            string4.getClass();
                            passwordEditActivity2.A(string4);
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 2;
        z0().f9780m.setOnClickListener(new View.OnClickListener(this) { // from class: c4.o6

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f1952b;

            {
                this.f1952b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i10;
                PasswordEditActivity passwordEditActivity = this.f1952b;
                switch (i62) {
                    case 0:
                        int i102 = PasswordEditActivity.Q;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i11 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9779l, passwordEditActivity.z0().f9781n);
                        break;
                    case 2:
                        int i12 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9778b, passwordEditActivity.z0().f9780m);
                        break;
                    default:
                        int i13 = PasswordEditActivity.Q;
                        Activity activity = f4.c.f4875o;
                        PasswordEditActivity passwordEditActivity2 = this.f1952b;
                        t0.f.h(passwordEditActivity2, passwordEditActivity2.z0().f9779l);
                        if (passwordEditActivity2.z0().f9779l.getText().toString().length() != 0 && passwordEditActivity2.z0().f9778b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.z0().f9779l.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.z0().f9779l.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.z0().f9779l.getText().toString(), passwordEditActivity2.z0().f9778b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(2131952455);
                                        string.getClass();
                                        passwordEditActivity2.A(string);
                                        break;
                                    } else {
                                        v6 v6Var = (v6) passwordEditActivity2.O.getValue();
                                        String obj = passwordEditActivity2.z0().f9779l.getText().toString();
                                        String obj2 = passwordEditActivity2.z0().f9778b.getText().toString();
                                        v6Var.getClass();
                                        obj.getClass();
                                        obj2.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(v6Var);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new u6(v6Var, passwordEditActivity2, obj, obj2, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string2 = passwordEditActivity2.getString(2131952758);
                                    string2.getClass();
                                    passwordEditActivity2.A(string2);
                                    break;
                                }
                            } else {
                                String string3 = passwordEditActivity2.getString(2131952760);
                                string3.getClass();
                                passwordEditActivity2.A(string3);
                                break;
                            }
                        } else {
                            String string4 = passwordEditActivity2.getString(2131951996);
                            string4.getClass();
                            passwordEditActivity2.A(string4);
                            break;
                        }
                        break;
                }
            }
        });
        z0().f9779l.addTextChangedListener(new p6(this, i));
        z0().f9778b.addTextChangedListener(new p6(this, i6));
        final int i11 = 3;
        z0().f9787t.setOnClickListener(new View.OnClickListener(this) { // from class: c4.o6

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PasswordEditActivity f1952b;

            {
                this.f1952b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = i11;
                PasswordEditActivity passwordEditActivity = this.f1952b;
                switch (i62) {
                    case 0:
                        int i102 = PasswordEditActivity.Q;
                        passwordEditActivity.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    case 1:
                        int i112 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9779l, passwordEditActivity.z0().f9781n);
                        break;
                    case 2:
                        int i12 = PasswordEditActivity.Q;
                        passwordEditActivity.A0(passwordEditActivity.z0().f9778b, passwordEditActivity.z0().f9780m);
                        break;
                    default:
                        int i13 = PasswordEditActivity.Q;
                        Activity activity = f4.c.f4875o;
                        PasswordEditActivity passwordEditActivity2 = this.f1952b;
                        t0.f.h(passwordEditActivity2, passwordEditActivity2.z0().f9779l);
                        if (passwordEditActivity2.z0().f9779l.getText().toString().length() != 0 && passwordEditActivity2.z0().f9778b.getText().toString().length() != 0) {
                            if (passwordEditActivity2.z0().f9779l.getText().toString().length() >= 6) {
                                if (passwordEditActivity2.z0().f9779l.getText().toString().length() <= 99) {
                                    if (!kotlin.jvm.internal.l.a(passwordEditActivity2.z0().f9779l.getText().toString(), passwordEditActivity2.z0().f9778b.getText().toString())) {
                                        String string = passwordEditActivity2.getString(2131952455);
                                        string.getClass();
                                        passwordEditActivity2.A(string);
                                        break;
                                    } else {
                                        v6 v6Var = (v6) passwordEditActivity2.O.getValue();
                                        String obj = passwordEditActivity2.z0().f9779l.getText().toString();
                                        String obj2 = passwordEditActivity2.z0().f9778b.getText().toString();
                                        v6Var.getClass();
                                        obj.getClass();
                                        obj2.getClass();
                                        kotlin.jvm.internal.v vVar = new kotlin.jvm.internal.v();
                                        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(v6Var);
                                        v7.e eVar = o7.m0.f8288a;
                                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new u6(v6Var, passwordEditActivity2, obj, obj2, xVar, vVar, null), 2);
                                        break;
                                    }
                                } else {
                                    String string2 = passwordEditActivity2.getString(2131952758);
                                    string2.getClass();
                                    passwordEditActivity2.A(string2);
                                    break;
                                }
                            } else {
                                String string3 = passwordEditActivity2.getString(2131952760);
                                string3.getClass();
                                passwordEditActivity2.A(string3);
                                break;
                            }
                        } else {
                            String string4 = passwordEditActivity2.getString(2131951996);
                            string4.getClass();
                            passwordEditActivity2.A(string4);
                            break;
                        }
                        break;
                }
            }
        });
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), n.f10348a, null, new s(this, (t6.c) null, 11), 2);
    }

    public final f0 z0() {
        return (f0) this.P.getValue();
    }
}
