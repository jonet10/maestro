package androidx.constraintlayout.core.parser;

import a4.x;
import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLElement implements Cloneable {
    protected static int sBaseIndent = 2;
    protected static int sMaxLine = 80;
    protected CLContainer mContainer;
    private final char[] mContent;
    private int mLine;
    protected long mStart = -1;
    protected long mEnd = LocationRequestCompat.PASSIVE_INTERVAL;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public void addIndent(StringBuilder sb, int i) {
        for (int i6 = 0; i6 < i; i6++) {
            sb.append(' ');
        }
    }

    @Override // 
    @NonNull
    /* renamed from: clone */
    public CLElement mo34clone() {
        try {
            return (CLElement) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public String content() {
        String str = new String(this.mContent);
        if (str.length() < 1) {
            return "";
        }
        long j = this.mEnd;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j6 = this.mStart;
            if (j >= j6) {
                return str.substring((int) j6, ((int) j) + 1);
            }
        }
        long j10 = this.mStart;
        return str.substring((int) j10, ((int) j10) + 1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CLElement)) {
            return false;
        }
        CLElement cLElement = (CLElement) obj;
        if (this.mStart == cLElement.mStart && this.mEnd == cLElement.mEnd && this.mLine == cLElement.mLine && Arrays.equals(this.mContent, cLElement.mContent)) {
            return Objects.equals(this.mContainer, cLElement.mContainer);
        }
        return false;
    }

    public CLElement getContainer() {
        return this.mContainer;
    }

    public String getDebugName() {
        if (!CLParser.sDebug) {
            return "";
        }
        return getStrClass() + " -> ";
    }

    public long getEnd() {
        return this.mEnd;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.mLine;
    }

    public long getStart() {
        return this.mStart;
    }

    public String getStrClass() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public boolean hasContent() {
        char[] cArr = this.mContent;
        return cArr != null && cArr.length >= 1;
    }

    public int hashCode() {
        int hashCode = Arrays.hashCode(this.mContent) * 31;
        long j = this.mStart;
        int i = (hashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j6 = this.mEnd;
        int i6 = (i + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        CLContainer cLContainer = this.mContainer;
        return ((i6 + (cLContainer != null ? cLContainer.hashCode() : 0)) * 31) + this.mLine;
    }

    public boolean isDone() {
        return this.mEnd != LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public boolean isStarted() {
        return this.mStart > -1;
    }

    public boolean notStarted() {
        return this.mStart == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.mContainer = cLContainer;
    }

    public void setEnd(long j) {
        if (this.mEnd != LocationRequestCompat.PASSIVE_INTERVAL) {
            return;
        }
        this.mEnd = j;
        if (CLParser.sDebug) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        CLContainer cLContainer = this.mContainer;
        if (cLContainer != null) {
            cLContainer.add(this);
        }
    }

    public void setLine(int i) {
        this.mLine = i;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public String toFormattedJSON(int i, int i6) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long j = this.mStart;
        long j6 = this.mEnd;
        if (j > j6 || j6 == LocationRequestCompat.PASSIVE_INTERVAL) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass());
            sb.append(" (INVALID, ");
            sb.append(this.mStart);
            sb.append("-");
            return x.l(sb, this.mEnd, ")");
        }
        return getStrClass() + " (" + this.mStart + " : " + this.mEnd + ") <<" + new String(this.mContent).substring((int) this.mStart, ((int) this.mEnd) + 1) + ">>";
    }
}
