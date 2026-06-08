package g4;

import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.documentfile.provider.DocumentFile;
import androidx.recyclerview.widget.RecyclerView;
import c4.n5;
import com.uptodown.core.activities.FileExplorerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5225a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5226b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(FileExplorerActivity fileExplorerActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f5225a = i;
        this.f5226b = fileExplorerActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5225a) {
            case 0:
                return new n(this.f5226b, cVar, 0);
            case 1:
                return new n(this.f5226b, cVar, 1);
            case 2:
                return new n(this.f5226b, cVar, 2);
            case 3:
                return new n(this.f5226b, cVar, 3);
            case 4:
                return new n(this.f5226b, cVar, 4);
            case 5:
                return new n(this.f5226b, cVar, 5);
            case 6:
                return new n(this.f5226b, cVar, 6);
            case 7:
                return new n(this.f5226b, cVar, 7);
            case 8:
                return new n(this.f5226b, cVar, 8);
            case 9:
                return new n(this.f5226b, cVar, 9);
            case 10:
                return new n(this.f5226b, cVar, 10);
            case 11:
                return new n(this.f5226b, cVar, 11);
            case 12:
                return new n(this.f5226b, cVar, 12);
            case 13:
                return new n(this.f5226b, cVar, 13);
            case 14:
                return new n(this.f5226b, cVar, 14);
            default:
                return new n(this.f5226b, cVar, 15);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5225a) {
            case 0:
                n nVar = (n) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                nVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                n nVar2 = (n) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                nVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                n nVar3 = (n) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                nVar3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                n nVar4 = (n) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                nVar4.invokeSuspend(xVar4);
                return xVar4;
            case 4:
                n nVar5 = (n) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                nVar5.invokeSuspend(xVar5);
                return xVar5;
            case 5:
                n nVar6 = (n) create(a0Var, cVar);
                p6.x xVar6 = p6.x.f8463a;
                nVar6.invokeSuspend(xVar6);
                return xVar6;
            case 6:
                n nVar7 = (n) create(a0Var, cVar);
                p6.x xVar7 = p6.x.f8463a;
                nVar7.invokeSuspend(xVar7);
                return xVar7;
            case 7:
                n nVar8 = (n) create(a0Var, cVar);
                p6.x xVar8 = p6.x.f8463a;
                nVar8.invokeSuspend(xVar8);
                return xVar8;
            case 8:
                n nVar9 = (n) create(a0Var, cVar);
                p6.x xVar9 = p6.x.f8463a;
                nVar9.invokeSuspend(xVar9);
                return xVar9;
            case 9:
                n nVar10 = (n) create(a0Var, cVar);
                p6.x xVar10 = p6.x.f8463a;
                nVar10.invokeSuspend(xVar10);
                return xVar10;
            case 10:
                n nVar11 = (n) create(a0Var, cVar);
                p6.x xVar11 = p6.x.f8463a;
                nVar11.invokeSuspend(xVar11);
                return xVar11;
            case 11:
                n nVar12 = (n) create(a0Var, cVar);
                p6.x xVar12 = p6.x.f8463a;
                nVar12.invokeSuspend(xVar12);
                return xVar12;
            case 12:
                n nVar13 = (n) create(a0Var, cVar);
                p6.x xVar13 = p6.x.f8463a;
                nVar13.invokeSuspend(xVar13);
                return xVar13;
            case 13:
                n nVar14 = (n) create(a0Var, cVar);
                p6.x xVar14 = p6.x.f8463a;
                nVar14.invokeSuspend(xVar14);
                return xVar14;
            case 14:
                n nVar15 = (n) create(a0Var, cVar);
                p6.x xVar15 = p6.x.f8463a;
                nVar15.invokeSuspend(xVar15);
                return xVar15;
            default:
                n nVar16 = (n) create(a0Var, cVar);
                p6.x xVar16 = p6.x.f8463a;
                nVar16.invokeSuspend(xVar16);
                return xVar16;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Menu menu;
        MenuItem findItem;
        Menu menu2;
        MenuItem findItem2;
        Menu menu3;
        MenuItem findItem3;
        Menu menu4;
        MenuItem findItem4;
        Menu menu5;
        MenuItem findItem5;
        Menu menu6;
        MenuItem findItem6;
        Menu menu7;
        MenuItem findItem7;
        Menu menu8;
        MenuItem findItem8;
        Menu menu9;
        MenuItem findItem9;
        Menu menu10;
        MenuItem findItem10;
        Menu menu11;
        MenuItem findItem11;
        Menu menu12;
        MenuItem findItem12;
        Throwable th;
        String str;
        int i = this.f5225a;
        p6.x xVar = p6.x.f8463a;
        FileExplorerActivity fileExplorerActivity = this.f5226b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 1:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 2:
                p6.a.e(obj);
                i4.b bVar = fileExplorerActivity.V;
                if (bVar != null) {
                    fileExplorerActivity.f3384f0 = bVar.a();
                }
                return xVar;
            case 3:
                p6.a.e(obj);
                i4.b bVar2 = fileExplorerActivity.V;
                bVar2.getClass();
                bVar2.c(false);
                ArrayList arrayList = fileExplorerActivity.f3384f0;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Toolbar toolbar = fileExplorerActivity.T;
                    if (toolbar != null && (menu6 = toolbar.getMenu()) != null && (findItem6 = menu6.findItem(2131361888)) != null) {
                        findItem6.setVisible(true);
                    }
                    Toolbar toolbar2 = fileExplorerActivity.T;
                    if (toolbar2 != null && (menu5 = toolbar2.getMenu()) != null && (findItem5 = menu5.findItem(2131361869)) != null) {
                        findItem5.setVisible(true);
                    }
                    Toolbar toolbar3 = fileExplorerActivity.T;
                    if (toolbar3 != null && (menu4 = toolbar3.getMenu()) != null && (findItem4 = menu4.findItem(2131361868)) != null) {
                        findItem4.setVisible(false);
                    }
                    Toolbar toolbar4 = fileExplorerActivity.T;
                    if (toolbar4 != null && (menu3 = toolbar4.getMenu()) != null && (findItem3 = menu3.findItem(2131361865)) != null) {
                        findItem3.setVisible(false);
                    }
                    Toolbar toolbar5 = fileExplorerActivity.T;
                    if (toolbar5 != null && (menu2 = toolbar5.getMenu()) != null && (findItem2 = menu2.findItem(2131361870)) != null) {
                        findItem2.setVisible(false);
                    }
                    Toolbar toolbar6 = fileExplorerActivity.T;
                    if (toolbar6 != null && (menu = toolbar6.getMenu()) != null && (findItem = menu.findItem(2131361872)) != null) {
                        findItem.setVisible(false);
                    }
                }
                return xVar;
            case 4:
                p6.a.e(obj);
                int i6 = FileExplorerActivity.f3379q0;
                fileExplorerActivity.V(null);
                return xVar;
            case 5:
                p6.a.e(obj);
                i4.b bVar3 = fileExplorerActivity.V;
                if (bVar3 != null) {
                    fileExplorerActivity.f3384f0 = bVar3.a();
                }
                return xVar;
            case 6:
                p6.a.e(obj);
                i4.b bVar4 = fileExplorerActivity.V;
                bVar4.getClass();
                bVar4.c(false);
                ArrayList arrayList2 = fileExplorerActivity.f3384f0;
                if (arrayList2 != null && !arrayList2.isEmpty()) {
                    Toolbar toolbar7 = fileExplorerActivity.T;
                    if (toolbar7 != null && (menu12 = toolbar7.getMenu()) != null && (findItem12 = menu12.findItem(2131361888)) != null) {
                        findItem12.setVisible(true);
                    }
                    Toolbar toolbar8 = fileExplorerActivity.T;
                    if (toolbar8 != null && (menu11 = toolbar8.getMenu()) != null && (findItem11 = menu11.findItem(2131361869)) != null) {
                        findItem11.setVisible(true);
                    }
                    Toolbar toolbar9 = fileExplorerActivity.T;
                    if (toolbar9 != null && (menu10 = toolbar9.getMenu()) != null && (findItem10 = menu10.findItem(2131361868)) != null) {
                        findItem10.setVisible(false);
                    }
                    Toolbar toolbar10 = fileExplorerActivity.T;
                    if (toolbar10 != null && (menu9 = toolbar10.getMenu()) != null && (findItem9 = menu9.findItem(2131361865)) != null) {
                        findItem9.setVisible(false);
                    }
                    Toolbar toolbar11 = fileExplorerActivity.T;
                    if (toolbar11 != null && (menu8 = toolbar11.getMenu()) != null && (findItem8 = menu8.findItem(2131361870)) != null) {
                        findItem8.setVisible(false);
                    }
                    Toolbar toolbar12 = fileExplorerActivity.T;
                    if (toolbar12 != null && (menu7 = toolbar12.getMenu()) != null && (findItem7 = menu7.findItem(2131361872)) != null) {
                        findItem7.setVisible(false);
                    }
                }
                return xVar;
            case 7:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 8:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 9:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 10:
                p6.a.e(obj);
                FileExplorerActivity.R(fileExplorerActivity);
                return xVar;
            case 11:
                p6.a.e(obj);
                RelativeLayout relativeLayout = fileExplorerActivity.G;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                    return xVar;
                }
                kotlin.jvm.internal.l.i("rlLoading");
                throw null;
            case 12:
                p6.a.e(obj);
                boolean z9 = fileExplorerActivity.f3382d0;
                ArrayList arrayList3 = fileExplorerActivity.X;
                if (z9) {
                    if (arrayList3 != null) {
                        if (arrayList3.size() > 1) {
                            q6.q.j0(arrayList3, new z(3));
                        }
                        ArrayList arrayList4 = fileExplorerActivity.X;
                        arrayList4.getClass();
                        if (arrayList4.size() > 1) {
                            q6.q.j0(arrayList4, new z(4));
                        }
                    }
                    ArrayList arrayList5 = fileExplorerActivity.f3380b0;
                    if (arrayList5 != null) {
                        if (arrayList5.size() > 1) {
                            q6.q.j0(arrayList5, new z(5));
                        }
                        ArrayList arrayList6 = fileExplorerActivity.f3380b0;
                        arrayList6.getClass();
                        if (arrayList6.size() > 1) {
                            q6.q.j0(arrayList6, new z(6));
                        }
                    }
                } else {
                    if (arrayList3 != null) {
                        if (arrayList3.size() > 1) {
                            q6.q.j0(arrayList3, new n5(29));
                        }
                        ArrayList arrayList7 = fileExplorerActivity.X;
                        arrayList7.getClass();
                        if (arrayList7.size() > 1) {
                            q6.q.j0(arrayList7, new z(0));
                        }
                    }
                    ArrayList arrayList8 = fileExplorerActivity.f3380b0;
                    if (arrayList8 != null) {
                        if (arrayList8.size() > 1) {
                            q6.q.j0(arrayList8, new z(1));
                        }
                        ArrayList arrayList9 = fileExplorerActivity.f3380b0;
                        arrayList9.getClass();
                        if (arrayList9.size() > 1) {
                            q6.q.j0(arrayList9, new z(2));
                        }
                    }
                }
                return xVar;
            case 13:
                p6.a.e(obj);
                boolean z10 = fileExplorerActivity.f3382d0;
                ArrayList arrayList10 = fileExplorerActivity.X;
                if (z10) {
                    if (arrayList10 != null) {
                        if (arrayList10.size() > 1) {
                            q6.q.j0(arrayList10, new n5(17));
                        }
                        ArrayList arrayList11 = fileExplorerActivity.X;
                        arrayList11.getClass();
                        if (arrayList11.size() > 1) {
                            q6.q.j0(arrayList11, new n5(18));
                        }
                    }
                    ArrayList arrayList12 = fileExplorerActivity.f3380b0;
                    if (arrayList12 != null) {
                        if (arrayList12.size() > 1) {
                            q6.q.j0(arrayList12, new n5(19));
                        }
                        ArrayList arrayList13 = fileExplorerActivity.f3380b0;
                        arrayList13.getClass();
                        if (arrayList13.size() > 1) {
                            q6.q.j0(arrayList13, new n5(20));
                        }
                    }
                } else {
                    if (arrayList10 != null) {
                        if (arrayList10.size() > 1) {
                            q6.q.j0(arrayList10, new n5(13));
                        }
                        ArrayList arrayList14 = fileExplorerActivity.X;
                        arrayList14.getClass();
                        if (arrayList14.size() > 1) {
                            q6.q.j0(arrayList14, new n5(14));
                        }
                    }
                    ArrayList arrayList15 = fileExplorerActivity.f3380b0;
                    if (arrayList15 != null) {
                        if (arrayList15.size() > 1) {
                            q6.q.j0(arrayList15, new n5(15));
                        }
                        ArrayList arrayList16 = fileExplorerActivity.f3380b0;
                        arrayList16.getClass();
                        if (arrayList16.size() > 1) {
                            q6.q.j0(arrayList16, new n5(16));
                        }
                    }
                }
                return xVar;
            case 14:
                p6.a.e(obj);
                boolean z11 = fileExplorerActivity.f3382d0;
                ArrayList arrayList17 = fileExplorerActivity.X;
                if (z11) {
                    if (arrayList17 != null) {
                        if (arrayList17.size() > 1) {
                            q6.q.j0(arrayList17, new n5(25));
                        }
                        ArrayList arrayList18 = fileExplorerActivity.X;
                        arrayList18.getClass();
                        if (arrayList18.size() > 1) {
                            q6.q.j0(arrayList18, new n5(26));
                        }
                    }
                    ArrayList arrayList19 = fileExplorerActivity.f3380b0;
                    if (arrayList19 != null) {
                        if (arrayList19.size() > 1) {
                            q6.q.j0(arrayList19, new n5(27));
                        }
                        ArrayList arrayList20 = fileExplorerActivity.f3380b0;
                        arrayList20.getClass();
                        if (arrayList20.size() > 1) {
                            q6.q.j0(arrayList20, new n5(28));
                        }
                    }
                } else {
                    if (arrayList17 != null) {
                        if (arrayList17.size() > 1) {
                            q6.q.j0(arrayList17, new n5(21));
                        }
                        ArrayList arrayList21 = fileExplorerActivity.X;
                        arrayList21.getClass();
                        if (arrayList21.size() > 1) {
                            q6.q.j0(arrayList21, new n5(22));
                        }
                    }
                    ArrayList arrayList22 = fileExplorerActivity.f3380b0;
                    if (arrayList22 != null) {
                        if (arrayList22.size() > 1) {
                            q6.q.j0(arrayList22, new n5(23));
                        }
                        ArrayList arrayList23 = fileExplorerActivity.f3380b0;
                        arrayList23.getClass();
                        if (arrayList23.size() > 1) {
                            q6.q.j0(arrayList23, new n5(24));
                        }
                    }
                }
                return xVar;
            default:
                p6.a.e(obj);
                DocumentFile documentFile = fileExplorerActivity.Y;
                if (documentFile != null) {
                    String lastPathSegment = documentFile.getUri().getLastPathSegment();
                    if (lastPathSegment != null) {
                        th = null;
                        str = lastPathSegment.substring(l7.m.A0(":", lastPathSegment, 6) + 1);
                    } else {
                        th = null;
                        str = "";
                    }
                    if (!fileExplorerActivity.f3383e0) {
                        TextView textView = fileExplorerActivity.E;
                        if (textView == null) {
                            kotlin.jvm.internal.l.i("tvBreadCrumb");
                            throw th;
                        }
                        textView.setText(fileExplorerActivity.getString(2131952099) + "/" + str);
                    } else if (str.length() == 0) {
                        TextView textView2 = fileExplorerActivity.E;
                        if (textView2 == null) {
                            kotlin.jvm.internal.l.i("tvBreadCrumb");
                            throw th;
                        }
                        textView2.setText(fileExplorerActivity.getString(2131952558));
                    } else {
                        DocumentFile documentFile2 = fileExplorerActivity.Y;
                        documentFile2.getClass();
                        String lastPathSegment2 = documentFile2.getUri().getLastPathSegment();
                        LinearLayout linearLayout = fileExplorerActivity.I;
                        if (linearLayout == null) {
                            kotlin.jvm.internal.l.i("llBreadcrumb");
                            throw th;
                        }
                        if (linearLayout.findViewWithTag(lastPathSegment2) == null) {
                            LayoutInflater layoutInflater = fileExplorerActivity.getLayoutInflater();
                            LinearLayout linearLayout2 = fileExplorerActivity.I;
                            if (linearLayout2 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw th;
                            }
                            View inflate = layoutInflater.inflate(2131558446, (ViewGroup) linearLayout2, false);
                            inflate.getClass();
                            LinearLayout linearLayout3 = (LinearLayout) inflate;
                            linearLayout3.setTag(lastPathSegment2);
                            TextView textView3 = (TextView) linearLayout3.findViewById(2131363685);
                            lastPathSegment2.getClass();
                            if (lastPathSegment2.substring(l7.m.A0(":", lastPathSegment2, 6) + 1).length() > 0) {
                                String substring = lastPathSegment2.substring(l7.m.A0(":", lastPathSegment2, 6) + 1);
                                if (substring.substring(l7.m.A0("/", substring, 6) + 1).length() > 0) {
                                    textView3.setText(substring.substring(l7.m.A0("/", substring, 6) + 1));
                                } else {
                                    textView3.setText(substring.substring(l7.m.A0(":", substring, 6) + 1));
                                }
                            }
                            textView3.setTypeface(f4.c.f4883x);
                            LinearLayout linearLayout4 = fileExplorerActivity.I;
                            if (linearLayout4 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw th;
                            }
                            linearLayout4.addView(linearLayout3);
                            new Handler(Looper.getMainLooper()).post(new a2.s(fileExplorerActivity, 12));
                        }
                    }
                } else {
                    th = null;
                    File file = fileExplorerActivity.f3381c0;
                    if (file != null) {
                        if (file.equals(Environment.getExternalStorageDirectory())) {
                            TextView textView4 = fileExplorerActivity.E;
                            if (textView4 == null) {
                                kotlin.jvm.internal.l.i("tvBreadCrumb");
                                throw null;
                            }
                            textView4.setText(fileExplorerActivity.getString(2131952099));
                        } else {
                            File file2 = fileExplorerActivity.f3381c0;
                            file2.getClass();
                            String absolutePath = file2.getAbsolutePath();
                            LinearLayout linearLayout5 = fileExplorerActivity.I;
                            if (linearLayout5 == null) {
                                kotlin.jvm.internal.l.i("llBreadcrumb");
                                throw null;
                            }
                            if (linearLayout5.findViewWithTag(absolutePath) == null) {
                                LayoutInflater layoutInflater2 = fileExplorerActivity.getLayoutInflater();
                                LinearLayout linearLayout6 = fileExplorerActivity.I;
                                if (linearLayout6 == null) {
                                    kotlin.jvm.internal.l.i("llBreadcrumb");
                                    throw null;
                                }
                                View inflate2 = layoutInflater2.inflate(2131558446, (ViewGroup) linearLayout6, false);
                                inflate2.getClass();
                                LinearLayout linearLayout7 = (LinearLayout) inflate2;
                                linearLayout7.setTag(absolutePath);
                                TextView textView5 = (TextView) linearLayout7.findViewById(2131363685);
                                File file3 = fileExplorerActivity.f3381c0;
                                file3.getClass();
                                String path = file3.getPath();
                                path.getClass();
                                textView5.setText(Uri.parse(path).getLastPathSegment());
                                textView5.setTypeface(f4.c.f4883x);
                                LinearLayout linearLayout8 = fileExplorerActivity.I;
                                if (linearLayout8 == null) {
                                    kotlin.jvm.internal.l.i("llBreadcrumb");
                                    throw null;
                                }
                                linearLayout8.addView(linearLayout7);
                                new Handler(Looper.getMainLooper()).post(new a2.s(fileExplorerActivity, 12));
                            }
                        }
                    }
                }
                if (fileExplorerActivity.V == null) {
                    i4.b bVar5 = new i4.b(fileExplorerActivity.f3390l0);
                    fileExplorerActivity.V = bVar5;
                    RecyclerView recyclerView = fileExplorerActivity.F;
                    if (recyclerView == null) {
                        kotlin.jvm.internal.l.i("rvFiles");
                        throw th;
                    }
                    recyclerView.setAdapter(bVar5);
                }
                ArrayList arrayList24 = new ArrayList();
                ArrayList arrayList25 = fileExplorerActivity.X;
                if (arrayList25 != null) {
                    arrayList24.addAll(arrayList25);
                } else {
                    ArrayList arrayList26 = fileExplorerActivity.f3380b0;
                    if (arrayList26 != null) {
                        arrayList24.addAll(arrayList26);
                    }
                }
                i4.b bVar6 = fileExplorerActivity.V;
                bVar6.getClass();
                bVar6.f5656b = arrayList24;
                bVar6.f5658d = new boolean[arrayList24.size()];
                bVar6.notifyDataSetChanged();
                RelativeLayout relativeLayout2 = fileExplorerActivity.G;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                    return xVar;
                }
                kotlin.jvm.internal.l.i("rlLoading");
                throw th;
        }
    }
}
