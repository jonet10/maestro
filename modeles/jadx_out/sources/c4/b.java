package c4;

import android.os.Environment;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.SearchView;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.core.activities.InstallerActivity;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends OnBackPressedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1400a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.h f1401b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(g4.h hVar, int i) {
        super(true);
        this.f1400a = i;
        this.f1401b = hVar;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public final void handleOnBackPressed() {
        int i = this.f1400a;
        int i6 = 1;
        g4.h hVar = this.f1401b;
        switch (i) {
            case 0:
                AppDetailActivity appDetailActivity = (AppDetailActivity) hVar;
                ArrayList arrayList = appDetailActivity.U;
                ArrayList arrayList2 = appDetailActivity.T;
                ArrayList arrayList3 = appDetailActivity.S;
                n5.d dVar = appDetailActivity.L;
                if (dVar == null || !dVar.c(appDetailActivity)) {
                    if (!arrayList2.isEmpty()) {
                        arrayList2.remove(q6.m.c0(arrayList2));
                        if (arrayList2.isEmpty() && appDetailActivity.O != null && arrayList3.size() == 1) {
                            appDetailActivity.finish();
                        } else {
                            appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                        }
                    } else if (!arrayList.isEmpty()) {
                        arrayList.remove(q6.m.c0(arrayList));
                        appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                    } else if (arrayList3.isEmpty()) {
                        appDetailActivity.finish();
                    } else {
                        arrayList3.remove(q6.m.c0(arrayList3));
                        appDetailActivity.getSupportFragmentManager().popBackStackImmediate();
                        if (arrayList3.isEmpty()) {
                            appDetailActivity.finish();
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        ((u4.f0) q6.l.y0(arrayList3)).p0(appDetailActivity);
                        break;
                    }
                }
                break;
            case 1:
                ((Gallery) hVar).finish();
                break;
            case 2:
                LoginActivity loginActivity = (LoginActivity) hVar;
                int i10 = LoginActivity.W;
                if (((LinearLayout) loginActivity.G0().f10133m.f8816b).getVisibility() != 0) {
                    loginActivity.finish();
                    break;
                } else {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setInterpolator(new AccelerateInterpolator());
                    alphaAnimation.setDuration(200L);
                    alphaAnimation.setAnimationListener(new l2(loginActivity, i6));
                    ((LinearLayout) loginActivity.G0().f10133m.f8816b).startAnimation(alphaAnimation);
                    break;
                }
            case 3:
                MainActivity mainActivity = (MainActivity) hVar;
                ArrayList arrayList4 = mainActivity.f3318q0;
                n5.d dVar2 = mainActivity.L;
                if (dVar2 == null || !dVar2.c(mainActivity)) {
                    boolean popBackStackImmediate = mainActivity.getSupportFragmentManager().popBackStackImmediate();
                    int backStackEntryCount = mainActivity.getSupportFragmentManager().getBackStackEntryCount();
                    if (popBackStackImmediate && backStackEntryCount >= 0) {
                        boolean z9 = mainActivity.W0() instanceof u4.f0;
                        RelativeLayout relativeLayout = mainActivity.f3312j0;
                        if (!z9) {
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(8);
                            }
                            if (mainActivity.W0() == null || (mainActivity.W0() instanceof u4.m1) || (mainActivity.W0() instanceof u4.g1) || (mainActivity.W0() instanceof u4.w0)) {
                                mainActivity.q1();
                                break;
                            }
                        } else {
                            if (relativeLayout != null) {
                                relativeLayout.setVisibility(0);
                            }
                            Fragment W0 = mainActivity.W0();
                            W0.getClass();
                            ((u4.f0) W0).p0(mainActivity);
                            break;
                        }
                    } else {
                        RelativeLayout relativeLayout2 = mainActivity.f3312j0;
                        if (relativeLayout2 != null) {
                            relativeLayout2.setVisibility(8);
                        }
                        int size = arrayList4.size();
                        if (size <= 0) {
                            if (!MainActivity.K0(mainActivity)) {
                                mainActivity.finish();
                                break;
                            } else {
                                RelativeLayout relativeLayout3 = mainActivity.W;
                                if (relativeLayout3 != null && relativeLayout3.getVisibility() == 0) {
                                    mainActivity.P0();
                                    break;
                                } else {
                                    ViewPager2 viewPager2 = mainActivity.f3310h0;
                                    if (viewPager2 != null && viewPager2.getCurrentItem() == 0) {
                                        mainActivity.finish();
                                        break;
                                    } else {
                                        mainActivity.S0(0);
                                        break;
                                    }
                                }
                            }
                        } else {
                            Fragment fragment = (Fragment) q6.l.y0(arrayList4);
                            arrayList4.remove(size - 1);
                            if (!(fragment instanceof u4.g1)) {
                                if (!MainActivity.K0(mainActivity)) {
                                    mainActivity.finish();
                                    break;
                                } else {
                                    RelativeLayout relativeLayout4 = mainActivity.W;
                                    if (relativeLayout4 != null && relativeLayout4.getVisibility() == 0) {
                                        mainActivity.P0();
                                        break;
                                    } else {
                                        ViewPager2 viewPager22 = mainActivity.f3310h0;
                                        if (viewPager22 != null && viewPager22.getCurrentItem() == 0) {
                                            mainActivity.finish();
                                            break;
                                        } else {
                                            mainActivity.S0(0);
                                            break;
                                        }
                                    }
                                }
                            } else {
                                x4.j jVar = ((u4.g1) fragment).f10669a;
                                if (jVar != null && jVar.f11224a == 523) {
                                    mainActivity.S0(1);
                                    break;
                                } else {
                                    mainActivity.S0(0);
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            case 4:
                MyDownloads myDownloads = (MyDownloads) hVar;
                e4.b bVar = myDownloads.Q;
                if (bVar != null && bVar.f4486c) {
                    myDownloads.F0();
                    break;
                } else {
                    myDownloads.finish();
                    break;
                }
            case 5:
                Updates updates = (Updates) hVar;
                if (!updates.f3357d0.isEmpty()) {
                    updates.P0();
                    break;
                } else {
                    updates.finish();
                    break;
                }
            case 6:
                ((UserDeviceDetailsActivity) hVar).finish();
                break;
            case 7:
                ((YouTubeActivity) hVar).finish();
                break;
            case 8:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) hVar;
                i4.b bVar2 = fileExplorerActivity.V;
                if (bVar2 != null && bVar2.f5657c) {
                    bVar2.c(false);
                    fileExplorerActivity.U();
                    break;
                } else {
                    DocumentFile documentFile = fileExplorerActivity.Y;
                    if (documentFile == null) {
                        File file = fileExplorerActivity.f3381c0;
                        if (file != null && !file.equals(Environment.getExternalStorageDirectory())) {
                            File file2 = fileExplorerActivity.f3381c0;
                            file2.getClass();
                            String name = file2.getName();
                            File file3 = fileExplorerActivity.f3381c0;
                            file3.getClass();
                            File parentFile = file3.getParentFile();
                            if (parentFile == null) {
                                FileExplorerActivity.H(fileExplorerActivity);
                                break;
                            } else {
                                fileExplorerActivity.f3381c0 = parentFile;
                                fileExplorerActivity.Y = null;
                                FileExplorerActivity.P(fileExplorerActivity);
                                fileExplorerActivity.V(name);
                                SearchView searchView = fileExplorerActivity.N;
                                if (searchView != null) {
                                    fileExplorerActivity.T(searchView);
                                    break;
                                }
                            }
                        } else {
                            FileExplorerActivity.H(fileExplorerActivity);
                            break;
                        }
                    } else {
                        String name2 = documentFile.getName();
                        DocumentFile documentFile2 = fileExplorerActivity.Y;
                        documentFile2.getClass();
                        DocumentFile parentFile2 = documentFile2.getParentFile();
                        if (parentFile2 == null) {
                            FileExplorerActivity.H(fileExplorerActivity);
                            break;
                        } else {
                            fileExplorerActivity.Y = parentFile2;
                            fileExplorerActivity.f3381c0 = null;
                            FileExplorerActivity.P(fileExplorerActivity);
                            fileExplorerActivity.V(name2);
                            SearchView searchView2 = fileExplorerActivity.N;
                            if (searchView2 != null) {
                                fileExplorerActivity.T(searchView2);
                                break;
                            }
                        }
                    }
                }
                break;
            default:
                int i11 = InstallerActivity.f3394j0;
                ((InstallerActivity) hVar).D();
                break;
        }
    }
}
