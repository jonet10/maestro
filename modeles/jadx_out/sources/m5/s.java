package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s extends f {

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f7555b;

    /* renamed from: l, reason: collision with root package name */
    public final Context f7556l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f7557m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7558n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7559o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(View view, w4.b bVar, Context context) {
        super(view);
        context.getClass();
        this.f7555b = bVar;
        this.f7556l = context;
        View findViewById = view.findViewById(2131362379);
        findViewById.getClass();
        this.f7557m = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364043);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7558n = textView;
        View findViewById3 = view.findViewById(2131364305);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7559o = textView2;
        View findViewById4 = view.findViewById(2131363621);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        View findViewById5 = view.findViewById(2131363146);
        findViewById5.getClass();
        final int i = 0;
        ((RelativeLayout) findViewById5).setOnClickListener(new View.OnClickListener(this) { // from class: m5.r

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f7548b;

            {
                this.f7548b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i) {
                    case 0:
                        s sVar = this.f7548b;
                        w4.b bVar2 = sVar.f7555b;
                        if (bVar2 != null && (bindingAdapterPosition = sVar.getBindingAdapterPosition()) != -1) {
                            bVar2.b(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        s sVar2 = this.f7548b;
                        w4.b bVar3 = sVar2.f7555b;
                        if (bVar3 != null) {
                            bVar3.b(sVar2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i6 = 1;
        textView3.setOnClickListener(new View.OnClickListener(this) { // from class: m5.r

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ s f7548b;

            {
                this.f7548b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i6) {
                    case 0:
                        s sVar = this.f7548b;
                        w4.b bVar2 = sVar.f7555b;
                        if (bVar2 != null && (bindingAdapterPosition = sVar.getBindingAdapterPosition()) != -1) {
                            bVar2.b(bindingAdapterPosition);
                            break;
                        }
                        break;
                    default:
                        s sVar2 = this.f7548b;
                        w4.b bVar3 = sVar2.f7555b;
                        if (bVar3 != null) {
                            bVar3.b(sVar2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
    }
}
