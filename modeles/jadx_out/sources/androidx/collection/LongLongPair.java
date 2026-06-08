package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j, long j6) {
        this.first = j;
        this.second = j6;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        return longLongPair.first == this.first && longLongPair.second == this.second;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        long j = this.first;
        int i = (int) (j ^ (j >>> 32));
        long j6 = this.second;
        return i ^ ((int) ((j6 >>> 32) ^ j6));
    }

    public String toString() {
        return "(" + this.first + ", " + this.second + ')';
    }
}
