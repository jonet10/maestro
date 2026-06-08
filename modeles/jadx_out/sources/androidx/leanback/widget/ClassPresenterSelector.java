package androidx.leanback.widget;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ClassPresenterSelector extends PresenterSelector {
    private final ArrayList<Presenter> mPresenters = new ArrayList<>();
    private final HashMap<Class<?>, Object> mClassMap = new HashMap<>();

    public ClassPresenterSelector addClassPresenter(Class<?> cls, Presenter presenter) {
        this.mClassMap.put(cls, presenter);
        if (!this.mPresenters.contains(presenter)) {
            this.mPresenters.add(presenter);
        }
        return this;
    }

    public ClassPresenterSelector addClassPresenterSelector(Class<?> cls, PresenterSelector presenterSelector) {
        this.mClassMap.put(cls, presenterSelector);
        Presenter[] presenters = presenterSelector.getPresenters();
        for (int i = 0; i < presenters.length; i++) {
            if (!this.mPresenters.contains(presenters[i])) {
                this.mPresenters.add(presenters[i]);
            }
        }
        return this;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        Object obj2;
        Presenter presenter;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        do {
            obj2 = this.mClassMap.get(cls);
            if ((obj2 instanceof PresenterSelector) && (presenter = ((PresenterSelector) obj2).getPresenter(obj)) != null) {
                return presenter;
            }
            cls = cls.getSuperclass();
            if (obj2 != null) {
                break;
            }
        } while (cls != null);
        return (Presenter) obj2;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        ArrayList<Presenter> arrayList = this.mPresenters;
        return (Presenter[]) arrayList.toArray(new Presenter[arrayList.size()]);
    }
}
