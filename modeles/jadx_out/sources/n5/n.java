package n5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.Locale;
import m8.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f8099a;

    /* renamed from: b, reason: collision with root package name */
    public final k f8100b;

    public n(HashMap hashMap, k kVar) {
        this.f8099a = hashMap;
        this.f8100b = kVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f8099a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        String str;
        m mVar = (m) viewHolder;
        mVar.getClass();
        q qVar = mVar.f8098a;
        String str2 = (String) this.f8099a.get(Integer.valueOf(i));
        if (str2 == null || str2.length() == 0) {
            return;
        }
        TextView textView = (TextView) qVar.f7781l;
        if (str2.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String valueOf = String.valueOf(str2.charAt(0));
            valueOf.getClass();
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            sb.append((Object) upperCase);
            sb.append(str2.substring(1));
            str = sb.toString();
        } else {
            str = str2;
        }
        textView.setText(str);
        ((TextView) qVar.f7781l).setTypeface(f4.c.f4883x);
        mVar.itemView.setOnClickListener(new g4.a(this, i, str2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558542, viewGroup, false);
        if (s6 != null) {
            TextView textView = (TextView) s6;
            return new m(new q(12, textView, textView));
        }
        com.google.gson.internal.a.i("rootView");
        return null;
    }
}
