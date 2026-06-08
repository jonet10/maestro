package androidx.window.core;

import android.graphics.Rect;
import androidx.lifecycle.l;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Bounds {
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        rect.getClass();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Bounds.class.equals(obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj != null) {
            Bounds bounds = (Bounds) obj;
            return this.left == bounds.left && this.top == bounds.top && this.right == bounds.right && this.bottom == bounds.bottom;
        }
        a.i("null cannot be cast to non-null type androidx.window.core.Bounds");
        return false;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.bottom - this.top;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public final boolean isEmpty() {
        return getHeight() == 0 || getWidth() == 0;
    }

    public final boolean isZero() {
        return getHeight() == 0 && getWidth() == 0;
    }

    public final Rect toRect() {
        return new Rect(this.left, this.top, this.right, this.bottom);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Bounds { [");
        sb.append(this.left);
        sb.append(',');
        sb.append(this.top);
        sb.append(',');
        sb.append(this.right);
        sb.append(',');
        return l.x(sb, "] }", this.bottom);
    }

    public Bounds(int i, int i6, int i10, int i11) {
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
    }
}
