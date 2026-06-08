package com.google.android.material.carousel;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class KeylineState {
    private final int carouselSize;
    private final int firstFocalKeylineIndex;
    private final float itemSize;
    private final List<Keyline> keylines;
    private final int lastFocalKeylineIndex;
    private int totalVisibleFocalItems;

    private KeylineState(float f, List<Keyline> list, int i, int i6, int i10) {
        this.itemSize = f;
        this.keylines = DesugarCollections.unmodifiableList(list);
        this.firstFocalKeylineIndex = i;
        this.lastFocalKeylineIndex = i6;
        while (i <= i6) {
            if (list.get(i).cutoff == 0.0f) {
                this.totalVisibleFocalItems++;
            }
            i++;
        }
        this.carouselSize = i10;
    }

    public static KeylineState lerp(KeylineState keylineState, KeylineState keylineState2, float f) {
        if (keylineState.getItemSize() != keylineState2.getItemSize()) {
            com.google.gson.internal.a.p("Keylines being linearly interpolated must have the same item size.");
            return null;
        }
        List<Keyline> keylines = keylineState.getKeylines();
        List<Keyline> keylines2 = keylineState2.getKeylines();
        if (keylines.size() != keylines2.size()) {
            com.google.gson.internal.a.p("Keylines being linearly interpolated must have the same number of keylines.");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            arrayList.add(Keyline.lerp(keylines.get(i), keylines2.get(i), f));
        }
        return new KeylineState(keylineState.getItemSize(), arrayList, AnimationUtils.lerp(keylineState.getFirstFocalKeylineIndex(), keylineState2.getFirstFocalKeylineIndex(), f), AnimationUtils.lerp(keylineState.getLastFocalKeylineIndex(), keylineState2.getLastFocalKeylineIndex(), f), keylineState.carouselSize);
    }

    public static KeylineState reverse(KeylineState keylineState, int i) {
        Builder builder = new Builder(keylineState.getItemSize(), i);
        float f = (i - keylineState.getLastKeyline().locOffset) - (keylineState.getLastKeyline().maskedItemSize / 2.0f);
        int size = keylineState.getKeylines().size() - 1;
        while (size >= 0) {
            Keyline keyline = keylineState.getKeylines().get(size);
            builder.addKeyline((keyline.maskedItemSize / 2.0f) + f, keyline.mask, keyline.maskedItemSize, size >= keylineState.getFirstFocalKeylineIndex() && size <= keylineState.getLastFocalKeylineIndex(), keyline.isAnchor);
            f += keyline.maskedItemSize;
            size--;
        }
        return builder.build();
    }

    public int getCarouselSize() {
        return this.carouselSize;
    }

    public Keyline getFirstFocalKeyline() {
        return this.keylines.get(this.firstFocalKeylineIndex);
    }

    public int getFirstFocalKeylineIndex() {
        return this.firstFocalKeylineIndex;
    }

    public Keyline getFirstKeyline() {
        return this.keylines.get(0);
    }

    @Nullable
    public Keyline getFirstNonAnchorKeyline() {
        for (int i = 0; i < this.keylines.size(); i++) {
            Keyline keyline = this.keylines.get(i);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public List<Keyline> getFocalKeylines() {
        return this.keylines.subList(this.firstFocalKeylineIndex, this.lastFocalKeylineIndex + 1);
    }

    public float getItemSize() {
        return this.itemSize;
    }

    public List<Keyline> getKeylines() {
        return this.keylines;
    }

    public Keyline getLastFocalKeyline() {
        return this.keylines.get(this.lastFocalKeylineIndex);
    }

    public int getLastFocalKeylineIndex() {
        return this.lastFocalKeylineIndex;
    }

    public Keyline getLastKeyline() {
        return this.keylines.get(r0.size() - 1);
    }

    @Nullable
    public Keyline getLastNonAnchorKeyline() {
        for (int size = this.keylines.size() - 1; size >= 0; size--) {
            Keyline keyline = this.keylines.get(size);
            if (!keyline.isAnchor) {
                return keyline;
            }
        }
        return null;
    }

    public int getNumberOfNonAnchorKeylines() {
        Iterator<Keyline> it = this.keylines.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isAnchor) {
                i++;
            }
        }
        return this.keylines.size() - i;
    }

    public int getTotalVisibleFocalItems() {
        return this.totalVisibleFocalItems;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Keyline {
        final float cutoff;
        final boolean isAnchor;
        final float leftOrTopPaddingShift;
        final float loc;
        final float locOffset;
        final float mask;
        final float maskedItemSize;
        final float rightOrBottomPaddingShift;

        public Keyline(float f, float f10, float f11, float f12, boolean z9, float f13, float f14, float f15) {
            this.loc = f;
            this.locOffset = f10;
            this.mask = f11;
            this.maskedItemSize = f12;
            this.isAnchor = z9;
            this.cutoff = f13;
            this.leftOrTopPaddingShift = f14;
            this.rightOrBottomPaddingShift = f15;
        }

        public static Keyline lerp(Keyline keyline, Keyline keyline2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
            return new Keyline(AnimationUtils.lerp(keyline.loc, keyline2.loc, f), AnimationUtils.lerp(keyline.locOffset, keyline2.locOffset, f), AnimationUtils.lerp(keyline.mask, keyline2.mask, f), AnimationUtils.lerp(keyline.maskedItemSize, keyline2.maskedItemSize, f));
        }

        public Keyline(float f, float f10, float f11, float f12) {
            this(f, f10, f11, f12, false, 0.0f, 0.0f, 0.0f);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {
        private static final int NO_INDEX = -1;
        private static final float UNKNOWN_LOC = Float.MIN_VALUE;
        private final int carouselSize;
        private final float itemSize;
        private Keyline tmpFirstFocalKeyline;
        private Keyline tmpLastFocalKeyline;
        private final List<Keyline> tmpKeylines = new ArrayList();
        private int firstFocalKeylineIndex = -1;
        private int lastFocalKeylineIndex = -1;
        private float lastKeylineMaskedSize = 0.0f;
        private int latestAnchorKeylineIndex = -1;

        public Builder(float f, int i) {
            this.itemSize = f;
            this.carouselSize = i;
        }

        private static float calculateKeylineLocationForItemPosition(float f, float f10, int i, int i6) {
            return (i6 * f10) + (f - (i * f10));
        }

        @NonNull
        public Builder addAnchorKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11) {
            return addKeyline(f, f10, f11, false, true);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, boolean z9, boolean z10, float f12, float f13, float f14) {
            if (f11 <= 0.0f) {
                return this;
            }
            if (z10) {
                if (z9) {
                    com.google.gson.internal.a.p("Anchor keylines cannot be focal.");
                    return null;
                }
                int i = this.latestAnchorKeylineIndex;
                if (i != -1 && i != 0) {
                    com.google.gson.internal.a.p("Anchor keylines must be either the first or last keyline.");
                    return null;
                }
                this.latestAnchorKeylineIndex = this.tmpKeylines.size();
            }
            Keyline keyline = new Keyline(UNKNOWN_LOC, f, f10, f11, z10, f12, f13, f14);
            Keyline keyline2 = this.tmpFirstFocalKeyline;
            if (z9) {
                if (keyline2 == null) {
                    this.tmpFirstFocalKeyline = keyline;
                    this.firstFocalKeylineIndex = this.tmpKeylines.size();
                }
                if (this.lastFocalKeylineIndex != -1 && this.tmpKeylines.size() - this.lastFocalKeylineIndex > 1) {
                    com.google.gson.internal.a.p("Keylines marked as focal must be placed next to each other. There cannot be non-focal keylines between focal keylines.");
                    return null;
                }
                if (f11 != this.tmpFirstFocalKeyline.maskedItemSize) {
                    com.google.gson.internal.a.p("Keylines that are marked as focal must all have the same masked item size.");
                    return null;
                }
                this.tmpLastFocalKeyline = keyline;
                this.lastFocalKeylineIndex = this.tmpKeylines.size();
            } else {
                if (keyline2 == null && keyline.maskedItemSize < this.lastKeylineMaskedSize) {
                    com.google.gson.internal.a.p("Keylines before the first focal keyline must be ordered by incrementing masked item size.");
                    return null;
                }
                if (this.tmpLastFocalKeyline != null && keyline.maskedItemSize > this.lastKeylineMaskedSize) {
                    com.google.gson.internal.a.p("Keylines after the last focal keyline must be ordered by decreasing masked item size.");
                    return null;
                }
            }
            this.lastKeylineMaskedSize = keyline.maskedItemSize;
            this.tmpKeylines.add(keyline);
            return this;
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, int i, boolean z9) {
            if (i > 0 && f11 > 0.0f) {
                for (int i6 = 0; i6 < i; i6++) {
                    addKeyline((i6 * f11) + f, f10, f11, z9);
                }
            }
            return this;
        }

        @NonNull
        public KeylineState build() {
            if (this.tmpFirstFocalKeyline == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("There must be a keyline marked as focal.");
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.tmpKeylines.size(); i++) {
                Keyline keyline = this.tmpKeylines.get(i);
                arrayList.add(new Keyline(calculateKeylineLocationForItemPosition(this.tmpFirstFocalKeyline.locOffset, this.itemSize, this.firstFocalKeylineIndex, i), keyline.locOffset, keyline.mask, keyline.maskedItemSize, keyline.isAnchor, keyline.cutoff, keyline.leftOrTopPaddingShift, keyline.rightOrBottomPaddingShift));
            }
            return new KeylineState(this.itemSize, arrayList, this.firstFocalKeylineIndex, this.lastFocalKeylineIndex, this.carouselSize);
        }

        @NonNull
        public Builder addKeylineRange(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, int i) {
            return addKeylineRange(f, f10, f11, i, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11) {
            return addKeyline(f, f10, f11, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, boolean z9) {
            return addKeyline(f, f10, f11, z9, false);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, boolean z9, boolean z10, float f12) {
            return addKeyline(f, f10, f11, z9, z10, f12, 0.0f, 0.0f);
        }

        @NonNull
        public Builder addKeyline(float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, float f11, boolean z9, boolean z10) {
            float f12;
            float f13 = f11 / 2.0f;
            float f14 = f - f13;
            float f15 = f13 + f;
            int i = this.carouselSize;
            if (f15 > i) {
                f12 = Math.abs(f15 - Math.max(f15 - f11, i));
            } else {
                f12 = 0.0f;
                if (f14 < 0.0f) {
                    f12 = Math.abs(f14 - Math.min(f14 + f11, 0.0f));
                }
            }
            return addKeyline(f, f10, f11, z9, z10, f12);
        }
    }
}
