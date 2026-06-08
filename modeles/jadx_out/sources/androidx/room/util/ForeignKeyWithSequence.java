package androidx.room.util;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
    private final String from;
    private final int id;
    private final int sequence;
    private final String to;

    public ForeignKeyWithSequence(int i, int i6, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.id = i;
        this.sequence = i6;
        this.from = str;
        this.to = str2;
    }

    @Override // java.lang.Comparable
    public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
        foreignKeyWithSequence.getClass();
        int i = this.id - foreignKeyWithSequence.id;
        return i == 0 ? this.sequence - foreignKeyWithSequence.sequence : i;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSequence() {
        return this.sequence;
    }

    public final String getTo() {
        return this.to;
    }
}
