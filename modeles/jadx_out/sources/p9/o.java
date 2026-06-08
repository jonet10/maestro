package p9;

import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import g4.b0;
import h9.r;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f8551a;

    /* renamed from: b, reason: collision with root package name */
    public final s5.c f8552b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f8553c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f8554d;

    /* renamed from: e, reason: collision with root package name */
    public final n9.a f8555e;

    public o(ArrayList arrayList, s5.c cVar, Integer num, Integer num2, n9.a aVar) {
        this.f8551a = arrayList;
        this.f8552b = cVar;
        this.f8553c = num;
        this.f8554d = num2;
        this.f8555e = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f8551a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Float f;
        Typeface typeface;
        n nVar = (n) viewHolder;
        nVar.getClass();
        r rVar = (r) this.f8551a.get(i);
        rVar.getClass();
        TextView textView = nVar.f8549q;
        textView.setText(rVar.f5599b);
        TextView textView2 = nVar.f8548p;
        textView2.setText(rVar.f5600c);
        Integer num = nVar.f8543b;
        if (num != null) {
            int intValue = num.intValue();
            textView.setTextColor(intValue);
            textView2.setTextColor(intValue);
            nVar.f8547o.setColorFilter(intValue);
        }
        Integer num2 = nVar.f8544l;
        if (num2 != null) {
            nVar.f8550r.setBackgroundColor(num2.intValue());
        }
        n9.a aVar = nVar.f8545m;
        int i6 = 0;
        TextView[] textViewArr = {textView, textView2};
        if (aVar != null && (typeface = aVar.f8119a) != null) {
            int i10 = 0;
            while (i10 < 2) {
                TextView textView3 = textViewArr[i10];
                i10++;
                if (textView3 != null) {
                    textView3.setTypeface(typeface);
                }
            }
        }
        if (aVar != null && (f = aVar.f8120b) != null) {
            float floatValue = f.floatValue();
            while (i6 < 2) {
                TextView textView4 = textViewArr[i6];
                i6++;
                if (textView4 != null) {
                    textView4.setTextSize(2, floatValue);
                }
            }
        }
        nVar.f8546n.setOnClickListener(new b0(25, nVar, rVar));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558666, viewGroup, false);
        s6.getClass();
        return new n(s6, this.f8552b, this.f8553c, this.f8554d, this.f8555e);
    }
}
