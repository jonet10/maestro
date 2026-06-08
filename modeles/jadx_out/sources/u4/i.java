package u4;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.SearchActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import x4.u2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class i implements ActivityResultCallback, Toolbar.OnMenuItemClickListener, NestedScrollView.OnScrollChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10502a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10503b;

    public /* synthetic */ i(f0 f0Var, int i) {
        this.f10502a = i;
        this.f10503b = f0Var;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.f10502a;
        int i6 = 1;
        f0 f0Var = this.f10503b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i) {
            case 0:
                q1.a aVar = new q1.a(8);
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(f0Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, v7.d.f10884a, null, new d0(f0Var, aVar, null, i6), 2);
                break;
            default:
                if (activityResult.getResultCode() == 1) {
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    if (u2.g(requireContext)) {
                        Context requireContext2 = f0Var.requireContext();
                        requireContext2.getClass();
                        u2.i(requireContext2, LifecycleOwnerKt.getLifecycleScope(f0Var));
                        if (((CharSequence) f0Var.G().H.getValue()).length() > 0) {
                            f0Var.Z((String) f0Var.G().H.getValue());
                            FragmentActivity activity = f0Var.getActivity();
                            activity.getClass();
                            AlertDialog alertDialog = ((c4.k0) activity).F;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                        }
                        f0Var.q();
                        break;
                    }
                }
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        FragmentActivity activity;
        String str;
        menuItem.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            int itemId = menuItem.getItemId();
            f0 f0Var = this.f10503b;
            if (itemId == 2131361892) {
                FragmentActivity activity2 = f0Var.getActivity();
                activity2.getClass();
                if (((c4.k0) activity2).T()) {
                    Intent intent = new Intent(f0Var.getContext(), (Class<?>) SearchActivity.class);
                    intent.setFlags(603979776);
                    FragmentActivity requireActivity = f0Var.requireActivity();
                    requireActivity.getClass();
                    f0Var.startActivity(intent, b4.d.a(requireActivity));
                    return true;
                }
            } else {
                t6.c cVar = null;
                if (menuItem.getItemId() == 2131361893) {
                    if (f0Var.getContext() != null) {
                        LifecycleOwner viewLifecycleOwner = f0Var.getViewLifecycleOwner();
                        viewLifecycleOwner.getClass();
                        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new w(f0Var, cVar, 22), 3);
                        return true;
                    }
                } else if (menuItem.getItemId() == 2131361887) {
                    if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing() && (str = f0Var.B().f11174n) != null && str.length() != 0) {
                        FragmentActivity activity3 = f0Var.getActivity();
                        activity3.getClass();
                        if (((c4.k0) activity3).T()) {
                            FragmentActivity requireActivity2 = f0Var.requireActivity();
                            requireActivity2.getClass();
                            String str2 = f0Var.B().f11174n;
                            str2.getClass();
                            j5.c.e((c4.k0) requireActivity2, str2, f0Var.B().f11159b);
                            return true;
                        }
                    }
                } else {
                    if (menuItem.getItemId() == 2131361855) {
                        f0Var.V();
                        return true;
                    }
                    if (menuItem.getItemId() == 2131361897) {
                        String str3 = f0Var.B().F;
                        if (str3 != null && str3.length() != 0 && (activity = f0Var.getActivity()) != null) {
                            String str4 = f0Var.B().F;
                            str4.getClass();
                            Intent intent2 = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                            intent2.addFlags(268435456);
                            activity.startActivity(intent2);
                            return true;
                        }
                    } else {
                        if (menuItem.getItemId() == 2131361898) {
                            f0Var.o();
                            return true;
                        }
                        if (menuItem.getItemId() == 2131361890) {
                            f0Var.n();
                            return true;
                        }
                        if (menuItem.getItemId() == 2131361876) {
                            String str5 = f0Var.B().F;
                            if (str5 != null && str5.length() != 0 && f0Var.getContext() != null) {
                                e1.c0 c0Var = j5.g.D;
                                Context requireContext = f0Var.requireContext();
                                requireContext.getClass();
                                j5.g l10 = c0Var.l(requireContext);
                                l10.b();
                                String str6 = f0Var.B().F;
                                str6.getClass();
                                x4.e B = l10.B(str6);
                                if (B != null) {
                                    if (B.v == 0) {
                                        B.v = 1;
                                        x4.d dVar = B.f11127p;
                                        x4.d dVar2 = x4.d.f11088b;
                                        if (dVar != dVar2) {
                                            B.f11127p = dVar2;
                                            String str7 = B.f11123l;
                                            str7.getClass();
                                            l10.s(str7);
                                            Context requireContext2 = f0Var.requireContext();
                                            requireContext2.getClass();
                                            a.a.r(requireContext2);
                                        }
                                    } else {
                                        B.v = 0;
                                    }
                                    l10.n0(B);
                                    r7.o0 o0Var = f0Var.G().C;
                                    o0Var.getClass();
                                    o0Var.g(null, B);
                                    Context requireContext3 = f0Var.requireContext();
                                    requireContext3.getClass();
                                    j5.a.i(requireContext3);
                                }
                                l10.c();
                                f0Var.z();
                                return true;
                            }
                        } else if (menuItem.getItemId() == 2131361856) {
                            if (f0Var.getActivity() != null && !f0Var.requireActivity().isFinishing()) {
                                Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                                intent3.setData(Uri.fromParts("package", f0Var.B().F, null));
                                intent3.addFlags(268435456);
                                intent3.addFlags(8388608);
                                try {
                                    f0Var.startActivity(intent3);
                                } catch (ActivityNotFoundException e10) {
                                    e10.printStackTrace();
                                }
                            }
                        } else if (menuItem.getItemId() == 2131361857) {
                            if (f0Var.getContext() != null) {
                                e1.c0 c0Var2 = j5.g.D;
                                FragmentActivity requireActivity3 = f0Var.requireActivity();
                                requireActivity3.getClass();
                                j5.g l11 = c0Var2.l(requireActivity3);
                                l11.b();
                                String str8 = f0Var.B().F;
                                str8.getClass();
                                x4.e B2 = l11.B(str8);
                                l11.c();
                                Intent intent4 = new Intent(f0Var.requireActivity(), (Class<?>) AppInstalledDetailsActivity.class);
                                intent4.putExtra("appInstalled", B2);
                                intent4.putExtra("appInfo", f0Var.B());
                                FragmentActivity requireActivity4 = f0Var.requireActivity();
                                requireActivity4.getClass();
                                f0Var.startActivity(intent4, b4.d.a(requireActivity4));
                                return true;
                            }
                        } else {
                            if (menuItem.getItemId() != 2131361891) {
                                return false;
                            }
                            if (f0Var.G().f10642z.getValue() instanceof j5.r) {
                                Object value = f0Var.G().f10642z.getValue();
                                value.getClass();
                                f0Var.o0((ArrayList) ((j5.r) value).f6707a);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i6, int i10, int i11) {
        boolean z9;
        Rect rect = new Rect();
        f0 f0Var = this.f10503b;
        t4.b bVar = f0Var.f10473b;
        bVar.getClass();
        bVar.f9605f0.getHitRect(rect);
        f0Var.l0(rect);
        t4.b bVar2 = f0Var.f10473b;
        bVar2.getClass();
        if (bVar2.T.A.getLocalVisibleRect(rect)) {
            t4.b bVar3 = f0Var.f10473b;
            bVar3.getClass();
            bVar3.f9613m.setTitle("");
            r7.o0 o0Var = f0Var.G().P;
            Boolean bool = Boolean.TRUE;
            o0Var.getClass();
            o0Var.g(null, bool);
            return;
        }
        boolean booleanValue = ((Boolean) f0Var.G().P.getValue()).booleanValue();
        r7.o0 o0Var2 = f0Var.G().P;
        Boolean bool2 = Boolean.FALSE;
        o0Var2.getClass();
        o0Var2.g(null, bool2);
        String str = f0Var.B().f11159b;
        if (str == null || str.length() == 0) {
            return;
        }
        ArrayList arrayList = f0Var.B().Y;
        if (arrayList == null || arrayList.isEmpty()) {
            String e10 = f0Var.B().e();
            if (e10 == null || e10.length() == 0) {
                t4.b bVar4 = f0Var.f10473b;
                bVar4.getClass();
                bVar4.f9613m.setTitleEnabled(false);
                z9 = true;
            } else {
                z9 = ((Boolean) f0Var.G().O.getValue()).booleanValue();
            }
        } else {
            z9 = ((Boolean) f0Var.G().O.getValue()).booleanValue();
        }
        if (booleanValue && z9) {
            if (f0Var.getResources().getConfiguration().getLayoutDirection() == 1) {
                String str2 = f0Var.B().f11159b;
                str2.getClass();
                int length = str2.length() - 1;
                int i12 = 0;
                for (int i13 = 0; i13 < length; i13++) {
                    String str3 = f0Var.B().f11159b;
                    str3.getClass();
                    char charAt = str3.charAt(i13);
                    if (charAt != ' ') {
                        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
                        if (1424 > charAt || charAt >= 1792) {
                            i12++;
                        }
                    }
                }
                if (i12 > 0) {
                    t4.b bVar5 = f0Var.f10473b;
                    bVar5.getClass();
                    bVar5.f9613m.setRtlTextDirectionHeuristicsEnabled(false);
                    t4.b bVar6 = f0Var.f10473b;
                    bVar6.getClass();
                    bVar6.f9613m.setLayoutDirection(0);
                }
            }
            t4.b bVar7 = f0Var.f10473b;
            bVar7.getClass();
            CollapsingToolbarLayout collapsingToolbarLayout = bVar7.f9613m;
            String str4 = f0Var.B().f11159b;
            str4.getClass();
            collapsingToolbarLayout.setTitle(str4);
        }
    }
}
