package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.RecyclerView;
import c4.a6;
import c4.b6;
import com.uptodown.activities.NotificationsRegistryActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f7412a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7413b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7414l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7415m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7416n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7417o;

    /* renamed from: p, reason: collision with root package name */
    public final Context f7418p;

    public h0(View view, a3.d dVar) {
        super(view);
        this.f7412a = dVar;
        View findViewById = view.findViewById(2131364363);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7413b = textView;
        View findViewById2 = view.findViewById(2131364010);
        findViewById2.getClass();
        TextView textView2 = (TextView) findViewById2;
        this.f7414l = textView2;
        View findViewById3 = view.findViewById(2131363613);
        findViewById3.getClass();
        TextView textView3 = (TextView) findViewById3;
        this.f7415m = textView3;
        View findViewById4 = view.findViewById(2131363614);
        findViewById4.getClass();
        TextView textView4 = (TextView) findViewById4;
        this.f7416n = textView4;
        View findViewById5 = view.findViewById(2131363741);
        findViewById5.getClass();
        TextView textView5 = (TextView) findViewById5;
        this.f7417o = textView5;
        View findViewById6 = view.findViewById(2131362340);
        findViewById6.getClass();
        Context context = view.getContext();
        context.getClass();
        this.f7418p = context;
        final int i = 0;
        textView3.setOnClickListener(new View.OnClickListener(this) { // from class: m5.g0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f7397b;

            {
                this.f7397b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                e4.q qVar;
                int i6 = i;
                h0 h0Var = this.f7397b;
                switch (i6) {
                    case 0:
                        a3.d dVar2 = h0Var.f7412a;
                        if (dVar2 != null && (bindingAdapterPosition = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar2.f63b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        a3.d dVar3 = h0Var.f7412a;
                        if (dVar3 != null && (bindingAdapterPosition2 = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar3.f63b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        a3.d dVar4 = h0Var.f7412a;
                        if (dVar4 != null && (bindingAdapterPosition3 = h0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) dVar4.f63b).R) != null && qVar.f4657a.size() > bindingAdapterPosition3) {
                            b6 B0 = notificationsRegistryActivity.B0();
                            e4.q qVar2 = notificationsRegistryActivity.R;
                            qVar2.getClass();
                            int i10 = ((x4.s1) qVar2.f4657a.get(bindingAdapterPosition3)).f11384a;
                            B0.getClass();
                            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(viewModelScope, v7.d.f10884a, null, new a6(notificationsRegistryActivity, i10, (t6.c) null), 2);
                            e4.q qVar3 = notificationsRegistryActivity.R;
                            qVar3.getClass();
                            qVar3.f4657a.remove(bindingAdapterPosition3);
                            e4.q qVar4 = notificationsRegistryActivity.R;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i6 = 1;
        textView4.setOnClickListener(new View.OnClickListener(this) { // from class: m5.g0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f7397b;

            {
                this.f7397b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                e4.q qVar;
                int i62 = i6;
                h0 h0Var = this.f7397b;
                switch (i62) {
                    case 0:
                        a3.d dVar2 = h0Var.f7412a;
                        if (dVar2 != null && (bindingAdapterPosition = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar2.f63b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        a3.d dVar3 = h0Var.f7412a;
                        if (dVar3 != null && (bindingAdapterPosition2 = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar3.f63b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        a3.d dVar4 = h0Var.f7412a;
                        if (dVar4 != null && (bindingAdapterPosition3 = h0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) dVar4.f63b).R) != null && qVar.f4657a.size() > bindingAdapterPosition3) {
                            b6 B0 = notificationsRegistryActivity.B0();
                            e4.q qVar2 = notificationsRegistryActivity.R;
                            qVar2.getClass();
                            int i10 = ((x4.s1) qVar2.f4657a.get(bindingAdapterPosition3)).f11384a;
                            B0.getClass();
                            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(viewModelScope, v7.d.f10884a, null, new a6(notificationsRegistryActivity, i10, (t6.c) null), 2);
                            e4.q qVar3 = notificationsRegistryActivity.R;
                            qVar3.getClass();
                            qVar3.f4657a.remove(bindingAdapterPosition3);
                            e4.q qVar4 = notificationsRegistryActivity.R;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 2;
        ((ImageView) findViewById6).setOnClickListener(new View.OnClickListener(this) { // from class: m5.g0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h0 f7397b;

            {
                this.f7397b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                int bindingAdapterPosition2;
                int bindingAdapterPosition3;
                NotificationsRegistryActivity notificationsRegistryActivity;
                e4.q qVar;
                int i62 = i10;
                h0 h0Var = this.f7397b;
                switch (i62) {
                    case 0:
                        a3.d dVar2 = h0Var.f7412a;
                        if (dVar2 != null && (bindingAdapterPosition = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar2.f63b, bindingAdapterPosition, 0);
                            break;
                        }
                        break;
                    case 1:
                        a3.d dVar3 = h0Var.f7412a;
                        if (dVar3 != null && (bindingAdapterPosition2 = h0Var.getBindingAdapterPosition()) != -1) {
                            NotificationsRegistryActivity.y0((NotificationsRegistryActivity) dVar3.f63b, bindingAdapterPosition2, 1);
                            break;
                        }
                        break;
                    default:
                        a3.d dVar4 = h0Var.f7412a;
                        if (dVar4 != null && (bindingAdapterPosition3 = h0Var.getBindingAdapterPosition()) != -1 && (qVar = (notificationsRegistryActivity = (NotificationsRegistryActivity) dVar4.f63b).R) != null && qVar.f4657a.size() > bindingAdapterPosition3) {
                            b6 B0 = notificationsRegistryActivity.B0();
                            e4.q qVar2 = notificationsRegistryActivity.R;
                            qVar2.getClass();
                            int i102 = ((x4.s1) qVar2.f4657a.get(bindingAdapterPosition3)).f11384a;
                            B0.getClass();
                            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                            v7.e eVar = o7.m0.f8288a;
                            o7.c0.s(viewModelScope, v7.d.f10884a, null, new a6(notificationsRegistryActivity, i102, (t6.c) null), 2);
                            e4.q qVar3 = notificationsRegistryActivity.R;
                            qVar3.getClass();
                            qVar3.f4657a.remove(bindingAdapterPosition3);
                            e4.q qVar4 = notificationsRegistryActivity.R;
                            qVar4.getClass();
                            qVar4.notifyItemRemoved(bindingAdapterPosition3);
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4882w);
        textView4.setTypeface(f4.c.f4882w);
    }

    public final String a(String str) {
        int hashCode = str.hashCode();
        Context context = this.f7418p;
        switch (hashCode) {
            case -1569440520:
                if (!str.equals("positive_apps")) {
                    return "";
                }
                String string = context.getString(2131952653);
                string.getClass();
                return string;
            case -1335458389:
                if (!str.equals("delete")) {
                    return "";
                }
                String string2 = context.getString(2131952426);
                string2.getClass();
                return string2;
            case -504325460:
                if (!str.equals("open_app")) {
                    return "";
                }
                String string3 = context.getString(2131952419);
                string3.getClass();
                return string3;
            case -234430262:
                if (!str.equals("updates")) {
                    return "";
                }
                String string4 = context.getString(2131952709);
                string4.getClass();
                return string4;
            case 212443764:
                str.equals("no_action");
                return "";
            case 1085191854:
                if (!str.equals("update_uptodown")) {
                    return "";
                }
                String string5 = context.getString(2131951657);
                string5.getClass();
                return string5;
            case 1117687366:
                if (!str.equals("preregister")) {
                    return "";
                }
                String string6 = context.getString(2131951651);
                string6.getClass();
                return string6;
            case 1312704747:
                if (!str.equals("downloads")) {
                    return "";
                }
                String string7 = context.getString(2131951976);
                string7.getClass();
                return string7;
            case 1957569947:
                if (!str.equals("install")) {
                    return "";
                }
                String string8 = context.getString(2131952428);
                string8.getClass();
                return string8;
            default:
                return "";
        }
    }
}
