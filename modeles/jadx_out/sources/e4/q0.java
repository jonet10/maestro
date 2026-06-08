package e4;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import u4.d2;
import u4.o1;
import u4.p1;
import u4.z1;
import x4.o2;
import x4.p2;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.c f4660a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.d f4661b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.a f4662c;

    /* renamed from: d, reason: collision with root package name */
    public final p1 f4663d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4664e;
    public final o2 f;
    public final ArrayList g;
    public final String h;
    public final boolean i;
    public final w4.e j;

    /* renamed from: k, reason: collision with root package name */
    public final p1 f4665k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f4666l;

    /* renamed from: m, reason: collision with root package name */
    public int f4667m;

    public q0(w4.c cVar, w4.d dVar, w4.a aVar, p1 p1Var, String str, o2 o2Var, ArrayList arrayList, String str2, boolean z9, o1 o1Var, p1 p1Var2) {
        cVar.getClass();
        dVar.getClass();
        aVar.getClass();
        this.f4660a = cVar;
        this.f4661b = dVar;
        this.f4662c = aVar;
        this.f4663d = p1Var;
        this.f4664e = str;
        this.f = o2Var;
        this.g = arrayList;
        this.h = str2;
        this.i = z9;
        this.j = o1Var;
        this.f4665k = p1Var2;
        this.f4666l = new ArrayList();
    }

    public final void a(p2 p2Var) {
        this.f4666l = new ArrayList();
        x4.j jVar = p2Var.f11329a;
        int i = jVar.f11224a;
        if (i == -3 || i == -2) {
            Iterator it = p2Var.f11330b.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                o0 o0Var = new o0();
                o0Var.f4648a = (x4.g) next;
                o0Var.f4649b = 0;
                o0Var.f4650c = 0;
                this.f4666l.add(o0Var);
            }
        } else {
            String str = jVar.f11226l;
            if (str != null && str.length() != 0) {
                o0 o0Var2 = new o0();
                o0Var2.f4649b = 5;
                this.f4666l.add(o0Var2);
                o0 o0Var3 = new o0();
                o0Var3.f4649b = 2;
                this.f4666l.add(o0Var3);
            }
            int i6 = 0;
            int i10 = 0;
            for (x4.g gVar : p2Var.f11330b) {
                int i11 = i6 + 1;
                o0 o0Var4 = new o0();
                o0Var4.f4648a = gVar;
                if (gVar.m()) {
                    o0Var4.f4649b = 3;
                    o0Var4.f4650c = 0;
                } else {
                    i10++;
                    o0Var4.f4650c = i10;
                    if (i6 >= 10) {
                        o0Var4.f4649b = 0;
                    } else if (p2Var.f11329a.f11224a == 1090) {
                        o0Var4.f4649b = 4;
                    } else {
                        o0Var4.f4649b = 1;
                    }
                }
                this.f4667m = i10;
                this.f4666l.add(o0Var4);
                i6 = i11;
            }
        }
        String str2 = p2Var.f11329a.f11226l;
        int i12 = (str2 == null || str2.length() == 0) ? 20 : 22;
        ArrayList arrayList = this.g;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        o0 o0Var5 = new o0();
        o0Var5.f4648a = arrayList;
        o0Var5.f4649b = 6;
        o0Var5.f4650c = 0;
        int size = this.f4666l.size();
        ArrayList arrayList2 = this.f4666l;
        if (size > i12) {
            arrayList2.add(i12, o0Var5);
        } else {
            arrayList2.add(o0Var5);
        }
    }

    public final void b(x4.g gVar) {
        gVar.getClass();
        Iterator it = this.f4666l.iterator();
        int i = 0;
        while (it.hasNext()) {
            int i6 = i + 1;
            Object obj = ((o0) it.next()).f4648a;
            if (obj instanceof x4.g) {
                obj.getClass();
                if (((x4.g) obj).f11158a == gVar.f11158a) {
                    notifyItemChanged(i);
                    return;
                }
            }
            i = i6;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4666l.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return ((o0) this.f4666l.get(i)).f4649b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ImageView imageView;
        TextView textView;
        final int i6;
        int i10;
        int i11;
        String format;
        int i12;
        int i13;
        x4.e eVar;
        x4.r K;
        int i14;
        int i15;
        String format2;
        viewHolder.getClass();
        if (!(viewHolder instanceof m5.f1)) {
            if (!(viewHolder instanceof m5.d1)) {
                if (viewHolder instanceof m5.g1) {
                    Object obj = ((o0) this.f4666l.get(i)).f4648a;
                    obj.getClass();
                    ((m5.g1) viewHolder).g((x4.g) obj, ((o0) this.f4666l.get(i)).f4650c);
                    return;
                } else {
                    if ((viewHolder instanceof m5.h1) || (viewHolder instanceof m5.i1)) {
                        return;
                    }
                    if (!(viewHolder instanceof m5.o)) {
                        com.google.gson.internal.a.p("ViewHolder unknown!!");
                        return;
                    }
                    Object obj2 = ((o0) this.f4666l.get(i)).f4648a;
                    obj2.getClass();
                    ((m5.o) viewHolder).a((ArrayList) obj2);
                    return;
                }
            }
            final m5.d1 d1Var = (m5.d1) viewHolder;
            Object obj3 = ((o0) this.f4666l.get(i)).f4648a;
            obj3.getClass();
            final x4.g gVar = (x4.g) obj3;
            int i16 = ((o0) this.f4666l.get(i)).f4650c;
            ImageView imageView2 = d1Var.f7359o;
            LinearLayout linearLayout = d1Var.v;
            TextView textView2 = d1Var.f7362r;
            TextView textView3 = d1Var.f7363s;
            RelativeLayout relativeLayout = d1Var.f7358n;
            relativeLayout.setOnLongClickListener(new d4.d(d1Var, gVar, i, 8));
            m5.e.b(relativeLayout, d1Var.f7355b, gVar);
            TextView textView4 = d1Var.f7361q;
            if (textView4 != null) {
                imageView = imageView2;
                textView4.setText(d1Var.itemView.getContext().getResources().getString(2131952659, String.valueOf(i16)));
            } else {
                imageView = imageView2;
            }
            int i17 = gVar.f11194y;
            if (i17 <= 0 || gVar.f11181r <= 0) {
                textView = textView3;
                if (linearLayout != null) {
                    linearLayout.setVisibility(4);
                }
            } else {
                TextView textView5 = d1Var.f7364t;
                if (textView5 != null) {
                    textView5.setText(String.valueOf(i17 / 10.0d));
                }
                TextView textView6 = d1Var.f7365u;
                if (textView6 != null) {
                    Context context = d1Var.itemView.getContext();
                    long j = gVar.f11181r;
                    if (j < 1000) {
                        format = String.valueOf(j);
                        textView = textView3;
                        i10 = 0;
                        i11 = 1;
                    } else if (j < 1000000) {
                        textView = textView3;
                        i10 = 0;
                        format = String.format(Locale.getDefault(), "%dK", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j) / 1000)}, 1));
                        i11 = 1;
                    } else {
                        textView = textView3;
                        i10 = 0;
                        i11 = 1;
                        format = String.format(Locale.getDefault(), "%dM", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j) / 1000000)}, 1));
                    }
                    Object[] objArr = new Object[i11];
                    objArr[i10] = format;
                    textView6.setText(context.getString(2131952476, objArr));
                } else {
                    textView = textView3;
                    i10 = 0;
                }
                if (linearLayout != null) {
                    linearLayout.setVisibility(i10);
                }
            }
            d1Var.f7360p.setText(gVar.f11159b);
            String str = gVar.f11192x;
            if (str == null || str.length() == 0) {
                i6 = 0;
                textView2.setText(gVar.f11190w);
            } else {
                String str2 = gVar.f11192x;
                str2.getClass();
                i6 = 0;
                textView2.setText(l7.u.o0(new l7.k("<(\\w+)>(.*?)</(\\w+)>").b(new l7.k("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]").b(new SpannableStringBuilder(str2), new x4.l(2)), new x4.l(3)), "<br />", "", false));
            }
            TextView textView7 = textView;
            textView7.setOnClickListener(new View.OnClickListener(d1Var, gVar, i, i6) { // from class: m5.c1

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f7333a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d1 f7334b;

                /* renamed from: l, reason: collision with root package name */
                public final /* synthetic */ x4.g f7335l;

                {
                    this.f7333a = i6;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (this.f7333a) {
                        case 0:
                            this.f7334b.f7356l.b(this.f7335l);
                            break;
                        default:
                            this.f7334b.f7356l.b(this.f7335l);
                            break;
                    }
                }
            });
            ImageView imageView3 = imageView;
            d1Var.e(imageView3, gVar.h());
            t0.f.s(d1Var.f7367x, imageView3);
            final int i18 = 1;
            textView7.setOnClickListener(new View.OnClickListener(d1Var, gVar, i, i18) { // from class: m5.c1

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ int f7333a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ d1 f7334b;

                /* renamed from: l, reason: collision with root package name */
                public final /* synthetic */ x4.g f7335l;

                {
                    this.f7333a = i18;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (this.f7333a) {
                        case 0:
                            this.f7334b.f7356l.b(this.f7335l);
                            break;
                        default:
                            this.f7334b.f7356l.b(this.f7335l);
                            break;
                    }
                }
            });
            d1Var.f7366w.setVisibility(8);
            textView2.setVisibility(i6);
            textView7.setVisibility(i6);
            if (d1Var.itemView.getContext() != null) {
                e1.c0 c0Var = j5.g.D;
                Context context2 = d1Var.itemView.getContext();
                context2.getClass();
                j5.g l10 = c0Var.l(context2);
                l10.b();
                if (l10.U(gVar.f11158a) == null) {
                    textView7.setText(2131952477);
                    z3.J(textView7);
                } else {
                    textView7.setText(2131951768);
                    textView7.setVisibility(0);
                    textView7.setBackground(ContextCompat.getDrawable(textView7.getContext(), 2131231149));
                    textView7.setTextColor(ContextCompat.getColor(textView7.getContext(), 2131100824));
                }
                l10.c();
                return;
            }
            return;
        }
        Object obj4 = ((o0) this.f4666l.get(i)).f4648a;
        obj4.getClass();
        x4.g gVar2 = (x4.g) obj4;
        m5.f1 f1Var = (m5.f1) viewHolder;
        TextView textView8 = f1Var.f7389u;
        int i19 = ((o0) this.f4666l.get(i)).f4650c;
        ImageView imageView4 = f1Var.B;
        TextView textView9 = f1Var.f7388t;
        RelativeLayout relativeLayout2 = f1Var.f7384p;
        if (gVar2.m()) {
            i12 = i19;
            if (!gVar2.f11193x0) {
                gVar2.f11193x0 = true;
                p1 p1Var = f1Var.f7383o;
                if (p1Var != null) {
                    z1 z1Var = p1Var.f10571a;
                    d2 d10 = z1Var.d();
                    Context requireContext = z1Var.requireContext();
                    requireContext.getClass();
                    d10.d(requireContext, gVar2, "impress");
                }
            }
        } else {
            i12 = i19;
        }
        relativeLayout2.setOnLongClickListener(new d4.d(f1Var, gVar2, i, 9));
        m5.e.b(relativeLayout2, f1Var.f7379b, gVar2);
        TextView textView10 = f1Var.f7387s;
        if (textView10 != null) {
            textView10.setText(f1Var.itemView.getContext().getResources().getString(2131952659, String.valueOf(i12)));
        }
        TextView textView11 = f1Var.v;
        if (textView11 != null) {
            textView11.setText(String.valueOf(gVar2.f11194y / 10.0d));
        }
        TextView textView12 = f1Var.f7390w;
        if (textView12 != null) {
            Context context3 = f1Var.itemView.getContext();
            long j6 = gVar2.f11181r;
            if (j6 < 1000) {
                format2 = String.valueOf(j6);
                i15 = 1;
            } else if (j6 < 1000000) {
                i15 = 1;
                format2 = String.format(Locale.getDefault(), "%dK", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j6) / 1000)}, 1));
            } else {
                i15 = 1;
                format2 = String.format(Locale.getDefault(), "%dM", Arrays.copyOf(new Object[]{Integer.valueOf(((int) j6) / 1000000)}, 1));
            }
            Object[] objArr2 = new Object[i15];
            objArr2[0] = format2;
            textView12.setText(context3.getString(2131951973, objArr2));
        }
        f1Var.f7386r.setText(gVar2.f11159b);
        String str3 = gVar2.f11192x;
        if (str3 == null || str3.length() == 0) {
            i13 = 0;
            textView9.setText(gVar2.f11190w);
        } else {
            String str4 = gVar2.f11192x;
            str4.getClass();
            i13 = 0;
            textView9.setText(l7.u.o0(new l7.k("<(\\w+)>(.*?)</(\\w+)>").b(new l7.k("\\[(\\w+)=([\\w\\d]*)](.*?)\\[/(\\w+)]").b(new SpannableStringBuilder(str4), new x4.l(2)), new x4.l(3)), "<br />", "", false));
        }
        textView8.setOnClickListener(new m5.e1(f1Var, gVar2, i, i13));
        if (imageView4 != null) {
            imageView4.setVisibility(f1Var.f7382n ? 0 : 8);
        }
        if (imageView4 != null) {
            imageView4.setOnClickListener(new m5.e1(f1Var, gVar2, i, 1));
        }
        f1Var.e(f1Var.f7385q, gVar2.h());
        e1.c0 c0Var2 = j5.g.D;
        Context context4 = f1Var.itemView.getContext();
        context4.getClass();
        j5.g l11 = c0Var2.l(context4);
        l11.b();
        String str5 = gVar2.F;
        q2 q2Var = null;
        if (str5 == null || str5.length() == 0) {
            eVar = null;
        } else {
            String str6 = gVar2.F;
            str6.getClass();
            eVar = l11.B(str6);
        }
        long j10 = gVar2.f11158a;
        boolean z9 = a5.b.c(j10) || a5.c.b(j10);
        if (z9) {
            long j11 = gVar2.f11158a;
            if (a5.b.c(j11)) {
                K = a5.b.b();
            } else {
                if (a5.c.b(j11)) {
                    K = a5.c.a();
                }
                K = null;
            }
        } else {
            String str7 = gVar2.F;
            if (str7 != null && str7.length() != 0) {
                String str8 = gVar2.F;
                str8.getClass();
                K = l11.K(str8);
            }
            K = null;
        }
        if (eVar != null) {
            String str9 = gVar2.F;
            if (str9 != null && str9.length() != 0) {
                String str10 = gVar2.F;
                str10.getClass();
                q2Var = l11.Y(str10);
            }
            l4.a c9 = f4.a.f4869a.c();
            if (c9 != null) {
                i14 = 1;
                if (l7.u.m0(c9.f7095a, eVar.f11123l, true)) {
                    f1Var.i();
                }
            } else {
                i14 = 1;
            }
            if (q2Var == null || q2Var.c() || eVar.v == i14) {
                f1Var.g(gVar2, i);
                textView8.setText(2131952419);
                z3.J(textView8);
            } else {
                if (!z9 || K == null) {
                    float f = UptodownApp.I;
                    if (!b4.d.m(q2Var.f11344b)) {
                        String string = f1Var.itemView.getContext().getString(2131951657);
                        string.getClass();
                        f1Var.g(gVar2, i);
                        textView8.setText(string);
                        z3.J(textView8);
                    }
                }
                K.getClass();
                f1Var.h(K, gVar2, i);
            }
        } else if (K == null) {
            String string2 = f1Var.itemView.getContext().getString(2131952428);
            string2.getClass();
            f1Var.g(gVar2, i);
            textView8.setText(string2);
            z3.J(textView8);
        } else if (K.n()) {
            f1Var.i();
        } else if (K.c()) {
            f1Var.g(gVar2, i);
            textView8.setText(2131952428);
            textView8.setOnClickListener(new m5.e1(f1Var, gVar2, i, 2));
            z3.J(textView8);
        } else if (z9 || K.m()) {
            f1Var.h(K, gVar2, i);
        } else {
            String string3 = f1Var.itemView.getContext().getString(2131952428);
            string3.getClass();
            f1Var.g(gVar2, i);
            textView8.setText(string3);
            z3.J(textView8);
        }
        l11.c();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        boolean z9;
        o2 o2Var;
        String format;
        viewGroup.getClass();
        w4.a aVar = this.f4662c;
        w4.c cVar = this.f4660a;
        switch (i) {
            case 0:
                return new m5.g1(androidx.lifecycle.l.E(viewGroup, 2131558440, viewGroup, false), cVar, aVar, this.i);
            case 1:
                return new m5.f1(androidx.lifecycle.l.E(viewGroup, 2131558439, viewGroup, false), this.f4660a, this.f4661b, this.f4662c, this.i, this.f4665k);
            case 2:
                View b7 = c.j.b(viewGroup, 2131558827, null, false);
                int i6 = 2131362519;
                if (((ImageView) ViewBindings.findChildViewById(b7, 2131362519)) != null) {
                    i6 = 2131362520;
                    if (((ImageView) ViewBindings.findChildViewById(b7, 2131362520)) != null) {
                        i6 = 2131362521;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(b7, 2131362521);
                        if (imageView != null) {
                            i6 = 2131362747;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(b7, 2131362747);
                            if (linearLayout != null) {
                                i6 = 2131363120;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(b7, 2131363120);
                                if (relativeLayout != null) {
                                    i6 = 2131364465;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(b7, 2131364465);
                                    if (textView != null) {
                                        i6 = 2131364466;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(b7, 2131364466);
                                        if (textView2 != null) {
                                            i6 = 2131364467;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(b7, 2131364467);
                                            if (textView3 != null) {
                                                i6 = 2131364468;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(b7, 2131364468);
                                                if (textView4 != null) {
                                                    i6 = 2131364469;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(b7, 2131364469);
                                                    if (textView5 != null) {
                                                        RelativeLayout relativeLayout2 = (RelativeLayout) b7;
                                                        m5.h1 h1Var = new m5.h1(relativeLayout2);
                                                        o2 o2Var2 = this.f;
                                                        if (o2Var2 != null) {
                                                            textView3.setTypeface(f4.c.f4883x);
                                                            textView2.setTypeface(f4.c.f4882w);
                                                            textView2.setText(o2Var2.f11310d);
                                                            textView5.setTypeface(f4.c.f4883x);
                                                            Context context = h1Var.itemView.getContext();
                                                            long j = o2Var2.f11307a;
                                                            if (j <= 0) {
                                                                z9 = false;
                                                                o2Var = o2Var2;
                                                                format = null;
                                                            } else {
                                                                z9 = false;
                                                                o2Var = o2Var2;
                                                                format = new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j * 1000));
                                                            }
                                                            Object[] objArr = new Object[1];
                                                            objArr[z9 ? 1 : 0] = format;
                                                            textView5.setText(context.getString(2131951753, objArr));
                                                            o2 o2Var3 = o2Var;
                                                            a4.l0 e10 = a4.g0.d().e(o2Var3.f11311e);
                                                            float f = UptodownApp.I;
                                                            Context context2 = h1Var.itemView.getContext();
                                                            context2.getClass();
                                                            e10.h(b4.d.x(context2));
                                                            e10.e(imageView, null);
                                                            textView.setTypeface(f4.c.f4882w);
                                                            Context context3 = relativeLayout2.getContext();
                                                            Object[] objArr2 = new Object[1];
                                                            objArr2[z9 ? 1 : 0] = String.valueOf(o2Var3.f11308b);
                                                            textView.setText(context3.getString(2131951721, objArr2));
                                                        } else {
                                                            z9 = false;
                                                            relativeLayout.setVisibility(8);
                                                            linearLayout.setVisibility(8);
                                                            textView.setVisibility(8);
                                                        }
                                                        String str = this.f4664e;
                                                        if (str == null || str.length() == 0) {
                                                            h1Var.itemView.setVisibility(8);
                                                            return h1Var;
                                                        }
                                                        textView4.setTypeface(f4.c.f4883x);
                                                        p1 p1Var = this.f4663d;
                                                        if (p1Var == null) {
                                                            textView4.setText(str);
                                                            return h1Var;
                                                        }
                                                        textView4.setOnTouchListener(new l5.e());
                                                        Context context4 = h1Var.itemView.getContext();
                                                        context4.getClass();
                                                        boolean z10 = z9;
                                                        String o02 = l7.u.o0(l7.u.o0(str, "<br />", "\n", z10), "<br/>", "\n", z10);
                                                        List<x4.o> w2 = a.a.w(o02);
                                                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(o02);
                                                        int i10 = 0;
                                                        for (x4.o oVar : w2) {
                                                            int i11 = oVar.f11300a;
                                                            String str2 = oVar.f11304e;
                                                            String str3 = oVar.f11303d;
                                                            int i12 = i11 - i10;
                                                            int length = str3.length() + i12;
                                                            str2.getClass();
                                                            spannableStringBuilder = spannableStringBuilder.replace(i12, str2.length() + i12, (CharSequence) str3);
                                                            spannableStringBuilder.getClass();
                                                            String str4 = oVar.f11301b;
                                                            switch (str4.hashCode()) {
                                                                case 116079:
                                                                    if (str4.equals("url")) {
                                                                        spannableStringBuilder.setSpan(new x4.m(oVar, p1Var, context4, 3), i12, length, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 93028092:
                                                                    if (str4.equals("appID")) {
                                                                        spannableStringBuilder.setSpan(new x4.m(oVar, p1Var, context4, 0), i12, length, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 1296531097:
                                                                    if (str4.equals("categoryID")) {
                                                                        spannableStringBuilder.setSpan(new x4.m(oVar, p1Var, context4, 2), i12, length, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                                case 1524339519:
                                                                    if (str4.equals("floatingCategoryID")) {
                                                                        spannableStringBuilder.setSpan(new x4.m(oVar, p1Var, context4, 1), i12, length, 33);
                                                                        break;
                                                                    } else {
                                                                        break;
                                                                    }
                                                            }
                                                            i10 = (str2.length() + i10) - str3.length();
                                                        }
                                                        textView4.setText(spannableStringBuilder);
                                                        return h1Var;
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
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(b7.getResources().getResourceName(i6)));
                return null;
            case 3:
                return new m5.f1(androidx.lifecycle.l.E(viewGroup, 2131558437, viewGroup, false), this.f4660a, this.f4661b, this.f4662c, this.i, this.f4665k);
            case 4:
                return new m5.d1(androidx.lifecycle.l.E(viewGroup, 2131558439, viewGroup, false), cVar, this.f4661b, aVar);
            case 5:
                View b10 = c.j.b(viewGroup, 2131558829, null, false);
                if (b10 == null) {
                    com.google.gson.internal.a.i("rootView");
                    return null;
                }
                TextView textView6 = (TextView) b10;
                m5.i1 i1Var = new m5.i1(textView6);
                textView6.setTypeface(f4.c.f4882w);
                textView6.setText(this.h);
                return i1Var;
            case 6:
                return new m5.o(androidx.lifecycle.l.E(viewGroup, 2131558555, viewGroup, false), new p0(this));
            default:
                com.google.gson.internal.a.p("viewType unknown");
                return null;
        }
    }
}
