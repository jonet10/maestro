package androidx.core.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewKt {
    public static final void doOnAttach(final View view, final d7.l lVar) {
        if (view.isAttachedToWindow()) {
            lVar.invoke(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static final void doOnDetach(final View view, final d7.l lVar) {
        if (view.isAttachedToWindow()) {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.core.view.ViewKt$doOnDetach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                    view.removeOnAttachStateChangeListener(this);
                    lVar.invoke(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnLayout(View view, final d7.l lVar) {
        if (!view.isLaidOut() || view.isLayoutRequested()) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnLayout$$inlined$doOnNextLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view2, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
                    view2.removeOnLayoutChangeListener(this);
                    d7.l.this.invoke(view2);
                }
            });
        } else {
            lVar.invoke(view);
        }
    }

    public static final void doOnNextLayout(View view, final d7.l lVar) {
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: androidx.core.view.ViewKt$doOnNextLayout$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view2, int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
                view2.removeOnLayoutChangeListener(this);
                d7.l.this.invoke(view2);
            }
        });
    }

    public static final OneShotPreDrawListener doOnPreDraw(final View view, final d7.l lVar) {
        return OneShotPreDrawListener.add(view, new Runnable() { // from class: androidx.core.view.ViewKt$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                d7.l.this.invoke(view);
            }
        });
    }

    public static final Bitmap drawToBitmap(View view, Bitmap.Config config) {
        if (!view.isLaidOut()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("View needs to be laid out before calling drawToBitmap()");
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), config);
        Canvas canvas = new Canvas(createBitmap);
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap drawToBitmap$default(View view, Bitmap.Config config, int i, Object obj) {
        if ((i & 1) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return drawToBitmap(view, config);
    }

    public static final k7.f getAllViews(View view) {
        return new a7.e(new ViewKt$allViews$1(view, null), 1);
    }

    public static final k7.f getAncestors(View view) {
        return k7.i.h0(ViewKt$ancestors$1.INSTANCE, view.getParent());
    }

    public static final int getMarginBottom(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.bottomMargin;
        }
        return 0;
    }

    public static final int getMarginEnd(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginEnd();
        }
        return 0;
    }

    public static final int getMarginLeft(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.leftMargin;
        }
        return 0;
    }

    public static final int getMarginRight(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.rightMargin;
        }
        return 0;
    }

    public static final int getMarginStart(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).getMarginStart();
        }
        return 0;
    }

    public static final int getMarginTop(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.topMargin;
        }
        return 0;
    }

    public static final boolean isGone(View view) {
        return view.getVisibility() == 8;
    }

    public static final boolean isInvisible(View view) {
        return view.getVisibility() == 4;
    }

    public static final boolean isVisible(View view) {
        return view.getVisibility() == 0;
    }

    public static final Runnable postDelayed(View view, long j, final d7.a aVar) {
        Runnable runnable = new Runnable() { // from class: androidx.core.view.ViewKt$postDelayed$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                d7.a.this.invoke();
            }
        };
        view.postDelayed(runnable, j);
        return runnable;
    }

    public static final Runnable postOnAnimationDelayed(View view, long j, d7.a aVar) {
        h hVar = new h(aVar, 1);
        view.postOnAnimationDelayed(hVar, j);
        return hVar;
    }

    public static final void setGone(View view, boolean z9) {
        view.setVisibility(z9 ? 8 : 0);
    }

    public static final void setInvisible(View view, boolean z9) {
        view.setVisibility(z9 ? 4 : 0);
    }

    public static final void setPadding(View view, @Px int i) {
        view.setPadding(i, i, i, i);
    }

    public static final void setVisible(View view, boolean z9) {
        view.setVisibility(z9 ? 0 : 8);
    }

    public static final void updateLayoutParams(View view, d7.l lVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            com.google.gson.internal.a.i("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        } else {
            lVar.invoke(layoutParams);
            view.setLayoutParams(layoutParams);
        }
    }

    public static final <T extends ViewGroup.LayoutParams> void updateLayoutParamsTyped(View view, d7.l lVar) {
        view.getLayoutParams();
        kotlin.jvm.internal.l.h();
        throw null;
    }

    public static final void updatePadding(View view, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        view.setPadding(i, i6, i10, i11);
    }

    public static /* synthetic */ void updatePadding$default(View view, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = view.getPaddingLeft();
        }
        if ((i12 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i12 & 4) != 0) {
            i10 = view.getPaddingRight();
        }
        if ((i12 & 8) != 0) {
            i11 = view.getPaddingBottom();
        }
        view.setPadding(i, i6, i10, i11);
    }

    public static final void updatePaddingRelative(View view, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        view.setPaddingRelative(i, i6, i10, i11);
    }

    public static /* synthetic */ void updatePaddingRelative$default(View view, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = view.getPaddingStart();
        }
        if ((i12 & 2) != 0) {
            i6 = view.getPaddingTop();
        }
        if ((i12 & 4) != 0) {
            i10 = view.getPaddingEnd();
        }
        if ((i12 & 8) != 0) {
            i11 = view.getPaddingBottom();
        }
        view.setPaddingRelative(i, i6, i10, i11);
    }
}
