package androidx.leanback.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Row {
    private static final int FLAG_ID_USE_HEADER = 1;
    private static final int FLAG_ID_USE_ID = 0;
    private static final int FLAG_ID_USE_MASK = 1;
    private HeaderItem mHeaderItem;
    private int mFlags = 1;
    private long mId = -1;

    public Row(long j, HeaderItem headerItem) {
        setId(j);
        setHeaderItem(headerItem);
    }

    public final int getFlags() {
        return this.mFlags;
    }

    public final HeaderItem getHeaderItem() {
        return this.mHeaderItem;
    }

    public final long getId() {
        if ((this.mFlags & 1) != 1) {
            return this.mId;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem != null) {
            return headerItem.getId();
        }
        return -1L;
    }

    public boolean isRenderedAsRowView() {
        return true;
    }

    public final void setFlags(int i, int i6) {
        this.mFlags = (i & i6) | (this.mFlags & (~i6));
    }

    public final void setHeaderItem(HeaderItem headerItem) {
        this.mHeaderItem = headerItem;
    }

    public final void setId(long j) {
        this.mId = j;
        setFlags(0, 1);
    }

    public Row(HeaderItem headerItem) {
        setHeaderItem(headerItem);
    }

    public Row() {
    }
}
