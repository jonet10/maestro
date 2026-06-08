package androidx.constraintlayout.core.parser;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLArray extends CLContainer {
    public CLArray(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLArray(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i6) {
        StringBuilder sb = new StringBuilder();
        String json = toJSON();
        if (i6 > 0 || json.length() + i >= CLElement.sMaxLine) {
            sb.append("[\n");
            ArrayList<CLElement> arrayList = this.mElements;
            int size = arrayList.size();
            int i10 = 0;
            boolean z9 = true;
            while (i10 < size) {
                CLElement cLElement = arrayList.get(i10);
                i10++;
                CLElement cLElement2 = cLElement;
                if (z9) {
                    z9 = false;
                } else {
                    sb.append(",\n");
                }
                addIndent(sb, CLElement.sBaseIndent + i);
                sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i, i6 - 1));
            }
            sb.append("\n");
            addIndent(sb, i);
            sb.append("]");
        } else {
            sb.append(json);
        }
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "[");
        boolean z9 = true;
        for (int i = 0; i < this.mElements.size(); i++) {
            if (z9) {
                z9 = false;
            } else {
                sb.append(", ");
            }
            sb.append(this.mElements.get(i).toJSON());
        }
        return ((Object) sb) + "]";
    }
}
