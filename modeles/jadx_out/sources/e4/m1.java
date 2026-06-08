package e4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import c4.xd;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.HashMap;
import x4.d3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f4628a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4629b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f4630c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4631d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4632e;
    public boolean f;
    public final YouTubePlayerView g;
    public v3.e h;
    public String i;
    public String j;

    /* renamed from: k, reason: collision with root package name */
    public int f4633k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4634l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4635m;

    /* renamed from: n, reason: collision with root package name */
    public l5.c f4636n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4637o;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m1(w4.j r5, w4.a r6, android.content.Context r7, java.lang.String r8) {
        /*
            r4 = this;
            java.lang.String r0 = "SettingsPreferences"
            r5.getClass()
            r6.getClass()
            r8.getClass()
            r4.<init>()
            r4.f4628a = r5
            r4.f4629b = r6
            r4.f4630c = r7
            r4.f4631d = r8
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r4.f4632e = r5
            java.lang.String r5 = ""
            r4.i = r5
            r5 = 1
            r4.f4635m = r5
            r6 = 8
            r4.f4637o = r6
            java.lang.String r8 = "app_detail_inflate_view_failed"
            r1 = 0
            android.content.SharedPreferences r2 = r7.getSharedPreferences(r0, r1)     // Catch: java.lang.Exception -> L3a
            boolean r3 = r2.contains(r8)     // Catch: java.lang.Exception -> L3a
            if (r3 == 0) goto L3a
            boolean r2 = r2.getBoolean(r8, r1)     // Catch: java.lang.Exception -> L3a
            goto L3b
        L3a:
            r2 = r1
        L3b:
            if (r2 != 0) goto L87
            r2 = 0
            com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView r3 = new com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView     // Catch: java.lang.Exception -> L4c java.lang.UnsatisfiedLinkError -> L4e
            r3.<init>(r7)     // Catch: java.lang.Exception -> L4c java.lang.UnsatisfiedLinkError -> L4e
            r3.setEnableAutomaticInitialization(r1)     // Catch: java.lang.Exception -> L4c java.lang.UnsatisfiedLinkError -> L4e
            r4.g = r3     // Catch: java.lang.Exception -> L4c java.lang.UnsatisfiedLinkError -> L4e
            r4.a()     // Catch: java.lang.Exception -> L4c java.lang.UnsatisfiedLinkError -> L4e
            goto L87
        L4c:
            r7 = move-exception
            goto L50
        L4e:
            r7 = move-exception
            goto L6c
        L50:
            android.content.Context r3 = r4.f4630c
            r3.getClass()
            android.content.SharedPreferences r0 = r3.getSharedPreferences(r0, r1)
            r0.getClass()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r8, r5)
            r0.apply()
            r4.g = r2
            r7.printStackTrace()
            goto L87
        L6c:
            android.content.Context r3 = r4.f4630c
            r3.getClass()
            android.content.SharedPreferences r0 = r3.getSharedPreferences(r0, r1)
            r0.getClass()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r0.putBoolean(r8, r5)
            r0.apply()
            r4.g = r2
            r7.printStackTrace()
        L87:
            java.lang.String r5 = r4.f4631d
            java.lang.Class<u4.m1> r7 = u4.m1.class
            kotlin.jvm.internal.f r7 = kotlin.jvm.internal.y.a(r7)
            java.lang.String r7 = r7.c()
            boolean r5 = kotlin.jvm.internal.l.a(r5, r7)
            if (r5 == 0) goto L9c
            r4.f4637o = r6
            goto La0
        L9c:
            r5 = 20
            r4.f4637o = r5
        La0:
            float r5 = com.uptodown.UptodownApp.I
            android.content.Context r5 = r4.f4630c
            boolean r5 = b4.d.e(r5)
            r4.f4635m = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.m1.<init>(w4.j, w4.a, android.content.Context, java.lang.String):void");
    }

    public final void a() {
        YouTubePlayerView youTubePlayerView = this.g;
        if (youTubePlayerView != null) {
            z3.c cVar = youTubePlayerView.f3285b;
            cVar.removeViews(1, cVar.getChildCount() - 1);
            View inflate = View.inflate(cVar.getContext(), 2131558576, cVar);
            inflate.getClass();
            k9.c cVar2 = new k9.c(this.f4630c);
            cVar2.d(0, "controls");
            cVar2.d(0, "rel");
            cVar2.d(3, "iv_load_policy");
            cVar2.d(1, "cc_load_policy");
            youTubePlayerView.a(new xd(1, this, inflate), new k9.b(cVar2.f7009b));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4632e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z9;
        ArrayList arrayList;
        ArrayList arrayList2;
        ImageView imageView;
        SharedPreferences sharedPreferences;
        l1 l1Var = (l1) viewHolder;
        l1Var.getClass();
        RelativeLayout relativeLayout = l1Var.f4611p;
        ImageView imageView2 = l1Var.f4610o;
        int i6 = i + 1;
        Context context = this.f4630c;
        context.getClass();
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception unused) {
        }
        if (sharedPreferences.contains("app_detail_inflate_view_failed")) {
            z9 = sharedPreferences.getBoolean("app_detail_inflate_view_failed", false);
            arrayList = this.f4632e;
            if (!z9 || i != this.f4633k) {
                Object obj = arrayList.get(i);
                obj.getClass();
                l1Var.g((x4.g) obj, i6);
            }
            Object obj2 = arrayList.get(i);
            obj2.getClass();
            x4.g gVar = (x4.g) obj2;
            String str = l1Var.f4609n;
            Context context2 = l1Var.f4608m;
            View view = l1Var.f4619y;
            CardView cardView = l1Var.f4618x;
            Float valueOf = Float.valueOf(0.0f);
            m1 m1Var = l1Var.A;
            YouTubePlayerView youTubePlayerView = m1Var.g;
            if (youTubePlayerView != null) {
                if (youTubePlayerView.getParent() != null) {
                    ViewParent parent = youTubePlayerView.getParent();
                    parent.getClass();
                    ((ViewGroup) parent).removeView(youTubePlayerView);
                }
                cardView.addView(youTubePlayerView);
                cardView.setVisibility(0);
                view.setVisibility(0);
                imageView2.setVisibility(8);
                l5.c cVar = m1Var.f4636n;
                if (cVar != null && (imageView = cVar.f7131b) != null) {
                    imageView.setImageDrawable(null);
                }
                m5.e.f(gVar, l1Var.f4614s, l1Var.f4615t);
                m5.e.b(relativeLayout, l1Var.f4606b, gVar);
                l1.h(imageView2, gVar);
                l1Var.e(l1Var.f4613r, gVar.i());
                l1Var.c(gVar, l1Var.f4612q, l1Var.f4613r, l1Var.f4615t, l1Var.v, l1Var.f4616u, l1Var.f4617w);
                view.setOnClickListener(new c4.d(m1Var, 17));
                relativeLayout.setOnLongClickListener(new k1(l1Var, gVar, i6, 0));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l1Var.f4620z, -1);
                View view2 = l1Var.itemView;
                m5.e.a(layoutParams, context2, i6, m1Var.f4637o);
                view2.setLayoutParams(layoutParams);
                if (m1Var.f4634l && m1Var.h != null && (arrayList2 = gVar.Y) != null && !arrayList2.isEmpty()) {
                    ArrayList arrayList3 = gVar.Y;
                    arrayList3.getClass();
                    if (((d3) arrayList3.get(0)).f11119a != null) {
                        ArrayList arrayList4 = gVar.Y;
                        arrayList4.getClass();
                        if (!kotlin.jvm.internal.l.a(((d3) arrayList4.get(0)).f11119a, m1Var.j)) {
                            ArrayList arrayList5 = gVar.Y;
                            arrayList5.getClass();
                            m1Var.j = ((d3) arrayList5.get(0)).f11119a;
                            String str2 = gVar.f11159b;
                            str2.getClass();
                            m1Var.i = str2 + str;
                            if (kotlin.jvm.internal.l.a(str, kotlin.jvm.internal.y.a(u4.m1.class).c())) {
                                float f = UptodownApp.I;
                                UptodownApp.Z = m1Var.h;
                            } else {
                                float f10 = UptodownApp.I;
                                UptodownApp.a0 = m1Var.h;
                            }
                            float f11 = UptodownApp.I;
                            if (b4.d.e(context2)) {
                                HashMap hashMap = UptodownApp.f3288b0;
                                boolean containsKey = hashMap.containsKey(m1Var.i);
                                v3.e eVar = m1Var.h;
                                if (containsKey) {
                                    eVar.getClass();
                                    ArrayList arrayList6 = gVar.Y;
                                    arrayList6.getClass();
                                    String str3 = ((d3) arrayList6.get(0)).f11119a;
                                    str3.getClass();
                                    Object obj3 = hashMap.get(m1Var.i);
                                    obj3.getClass();
                                    ((z3.g) eVar).d(str3, ((Number) obj3).floatValue());
                                } else {
                                    eVar.getClass();
                                    ArrayList arrayList7 = gVar.Y;
                                    arrayList7.getClass();
                                    String str4 = ((d3) arrayList7.get(0)).f11119a;
                                    str4.getClass();
                                    ((z3.g) eVar).d(str4, 0.0f);
                                    hashMap.put(m1Var.i, valueOf);
                                }
                                boolean z10 = m1Var.f;
                                v3.e eVar2 = m1Var.h;
                                if (z10) {
                                    eVar2.getClass();
                                    ((z3.g) eVar2).f();
                                    return;
                                } else {
                                    eVar2.getClass();
                                    ((z3.g) eVar2).e();
                                    return;
                                }
                            }
                            HashMap hashMap2 = UptodownApp.f3288b0;
                            boolean containsKey2 = hashMap2.containsKey(m1Var.i);
                            v3.e eVar3 = m1Var.h;
                            if (containsKey2) {
                                eVar3.getClass();
                                ArrayList arrayList8 = gVar.Y;
                                arrayList8.getClass();
                                String str5 = ((d3) arrayList8.get(0)).f11119a;
                                str5.getClass();
                                Object obj4 = hashMap2.get(m1Var.i);
                                obj4.getClass();
                                ((z3.g) eVar3).b(str5, ((Number) obj4).floatValue());
                            } else {
                                eVar3.getClass();
                                ArrayList arrayList9 = gVar.Y;
                                arrayList9.getClass();
                                String str6 = ((d3) arrayList9.get(0)).f11119a;
                                str6.getClass();
                                ((z3.g) eVar3).b(str6, 0.0f);
                                hashMap2.put(m1Var.i, valueOf);
                            }
                            String e10 = gVar.e();
                            if (e10 == null || e10.length() == 0) {
                                return;
                            }
                            l5.c cVar2 = m1Var.f4636n;
                            cVar2.getClass();
                            cVar2.f7131b.setVisibility(0);
                            l5.c cVar3 = m1Var.f4636n;
                            cVar3.getClass();
                            l1.h(cVar3.f7131b, gVar);
                            return;
                        }
                    }
                }
                ArrayList arrayList10 = gVar.Y;
                if (arrayList10 == null || arrayList10.isEmpty()) {
                    l1Var.g(gVar, i6);
                }
                if (m1Var.h == null) {
                    m1Var.a();
                    return;
                }
                return;
            }
            return;
        }
        z9 = false;
        arrayList = this.f4632e;
        if (!z9) {
        }
        Object obj5 = arrayList.get(i);
        obj5.getClass();
        l1Var.g((x4.g) obj5, i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558575, viewGroup, false);
        s6.getClass();
        return new l1(this, s6, this.f4628a, this.f4629b, this.f4630c, this.f4631d);
    }
}
