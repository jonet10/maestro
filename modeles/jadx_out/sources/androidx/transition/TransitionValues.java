package androidx.transition;

import a4.x;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TransitionValues {

    @SuppressLint({"UnknownNullness"})
    public View view;
    public final Map<String, Object> values = new HashMap();
    final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    @NonNull
    public String toString() {
        StringBuilder u7 = x.u("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        u7.append(this.view);
        u7.append("\n");
        String concat = u7.toString().concat("    values:");
        for (String str : this.values.keySet()) {
            concat = concat + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return concat;
    }

    @Deprecated
    public TransitionValues() {
    }
}
