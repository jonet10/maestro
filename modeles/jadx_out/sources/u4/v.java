package u4;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import x4.b3;
import x4.d3;
import x4.k2;
import x4.l2;
import x4.p2;
import x4.q2;
import x4.u2;
import x4.v2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10621a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10622b;

    public /* synthetic */ v(f0 f0Var, int i) {
        this.f10621a = i;
        this.f10622b = f0Var;
    }

    private final Object a(Object obj, t6.c cVar) {
        final j5.s sVar = (j5.s) obj;
        if (!(sVar instanceof j5.p)) {
            if (sVar instanceof j5.r) {
                Object obj2 = ((j5.r) sVar).f6707a;
                boolean isEmpty = ((Collection) obj2).isEmpty();
                final f0 f0Var = this.f10622b;
                if (!isEmpty) {
                    Iterator it = ((ArrayList) obj2).iterator();
                    it.getClass();
                    while (true) {
                        if (!it.hasNext()) {
                            t4.b bVar = f0Var.f10473b;
                            bVar.getClass();
                            bVar.P.f9802l.setVisibility(8);
                            t4.b bVar2 = f0Var.f10473b;
                            bVar2.getClass();
                            bVar2.P.f9803m.setVisibility(8);
                            f0Var.I(2131361891);
                            break;
                        }
                        Object next = it.next();
                        next.getClass();
                        final int i = 1;
                        if (((b3) next).f11069n == 1) {
                            f0Var.n0(2131361891);
                            t4.b bVar3 = f0Var.f10473b;
                            bVar3.getClass();
                            final int i6 = 0;
                            bVar3.P.f9802l.setOnClickListener(new View.OnClickListener() { // from class: u4.a0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    int i10 = i6;
                                    j5.s sVar2 = sVar;
                                    f0 f0Var2 = f0Var;
                                    switch (i10) {
                                        case 0:
                                            float f = UptodownApp.I;
                                            if (b4.d.t()) {
                                                f0Var2.o0((ArrayList) ((j5.r) sVar2).f6707a);
                                                break;
                                            }
                                            break;
                                        default:
                                            float f10 = UptodownApp.I;
                                            if (b4.d.t()) {
                                                f0Var2.o0((ArrayList) ((j5.r) sVar2).f6707a);
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            t4.b bVar4 = f0Var.f10473b;
                            bVar4.getClass();
                            bVar4.P.f9803m.setOnClickListener(new View.OnClickListener() { // from class: u4.a0
                                @Override // android.view.View.OnClickListener
                                public final void onClick(View view) {
                                    int i10 = i;
                                    j5.s sVar2 = sVar;
                                    f0 f0Var2 = f0Var;
                                    switch (i10) {
                                        case 0:
                                            float f = UptodownApp.I;
                                            if (b4.d.t()) {
                                                f0Var2.o0((ArrayList) ((j5.r) sVar2).f6707a);
                                                break;
                                            }
                                            break;
                                        default:
                                            float f10 = UptodownApp.I;
                                            if (b4.d.t()) {
                                                f0Var2.o0((ArrayList) ((j5.r) sVar2).f6707a);
                                                break;
                                            }
                                            break;
                                    }
                                }
                            });
                            break;
                        }
                    }
                } else {
                    t4.b bVar5 = f0Var.f10473b;
                    bVar5.getClass();
                    bVar5.P.f9802l.setVisibility(8);
                    t4.b bVar6 = f0Var.f10473b;
                    bVar6.getClass();
                    bVar6.P.f9803m.setVisibility(8);
                    f0Var.I(2131361891);
                }
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }

    private final Object b(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        if (!(sVar instanceof j5.p)) {
            if (sVar instanceof j5.r) {
                l0 l0Var = (l0) ((j5.r) sVar).f6707a;
                boolean z9 = l0Var.f10523a;
                int i = l0Var.f10524b;
                f0 f0Var = this.f10622b;
                if (z9) {
                    FragmentActivity activity = f0Var.getActivity();
                    activity.getClass();
                    String string = f0Var.requireContext().getString(2131952543);
                    string.getClass();
                    ((c4.k0) activity).A(string);
                } else if (!z9 && i == 0) {
                    FragmentActivity activity2 = f0Var.getActivity();
                    activity2.getClass();
                    String string2 = f0Var.getString(2131952005);
                    string2.getClass();
                    ((c4.k0) activity2).A(string2);
                } else if (i == 401) {
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    u2.b(requireContext);
                    f0Var.R();
                } else if (i == 403) {
                    FragmentActivity activity3 = f0Var.getActivity();
                    activity3.getClass();
                    String string3 = f0Var.getString(2131951981);
                    string3.getClass();
                    ((c4.k0) activity3).A(string3);
                } else {
                    FragmentActivity activity4 = f0Var.getActivity();
                    activity4.getClass();
                    String string4 = f0Var.getString(2131951998);
                    string4.getClass();
                    ((c4.k0) activity4).A(string4);
                }
            } else if (!(sVar instanceof j5.q)) {
                com.google.gson.internal.a.b();
                return null;
            }
        }
        return p6.x.f8463a;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        Object obj2;
        FragmentActivity activity;
        FragmentActivity activity2;
        FragmentActivity activity3;
        FragmentActivity activity4;
        q2 q2Var;
        int i = 6;
        int i6 = -1;
        int i10 = 0;
        ViewGroup viewGroup = null;
        k2 k2Var = null;
        switch (this.f10621a) {
            case 0:
                j5.s sVar = (j5.s) obj;
                f0 f0Var = this.f10622b;
                if (!(sVar instanceof j5.p)) {
                    if (sVar instanceof j5.r) {
                        k0 k0Var = (k0) ((j5.r) sVar).f6707a;
                        boolean z9 = k0Var.f10516b;
                        String str = k0Var.f10515a;
                        t4.b bVar = f0Var.f10473b;
                        if (z9) {
                            bVar.getClass();
                            TextView textView = bVar.P.f9809s;
                            textView.setOnClickListener(new k(f0Var, textView, 0));
                            t4.b bVar2 = f0Var.f10473b;
                            bVar2.getClass();
                            RelativeLayout relativeLayout = bVar2.L.f9869r;
                            relativeLayout.setOnClickListener(new k(f0Var, relativeLayout, 0));
                            t4.b bVar3 = f0Var.f10473b;
                            bVar3.getClass();
                            bVar3.L.f9864m.setVisibility(8);
                            if (f0Var.getContext() != null && str != null && str.length() != 0) {
                                t4.b bVar4 = f0Var.f10473b;
                                bVar4.getClass();
                                TextView textView2 = bVar4.P.f9809s;
                                textView2.setText(str);
                                z3.K(textView2);
                                t4.b bVar5 = f0Var.f10473b;
                                bVar5.getClass();
                                ((RelativeLayout) bVar5.P.v).setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231156));
                                t4.b bVar6 = f0Var.f10473b;
                                bVar6.getClass();
                                bVar6.L.f9869r.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231156));
                                t4.b bVar7 = f0Var.f10473b;
                                bVar7.getClass();
                                bVar7.L.f9876z.setTextColor(ContextCompat.getColorStateList(f0Var.requireContext(), 2131100765));
                                t4.b bVar8 = f0Var.f10473b;
                                bVar8.getClass();
                                bVar8.L.f9876z.setText(str);
                            }
                            e1.c0 c0Var = j5.g.D;
                            Context requireContext = f0Var.requireContext();
                            requireContext.getClass();
                            j5.g l10 = c0Var.l(requireContext);
                            l10.b();
                            x4.x1 U = l10.U(f0Var.B().f11158a);
                            l10.c();
                            t4.b bVar9 = f0Var.f10473b;
                            if (U != null) {
                                bVar9.getClass();
                                bVar9.I.setVisibility(0);
                                t4.b bVar10 = f0Var.f10473b;
                                bVar10.getClass();
                                bVar10.f9603d0.setChecked(U.f11452e == 1);
                            } else {
                                bVar9.getClass();
                                bVar9.f9603d0.setChecked(true);
                            }
                        } else {
                            bVar.getClass();
                            bVar.P.f9809s.setOnClickListener(new e(f0Var, i));
                            t4.b bVar11 = f0Var.f10473b;
                            bVar11.getClass();
                            bVar11.L.f9869r.setOnClickListener(new e(f0Var, i));
                            t4.b bVar12 = f0Var.f10473b;
                            bVar12.getClass();
                            bVar12.L.f9864m.setVisibility(0);
                            if (f0Var.getContext() != null) {
                                t4.b bVar13 = f0Var.f10473b;
                                bVar13.getClass();
                                TextView textView3 = bVar13.P.f9809s;
                                String string = f0Var.getString(2131952477);
                                string.getClass();
                                textView3.setText(string);
                                z3.J(textView3);
                                t4.b bVar14 = f0Var.f10473b;
                                bVar14.getClass();
                                ((RelativeLayout) bVar14.P.v).setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                                t4.b bVar15 = f0Var.f10473b;
                                bVar15.getClass();
                                bVar15.L.f9869r.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                                t4.b bVar16 = f0Var.f10473b;
                                bVar16.getClass();
                                bVar16.L.f9876z.setText(f0Var.getString(2131952477));
                                t4.b bVar17 = f0Var.f10473b;
                                bVar17.getClass();
                                bVar17.L.f9876z.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100824));
                            }
                        }
                    } else if (!(sVar instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 1:
                ArrayList arrayList = (ArrayList) obj;
                f0 f0Var2 = this.f10622b;
                t4.b bVar18 = f0Var2.f10473b;
                bVar18.getClass();
                if (bVar18.f9628u.getVisibility() == 8 && !arrayList.isEmpty()) {
                    e4.u0 u0Var = new e4.u0(new s(f0Var2, 2), new x(f0Var2, 2));
                    f0Var2.f10481s = u0Var;
                    u0Var.a(arrayList);
                    t4.b bVar19 = f0Var2.f10473b;
                    bVar19.getClass();
                    bVar19.a0.setAdapter(f0Var2.f10481s);
                    t4.b bVar20 = f0Var2.f10473b;
                    bVar20.getClass();
                    bVar20.a0.setNestedScrollingEnabled(false);
                    t4.b bVar21 = f0Var2.f10473b;
                    bVar21.getClass();
                    bVar21.a0.setLayoutManager(new LinearLayoutManager(f0Var2.getContext(), 0, false));
                    DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
                    defaultItemAnimator.setSupportsChangeAnimations(false);
                    t4.b bVar22 = f0Var2.f10473b;
                    bVar22.getClass();
                    bVar22.a0.setItemAnimator(defaultItemAnimator);
                    t4.b bVar23 = f0Var2.f10473b;
                    bVar23.getClass();
                    bVar23.f9628u.setVisibility(0);
                }
                return p6.x.f8463a;
            case 2:
                x4.i0 i0Var = (x4.i0) obj;
                f0 f0Var3 = this.f10622b;
                if (i0Var instanceof x4.f0) {
                    x4.r rVar = ((x4.f0) i0Var).f11150a;
                    if (l7.u.m0(rVar.f11355b, f0Var3.B().F, true)) {
                        f0Var3.d0(rVar);
                    }
                } else if (i0Var instanceof x4.h0) {
                    x4.r rVar2 = ((x4.h0) i0Var).f11209a;
                    if (l7.u.m0(rVar2.f11355b, f0Var3.B().F, true)) {
                        f0Var3.i0(rVar2);
                    }
                } else if (!kotlin.jvm.internal.l.a(i0Var, x4.g0.f11198a) && !kotlin.jvm.internal.l.a(i0Var, x4.e0.f11137a)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 3:
                x4.d0 d0Var = (x4.d0) obj;
                f0 f0Var4 = this.f10622b;
                String b7 = d0Var.b();
                if (b7 == null || b7.length() == 0 || b7.equalsIgnoreCase(f0Var4.B().F)) {
                    boolean z10 = b7 != null && b7.equalsIgnoreCase(f0Var4.B().F);
                    if (d0Var instanceof x4.y) {
                        if (z10) {
                            f0Var4.d0(null);
                        }
                    } else if (!(d0Var instanceof x4.c0)) {
                        obj2 = null;
                        if (d0Var instanceof x4.b0) {
                            if (z10 && f0Var4.L()) {
                                f0Var4.d0(d0Var.a());
                            }
                        } else if (d0Var instanceof x4.v) {
                            if (z10) {
                                f0Var4.d0(d0Var.a());
                            }
                        } else if (!(d0Var instanceof x4.u)) {
                            if (d0Var instanceof x4.x) {
                                FragmentActivity activity5 = f0Var4.getActivity();
                                if (activity5 != null) {
                                    f0Var4.p0(activity5);
                                }
                            } else if (d0Var instanceof x4.w) {
                                if (z10 && (activity4 = f0Var4.getActivity()) != null) {
                                    String string2 = f0Var4.getString(2131951967);
                                    string2.getClass();
                                    f0Var4.v(string2);
                                    f0Var4.c0(activity4);
                                }
                            } else if (d0Var instanceof x4.t) {
                                if (z10 && (activity3 = f0Var4.getActivity()) != null) {
                                    if (f0Var4.G().C.getValue() != null) {
                                        f0Var4.k0();
                                    } else {
                                        f0Var4.c0(activity3);
                                    }
                                }
                            } else if (d0Var.equals(x4.a0.f11041a)) {
                                x4.r rVar3 = f0Var4.C().f10422e;
                                if (l7.u.m0(rVar3 != null ? rVar3.f11355b : null, f0Var4.B().F, true) && (activity2 = f0Var4.getActivity()) != null) {
                                    String string3 = f0Var4.getString(2131952382);
                                    string3.getClass();
                                    f0Var4.v(string3);
                                    f0Var4.p0(activity2);
                                }
                            } else if (d0Var.equals(x4.z.f11477a)) {
                                x4.r rVar4 = f0Var4.C().f10422e;
                                if (l7.u.m0(rVar4 != null ? rVar4.f11355b : null, f0Var4.B().F, true) && (activity = f0Var4.getActivity()) != null) {
                                    f0Var4.p0(activity);
                                }
                            } else {
                                if (!d0Var.equals(x4.s.f11382a)) {
                                    com.google.gson.internal.a.b();
                                    return obj2;
                                }
                                FragmentActivity activity6 = f0Var4.getActivity();
                                if (activity6 != null) {
                                    f0Var4.p0(activity6);
                                }
                            }
                        }
                    } else if (z10) {
                        f0Var4.E();
                        f0Var4.d0(d0Var.a());
                        x4.r a8 = d0Var.a();
                        a8.getClass();
                        if (a8.f11358n < f0Var4.B().K && (f0Var4.getActivity() instanceof c4.k0) && f0Var4.getActivity() != null && !f0Var4.requireActivity().isFinishing()) {
                            FragmentActivity activity7 = f0Var4.getActivity();
                            activity7.getClass();
                            ((c4.k0) activity7).Q();
                            AlertDialog.Builder builder = new AlertDialog.Builder(f0Var4.requireContext());
                            obj2 = null;
                            View inflate = f0Var4.getLayoutInflater().inflate(2131558526, (ViewGroup) null, false);
                            int i11 = 2131363836;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363836);
                            if (textView4 != null) {
                                i11 = 2131363837;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363837);
                                if (textView5 != null) {
                                    i11 = 2131364010;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364010);
                                    if (textView6 != null) {
                                        textView6.setTypeface(f4.c.f4883x);
                                        textView6.setText(f0Var4.getString(2131952513, f0Var4.B().f11159b));
                                        textView5.setTypeface(f4.c.f4882w);
                                        textView5.setOnClickListener(new p(f0Var4, 3));
                                        textView4.setTypeface(f4.c.f4882w);
                                        textView4.setOnClickListener(new p(f0Var4, 7));
                                        builder.setView((LinearLayout) inflate);
                                        builder.setCancelable(true);
                                        FragmentActivity activity8 = f0Var4.getActivity();
                                        activity8.getClass();
                                        ((c4.k0) activity8).F = builder.create();
                                        FragmentActivity activity9 = f0Var4.getActivity();
                                        activity9.getClass();
                                        ((c4.k0) activity9).u0();
                                    }
                                }
                            }
                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                            return obj2;
                        }
                    }
                } else {
                    f0Var4.u0(b7);
                }
                return p6.x.f8463a;
            case 4:
                x4.a1 a1Var = (x4.a1) obj;
                f0 f0Var5 = this.f10622b;
                if (a1Var instanceof x4.w0) {
                    x4.r rVar5 = ((x4.w0) a1Var).f11427a;
                    if (rVar5 != null && l7.u.m0(rVar5.f11355b, f0Var5.B().F, true) && (q2Var = (q2) f0Var5.G().D.getValue()) != null) {
                        f0Var5.j0(q2Var);
                    }
                } else if (!kotlin.jvm.internal.l.a(a1Var, x4.x0.f11447a) && !kotlin.jvm.internal.l.a(a1Var, x4.z0.f11478a) && !kotlin.jvm.internal.l.a(a1Var, x4.v0.f11420a) && !(a1Var instanceof x4.y0)) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                return p6.x.f8463a;
            case 5:
                x4.u0 u0Var2 = (x4.u0) obj;
                f0 f0Var6 = this.f10622b;
                String b10 = u0Var2.b();
                if (b10 != null && b10.equalsIgnoreCase(f0Var6.B().F)) {
                    if (u0Var2 instanceof x4.t0) {
                        q2 q2Var2 = (q2) f0Var6.G().D.getValue();
                        if (q2Var2 != null) {
                            f0Var6.E();
                            f0Var6.j0(q2Var2);
                        }
                    } else if (u0Var2 instanceof x4.q0) {
                        q2 q2Var3 = (q2) f0Var6.G().D.getValue();
                        if (q2Var3 != null) {
                            f0Var6.j0(q2Var3);
                        }
                    } else if (u0Var2 instanceof x4.m0) {
                        if (f0Var6.G().C.getValue() != null) {
                            f0Var6.k0();
                        } else {
                            FragmentActivity activity10 = f0Var6.getActivity();
                            if (activity10 != null) {
                                f0Var6.c0(activity10);
                            }
                        }
                    } else if ((u0Var2 instanceof x4.s0) || (u0Var2 instanceof x4.r0)) {
                        Context context = f0Var6.getContext();
                        if (context != null) {
                            f0Var6.p0(context);
                        }
                    } else if (!(u0Var2 instanceof x4.l0) && !(u0Var2 instanceof x4.n0) && !(u0Var2 instanceof x4.p0) && !u0Var2.equals(x4.o0.f11305a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 6:
                l4.m mVar = (l4.m) obj;
                f0 f0Var7 = this.f10622b;
                if (mVar instanceof l4.i) {
                    l4.a aVar = ((l4.i) mVar).f7116a;
                    if (l7.u.m0(aVar != null ? aVar.f7095a : null, f0Var7.B().F, true)) {
                        String string4 = f0Var7.getString(2131952095);
                        string4.getClass();
                        f0.i(f0Var7, string4);
                    }
                } else if (mVar instanceof l4.f) {
                    f0Var7.v(((l4.f) mVar).f7112b);
                }
                return p6.x.f8463a;
            case 7:
                j5.s sVar2 = (j5.s) obj;
                f0 f0Var8 = this.f10622b;
                if (!(sVar2 instanceof j5.p)) {
                    if (sVar2 instanceof j5.r) {
                        j0 j0Var = (j0) ((j5.r) sVar2).f6707a;
                        j0Var.getClass();
                        if (j0Var.f10510a) {
                            FragmentActivity activity11 = f0Var8.getActivity();
                            activity11.getClass();
                            AlertDialog alertDialog = ((c4.k0) activity11).F;
                            if (alertDialog != null) {
                                alertDialog.dismiss();
                            }
                            if (f0Var8.getContext() != null) {
                                View inflate2 = f0Var8.getLayoutInflater().inflate(2131558496, (ViewGroup) null, false);
                                int i12 = 2131363719;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363719);
                                if (textView7 != null) {
                                    i12 = 2131363789;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate2, 2131363789);
                                    if (textView8 != null) {
                                        i12 = 2131364387;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364387);
                                        if (textView9 != null) {
                                            LinearLayout linearLayout = (LinearLayout) inflate2;
                                            textView9.setTypeface(f4.c.f4882w);
                                            textView8.setTypeface(f4.c.f4883x);
                                            String string5 = f0Var8.getString(2131952475, f0Var8.B().f11159b);
                                            string5.getClass();
                                            String str2 = f0Var8.B().f11159b;
                                            str2.getClass();
                                            Context requireContext2 = f0Var8.requireContext();
                                            requireContext2.getClass();
                                            SpannableString spannableString = new SpannableString(string5);
                                            int y02 = l7.m.y0(string5, str2, 0, false, 6);
                                            int length = str2.length() + y02;
                                            if (y02 != -1) {
                                                float dimension = requireContext2.getResources().getDimension(2131166539);
                                                Typeface typeface = f4.c.f4882w;
                                                typeface.getClass();
                                                spannableString.setSpan(new j5.e(dimension, typeface, ContextCompat.getColor(requireContext2, 2131100787)), y02, length, 33);
                                            }
                                            textView8.setText(spannableString);
                                            textView7.setTypeface(f4.c.f4882w);
                                            textView7.setOnClickListener(new p(f0Var8, 1));
                                            AlertDialog.Builder builder2 = new AlertDialog.Builder(f0Var8.requireContext());
                                            builder2.setView(linearLayout);
                                            builder2.setCancelable(true);
                                            f0Var8.m0(builder2);
                                        }
                                    }
                                }
                                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i12)));
                                return null;
                            }
                        }
                        f0.j(f0Var8);
                    } else if (!(sVar2 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 8:
                j5.s sVar3 = (j5.s) obj;
                if (!(sVar3 instanceof j5.p)) {
                    if (sVar3 instanceof j5.r) {
                        f0 f0Var9 = this.f10622b;
                        g0 g0Var = (g0) ((j5.r) sVar3).f6707a;
                        ArrayList arrayList2 = g0Var.f10494a;
                        ArrayList arrayList3 = g0Var.f10495b;
                        if (arrayList2.isEmpty()) {
                            t4.b bVar24 = f0Var9.f10473b;
                            bVar24.getClass();
                            bVar24.f9601b0.setVisibility(8);
                        } else {
                            ArrayList arrayList4 = new ArrayList();
                            if (!arrayList3.isEmpty()) {
                                int size = arrayList3.size();
                                int i13 = 0;
                                while (i13 < size) {
                                    Object obj3 = arrayList3.get(i13);
                                    i13++;
                                    d3 d3Var = (d3) obj3;
                                    String a10 = d3Var.a();
                                    if (a10 != null && a10.length() != 0) {
                                        arrayList4.add(d3Var);
                                    }
                                }
                            }
                            ArrayList arrayList5 = new ArrayList();
                            int size2 = arrayList2.size();
                            for (int i14 = 0; i14 < size2; i14++) {
                                Object obj4 = arrayList2.get(i14);
                                obj4.getClass();
                                l2 l2Var = (l2) obj4;
                                if (l2Var.f11279l == 0) {
                                    arrayList5.add(l2Var);
                                }
                            }
                            kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                            y2.s sVar4 = new y2.s(f0Var9, arrayList5, xVar, arrayList4, 19);
                            ArrayList arrayList6 = new ArrayList();
                            arrayList6.addAll(arrayList4);
                            arrayList6.addAll(arrayList5);
                            xVar.f7024a = new e4.k0(arrayList6, sVar4);
                            t4.b bVar25 = f0Var9.f10473b;
                            bVar25.getClass();
                            bVar25.f9601b0.setAdapter((RecyclerView.Adapter) xVar.f7024a);
                            t4.b bVar26 = f0Var9.f10473b;
                            bVar26.getClass();
                            bVar26.f9601b0.setVisibility(0);
                        }
                    } else if (!(sVar3 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 9:
                f0.d(this.f10622b, (ArrayList) obj);
                return p6.x.f8463a;
            case 10:
                x4.c cVar2 = (x4.c) obj;
                f0 f0Var10 = this.f10622b;
                ArrayList arrayList7 = cVar2.f11073c;
                if (arrayList7 != null && !arrayList7.isEmpty()) {
                    t4.b bVar27 = f0Var10.f10473b;
                    bVar27.getClass();
                    bVar27.f9620q.setVisibility(0);
                    t4.b bVar28 = f0Var10.f10473b;
                    bVar28.getClass();
                    bVar28.F0.setText(f0Var10.getString(2131951743));
                    t4.b bVar29 = f0Var10.f10473b;
                    bVar29.getClass();
                    bVar29.E.setOnClickListener(new f(10, f0Var10, cVar2));
                    f0.d(f0Var10, cVar2.f11073c);
                }
                return p6.x.f8463a;
            case 11:
                j5.s sVar5 = (j5.s) obj;
                f0 f0Var11 = this.f10622b;
                if (!(sVar5 instanceof j5.p)) {
                    if (sVar5 instanceof j5.r) {
                        h0 h0Var = (h0) ((j5.r) sVar5).f6707a;
                        ArrayList arrayList8 = h0Var.f10499a;
                        ArrayList arrayList9 = h0Var.f10500b;
                        if (arrayList8 != null && !arrayList8.isEmpty()) {
                            ArrayList<p2> arrayList10 = h0Var.f10499a;
                            t4.b bVar30 = f0Var11.f10473b;
                            bVar30.getClass();
                            if (bVar30.f9631w.getChildCount() == 0) {
                                t4.b bVar31 = f0Var11.f10473b;
                                bVar31.getClass();
                                bVar31.f9617o0.setVisibility(8);
                                if (f0Var11.getActivity() != null) {
                                    int i15 = 0;
                                    for (p2 p2Var : arrayList10) {
                                        int i16 = i15 + 1;
                                        View inflate3 = f0Var11.getLayoutInflater().inflate(2131558574, viewGroup, false);
                                        int i17 = 2131362434;
                                        if (((ImageView) ViewBindings.findChildViewById(inflate3, 2131362434)) != null) {
                                            i17 = 2131363271;
                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate3, 2131363271);
                                            if (relativeLayout2 != null) {
                                                i17 = 2131363327;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate3, 2131363327);
                                                if (recyclerView != null) {
                                                    i17 = 2131364402;
                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364402);
                                                    if (textView10 != null) {
                                                        View view = (LinearLayout) inflate3;
                                                        if (i15 > 0) {
                                                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                                                            layoutParams.setMargins(0, (int) f0Var11.getResources().getDimension(2131166250), 0, 0);
                                                            view.setLayoutParams(layoutParams);
                                                        }
                                                        e4.u0 u0Var3 = new e4.u0(new s(f0Var11, 4), new x(f0Var11, 4));
                                                        u0Var3.a(p2Var.f11330b);
                                                        textView10.setTypeface(f4.c.f4882w);
                                                        textView10.setText(p2Var.f11329a.f11225b);
                                                        relativeLayout2.setOnClickListener(new f(5, f0Var11, p2Var));
                                                        recyclerView.setAdapter(u0Var3);
                                                        recyclerView.setNestedScrollingEnabled(false);
                                                        recyclerView.setLayoutManager(new LinearLayoutManager(f0Var11.getContext(), 0, false));
                                                        DefaultItemAnimator defaultItemAnimator2 = new DefaultItemAnimator();
                                                        defaultItemAnimator2.setSupportsChangeAnimations(false);
                                                        recyclerView.setItemAnimator(defaultItemAnimator2);
                                                        t4.b bVar32 = f0Var11.f10473b;
                                                        bVar32.getClass();
                                                        bVar32.f9631w.addView(view);
                                                        f0Var11.f10482t.add(u0Var3);
                                                        i15 = i16;
                                                        viewGroup = null;
                                                    }
                                                }
                                            }
                                        }
                                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate3.getResources().getResourceName(i17)));
                                        return null;
                                    }
                                }
                                t4.b bVar33 = f0Var11.f10473b;
                                bVar33.getClass();
                                bVar33.f9633x.setVisibility(0);
                            }
                        } else if (arrayList9 != null && !arrayList9.isEmpty()) {
                            t4.b bVar34 = f0Var11.f10473b;
                            bVar34.getClass();
                            if (bVar34.f9631w.getChildCount() == 0) {
                                t4.b bVar35 = f0Var11.f10473b;
                                bVar35.getClass();
                                bVar35.f9617o0.setTypeface(f4.c.f4882w);
                                if (f0Var11.getActivity() != null) {
                                    HorizontalScrollView horizontalScrollView = new HorizontalScrollView(f0Var11.requireContext());
                                    horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                    horizontalScrollView.setHorizontalScrollBarEnabled(false);
                                    LinearLayout linearLayout2 = new LinearLayout(f0Var11.requireContext());
                                    linearLayout2.setOrientation(0);
                                    linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                                    horizontalScrollView.addView(linearLayout2);
                                    t4.b bVar36 = f0Var11.f10473b;
                                    bVar36.getClass();
                                    bVar36.f9631w.addView(horizontalScrollView);
                                    Iterator it = arrayList9.iterator();
                                    it.getClass();
                                    while (it.hasNext()) {
                                        Object next = it.next();
                                        next.getClass();
                                        x4.j jVar = (x4.j) next;
                                        int dimension2 = (int) f0Var11.getResources().getDimension(2131166251);
                                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                                        if (jVar.equals(q6.l.y0(arrayList9))) {
                                            layoutParams2.setMargins(dimension2, 0, dimension2, 0);
                                        } else {
                                            layoutParams2.setMargins(dimension2, 0, 0, 0);
                                        }
                                        View inflate4 = f0Var11.getLayoutInflater().inflate(2131558457, (ViewGroup) null, false);
                                        if (inflate4 == null) {
                                            com.google.gson.internal.a.i("rootView");
                                            return null;
                                        }
                                        TextView textView11 = (TextView) inflate4;
                                        textView11.setLayoutParams(layoutParams2);
                                        textView11.setTypeface(f4.c.f4882w);
                                        textView11.setText(String.valueOf(jVar.f11225b));
                                        textView11.setOnClickListener(new f(3, f0Var11, jVar));
                                        linearLayout2.addView(textView11);
                                    }
                                }
                                t4.b bVar37 = f0Var11.f10473b;
                                bVar37.getClass();
                                bVar37.f9633x.setVisibility(0);
                            }
                        }
                    } else if (!(sVar5 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 12:
                j5.s sVar6 = (j5.s) obj;
                f0 f0Var12 = this.f10622b;
                if (!(sVar6 instanceof j5.p)) {
                    if (sVar6 instanceof j5.r) {
                        i0 i0Var2 = (i0) ((j5.r) sVar6).f6707a;
                        ArrayList arrayList11 = i0Var2.f10504a;
                        t4.b bVar38 = f0Var12.f10473b;
                        bVar38.getClass();
                        if (bVar38.C.getChildCount() == 0 && f0Var12.getContext() != null) {
                            if (arrayList11.isEmpty()) {
                                t4.b bVar39 = f0Var12.f10473b;
                                bVar39.getClass();
                                bVar39.C.setVisibility(8);
                                t4.b bVar40 = f0Var12.f10473b;
                                bVar40.getClass();
                                bVar40.O.setVisibility(8);
                            } else {
                                int dimension3 = (int) f0Var12.getResources().getDimension(2131166251);
                                if (arrayList11.size() >= 5) {
                                    t4.b bVar41 = f0Var12.f10473b;
                                    bVar41.getClass();
                                    bVar41.D0.setVisibility(0);
                                }
                                if (l7.u.m0(f0Var12.getString(2131952555), "phone", true)) {
                                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                                    layoutParams3.setMargins(0, dimension3, 0, 0);
                                    Iterator it2 = arrayList11.iterator();
                                    it2.getClass();
                                    while (it2.hasNext()) {
                                        Object next2 = it2.next();
                                        next2.getClass();
                                        k2 k2Var2 = (k2) next2;
                                        boolean b11 = k2Var2.b();
                                        t4.b bVar42 = f0Var12.f10473b;
                                        if (b11) {
                                            bVar42.getClass();
                                            LinearLayout linearLayout3 = bVar42.C;
                                            Context requireContext3 = f0Var12.requireContext();
                                            requireContext3.getClass();
                                            linearLayout3.addView(f0Var12.Y(layoutParams3, k2Var2, requireContext3));
                                        } else {
                                            bVar42.getClass();
                                            LinearLayout linearLayout4 = bVar42.C;
                                            Context requireContext4 = f0Var12.requireContext();
                                            requireContext4.getClass();
                                            linearLayout4.addView(f0Var12.X(layoutParams3, k2Var2, requireContext4));
                                        }
                                    }
                                } else {
                                    int i18 = 0;
                                    while (i18 < arrayList11.size()) {
                                        LinearLayout linearLayout5 = new LinearLayout(f0Var12.getContext());
                                        linearLayout5.setOrientation(0);
                                        linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                                        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                                        layoutParams4.weight = 1.0f;
                                        layoutParams4.setMargins(0, dimension3, 0, 0);
                                        if (((k2) arrayList11.get(i18)).b()) {
                                            Object obj5 = arrayList11.get(i18);
                                            obj5.getClass();
                                            Context requireContext5 = f0Var12.requireContext();
                                            requireContext5.getClass();
                                            linearLayout5.addView(f0Var12.Y(layoutParams4, (k2) obj5, requireContext5));
                                            i18++;
                                        } else {
                                            Object obj6 = arrayList11.get(i18);
                                            obj6.getClass();
                                            Context requireContext6 = f0Var12.requireContext();
                                            requireContext6.getClass();
                                            linearLayout5.addView(f0Var12.X(layoutParams4, (k2) obj6, requireContext6));
                                            int i19 = i18 + 1;
                                            if (i19 < arrayList11.size()) {
                                                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
                                                layoutParams5.setMargins(dimension3, dimension3, 0, 0);
                                                layoutParams5.weight = 1.0f;
                                                if (!((k2) arrayList11.get(i19)).b()) {
                                                    Object obj7 = arrayList11.get(i19);
                                                    obj7.getClass();
                                                    Context requireContext7 = f0Var12.requireContext();
                                                    requireContext7.getClass();
                                                    linearLayout5.addView(f0Var12.X(layoutParams5, (k2) obj7, requireContext7));
                                                }
                                            } else {
                                                RelativeLayout relativeLayout3 = t4.p0.a(f0Var12.getLayoutInflater().inflate(2131558803, (ViewGroup) null, false)).f10043a;
                                                relativeLayout3.setLayoutParams(layoutParams4);
                                                relativeLayout3.setVisibility(4);
                                                linearLayout5.addView(relativeLayout3);
                                            }
                                            i18 += 2;
                                        }
                                        t4.b bVar43 = f0Var12.f10473b;
                                        bVar43.getClass();
                                        bVar43.C.addView(linearLayout5);
                                    }
                                }
                            }
                        }
                        k2 k2Var3 = i0Var2.f10505b;
                        if (f0Var12.getActivity() != null && !f0Var12.requireActivity().isFinishing() && k2Var3 != null) {
                            if (k2Var3.f11264p >= 1) {
                                t4.b bVar44 = f0Var12.f10473b;
                                bVar44.getClass();
                                k0.k.l(f0Var12, 2131231441, (ImageView) bVar44.H.f8817l);
                            }
                            if (k2Var3.f11264p >= 2) {
                                t4.b bVar45 = f0Var12.f10473b;
                                bVar45.getClass();
                                k0.k.l(f0Var12, 2131231441, (ImageView) bVar45.H.f8818m);
                            }
                            if (k2Var3.f11264p >= 3) {
                                t4.b bVar46 = f0Var12.f10473b;
                                bVar46.getClass();
                                k0.k.l(f0Var12, 2131231441, (ImageView) bVar46.H.f8819n);
                            }
                            if (k2Var3.f11264p >= 4) {
                                t4.b bVar47 = f0Var12.f10473b;
                                bVar47.getClass();
                                k0.k.l(f0Var12, 2131231441, (ImageView) bVar47.H.f8820o);
                            }
                            if (k2Var3.f11264p == 5) {
                                t4.b bVar48 = f0Var12.f10473b;
                                bVar48.getClass();
                                k0.k.l(f0Var12, 2131231441, (ImageView) bVar48.H.f8821p);
                            }
                            t4.b bVar49 = f0Var12.f10473b;
                            bVar49.getClass();
                            ((TextView) bVar49.H.f8824s).setText(f0Var12.getString(2131951980));
                        }
                    } else if (!(sVar6 instanceof j5.q)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 13:
                j5.s sVar7 = (j5.s) obj;
                f0 f0Var13 = this.f10622b;
                if (!kotlin.jvm.internal.l.a(sVar7, j5.p.f6705a)) {
                    if (sVar7 instanceof j5.r) {
                        Iterator it3 = ((Iterable) f0Var13.G().f10635r.getValue()).iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                int i20 = i10 + 1;
                                k2 k2Var4 = (k2) it3.next();
                                String str3 = k2Var4.f11259b;
                                v2 v2Var = (v2) ((j5.r) sVar7).f6707a;
                                if (kotlin.jvm.internal.l.a(str3, v2Var.f11422a)) {
                                    k2Var4.f11271x = v2Var.f11425d;
                                    k2Var = k2Var4;
                                    i6 = i10;
                                } else {
                                    i10 = i20;
                                }
                            }
                        }
                        if (i6 >= 0 && k2Var != null && i6 < ((ArrayList) f0Var13.G().f10635r.getValue()).size()) {
                            f0.m(f0Var13, k2Var, i6);
                            if (((v2) ((j5.r) sVar7).f6707a).f11425d == 1) {
                                FragmentActivity activity12 = f0Var13.getActivity();
                                activity12.getClass();
                                String string6 = f0Var13.getString(2131952032);
                                string6.getClass();
                                ((c4.k0) activity12).A(string6);
                            } else {
                                FragmentActivity activity13 = f0Var13.getActivity();
                                activity13.getClass();
                                String string7 = f0Var13.getString(2131952686);
                                string7.getClass();
                                ((c4.k0) activity13).A(string7);
                            }
                        }
                    } else if (!kotlin.jvm.internal.l.a(sVar7, j5.q.f6706a)) {
                        com.google.gson.internal.a.b();
                        return null;
                    }
                }
                return p6.x.f8463a;
            case 14:
                return a(obj, cVar);
            case 15:
                int intValue = ((Number) obj).intValue();
                f0 f0Var14 = this.f10622b;
                f0Var14.B().C0 = intValue;
                v7.e eVar = o7.m0.f8288a;
                Object C = o7.c0.C(new u(f0Var14, null, 3), t7.n.f10348a, cVar);
                return C == u6.a.f10762a ? C : p6.x.f8463a;
            case 16:
                return b(obj, cVar);
            default:
                int intValue2 = ((Number) obj).intValue();
                f0 f0Var15 = this.f10622b;
                f0Var15.B().B0 = intValue2;
                v7.e eVar2 = o7.m0.f8288a;
                Object C2 = o7.c0.C(new u(f0Var15, null, 4), t7.n.f10348a, cVar);
                return C2 == u6.a.f10762a ? C2 : p6.x.f8463a;
        }
    }
}
