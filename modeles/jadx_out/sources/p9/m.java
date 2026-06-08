package p9;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import g4.b0;
import h9.q;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final List f8538a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8539b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f8540c;

    /* renamed from: d, reason: collision with root package name */
    public final n9.a f8541d;

    public m(List list, Context context, Integer num, n9.a aVar) {
        list.getClass();
        this.f8538a = list;
        this.f8539b = context;
        this.f8540c = num;
        this.f8541d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f8538a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Float f;
        Typeface typeface;
        l lVar = (l) viewHolder;
        lVar.getClass();
        q qVar = (q) this.f8538a.get(i);
        n9.a aVar = lVar.f8536a;
        Context context = this.f8539b;
        context.getClass();
        qVar.getClass();
        SpannableString spannableString = new SpannableString(qVar.f5596a);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        TextView textView = lVar.f8537b;
        textView.setText(spannableString);
        Integer num = this.f8540c;
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        if (aVar != null && (typeface = aVar.f8119a) != null) {
            textView.setTypeface(typeface);
        }
        if (aVar != null && (f = aVar.f8120b) != null) {
            textView.setTextSize(f.floatValue());
        }
        if (qVar.f5597b.length() > 0) {
            lVar.itemView.setOnClickListener(new b0(24, context, qVar));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558672, viewGroup, false);
        s6.getClass();
        return new l(s6, this.f8541d);
    }
}
