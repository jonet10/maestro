package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import c4.wd;
import j0.p;
import java.util.ArrayList;
import k9.b;
import u3.a;
import z3.c;
import z3.d;
import z3.f;
import z3.g;
import z3.h;
import z3.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class YouTubePlayerView extends d implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3284a;

    /* renamed from: b, reason: collision with root package name */
    public final c f3285b;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3286l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.f3284a = new ArrayList();
        c cVar = new c(context, new wd(this, 1));
        this.f3285b = cVar;
        addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.f10412a, 0, 0);
        obtainStyledAttributes.getClass();
        this.f3286l = obtainStyledAttributes.getBoolean(1, true);
        boolean z9 = obtainStyledAttributes.getBoolean(0, false);
        boolean z10 = obtainStyledAttributes.getBoolean(2, true);
        String string = obtainStyledAttributes.getString(3);
        obtainStyledAttributes.recycle();
        if (z9 && string == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("YouTubePlayerView: videoId is not set but autoPlay is set to true. This combination is not allowed.");
            throw null;
        }
        i iVar = new i(string, this, z9);
        if (this.f3286l) {
            k9.c cVar2 = new k9.c(context);
            cVar2.d(1, "controls");
            cVar.a(iVar, z10, new b(cVar2.f7009b), string);
        }
    }

    public final void a(w3.a aVar, b bVar) {
        if (this.f3286l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("YouTubePlayerView: If you want to initialize this view manually, you need to set 'enableAutomaticInitialization' to false.");
            return;
        }
        c cVar = this.f3285b;
        cVar.getClass();
        cVar.a(aVar, true, bVar, null);
    }

    public final void b() {
        c cVar = this.f3285b;
        f fVar = cVar.f11932a;
        y3.d dVar = cVar.f11933b;
        Context context = dVar.f11797a;
        if (Build.VERSION.SDK_INT >= 24) {
            y3.c cVar2 = dVar.f11800d;
            if (cVar2 != null) {
                Object systemService = context.getSystemService("connectivity");
                systemService.getClass();
                ((ConnectivityManager) systemService).unregisterNetworkCallback(cVar2);
                dVar.f11798b.clear();
                dVar.f11800d = null;
                dVar.f11799c = null;
            }
        } else {
            p pVar = dVar.f11799c;
            if (pVar != null) {
                try {
                    context.unregisterReceiver(pVar);
                } catch (Throwable unused) {
                }
                dVar.f11798b.clear();
                dVar.f11800d = null;
                dVar.f11799c = null;
            }
        }
        cVar.removeView(fVar);
        fVar.removeAllViews();
        fVar.destroy();
    }

    public final boolean getEnableAutomaticInitialization() {
        return this.f3286l;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        lifecycleOwner.getClass();
        event.getClass();
        int i = h.f11950a[event.ordinal()];
        c cVar = this.f3285b;
        switch (i) {
            case 1:
                cVar.f11934l.f11801a = true;
                cVar.f11938p = true;
                break;
            case 2:
                ((g) cVar.f11932a.getYoutubePlayer$core_release()).e();
                cVar.f11934l.f11801a = false;
                cVar.f11938p = false;
                break;
            case 3:
                b();
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                break;
            default:
                com.google.gson.internal.a.b();
                break;
        }
    }

    public final void setCustomPlayerUi(View view) {
        view.getClass();
        this.f3285b.setCustomPlayerUi(view);
    }

    public final void setEnableAutomaticInitialization(boolean z9) {
        this.f3286l = z9;
    }

    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, int i6, kotlin.jvm.internal.g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context) {
        this(context, null, 0);
        context.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YouTubePlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        context.getClass();
    }

    public /* synthetic */ YouTubePlayerView(Context context, AttributeSet attributeSet, int i, kotlin.jvm.internal.g gVar) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
