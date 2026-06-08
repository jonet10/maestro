package androidx.constraintlayout.core.motion.utils;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TypedBundle {
    private static final int INITIAL_BOOLEAN = 4;
    private static final int INITIAL_FLOAT = 10;
    private static final int INITIAL_INT = 10;
    private static final int INITIAL_STRING = 5;
    int[] mTypeInt = new int[10];
    int[] mValueInt = new int[10];
    int mCountInt = 0;
    int[] mTypeFloat = new int[10];
    float[] mValueFloat = new float[10];
    int mCountFloat = 0;
    int[] mTypeString = new int[5];
    String[] mValueString = new String[5];
    int mCountString = 0;
    int[] mTypeBoolean = new int[4];
    boolean[] mValueBoolean = new boolean[4];
    int mCountBoolean = 0;

    public void add(int i, String str) {
        int i6 = this.mCountString;
        int[] iArr = this.mTypeString;
        if (i6 >= iArr.length) {
            this.mTypeString = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.mValueString;
            this.mValueString = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.mTypeString;
        int i10 = this.mCountString;
        iArr2[i10] = i;
        String[] strArr2 = this.mValueString;
        this.mCountString = i10 + 1;
        strArr2[i10] = str;
    }

    public void addIfNotNull(int i, String str) {
        if (str != null) {
            add(i, str);
        }
    }

    public void applyDelta(TypedValues typedValues) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedValues.setValue(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i6 = 0; i6 < this.mCountFloat; i6++) {
            typedValues.setValue(this.mTypeFloat[i6], this.mValueFloat[i6]);
        }
        for (int i10 = 0; i10 < this.mCountString; i10++) {
            typedValues.setValue(this.mTypeString[i10], this.mValueString[i10]);
        }
        for (int i11 = 0; i11 < this.mCountBoolean; i11++) {
            typedValues.setValue(this.mTypeBoolean[i11], this.mValueBoolean[i11]);
        }
    }

    public void clear() {
        this.mCountBoolean = 0;
        this.mCountString = 0;
        this.mCountFloat = 0;
        this.mCountInt = 0;
    }

    public int getInteger(int i) {
        for (int i6 = 0; i6 < this.mCountInt; i6++) {
            if (this.mTypeInt[i6] == i) {
                return this.mValueInt[i6];
            }
        }
        return -1;
    }

    public String toString() {
        return "TypedBundle{mCountInt=" + this.mCountInt + ", mCountFloat=" + this.mCountFloat + ", mCountString=" + this.mCountString + ", mCountBoolean=" + this.mCountBoolean + '}';
    }

    public void add(int i, float f) {
        int i6 = this.mCountFloat;
        int[] iArr = this.mTypeFloat;
        if (i6 >= iArr.length) {
            this.mTypeFloat = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValueFloat;
            this.mValueFloat = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTypeFloat;
        int i10 = this.mCountFloat;
        iArr2[i10] = i;
        float[] fArr2 = this.mValueFloat;
        this.mCountFloat = i10 + 1;
        fArr2[i10] = f;
    }

    public void add(int i, int i6) {
        int i10 = this.mCountInt;
        int[] iArr = this.mTypeInt;
        if (i10 >= iArr.length) {
            this.mTypeInt = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.mValueInt;
            this.mValueInt = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.mTypeInt;
        int i11 = this.mCountInt;
        iArr3[i11] = i;
        int[] iArr4 = this.mValueInt;
        this.mCountInt = i11 + 1;
        iArr4[i11] = i6;
    }

    public void add(int i, boolean z9) {
        int i6 = this.mCountBoolean;
        int[] iArr = this.mTypeBoolean;
        if (i6 >= iArr.length) {
            this.mTypeBoolean = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.mValueBoolean;
            this.mValueBoolean = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.mTypeBoolean;
        int i10 = this.mCountBoolean;
        iArr2[i10] = i;
        boolean[] zArr2 = this.mValueBoolean;
        this.mCountBoolean = i10 + 1;
        zArr2[i10] = z9;
    }

    public void applyDelta(TypedBundle typedBundle) {
        for (int i = 0; i < this.mCountInt; i++) {
            typedBundle.add(this.mTypeInt[i], this.mValueInt[i]);
        }
        for (int i6 = 0; i6 < this.mCountFloat; i6++) {
            typedBundle.add(this.mTypeFloat[i6], this.mValueFloat[i6]);
        }
        for (int i10 = 0; i10 < this.mCountString; i10++) {
            typedBundle.add(this.mTypeString[i10], this.mValueString[i10]);
        }
        for (int i11 = 0; i11 < this.mCountBoolean; i11++) {
            typedBundle.add(this.mTypeBoolean[i11], this.mValueBoolean[i11]);
        }
    }
}
