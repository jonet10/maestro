package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.CarouselStrategy;
import com.google.android.material.carousel.KeylineState;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: com.google.android.material.carousel.KeylineStateList$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType;

        static {
            int[] iArr = new int[CarouselStrategy.StrategyType.values().length];
            $SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType = iArr;
            try {
                iArr[CarouselStrategy.StrategyType.CONTAINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = DesugarCollections.unmodifiableList(list);
        this.endStateSteps = DesugarCollections.unmodifiableList(list2);
        float f = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f;
        float f10 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.endShiftRange = f10;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f10, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i = 0; i < keylineState.getKeylines().size(); i++) {
            if (!keylineState.getKeylines().get(i).isAnchor) {
                return i;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f, float f10, float f11, CarouselStrategy.StrategyType strategyType) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f, f10, strategyType), getStateStepsEnd(carousel, keylineState, f, f11, strategyType));
    }

    private static float[] getStateStepInterpolationPoints(float f, List<KeylineState> list, boolean z9) {
        int size = list.size();
        float[] fArr = new float[size];
        int i = 1;
        while (i < size) {
            int i6 = i - 1;
            KeylineState keylineState = list.get(i6);
            KeylineState keylineState2 = list.get(i);
            fArr[i] = i == size + (-1) ? 1.0f : fArr[i6] + ((z9 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f);
            i++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f, float f10, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && findLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = findLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f11 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, (f11 - keylineState.getLastFocalKeyline().cutoff) - f10, containerWidth));
                return arrayList;
            }
            float f12 = 0.0f;
            int i = 0;
            while (i < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i6 = findLastNonAnchorKeylineIndex - i;
                float f13 = f12 + keylineState.getKeylines().get(i6).cutoff;
                int i10 = i6 + 1;
                int i11 = containerWidth;
                KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, findLastNonAnchorKeylineIndex, i10 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i10).mask) + 1 : 0, f11 - f13, keylineState.getFirstFocalKeylineIndex() + i + 1, keylineState.getLastFocalKeylineIndex() + i + 1, i11);
                if (i == lastFocalKeylineIndex - 1 && f10 > 0.0f) {
                    moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f10, i11, false, f, strategyType);
                    i11 = i11;
                }
                arrayList.add(moveKeylineAndCreateKeylineState);
                i++;
                containerWidth = i11;
                f12 = f13;
            }
        } else if (f10 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f10, containerWidth, false, f, strategyType));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f, float[] fArr) {
        int size = list.size();
        float f10 = fArr[0];
        int i = 1;
        while (i < size) {
            float f11 = fArr[i];
            if (f <= f11) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f10, f11, f), i - 1, i};
            }
            i++;
            f10 = f11;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f, float f10, CarouselStrategy.StrategyType strategyType) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int findFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        int containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && findFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - findFirstNonAnchorKeylineIndex;
            float f11 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f11 + keylineState.getFirstFocalKeyline().cutoff + f10, containerWidth));
                return arrayList;
            }
            float f12 = 0.0f;
            for (int i = 0; i < firstFocalKeylineIndex; i++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i6 = findFirstNonAnchorKeylineIndex + i;
                int size = keylineState.getKeylines().size() - 1;
                f12 += keylineState.getKeylines().get(i6).cutoff;
                int i10 = i6 - 1;
                if (i10 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i10).mask) - 1;
                }
                int i11 = containerWidth;
                KeylineState moveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, findFirstNonAnchorKeylineIndex, size, f11 + f12, (keylineState.getFirstFocalKeylineIndex() - i) - 1, (keylineState.getLastFocalKeylineIndex() - i) - 1, i11);
                containerWidth = i11;
                if (i == firstFocalKeylineIndex - 1 && f10 > 0.0f) {
                    moveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(moveKeylineAndCreateKeylineState, f10, containerWidth, true, f, strategyType);
                }
                arrayList.add(moveKeylineAndCreateKeylineState);
            }
        } else if (f10 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f10, containerWidth, true, f, strategyType));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i, int i6, float f, int i10, int i11, int i12) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i6, (KeylineState.Keyline) arrayList.remove(i));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i12);
        int i13 = 0;
        while (i13 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i13);
            float f10 = keyline.maskedItemSize;
            builder.addKeyline((f10 / 2.0f) + f, keyline.mask, f10, i13 >= i10 && i13 <= i11, keyline.isAnchor, keyline.cutoff);
            f += keyline.maskedItemSize;
            i13++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPadding(@NonNull KeylineState keylineState, float f, int i, boolean z9, float f10, CarouselStrategy.StrategyType strategyType) {
        return AnonymousClass1.$SwitchMap$com$google$android$material$carousel$CarouselStrategy$StrategyType[strategyType.ordinal()] != 1 ? shiftKeylineStateForPaddingUncontained(keylineState, f, i, z9) : shiftKeylineStateForPaddingContained(keylineState, f, i, z9, f10);
    }

    private static KeylineState shiftKeylineStateForPaddingContained(KeylineState keylineState, float f, int i, boolean z9, float f10) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i);
        float numberOfNonAnchorKeylines = f / keylineState.getNumberOfNonAnchorKeylines();
        float f11 = z9 ? f : 0.0f;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z10 = i6 >= keylineState.getFirstFocalKeylineIndex() && i6 <= keylineState.getLastFocalKeylineIndex();
                float f12 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f12, keylineState.getItemSize(), f10);
                float f13 = (f12 / 2.0f) + f11;
                float abs = Math.abs(f13 - keyline.locOffset);
                builder.addKeyline(f13, childMaskPercentage, f12, z10, false, keyline.cutoff, z9 ? abs : 0.0f, z9 ? 0.0f : abs);
                f11 += f12;
            }
            i6++;
        }
        return builder.build();
    }

    @NonNull
    private static KeylineState shiftKeylineStateForPaddingUncontained(@NonNull KeylineState keylineState, float f, int i, boolean z9) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), i);
        boolean z10 = true;
        int size = z9 ? 0 : arrayList.size() - 1;
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            if (keyline.isAnchor && i6 == size) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                float f10 = keyline.locOffset;
                float f11 = z9 ? f10 + f : f10 - f;
                float f12 = z9 ? f : 0.0f;
                float f13 = z9 ? 0.0f : f;
                boolean z11 = (i6 < keylineState.getFirstFocalKeylineIndex() || i6 > keylineState.getLastFocalKeylineIndex()) ? false : z10;
                float f14 = f11;
                float f15 = keyline.mask;
                float f16 = keyline.maskedItemSize;
                builder.addKeyline(f14, f15, f16, z11, keyline.isAnchor, Math.abs(z9 ? Math.max(0.0f, ((f16 / 2.0f) + f14) - i) : Math.min(0.0f, f14 - (f16 / 2.0f))), f12, f13);
            }
            i6++;
            z10 = true;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f, int i) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), i);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return this.endStateSteps.get(r0.size() - 1);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i, int i6, int i10, boolean z9) {
        float itemSize = this.defaultState.getItemSize();
        HashMap hashMap = new HashMap();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= i) {
                break;
            }
            int i13 = z9 ? (i - i11) - 1 : i11;
            if (i13 * itemSize * (z9 ? -1 : 1) > i10 - this.endShiftRange || i11 >= i - this.endStateSteps.size()) {
                Integer valueOf = Integer.valueOf(i13);
                List<KeylineState> list = this.endStateSteps;
                hashMap.put(valueOf, list.get(MathUtils.clamp(i12, 0, list.size() - 1)));
                i12++;
            }
            i11++;
        }
        int i14 = 0;
        for (int i15 = i - 1; i15 >= 0; i15--) {
            int i16 = z9 ? (i - i15) - 1 : i15;
            if (i16 * itemSize * (z9 ? -1 : 1) < i6 + this.startShiftRange || i15 < this.startStateSteps.size()) {
                Integer valueOf2 = Integer.valueOf(i16);
                List<KeylineState> list2 = this.startStateSteps;
                hashMap.put(valueOf2, list2.get(MathUtils.clamp(i14, 0, list2.size() - 1)));
                i14++;
            }
        }
        return hashMap;
    }

    public KeylineState getShiftedState(float f, float f10, float f11, boolean z9) {
        float lerp;
        List<KeylineState> list;
        float[] fArr;
        float f12 = this.startShiftRange + f10;
        float f13 = f11 - this.endShiftRange;
        float f14 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f15 = getEndState().getFirstFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f14) {
            f12 += f14;
        }
        if (this.endShiftRange == f15) {
            f13 -= f15;
        }
        if (f < f12) {
            lerp = AnimationUtils.lerp(1.0f, 0.0f, f10, f12, f);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f <= f13) {
                return this.defaultState;
            }
            lerp = AnimationUtils.lerp(0.0f, 1.0f, f13, f11, f);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z9 ? closestStateStepFromInterpolation(list, lerp, fArr) : lerp(list, lerp, fArr);
    }

    public KeylineState getStartState() {
        return this.startStateSteps.get(r0.size() - 1);
    }

    @NonNull
    public KeylineState getShiftedState(float f, float f10, float f11) {
        return getShiftedState(f, f10, f11, false);
    }
}
