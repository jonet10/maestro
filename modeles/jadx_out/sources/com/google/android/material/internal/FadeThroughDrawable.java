package com.google.android.material.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class FadeThroughDrawable extends Drawable {
    private final float[] alphas;
    private final Drawable fadeInDrawable;
    private final Drawable fadeOutDrawable;
    private float progress;

    public FadeThroughDrawable(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        Drawable mutate = drawable != null ? drawable.getConstantState().newDrawable().mutate() : new EmptyDrawable();
        this.fadeOutDrawable = mutate;
        Drawable mutate2 = drawable2 != null ? drawable2.getConstantState().newDrawable().mutate() : new EmptyDrawable();
        this.fadeInDrawable = mutate2;
        int layoutDirection = drawable != null ? DrawableCompat.getLayoutDirection(drawable) : 3;
        int layoutDirection2 = drawable2 != null ? DrawableCompat.getLayoutDirection(drawable2) : 3;
        DrawableCompat.setLayoutDirection(mutate, layoutDirection);
        DrawableCompat.setLayoutDirection(mutate2, layoutDirection2);
        mutate2.setAlpha(0);
        this.alphas = new float[2];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        this.fadeOutDrawable.draw(canvas);
        this.fadeInDrawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return Math.max(this.fadeOutDrawable.getIntrinsicHeight(), this.fadeInDrawable.getIntrinsicHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.max(this.fadeOutDrawable.getIntrinsicWidth(), this.fadeInDrawable.getIntrinsicWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return Math.max(this.fadeOutDrawable.getMinimumHeight(), this.fadeInDrawable.getMinimumHeight());
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return Math.max(this.fadeOutDrawable.getMinimumWidth(), this.fadeInDrawable.getMinimumWidth());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.fadeOutDrawable.isStateful() || this.fadeInDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        float f = this.progress;
        Drawable drawable = this.fadeOutDrawable;
        if (f <= 0.5f) {
            drawable.setAlpha(i);
            this.fadeInDrawable.setAlpha(0);
        } else {
            drawable.setAlpha(0);
            this.fadeInDrawable.setAlpha(i);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i6, int i10, int i11) {
        super.setBounds(i, i6, i10, i11);
        this.fadeOutDrawable.setBounds(i, i6, i10, i11);
        this.fadeInDrawable.setBounds(i, i6, i10, i11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.fadeOutDrawable.setColorFilter(colorFilter);
        this.fadeInDrawable.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (this.progress != f) {
            this.progress = f;
            FadeThroughUtils.calculateFadeOutAndInAlphas(f, this.alphas);
            this.fadeOutDrawable.setAlpha((int) (this.alphas[0] * 255.0f));
            this.fadeInDrawable.setAlpha((int) (this.alphas[1] * 255.0f));
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.fadeOutDrawable.setState(iArr) || this.fadeInDrawable.setState(iArr);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class EmptyDrawable extends Drawable {
        private EmptyDrawable() {
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }
}
