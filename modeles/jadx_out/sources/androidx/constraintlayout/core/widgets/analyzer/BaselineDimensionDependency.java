package androidx.constraintlayout.core.widgets.analyzer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class BaselineDimensionDependency extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        WidgetRun widgetRun = this.mRun;
        ((VerticalWidgetRun) widgetRun).baseline.mMargin = widgetRun.mWidget.getBaselineDistance();
        this.resolved = true;
    }
}
