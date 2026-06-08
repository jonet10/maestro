package c4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p9 extends ArrayAdapter implements Filterable {

    /* renamed from: a, reason: collision with root package name */
    public final LayoutInflater f1991a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f1992b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p9(SearchActivity searchActivity, SearchActivity searchActivity2) {
        super(searchActivity2, -1);
        this.f1992b = searchActivity;
        LayoutInflater from = LayoutInflater.from(searchActivity2);
        from.getClass();
        this.f1991a = from;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public final Filter getFilter() {
        return new o9(this.f1992b, this);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout linearLayout;
        viewGroup.getClass();
        x4.z1 z1Var = (x4.z1) getItem(i);
        LayoutInflater layoutInflater = this.f1991a;
        if (z1Var == null) {
            View inflate = layoutInflater.inflate(2131558798, viewGroup, false);
            inflate.getClass();
            return (LinearLayout) inflate;
        }
        if (view != null) {
            linearLayout = (LinearLayout) view;
        } else {
            View inflate2 = layoutInflater.inflate(2131558798, viewGroup, false);
            inflate2.getClass();
            linearLayout = (LinearLayout) inflate2;
        }
        TextView textView = (TextView) linearLayout.findViewById(2131364207);
        ImageView imageView = (ImageView) linearLayout.findViewById(2131362341);
        imageView.setTag(z1Var.f11479a);
        imageView.setOnClickListener(new m9(this.f1992b, 5));
        textView.setTypeface(f4.c.f4883x);
        textView.setText(z1Var.f11479a);
        return linearLayout;
    }
}
