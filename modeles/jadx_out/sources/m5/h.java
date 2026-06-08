package m5;

import android.view.View;
import c4.t5;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import java.util.Arrays;
import x4.a3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class h implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7410a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f7411b;

    public /* synthetic */ h(f fVar, int i) {
        this.f7410a = i;
        this.f7411b = fVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int bindingAdapterPosition;
        MyDownloads myDownloads;
        e4.b bVar;
        boolean z9;
        int bindingAdapterPosition2;
        e4.e1 e1Var;
        e4.e1 e1Var2;
        int i = this.f7410a;
        f fVar = this.f7411b;
        int i6 = 1;
        switch (i) {
            case 0:
                i iVar = (i) fVar;
                f0.i iVar2 = iVar.f7419b;
                if (iVar2 != null && (bindingAdapterPosition = iVar.getBindingAdapterPosition()) != -1 && (bVar = (myDownloads = (MyDownloads) iVar2.f4811b).Q) != null && !(z9 = bVar.f4486c)) {
                    bVar.c(!z9);
                    e4.b bVar2 = myDownloads.Q;
                    bVar2.getClass();
                    bVar2.b(bindingAdapterPosition);
                    myDownloads.E0();
                    myDownloads.S = true;
                    myDownloads.A0().f10241n.smoothScrollToPosition(bindingAdapterPosition);
                }
                return false;
            default:
                y1 y1Var = (y1) fVar;
                f0.i iVar3 = y1Var.f7644m;
                if (iVar3 != null && (bindingAdapterPosition2 = y1Var.getBindingAdapterPosition()) != -1) {
                    view.getClass();
                    switch (iVar3.f4810a) {
                        case 11:
                            break;
                        case 12:
                            RecommendedActivity recommendedActivity = (RecommendedActivity) iVar3.f4811b;
                            float f = UptodownApp.I;
                            if (b4.d.t() && (e1Var = recommendedActivity.f3340c0) != null && !e1Var.f4519a.isEmpty()) {
                                e4.e1 e1Var3 = recommendedActivity.f3340c0;
                                e1Var3.getClass();
                                Object obj = e1Var3.f4519a.get(bindingAdapterPosition2);
                                obj.getClass();
                                a3 a3Var = (a3) obj;
                                String string = recommendedActivity.getString(2131951940, a3Var.f11047b);
                                string.getClass();
                                recommendedActivity.H(string, new t5(bindingAdapterPosition2, recommendedActivity, i6, a3Var));
                                break;
                            }
                            break;
                        default:
                            WishlistActivity wishlistActivity = (WishlistActivity) iVar3.f4811b;
                            float f10 = UptodownApp.I;
                            if (b4.d.t() && (e1Var2 = wishlistActivity.f3369c0) != null && !e1Var2.f4519a.isEmpty()) {
                                e4.e1 e1Var4 = wishlistActivity.f3369c0;
                                e1Var4.getClass();
                                Object obj2 = e1Var4.f4519a.get(bindingAdapterPosition2);
                                obj2.getClass();
                                a3 a3Var2 = (a3) obj2;
                                String string2 = wishlistActivity.getString(2131951946);
                                string2.getClass();
                                wishlistActivity.H(String.format(string2, Arrays.copyOf(new Object[]{a3Var2.f11047b}, 1)), new t5(bindingAdapterPosition2, wishlistActivity, 2, a3Var2));
                                break;
                            }
                            break;
                    }
                }
                return true;
        }
    }
}
