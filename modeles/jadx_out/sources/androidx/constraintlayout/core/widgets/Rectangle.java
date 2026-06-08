package androidx.constraintlayout.core.widgets;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f330x;

    /* renamed from: y, reason: collision with root package name */
    public int f331y;

    public boolean contains(int i, int i6) {
        int i10;
        int i11 = this.f330x;
        return i >= i11 && i < i11 + this.width && i6 >= (i10 = this.f331y) && i6 < i10 + this.height;
    }

    public int getCenterX() {
        return (this.f330x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f331y + this.height) / 2;
    }

    public void grow(int i, int i6) {
        this.f330x -= i;
        this.f331y -= i6;
        this.width = (i * 2) + this.width;
        this.height = (i6 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i;
        int i6;
        int i10 = this.f330x;
        int i11 = rectangle.f330x;
        return i10 >= i11 && i10 < i11 + rectangle.width && (i = this.f331y) >= (i6 = rectangle.f331y) && i < i6 + rectangle.height;
    }

    public void setBounds(int i, int i6, int i10, int i11) {
        this.f330x = i;
        this.f331y = i6;
        this.width = i10;
        this.height = i11;
    }
}
