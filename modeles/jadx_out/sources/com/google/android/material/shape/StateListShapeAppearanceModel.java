package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import com.google.android.material.R;
import com.google.android.material.shape.ShapeAppearanceModel;
import j$.util.Objects;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class StateListShapeAppearanceModel {
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    private static final int INITIAL_CAPACITY = 10;

    @Nullable
    final StateListCornerSize bottomLeftCornerSizeOverride;

    @Nullable
    final StateListCornerSize bottomRightCornerSizeOverride;

    @NonNull
    final ShapeAppearanceModel defaultShape;

    @NonNull
    final ShapeAppearanceModel[] shapeAppearanceModels;
    final int stateCount;

    @NonNull
    final int[][] stateSpecs;

    @Nullable
    final StateListCornerSize topLeftCornerSizeOverride;

    @Nullable
    final StateListCornerSize topRightCornerSizeOverride;

    private StateListShapeAppearanceModel(@NonNull Builder builder) {
        this.stateCount = builder.stateCount;
        this.defaultShape = builder.defaultShape;
        this.stateSpecs = builder.stateSpecs;
        this.shapeAppearanceModels = builder.shapeAppearanceModels;
        this.topLeftCornerSizeOverride = builder.topLeftCornerSizeOverride;
        this.topRightCornerSizeOverride = builder.topRightCornerSizeOverride;
        this.bottomLeftCornerSizeOverride = builder.bottomLeftCornerSizeOverride;
        this.bottomRightCornerSizeOverride = builder.bottomRightCornerSizeOverride;
    }

    @Nullable
    public static StateListShapeAppearanceModel create(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId != 0 && Objects.equals(context.getResources().getResourceTypeName(resourceId), "xml")) {
            return new Builder(context, resourceId).build();
        }
        return null;
    }

    private int indexOfStateSet(int[] iArr) {
        int[][] iArr2 = this.stateSpecs;
        for (int i = 0; i < this.stateCount; i++) {
            if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadShapeAppearanceModelsFromItems(@NonNull Builder builder, @NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.MaterialShape) : theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, 0, 0);
                ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, obtainAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0), obtainAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0)).build();
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != R.attr.shapeAppearance && attributeNameResource != R.attr.shapeAppearanceOverlay) {
                        int i10 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i] = attributeNameResource;
                        i = i10;
                    }
                }
                builder.addStateShapeAppearanceModel(StateSet.trimStateSet(iArr, i), build);
            }
        }
    }

    public static int swapCornerPositionRtl(int i) {
        int i6 = i & 5;
        return ((i & 10) >> 1) | (i6 << 1);
    }

    @NonNull
    public ShapeAppearanceModel getDefaultShape(boolean z9) {
        if (!z9 || (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null)) {
            return this.defaultShape;
        }
        ShapeAppearanceModel.Builder builder = this.defaultShape.toBuilder();
        StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
        if (stateListCornerSize != null) {
            builder.setTopLeftCornerSize(stateListCornerSize.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
        if (stateListCornerSize2 != null) {
            builder.setTopRightCornerSize(stateListCornerSize2.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
        if (stateListCornerSize3 != null) {
            builder.setBottomLeftCornerSize(stateListCornerSize3.getDefaultCornerSize());
        }
        StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
        if (stateListCornerSize4 != null) {
            builder.setBottomRightCornerSize(stateListCornerSize4.getDefaultCornerSize());
        }
        return builder.build();
    }

    @NonNull
    public ShapeAppearanceModel getShapeForState(@NonNull int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        if (this.topLeftCornerSizeOverride == null && this.topRightCornerSizeOverride == null && this.bottomLeftCornerSizeOverride == null && this.bottomRightCornerSizeOverride == null) {
            return this.shapeAppearanceModels[indexOfStateSet];
        }
        ShapeAppearanceModel.Builder builder = this.shapeAppearanceModels[indexOfStateSet].toBuilder();
        StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
        if (stateListCornerSize != null) {
            builder.setTopLeftCornerSize(stateListCornerSize.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
        if (stateListCornerSize2 != null) {
            builder.setTopRightCornerSize(stateListCornerSize2.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
        if (stateListCornerSize3 != null) {
            builder.setBottomLeftCornerSize(stateListCornerSize3.getCornerSizeForState(iArr));
        }
        StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
        if (stateListCornerSize4 != null) {
            builder.setBottomRightCornerSize(stateListCornerSize4.getCornerSizeForState(iArr));
        }
        return builder.build();
    }

    public int getStateCount() {
        return this.stateCount;
    }

    public boolean isStateful() {
        StateListCornerSize stateListCornerSize;
        StateListCornerSize stateListCornerSize2;
        StateListCornerSize stateListCornerSize3;
        StateListCornerSize stateListCornerSize4;
        return this.stateCount > 1 || ((stateListCornerSize = this.topLeftCornerSizeOverride) != null && stateListCornerSize.isStateful()) || (((stateListCornerSize2 = this.topRightCornerSizeOverride) != null && stateListCornerSize2.isStateful()) || (((stateListCornerSize3 = this.bottomLeftCornerSizeOverride) != null && stateListCornerSize3.isStateful()) || ((stateListCornerSize4 = this.bottomRightCornerSizeOverride) != null && stateListCornerSize4.isStateful())));
    }

    @NonNull
    public Builder toBuilder() {
        return new Builder(this);
    }

    @NonNull
    public StateListShapeAppearanceModel withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return toBuilder().withTransformedCornerSizes(cornerSizeUnaryOperator).build();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Builder {

        @Nullable
        private StateListCornerSize bottomLeftCornerSizeOverride;

        @Nullable
        private StateListCornerSize bottomRightCornerSizeOverride;

        @NonNull
        private ShapeAppearanceModel defaultShape;

        @NonNull
        private ShapeAppearanceModel[] shapeAppearanceModels;
        private int stateCount;

        @NonNull
        private int[][] stateSpecs;

        @Nullable
        private StateListCornerSize topLeftCornerSizeOverride;

        @Nullable
        private StateListCornerSize topRightCornerSizeOverride;

        private Builder(@NonNull Context context, @XmlRes int i) {
            int next;
            initialize();
            try {
                XmlResourceParser xml = context.getResources().getXml(i);
                try {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                    do {
                        next = xml.next();
                        if (next == 2) {
                            break;
                        }
                    } while (next != 1);
                    if (next != 2) {
                        throw new XmlPullParserException("No start tag found");
                    }
                    if (xml.getName().equals("selector")) {
                        StateListShapeAppearanceModel.loadShapeAppearanceModelsFromItems(this, context, xml, asAttributeSet, context.getTheme());
                    }
                    xml.close();
                } catch (Throwable th) {
                    if (xml != null) {
                        try {
                            xml.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Resources.NotFoundException | IOException | XmlPullParserException unused) {
                initialize();
            }
        }

        private boolean containsFlag(int i, int i6) {
            return (i6 | i) == i;
        }

        private void growArray(int i, int i6) {
            int[][] iArr = new int[i6][];
            System.arraycopy(this.stateSpecs, 0, iArr, 0, i);
            this.stateSpecs = iArr;
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[i6];
            System.arraycopy(this.shapeAppearanceModels, 0, shapeAppearanceModelArr, 0, i);
            this.shapeAppearanceModels = shapeAppearanceModelArr;
        }

        private void initialize() {
            this.defaultShape = new ShapeAppearanceModel();
            this.stateSpecs = new int[10][];
            this.shapeAppearanceModels = new ShapeAppearanceModel[10];
        }

        @NonNull
        public Builder addStateShapeAppearanceModel(@NonNull int[] iArr, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
            int i = this.stateCount;
            if (i == 0 || iArr.length == 0) {
                this.defaultShape = shapeAppearanceModel;
            }
            if (i >= this.stateSpecs.length) {
                growArray(i, i + 10);
            }
            int[][] iArr2 = this.stateSpecs;
            int i6 = this.stateCount;
            iArr2[i6] = iArr;
            this.shapeAppearanceModels[i6] = shapeAppearanceModel;
            this.stateCount = i6 + 1;
            return this;
        }

        @Nullable
        public StateListShapeAppearanceModel build() {
            if (this.stateCount == 0) {
                return null;
            }
            return new StateListShapeAppearanceModel(this);
        }

        @NonNull
        public Builder setCornerSizeOverride(@NonNull StateListCornerSize stateListCornerSize, int i) {
            if (containsFlag(i, 1)) {
                this.topLeftCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i, 2)) {
                this.topRightCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i, 4)) {
                this.bottomLeftCornerSizeOverride = stateListCornerSize;
            }
            if (containsFlag(i, 8)) {
                this.bottomRightCornerSizeOverride = stateListCornerSize;
            }
            return this;
        }

        @NonNull
        public Builder withTransformedCornerSizes(@NonNull ShapeAppearanceModel.CornerSizeUnaryOperator cornerSizeUnaryOperator) {
            ShapeAppearanceModel[] shapeAppearanceModelArr = new ShapeAppearanceModel[this.shapeAppearanceModels.length];
            for (int i = 0; i < this.stateCount; i++) {
                shapeAppearanceModelArr[i] = this.shapeAppearanceModels[i].withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            this.shapeAppearanceModels = shapeAppearanceModelArr;
            StateListCornerSize stateListCornerSize = this.topLeftCornerSizeOverride;
            if (stateListCornerSize != null) {
                this.topLeftCornerSizeOverride = stateListCornerSize.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize2 = this.topRightCornerSizeOverride;
            if (stateListCornerSize2 != null) {
                this.topRightCornerSizeOverride = stateListCornerSize2.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize3 = this.bottomLeftCornerSizeOverride;
            if (stateListCornerSize3 != null) {
                this.bottomLeftCornerSizeOverride = stateListCornerSize3.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            StateListCornerSize stateListCornerSize4 = this.bottomRightCornerSizeOverride;
            if (stateListCornerSize4 != null) {
                this.bottomRightCornerSizeOverride = stateListCornerSize4.withTransformedCornerSizes(cornerSizeUnaryOperator);
            }
            return this;
        }

        public Builder(@NonNull StateListShapeAppearanceModel stateListShapeAppearanceModel) {
            int i = stateListShapeAppearanceModel.stateCount;
            this.stateCount = i;
            this.defaultShape = stateListShapeAppearanceModel.defaultShape;
            int[][] iArr = stateListShapeAppearanceModel.stateSpecs;
            int[][] iArr2 = new int[iArr.length][];
            this.stateSpecs = iArr2;
            this.shapeAppearanceModels = new ShapeAppearanceModel[stateListShapeAppearanceModel.shapeAppearanceModels.length];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(stateListShapeAppearanceModel.shapeAppearanceModels, 0, this.shapeAppearanceModels, 0, this.stateCount);
            this.topLeftCornerSizeOverride = stateListShapeAppearanceModel.topLeftCornerSizeOverride;
            this.topRightCornerSizeOverride = stateListShapeAppearanceModel.topRightCornerSizeOverride;
            this.bottomLeftCornerSizeOverride = stateListShapeAppearanceModel.bottomLeftCornerSizeOverride;
            this.bottomRightCornerSizeOverride = stateListShapeAppearanceModel.bottomRightCornerSizeOverride;
        }

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
            initialize();
            addStateShapeAppearanceModel(StateSet.WILD_CARD, shapeAppearanceModel);
        }
    }
}
