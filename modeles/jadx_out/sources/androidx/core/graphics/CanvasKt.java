package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, Rect rect, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rect);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, l lVar) {
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f10, float f11, l lVar) {
        int save = canvas.save();
        canvas.rotate(f, f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f10, float f11, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i & 4) != 0) {
            f11 = 0.0f;
        }
        int save = canvas.save();
        canvas.rotate(f, f10, f11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withSave(Canvas canvas, l lVar) {
        int save = canvas.save();
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withScale(Canvas canvas, float f, float f10, float f11, float f12, l lVar) {
        int save = canvas.save();
        canvas.scale(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f10, float f11, float f12, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i & 8) != 0) {
            f12 = 0.0f;
        }
        int save = canvas.save();
        canvas.scale(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f10, l lVar) {
        int save = canvas.save();
        canvas.skew(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f10, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f10 = 0.0f;
        }
        int save = canvas.save();
        canvas.skew(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f10, l lVar) {
        int save = canvas.save();
        canvas.translate(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f10, l lVar, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f10 = 0.0f;
        }
        int save = canvas.save();
        canvas.translate(f, f10);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, RectF rectF, l lVar) {
        int save = canvas.save();
        canvas.clipRect(rectF);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, int i, int i6, int i10, int i11, l lVar) {
        int save = canvas.save();
        canvas.clipRect(i, i6, i10, i11);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, float f, float f10, float f11, float f12, l lVar) {
        int save = canvas.save();
        canvas.clipRect(f, f10, f11, f12);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }

    public static final void withClip(Canvas canvas, Path path, l lVar) {
        int save = canvas.save();
        canvas.clipPath(path);
        try {
            lVar.invoke(canvas);
        } finally {
            canvas.restoreToCount(save);
        }
    }
}
