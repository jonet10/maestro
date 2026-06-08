package c4;

import com.uptodown.activities.ReviewsActivity;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z8 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2400a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f2401b;

    public /* synthetic */ z8(ReviewsActivity reviewsActivity, int i) {
        this.f2400a = i;
        this.f2401b = reviewsActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        x4.k2 k2Var;
        int i = this.f2400a;
        int i6 = -1;
        j5.q qVar = j5.q.f6706a;
        p6.x xVar = p6.x.f8463a;
        int i10 = 0;
        j5.p pVar = j5.p.f6705a;
        ReviewsActivity reviewsActivity = this.f2401b;
        switch (i) {
            case 0:
                j5.s sVar = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar, pVar)) {
                    if (!(sVar instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        int i11 = ReviewsActivity.T;
                        reviewsActivity.A0().f1643n = false;
                        if (reviewsActivity.Q == null) {
                            d9 d9Var = (d9) ((j5.r) sVar).f6707a;
                            if (d9Var.f1518a.isEmpty()) {
                                reviewsActivity.y0().A.setVisibility(0);
                            } else {
                                reviewsActivity.Q = new e4.i0(d9Var.f1518a, reviewsActivity, reviewsActivity.R);
                                reviewsActivity.y0().v.setAdapter(reviewsActivity.Q);
                                reviewsActivity.y0().A.setVisibility(8);
                            }
                        } else {
                            Iterator it = ((d9) ((j5.r) sVar).f6707a).f1518a.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                e4.i0 i0Var = reviewsActivity.Q;
                                i0Var.getClass();
                                i0Var.f4560a.add((x4.k2) next);
                                i0Var.notifyItemInserted(i0Var.getItemCount());
                            }
                        }
                        e4.i0 i0Var2 = reviewsActivity.Q;
                        if (i0Var2 != null) {
                            i0Var2.f4563d = false;
                            i0Var2.notifyItemRemoved(i0Var2.getItemCount());
                        }
                        reviewsActivity.y0().f10097t.setVisibility(8);
                        break;
                    }
                } else {
                    int i12 = ReviewsActivity.T;
                    reviewsActivity.A0().f1643n = true;
                    if (reviewsActivity.Q == null) {
                        reviewsActivity.y0().f10097t.setVisibility(0);
                        break;
                    }
                }
                break;
            case 1:
                j5.s sVar2 = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar2, pVar)) {
                    if (!(sVar2 instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar2, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        e9 e9Var = (e9) ((j5.r) sVar2).f6707a;
                        int i13 = e9Var.f1561a;
                        if (i13 != 1) {
                            int i14 = e9Var.f1562b;
                            if (i14 != 403) {
                                if (i13 != 0 || i14 != 0) {
                                    String string = reviewsActivity.getString(2131951998);
                                    string.getClass();
                                    reviewsActivity.A(string);
                                    break;
                                } else {
                                    String string2 = reviewsActivity.getString(2131952005);
                                    string2.getClass();
                                    reviewsActivity.A(string2);
                                    break;
                                }
                            } else {
                                String string3 = reviewsActivity.getString(2131951981);
                                string3.getClass();
                                reviewsActivity.A(string3);
                                break;
                            }
                        } else {
                            String string4 = reviewsActivity.getString(2131952543);
                            string4.getClass();
                            reviewsActivity.A(string4);
                            reviewsActivity.y0().f10088b.setText("");
                            break;
                        }
                    }
                } else {
                    int i15 = ReviewsActivity.T;
                    reviewsActivity.A0().f1643n = true;
                    reviewsActivity.y0().f10097t.setVisibility(0);
                    break;
                }
                break;
            case 2:
                j5.s sVar3 = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar3, pVar)) {
                    if (!(sVar3 instanceof j5.r)) {
                        if (!(sVar3 instanceof j5.q)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        x4.j2 j2Var = (x4.j2) ((j5.r) sVar3).f6707a;
                        if (j2Var.f11245b != 1) {
                            if (j2Var.f11246c != 401) {
                                String string5 = reviewsActivity.getString(2131951998);
                                string5.getClass();
                                reviewsActivity.A(string5);
                                break;
                            } else {
                                String string6 = reviewsActivity.getString(2131952183);
                                string6.getClass();
                                String string7 = reviewsActivity.getString(2131952182);
                                string7.getClass();
                                b2.t1.v(reviewsActivity, string6, string7);
                                break;
                            }
                        } else {
                            e4.i0 i0Var3 = reviewsActivity.Q;
                            if (i0Var3 != null) {
                                x4.k2 k2Var2 = j2Var.f11244a;
                                k2Var2.getClass();
                                ArrayList arrayList = i0Var3.f4560a;
                                Iterator it2 = arrayList.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        int i16 = i10 + 1;
                                        if (((x4.k2) it2.next()).f11258a == k2Var2.f11258a) {
                                            i6 = i10;
                                        } else {
                                            i10 = i16;
                                        }
                                    }
                                }
                                arrayList.set(i6, k2Var2);
                                i0Var3.notifyItemChanged(i6);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                j5.s sVar4 = (j5.s) obj;
                if (!kotlin.jvm.internal.l.a(sVar4, pVar)) {
                    if (!(sVar4 instanceof j5.r)) {
                        if (!kotlin.jvm.internal.l.a(sVar4, qVar)) {
                            com.google.gson.internal.a.b();
                            break;
                        }
                    } else {
                        x4.v2 v2Var = (x4.v2) ((j5.r) sVar4).f6707a;
                        int i17 = v2Var.f11423b;
                        int i18 = v2Var.f11425d;
                        if (i17 != 1) {
                            int i19 = v2Var.f11424c;
                            if (i19 != 401) {
                                if (i19 != 409) {
                                    String string8 = reviewsActivity.getString(2131951998);
                                    string8.getClass();
                                    reviewsActivity.A(string8);
                                    break;
                                } else {
                                    String string9 = reviewsActivity.getString(2131951675);
                                    string9.getClass();
                                    reviewsActivity.A(string9);
                                    break;
                                }
                            } else {
                                String string10 = reviewsActivity.getString(2131952181);
                                string10.getClass();
                                String string11 = reviewsActivity.getString(2131952180);
                                string11.getClass();
                                b2.t1.v(reviewsActivity, string10, string11);
                                break;
                            }
                        } else {
                            String str = v2Var.f11422a;
                            e4.i0 i0Var4 = reviewsActivity.Q;
                            if (i0Var4 != null) {
                                Iterator it3 = i0Var4.f4560a.iterator();
                                while (true) {
                                    if (it3.hasNext()) {
                                        int i20 = i10 + 1;
                                        if (kotlin.jvm.internal.l.a(((x4.k2) it3.next()).f11259b, str)) {
                                            i6 = i10;
                                        } else {
                                            i10 = i20;
                                        }
                                    }
                                }
                            }
                            if (i6 >= 0) {
                                e4.i0 i0Var5 = reviewsActivity.Q;
                                if (i0Var5 != null && (k2Var = (x4.k2) i0Var5.f4560a.get(i6)) != null) {
                                    k2Var.f11271x = i18;
                                }
                                e4.i0 i0Var6 = reviewsActivity.Q;
                                if (i0Var6 != null) {
                                    i0Var6.notifyItemChanged(i6);
                                }
                            }
                            if (i18 != 1) {
                                String string12 = reviewsActivity.getString(2131952686);
                                string12.getClass();
                                reviewsActivity.A(string12);
                                break;
                            } else {
                                String string13 = reviewsActivity.getString(2131952032);
                                string13.getClass();
                                reviewsActivity.A(string13);
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return null;
    }
}
