package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class KeyFrames {
    ArrayList<Keys> mKeys = new ArrayList<>();

    public void add(Keys keys) {
        this.mKeys.add(keys);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.mKeys.isEmpty()) {
            sb.append("keyFrames:{\n");
            ArrayList<Keys> arrayList = this.mKeys;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Keys keys = arrayList.get(i);
                i++;
                sb.append(keys.toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
