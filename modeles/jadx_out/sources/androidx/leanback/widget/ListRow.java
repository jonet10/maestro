package androidx.leanback.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ListRow extends Row {
    private final ObjectAdapter mAdapter;
    private CharSequence mContentDescription;

    public ListRow(HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(headerItem);
        this.mAdapter = objectAdapter;
        verify();
    }

    private void verify() {
        if (this.mAdapter != null) {
            return;
        }
        com.google.gson.internal.a.p("ObjectAdapter cannot be null");
    }

    public final ObjectAdapter getAdapter() {
        return this.mAdapter;
    }

    public CharSequence getContentDescription() {
        CharSequence charSequence = this.mContentDescription;
        if (charSequence != null) {
            return charSequence;
        }
        HeaderItem headerItem = getHeaderItem();
        if (headerItem == null) {
            return null;
        }
        CharSequence contentDescription = headerItem.getContentDescription();
        return contentDescription != null ? contentDescription : headerItem.getName();
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
    }

    public ListRow(long j, HeaderItem headerItem, ObjectAdapter objectAdapter) {
        super(j, headerItem);
        this.mAdapter = objectAdapter;
        verify();
    }

    public ListRow(ObjectAdapter objectAdapter) {
        this.mAdapter = objectAdapter;
        verify();
    }
}
