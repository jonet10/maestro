package e4;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4570a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4571b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.b f4572c;

    public j0(ArrayList arrayList, Context context, w4.b bVar) {
        bVar.getClass();
        this.f4570a = arrayList;
        this.f4571b = context;
        this.f4572c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4570a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m5.v0 v0Var = (m5.v0) viewHolder;
        v0Var.getClass();
        Object obj = this.f4570a.get(i);
        obj.getClass();
        x4.e eVar = (x4.e) obj;
        ImageView imageView = v0Var.f7618n;
        Context context = this.f4571b;
        context.getClass();
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String str = eVar.f11123l;
            str.getClass();
            ApplicationInfo applicationInfo = n4.i.e(packageManager, str, 0).applicationInfo;
            if (applicationInfo != null) {
                imageView.setImageDrawable(applicationInfo.loadIcon(context.getPackageManager()));
            }
        } catch (Exception e10) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231475));
            e10.printStackTrace();
        }
        v0Var.f7615b.setText(eVar.f11122b);
        v0Var.f7616l.setText(eVar.f11125n);
        v0Var.f7617m.setText(i5.H(context, eVar.f11133w));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(this.f4571b).inflate(2131558808, viewGroup, false);
        inflate.getClass();
        return new m5.v0(inflate, this.f4572c);
    }
}
