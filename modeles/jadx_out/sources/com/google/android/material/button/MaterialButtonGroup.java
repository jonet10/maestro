package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.StateListCornerSize;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class MaterialButtonGroup extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_MaterialButtonGroup;
    private static final String LOG_TAG = "MButtonGroup";

    @Nullable
    private StateListSizeChange buttonSizeChange;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private boolean childShapesDirty;

    @Nullable
    private StateListShapeAppearanceModel groupStateListShapeAppearance;

    @Nullable
    StateListCornerSize innerCornerSize;
    private final List<ShapeAppearanceModel> originalChildShapeAppearanceModels;
    private final List<StateListShapeAppearanceModel> originalChildStateListShapeAppearanceModels;
    private final PressedStateTracker pressedStateTracker;

    @Px
    private int spacing;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(@NonNull MaterialButton materialButton, boolean z9) {
            MaterialButtonGroup.this.invalidate();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonGroup(@androidx.annotation.NonNull android.content.Context r8, @androidx.annotation.Nullable android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.button.MaterialButtonGroup.DEF_STYLE_RES
            android.content.Context r8 = com.google.android.material.theme.overlay.MaterialThemeOverlay.wrap(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.originalChildShapeAppearanceModels = r8
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.originalChildStateListShapeAppearanceModels = r8
            com.google.android.material.button.MaterialButtonGroup$PressedStateTracker r8 = new com.google.android.material.button.MaterialButtonGroup$PressedStateTracker
            r0 = 0
            r8.<init>()
            r7.pressedStateTracker = r8
            c4.k1 r8 = new c4.k1
            r0 = 1
            r8.<init>(r7, r0)
            r7.childOrderComparator = r8
            r8 = 1
            r7.childShapesDirty = r8
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonGroup
            r6 = 0
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.ThemeEnforcement.obtainStyledAttributes(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_buttonSizeChange
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L49
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_buttonSizeChange
            com.google.android.material.shape.StateListSizeChange r10 = com.google.android.material.shape.StateListSizeChange.create(r0, r9, r10)
            r7.buttonSizeChange = r10
        L49:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearance
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L7a
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearance
            com.google.android.material.shape.StateListShapeAppearanceModel r10 = com.google.android.material.shape.StateListShapeAppearanceModel.create(r0, r9, r10)
            r7.groupStateListShapeAppearance = r10
            if (r10 != 0) goto L7a
            com.google.android.material.shape.StateListShapeAppearanceModel$Builder r10 = new com.google.android.material.shape.StateListShapeAppearanceModel$Builder
            int r1 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearance
            int r1 = r9.getResourceId(r1, r6)
            int r2 = com.google.android.material.R.styleable.MaterialButtonGroup_shapeAppearanceOverlay
            int r2 = r9.getResourceId(r2, r6)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.builder(r0, r1, r2)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.build()
            r10.<init>(r1)
            com.google.android.material.shape.StateListShapeAppearanceModel r10 = r10.build()
            r7.groupStateListShapeAppearance = r10
        L7a:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_innerCornerSize
            boolean r10 = r9.hasValue(r10)
            if (r10 == 0) goto L90
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_innerCornerSize
            com.google.android.material.shape.AbsoluteCornerSize r1 = new com.google.android.material.shape.AbsoluteCornerSize
            r2 = 0
            r1.<init>(r2)
            com.google.android.material.shape.StateListCornerSize r10 = com.google.android.material.shape.StateListCornerSize.create(r0, r9, r10, r1)
            r7.innerCornerSize = r10
        L90:
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_android_spacing
            int r10 = r9.getDimensionPixelSize(r10, r6)
            r7.spacing = r10
            r7.setChildrenDrawingOrderEnabled(r8)
            int r10 = com.google.android.material.R.styleable.MaterialButtonGroup_android_enabled
            boolean r8 = r9.getBoolean(r10, r8)
            r7.setEnabled(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int i;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i6 = firstVisibleChildIndex + 1; i6 < getChildCount(); i6++) {
            MaterialButton childButton = getChildButton(i6);
            MaterialButton childButton2 = getChildButton(i6 - 1);
            if (this.spacing <= 0) {
                i = Math.min(childButton.getStrokeWidth(), childButton2.getStrokeWidth());
                childButton.setShouldDrawSurfaceColorStroke(true);
                childButton2.setShouldDrawSurfaceColorStroke(true);
            } else {
                childButton.setShouldDrawSurfaceColorStroke(false);
                childButton2.setShouldDrawSurfaceColorStroke(false);
                i = 0;
            }
            LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childButton);
            if (getOrientation() == 0) {
                buildLayoutParams.setMarginEnd(0);
                buildLayoutParams.setMarginStart(this.spacing - i);
                buildLayoutParams.topMargin = 0;
            } else {
                buildLayoutParams.bottomMargin = 0;
                buildLayoutParams.topMargin = this.spacing - i;
                buildLayoutParams.setMarginStart(0);
            }
            childButton.setLayoutParams(buildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    private void adjustChildSizeChange() {
        if (this.buttonSizeChange == null || getChildCount() == 0) {
            return;
        }
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        int i = Integer.MAX_VALUE;
        for (int i6 = firstVisibleChildIndex; i6 <= lastVisibleChildIndex; i6++) {
            if (isChildVisible(i6)) {
                int buttonAllowedWidthIncrease = getButtonAllowedWidthIncrease(i6);
                if (i6 != firstVisibleChildIndex && i6 != lastVisibleChildIndex) {
                    buttonAllowedWidthIncrease /= 2;
                }
                i = Math.min(i, buttonAllowedWidthIncrease);
            }
        }
        int i10 = firstVisibleChildIndex;
        while (i10 <= lastVisibleChildIndex) {
            if (isChildVisible(i10)) {
                getChildButton(i10).setSizeChange(this.buttonSizeChange);
                getChildButton(i10).setWidthChangeMax((i10 == firstVisibleChildIndex || i10 == lastVisibleChildIndex) ? i : i * 2);
            }
            i10++;
        }
    }

    private int getButtonAllowedWidthIncrease(int i) {
        if (!isChildVisible(i) || this.buttonSizeChange == null) {
            return 0;
        }
        int max = Math.max(0, this.buttonSizeChange.getMaxWidthChange(getChildButton(i).getWidth()));
        MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(i);
        int allowedWidthDecrease = prevVisibleChildButton == null ? 0 : prevVisibleChildButton.getAllowedWidthDecrease();
        MaterialButton nextVisibleChildButton = getNextVisibleChildButton(i);
        return Math.min(max, allowedWidthDecrease + (nextVisibleChildButton != null ? nextVisibleChildButton.getAllowedWidthDecrease() : 0));
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    @Nullable
    private MaterialButton getNextVisibleChildButton(int i) {
        int childCount = getChildCount();
        do {
            i++;
            if (i >= childCount) {
                return null;
            }
        } while (!isChildVisible(i));
        return getChildButton(i);
    }

    @NonNull
    private StateListShapeAppearanceModel.Builder getOriginalStateListShapeBuilder(boolean z9, boolean z10, int i) {
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.groupStateListShapeAppearance;
        if (stateListShapeAppearanceModel == null || (!z9 && !z10)) {
            stateListShapeAppearanceModel = this.originalChildStateListShapeAppearanceModels.get(i);
        }
        return stateListShapeAppearanceModel == null ? new StateListShapeAppearanceModel.Builder(this.originalChildShapeAppearanceModels.get(i)) : stateListShapeAppearanceModel.toBuilder();
    }

    @Nullable
    private MaterialButton getPrevVisibleChildButton(int i) {
        for (int i6 = i - 1; i6 >= 0; i6--) {
            if (isChildVisible(i6)) {
                return getChildButton(i6);
            }
        }
        return null;
    }

    private boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int lambda$new$0(MaterialButton materialButton, MaterialButton materialButton2) {
        int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        return compareTo2 != 0 ? compareTo2 : Integer.compare(indexOfChild(materialButton), indexOfChild(materialButton2));
    }

    private void recoverAllChildrenLayoutParams() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildButton(i).recoverOriginalLayoutParams();
        }
    }

    private void resetChildMargins(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildButton(i).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            layoutParams.setMarginEnd(0);
            layoutParams.setMarginStart(0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        recoverAllChildrenLayoutParams();
        this.childShapesDirty = true;
        super.addView(view, i, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        this.originalChildShapeAppearanceModels.add(materialButton.getShapeAppearanceModel());
        this.originalChildStateListShapeAppearanceModels.add(materialButton.getStateListShapeAppearanceModel());
        materialButton.setEnabled(isEnabled());
    }

    @NonNull
    public LinearLayout.LayoutParams buildLayoutParams(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListSizeChange getButtonSizeChange() {
        return this.buttonSizeChange;
    }

    @NonNull
    public MaterialButton getChildButton(int i) {
        return (MaterialButton) getChildAt(i);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i6) {
        Integer[] numArr = this.childOrder;
        if (numArr != null && i6 < numArr.length) {
            return numArr[i6].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i6;
    }

    @NonNull
    public CornerSize getInnerCornerSize() {
        return this.innerCornerSize.getDefaultCornerSize();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListCornerSize getInnerCornerSizeStateList() {
        return this.innerCornerSize;
    }

    @Nullable
    public ShapeAppearanceModel getShapeAppearance() {
        StateListShapeAppearanceModel stateListShapeAppearanceModel = this.groupStateListShapeAppearance;
        if (stateListShapeAppearanceModel == null) {
            return null;
        }
        return stateListShapeAppearanceModel.getDefaultShape(true);
    }

    @Px
    public int getSpacing() {
        return this.spacing;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public StateListShapeAppearanceModel getStateListShapeAppearance() {
        return this.groupStateListShapeAppearance;
    }

    public void onButtonWidthChanged(@NonNull MaterialButton materialButton, int i) {
        int indexOfChild = indexOfChild(materialButton);
        if (indexOfChild < 0) {
            return;
        }
        MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(indexOfChild);
        MaterialButton nextVisibleChildButton = getNextVisibleChildButton(indexOfChild);
        if (prevVisibleChildButton == null && nextVisibleChildButton == null) {
            return;
        }
        if (prevVisibleChildButton == null) {
            nextVisibleChildButton.setDisplayedWidthDecrease(i);
        }
        if (nextVisibleChildButton == null) {
            prevVisibleChildButton.setDisplayedWidthDecrease(i);
        }
        if (prevVisibleChildButton == null || nextVisibleChildButton == null) {
            return;
        }
        prevVisibleChildButton.setDisplayedWidthDecrease(i / 2);
        nextVisibleChildButton.setDisplayedWidthDecrease((i + 1) / 2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        if (z9) {
            recoverAllChildrenLayoutParams();
            adjustChildSizeChange();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i6) {
        updateChildShapes();
        adjustChildMarginsAndUpdateLayout();
        super.onMeasure(i, i6);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalChildShapeAppearanceModels.remove(indexOfChild);
            this.originalChildStateListShapeAppearanceModels.remove(indexOfChild);
        }
        this.childShapesDirty = true;
        updateChildShapes();
        recoverAllChildrenLayoutParams();
        adjustChildMarginsAndUpdateLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setButtonSizeChange(@NonNull StateListSizeChange stateListSizeChange) {
        if (this.buttonSizeChange != stateListSizeChange) {
            this.buttonSizeChange = stateListSizeChange;
            adjustChildSizeChange();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z9) {
        super.setEnabled(z9);
        for (int i = 0; i < getChildCount(); i++) {
            getChildButton(i).setEnabled(z9);
        }
    }

    public void setInnerCornerSize(@NonNull CornerSize cornerSize) {
        this.innerCornerSize = StateListCornerSize.create(cornerSize);
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setInnerCornerSizeStateList(@NonNull StateListCornerSize stateListCornerSize) {
        this.innerCornerSize = stateListCornerSize;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.childShapesDirty = true;
        }
        super.setOrientation(i);
    }

    public void setShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.groupStateListShapeAppearance = new StateListShapeAppearanceModel.Builder(shapeAppearanceModel).build();
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setSpacing(@Px int i) {
        this.spacing = i;
        invalidate();
        requestLayout();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStateListShapeAppearance(@Nullable StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        this.groupStateListShapeAppearance = stateListShapeAppearanceModel;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @VisibleForTesting
    public void updateChildShapes() {
        int i;
        if (!(this.innerCornerSize == null && this.groupStateListShapeAppearance == null) && this.childShapesDirty) {
            this.childShapesDirty = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i6 = 0;
            while (i6 < childCount) {
                MaterialButton childButton = getChildButton(i6);
                if (childButton.getVisibility() != 8) {
                    boolean z9 = i6 == firstVisibleChildIndex;
                    boolean z10 = i6 == lastVisibleChildIndex;
                    StateListShapeAppearanceModel.Builder originalStateListShapeBuilder = getOriginalStateListShapeBuilder(z9, z10, i6);
                    boolean z11 = getOrientation() == 0;
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (z11) {
                        i = z9 ? 5 : 0;
                        if (z10) {
                            i |= 10;
                        }
                        if (isLayoutRtl) {
                            i = StateListShapeAppearanceModel.swapCornerPositionRtl(i);
                        }
                    } else {
                        i = z9 ? 3 : 0;
                        if (z10) {
                            i |= 12;
                        }
                    }
                    StateListShapeAppearanceModel build = originalStateListShapeBuilder.setCornerSizeOverride(this.innerCornerSize, ~i).build();
                    if (build.isStateful()) {
                        childButton.setStateListShapeAppearanceModel(build);
                    } else {
                        childButton.setShapeAppearanceModel(build.getDefaultShape(true));
                    }
                }
                i6++;
            }
        }
    }

    public MaterialButtonGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonGroupStyle);
    }

    public MaterialButtonGroup(@NonNull Context context) {
        this(context, null);
    }
}
