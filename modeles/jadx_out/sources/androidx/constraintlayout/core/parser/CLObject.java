package androidx.constraintlayout.core.parser;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLObject extends CLContainer implements Iterable<CLKey> {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class CLObjectIterator implements Iterator<CLKey> {
        int mIndex = 0;
        CLObject mObject;

        public CLObjectIterator(CLObject cLObject) {
            this.mObject = cLObject;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.mIndex < this.mObject.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CLKey next() {
            CLKey cLKey = (CLKey) this.mObject.mElements.get(this.mIndex);
            this.mIndex++;
            return cLKey;
        }
    }

    public CLObject(char[] cArr) {
        super(cArr);
    }

    public static CLObject allocate(char[] cArr) {
        return new CLObject(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.CLContainer, androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* renamed from: clone */
    public CLObject mo34clone() {
        return (CLObject) super.mo34clone();
    }

    @Override // java.lang.Iterable
    public Iterator<CLKey> iterator() {
        return new CLObjectIterator(this);
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toFormattedJSON(int i, int i6) {
        StringBuilder sb = new StringBuilder(getDebugName());
        sb.append("{\n");
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        boolean z9 = true;
        int i10 = 0;
        while (i10 < size) {
            CLElement cLElement = arrayList.get(i10);
            i10++;
            CLElement cLElement2 = cLElement;
            if (z9) {
                z9 = false;
            } else {
                sb.append(",\n");
            }
            sb.append(cLElement2.toFormattedJSON(CLElement.sBaseIndent + i, i6 - 1));
        }
        sb.append("\n");
        addIndent(sb, i);
        sb.append("}");
        return sb.toString();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toJSON() {
        StringBuilder sb = new StringBuilder(getDebugName() + "{ ");
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        boolean z9 = true;
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList.get(i);
            i++;
            CLElement cLElement2 = cLElement;
            if (z9) {
                z9 = false;
            } else {
                sb.append(", ");
            }
            sb.append(cLElement2.toJSON());
        }
        sb.append(" }");
        return sb.toString();
    }

    public String toFormattedJSON() {
        return toFormattedJSON(0, 0);
    }
}
