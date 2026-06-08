package androidx.constraintlayout.core.parser;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLToken extends CLElement {
    int mIndex;
    char[] mTokenFalse;
    char[] mTokenNull;
    char[] mTokenTrue;
    Type mType;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum Type {
        UNKNOWN,
        TRUE,
        FALSE,
        NULL
    }

    public CLToken(char[] cArr) {
        super(cArr);
        this.mIndex = 0;
        this.mType = Type.UNKNOWN;
        this.mTokenTrue = "true".toCharArray();
        this.mTokenFalse = "false".toCharArray();
        this.mTokenNull = "null".toCharArray();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLToken(cArr);
    }

    public boolean getBoolean() throws CLParsingException {
        Type type = this.mType;
        if (type == Type.TRUE) {
            return true;
        }
        if (type == Type.FALSE) {
            return false;
        }
        throw new CLParsingException("this token is not a boolean: <" + content() + ">", this);
    }

    public Type getType() {
        return this.mType;
    }

    public boolean isNull() throws CLParsingException {
        if (this.mType == Type.NULL) {
            return true;
        }
        throw new CLParsingException("this token is not a null: <" + content() + ">", this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i6) {
        StringBuilder sb = new StringBuilder();
        addIndent(sb, i);
        sb.append(content());
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        if (!CLParser.sDebug) {
            return content();
        }
        return "<" + content() + ">";
    }

    public boolean validate(char c9, long j) {
        int ordinal = this.mType.ordinal();
        if (ordinal == 0) {
            char[] cArr = this.mTokenTrue;
            int i = this.mIndex;
            if (cArr[i] == c9) {
                this.mType = Type.TRUE;
            } else if (this.mTokenFalse[i] == c9) {
                this.mType = Type.FALSE;
            } else if (this.mTokenNull[i] == c9) {
                this.mType = Type.NULL;
            }
            r2 = true;
        } else if (ordinal == 1) {
            char[] cArr2 = this.mTokenTrue;
            int i6 = this.mIndex;
            r2 = cArr2[i6] == c9;
            if (r2 && i6 + 1 == cArr2.length) {
                setEnd(j);
            }
        } else if (ordinal == 2) {
            char[] cArr3 = this.mTokenFalse;
            int i10 = this.mIndex;
            r2 = cArr3[i10] == c9;
            if (r2 && i10 + 1 == cArr3.length) {
                setEnd(j);
            }
        } else if (ordinal == 3) {
            char[] cArr4 = this.mTokenNull;
            int i11 = this.mIndex;
            r2 = cArr4[i11] == c9;
            if (r2 && i11 + 1 == cArr4.length) {
                setEnd(j);
            }
        }
        this.mIndex++;
        return r2;
    }
}
