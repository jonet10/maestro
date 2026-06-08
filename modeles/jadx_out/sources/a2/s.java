package a2;

import a4.d0;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.room.RoomTrackingLiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.ListenableFutureKt;
import c4.pd;
import c4.z7;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import m5.o1;
import m5.p1;
import o7.e1;
import y2.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f50a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f51b;

    public /* synthetic */ s(Object obj, int i) {
        this.f50a = i;
        this.f51b = obj;
    }

    private final void a() {
        d0 d0Var = (d0) this.f51b;
        synchronized (((ArrayDeque) d0Var.f84n)) {
            SharedPreferences.Editor edit = ((SharedPreferences) d0Var.f81b).edit();
            String str = (String) d0Var.f82l;
            StringBuilder sb = new StringBuilder();
            Iterator it = ((ArrayDeque) d0Var.f84n).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append((String) d0Var.f83m);
            }
            edit.putString(str, sb.toString()).commit();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = 2;
        int i6 = 1;
        Map map = null;
        int i10 = 0;
        switch (this.f50a) {
            case 0:
                t tVar = (t) this.f51b;
                ((AtomicReference) tVar.f54c).set(null);
                synchronized (tVar) {
                    try {
                        if (((AtomicMarkableReference) tVar.f53b).isMarked()) {
                            map = ((e) ((AtomicMarkableReference) tVar.f53b).getReference()).a();
                            AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) tVar.f53b;
                            atomicMarkableReference.set((e) atomicMarkableReference.getReference(), false);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (map != null) {
                    e2.d dVar = (e2.d) tVar.f55d;
                    ((h) dVar.f4467l).h((String) dVar.f4466b, map, tVar.f52a);
                    return;
                }
                return;
            case 1:
                ((Carousel) this.f51b).lambda$updateItems$0();
                return;
            case 2:
                RoomTrackingLiveData.access$invalidated((RoomTrackingLiveData) this.f51b);
                return;
            case 3:
                ((SwipeRefreshLayout) this.f51b).lambda$onStopNestedScroll$0();
                return;
            case 4:
                ListenableFutureKt.launchFuture$lambda$1$lambda$0((e1) this.f51b);
                return;
            case 5:
                AppInstalledDetailsActivity appInstalledDetailsActivity = (AppInstalledDetailsActivity) this.f51b;
                int i11 = AppInstalledDetailsActivity.f3300e0;
                appInstalledDetailsActivity.R0().F.smoothScrollTo(0, appInstalledDetailsActivity.R0().f9747x.getTop());
                return;
            case 6:
                OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f51b;
                int i12 = OldVersionsActivity.S;
                oldVersionsActivity.y0().f9669l.scrollToPosition(0);
                return;
            case 7:
                RecommendedActivity recommendedActivity = (RecommendedActivity) this.f51b;
                int i13 = RecommendedActivity.f3338g0;
                String string = recommendedActivity.getString(2131952519);
                string.getClass();
                recommendedActivity.I(string, new z7(recommendedActivity, i), new z7(recommendedActivity, i10));
                return;
            case 8:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f51b;
                int i14 = WishlistActivity.f3367g0;
                String string2 = wishlistActivity.getString(2131952808);
                string2.getClass();
                wishlistActivity.I(string2, new pd(wishlistActivity, i6), new pd(wishlistActivity, i));
                return;
            case 9:
                ((MaterialButton) this.f51b).lambda$setOpticalCenterEnabled$1();
                return;
            case 10:
                ((CarouselLayoutManager) this.f51b).refreshKeylineState();
                return;
            case 11:
                ((MaterialBackOrchestrator) this.f51b).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            case 12:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f51b;
                HorizontalScrollView horizontalScrollView = fileExplorerActivity.J;
                if (horizontalScrollView == null) {
                    kotlin.jvm.internal.l.i("svBreadcrumb");
                    throw null;
                }
                LinearLayout linearLayout = fileExplorerActivity.I;
                if (linearLayout == null) {
                    kotlin.jvm.internal.l.i("llBreadcrumb");
                    throw null;
                }
                int right = linearLayout.getRight();
                LinearLayout linearLayout2 = fileExplorerActivity.I;
                if (linearLayout2 != null) {
                    horizontalScrollView.scrollTo(right, linearLayout2.getTop());
                    return;
                } else {
                    kotlin.jvm.internal.l.i("llBreadcrumb");
                    throw null;
                }
            case 13:
                ((TvMyAppsFragment) this.f51b).startEntranceTransition();
                return;
            case 14:
                ((TvOldVersionsFragment) this.f51b).startEntranceTransition();
                return;
            case 15:
                ((p1) this.f51b).B = o1.f7496l;
                return;
            case 16:
                ((AppCompatTextView) this.f51b).setSelected(true);
                return;
            case 17:
                y2.s sVar = (y2.s) this.f51b;
                ((y.h) ((z.c) sVar.f11758n)).h(new v4.a(sVar, 4));
                return;
            case 18:
                a();
                return;
            default:
                c0 c0Var = (c0) this.f51b;
                Log.w("FirebaseMessaging", "Service took too long to process intent: " + c0Var.f11715a.getAction() + " finishing.");
                c0Var.f11716b.c(null);
                return;
        }
    }
}
