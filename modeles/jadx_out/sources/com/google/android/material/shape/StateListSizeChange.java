package com.google.android.material.shape;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import com.google.android.material.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class StateListSizeChange {
    private static final int INITIAL_CAPACITY = 10;

    @NonNull
    private SizeChange defaultSizeChange;
    int stateCount;

    @NonNull
    int[][] stateSpecs = new int[10][];

    @NonNull
    SizeChange[] sizeChanges = new SizeChange[10];

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SizeChangeAmount {
        float amount;
        SizeChangeType type;

        public SizeChangeAmount(SizeChangeType sizeChangeType, float f) {
            this.type = sizeChangeType;
            this.amount = f;
        }

        public int getChange(@Px int i) {
            SizeChangeType sizeChangeType = this.type;
            if (sizeChangeType == SizeChangeType.PERCENT) {
                return (int) (this.amount * i);
            }
            if (sizeChangeType == SizeChangeType.PIXELS) {
                return (int) this.amount;
            }
            return 0;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum SizeChangeType {
        PERCENT,
        PIXELS
    }

    private void addStateSizeChange(@NonNull int[] iArr, @NonNull SizeChange sizeChange) {
        int i = this.stateCount;
        if (i == 0 || iArr.length == 0) {
            this.defaultSizeChange = sizeChange;
        }
        if (i >= this.stateSpecs.length) {
            growArray(i, i + 10);
        }
        int[][] iArr2 = this.stateSpecs;
        int i6 = this.stateCount;
        iArr2[i6] = iArr;
        this.sizeChanges[i6] = sizeChange;
        this.stateCount = i6 + 1;
    }

    @Nullable
    public static StateListSizeChange create(@NonNull Context context, @NonNull TypedArray typedArray, @StyleableRes int i) {
        int next;
        int resourceId = typedArray.getResourceId(i, 0);
        if (resourceId == 0 || !context.getResources().getResourceTypeName(resourceId).equals("xml")) {
            return null;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(resourceId);
            try {
                StateListSizeChange stateListSizeChange = new StateListSizeChange();
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
                    stateListSizeChange.loadSizeChangeFromItems(context, xml, asAttributeSet, context.getTheme());
                }
                xml.close();
                return stateListSizeChange;
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
            return null;
        }
    }

    @Nullable
    private SizeChangeAmount getSizeChangeAmount(@NonNull TypedArray typedArray, int i, @Nullable SizeChangeAmount sizeChangeAmount) {
        TypedValue peekValue = typedArray.peekValue(i);
        if (peekValue != null) {
            int i6 = peekValue.type;
            if (i6 == 5) {
                return new SizeChangeAmount(SizeChangeType.PIXELS, TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i6 == 6) {
                return new SizeChangeAmount(SizeChangeType.PERCENT, peekValue.getFraction(1.0f, 1.0f));
            }
        }
        return sizeChangeAmount;
    }

    private void growArray(int i, int i6) {
        int[][] iArr = new int[i6][];
        System.arraycopy(this.stateSpecs, 0, iArr, 0, i);
        this.stateSpecs = iArr;
        SizeChange[] sizeChangeArr = new SizeChange[i6];
        System.arraycopy(this.sizeChanges, 0, sizeChangeArr, 0, i);
        this.sizeChanges = sizeChangeArr;
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

    private void loadSizeChangeFromItems(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
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
                TypedArray obtainAttributes = theme == null ? context.getResources().obtainAttributes(attributeSet, R.styleable.StateListSizeChange) : theme.obtainStyledAttributes(attributeSet, R.styleable.StateListSizeChange, 0, 0);
                SizeChangeAmount sizeChangeAmount = getSizeChangeAmount(obtainAttributes, R.styleable.StateListSizeChange_widthChange, null);
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr = new int[attributeCount];
                int i = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != R.attr.widthChange) {
                        int i10 = i + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr[i] = attributeNameResource;
                        i = i10;
                    }
                }
                addStateSizeChange(StateSet.trimStateSet(iArr, i), new SizeChange(sizeChangeAmount));
            }
        }
    }

    @NonNull
    public SizeChange getDefaultSizeChange() {
        return this.defaultSizeChange;
    }

    public int getMaxWidthChange(@Px int i) {
        float max;
        int i6 = -i;
        for (int i10 = 0; i10 < this.stateCount; i10++) {
            SizeChangeAmount sizeChangeAmount = this.sizeChanges[i10].widthChange;
            SizeChangeType sizeChangeType = sizeChangeAmount.type;
            if (sizeChangeType == SizeChangeType.PIXELS) {
                max = Math.max(i6, sizeChangeAmount.amount);
            } else if (sizeChangeType == SizeChangeType.PERCENT) {
                max = Math.max(i6, i * sizeChangeAmount.amount);
            }
            i6 = (int) max;
        }
        return i6;
    }

    @NonNull
    public SizeChange getSizeChangeForState(@NonNull int[] iArr) {
        int indexOfStateSet = indexOfStateSet(iArr);
        if (indexOfStateSet < 0) {
            indexOfStateSet = indexOfStateSet(StateSet.WILD_CARD);
        }
        return indexOfStateSet < 0 ? this.defaultSizeChange : this.sizeChanges[indexOfStateSet];
    }

    public boolean isStateful() {
        return this.stateCount > 1;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SizeChange {

        @Nullable
        public SizeChangeAmount widthChange;

        public SizeChange(@NonNull SizeChange sizeChange) {
            SizeChangeAmount sizeChangeAmount = sizeChange.widthChange;
            this.widthChange = new SizeChangeAmount(sizeChangeAmount.type, sizeChangeAmount.amount);
        }

        public SizeChange(@Nullable SizeChangeAmount sizeChangeAmount) {
            this.widthChange = sizeChangeAmount;
        }
    }
}
