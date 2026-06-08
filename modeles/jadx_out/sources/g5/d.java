package g5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.leanback.app.BackgroundManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import java.util.ArrayList;
import x4.l2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5302a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f5303b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(TvAppDetailFragment tvAppDetailFragment, t6.c cVar, int i) {
        super(2, cVar);
        this.f5302a = i;
        this.f5303b = tvAppDetailFragment;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5302a) {
            case 0:
                return new d(this.f5303b, cVar, 0);
            case 1:
                return new d(this.f5303b, cVar, 1);
            default:
                return new d(this.f5303b, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5302a) {
            case 0:
                d dVar = (d) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                dVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                return ((d) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
            default:
                d dVar2 = (d) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                dVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5302a;
        p6.x xVar = p6.x.f8463a;
        TvAppDetailFragment tvAppDetailFragment = this.f5303b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                if (tvAppDetailFragment.getContext() != null) {
                    e5.b bVar = tvAppDetailFragment.f3423t;
                    bVar.getClass();
                    Context requireContext = tvAppDetailFragment.requireContext();
                    requireContext.getClass();
                    x4.g gVar = tvAppDetailFragment.f3413a;
                    i5.b bVar2 = bVar.f4734b;
                    if (bVar2 != null) {
                        LinearLayout linearLayout = bVar2.f5668q;
                        if ((gVar != null ? gVar.X : null) != null && linearLayout != null) {
                            if (linearLayout.getChildCount() > 0) {
                                linearLayout.removeAllViews();
                            }
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                            layoutParams.setMargins(12, 12, 12, 12);
                            ArrayList arrayList = gVar.X;
                            arrayList.getClass();
                            int size = arrayList.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                h5.a aVar = new h5.a(requireContext);
                                a4.g0 d10 = a4.g0.d();
                                ArrayList arrayList2 = gVar.X;
                                arrayList2.getClass();
                                d10.e(((l2) arrayList2.get(i6)).a()).e(aVar, null);
                                aVar.setPadding(4, 4, 4, 4);
                                aVar.setLayoutParams(layoutParams);
                                aVar.setFocusable(true);
                                aVar.setTag(Integer.valueOf(i6));
                                aVar.setOnClickListener(new c4.d(gVar, 21));
                                aVar.setOnFocusChangeListener(new i5.a());
                                linearLayout.addView(aVar);
                            }
                        }
                    }
                }
                tvAppDetailFragment.u();
                return xVar;
            case 1:
                p6.a.e(obj);
                try {
                    x4.g gVar2 = tvAppDetailFragment.f3413a;
                    if ((gVar2 != null ? gVar2.e() : null) != null) {
                        BackgroundManager backgroundManager = tvAppDetailFragment.f3417n;
                        if (backgroundManager == null) {
                            return null;
                        }
                        a4.g0 d11 = a4.g0.d();
                        x4.g gVar3 = tvAppDetailFragment.f3413a;
                        gVar3.getClass();
                        backgroundManager.setBitmap(d11.e(gVar3.e()).c());
                    } else {
                        Drawable drawable = ContextCompat.getDrawable(tvAppDetailFragment.requireContext(), 2131230977);
                        BackgroundManager backgroundManager2 = tvAppDetailFragment.f3417n;
                        if (backgroundManager2 == null) {
                            return null;
                        }
                        backgroundManager2.setDrawable(drawable);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                return xVar;
            default:
                p6.a.e(obj);
                tvAppDetailFragment.startEntranceTransition();
                return xVar;
        }
    }
}
