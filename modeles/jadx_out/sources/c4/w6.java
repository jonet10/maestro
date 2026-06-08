package c4;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.uptodown.activities.PasswordRecoveryActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.UsernameEditActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.activities.preferences.AdvancedPreferencesActivity;
import com.uptodown.activities.preferences.MobileDataUsageActivity;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.views.DonutChartView;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class w6 implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2263a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2264b;

    public /* synthetic */ w6(Object obj, int i) {
        this.f2263a = i;
        this.f2264b = obj;
    }

    private final Object a() {
        VirusTotalReport virusTotalReport = (VirusTotalReport) this.f2264b;
        int i = VirusTotalReport.Q;
        View inflate = virusTotalReport.getLayoutInflater().inflate(2131558881, (ViewGroup) null, false);
        int i6 = 2131362241;
        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362241);
        if (findChildViewById != null) {
            int i10 = 2131362413;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(findChildViewById, 2131362413);
            if (imageView != null) {
                i10 = 2131363631;
                TextView textView = (TextView) ViewBindings.findChildViewById(findChildViewById, 2131363631);
                if (textView != null) {
                    i10 = 2131363637;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(findChildViewById, 2131363637);
                    if (textView2 != null) {
                        i10 = 2131363656;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(findChildViewById, 2131363656);
                        if (textView3 != null) {
                            a4.d0 d0Var = new a4.d0((RelativeLayout) findChildViewById, imageView, textView, textView2, textView3, 9);
                            i6 = 2131362295;
                            if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362295)) != null) {
                                i6 = 2131362296;
                                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362296)) != null) {
                                    i6 = 2131362522;
                                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362522)) != null) {
                                        i6 = 2131362536;
                                        if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362536)) != null) {
                                            i6 = 2131362724;
                                            if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362724)) != null) {
                                                i6 = 2131362737;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362737);
                                                if (linearLayout != null) {
                                                    i6 = 2131362740;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362740);
                                                    if (linearLayout2 != null) {
                                                        i6 = 2131362824;
                                                        View findChildViewById2 = ViewBindings.findChildViewById(inflate, 2131362824);
                                                        if (findChildViewById2 != null) {
                                                            i6 = 2131363273;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363273);
                                                            if (relativeLayout != null) {
                                                                i6 = 2131363283;
                                                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363283);
                                                                if (relativeLayout2 != null) {
                                                                    i6 = 2131363296;
                                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363296);
                                                                    if (relativeLayout3 != null) {
                                                                        i6 = 2131363483;
                                                                        if (((ScrollView) ViewBindings.findChildViewById(inflate, 2131363483)) != null) {
                                                                            i6 = 2131363576;
                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363576);
                                                                            if (toolbar != null) {
                                                                                i6 = 2131363887;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363887);
                                                                                if (textView4 != null) {
                                                                                    i6 = 2131363928;
                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363928);
                                                                                    if (textView5 != null) {
                                                                                        i6 = 2131364278;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364278);
                                                                                        if (textView6 != null) {
                                                                                            i6 = 2131364280;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131364280);
                                                                                            if (textView7 != null) {
                                                                                                i6 = 2131364294;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131364294);
                                                                                                if (textView8 != null) {
                                                                                                    i6 = 2131364296;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate, 2131364296);
                                                                                                    if (textView9 != null) {
                                                                                                        i6 = 2131364457;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate, 2131364457);
                                                                                                        if (textView10 != null) {
                                                                                                            i6 = 2131364473;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate, 2131364473);
                                                                                                            if (textView11 != null) {
                                                                                                                i6 = 2131364474;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate, 2131364474);
                                                                                                                if (textView12 != null) {
                                                                                                                    i6 = 2131364514;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate, 2131364514);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i6 = 2131364515;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate, 2131364515);
                                                                                                                        if (textView14 != null) {
                                                                                                                            return new t4.j1((RelativeLayout) inflate, d0Var, linearLayout, linearLayout2, findChildViewById2, relativeLayout, relativeLayout2, relativeLayout3, toolbar, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById.getResources().getResourceName(i10)));
            return null;
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    private final Object b() {
        YouTubeActivity youTubeActivity = (YouTubeActivity) this.f2264b;
        int i = YouTubeActivity.Q;
        View inflate = youTubeActivity.getLayoutInflater().inflate(2131558880, (ViewGroup) null, false);
        int i6 = 2131364677;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(inflate, 2131364677);
        if (frameLayout != null) {
            i6 = 2131364678;
            YouTubePlayerView youTubePlayerView = (YouTubePlayerView) ViewBindings.findChildViewById(inflate, 2131364678);
            if (youTubePlayerView != null) {
                return new t4.i1((RelativeLayout) inflate, frameLayout, youTubePlayerView);
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    private final Object c() {
        AdvancedPreferencesActivity advancedPreferencesActivity = (AdvancedPreferencesActivity) this.f2264b;
        int i = AdvancedPreferencesActivity.Q;
        View inflate = advancedPreferencesActivity.getLayoutInflater().inflate(2131558429, (ViewGroup) null, false);
        int i6 = 2131362617;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362617);
        if (linearLayout != null) {
            LinearLayout linearLayout2 = (LinearLayout) inflate;
            int i10 = 2131363530;
            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363530);
            if (toolbar != null) {
                i10 = 2131364442;
                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364442);
                if (textView != null) {
                    return new t4.a(linearLayout2, linearLayout, toolbar, textView);
                }
            }
            i6 = i10;
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    private final Object d() {
        MobileDataUsageActivity mobileDataUsageActivity = (MobileDataUsageActivity) this.f2264b;
        int i = MobileDataUsageActivity.Q;
        View inflate = mobileDataUsageActivity.getLayoutInflater().inflate(2131558703, (ViewGroup) null, false);
        int i6 = 2131362115;
        DonutChartView donutChartView = (DonutChartView) ViewBindings.findChildViewById(inflate, 2131362115);
        if (donutChartView != null) {
            i6 = 2131362651;
            if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362651)) != null) {
                i6 = 2131362665;
                if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362665)) != null) {
                    i6 = 2131362684;
                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362684)) != null) {
                        i6 = 2131362759;
                        if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362759)) != null) {
                            i6 = 2131362799;
                            if (ViewBindings.findChildViewById(inflate, 2131362799) != null) {
                                i6 = 2131363125;
                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363125);
                                if (relativeLayout != null) {
                                    i6 = 2131363281;
                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131363281)) != null) {
                                        i6 = 2131363373;
                                        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(inflate, 2131363373);
                                        if (switchCompat != null) {
                                            i6 = 2131363548;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363548);
                                            if (toolbar != null) {
                                                i6 = 2131363668;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363668);
                                                if (textView != null) {
                                                    i6 = 2131363678;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363678);
                                                    if (textView2 != null) {
                                                        i6 = 2131363679;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363679);
                                                        if (textView3 != null) {
                                                            i6 = 2131363844;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131363844);
                                                            if (textView4 != null) {
                                                                i6 = 2131363901;
                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363901);
                                                                if (textView5 != null) {
                                                                    i6 = 2131363902;
                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131363902);
                                                                    if (textView6 != null) {
                                                                        i6 = 2131363903;
                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131363903);
                                                                        if (textView7 != null) {
                                                                            i6 = 2131363982;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate, 2131363982);
                                                                            if (textView8 != null) {
                                                                                i6 = 2131363993;
                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate, 2131363993);
                                                                                if (textView9 != null) {
                                                                                    i6 = 2131363998;
                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate, 2131363998);
                                                                                    if (textView10 != null) {
                                                                                        i6 = 2131364001;
                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate, 2131364001);
                                                                                        if (textView11 != null) {
                                                                                            i6 = 2131364206;
                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate, 2131364206);
                                                                                            if (textView12 != null) {
                                                                                                i6 = 2131364271;
                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate, 2131364271);
                                                                                                if (textView13 != null) {
                                                                                                    i6 = 2131364349;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate, 2131364349);
                                                                                                    if (textView14 != null) {
                                                                                                        i6 = 2131364350;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate, 2131364350);
                                                                                                        if (textView15 != null) {
                                                                                                            i6 = 2131364351;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate, 2131364351);
                                                                                                            if (textView16 != null) {
                                                                                                                i6 = 2131364352;
                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate, 2131364352);
                                                                                                                if (textView17 != null) {
                                                                                                                    i6 = 2131364375;
                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate, 2131364375);
                                                                                                                    if (textView18 != null) {
                                                                                                                        i6 = 2131364435;
                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate, 2131364435);
                                                                                                                        if (textView19 != null) {
                                                                                                                            i6 = 2131364500;
                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate, 2131364500);
                                                                                                                            if (textView20 != null) {
                                                                                                                                i6 = 2131364504;
                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(inflate, 2131364504);
                                                                                                                                if (textView21 != null) {
                                                                                                                                    i6 = 2131364506;
                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(inflate, 2131364506);
                                                                                                                                    if (textView22 != null) {
                                                                                                                                        i6 = 2131364507;
                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(inflate, 2131364507);
                                                                                                                                        if (textView23 != null) {
                                                                                                                                            i6 = 2131364508;
                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(inflate, 2131364508);
                                                                                                                                            if (textView24 != null) {
                                                                                                                                                i6 = 2131364607;
                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(inflate, 2131364607);
                                                                                                                                                if (textView25 != null) {
                                                                                                                                                    i6 = 2131364613;
                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(inflate, 2131364613);
                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                        i6 = 2131364640;
                                                                                                                                                        if (ViewBindings.findChildViewById(inflate, 2131364640) != null) {
                                                                                                                                                            return new t4.v((RelativeLayout) inflate, donutChartView, relativeLayout, switchCompat, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }

    private final Object e() {
        return t4.x0.a(((u4.d) this.f2264b).getLayoutInflater());
    }

    private final Object f() {
        View inflate = ((u4.w0) this.f2264b).getLayoutInflater().inflate(2131558444, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate;
        int i = 2131362787;
        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362787);
        if (findChildViewById != null) {
            i = 2131363082;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363082);
            if (recyclerView != null) {
                i = 2131364073;
                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364073);
                if (textView != null) {
                    i = 2131364217;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364217);
                    if (textView2 != null) {
                        return new t4.f(frameLayout, findChildViewById, recyclerView, textView, textView2);
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    private final Object g() {
        View inflate = ((u4.f1) this.f2264b).getLayoutInflater().inflate(2131558547, (ViewGroup) null, false);
        int i = 2131362306;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362306);
        if (imageView != null) {
            i = 2131362312;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362312);
            if (imageView2 != null) {
                i = 2131362350;
                if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362350)) != null) {
                    i = 2131362365;
                    if (((ImageView) ViewBindings.findChildViewById(inflate, 2131362365)) != null) {
                        i = 2131362681;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362681);
                        if (linearLayout != null) {
                            i = 2131362691;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362691);
                            if (linearLayout2 != null) {
                                i = 2131362790;
                                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362790);
                                if (findChildViewById != null) {
                                    i = 2131363123;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363123);
                                    if (relativeLayout != null) {
                                        i = 2131363212;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363212);
                                        if (relativeLayout2 != null) {
                                            i = 2131363213;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363213);
                                            if (relativeLayout3 != null) {
                                                i = 2131363321;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363321);
                                                if (recyclerView != null) {
                                                    i = 2131363453;
                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(inflate, 2131363453);
                                                    if (swipeRefreshLayout != null) {
                                                        i = 2131363975;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363975);
                                                        if (textView != null) {
                                                            i = 2131363978;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363978);
                                                            if (textView2 != null) {
                                                                i = 2131363980;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363980);
                                                                if (textView3 != null) {
                                                                    i = 2131364074;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364074);
                                                                    if (textView4 != null) {
                                                                        i = 2131364218;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364218);
                                                                        if (textView5 != null) {
                                                                            i = 2131364397;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131364397);
                                                                            if (textView6 != null) {
                                                                                return new t4.k((RelativeLayout) inflate, imageView, imageView2, linearLayout, linearLayout2, findChildViewById, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, swipeRefreshLayout, textView, textView2, textView3, textView4, textView5, textView6);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    private final Object h() {
        View inflate = ((u4.g1) this.f2264b).getLayoutInflater().inflate(2131558563, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate;
        int i = 2131362793;
        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362793);
        if (findChildViewById != null) {
            i = 2131363082;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363082);
            if (recyclerView != null) {
                i = 2131364076;
                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364076);
                if (textView != null) {
                    i = 2131364219;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364219);
                    if (textView2 != null) {
                        return new t4.o(frameLayout, findChildViewById, recyclerView, textView, textView2);
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    private final Object i() {
        View inflate = ((u4.m1) this.f2264b).getLayoutInflater().inflate(2131558570, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate;
        int i = 2131362692;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362692);
        if (linearLayout != null) {
            i = 2131362794;
            View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362794);
            if (findChildViewById != null) {
                i = 2131363083;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363083);
                if (recyclerView != null) {
                    i = 2131364077;
                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364077);
                    if (textView != null) {
                        i = 2131364220;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364220);
                        if (textView2 != null) {
                            return new t4.p(frameLayout, linearLayout, findChildViewById, recyclerView, textView, textView2);
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    private final Object j() {
        return t4.x0.a(((u4.z1) this.f2264b).getLayoutInflater());
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f2263a;
        int i6 = 2131363129;
        p6.x xVar = p6.x.f8463a;
        Object obj = this.f2264b;
        switch (i) {
            case 0:
                int i10 = PasswordRecoveryActivity.P;
                View inflate = ((PasswordRecoveryActivity) obj).getLayoutInflater().inflate(2131558767, (ViewGroup) null, false);
                int i11 = 2131362149;
                EditText editText = (EditText) ViewBindings.findChildViewById(inflate, 2131362149);
                if (editText != null) {
                    i11 = 2131362151;
                    EditText editText2 = (EditText) ViewBindings.findChildViewById(inflate, 2131362151);
                    if (editText2 != null) {
                        i11 = 2131362808;
                        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362808);
                        if (findChildViewById != null) {
                            i11 = 2131363556;
                            if (((Toolbar) ViewBindings.findChildViewById(inflate, 2131363556)) != null) {
                                i11 = 2131364214;
                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364214);
                                if (textView != null) {
                                    i11 = 2131364419;
                                    if (((TextView) ViewBindings.findChildViewById(inflate, 2131364419)) != null) {
                                        return new t4.g0((RelativeLayout) inflate, editText, editText2, findChildViewById, textView);
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                return null;
            case 1:
                int i12 = PublicListActivity.f3334e0;
                View inflate2 = ((PublicListActivity) obj).getLayoutInflater().inflate(2131558795, (ViewGroup) null, false);
                int i13 = 2131362809;
                View findChildViewById2 = ViewBindings.findChildViewById(inflate2, 2131362809);
                if (findChildViewById2 != null) {
                    i13 = 2131363340;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate2, 2131363340);
                    if (recyclerView != null) {
                        i13 = 2131363559;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate2, 2131363559);
                        if (toolbar != null) {
                            i13 = 2131364086;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364086);
                            if (textView2 != null) {
                                i13 = 2131364408;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate2, 2131364408);
                                if (textView3 != null) {
                                    return new t4.k0((RelativeLayout) inflate2, findChildViewById2, recyclerView, toolbar, textView2, textView3);
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate2.getResources().getResourceName(i13)));
                return null;
            case 2:
                int i14 = PublicProfileActivity.R;
                View inflate3 = ((PublicProfileActivity) obj).getLayoutInflater().inflate(2131558796, (ViewGroup) null, false);
                int i15 = 2131362313;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate3, 2131362313);
                if (imageView != null) {
                    i15 = 2131362384;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate3, 2131362384);
                    if (imageView2 != null) {
                        i15 = 2131362527;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate3, 2131362527);
                        if (imageView3 != null) {
                            i15 = 2131362616;
                            if (((LinearLayout) ViewBindings.findChildViewById(inflate3, 2131362616)) != null) {
                                i15 = 2131362658;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate3, 2131362658);
                                if (linearLayout != null) {
                                    i15 = 2131362659;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(inflate3, 2131362659);
                                    if (linearLayout2 != null) {
                                        i15 = 2131362729;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(inflate3, 2131362729);
                                        if (linearLayout3 != null) {
                                            i15 = 2131362768;
                                            if (((RelativeLayout) ViewBindings.findChildViewById(inflate3, 2131362768)) != null) {
                                                i15 = 2131362810;
                                                View findChildViewById3 = ViewBindings.findChildViewById(inflate3, 2131362810);
                                                if (findChildViewById3 != null) {
                                                    i15 = 2131363080;
                                                    View findChildViewById4 = ViewBindings.findChildViewById(inflate3, 2131363080);
                                                    if (findChildViewById4 != null) {
                                                        e2.d d10 = e2.d.d(findChildViewById4);
                                                        i15 = 2131363091;
                                                        View findChildViewById5 = ViewBindings.findChildViewById(inflate3, 2131363091);
                                                        if (findChildViewById5 != null) {
                                                            e2.d d11 = e2.d.d(findChildViewById5);
                                                            i15 = 2131363369;
                                                            ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(inflate3, 2131363369);
                                                            if (scrollView != null) {
                                                                i15 = 2131363560;
                                                                Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(inflate3, 2131363560);
                                                                if (toolbar2 != null) {
                                                                    i15 = 2131363849;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363849);
                                                                    if (textView4 != null) {
                                                                        i15 = 2131363869;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363869);
                                                                        if (textView5 != null) {
                                                                            i15 = 2131363881;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363881);
                                                                            if (textView6 != null) {
                                                                                i15 = 2131363882;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363882);
                                                                                if (textView7 != null) {
                                                                                    i15 = 2131363883;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363883);
                                                                                    if (textView8 != null) {
                                                                                        i15 = 2131363884;
                                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363884);
                                                                                        if (textView9 != null) {
                                                                                            i15 = 2131363885;
                                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(inflate3, 2131363885);
                                                                                            if (textView10 != null) {
                                                                                                i15 = 2131364054;
                                                                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(inflate3, 2131364054);
                                                                                                if (usernameTextView != null) {
                                                                                                    i15 = 2131364216;
                                                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364216);
                                                                                                    if (textView11 != null) {
                                                                                                        i15 = 2131364249;
                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364249);
                                                                                                        if (textView12 != null) {
                                                                                                            i15 = 2131364254;
                                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364254);
                                                                                                            if (textView13 != null) {
                                                                                                                i15 = 2131364452;
                                                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(inflate3, 2131364452);
                                                                                                                if (textView14 != null) {
                                                                                                                    i15 = 2131364667;
                                                                                                                    View findChildViewById6 = ViewBindings.findChildViewById(inflate3, 2131364667);
                                                                                                                    if (findChildViewById6 != null) {
                                                                                                                        return new t4.l0((RelativeLayout) inflate3, imageView, imageView2, imageView3, linearLayout, linearLayout2, linearLayout3, findChildViewById3, d10, d11, scrollView, toolbar2, textView4, textView5, textView6, textView7, textView8, textView9, textView10, usernameTextView, textView11, textView12, textView13, textView14, e2.d.d(findChildViewById6));
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate3.getResources().getResourceName(i15)));
                return null;
            case 3:
                int i16 = RepliesActivity.S;
                View inflate4 = ((RepliesActivity) obj).getLayoutInflater().inflate(2131558801, (ViewGroup) null, false);
                int i17 = 2131362157;
                EditText editText3 = (EditText) ViewBindings.findChildViewById(inflate4, 2131362157);
                if (editText3 != null) {
                    i17 = 2131362374;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(inflate4, 2131362374);
                    if (imageView4 != null) {
                        i17 = 2131362470;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(inflate4, 2131362470);
                        if (imageView5 != null) {
                            i17 = 2131362539;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(inflate4, 2131362539);
                            if (imageView6 != null) {
                                i17 = 2131362620;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(inflate4, 2131362620);
                                if (linearLayout4 != null) {
                                    i17 = 2131362812;
                                    View findChildViewById7 = ViewBindings.findChildViewById(inflate4, 2131362812);
                                    if (findChildViewById7 != null) {
                                        i17 = 2131362828;
                                        View findChildViewById8 = ViewBindings.findChildViewById(inflate4, 2131362828);
                                        if (findChildViewById8 != null) {
                                            i17 = 2131362947;
                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(inflate4, 2131362947);
                                            if (nestedScrollView != null) {
                                                i17 = 2131363089;
                                                View findChildViewById9 = ViewBindings.findChildViewById(inflate4, 2131363089);
                                                if (findChildViewById9 != null) {
                                                    t4.p0 a8 = t4.p0.a(findChildViewById9);
                                                    i17 = 2131363090;
                                                    View findChildViewById10 = ViewBindings.findChildViewById(inflate4, 2131363090);
                                                    if (findChildViewById10 != null) {
                                                        t4.q0 a10 = t4.q0.a(findChildViewById10);
                                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate4, 2131363129)) != null) {
                                                            i6 = 2131363131;
                                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate4, 2131363131);
                                                            if (relativeLayout != null) {
                                                                i6 = 2131363287;
                                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate4, 2131363287)) != null) {
                                                                    i6 = 2131363346;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(inflate4, 2131363346);
                                                                    if (recyclerView2 != null) {
                                                                        i6 = 2131363422;
                                                                        if (ViewBindings.findChildViewById(inflate4, 2131363422) != null) {
                                                                            i6 = 2131363562;
                                                                            Toolbar toolbar3 = (Toolbar) ViewBindings.findChildViewById(inflate4, 2131363562);
                                                                            if (toolbar3 != null) {
                                                                                i6 = 2131363602;
                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(inflate4, 2131363602);
                                                                                if (textView15 != null) {
                                                                                    i6 = 2131363645;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(inflate4, 2131363645);
                                                                                    if (textView16 != null) {
                                                                                        i6 = 2131364070;
                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(inflate4, 2131364070);
                                                                                        if (textView17 != null) {
                                                                                            i6 = 2131364412;
                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(inflate4, 2131364412);
                                                                                            if (textView18 != null) {
                                                                                                return new t4.o0((RelativeLayout) inflate4, editText3, imageView4, imageView5, imageView6, linearLayout4, findChildViewById7, findChildViewById8, nestedScrollView, a8, a10, relativeLayout, recyclerView2, toolbar3, textView15, textView16, textView17, textView18);
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate4.getResources().getResourceName(i6)));
                                                        return null;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i6 = i17;
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate4.getResources().getResourceName(i6)));
                return null;
            case 4:
                int i18 = ReviewsActivity.T;
                View inflate5 = ((ReviewsActivity) obj).getLayoutInflater().inflate(2131558806, (ViewGroup) null, false);
                int i19 = 2131362158;
                EditText editText4 = (EditText) ViewBindings.findChildViewById(inflate5, 2131362158);
                if (editText4 != null) {
                    i19 = 2131362256;
                    if (((HorizontalScrollView) ViewBindings.findChildViewById(inflate5, 2131362256)) != null) {
                        i19 = 2131362292;
                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362292);
                        if (imageView7 != null) {
                            i19 = 2131362471;
                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362471);
                            if (imageView8 != null) {
                                i19 = 2131362487;
                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362487);
                                if (imageView9 != null) {
                                    i19 = 2131362493;
                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362493);
                                    if (imageView10 != null) {
                                        i19 = 2131362499;
                                        ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362499);
                                        if (imageView11 != null) {
                                            i19 = 2131362505;
                                            ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362505);
                                            if (imageView12 != null) {
                                                i19 = 2131362511;
                                                ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(inflate5, 2131362511);
                                                if (imageView13 != null) {
                                                    i19 = 2131362625;
                                                    LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(inflate5, 2131362625);
                                                    if (linearLayout5 != null) {
                                                        i19 = 2131362703;
                                                        if (((LinearLayout) ViewBindings.findChildViewById(inflate5, 2131362703)) != null) {
                                                            i19 = 2131362813;
                                                            View findChildViewById11 = ViewBindings.findChildViewById(inflate5, 2131362813);
                                                            if (findChildViewById11 != null) {
                                                                i19 = 2131362948;
                                                                NestedScrollView nestedScrollView2 = (NestedScrollView) ViewBindings.findChildViewById(inflate5, 2131362948);
                                                                if (nestedScrollView2 != null) {
                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(inflate5, 2131363129)) != null) {
                                                                        i6 = 2131363189;
                                                                        if (((RelativeLayout) ViewBindings.findChildViewById(inflate5, 2131363189)) != null) {
                                                                            i6 = 2131363347;
                                                                            RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(inflate5, 2131363347);
                                                                            if (recyclerView3 != null) {
                                                                                i6 = 2131363563;
                                                                                Toolbar toolbar4 = (Toolbar) ViewBindings.findChildViewById(inflate5, 2131363563);
                                                                                if (toolbar4 != null) {
                                                                                    i6 = 2131363632;
                                                                                    TextView textView19 = (TextView) ViewBindings.findChildViewById(inflate5, 2131363632);
                                                                                    if (textView19 != null) {
                                                                                        i6 = 2131363647;
                                                                                        TextView textView20 = (TextView) ViewBindings.findChildViewById(inflate5, 2131363647);
                                                                                        if (textView20 != null) {
                                                                                            i6 = 2131363657;
                                                                                            TextView textView21 = (TextView) ViewBindings.findChildViewById(inflate5, 2131363657);
                                                                                            if (textView21 != null) {
                                                                                                i6 = 2131364081;
                                                                                                TextView textView22 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364081);
                                                                                                if (textView22 != null) {
                                                                                                    i6 = 2131364128;
                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364128);
                                                                                                    if (textView23 != null) {
                                                                                                        i6 = 2131364129;
                                                                                                        TextView textView24 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364129);
                                                                                                        if (textView24 != null) {
                                                                                                            i6 = 2131364130;
                                                                                                            TextView textView25 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364130);
                                                                                                            if (textView25 != null) {
                                                                                                                i6 = 2131364440;
                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(inflate5, 2131364440);
                                                                                                                if (textView26 != null) {
                                                                                                                    return new t4.r0((RelativeLayout) inflate5, editText4, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, imageView13, linearLayout5, findChildViewById11, nestedScrollView2, recyclerView3, toolbar4, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate5.getResources().getResourceName(i6)));
                                                                    return null;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i6 = i19;
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate5.getResources().getResourceName(i6)));
                return null;
            case 5:
                int i20 = RollbackActivity.f3344f0;
                View inflate6 = ((RollbackActivity) obj).getLayoutInflater().inflate(2131558807, (ViewGroup) null, false);
                int i21 = 2131362814;
                View findChildViewById12 = ViewBindings.findChildViewById(inflate6, 2131362814);
                if (findChildViewById12 != null) {
                    i21 = 2131363084;
                    RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(inflate6, 2131363084);
                    if (recyclerView4 != null) {
                        i21 = 2131363564;
                        Toolbar toolbar5 = (Toolbar) ViewBindings.findChildViewById(inflate6, 2131363564);
                        if (toolbar5 != null) {
                            i21 = 2131363889;
                            TextView textView27 = (TextView) ViewBindings.findChildViewById(inflate6, 2131363889);
                            if (textView27 != null) {
                                i21 = 2131364083;
                                TextView textView28 = (TextView) ViewBindings.findChildViewById(inflate6, 2131364083);
                                if (textView28 != null) {
                                    i21 = 2131364345;
                                    TextView textView29 = (TextView) ViewBindings.findChildViewById(inflate6, 2131364345);
                                    if (textView29 != null) {
                                        i21 = 2131364413;
                                        TextView textView30 = (TextView) ViewBindings.findChildViewById(inflate6, 2131364413);
                                        if (textView30 != null) {
                                            return new t4.s0((RelativeLayout) inflate6, findChildViewById12, recyclerView4, toolbar5, textView27, textView28, textView29, textView30);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate6.getResources().getResourceName(i21)));
                return null;
            case 6:
                int i22 = SearchActivity.Y;
                View inflate7 = ((SearchActivity) obj).getLayoutInflater().inflate(2131558811, (ViewGroup) null, false);
                int i23 = 2131362181;
                if (((FrameLayout) ViewBindings.findChildViewById(inflate7, 2131362181)) != null) {
                    i23 = 2131362269;
                    View findChildViewById13 = ViewBindings.findChildViewById(inflate7, 2131362269);
                    if (findChildViewById13 != null) {
                        int i24 = 2131361902;
                        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) ViewBindings.findChildViewById(findChildViewById13, 2131361902);
                        if (instantAutoCompleteTextView != null) {
                            i24 = 2131362309;
                            if (((ImageView) ViewBindings.findChildViewById(findChildViewById13, 2131362309)) != null) {
                                i24 = 2131362342;
                                ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(findChildViewById13, 2131362342);
                                if (imageView14 != null) {
                                    i24 = 2131362551;
                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(findChildViewById13, 2131362551);
                                    if (imageView15 != null) {
                                        i24 = 2131363238;
                                        if (((RelativeLayout) ViewBindings.findChildViewById(findChildViewById13, 2131363238)) != null) {
                                            y2.s sVar = new y2.s((RelativeLayout) findChildViewById13, instantAutoCompleteTextView, imageView14, imageView15, 14);
                                            i23 = 2131362734;
                                            if (((LinearLayout) ViewBindings.findChildViewById(inflate7, 2131362734)) != null) {
                                                i23 = 2131362815;
                                                View findChildViewById14 = ViewBindings.findChildViewById(inflate7, 2131362815);
                                                if (findChildViewById14 != null) {
                                                    i23 = 2131363349;
                                                    RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(inflate7, 2131363349);
                                                    if (recyclerView5 != null) {
                                                        i23 = 2131363658;
                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(inflate7, 2131363658);
                                                        if (textView31 != null) {
                                                            i23 = 2131363705;
                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(inflate7, 2131363705);
                                                            if (textView32 != null) {
                                                                i23 = 2131364019;
                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(inflate7, 2131364019);
                                                                if (textView33 != null) {
                                                                    return new t4.u0((RelativeLayout) inflate7, sVar, findChildViewById14, recyclerView5, textView31, textView32, textView33);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(findChildViewById13.getResources().getResourceName(i24)));
                        return null;
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate7.getResources().getResourceName(i23)));
                return null;
            case 7:
                int i25 = SecurityActivity.f3349g0;
                View inflate8 = ((SecurityActivity) obj).getLayoutInflater().inflate(2131558815, (ViewGroup) null, false);
                int i26 = 2131362453;
                if (((AppCompatImageView) ViewBindings.findChildViewById(inflate8, 2131362453)) != null) {
                    i26 = 2131362816;
                    View findChildViewById15 = ViewBindings.findChildViewById(inflate8, 2131362816);
                    if (findChildViewById15 != null) {
                        i26 = 2131363181;
                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(inflate8, 2131363181);
                        if (linearLayout6 != null) {
                            i26 = 2131363336;
                            RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(inflate8, 2131363336);
                            if (recyclerView6 != null) {
                                i26 = 2131363557;
                                Toolbar toolbar6 = (Toolbar) ViewBindings.findChildViewById(inflate8, 2131363557);
                                if (toolbar6 != null) {
                                    i26 = 2131363687;
                                    TextView textView34 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363687);
                                    if (textView34 != null) {
                                        i26 = 2131363941;
                                        TextView textView35 = (TextView) ViewBindings.findChildViewById(inflate8, 2131363941);
                                        if (textView35 != null) {
                                            i26 = 2131364399;
                                            TextView textView36 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364399);
                                            if (textView36 != null) {
                                                i26 = 2131364450;
                                                TextView textView37 = (TextView) ViewBindings.findChildViewById(inflate8, 2131364450);
                                                if (textView37 != null) {
                                                    return new t4.w0((RelativeLayout) inflate8, findChildViewById15, linearLayout6, recyclerView6, toolbar6, textView34, textView35, textView36, textView37);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate8.getResources().getResourceName(i26)));
                return null;
            case 8:
                int i27 = UserActivity.W;
                View inflate9 = ((UserActivity) obj).getLayoutInflater().inflate(2131558863, (ViewGroup) null, false);
                int i28 = 2131362528;
                ImageView imageView16 = (ImageView) ViewBindings.findChildViewById(inflate9, 2131362528);
                if (imageView16 != null) {
                    i28 = 2131362540;
                    ImageView imageView17 = (ImageView) ViewBindings.findChildViewById(inflate9, 2131362540);
                    if (imageView17 != null) {
                        i28 = 2131362653;
                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362653);
                        if (linearLayout7 != null) {
                            i28 = 2131362680;
                            LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362680);
                            if (linearLayout8 != null) {
                                i28 = 2131362689;
                                LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362689);
                                if (linearLayout9 != null) {
                                    i28 = 2131362690;
                                    LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362690);
                                    if (linearLayout10 != null) {
                                        i28 = 2131362695;
                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362695);
                                        if (linearLayout11 != null) {
                                            i28 = 2131362730;
                                            LinearLayout linearLayout12 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362730);
                                            if (linearLayout12 != null) {
                                                i28 = 2131362731;
                                                LinearLayout linearLayout13 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362731);
                                                if (linearLayout13 != null) {
                                                    i28 = 2131362736;
                                                    LinearLayout linearLayout14 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362736);
                                                    if (linearLayout14 != null) {
                                                        i28 = 2131362745;
                                                        LinearLayout linearLayout15 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362745);
                                                        if (linearLayout15 != null) {
                                                            i28 = 2131362748;
                                                            LinearLayout linearLayout16 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362748);
                                                            if (linearLayout16 != null) {
                                                                i28 = 2131362754;
                                                                LinearLayout linearLayout17 = (LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362754);
                                                                if (linearLayout17 != null) {
                                                                    i28 = 2131362763;
                                                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate9, 2131362763)) != null) {
                                                                        i28 = 2131363171;
                                                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363171);
                                                                        if (relativeLayout2 != null) {
                                                                            i28 = 2131363198;
                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363198)) != null) {
                                                                                i28 = 2131363203;
                                                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363203)) != null) {
                                                                                    i28 = 2131363257;
                                                                                    if (((RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363257)) != null) {
                                                                                        i28 = 2131363282;
                                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363282);
                                                                                        if (relativeLayout3 != null) {
                                                                                            i28 = 2131363285;
                                                                                            if (((RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363285)) != null) {
                                                                                                i28 = 2131363286;
                                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(inflate9, 2131363286);
                                                                                                if (relativeLayout4 != null) {
                                                                                                    i28 = 2131363484;
                                                                                                    if (((ScrollView) ViewBindings.findChildViewById(inflate9, 2131363484)) != null) {
                                                                                                        i28 = 2131363571;
                                                                                                        Toolbar toolbar7 = (Toolbar) ViewBindings.findChildViewById(inflate9, 2131363571);
                                                                                                        if (toolbar7 != null) {
                                                                                                            i28 = 2131363847;
                                                                                                            TextView textView38 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363847);
                                                                                                            if (textView38 != null) {
                                                                                                                i28 = 2131363870;
                                                                                                                TextView textView39 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363870);
                                                                                                                if (textView39 != null) {
                                                                                                                    i28 = 2131363969;
                                                                                                                    TextView textView40 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363969);
                                                                                                                    if (textView40 != null) {
                                                                                                                        i28 = 2131363970;
                                                                                                                        TextView textView41 = (TextView) ViewBindings.findChildViewById(inflate9, 2131363970);
                                                                                                                        if (textView41 != null) {
                                                                                                                            i28 = 2131364023;
                                                                                                                            TextView textView42 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364023);
                                                                                                                            if (textView42 != null) {
                                                                                                                                i28 = 2131364024;
                                                                                                                                TextView textView43 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364024);
                                                                                                                                if (textView43 != null) {
                                                                                                                                    i28 = 2131364101;
                                                                                                                                    TextView textView44 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364101);
                                                                                                                                    if (textView44 != null) {
                                                                                                                                        i28 = 2131364102;
                                                                                                                                        TextView textView45 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364102);
                                                                                                                                        if (textView45 != null) {
                                                                                                                                            i28 = 2131364103;
                                                                                                                                            TextView textView46 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364103);
                                                                                                                                            if (textView46 != null) {
                                                                                                                                                i28 = 2131364252;
                                                                                                                                                TextView textView47 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364252);
                                                                                                                                                if (textView47 != null) {
                                                                                                                                                    i28 = 2131364256;
                                                                                                                                                    TextView textView48 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364256);
                                                                                                                                                    if (textView48 != null) {
                                                                                                                                                        i28 = 2131364264;
                                                                                                                                                        TextView textView49 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364264);
                                                                                                                                                        if (textView49 != null) {
                                                                                                                                                            i28 = 2131364274;
                                                                                                                                                            TextView textView50 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364274);
                                                                                                                                                            if (textView50 != null) {
                                                                                                                                                                i28 = 2131364328;
                                                                                                                                                                TextView textView51 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364328);
                                                                                                                                                                if (textView51 != null) {
                                                                                                                                                                    i28 = 2131364455;
                                                                                                                                                                    TextView textView52 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364455);
                                                                                                                                                                    if (textView52 != null) {
                                                                                                                                                                        i28 = 2131364477;
                                                                                                                                                                        TextView textView53 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364477);
                                                                                                                                                                        if (textView53 != null) {
                                                                                                                                                                            i28 = 2131364478;
                                                                                                                                                                            TextView textView54 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364478);
                                                                                                                                                                            if (textView54 != null) {
                                                                                                                                                                                i28 = 2131364510;
                                                                                                                                                                                TextView textView55 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364510);
                                                                                                                                                                                if (textView55 != null) {
                                                                                                                                                                                    i28 = 2131364533;
                                                                                                                                                                                    UsernameTextView usernameTextView2 = (UsernameTextView) ViewBindings.findChildViewById(inflate9, 2131364533);
                                                                                                                                                                                    if (usernameTextView2 != null) {
                                                                                                                                                                                        i28 = 2131364606;
                                                                                                                                                                                        TextView textView56 = (TextView) ViewBindings.findChildViewById(inflate9, 2131364606);
                                                                                                                                                                                        if (textView56 != null) {
                                                                                                                                                                                            return new t4.z0((RelativeLayout) inflate9, imageView16, imageView17, linearLayout7, linearLayout8, linearLayout9, linearLayout10, linearLayout11, linearLayout12, linearLayout13, linearLayout14, linearLayout15, linearLayout16, linearLayout17, relativeLayout2, relativeLayout3, relativeLayout4, toolbar7, textView38, textView39, textView40, textView41, textView42, textView43, textView44, textView45, textView46, textView47, textView48, textView49, textView50, textView51, textView52, textView53, textView54, textView55, usernameTextView2, textView56);
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate9.getResources().getResourceName(i28)));
                return null;
            case 9:
                int i29 = UserAvatarActivity.V;
                View inflate10 = ((UserAvatarActivity) obj).getLayoutInflater().inflate(2131558865, (ViewGroup) null, false);
                int i30 = 2131362523;
                ImageView imageView18 = (ImageView) ViewBindings.findChildViewById(inflate10, 2131362523);
                if (imageView18 != null) {
                    i30 = 2131362749;
                    LinearLayout linearLayout18 = (LinearLayout) ViewBindings.findChildViewById(inflate10, 2131362749);
                    if (linearLayout18 != null) {
                        i30 = 2131362788;
                        View findChildViewById16 = ViewBindings.findChildViewById(inflate10, 2131362788);
                        if (findChildViewById16 != null) {
                            i30 = 2131363315;
                            RecyclerView recyclerView7 = (RecyclerView) ViewBindings.findChildViewById(inflate10, 2131363315);
                            if (recyclerView7 != null) {
                                i30 = 2131363356;
                                RecyclerView recyclerView8 = (RecyclerView) ViewBindings.findChildViewById(inflate10, 2131363356);
                                if (recyclerView8 != null) {
                                    i30 = 2131363534;
                                    Toolbar toolbar8 = (Toolbar) ViewBindings.findChildViewById(inflate10, 2131363534);
                                    if (toolbar8 != null) {
                                        i30 = 2131363671;
                                        TextView textView57 = (TextView) ViewBindings.findChildViewById(inflate10, 2131363671);
                                        if (textView57 != null) {
                                            i30 = 2131364257;
                                            TextView textView58 = (TextView) ViewBindings.findChildViewById(inflate10, 2131364257);
                                            if (textView58 != null) {
                                                i30 = 2131364368;
                                                TextView textView59 = (TextView) ViewBindings.findChildViewById(inflate10, 2131364368);
                                                if (textView59 != null) {
                                                    i30 = 2131364445;
                                                    TextView textView60 = (TextView) ViewBindings.findChildViewById(inflate10, 2131364445);
                                                    if (textView60 != null) {
                                                        i30 = 2131364475;
                                                        TextView textView61 = (TextView) ViewBindings.findChildViewById(inflate10, 2131364475);
                                                        if (textView61 != null) {
                                                            return new t4.a1((RelativeLayout) inflate10, imageView18, linearLayout18, findChildViewById16, recyclerView7, recyclerView8, toolbar8, textView57, textView58, textView59, textView60, textView61);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate10.getResources().getResourceName(i30)));
                return null;
            case 10:
                int i31 = UserCommentsActivity.S;
                View inflate11 = ((UserCommentsActivity) obj).getLayoutInflater().inflate(2131558867, (ViewGroup) null, false);
                int i32 = 2131362820;
                View findChildViewById17 = ViewBindings.findChildViewById(inflate11, 2131362820);
                if (findChildViewById17 != null) {
                    i32 = 2131363360;
                    RecyclerView recyclerView9 = (RecyclerView) ViewBindings.findChildViewById(inflate11, 2131363360);
                    if (recyclerView9 != null) {
                        i32 = 2131363572;
                        Toolbar toolbar9 = (Toolbar) ViewBindings.findChildViewById(inflate11, 2131363572);
                        if (toolbar9 != null) {
                            i32 = 2131363857;
                            TextView textView62 = (TextView) ViewBindings.findChildViewById(inflate11, 2131363857);
                            if (textView62 != null) {
                                i32 = 2131364456;
                                TextView textView63 = (TextView) ViewBindings.findChildViewById(inflate11, 2131364456);
                                if (textView63 != null) {
                                    return new t4.b1((RelativeLayout) inflate11, findChildViewById17, recyclerView9, toolbar9, textView62, textView63);
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate11.getResources().getResourceName(i32)));
                return null;
            case 11:
                int i33 = UserDeviceDetailsActivity.T;
                View inflate12 = ((UserDeviceDetailsActivity) obj).getLayoutInflater().inflate(2131558869, (ViewGroup) null, false);
                int i34 = 2131362348;
                ImageView imageView19 = (ImageView) ViewBindings.findChildViewById(inflate12, 2131362348);
                if (imageView19 != null) {
                    i34 = 2131362361;
                    ImageView imageView20 = (ImageView) ViewBindings.findChildViewById(inflate12, 2131362361);
                    if (imageView20 != null) {
                        i34 = 2131362535;
                        ImageView imageView21 = (ImageView) ViewBindings.findChildViewById(inflate12, 2131362535);
                        if (imageView21 != null) {
                            i34 = 2131362641;
                            LinearLayout linearLayout19 = (LinearLayout) ViewBindings.findChildViewById(inflate12, 2131362641);
                            if (linearLayout19 != null) {
                                i34 = 2131362821;
                                View findChildViewById18 = ViewBindings.findChildViewById(inflate12, 2131362821);
                                if (findChildViewById18 != null) {
                                    i34 = 2131363064;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(inflate12, 2131363064);
                                    if (radioButton != null) {
                                        i34 = 2131363066;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(inflate12, 2131363066);
                                        if (radioButton2 != null) {
                                            i34 = 2131363095;
                                            RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(inflate12, 2131363095);
                                            if (radioGroup != null) {
                                                i34 = 2131363359;
                                                RecyclerView recyclerView10 = (RecyclerView) ViewBindings.findChildViewById(inflate12, 2131363359);
                                                if (recyclerView10 != null) {
                                                    i34 = 2131363573;
                                                    Toolbar toolbar10 = (Toolbar) ViewBindings.findChildViewById(inflate12, 2131363573);
                                                    if (toolbar10 != null) {
                                                        i34 = 2131363683;
                                                        TextView textView64 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363683);
                                                        if (textView64 != null) {
                                                            i34 = 2131363684;
                                                            TextView textView65 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363684);
                                                            if (textView65 != null) {
                                                                i34 = 2131363797;
                                                                TextView textView66 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363797);
                                                                if (textView66 != null) {
                                                                    i34 = 2131363801;
                                                                    TextView textView67 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363801);
                                                                    if (textView67 != null) {
                                                                        i34 = 2131363943;
                                                                        TextView textView68 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363943);
                                                                        if (textView68 != null) {
                                                                            i34 = 2131363944;
                                                                            TextView textView69 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363944);
                                                                            if (textView69 != null) {
                                                                                i34 = 2131363999;
                                                                                TextView textView70 = (TextView) ViewBindings.findChildViewById(inflate12, 2131363999);
                                                                                if (textView70 != null) {
                                                                                    i34 = 2131364000;
                                                                                    TextView textView71 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364000);
                                                                                    if (textView71 != null) {
                                                                                        i34 = 2131364084;
                                                                                        if (((TextView) ViewBindings.findChildViewById(inflate12, 2131364084)) != null) {
                                                                                            i34 = 2131364168;
                                                                                            TextView textView72 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364168);
                                                                                            if (textView72 != null) {
                                                                                                i34 = 2131364169;
                                                                                                TextView textView73 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364169);
                                                                                                if (textView73 != null) {
                                                                                                    i34 = 2131364491;
                                                                                                    TextView textView74 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364491);
                                                                                                    if (textView74 != null) {
                                                                                                        i34 = 2131364513;
                                                                                                        TextView textView75 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364513);
                                                                                                        if (textView75 != null) {
                                                                                                            i34 = 2131364519;
                                                                                                            TextView textView76 = (TextView) ViewBindings.findChildViewById(inflate12, 2131364519);
                                                                                                            if (textView76 != null) {
                                                                                                                return new t4.d1((RelativeLayout) inflate12, imageView19, imageView20, imageView21, linearLayout19, findChildViewById18, radioButton, radioButton2, radioGroup, recyclerView10, toolbar10, textView64, textView65, textView66, textView67, textView68, textView69, textView70, textView71, textView72, textView73, textView74, textView75, textView76);
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate12.getResources().getResourceName(i34)));
                return null;
            case 12:
                int i35 = UserDevicesActivity.R;
                View inflate13 = ((UserDevicesActivity) obj).getLayoutInflater().inflate(2131558871, (ViewGroup) null, false);
                int i36 = 2131362822;
                View findChildViewById19 = ViewBindings.findChildViewById(inflate13, 2131362822);
                if (findChildViewById19 != null) {
                    i36 = 2131362951;
                    NestedScrollView nestedScrollView3 = (NestedScrollView) ViewBindings.findChildViewById(inflate13, 2131362951);
                    if (nestedScrollView3 != null) {
                        i36 = 2131363361;
                        RecyclerView recyclerView11 = (RecyclerView) ViewBindings.findChildViewById(inflate13, 2131363361);
                        if (recyclerView11 != null) {
                            i36 = 2131363574;
                            Toolbar toolbar11 = (Toolbar) ViewBindings.findChildViewById(inflate13, 2131363574);
                            if (toolbar11 != null) {
                                i36 = 2131364133;
                                TextView textView77 = (TextView) ViewBindings.findChildViewById(inflate13, 2131364133);
                                if (textView77 != null) {
                                    i36 = 2131364360;
                                    TextView textView78 = (TextView) ViewBindings.findChildViewById(inflate13, 2131364360);
                                    if (textView78 != null) {
                                        i36 = 2131364520;
                                        TextView textView79 = (TextView) ViewBindings.findChildViewById(inflate13, 2131364520);
                                        if (textView79 != null) {
                                            i36 = 2131364626;
                                            View findChildViewById20 = ViewBindings.findChildViewById(inflate13, 2131364626);
                                            if (findChildViewById20 != null) {
                                                return new t4.e1((RelativeLayout) inflate13, findChildViewById19, nestedScrollView3, recyclerView11, toolbar11, textView77, textView78, textView79, t4.c1.a(findChildViewById20));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate13.getResources().getResourceName(i36)));
                return null;
            case 13:
                int i37 = UserEditProfileActivity.R;
                View inflate14 = ((UserEditProfileActivity) obj).getLayoutInflater().inflate(2131558872, (ViewGroup) null, false);
                int i38 = 2131362623;
                LinearLayout linearLayout20 = (LinearLayout) ViewBindings.findChildViewById(inflate14, 2131362623);
                if (linearLayout20 != null) {
                    i38 = 2131362683;
                    LinearLayout linearLayout21 = (LinearLayout) ViewBindings.findChildViewById(inflate14, 2131362683);
                    if (linearLayout21 != null) {
                        i38 = 2131362705;
                        LinearLayout linearLayout22 = (LinearLayout) ViewBindings.findChildViewById(inflate14, 2131362705);
                        if (linearLayout22 != null) {
                            i38 = 2131362771;
                            LinearLayout linearLayout23 = (LinearLayout) ViewBindings.findChildViewById(inflate14, 2131362771);
                            if (linearLayout23 != null) {
                                i38 = 2131363568;
                                Toolbar toolbar12 = (Toolbar) ViewBindings.findChildViewById(inflate14, 2131363568);
                                if (toolbar12 != null) {
                                    i38 = 2131363670;
                                    TextView textView80 = (TextView) ViewBindings.findChildViewById(inflate14, 2131363670);
                                    if (textView80 != null) {
                                        i38 = 2131363981;
                                        TextView textView81 = (TextView) ViewBindings.findChildViewById(inflate14, 2131363981);
                                        if (textView81 != null) {
                                            i38 = 2131364146;
                                            TextView textView82 = (TextView) ViewBindings.findChildViewById(inflate14, 2131364146);
                                            if (textView82 != null) {
                                                i38 = 2131364422;
                                                TextView textView83 = (TextView) ViewBindings.findChildViewById(inflate14, 2131364422);
                                                if (textView83 != null) {
                                                    i38 = 2131364532;
                                                    TextView textView84 = (TextView) ViewBindings.findChildViewById(inflate14, 2131364532);
                                                    if (textView84 != null) {
                                                        i38 = 2131364632;
                                                        if (ViewBindings.findChildViewById(inflate14, 2131364632) != null) {
                                                            return new t4.f1((RelativeLayout) inflate14, linearLayout20, linearLayout21, linearLayout22, linearLayout23, toolbar12, textView80, textView81, textView82, textView83, textView84);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate14.getResources().getResourceName(i38)));
                return null;
            case 14:
                int i39 = UsernameEditActivity.R;
                View inflate15 = ((UsernameEditActivity) obj).getLayoutInflater().inflate(2131558876, (ViewGroup) null, false);
                int i40 = 2131362161;
                EditText editText5 = (EditText) ViewBindings.findChildViewById(inflate15, 2131362161);
                if (editText5 != null) {
                    i40 = 2131362406;
                    ImageView imageView22 = (ImageView) ViewBindings.findChildViewById(inflate15, 2131362406);
                    if (imageView22 != null) {
                        i40 = 2131362407;
                        ImageView imageView23 = (ImageView) ViewBindings.findChildViewById(inflate15, 2131362407);
                        if (imageView23 != null) {
                            i40 = 2131362408;
                            ImageView imageView24 = (ImageView) ViewBindings.findChildViewById(inflate15, 2131362408);
                            if (imageView24 != null) {
                                i40 = 2131362524;
                                ImageView imageView25 = (ImageView) ViewBindings.findChildViewById(inflate15, 2131362524);
                                if (imageView25 != null) {
                                    i40 = 2131362750;
                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate15, 2131362750)) != null) {
                                        i40 = 2131362751;
                                        LinearLayout linearLayout24 = (LinearLayout) ViewBindings.findChildViewById(inflate15, 2131362751);
                                        if (linearLayout24 != null) {
                                            i40 = 2131362752;
                                            LinearLayout linearLayout25 = (LinearLayout) ViewBindings.findChildViewById(inflate15, 2131362752);
                                            if (linearLayout25 != null) {
                                                i40 = 2131362753;
                                                LinearLayout linearLayout26 = (LinearLayout) ViewBindings.findChildViewById(inflate15, 2131362753);
                                                if (linearLayout26 != null) {
                                                    i40 = 2131362755;
                                                    if (((LinearLayout) ViewBindings.findChildViewById(inflate15, 2131362755)) != null) {
                                                        i40 = 2131362823;
                                                        View findChildViewById21 = ViewBindings.findChildViewById(inflate15, 2131362823);
                                                        if (findChildViewById21 != null) {
                                                            i40 = 2131363075;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(inflate15, 2131363075);
                                                            if (radioButton3 != null) {
                                                                i40 = 2131363076;
                                                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(inflate15, 2131363076);
                                                                if (radioButton4 != null) {
                                                                    i40 = 2131363077;
                                                                    RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(inflate15, 2131363077);
                                                                    if (radioButton5 != null) {
                                                                        i40 = 2131363078;
                                                                        RadioButton radioButton6 = (RadioButton) ViewBindings.findChildViewById(inflate15, 2131363078);
                                                                        if (radioButton6 != null) {
                                                                            i40 = 2131363575;
                                                                            Toolbar toolbar13 = (Toolbar) ViewBindings.findChildViewById(inflate15, 2131363575);
                                                                            if (toolbar13 != null) {
                                                                                i40 = 2131363986;
                                                                                TextView textView85 = (TextView) ViewBindings.findChildViewById(inflate15, 2131363986);
                                                                                if (textView85 != null) {
                                                                                    i40 = 2131363995;
                                                                                    TextView textView86 = (TextView) ViewBindings.findChildViewById(inflate15, 2131363995);
                                                                                    if (textView86 != null) {
                                                                                        i40 = 2131364420;
                                                                                        TextView textView87 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364420);
                                                                                        if (textView87 != null) {
                                                                                            i40 = 2131364479;
                                                                                            TextView textView88 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364479);
                                                                                            if (textView88 != null) {
                                                                                                i40 = 2131364480;
                                                                                                TextView textView89 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364480);
                                                                                                if (textView89 != null) {
                                                                                                    i40 = 2131364484;
                                                                                                    TextView textView90 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364484);
                                                                                                    if (textView90 != null) {
                                                                                                        i40 = 2131364524;
                                                                                                        TextView textView91 = (TextView) ViewBindings.findChildViewById(inflate15, 2131364524);
                                                                                                        if (textView91 != null) {
                                                                                                            i40 = 2131364528;
                                                                                                            UsernameTextView usernameTextView3 = (UsernameTextView) ViewBindings.findChildViewById(inflate15, 2131364528);
                                                                                                            if (usernameTextView3 != null) {
                                                                                                                i40 = 2131364529;
                                                                                                                UsernameTextView usernameTextView4 = (UsernameTextView) ViewBindings.findChildViewById(inflate15, 2131364529);
                                                                                                                if (usernameTextView4 != null) {
                                                                                                                    i40 = 2131364530;
                                                                                                                    UsernameTextView usernameTextView5 = (UsernameTextView) ViewBindings.findChildViewById(inflate15, 2131364530);
                                                                                                                    if (usernameTextView5 != null) {
                                                                                                                        i40 = 2131364531;
                                                                                                                        UsernameTextView usernameTextView6 = (UsernameTextView) ViewBindings.findChildViewById(inflate15, 2131364531);
                                                                                                                        if (usernameTextView6 != null) {
                                                                                                                            return new t4.h1((RelativeLayout) inflate15, editText5, imageView22, imageView23, imageView24, imageView25, linearLayout24, linearLayout25, linearLayout26, findChildViewById21, radioButton3, radioButton4, radioButton5, radioButton6, toolbar13, textView85, textView86, textView87, textView88, textView89, textView90, textView91, usernameTextView3, usernameTextView4, usernameTextView5, usernameTextView6);
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate15.getResources().getResourceName(i40)));
                return null;
            case 15:
                return a();
            case 16:
                return b();
            case 17:
                return c();
            case 18:
                return d();
            case 19:
                return obj;
            case 20:
                ((ProgressBar) obj).setVisibility(8);
                return xVar;
            case 21:
                ((m5.f) obj).f7375a = false;
                return xVar;
            case 22:
                return kotlin.jvm.internal.a0.d((Object[]) obj);
            case 23:
                return e();
            case 24:
                return f();
            case 25:
                return g();
            case 26:
                return h();
            case 27:
                return i();
            case 28:
                return j();
            default:
                ((WebChromeClient.CustomViewCallback) obj).onCustomViewHidden();
                return xVar;
        }
    }
}
