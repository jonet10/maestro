package androidx.constraintlayout.core.parser;

import a4.x;
import androidx.annotation.NonNull;
import androidx.lifecycle.l;
import j$.util.Objects;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLContainer extends CLElement {
    ArrayList<CLElement> mElements;

    public CLContainer(char[] cArr) {
        super(cArr);
        this.mElements = new ArrayList<>();
    }

    public static CLElement allocate(char[] cArr) {
        return new CLContainer(cArr);
    }

    public void add(CLElement cLElement) {
        this.mElements.add(cLElement);
        if (CLParser.sDebug) {
            System.out.println("added element " + cLElement + " to " + this);
        }
    }

    public void clear() {
        this.mElements.clear();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    @NonNull
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CLContainer mo34clone() {
        CLContainer cLContainer = (CLContainer) super.mo34clone();
        ArrayList<CLElement> arrayList = new ArrayList<>(this.mElements.size());
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList2.get(i);
            i++;
            CLElement mo34clone = cLElement.mo34clone();
            mo34clone.setContainer(cLContainer);
            arrayList.add(mo34clone);
        }
        cLContainer.mElements = arrayList;
        return cLContainer;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CLContainer) {
            return this.mElements.equals(((CLContainer) obj).mElements);
        }
        return false;
    }

    public CLElement get(String str) throws CLParsingException {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList.get(i);
            i++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        throw new CLParsingException(l.w("no element for key <", str, ">"), this);
    }

    public CLArray getArray(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        StringBuilder v = x.v("no array found for key <", str, ">, found [");
        v.append(cLElement.getStrClass());
        v.append("] : ");
        v.append(cLElement);
        throw new CLParsingException(v.toString(), this);
    }

    public CLArray getArrayOrCreate(String str) {
        CLArray arrayOrNull = getArrayOrNull(str);
        if (arrayOrNull != null) {
            return arrayOrNull;
        }
        CLArray cLArray = new CLArray(new char[0]);
        put(str, cLArray);
        return cLArray;
    }

    public CLArray getArrayOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLArray) {
            return (CLArray) orNull;
        }
        return null;
    }

    public boolean getBoolean(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        StringBuilder v = x.v("no boolean found for key <", str, ">, found [");
        v.append(cLElement.getStrClass());
        v.append("] : ");
        v.append(cLElement);
        throw new CLParsingException(v.toString(), this);
    }

    public float getFloat(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        StringBuilder v = x.v("no float found for key <", str, ">, found [");
        v.append(cLElement.getStrClass());
        v.append("] : ");
        v.append(cLElement);
        throw new CLParsingException(v.toString(), this);
    }

    public float getFloatOrNaN(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLNumber) {
            return orNull.getFloat();
        }
        return Float.NaN;
    }

    public int getInt(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        StringBuilder v = x.v("no int found for key <", str, ">, found [");
        v.append(cLElement.getStrClass());
        v.append("] : ");
        v.append(cLElement);
        throw new CLParsingException(v.toString(), this);
    }

    public CLObject getObject(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        StringBuilder v = x.v("no object found for key <", str, ">, found [");
        v.append(cLElement.getStrClass());
        v.append("] : ");
        v.append(cLElement);
        throw new CLParsingException(v.toString(), this);
    }

    public CLObject getObjectOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLObject) {
            return (CLObject) orNull;
        }
        return null;
    }

    public CLElement getOrNull(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList.get(i);
            i++;
            CLKey cLKey = (CLKey) cLElement;
            if (cLKey.content().equals(str)) {
                return cLKey.getValue();
            }
        }
        return null;
    }

    public String getString(String str) throws CLParsingException {
        CLElement cLElement = get(str);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException("no string found for key <" + str + ">, found [" + (cLElement != null ? cLElement.getStrClass() : null) + "] : " + cLElement, this);
    }

    public String getStringOrNull(String str) {
        CLElement orNull = getOrNull(str);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public boolean has(String str) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList.get(i);
            i++;
            CLElement cLElement2 = cLElement;
            if ((cLElement2 instanceof CLKey) && ((CLKey) cLElement2).content().equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public int hashCode() {
        return Objects.hash(this.mElements, Integer.valueOf(super.hashCode()));
    }

    public ArrayList<String> names() {
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList2.get(i);
            i++;
            CLElement cLElement2 = cLElement;
            if (cLElement2 instanceof CLKey) {
                arrayList.add(((CLKey) cLElement2).content());
            }
        }
        return arrayList;
    }

    public void put(String str, CLElement cLElement) {
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement2 = arrayList.get(i);
            i++;
            CLKey cLKey = (CLKey) cLElement2;
            if (cLKey.content().equals(str)) {
                cLKey.set(cLElement);
                return;
            }
        }
        this.mElements.add((CLKey) CLKey.allocate(str, cLElement));
    }

    public void putNumber(String str, float f) {
        put(str, new CLNumber(f));
    }

    public void putString(String str, String str2) {
        CLString cLString = new CLString(str2.toCharArray());
        cLString.setStart(0L);
        cLString.setEnd(str2.length() - 1);
        put(str, cLString);
    }

    public void remove(String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<CLElement> arrayList2 = this.mElements;
        int size = arrayList2.size();
        int i = 0;
        int i6 = 0;
        while (i6 < size) {
            CLElement cLElement = arrayList2.get(i6);
            i6++;
            CLElement cLElement2 = cLElement;
            if (((CLKey) cLElement2).content().equals(str)) {
                arrayList.add(cLElement2);
            }
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            this.mElements.remove((CLElement) obj);
        }
    }

    public int size() {
        return this.mElements.size();
    }

    @Override // androidx.constraintlayout.core.parser.CLElement
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ArrayList<CLElement> arrayList = this.mElements;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            CLElement cLElement = arrayList.get(i);
            i++;
            CLElement cLElement2 = cLElement;
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append(cLElement2);
        }
        return super.toString() + " = <" + ((Object) sb) + " >";
    }

    public String getStringOrNull(int i) {
        CLElement orNull = getOrNull(i);
        if (orNull instanceof CLString) {
            return orNull.content();
        }
        return null;
    }

    public CLElement getOrNull(int i) {
        if (i < 0 || i >= this.mElements.size()) {
            return null;
        }
        return this.mElements.get(i);
    }

    public CLArray getArray(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLArray) {
            return (CLArray) cLElement;
        }
        throw new CLParsingException(l.u(i, "no array at index "), this);
    }

    public float getFloat(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement != null) {
            return cLElement.getFloat();
        }
        throw new CLParsingException(l.u(i, "no float at index "), this);
    }

    public int getInt(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement != null) {
            return cLElement.getInt();
        }
        throw new CLParsingException(l.u(i, "no int at index "), this);
    }

    public CLObject getObject(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLObject) {
            return (CLObject) cLElement;
        }
        throw new CLParsingException(l.u(i, "no object at index "), this);
    }

    public CLElement get(int i) throws CLParsingException {
        if (i >= 0 && i < this.mElements.size()) {
            return this.mElements.get(i);
        }
        throw new CLParsingException(l.u(i, "no element at index "), this);
    }

    public boolean getBoolean(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLToken) {
            return ((CLToken) cLElement).getBoolean();
        }
        throw new CLParsingException(l.u(i, "no boolean at index "), this);
    }

    public String getString(int i) throws CLParsingException {
        CLElement cLElement = get(i);
        if (cLElement instanceof CLString) {
            return cLElement.content();
        }
        throw new CLParsingException(l.u(i, "no string at index "), this);
    }
}
