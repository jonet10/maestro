package androidx.constraintlayout.core.widgets.analyzer;

import a4.x;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int mDirection;
    WidgetRun mFirstRun;
    int mGroupIndex;
    WidgetRun mLastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> mRuns = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i) {
        this.mFirstRun = null;
        this.mLastRun = null;
        int i6 = index;
        this.mGroupIndex = i6;
        index = i6 + 1;
        this.mFirstRun = widgetRun;
        this.mLastRun = widgetRun;
        this.mDirection = i;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.mWidget.isTerminalWidget[i]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.mDependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).mRun) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList = ((ChainRun) widgetRun).mWidgets;
                    int size = arrayList.size();
                    int i6 = 0;
                    while (i6 < size) {
                        WidgetRun widgetRun4 = arrayList.get(i6);
                        i6++;
                        defineTerminalWidget(widgetRun4, i);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode2.mRun, i);
            }
        }
        for (Dependency dependency2 : widgetRun.end.mDependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).mRun) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    ArrayList<WidgetRun> arrayList2 = ((ChainRun) widgetRun).mWidgets;
                    int size2 = arrayList2.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        WidgetRun widgetRun5 = arrayList2.get(i10);
                        i10++;
                        defineTerminalWidget(widgetRun5, i);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.mWidget.isTerminalWidget[i] = false;
                }
                defineTerminalWidget(dependencyNode.mRun, i);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.mDependencies.size();
        long j6 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.mDependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j6 = Math.min(j6, traverseEnd(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.end) {
            return j6;
        }
        long wrapDimension = j - widgetRun.getWrapDimension();
        return Math.min(Math.min(j6, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.mMargin);
    }

    private long traverseStart(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.mRun;
        if (widgetRun instanceof HelperReferences) {
            return j;
        }
        int size = dependencyNode.mDependencies.size();
        long j6 = j;
        for (int i = 0; i < size; i++) {
            Dependency dependency = dependencyNode.mDependencies.get(i);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.mRun != widgetRun) {
                    j6 = Math.max(j6, traverseStart(dependencyNode2, dependencyNode2.mMargin + j));
                }
            }
        }
        if (dependencyNode != widgetRun.start) {
            return j6;
        }
        long wrapDimension = j + widgetRun.getWrapDimension();
        return Math.max(Math.max(j6, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.mMargin);
    }

    public void add(WidgetRun widgetRun) {
        this.mRuns.add(widgetRun);
        this.mLastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        WidgetRun widgetRun = this.mFirstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i == 0 ? constraintWidgetContainer.mHorizontalRun : constraintWidgetContainer.mVerticalRun).start;
        DependencyNode dependencyNode2 = (i == 0 ? constraintWidgetContainer.mHorizontalRun : constraintWidgetContainer.mVerticalRun).end;
        boolean contains = widgetRun.start.mTargets.contains(dependencyNode);
        boolean contains2 = this.mFirstRun.end.mTargets.contains(dependencyNode2);
        long wrapDimension = this.mFirstRun.getWrapDimension();
        if (!contains || !contains2) {
            if (contains) {
                return Math.max(traverseStart(this.mFirstRun.start, r12.mMargin), this.mFirstRun.start.mMargin + wrapDimension);
            }
            WidgetRun widgetRun2 = this.mFirstRun;
            if (!contains2) {
                return (widgetRun2.getWrapDimension() + widgetRun2.start.mMargin) - this.mFirstRun.end.mMargin;
            }
            return Math.max(-traverseEnd(widgetRun2.end, r12.mMargin), (-this.mFirstRun.end.mMargin) + wrapDimension);
        }
        long traverseStart = traverseStart(this.mFirstRun.start, 0L);
        long traverseEnd = traverseEnd(this.mFirstRun.end, 0L);
        long j = traverseStart - wrapDimension;
        WidgetRun widgetRun3 = this.mFirstRun;
        int i6 = widgetRun3.end.mMargin;
        if (j >= (-i6)) {
            j += i6;
        }
        int i10 = widgetRun3.start.mMargin;
        long j6 = ((-traverseEnd) - wrapDimension) - i10;
        if (j6 >= i10) {
            j6 -= i10;
        }
        float biasPercent = widgetRun3.mWidget.getBiasPercent(i);
        float f = biasPercent > 0.0f ? (long) ((j / (1.0f - biasPercent)) + (j6 / biasPercent)) : 0L;
        long f10 = ((long) ((f * biasPercent) + 0.5f)) + wrapDimension + ((long) x.f(1.0f, biasPercent, f, 0.5f));
        WidgetRun widgetRun4 = this.mFirstRun;
        return (widgetRun4.start.mMargin + f10) - widgetRun4.end.mMargin;
    }

    public void defineTerminalWidgets(boolean z9, boolean z10) {
        if (z9) {
            WidgetRun widgetRun = this.mFirstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z10) {
            WidgetRun widgetRun2 = this.mFirstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
