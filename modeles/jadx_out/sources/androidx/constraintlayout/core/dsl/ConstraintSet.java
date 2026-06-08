package androidx.constraintlayout.core.dsl;

import a4.x;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ConstraintSet {
    ArrayList<Constraint> mConstraints = new ArrayList<>();
    ArrayList<Helper> mHelpers = new ArrayList<>();
    private final String mName;

    public ConstraintSet(String str) {
        this.mName = str;
    }

    public void add(Constraint constraint) {
        this.mConstraints.add(constraint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(x.n(new StringBuilder(), this.mName, ":{\n"));
        int i = 0;
        if (!this.mConstraints.isEmpty()) {
            ArrayList<Constraint> arrayList = this.mConstraints;
            int size = arrayList.size();
            int i6 = 0;
            while (i6 < size) {
                Constraint constraint = arrayList.get(i6);
                i6++;
                sb.append(constraint.toString());
            }
        }
        if (!this.mHelpers.isEmpty()) {
            ArrayList<Helper> arrayList2 = this.mHelpers;
            int size2 = arrayList2.size();
            while (i < size2) {
                Helper helper = arrayList2.get(i);
                i++;
                sb.append(helper.toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void add(Helper helper) {
        this.mHelpers.add(helper);
    }
}
