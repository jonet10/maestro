package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final x4.g f4680a;

    /* renamed from: b, reason: collision with root package name */
    public x4.e f4681b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f4682c;

    /* renamed from: d, reason: collision with root package name */
    public final f0.i f4683d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4684e;
    public int f;

    public s(x4.g gVar, x4.e eVar, Context context, f0.i iVar, int i) {
        iVar.getClass();
        this.f4680a = gVar;
        this.f4681b = eVar;
        this.f4682c = context;
        this.f4683d = iVar;
        this.f4684e = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f4680a.E0;
        return (arrayList != null ? arrayList.size() : 0) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        if (i == 0) {
            return 0;
        }
        ArrayList arrayList = this.f4680a.E0;
        return i < (arrayList != null ? arrayList.size() : 0) ? 1 : 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0101  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r21, int r22) {
        /*
            Method dump skipped, instructions count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.s.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        Context context = this.f4682c;
        if (i == 0) {
            View inflate = LayoutInflater.from(context).inflate(2131558567, viewGroup, false);
            inflate.getClass();
            return new m5.t(inflate, context);
        }
        if (i != 1) {
            View inflate2 = LayoutInflater.from(context).inflate(2131558676, viewGroup, false);
            inflate2.getClass();
            return new m5.b0(inflate2);
        }
        View inflate3 = LayoutInflater.from(context).inflate(2131558759, viewGroup, false);
        inflate3.getClass();
        return new m5.l0(inflate3, this.f4683d);
    }
}
