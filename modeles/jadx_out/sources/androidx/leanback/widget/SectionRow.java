package androidx.leanback.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SectionRow extends Row {
    public SectionRow(long j, String str) {
        super(new HeaderItem(j, str));
    }

    @Override // androidx.leanback.widget.Row
    public final boolean isRenderedAsRowView() {
        return false;
    }

    public SectionRow(HeaderItem headerItem) {
        super(headerItem);
    }

    public SectionRow(String str) {
        super(new HeaderItem(str));
    }
}
