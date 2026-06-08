package e4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import x4.x1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4499a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f4500b;

    /* renamed from: c, reason: collision with root package name */
    public int f4501c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4502d;

    public c0(MainActivity mainActivity, f0.i iVar) {
        mainActivity.getClass();
        iVar.getClass();
        this.f4499a = mainActivity;
        this.f4500b = iVar;
        this.f4502d = new ArrayList();
    }

    public final void a(int i) {
        if (i > -1) {
            ArrayList arrayList = this.f4502d;
            if (i < arrayList.size()) {
                arrayList.remove(i);
                this.f4501c--;
                notifyDataSetChanged();
                c4.k0 k0Var = (c4.k0) this.f4500b.f4811b;
                if (k0Var.J.isEmpty()) {
                    return;
                }
                Object remove = k0Var.J.remove(0);
                remove.getClass();
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(k0Var);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new b.n(k0Var, (x1) remove, (t6.c) null, 11), 2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4502d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        Object obj = this.f4502d.get(absoluteAdapterPosition);
        obj.getClass();
        x1 x1Var = (x1) obj;
        if (viewHolder instanceof m5.p) {
            m5.p pVar = (m5.p) viewHolder;
            pVar.f7499a.setText(x1Var.f11449b);
            a4.l0 e10 = a4.g0.d().e(x1Var.f11450c);
            float f = UptodownApp.I;
            Context context = this.f4499a;
            e10.g(b4.d.f(context));
            e10.h(b4.d.x(context));
            e10.e(pVar.f7501l, null);
            pVar.f7500b.setText(context.getString(2131952495));
            pVar.f7502m.setText(context.getString(2131952712));
        }
        if (absoluteAdapterPosition > this.f4501c) {
            Context context2 = viewHolder.itemView.getContext();
            context2.getClass();
            View view = viewHolder.itemView;
            view.getClass();
            float f10 = UptodownApp.I;
            boolean z9 = true;
            try {
                SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("animations")) {
                    z9 = sharedPreferences.getBoolean("animations", true);
                }
            } catch (Exception unused) {
            }
            if (z9) {
                float f11 = UptodownApp.I;
                view.startAnimation(AnimationUtils.loadAnimation(context2, 2130772030));
                view.setVisibility(0);
            } else {
                view.setVisibility(0);
            }
            this.f4501c = absoluteAdapterPosition;
        }
        viewHolder.itemView.setOnClickListener(new c.e(26, this, x1Var));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(this.f4499a).inflate(2131558556, viewGroup, false);
        inflate.getClass();
        return new m5.p(inflate);
    }
}
