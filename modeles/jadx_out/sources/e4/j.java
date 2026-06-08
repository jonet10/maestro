package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f4567a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4568b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4569c;

    public j(w4.j jVar, w4.a aVar) {
        aVar.getClass();
        this.f4567a = jVar;
        this.f4568b = aVar;
        this.f4569c = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4569c.size() * 100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        i iVar = (i) viewHolder;
        iVar.getClass();
        ArrayList arrayList = this.f4569c;
        int size = i % arrayList.size();
        Object obj = arrayList.get(size);
        obj.getClass();
        x4.g gVar = (x4.g) obj;
        ImageView imageView = iVar.f4557l;
        TextView textView = iVar.f4558m;
        float f = UptodownApp.I;
        int i6 = UptodownApp.Y;
        int dimension = (int) iVar.itemView.getContext().getResources().getDimension(2131166252);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, -2);
        layoutParams.setMargins(dimension, 0, dimension, 0);
        iVar.itemView.setLayoutParams(layoutParams);
        int i10 = 1;
        if (gVar.f11184s0 != x4.f.f11148o) {
            textView.setText(gVar.f11182r0);
            textView.setVisibility(0);
            textView.setTextColor(ContextCompat.getColor(iVar.itemView.getContext(), 2131100824));
            int ordinal = gVar.f11184s0.ordinal();
            if (ordinal == 0) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), 2131231193));
            } else if (ordinal == 1) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), 2131231230));
            } else if (ordinal == 2) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), 2131231229));
            } else if (ordinal == 3) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), 2131230853));
                textView.setTextColor(ContextCompat.getColor(iVar.itemView.getContext(), 2131100504));
            } else if (ordinal == 4) {
                textView.setBackground(ContextCompat.getDrawable(iVar.itemView.getContext(), 2131231231));
            }
        }
        iVar.f4559n.setText(gVar.f11159b);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, UptodownApp.S));
        a4.g0 d10 = a4.g0.d();
        String str = gVar.v;
        a4.l0 e10 = d10.e(str != null ? a4.x.k(str, UptodownApp.M, ":webp") : null);
        e10.f136c = true;
        Context context = iVar.itemView.getContext();
        context.getClass();
        e10.h(b4.d.w(context));
        e10.e(imageView, null);
        imageView.setOnClickListener(new c.e(24, iVar, gVar));
        imageView.setOnLongClickListener(new d4.d(iVar, gVar, size, i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558572, viewGroup, false);
        s6.getClass();
        return new i(s6, this.f4567a, this.f4568b);
    }
}
