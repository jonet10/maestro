package c4;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonGroup;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k1 implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1778a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1779b;

    public /* synthetic */ k1(Object obj, int i) {
        this.f1778a = i;
        this.f1779b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int lambda$new$0;
        switch (this.f1778a) {
            case 1:
                lambda$new$0 = ((MaterialButtonGroup) this.f1779b).lambda$new$0((MaterialButton) obj, (MaterialButton) obj2);
                break;
        }
        return ((Number) ((j1) this.f1779b).invoke(obj, obj2)).intValue();
    }
}
