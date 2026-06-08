package com.uptodown.activities.preferences;

import a4.d0;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import androidx.viewbinding.ViewBindings;
import c.e;
import c4.k0;
import c4.t;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.activities.preferences.PreferencesActivity;
import d7.a;
import d7.l;
import e1.v4;
import f4.c;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.v;
import p6.m;
import t4.h0;
import t4.i0;
import x4.m2;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class PreferencesActivity extends k0 {
    public static final /* synthetic */ int T = 0;
    public final m O;
    public final m P;
    public m2 Q;
    public final ActivityResultLauncher R;
    public final ActivityResultLauncher S;

    public PreferencesActivity() {
        final int i = 0;
        this.O = new m(new a(this) { // from class: d4.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f3593b;

            {
                this.f3593b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                int i6 = i;
                PreferencesActivity preferencesActivity = this.f3593b;
                switch (i6) {
                    case 0:
                        int i10 = PreferencesActivity.T;
                        View inflate = preferencesActivity.getLayoutInflater().inflate(2131558790, (ViewGroup) null, false);
                        int i11 = 2131361813;
                        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131361813);
                        if (findChildViewById != null) {
                            h0 a8 = h0.a(findChildViewById);
                            i11 = 2131361814;
                            View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131361814);
                            if (findChildViewById2 != null) {
                                h0 a10 = h0.a(findChildViewById2);
                                i11 = 2131361906;
                                View findChildViewById3 = ViewBindings.findChildViewById(inflate, 2131361906);
                                if (findChildViewById3 != null) {
                                    h0 a11 = h0.a(findChildViewById3);
                                    i11 = 2131361908;
                                    View findChildViewById4 = ViewBindings.findChildViewById(inflate, 2131361908);
                                    if (findChildViewById4 != null) {
                                        h0 a12 = h0.a(findChildViewById4);
                                        i11 = 2131361909;
                                        View findChildViewById5 = ViewBindings.findChildViewById(inflate, 2131361909);
                                        if (findChildViewById5 != null) {
                                            b5.m z9 = b5.m.z(findChildViewById5);
                                            i11 = 2131361932;
                                            View findChildViewById6 = ViewBindings.findChildViewById(inflate, 2131361932);
                                            if (findChildViewById6 != null) {
                                                d0 g = d0.g(findChildViewById6);
                                                i11 = 2131362116;
                                                View findChildViewById7 = ViewBindings.findChildViewById(inflate, 2131362116);
                                                if (findChildViewById7 != null) {
                                                    d0 g3 = d0.g(findChildViewById7);
                                                    i11 = 2131362169;
                                                    View findChildViewById8 = ViewBindings.findChildViewById(inflate, 2131362169);
                                                    if (findChildViewById8 != null) {
                                                        m8.q c9 = m8.q.c(findChildViewById8);
                                                        i11 = 2131362278;
                                                        View findChildViewById9 = ViewBindings.findChildViewById(inflate, 2131362278);
                                                        if (findChildViewById9 != null) {
                                                            d0 g10 = d0.g(findChildViewById9);
                                                            i11 = 2131362279;
                                                            View findChildViewById10 = ViewBindings.findChildViewById(inflate, 2131362279);
                                                            if (findChildViewById10 != null) {
                                                                d0 g11 = d0.g(findChildViewById10);
                                                                i11 = 2131362567;
                                                                View findChildViewById11 = ViewBindings.findChildViewById(inflate, 2131362567);
                                                                if (findChildViewById11 != null) {
                                                                    h0 a13 = h0.a(findChildViewById11);
                                                                    i11 = 2131362709;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362709);
                                                                    if (linearLayout != null) {
                                                                        i11 = 2131362885;
                                                                        View findChildViewById12 = ViewBindings.findChildViewById(inflate, 2131362885);
                                                                        if (findChildViewById12 != null) {
                                                                            b5.m z10 = b5.m.z(findChildViewById12);
                                                                            i11 = 2131362893;
                                                                            View findChildViewById13 = ViewBindings.findChildViewById(inflate, 2131362893);
                                                                            if (findChildViewById13 != null) {
                                                                                m8.q c10 = m8.q.c(findChildViewById13);
                                                                                i11 = 2131362942;
                                                                                View findChildViewById14 = ViewBindings.findChildViewById(inflate, 2131362942);
                                                                                if (findChildViewById14 != null) {
                                                                                    m8.q c11 = m8.q.c(findChildViewById14);
                                                                                    i11 = 2131363028;
                                                                                    View findChildViewById15 = ViewBindings.findChildViewById(inflate, 2131363028);
                                                                                    if (findChildViewById15 != null) {
                                                                                        m8.q c12 = m8.q.c(findChildViewById15);
                                                                                        i11 = 2131363044;
                                                                                        View findChildViewById16 = ViewBindings.findChildViewById(inflate, 2131363044);
                                                                                        if (findChildViewById16 != null) {
                                                                                            m8.q c13 = m8.q.c(findChildViewById16);
                                                                                            i11 = 2131363046;
                                                                                            View findChildViewById17 = ViewBindings.findChildViewById(inflate, 2131363046);
                                                                                            if (findChildViewById17 != null) {
                                                                                                h0 a14 = h0.a(findChildViewById17);
                                                                                                i11 = 2131363054;
                                                                                                View findChildViewById18 = ViewBindings.findChildViewById(inflate, 2131363054);
                                                                                                if (findChildViewById18 != null) {
                                                                                                    d0 g12 = d0.g(findChildViewById18);
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) inflate;
                                                                                                    i11 = 2131363306;
                                                                                                    View findChildViewById19 = ViewBindings.findChildViewById(inflate, 2131363306);
                                                                                                    if (findChildViewById19 != null) {
                                                                                                        m8.q c14 = m8.q.c(findChildViewById19);
                                                                                                        i11 = 2131363429;
                                                                                                        View findChildViewById20 = ViewBindings.findChildViewById(inflate, 2131363429);
                                                                                                        if (findChildViewById20 != null) {
                                                                                                            d0 g13 = d0.g(findChildViewById20);
                                                                                                            i11 = 2131363476;
                                                                                                            View findChildViewById21 = ViewBindings.findChildViewById(inflate, 2131363476);
                                                                                                            if (findChildViewById21 != null) {
                                                                                                                h0 a15 = h0.a(findChildViewById21);
                                                                                                                i11 = 2131363558;
                                                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363558);
                                                                                                                if (toolbar != null) {
                                                                                                                    i11 = 2131363583;
                                                                                                                    View findChildViewById22 = ViewBindings.findChildViewById(inflate, 2131363583);
                                                                                                                    if (findChildViewById22 != null) {
                                                                                                                        h0 a16 = h0.a(findChildViewById22);
                                                                                                                        i11 = 2131364451;
                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364451);
                                                                                                                        if (textView != null) {
                                                                                                                            i11 = 2131364622;
                                                                                                                            View findChildViewById23 = ViewBindings.findChildViewById(inflate, 2131364622);
                                                                                                                            if (findChildViewById23 != null) {
                                                                                                                                m8.q c15 = m8.q.c(findChildViewById23);
                                                                                                                                i11 = 2131364623;
                                                                                                                                View findChildViewById24 = ViewBindings.findChildViewById(inflate, 2131364623);
                                                                                                                                if (findChildViewById24 != null) {
                                                                                                                                    b5.m z11 = b5.m.z(findChildViewById24);
                                                                                                                                    i11 = 2131364624;
                                                                                                                                    View findChildViewById25 = ViewBindings.findChildViewById(inflate, 2131364624);
                                                                                                                                    if (findChildViewById25 != null) {
                                                                                                                                        return new i0(linearLayout2, a8, a10, a11, a12, z9, g, g3, c9, g10, g11, a13, linearLayout, z10, c10, c11, c12, c13, a14, g12, c14, g13, a15, toolbar, a16, textView, c15, z11, d0.g(findChildViewById25));
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                        return null;
                    default:
                        int i12 = PreferencesActivity.T;
                        return new h4.a(preferencesActivity);
                }
            }
        });
        final int i6 = 1;
        this.P = new m(new a(this) { // from class: d4.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f3593b;

            {
                this.f3593b = this;
            }

            @Override // d7.a
            public final Object invoke() {
                int i62 = i6;
                PreferencesActivity preferencesActivity = this.f3593b;
                switch (i62) {
                    case 0:
                        int i10 = PreferencesActivity.T;
                        View inflate = preferencesActivity.getLayoutInflater().inflate(2131558790, (ViewGroup) null, false);
                        int i11 = 2131361813;
                        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131361813);
                        if (findChildViewById != null) {
                            h0 a8 = h0.a(findChildViewById);
                            i11 = 2131361814;
                            View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131361814);
                            if (findChildViewById2 != null) {
                                h0 a10 = h0.a(findChildViewById2);
                                i11 = 2131361906;
                                View findChildViewById3 = ViewBindings.findChildViewById(inflate, 2131361906);
                                if (findChildViewById3 != null) {
                                    h0 a11 = h0.a(findChildViewById3);
                                    i11 = 2131361908;
                                    View findChildViewById4 = ViewBindings.findChildViewById(inflate, 2131361908);
                                    if (findChildViewById4 != null) {
                                        h0 a12 = h0.a(findChildViewById4);
                                        i11 = 2131361909;
                                        View findChildViewById5 = ViewBindings.findChildViewById(inflate, 2131361909);
                                        if (findChildViewById5 != null) {
                                            b5.m z9 = b5.m.z(findChildViewById5);
                                            i11 = 2131361932;
                                            View findChildViewById6 = ViewBindings.findChildViewById(inflate, 2131361932);
                                            if (findChildViewById6 != null) {
                                                d0 g = d0.g(findChildViewById6);
                                                i11 = 2131362116;
                                                View findChildViewById7 = ViewBindings.findChildViewById(inflate, 2131362116);
                                                if (findChildViewById7 != null) {
                                                    d0 g3 = d0.g(findChildViewById7);
                                                    i11 = 2131362169;
                                                    View findChildViewById8 = ViewBindings.findChildViewById(inflate, 2131362169);
                                                    if (findChildViewById8 != null) {
                                                        m8.q c9 = m8.q.c(findChildViewById8);
                                                        i11 = 2131362278;
                                                        View findChildViewById9 = ViewBindings.findChildViewById(inflate, 2131362278);
                                                        if (findChildViewById9 != null) {
                                                            d0 g10 = d0.g(findChildViewById9);
                                                            i11 = 2131362279;
                                                            View findChildViewById10 = ViewBindings.findChildViewById(inflate, 2131362279);
                                                            if (findChildViewById10 != null) {
                                                                d0 g11 = d0.g(findChildViewById10);
                                                                i11 = 2131362567;
                                                                View findChildViewById11 = ViewBindings.findChildViewById(inflate, 2131362567);
                                                                if (findChildViewById11 != null) {
                                                                    h0 a13 = h0.a(findChildViewById11);
                                                                    i11 = 2131362709;
                                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362709);
                                                                    if (linearLayout != null) {
                                                                        i11 = 2131362885;
                                                                        View findChildViewById12 = ViewBindings.findChildViewById(inflate, 2131362885);
                                                                        if (findChildViewById12 != null) {
                                                                            b5.m z10 = b5.m.z(findChildViewById12);
                                                                            i11 = 2131362893;
                                                                            View findChildViewById13 = ViewBindings.findChildViewById(inflate, 2131362893);
                                                                            if (findChildViewById13 != null) {
                                                                                m8.q c10 = m8.q.c(findChildViewById13);
                                                                                i11 = 2131362942;
                                                                                View findChildViewById14 = ViewBindings.findChildViewById(inflate, 2131362942);
                                                                                if (findChildViewById14 != null) {
                                                                                    m8.q c11 = m8.q.c(findChildViewById14);
                                                                                    i11 = 2131363028;
                                                                                    View findChildViewById15 = ViewBindings.findChildViewById(inflate, 2131363028);
                                                                                    if (findChildViewById15 != null) {
                                                                                        m8.q c12 = m8.q.c(findChildViewById15);
                                                                                        i11 = 2131363044;
                                                                                        View findChildViewById16 = ViewBindings.findChildViewById(inflate, 2131363044);
                                                                                        if (findChildViewById16 != null) {
                                                                                            m8.q c13 = m8.q.c(findChildViewById16);
                                                                                            i11 = 2131363046;
                                                                                            View findChildViewById17 = ViewBindings.findChildViewById(inflate, 2131363046);
                                                                                            if (findChildViewById17 != null) {
                                                                                                h0 a14 = h0.a(findChildViewById17);
                                                                                                i11 = 2131363054;
                                                                                                View findChildViewById18 = ViewBindings.findChildViewById(inflate, 2131363054);
                                                                                                if (findChildViewById18 != null) {
                                                                                                    d0 g12 = d0.g(findChildViewById18);
                                                                                                    LinearLayout linearLayout2 = (LinearLayout) inflate;
                                                                                                    i11 = 2131363306;
                                                                                                    View findChildViewById19 = ViewBindings.findChildViewById(inflate, 2131363306);
                                                                                                    if (findChildViewById19 != null) {
                                                                                                        m8.q c14 = m8.q.c(findChildViewById19);
                                                                                                        i11 = 2131363429;
                                                                                                        View findChildViewById20 = ViewBindings.findChildViewById(inflate, 2131363429);
                                                                                                        if (findChildViewById20 != null) {
                                                                                                            d0 g13 = d0.g(findChildViewById20);
                                                                                                            i11 = 2131363476;
                                                                                                            View findChildViewById21 = ViewBindings.findChildViewById(inflate, 2131363476);
                                                                                                            if (findChildViewById21 != null) {
                                                                                                                h0 a15 = h0.a(findChildViewById21);
                                                                                                                i11 = 2131363558;
                                                                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363558);
                                                                                                                if (toolbar != null) {
                                                                                                                    i11 = 2131363583;
                                                                                                                    View findChildViewById22 = ViewBindings.findChildViewById(inflate, 2131363583);
                                                                                                                    if (findChildViewById22 != null) {
                                                                                                                        h0 a16 = h0.a(findChildViewById22);
                                                                                                                        i11 = 2131364451;
                                                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364451);
                                                                                                                        if (textView != null) {
                                                                                                                            i11 = 2131364622;
                                                                                                                            View findChildViewById23 = ViewBindings.findChildViewById(inflate, 2131364622);
                                                                                                                            if (findChildViewById23 != null) {
                                                                                                                                m8.q c15 = m8.q.c(findChildViewById23);
                                                                                                                                i11 = 2131364623;
                                                                                                                                View findChildViewById24 = ViewBindings.findChildViewById(inflate, 2131364623);
                                                                                                                                if (findChildViewById24 != null) {
                                                                                                                                    b5.m z11 = b5.m.z(findChildViewById24);
                                                                                                                                    i11 = 2131364624;
                                                                                                                                    View findChildViewById25 = ViewBindings.findChildViewById(inflate, 2131364624);
                                                                                                                                    if (findChildViewById25 != null) {
                                                                                                                                        return new i0(linearLayout2, a8, a10, a11, a12, z9, g, g3, c9, g10, g11, a13, linearLayout, z10, c10, c11, c12, c13, a14, g12, c14, g13, a15, toolbar, a16, textView, c15, z11, d0.g(findChildViewById25));
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                        return null;
                    default:
                        int i12 = PreferencesActivity.T;
                        return new h4.a(preferencesActivity);
                }
            }
        });
        final int i10 = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: d4.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f3597b;

            {
                this.f3597b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i11 = i10;
                PreferencesActivity preferencesActivity = this.f3597b;
                switch (i11) {
                    case 0:
                        int i12 = PreferencesActivity.T;
                        if (((ActivityResult) obj).getResultCode() == 1003) {
                            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
                            preferencesActivity.finish();
                            preferencesActivity.startActivity(preferencesActivity.getIntent());
                            break;
                        }
                        break;
                    default:
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        int i13 = PreferencesActivity.T;
                        int i14 = 0;
                        if (!booleanValue) {
                            ((SwitchCompat) preferencesActivity.z0().E.f83m).setChecked(false);
                            preferencesActivity.B0();
                            int i15 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).getInt("notification_permission_request_api33", -1) + 1;
                            SharedPreferences sharedPreferences = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences.getClass();
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putInt("notification_permission_request_api33", i15);
                            edit.apply();
                            if (Build.VERSION.SDK_INT >= 33 && i15 >= 2 && ContextCompat.checkSelfPermission(preferencesActivity, "android.permission.POST_NOTIFICATIONS") != 0) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(preferencesActivity);
                                builder.setTitle(2131952651);
                                builder.setMessage(2131951916);
                                builder.setPositiveButton(2131951759, new p(preferencesActivity, i14));
                                builder.create().show();
                                break;
                            }
                        } else {
                            SharedPreferences sharedPreferences2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences2.getClass();
                            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                            edit2.putBoolean("recibir_notificaciones", true);
                            edit2.apply();
                            preferencesActivity.C0();
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult.getClass();
        this.R = registerForActivityResult;
        final int i11 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback(this) { // from class: d4.q

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PreferencesActivity f3597b;

            {
                this.f3597b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                int i112 = i11;
                PreferencesActivity preferencesActivity = this.f3597b;
                switch (i112) {
                    case 0:
                        int i12 = PreferencesActivity.T;
                        if (((ActivityResult) obj).getResultCode() == 1003) {
                            preferencesActivity.setResult(PointerIconCompat.TYPE_HELP);
                            preferencesActivity.finish();
                            preferencesActivity.startActivity(preferencesActivity.getIntent());
                            break;
                        }
                        break;
                    default:
                        boolean booleanValue = ((Boolean) obj).booleanValue();
                        int i13 = PreferencesActivity.T;
                        int i14 = 0;
                        if (!booleanValue) {
                            ((SwitchCompat) preferencesActivity.z0().E.f83m).setChecked(false);
                            preferencesActivity.B0();
                            int i15 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0).getInt("notification_permission_request_api33", -1) + 1;
                            SharedPreferences sharedPreferences = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences.getClass();
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putInt("notification_permission_request_api33", i15);
                            edit.apply();
                            if (Build.VERSION.SDK_INT >= 33 && i15 >= 2 && ContextCompat.checkSelfPermission(preferencesActivity, "android.permission.POST_NOTIFICATIONS") != 0) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(preferencesActivity);
                                builder.setTitle(2131952651);
                                builder.setMessage(2131951916);
                                builder.setPositiveButton(2131951759, new p(preferencesActivity, i14));
                                builder.create().show();
                                break;
                            }
                        } else {
                            SharedPreferences sharedPreferences2 = preferencesActivity.getSharedPreferences("SettingsPreferences", 0);
                            sharedPreferences2.getClass();
                            SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                            edit2.putBoolean("recibir_notificaciones", true);
                            edit2.apply();
                            preferencesActivity.C0();
                            break;
                        }
                        break;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.S = registerForActivityResult2;
    }

    public final String A0() {
        int parseInt = Integer.parseInt(z3.u(this));
        if (parseInt == 1) {
            String string = getString(2131952716);
            string.getClass();
            return string;
        }
        if (parseInt == 2) {
            String string2 = getString(2131952717);
            string2.getClass();
            return string2;
        }
        if (parseInt == 3) {
            String string3 = getString(2131952719);
            string3.getClass();
            return string3;
        }
        if (parseInt != 4) {
            return "";
        }
        String string4 = getString(2131952718);
        string4.getClass();
        return string4;
    }

    public final void B0() {
        ((TextView) z0().E.f84n).setText(getString(2131951951));
        v4 v4Var = new v4(this, 1);
        RelativeLayout relativeLayout = (RelativeLayout) z0().K.f1061b;
        relativeLayout.getClass();
        v4Var.g(relativeLayout, 0.3f);
        v4 v4Var2 = new v4(this, 1);
        RelativeLayout relativeLayout2 = (RelativeLayout) z0().f9884q.f81b;
        relativeLayout2.getClass();
        v4Var2.g(relativeLayout2, 0.3f);
        ((SwitchCompat) z0().f9884q.f83m).setClickable(false);
        v4 v4Var3 = new v4(this, 1);
        RelativeLayout relativeLayout3 = (RelativeLayout) z0().f9887t.f81b;
        relativeLayout3.getClass();
        v4Var3.g(relativeLayout3, 0.3f);
        ((SwitchCompat) z0().f9887t.f83m).setClickable(false);
        v4 v4Var4 = new v4(this, 1);
        RelativeLayout relativeLayout4 = (RelativeLayout) z0().f9886s.f81b;
        relativeLayout4.getClass();
        v4Var4.g(relativeLayout4, 0.3f);
        ((SwitchCompat) z0().f9886s.f83m).setClickable(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C0() {
        /*
            r5 = this;
            t4.i0 r0 = r5.z0()
            a4.d0 r0 = r0.E
            java.lang.Object r0 = r0.f84n
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 2131951984(0x7f130170, float:1.9540398E38)
            java.lang.String r1 = r5.getString(r1)
            r0.setText(r1)
            java.lang.String r0 = "updates_active"
            r1 = 1
            java.lang.String r2 = "SettingsPreferences"
            r3 = 0
            android.content.SharedPreferences r2 = r5.getSharedPreferences(r2, r3)     // Catch: java.lang.Exception -> L29
            boolean r3 = r2.contains(r0)     // Catch: java.lang.Exception -> L29
            if (r3 == 0) goto L29
            boolean r0 = r2.getBoolean(r0, r1)     // Catch: java.lang.Exception -> L29
            goto L2a
        L29:
            r0 = r1
        L2a:
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L44
            e1.v4 r0 = new e1.v4
            r0.<init>(r5, r1)
            t4.i0 r3 = r5.z0()
            b5.m r3 = r3.K
            java.lang.Object r3 = r3.f1061b
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.getClass()
            r0.g(r3, r2)
            goto L5c
        L44:
            e1.v4 r0 = new e1.v4
            r0.<init>(r5, r1)
            t4.i0 r3 = r5.z0()
            b5.m r3 = r3.K
            java.lang.Object r3 = r3.f1061b
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.getClass()
            r4 = 1050253722(0x3e99999a, float:0.3)
            r0.g(r3, r4)
        L5c:
            e1.v4 r0 = new e1.v4
            r0.<init>(r5, r1)
            t4.i0 r3 = r5.z0()
            a4.d0 r3 = r3.f9884q
            java.lang.Object r3 = r3.f81b
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.getClass()
            r0.g(r3, r2)
            t4.i0 r0 = r5.z0()
            a4.d0 r0 = r0.f9884q
            java.lang.Object r0 = r0.f83m
            androidx.appcompat.widget.SwitchCompat r0 = (androidx.appcompat.widget.SwitchCompat) r0
            r0.setClickable(r1)
            e1.v4 r0 = new e1.v4
            r0.<init>(r5, r1)
            t4.i0 r3 = r5.z0()
            a4.d0 r3 = r3.f9887t
            java.lang.Object r3 = r3.f81b
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.getClass()
            r0.g(r3, r2)
            t4.i0 r0 = r5.z0()
            a4.d0 r0 = r0.f9887t
            java.lang.Object r0 = r0.f83m
            androidx.appcompat.widget.SwitchCompat r0 = (androidx.appcompat.widget.SwitchCompat) r0
            r0.setClickable(r1)
            e1.v4 r0 = new e1.v4
            r0.<init>(r5, r1)
            t4.i0 r3 = r5.z0()
            a4.d0 r3 = r3.f9886s
            java.lang.Object r3 = r3.f81b
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            r3.getClass()
            r0.g(r3, r2)
            t4.i0 r0 = r5.z0()
            a4.d0 r0 = r0.f9886s
            java.lang.Object r0 = r0.f83m
            androidx.appcompat.widget.SwitchCompat r0 = (androidx.appcompat.widget.SwitchCompat) r0
            r0.setClickable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.C0():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
    
        if (r2.equalsIgnoreCase(r3) != false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        if (r3 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
    
        if (r0.f11287b != r1.f11287b) goto L13;
     */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void finish() {
        /*
            r7 = this;
            x4.m2 r1 = new x4.m2
            r1.<init>(r7)
            x4.m2 r0 = r7.Q
            if (r0 == 0) goto L20
            java.lang.String r2 = r0.f11286a
            java.lang.String r3 = r1.f11286a
            if (r2 != 0) goto L11
            if (r3 == 0) goto L19
        L11:
            if (r2 == 0) goto L20
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L20
        L19:
            boolean r0 = r0.f11287b
            boolean r2 = r1.f11287b
            if (r0 != r2) goto L20
            goto L39
        L20:
            x4.p r3 = new x4.p
            r3.<init>()
            r3.f(r7)
            androidx.lifecycle.LifecycleCoroutineScope r6 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            b6.g r0 = new b6.g
            r5 = 15
            r4 = 0
            r2 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r1 = 3
            o7.c0.s(r6, r4, r4, r0, r1)
        L39:
            super.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.finish():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(42:0|1|(1:3)|4|(1:6)|7|(2:8|9)|(34:11|12|(1:(2:14|(2:17|18)(1:16))(2:84|85))|19|(1:21)(1:83)|22|23|24|(24:26|27|(1:79)(1:31)|32|(1:34)(1:78)|35|(1:37)(1:77)|38|(1:40)(2:74|(1:76))|41|(2:43|(1:45)(1:72))(1:73)|46|(1:48)|49|(1:51)|52|(4:54|(2:57|55)|58|59)|60|61|62|(1:64)|(1:67)|68|69)|81|27|(1:29)|79|32|(0)(0)|35|(0)(0)|38|(0)(0)|41|(0)(0)|46|(0)|49|(0)|52|(0)|60|61|62|(0)|(0)|68|69)|87|12|(2:(0)(0)|16)|19|(0)(0)|22|23|24|(0)|81|27|(0)|79|32|(0)(0)|35|(0)(0)|38|(0)(0)|41|(0)(0)|46|(0)|49|(0)|52|(0)|60|61|62|(0)|(0)|68|69) */
    /* JADX WARN: Can't wrap try/catch for region: R(43:0|1|(1:3)|4|(1:6)|7|8|9|(34:11|12|(1:(2:14|(2:17|18)(1:16))(2:84|85))|19|(1:21)(1:83)|22|23|24|(24:26|27|(1:79)(1:31)|32|(1:34)(1:78)|35|(1:37)(1:77)|38|(1:40)(2:74|(1:76))|41|(2:43|(1:45)(1:72))(1:73)|46|(1:48)|49|(1:51)|52|(4:54|(2:57|55)|58|59)|60|61|62|(1:64)|(1:67)|68|69)|81|27|(1:29)|79|32|(0)(0)|35|(0)(0)|38|(0)(0)|41|(0)(0)|46|(0)|49|(0)|52|(0)|60|61|62|(0)|(0)|68|69)|87|12|(2:(0)(0)|16)|19|(0)(0)|22|23|24|(0)|81|27|(0)|79|32|(0)(0)|35|(0)(0)|38|(0)(0)|41|(0)(0)|46|(0)|49|(0)|52|(0)|60|61|62|(0)|(0)|68|69) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0255 A[Catch: Exception -> 0x025a, TRY_LEAVE, TryCatch #0 {Exception -> 0x025a, blocks: (B:24:0x0249, B:26:0x0255), top: B:23:0x0249 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x06a0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0811 A[Catch: Exception -> 0x0815, TRY_LEAVE, TryCatch #2 {Exception -> 0x0815, blocks: (B:62:0x0807, B:64:0x0811), top: B:61:0x0807 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x067c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x064b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e0 A[SYNTHETIC] */
    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onCreate(android.os.Bundle r17) {
        /*
            Method dump skipped, instructions count: 2358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.preferences.PreferencesActivity.onCreate(android.os.Bundle):void");
    }

    public final void y0(String str, HashMap hashMap, int i, l lVar) {
        AlertDialog alertDialog;
        if (isFinishing()) {
            return;
        }
        AlertDialog alertDialog2 = this.F;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        s x3 = s.x(getLayoutInflater());
        TextView textView = (TextView) x3.f11757m;
        TextView textView2 = (TextView) x3.f11758n;
        v vVar = new v();
        vVar.f7022a = i;
        textView2.setTypeface(c.f4882w);
        textView2.setText(str);
        for (Map.Entry entry : hashMap.entrySet()) {
            View inflate = getLayoutInflater().inflate(2131558819, (ViewGroup) null, false);
            if (inflate == null) {
                com.google.gson.internal.a.i("rootView");
                return;
            }
            RadioButton radioButton = (RadioButton) inflate;
            radioButton.setId(((Number) entry.getKey()).intValue());
            radioButton.setTypeface(c.f4883x);
            radioButton.setText((CharSequence) entry.getValue());
            radioButton.setOnClickListener(new e(22, vVar, entry));
            if (((Number) entry.getKey()).intValue() == i) {
                radioButton.setChecked(true);
            }
            ((RadioGroup) x3.f11756l).addView(radioButton);
        }
        textView.setTypeface(c.f4882w);
        textView.setOnClickListener(new t(lVar, vVar, this, 11));
        builder.setView((LinearLayout) x3.f11755b);
        this.F = builder.create();
        if (isFinishing() || (alertDialog = this.F) == null) {
            return;
        }
        alertDialog.setCancelable(true);
        u0();
    }

    public final i0 z0() {
        return (i0) this.O.getValue();
    }
}
