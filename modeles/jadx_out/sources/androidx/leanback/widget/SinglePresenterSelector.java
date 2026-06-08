package androidx.leanback.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SinglePresenterSelector extends PresenterSelector {
    private final Presenter mPresenter;

    public SinglePresenterSelector(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        return this.mPresenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        return new Presenter[]{this.mPresenter};
    }
}
