package e4;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f4517b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f4518l;

    public /* synthetic */ e0(RecyclerView.ViewHolder viewHolder, int i, int i6) {
        this.f4516a = i6;
        this.f4518l = viewHolder;
        this.f4517b = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onClick(android.view.View r8) {
        /*
            r7 = this;
            int r8 = r7.f4516a
            r0 = -1
            int r1 = r7.f4517b
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r7.f4518l
            switch(r8) {
                case 0: goto Ld2;
                case 1: goto L47;
                case 2: goto L12;
                default: goto La;
            }
        La:
            m5.q0 r2 = (m5.q0) r2
            a3.d r8 = r2.f7526b
            r8.D(r1)
            return
        L12:
            e4.z0 r2 = (e4.z0) r2
            f0.i r8 = r2.f4731b
            r8.getClass()
            java.lang.Object r8 = r8.f4811b
            com.uptodown.activities.UserAvatarActivity r8 = (com.uptodown.activities.UserAvatarActivity) r8
            e4.a1 r2 = r8.R
            if (r2 == 0) goto L37
            int r3 = r2.f
            if (r3 == r0) goto L37
            r2.notifyItemChanged(r3)
            e4.a1 r2 = r8.R
            r2.getClass()
            r2.f = r0
            e4.a1 r0 = r8.R
            r0.getClass()
            r0.notifyItemChanged(r1)
        L37:
            e4.a1 r0 = r8.Q
            r0.getClass()
            r0.f = r1
            e4.a1 r8 = r8.Q
            r8.getClass()
            r8.notifyDataSetChanged()
            return
        L47:
            e4.y0 r2 = (e4.y0) r2
            f0.i r8 = r2.f4724b
            r8.getClass()
            java.lang.Object r8 = r8.f4811b
            com.uptodown.activities.UserAvatarActivity r8 = (com.uptodown.activities.UserAvatarActivity) r8
            int r2 = com.uptodown.activities.UserAvatarActivity.V
            c4.ub r2 = r8.z0()
            r7.o0 r2 = r2.f2184e
            java.lang.Object r2 = r2.getValue()
            r3 = 0
            if (r2 == 0) goto Lca
            java.lang.String r2 = "SharedPreferencesUser"
            r4 = 0
            android.content.SharedPreferences r2 = r8.getSharedPreferences(r2, r4)
            java.lang.String r5 = "UTOKEN"
            java.lang.String r6 = "SettingsPreferences"
            android.content.SharedPreferences r4 = r8.getSharedPreferences(r6, r4)     // Catch: java.lang.Exception -> L7b
            boolean r6 = r4.contains(r5)     // Catch: java.lang.Exception -> L7b
            if (r6 == 0) goto L7f
            java.lang.String r4 = r4.getString(r5, r3)     // Catch: java.lang.Exception -> L7b
            goto L80
        L7b:
            r4 = move-exception
            r4.printStackTrace()
        L7f:
            r4 = r3
        L80:
            if (r4 != 0) goto L8a
            java.lang.String r4 = "is_turbo"
            java.lang.String r2 = r2.getString(r4, r3)
            if (r2 == 0) goto Lca
        L8a:
            c4.ub r2 = r8.z0()
            r7.o0 r2 = r2.f2184e
            java.lang.Object r2 = r2.getValue()
            r2.getClass()
            x4.w2 r2 = (x4.w2) r2
            boolean r2 = r2.d()
            if (r2 == 0) goto Lca
            e4.a1 r2 = r8.Q
            if (r2 == 0) goto La8
            int r3 = r2.f
            if (r3 != r0) goto La8
            goto Lb5
        La8:
            r2.getClass()
            r2.f = r0
            e4.a1 r0 = r8.Q
            r0.getClass()
            r0.notifyDataSetChanged()
        Lb5:
            e4.a1 r0 = r8.R
            if (r0 == 0) goto Lbe
            int r2 = r0.f
            r0.notifyItemChanged(r2)
        Lbe:
            e4.a1 r8 = r8.R
            if (r8 == 0) goto Lc4
            r8.f = r1
        Lc4:
            if (r8 == 0) goto Ld1
            r8.notifyItemChanged(r1)
            goto Ld1
        Lca:
            java.lang.String r0 = d0.b.H(r8)
            j5.c.e(r8, r0, r3)
        Ld1:
            return
        Ld2:
            e4.f0 r2 = (e4.f0) r2
            w4.b r8 = r2.f4528l
            r8.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.e0.onClick(android.view.View):void");
    }

    public /* synthetic */ e0(RecyclerView.ViewHolder viewHolder, x4.i iVar, int i, int i6) {
        this.f4516a = i6;
        this.f4518l = viewHolder;
        this.f4517b = i;
    }
}
