package c4;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a3 implements ActivityResultCallback, TabLayoutMediator.TabConfigurationStrategy {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1370a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1371b;

    public /* synthetic */ a3(int i, MainActivity mainActivity) {
        this.f1370a = i;
        this.f1371b = mainActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        Bundle extras;
        int i = this.f1370a;
        int i6 = 2;
        t6.c cVar = null;
        MainActivity mainActivity = this.f1371b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i) {
            case 0:
                int i10 = MainActivity.G0;
                if (activityResult.getResultCode() == -1) {
                    mainActivity.E = new android.support.v4.media.g(mainActivity, 20);
                    break;
                }
                break;
            case 1:
                int i11 = MainActivity.G0;
                if (activityResult.getResultCode() != 1003) {
                    mainActivity.R();
                    break;
                } else {
                    j5.g l10 = j5.g.D.l(mainActivity);
                    l10.b();
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("responses", null, null);
                    l10.c();
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                }
            case 2:
                int i12 = MainActivity.G0;
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    mainActivity.u1();
                    u4.f1 f1Var = mainActivity.f3317p0;
                    if (f1Var != null) {
                        f1Var.a().f9935s.setVisibility(8);
                        f1Var.a().f9929m.setVisibility(0);
                        break;
                    }
                } else if (resultCode == 1) {
                    x4.w2 z02 = mainActivity.z0();
                    ArrayList arrayList = mainActivity.U;
                    if (z02 != null && mainActivity.W != null) {
                        int size = arrayList.size();
                        int i13 = mainActivity.T;
                        if (size > i13 && ((x4.e3) arrayList.get(i13)).f11141a == 5) {
                            mainActivity.Q0();
                        }
                    }
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(mainActivity);
                    lifecycleScope.getClass();
                    float f = UptodownApp.I;
                    b4.d.A(mainActivity);
                    b4.d.z(mainActivity);
                    v7.e eVar = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope, v7.d.f10884a, null, new a6(mainActivity, cVar, i6), 2);
                    mainActivity.u1();
                    break;
                }
                break;
            case 3:
                int i14 = MainActivity.G0;
                int resultCode2 = activityResult.getResultCode();
                if (resultCode2 == -1) {
                    mainActivity.u1();
                    u4.f1 f1Var2 = mainActivity.f3317p0;
                    if (f1Var2 != null) {
                        f1Var2.a().f9935s.setVisibility(8);
                        f1Var2.a().f9929m.setVisibility(0);
                        break;
                    }
                } else if (resultCode2 == 1) {
                    if (mainActivity.z0() != null) {
                        mainActivity.t1();
                    }
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(mainActivity);
                    lifecycleScope2.getClass();
                    float f10 = UptodownApp.I;
                    b4.d.A(mainActivity);
                    b4.d.z(mainActivity);
                    v7.e eVar2 = o7.m0.f8288a;
                    o7.c0.s(lifecycleScope2, v7.d.f10884a, null, new a6(mainActivity, cVar, i6), 2);
                    mainActivity.u1();
                    break;
                } else if (resultCode2 == 1003) {
                    mainActivity.finish();
                    mainActivity.startActivity(mainActivity.getIntent());
                    break;
                }
                break;
            case 4:
                int i15 = MainActivity.G0;
                if (activityResult.getResultCode() == 10) {
                    Intent data = activityResult.getData();
                    String string = (data == null || (extras = data.getExtras()) == null) ? null : extras.getString("realPath");
                    if (string != null && string.length() != 0) {
                        mainActivity.V(new File(string), null);
                        break;
                    }
                }
                break;
            default:
                int i16 = MainActivity.G0;
                a3.d dVar = new a3.d(mainActivity, 7);
                LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(mainActivity);
                v7.e eVar3 = o7.m0.f8288a;
                o7.c0.s(lifecycleScope3, v7.d.f10884a, null, new b.n(mainActivity, dVar, cVar, 16), 2);
                break;
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        int i6 = MainActivity.G0;
        tab.getClass();
        MainActivity mainActivity = this.f1371b;
        if (i == 0) {
            tab.setContentDescription(mainActivity.getString(2131951782));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, 2131231173));
            return;
        }
        if (i == 1) {
            tab.setContentDescription(mainActivity.getString(2131952658));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, 2131231172));
            return;
        }
        if (i == 2) {
            tab.setContentDescription(mainActivity.getString(2131951720));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, 2131231169));
        } else {
            if (i != 3) {
                return;
            }
            tab.setContentDescription(mainActivity.getString(2131952366));
            x4.w2 h = x4.u2.h(mainActivity);
            if (h == null || !h.f11445y) {
                tab.setIcon(ContextCompat.getDrawable(mainActivity, 2131231170));
            } else {
                tab.setIcon(ContextCompat.getDrawable(mainActivity, 2131231171));
            }
        }
    }
}
