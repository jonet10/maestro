package androidx.constraintlayout.core.parser;

import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLNumber extends CLElement {
    float mValue;

    public CLNumber(char[] cArr) {
        super(cArr);
        this.mValue = Float.NaN;
    }

    public static CLElement allocate(char[] cArr) {
        return new CLNumber(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLNumber) {
            float f = getFloat();
            float f10 = ((CLNumber) obj).getFloat();
            if ((Float.isNaN(f) && Float.isNaN(f10)) || f == f10) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public float getFloat() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Float.parseFloat(content());
        }
        return this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int getInt() {
        if (Float.isNaN(this.mValue) && hasContent()) {
            this.mValue = Integer.parseInt(content());
        }
        return (int) this.mValue;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        float f = this.mValue;
        return hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }

    public boolean isInt() {
        float f = getFloat();
        return ((float) ((int) f)) == f;
    }

    public void putValue(float f) {
        this.mValue = f;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        float f = getFloat();
        int i10 = (int) f;
        if (i10 == f) {
            sb.append(i10);
        } else {
            sb.append(f);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        float f = getFloat();
        int i = (int) f;
        if (i == f) {
            return l.u(i, "");
        }
        return "" + f;
    }

    public CLNumber(float f) {
        super(null);
        this.mValue = f;
    }
}
