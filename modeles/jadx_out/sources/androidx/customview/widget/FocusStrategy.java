package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.internal.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class FocusStrategy {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface BoundsAdapter<T> {
        void obtainBounds(T t9, Rect rect);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface CollectionAdapter<T, V> {
        V get(T t9, int i);

        int size(T t9);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z9, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z9;
            this.mAdapter = boundsAdapter;
        }

        @Override // java.util.Comparator
        public int compare(T t9, T t10) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t9, rect);
            this.mAdapter.obtainBounds(t10, rect2);
            int i = rect.top;
            int i6 = rect2.top;
            if (i < i6) {
                return -1;
            }
            if (i > i6) {
                return 1;
            }
            int i10 = rect.left;
            int i11 = rect2.left;
            if (i10 < i11) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i10 > i11) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            int i12 = rect.bottom;
            int i13 = rect2.bottom;
            if (i12 < i13) {
                return -1;
            }
            if (i12 > i13) {
                return 1;
            }
            int i14 = rect.right;
            int i15 = rect2.right;
            if (i14 < i15) {
                return this.mIsLayoutRtl ? 1 : -1;
            }
            if (i14 > i15) {
                return this.mIsLayoutRtl ? -1 : 1;
            }
            return 0;
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i, rect, rect2);
        if (beamsOverlap(i, rect, rect3) || !beamsOverlap) {
            return false;
        }
        return !isToDirectionOf(i, rect, rect3) || i == 17 || i == 66 || majorAxisDistance(i, rect, rect2) < majorAxisDistanceToFarEdge(i, rect, rect3);
    }

    private static boolean beamsOverlap(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return false;
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l10, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t9, @NonNull Rect rect, int i) {
        Rect rect2 = new Rect(rect);
        if (i == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else {
            if (i != 130) {
                a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return null;
            }
            rect2.offset(0, -(rect.height() + 1));
        }
        int size = collectionAdapter.size(l10);
        Rect rect3 = new Rect();
        T t10 = null;
        for (int i6 = 0; i6 < size; i6++) {
            T t11 = collectionAdapter.get(l10, i6);
            if (t11 != t9) {
                boundsAdapter.obtainBounds(t11, rect3);
                if (isBetterCandidate(i, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t10 = t11;
                }
            }
        }
        return t10;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l10, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t9, int i, boolean z9, boolean z10) {
        int size = collectionAdapter.size(l10);
        ArrayList arrayList = new ArrayList(size);
        for (int i6 = 0; i6 < size; i6++) {
            arrayList.add(collectionAdapter.get(l10, i6));
        }
        Collections.sort(arrayList, new SequentialComparator(z9, boundsAdapter));
        if (i == 1) {
            return (T) getPreviousFocusable(t9, arrayList, z10);
        }
        if (i == 2) {
            return (T) getNextFocusable(t9, arrayList, z10);
        }
        a.p("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        return null;
    }

    private static <T> T getNextFocusable(T t9, ArrayList<T> arrayList, boolean z9) {
        int size = arrayList.size();
        int lastIndexOf = (t9 == null ? -1 : arrayList.lastIndexOf(t9)) + 1;
        if (lastIndexOf < size) {
            return arrayList.get(lastIndexOf);
        }
        if (!z9 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t9, ArrayList<T> arrayList, boolean z9) {
        int size = arrayList.size();
        int indexOf = (t9 == null ? size : arrayList.indexOf(t9)) - 1;
        if (indexOf >= 0) {
            return arrayList.get(indexOf);
        }
        if (!z9 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i, int i6) {
        return (i6 * i6) + (i * 13 * i);
    }

    private static boolean isBetterCandidate(int i, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i)) {
            return false;
        }
        if (isCandidate(rect, rect3, i) && !beamBeats(i, rect, rect2, rect3)) {
            return !beamBeats(i, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i, rect, rect2), minorAxisDistance(i, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i, rect, rect3), minorAxisDistance(i, rect, rect3));
        }
        return true;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i) {
        if (i == 17) {
            int i6 = rect.right;
            int i10 = rect2.right;
            return (i6 > i10 || rect.left >= i10) && rect.left > rect2.left;
        }
        if (i == 33) {
            int i11 = rect.bottom;
            int i12 = rect2.bottom;
            return (i11 > i12 || rect.top >= i12) && rect.top > rect2.top;
        }
        if (i == 66) {
            int i13 = rect.left;
            int i14 = rect2.left;
            return (i13 < i14 || rect.right <= i14) && rect.right < rect2.right;
        }
        if (i != 130) {
            a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            return false;
        }
        int i15 = rect.top;
        int i16 = rect2.top;
        return (i15 < i16 || rect.bottom <= i16) && rect.bottom < rect2.bottom;
    }

    private static boolean isToDirectionOf(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i == 17) {
            return rect.left >= rect2.right;
        }
        if (i == 33) {
            return rect.top >= rect2.bottom;
        }
        if (i == 66) {
            return rect.right <= rect2.left;
        }
        if (i == 130) {
            return rect.bottom <= rect2.top;
        }
        a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return false;
    }

    private static int majorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i == 17) {
            return rect.left - rect2.right;
        }
        if (i == 33) {
            return rect.top - rect2.bottom;
        }
        if (i == 66) {
            return rect2.left - rect.right;
        }
        if (i == 130) {
            return rect2.top - rect.bottom;
        }
        a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return 0;
    }

    private static int majorAxisDistanceToFarEdge(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i == 17) {
            return rect.left - rect2.left;
        }
        if (i == 33) {
            return rect.top - rect2.top;
        }
        if (i == 66) {
            return rect2.right - rect.right;
        }
        if (i == 130) {
            return rect2.bottom - rect.bottom;
        }
        a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return 0;
    }

    private static int minorAxisDistance(int i, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i != 17) {
            if (i != 33) {
                if (i != 66) {
                    if (i != 130) {
                        a.p("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        return 0;
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }
}
