package l6;

import android.R;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b2.t1;
import c.h;
import c.i;
import c.j;
import h8.e;
import h8.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.l;
import s5.d;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends p9.a implements c.b {
    public static final /* synthetic */ int I = 0;
    public Button A;
    public RecyclerView B;
    public TextView C;
    public ConstraintLayout D;
    public int E;
    public h F;
    public c G;
    public d H;

    /* renamed from: z, reason: collision with root package name */
    public Button f7147z;

    public final ColorStateList a() {
        h9.d dVar = this.f8502s;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f5505p;
        Integer num2 = dVar.f5504o;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void b(LinkedHashSet linkedHashSet) {
        boolean z9;
        Button button = this.A;
        boolean z10 = false;
        if (button != null) {
            if (!linkedHashSet.isEmpty()) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    if (((Boolean) it.next()).booleanValue()) {
                        z9 = true;
                        break;
                    }
                }
            }
            z9 = false;
            button.setEnabled(z9);
        }
        Button button2 = this.f7147z;
        if (button2 == null) {
            return;
        }
        if (!linkedHashSet.isEmpty()) {
            Iterator it2 = linkedHashSet.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (!((Boolean) it2.next()).booleanValue()) {
                    z10 = true;
                    break;
                }
            }
        }
        button2.setEnabled(z10);
    }

    public final ColorStateList c() {
        h9.d dVar = this.f8502s;
        if (dVar == null) {
            return null;
        }
        Integer num = dVar.f5503n;
        Integer num2 = dVar.f5502m;
        if (num2 == null || num == null) {
            return null;
        }
        return new ColorStateList(new int[][]{new int[]{R.attr.state_enabled}, new int[]{-16842910}}, new int[]{num2.intValue(), num.intValue()});
    }

    public final void d() {
        h hVar = this.F;
        if (hVar == null) {
            l.i("switchAdapter");
            throw null;
        }
        c cVar = this.G;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        int i = this.E;
        ArrayList c9 = cVar.c(i);
        c9.addAll(cVar.d(i));
        hVar.f1155a = c9;
        hVar.notifyDataSetChanged();
        c cVar2 = this.G;
        if (cVar2 != null) {
            b(cVar2.b(this.E));
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b
    public final void e(i iVar) {
        h8.d dVar = iVar.f1160a;
        FragmentActivity activity = getActivity();
        if (activity != null && (dVar instanceof e) && activity.getSupportFragmentManager().findFragmentByTag("k") == null) {
            FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
            String str = dVar.f5466b;
            e eVar = (e) dVar;
            String a8 = eVar.a();
            String b7 = eVar.b();
            c cVar = this.G;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            String str2 = cVar.a().f5602b;
            c cVar2 = this.G;
            if (cVar2 != null) {
                beginTransaction.add(d0.b.f(str, a8, b7, str2, cVar2.a().f5605e, dVar.f5465a, iVar.f1163d, false, 1), "k").commit();
            } else {
                l.i("viewModel");
                throw null;
            }
        }
    }

    @Override // c.b
    public final void f(i iVar) {
        h8.d dVar = iVar.f1160a;
        c cVar = this.G;
        if (cVar == null) {
            l.i("viewModel");
            throw null;
        }
        m mVar = cVar.f7148a;
        int c9 = j.c(iVar.f1163d);
        if (c9 != 4) {
            if (c9 == 7) {
                if (l.a(iVar.f1161b, Boolean.TRUE)) {
                    mVar.f10748q.set(dVar.f5465a);
                } else {
                    mVar.f10748q.unset(dVar.f5465a);
                }
            }
        } else if (l.a(iVar.f1161b, Boolean.TRUE)) {
            mVar.f10749r.set(dVar.f5465a);
        } else {
            mVar.f10749r.unset(dVar.f5465a);
        }
        c cVar2 = this.G;
        if (cVar2 != null) {
            b(cVar2.b(this.E));
        } else {
            l.i("viewModel");
            throw null;
        }
    }

    @Override // p9.a, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        ViewModelStore viewModelStore = getViewModelStore();
        viewModelStore.getClass();
        this.G = (c) new ViewModelProvider(viewModelStore, new b6.i(2)).get(c.class);
        ViewModelStore viewModelStore2 = activity.getViewModelStore();
        viewModelStore2.getClass();
        this.H = (d) new ViewModelProvider(viewModelStore2, new b6.i(6)).get(d.class);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(2131558533, viewGroup, false);
        inflate.getClass();
        return inflate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface.getClass();
        super.onDismiss(dialogInterface);
        d dVar = this.H;
        if (dVar != null) {
            dVar.f9343o.postValue(Boolean.TRUE);
        } else {
            l.i("optionsViewModel");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getClass();
        if (menuItem.getItemId() == 16908332) {
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // p9.a, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        Map map;
        g gVar;
        view.getClass();
        super.onViewCreated(view, bundle);
        this.f7147z = (Button) view.findViewById(2131361980);
        this.A = (Button) view.findViewById(2131361984);
        this.B = (RecyclerView) view.findViewById(2131363354);
        this.C = (TextView) view.findViewById(2131364325);
        this.D = (ConstraintLayout) view.findViewById(2131363455);
        Bundle arguments = getArguments();
        final int i = 0;
        int i6 = arguments == null ? 0 : arguments.getInt("stack_id");
        this.E = i6;
        TextView textView = this.C;
        if (textView != null) {
            c cVar = this.G;
            if (cVar == null) {
                l.i("viewModel");
                throw null;
            }
            h8.c cVar2 = cVar.f7148a.f10737a;
            textView.setText((cVar2 == null || (map = cVar2.i) == null || (gVar = (g) map.get(String.valueOf(i6))) == null) ? null : gVar.f5466b);
        }
        TextView textView2 = this.f8494b;
        if (textView2 != null) {
            c cVar3 = this.G;
            if (cVar3 == null) {
                l.i("viewModel");
                throw null;
            }
            textView2.setText(cVar3.a().f5601a);
        }
        ImageView imageView = this.f8495l;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: l6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f7146b;

                {
                    this.f7146b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i10 = i;
                    int i11 = 0;
                    b bVar = this.f7146b;
                    switch (i10) {
                        case 0:
                            bVar.dismiss();
                            return;
                        case 1:
                            c cVar4 = bVar.G;
                            if (cVar4 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = cVar4.f7148a;
                            int i12 = bVar.E;
                            ArrayList c9 = cVar4.c(i12);
                            int size = c9.size();
                            int i13 = 0;
                            while (i13 < size) {
                                Object obj = c9.get(i13);
                                i13++;
                                mVar.f10749r.unset(((i) obj).f1160a.f5465a);
                            }
                            ArrayList d10 = cVar4.d(i12);
                            int size2 = d10.size();
                            while (i11 < size2) {
                                Object obj2 = d10.get(i11);
                                i11++;
                                mVar.f10748q.unset(((i) obj2).f1160a.f5465a);
                            }
                            bVar.d();
                            return;
                        default:
                            c cVar5 = bVar.G;
                            if (cVar5 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = cVar5.f7148a;
                            int i14 = bVar.E;
                            ArrayList c10 = cVar5.c(i14);
                            int size3 = c10.size();
                            int i15 = 0;
                            while (i15 < size3) {
                                Object obj3 = c10.get(i15);
                                i15++;
                                mVar2.f10749r.set(((i) obj3).f1160a.f5465a);
                            }
                            ArrayList d11 = cVar5.d(i14);
                            int size4 = d11.size();
                            while (i11 < size4) {
                                Object obj4 = d11.get(i11);
                                i11++;
                                mVar2.f10748q.set(((i) obj4).f1160a.f5465a);
                            }
                            bVar.d();
                            return;
                    }
                }
            });
            c cVar4 = this.G;
            if (cVar4 == null) {
                l.i("viewModel");
                throw null;
            }
            imageView.setContentDescription(cVar4.a().f);
        }
        h9.d dVar = this.f8502s;
        if (dVar != null) {
            Integer num = dVar.g;
            if (num != null) {
                int intValue = num.intValue();
                ConstraintLayout constraintLayout = this.D;
                if (constraintLayout != null) {
                    constraintLayout.setBackgroundColor(intValue);
                }
            }
            Integer num2 = dVar.i;
            if (num2 != null) {
                int intValue2 = num2.intValue();
                TextView textView3 = this.C;
                if (textView3 != null) {
                    textView3.setTextColor(intValue2);
                }
            }
            Button button = this.f7147z;
            if (button != null) {
                ColorStateList c9 = c();
                if (c9 != null) {
                    button.setTextColor(c9);
                }
                ColorStateList a8 = a();
                if (a8 != null) {
                    button.setBackgroundTintList(a8);
                }
            }
            Button button2 = this.A;
            if (button2 != null) {
                ColorStateList c10 = c();
                if (c10 != null) {
                    button2.setTextColor(c10);
                }
                ColorStateList a10 = a();
                if (a10 != null) {
                    button2.setBackgroundTintList(a10);
                }
            }
        }
        final int i10 = 2;
        final int i11 = 1;
        t1.f(this.f8504u, this.f7147z, this.A);
        t1.f(this.f8503t, this.C);
        c cVar5 = this.G;
        if (cVar5 == null) {
            l.i("viewModel");
            throw null;
        }
        int i12 = this.E;
        ArrayList c11 = cVar5.c(i12);
        c11.addAll(cVar5.d(i12));
        h9.d dVar2 = this.f8502s;
        this.F = new h(c11, this, (String) null, dVar2 == null ? null : dVar2.i, dVar2 == null ? null : dVar2.f5499e, dVar2 == null ? null : dVar2.f, dVar2 == null ? null : dVar2.f5495a, this.f8503t, this.v, 12);
        RecyclerView recyclerView = this.B;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            h hVar = this.F;
            if (hVar == null) {
                l.i("switchAdapter");
                throw null;
            }
            recyclerView.setAdapter(hVar);
        }
        Button button3 = this.A;
        if (button3 != null) {
            button3.setText(getString(2131951955));
        }
        c cVar6 = this.G;
        if (cVar6 == null) {
            l.i("viewModel");
            throw null;
        }
        b(cVar6.b(this.E));
        Button button4 = this.A;
        if (button4 != null) {
            button4.setOnClickListener(new View.OnClickListener(this) { // from class: l6.a

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f7146b;

                {
                    this.f7146b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    int i102 = i11;
                    int i112 = 0;
                    b bVar = this.f7146b;
                    switch (i102) {
                        case 0:
                            bVar.dismiss();
                            return;
                        case 1:
                            c cVar42 = bVar.G;
                            if (cVar42 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar = cVar42.f7148a;
                            int i122 = bVar.E;
                            ArrayList c92 = cVar42.c(i122);
                            int size = c92.size();
                            int i13 = 0;
                            while (i13 < size) {
                                Object obj = c92.get(i13);
                                i13++;
                                mVar.f10749r.unset(((i) obj).f1160a.f5465a);
                            }
                            ArrayList d10 = cVar42.d(i122);
                            int size2 = d10.size();
                            while (i112 < size2) {
                                Object obj2 = d10.get(i112);
                                i112++;
                                mVar.f10748q.unset(((i) obj2).f1160a.f5465a);
                            }
                            bVar.d();
                            return;
                        default:
                            c cVar52 = bVar.G;
                            if (cVar52 == null) {
                                l.i("viewModel");
                                throw null;
                            }
                            m mVar2 = cVar52.f7148a;
                            int i14 = bVar.E;
                            ArrayList c102 = cVar52.c(i14);
                            int size3 = c102.size();
                            int i15 = 0;
                            while (i15 < size3) {
                                Object obj3 = c102.get(i15);
                                i15++;
                                mVar2.f10749r.set(((i) obj3).f1160a.f5465a);
                            }
                            ArrayList d11 = cVar52.d(i14);
                            int size4 = d11.size();
                            while (i112 < size4) {
                                Object obj4 = d11.get(i112);
                                i112++;
                                mVar2.f10748q.set(((i) obj4).f1160a.f5465a);
                            }
                            bVar.d();
                            return;
                    }
                }
            });
        }
        Button button5 = this.f7147z;
        if (button5 != null) {
            c cVar7 = this.G;
            if (cVar7 == null) {
                l.i("viewModel");
                throw null;
            }
            button5.setText(cVar7.a().f5603c);
        }
        Button button6 = this.f7147z;
        if (button6 == null) {
            return;
        }
        button6.setOnClickListener(new View.OnClickListener(this) { // from class: l6.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f7146b;

            {
                this.f7146b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i102 = i10;
                int i112 = 0;
                b bVar = this.f7146b;
                switch (i102) {
                    case 0:
                        bVar.dismiss();
                        return;
                    case 1:
                        c cVar42 = bVar.G;
                        if (cVar42 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        m mVar = cVar42.f7148a;
                        int i122 = bVar.E;
                        ArrayList c92 = cVar42.c(i122);
                        int size = c92.size();
                        int i13 = 0;
                        while (i13 < size) {
                            Object obj = c92.get(i13);
                            i13++;
                            mVar.f10749r.unset(((i) obj).f1160a.f5465a);
                        }
                        ArrayList d10 = cVar42.d(i122);
                        int size2 = d10.size();
                        while (i112 < size2) {
                            Object obj2 = d10.get(i112);
                            i112++;
                            mVar.f10748q.unset(((i) obj2).f1160a.f5465a);
                        }
                        bVar.d();
                        return;
                    default:
                        c cVar52 = bVar.G;
                        if (cVar52 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        m mVar2 = cVar52.f7148a;
                        int i14 = bVar.E;
                        ArrayList c102 = cVar52.c(i14);
                        int size3 = c102.size();
                        int i15 = 0;
                        while (i15 < size3) {
                            Object obj3 = c102.get(i15);
                            i15++;
                            mVar2.f10749r.set(((i) obj3).f1160a.f5465a);
                        }
                        ArrayList d11 = cVar52.d(i14);
                        int size4 = d11.size();
                        while (i112 < size4) {
                            Object obj4 = d11.get(i112);
                            i112++;
                            mVar2.f10748q.set(((i) obj4).f1160a.f5465a);
                        }
                        bVar.d();
                        return;
                }
            }
        });
    }
}
