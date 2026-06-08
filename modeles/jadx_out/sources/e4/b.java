package e4;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final f0.i f4484a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4485b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4486c;

    /* renamed from: d, reason: collision with root package name */
    public boolean[] f4487d;

    /* renamed from: e, reason: collision with root package name */
    public int f4488e;

    public b(f0.i iVar) {
        iVar.getClass();
        this.f4484a = iVar;
        this.f4485b = new ArrayList();
        this.f4488e = -1;
    }

    public final void a(File file) {
        file.getClass();
        Iterator it = this.f4485b.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            int i6 = i + 1;
            if (kotlin.jvm.internal.l.a(((x4.r) it.next()).f(), file)) {
                break;
            } else {
                i = i6;
            }
        }
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    public final void b(int i) {
        boolean[] zArr = this.f4487d;
        zArr.getClass();
        this.f4487d.getClass();
        zArr[i] = !r1[i];
        notifyItemChanged(i);
    }

    public final void c(boolean z9) {
        this.f4486c = z9;
        if (!z9) {
            if (this.f4485b.isEmpty()) {
                this.f4487d = new boolean[0];
            } else {
                this.f4487d = new boolean[this.f4485b.size()];
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4485b.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0190  */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v6 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r25, int r26) {
        /*
            Method dump skipped, instructions count: 1359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.b.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558539, viewGroup, false);
        s6.getClass();
        return new m5.i(s6, this.f4484a);
    }
}
