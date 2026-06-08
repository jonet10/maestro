package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class AppCompatCompoundButtonHelper {
    private ColorStateList mButtonTintList = null;
    private PorterDuff.Mode mButtonTintMode = null;
    private boolean mHasButtonTint = false;
    private boolean mHasButtonTintMode = false;
    private boolean mSkipNextApply;

    @NonNull
    private final CompoundButton mView;

    public AppCompatCompoundButtonHelper(@NonNull CompoundButton compoundButton) {
        this.mView = compoundButton;
    }

    public void applyButtonTint() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
        if (buttonDrawable != null) {
            if (this.mHasButtonTint || this.mHasButtonTintMode) {
                Drawable mutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.mHasButtonTint) {
                    DrawableCompat.setTintList(mutate, this.mButtonTintList);
                }
                if (this.mHasButtonTintMode) {
                    DrawableCompat.setTintMode(mutate, this.mButtonTintMode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.mView.getDrawableState());
                }
                this.mView.setButtonDrawable(mutate);
            }
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.mButtonTintList;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        return this.mButtonTintMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0065 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005d, B:11:0x0065, B:12:0x0070, B:14:0x0078, B:21:0x0040, B:23:0x0048, B:25:0x0050), top: B:2:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005d, B:11:0x0065, B:12:0x0070, B:14:0x0078, B:21:0x0040, B:23:0x0048, B:25:0x0050), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadFromAttributes(@androidx.annotation.Nullable android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.mView
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.obtainStyledAttributes(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.mView
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CompoundButton
            android.content.res.TypedArray r7 = r1.getWrappedTypeArray()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r1.hasValue(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L40
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L3d
            int r11 = r1.getResourceId(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L40
            android.widget.CompoundButton r12 = r10.mView     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L40
            android.content.Context r0 = r12.getContext()     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L40
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L40
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L40
            goto L5d
        L3d:
            r0 = move-exception
            r11 = r0
            goto L8d
        L40:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r1.hasValue(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5d
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L3d
            int r11 = r1.getResourceId(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5d
            android.widget.CompoundButton r12 = r10.mView     // Catch: java.lang.Throwable -> L3d
            android.content.Context r0 = r12.getContext()     // Catch: java.lang.Throwable -> L3d
            android.graphics.drawable.Drawable r11 = androidx.appcompat.content.res.AppCompatResources.getDrawable(r0, r11)     // Catch: java.lang.Throwable -> L3d
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d
        L5d:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r1.hasValue(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L70
            android.widget.CompoundButton r11 = r10.mView     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L3d
            android.content.res.ColorStateList r12 = r1.getColorStateList(r12)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.CompoundButtonCompat.setButtonTintList(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L70:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r1.hasValue(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L89
            android.widget.CompoundButton r11 = r10.mView     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L3d
            r0 = -1
            int r12 = r1.getInt(r12, r0)     // Catch: java.lang.Throwable -> L3d
            r0 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.DrawableUtils.parseTintMode(r12, r0)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.CompoundButtonCompat.setButtonTintMode(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L89:
            r1.recycle()
            return
        L8d:
            r1.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatCompoundButtonHelper.loadFromAttributes(android.util.AttributeSet, int):void");
    }

    public void onSetButtonDrawable() {
        if (this.mSkipNextApply) {
            this.mSkipNextApply = false;
        } else {
            this.mSkipNextApply = true;
            applyButtonTint();
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        this.mButtonTintList = colorStateList;
        this.mHasButtonTint = true;
        applyButtonTint();
    }

    public void setSupportButtonTintMode(@Nullable PorterDuff.Mode mode) {
        this.mButtonTintMode = mode;
        this.mHasButtonTintMode = true;
        applyButtonTint();
    }
}
