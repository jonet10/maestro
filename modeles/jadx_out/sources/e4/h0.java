package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import x4.d2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4549a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4550b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.d f4551c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4552d;

    public h0(ArrayList arrayList, Context context, a3.d dVar) {
        arrayList.getClass();
        dVar.getClass();
        this.f4549a = arrayList;
        this.f4550b = context;
        this.f4551c = dVar;
    }

    public final void a(boolean z9) {
        this.f4552d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    public final void b(d2 d2Var) {
        d2Var.getClass();
        ArrayList arrayList = this.f4549a;
        Iterator it = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            int i6 = i + 1;
            if (((d2) it.next()).f11107a == d2Var.f11107a) {
                break;
            } else {
                i = i6;
            }
        }
        arrayList.set(i, d2Var);
        notifyItemChanged(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4549a.size() + (this.f4552d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4549a.size() ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008b  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.h0.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i == 0) {
            View b7 = c.j.b(viewGroup, 2131558802, viewGroup, false);
            b7.getClass();
            return new m5.q0(this.f4551c, this.f4550b, b7);
        }
        if (i != 1) {
            com.google.gson.internal.a.p("viewType unknown");
            return null;
        }
        View b10 = c.j.b(viewGroup, 2131558768, viewGroup, false);
        b10.getClass();
        return new m5.c0(b10);
    }
}
