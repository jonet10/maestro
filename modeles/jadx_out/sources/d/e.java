package d;

import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.l;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import j$.util.DesugarTimeZone;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class e {
    public static final Charset A;
    public static final byte[] B;
    public static final List j = Arrays.asList(1, 6, 3, 8);

    /* renamed from: k, reason: collision with root package name */
    public static final List f3512k = Arrays.asList(2, 7, 4, 5);

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f3513l = {8, 8, 8};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f3514m = {8};

    /* renamed from: n, reason: collision with root package name */
    public static final byte[] f3515n = {-1, -40, -1};

    /* renamed from: o, reason: collision with root package name */
    public static final byte[] f3516o = {79, 76, 89, 77, 80, 0};

    /* renamed from: p, reason: collision with root package name */
    public static final byte[] f3517p = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: q, reason: collision with root package name */
    public static final String[] f3518q = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};

    /* renamed from: r, reason: collision with root package name */
    public static final int[] f3519r = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};

    /* renamed from: s, reason: collision with root package name */
    public static final byte[] f3520s = {65, 83, 67, 73, 73, 0, 0, 0};

    /* renamed from: t, reason: collision with root package name */
    public static final c f3521t;

    /* renamed from: u, reason: collision with root package name */
    public static final c[][] f3522u;
    public static final c[] v;

    /* renamed from: w, reason: collision with root package name */
    public static final HashMap[] f3523w;

    /* renamed from: x, reason: collision with root package name */
    public static final HashMap[] f3524x;

    /* renamed from: y, reason: collision with root package name */
    public static final HashSet f3525y;

    /* renamed from: z, reason: collision with root package name */
    public static final HashMap f3526z;

    /* renamed from: a, reason: collision with root package name */
    public final String f3527a;

    /* renamed from: b, reason: collision with root package name */
    public int f3528b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap[] f3529c = new HashMap[f3522u.length];

    /* renamed from: d, reason: collision with root package name */
    public ByteOrder f3530d = ByteOrder.BIG_ENDIAN;

    /* renamed from: e, reason: collision with root package name */
    public int f3531e;
    public int f;
    public int g;
    public int h;
    public int i;

    static {
        c[] cVarArr = {new c(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new c(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new c(ExifInterface.TAG_IMAGE_WIDTH, 256), new c(ExifInterface.TAG_IMAGE_LENGTH, 257), new c(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new c(ExifInterface.TAG_COMPRESSION, 259, 3), new c(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new c(ExifInterface.TAG_IMAGE_DESCRIPTION, SubsamplingScaleImageView.ORIENTATION_270, 2), new c(ExifInterface.TAG_MAKE, 271, 2), new c(ExifInterface.TAG_MODEL, 272, 2), new c(ExifInterface.TAG_STRIP_OFFSETS, 273), new c(ExifInterface.TAG_ORIENTATION, 274, 3), new c(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new c(ExifInterface.TAG_ROWS_PER_STRIP, 278), new c(ExifInterface.TAG_STRIP_BYTE_COUNTS, 279), new c(ExifInterface.TAG_X_RESOLUTION, 282, 5), new c(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new c(ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new c(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new c(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new c(ExifInterface.TAG_SOFTWARE, 305, 2), new c(ExifInterface.TAG_DATETIME, 306, 2), new c(ExifInterface.TAG_ARTIST, 315, 2), new c(ExifInterface.TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new c(ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new c("SubIFDPointer", 330, 4), new c(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new c(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new c(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new c(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new c(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new c(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new c(ExifInterface.TAG_COPYRIGHT, 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new c(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new c(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new c(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new c(ExifInterface.TAG_RW2_ISO, 23, 3), new c(ExifInterface.TAG_RW2_JPG_FROM_RAW, 46, 7)};
        c[] cVarArr2 = {new c(ExifInterface.TAG_EXPOSURE_TIME, 33434, 5), new c(ExifInterface.TAG_F_NUMBER, 33437, 5), new c(ExifInterface.TAG_EXPOSURE_PROGRAM, 34850, 3), new c(ExifInterface.TAG_SPECTRAL_SENSITIVITY, 34852, 2), new c(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new c(ExifInterface.TAG_OECF, 34856, 7), new c(ExifInterface.TAG_EXIF_VERSION, 36864, 2), new c(ExifInterface.TAG_DATETIME_ORIGINAL, 36867, 2), new c(ExifInterface.TAG_DATETIME_DIGITIZED, 36868, 2), new c(ExifInterface.TAG_COMPONENTS_CONFIGURATION, 37121, 7), new c(ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new c(ExifInterface.TAG_SHUTTER_SPEED_VALUE, 37377, 10), new c(ExifInterface.TAG_APERTURE_VALUE, 37378, 5), new c(ExifInterface.TAG_BRIGHTNESS_VALUE, 37379, 10), new c(ExifInterface.TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new c(ExifInterface.TAG_MAX_APERTURE_VALUE, 37381, 5), new c(ExifInterface.TAG_SUBJECT_DISTANCE, 37382, 5), new c(ExifInterface.TAG_METERING_MODE, 37383, 3), new c(ExifInterface.TAG_LIGHT_SOURCE, 37384, 3), new c(ExifInterface.TAG_FLASH, 37385, 3), new c(ExifInterface.TAG_FOCAL_LENGTH, 37386, 5), new c(ExifInterface.TAG_SUBJECT_AREA, 37396, 3), new c(ExifInterface.TAG_MAKER_NOTE, 37500, 7), new c(ExifInterface.TAG_USER_COMMENT, 37510, 7), new c(ExifInterface.TAG_SUBSEC_TIME, 37520, 2), new c(ExifInterface.TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new c(ExifInterface.TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new c(ExifInterface.TAG_FLASHPIX_VERSION, 40960, 7), new c(ExifInterface.TAG_COLOR_SPACE, 40961, 3), new c(ExifInterface.TAG_PIXEL_X_DIMENSION, 40962), new c(ExifInterface.TAG_PIXEL_Y_DIMENSION, 40963), new c(ExifInterface.TAG_RELATED_SOUND_FILE, 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c(ExifInterface.TAG_FLASH_ENERGY, 41483, 5), new c(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new c(ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new c(ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new c(ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new c(ExifInterface.TAG_SUBJECT_LOCATION, 41492, 3), new c(ExifInterface.TAG_EXPOSURE_INDEX, 41493, 5), new c(ExifInterface.TAG_SENSING_METHOD, 41495, 3), new c(ExifInterface.TAG_FILE_SOURCE, 41728, 7), new c(ExifInterface.TAG_SCENE_TYPE, 41729, 7), new c(ExifInterface.TAG_CFA_PATTERN, 41730, 7), new c(ExifInterface.TAG_CUSTOM_RENDERED, 41985, 3), new c(ExifInterface.TAG_EXPOSURE_MODE, 41986, 3), new c(ExifInterface.TAG_WHITE_BALANCE, 41987, 3), new c(ExifInterface.TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new c(ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new c(ExifInterface.TAG_SCENE_CAPTURE_TYPE, 41990, 3), new c(ExifInterface.TAG_GAIN_CONTROL, 41991, 3), new c(ExifInterface.TAG_CONTRAST, 41992, 3), new c(ExifInterface.TAG_SATURATION, 41993, 3), new c(ExifInterface.TAG_SHARPNESS, 41994, 3), new c(ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new c(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new c(ExifInterface.TAG_IMAGE_UNIQUE_ID, 42016, 2), new c(ExifInterface.TAG_DNG_VERSION, 50706, 1), new c(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720)};
        c[] cVarArr3 = {new c(ExifInterface.TAG_GPS_VERSION_ID, 0, 1), new c(ExifInterface.TAG_GPS_LATITUDE_REF, 1, 2), new c(ExifInterface.TAG_GPS_LATITUDE, 2, 5), new c(ExifInterface.TAG_GPS_LONGITUDE_REF, 3, 2), new c(ExifInterface.TAG_GPS_LONGITUDE, 4, 5), new c(ExifInterface.TAG_GPS_ALTITUDE_REF, 5, 1), new c(ExifInterface.TAG_GPS_ALTITUDE, 6, 5), new c(ExifInterface.TAG_GPS_TIMESTAMP, 7, 5), new c(ExifInterface.TAG_GPS_SATELLITES, 8, 2), new c(ExifInterface.TAG_GPS_STATUS, 9, 2), new c(ExifInterface.TAG_GPS_MEASURE_MODE, 10, 2), new c(ExifInterface.TAG_GPS_DOP, 11, 5), new c(ExifInterface.TAG_GPS_SPEED_REF, 12, 2), new c(ExifInterface.TAG_GPS_SPEED, 13, 5), new c(ExifInterface.TAG_GPS_TRACK_REF, 14, 2), new c(ExifInterface.TAG_GPS_TRACK, 15, 5), new c(ExifInterface.TAG_GPS_IMG_DIRECTION_REF, 16, 2), new c(ExifInterface.TAG_GPS_IMG_DIRECTION, 17, 5), new c(ExifInterface.TAG_GPS_MAP_DATUM, 18, 2), new c(ExifInterface.TAG_GPS_DEST_LATITUDE_REF, 19, 2), new c(ExifInterface.TAG_GPS_DEST_LATITUDE, 20, 5), new c(ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new c(ExifInterface.TAG_GPS_DEST_LONGITUDE, 22, 5), new c(ExifInterface.TAG_GPS_DEST_BEARING_REF, 23, 2), new c(ExifInterface.TAG_GPS_DEST_BEARING, 24, 5), new c(ExifInterface.TAG_GPS_DEST_DISTANCE_REF, 25, 2), new c(ExifInterface.TAG_GPS_DEST_DISTANCE, 26, 5), new c(ExifInterface.TAG_GPS_PROCESSING_METHOD, 27, 7), new c(ExifInterface.TAG_GPS_AREA_INFORMATION, 28, 7), new c(ExifInterface.TAG_GPS_DATESTAMP, 29, 2), new c(ExifInterface.TAG_GPS_DIFFERENTIAL, 30, 3)};
        c[] cVarArr4 = {new c(ExifInterface.TAG_INTEROPERABILITY_INDEX, 1, 2)};
        c[] cVarArr5 = {new c(ExifInterface.TAG_NEW_SUBFILE_TYPE, 254, 4), new c(ExifInterface.TAG_SUBFILE_TYPE, 255, 4), new c(ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH, 256), new c(ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH, 257), new c(ExifInterface.TAG_BITS_PER_SAMPLE, 258, 3), new c(ExifInterface.TAG_COMPRESSION, 259, 3), new c(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new c(ExifInterface.TAG_IMAGE_DESCRIPTION, SubsamplingScaleImageView.ORIENTATION_270, 2), new c(ExifInterface.TAG_MAKE, 271, 2), new c(ExifInterface.TAG_MODEL, 272, 2), new c(ExifInterface.TAG_STRIP_OFFSETS, 273), new c(ExifInterface.TAG_ORIENTATION, 274, 3), new c(ExifInterface.TAG_SAMPLES_PER_PIXEL, 277, 3), new c(ExifInterface.TAG_ROWS_PER_STRIP, 278), new c(ExifInterface.TAG_STRIP_BYTE_COUNTS, 279), new c(ExifInterface.TAG_X_RESOLUTION, 282, 5), new c(ExifInterface.TAG_Y_RESOLUTION, 283, 5), new c(ExifInterface.TAG_PLANAR_CONFIGURATION, 284, 3), new c(ExifInterface.TAG_RESOLUTION_UNIT, 296, 3), new c(ExifInterface.TAG_TRANSFER_FUNCTION, 301, 3), new c(ExifInterface.TAG_SOFTWARE, 305, 2), new c(ExifInterface.TAG_DATETIME, 306, 2), new c(ExifInterface.TAG_ARTIST, 315, 2), new c(ExifInterface.TAG_WHITE_POINT, TypedValues.AttributesType.TYPE_PIVOT_TARGET, 5), new c(ExifInterface.TAG_PRIMARY_CHROMATICITIES, 319, 5), new c("SubIFDPointer", 330, 4), new c(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, InputDeviceCompat.SOURCE_DPAD, 4), new c(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new c(ExifInterface.TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new c(ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new c(ExifInterface.TAG_Y_CB_CR_POSITIONING, 531, 3), new c(ExifInterface.TAG_REFERENCE_BLACK_WHITE, 532, 5), new c(ExifInterface.TAG_COPYRIGHT, 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c(ExifInterface.TAG_DNG_VERSION, 50706, 1), new c(ExifInterface.TAG_DEFAULT_CROP_SIZE, 50720)};
        f3521t = new c(ExifInterface.TAG_STRIP_OFFSETS, 273, 3);
        f3522u = new c[][]{cVarArr, cVarArr2, cVarArr3, cVarArr4, cVarArr5, cVarArr, new c[]{new c(ExifInterface.TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)}, new c[]{new c(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new c(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)}, new c[]{new c(ExifInterface.TAG_ORF_ASPECT_FRAME, 4371, 3)}, new c[]{new c(ExifInterface.TAG_COLOR_SPACE, 55, 3)}};
        v = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        f3523w = new HashMap[10];
        f3524x = new HashMap[10];
        f3525y = new HashSet(Arrays.asList(ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_GPS_TIMESTAMP));
        f3526z = new HashMap();
        Charset forName = Charset.forName("US-ASCII");
        A = forName;
        B = "Exif\u0000\u0000".getBytes(forName);
        new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            c[][] cVarArr6 = f3522u;
            if (i >= cVarArr6.length) {
                HashMap hashMap = f3526z;
                c[] cVarArr7 = v;
                hashMap.put(Integer.valueOf(cVarArr7[0].f3506a), 5);
                hashMap.put(Integer.valueOf(cVarArr7[1].f3506a), 1);
                hashMap.put(Integer.valueOf(cVarArr7[2].f3506a), 2);
                hashMap.put(Integer.valueOf(cVarArr7[3].f3506a), 3);
                hashMap.put(Integer.valueOf(cVarArr7[4].f3506a), 7);
                hashMap.put(Integer.valueOf(cVarArr7[5].f3506a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            f3523w[i] = new HashMap();
            f3524x[i] = new HashMap();
            for (c cVar : cVarArr6[i]) {
                f3523w[i].put(Integer.valueOf(cVar.f3506a), cVar);
                f3524x[i].put(cVar.f3507b, cVar);
            }
            i++;
        }
    }

    public e(String str) {
        FileInputStream fileInputStream;
        this.f3527a = str;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            m(fileInputStream);
            try {
                fileInputStream.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (RuntimeException e11) {
                    throw e11;
                } catch (Exception unused2) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long[] b(Serializable serializable) {
        if (!(serializable instanceof int[])) {
            if (serializable instanceof long[]) {
                return (long[]) serializable;
            }
            return null;
        }
        int[] iArr = (int[]) serializable;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    public static ByteOrder o(a aVar) {
        short readShort = aVar.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        androidx.core.content.pm.a.k(Integer.toHexString(readShort), "Invalid byte order: ");
        return null;
    }

    public final void a() {
        String c9 = c(ExifInterface.TAG_DATETIME_ORIGINAL);
        HashMap[] hashMapArr = this.f3529c;
        if (c9 != null && c(ExifInterface.TAG_DATETIME) == null) {
            HashMap hashMap = hashMapArr[0];
            byte[] bytes = c9.concat("\u0000").getBytes(A);
            hashMap.put(ExifInterface.TAG_DATETIME, new b(2, bytes.length, bytes));
        }
        if (c(ExifInterface.TAG_IMAGE_WIDTH) == null) {
            hashMapArr[0].put(ExifInterface.TAG_IMAGE_WIDTH, b.a(0L, this.f3530d));
        }
        if (c(ExifInterface.TAG_IMAGE_LENGTH) == null) {
            hashMapArr[0].put(ExifInterface.TAG_IMAGE_LENGTH, b.a(0L, this.f3530d));
        }
        if (c(ExifInterface.TAG_ORIENTATION) == null) {
            hashMapArr[0].put(ExifInterface.TAG_ORIENTATION, b.a(0L, this.f3530d));
        }
        if (c(ExifInterface.TAG_LIGHT_SOURCE) == null) {
            hashMapArr[1].put(ExifInterface.TAG_LIGHT_SOURCE, b.a(0L, this.f3530d));
        }
    }

    public final String c(String str) {
        b d10 = d(str);
        if (d10 != null) {
            int i = d10.f3503a;
            if (!f3525y.contains(str)) {
                return d10.f(this.f3530d);
            }
            if (str.equals(ExifInterface.TAG_GPS_TIMESTAMP)) {
                if (i != 5 && i != 10) {
                    l.z(i, "GPS Timestamp format is not rational. format=", "ExifInterface");
                    return null;
                }
                d[] dVarArr = (d[]) d10.g(this.f3530d);
                if (dVarArr == null || dVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(dVarArr));
                    return null;
                }
                d dVar = dVarArr[0];
                Integer valueOf = Integer.valueOf((int) (dVar.f3510a / dVar.f3511b));
                d dVar2 = dVarArr[1];
                Integer valueOf2 = Integer.valueOf((int) (dVar2.f3510a / dVar2.f3511b));
                d dVar3 = dVarArr[2];
                return String.format("%02d:%02d:%02d", valueOf, valueOf2, Integer.valueOf((int) (dVar3.f3510a / dVar3.f3511b)));
            }
            try {
                return Double.toString(d10.d(this.f3530d));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final b d(String str) {
        if (ExifInterface.TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i = 0; i < f3522u.length; i++) {
            b bVar = (b) this.f3529c[i].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0115, code lost:
    
        r12.f3500b = r11.f3530d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0119, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(d.a r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.e(d.a, int, int):void");
    }

    public final int f(BufferedInputStream bufferedInputStream) {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr2 = f3515n;
            if (i >= bArr2.length) {
                return 4;
            }
            if (bArr[i] != bArr2[i]) {
                byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
                for (int i6 = 0; i6 < bytes.length; i6++) {
                    if (bArr[i6] != bytes[i6]) {
                        a aVar = new a(bArr);
                        ByteOrder o10 = o(aVar);
                        this.f3530d = o10;
                        aVar.f3500b = o10;
                        short readShort = aVar.readShort();
                        aVar.close();
                        if (readShort == 20306 || readShort == 21330) {
                            return 7;
                        }
                        a aVar2 = new a(bArr);
                        ByteOrder o11 = o(aVar2);
                        this.f3530d = o11;
                        aVar2.f3500b = o11;
                        short readShort2 = aVar2.readShort();
                        aVar2.close();
                        return readShort2 == 85 ? 10 : 0;
                    }
                }
                return 9;
            }
            i++;
        }
    }

    public final void g(a aVar) {
        int i;
        int i6;
        i(aVar);
        HashMap[] hashMapArr = this.f3529c;
        b bVar = (b) hashMapArr[1].get(ExifInterface.TAG_MAKER_NOTE);
        if (bVar != null) {
            a aVar2 = new a(bVar.f3505c);
            aVar2.f3500b = this.f3530d;
            byte[] bArr = f3516o;
            byte[] bArr2 = new byte[bArr.length];
            aVar2.readFully(bArr2);
            aVar2.b(0L);
            byte[] bArr3 = f3517p;
            byte[] bArr4 = new byte[bArr3.length];
            aVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                aVar2.b(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                aVar2.b(12L);
            }
            p(aVar2, 6);
            b bVar2 = (b) hashMapArr[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_START);
            b bVar3 = (b) hashMapArr[7].get(ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (bVar2 != null && bVar3 != null) {
                hashMapArr[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, bVar2);
                hashMapArr[5].put(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, bVar3);
            }
            b bVar4 = (b) hashMapArr[8].get(ExifInterface.TAG_ORF_ASPECT_FRAME);
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.g(this.f3530d);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i10 = iArr[2];
                int i11 = iArr[0];
                if (i10 <= i11 || (i = iArr[3]) <= (i6 = iArr[1])) {
                    return;
                }
                int i12 = (i10 - i11) + 1;
                int i13 = (i - i6) + 1;
                if (i12 < i13) {
                    int i14 = i12 + i13;
                    i13 = i14 - i13;
                    i12 = i14 - i13;
                }
                b c9 = b.c(i12, this.f3530d);
                b c10 = b.c(i13, this.f3530d);
                hashMapArr[0].put(ExifInterface.TAG_IMAGE_WIDTH, c9);
                hashMapArr[0].put(ExifInterface.TAG_IMAGE_LENGTH, c10);
            }
        }
    }

    public final void h(a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i6 = ByteBuffer.wrap(bArr2).getInt();
        e(aVar, i, 5);
        aVar.b(i6);
        aVar.f3500b = ByteOrder.BIG_ENDIAN;
        int readInt = aVar.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == f3521t.f3506a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b c9 = b.c(readShort, this.f3530d);
                b c10 = b.c(readShort2, this.f3530d);
                HashMap[] hashMapArr = this.f3529c;
                hashMapArr[0].put(ExifInterface.TAG_IMAGE_LENGTH, c9);
                hashMapArr[0].put(ExifInterface.TAG_IMAGE_WIDTH, c10);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    public final void i(a aVar) {
        b bVar;
        n(aVar, aVar.f3499a.available());
        p(aVar, 0);
        s(aVar, 0);
        s(aVar, 5);
        s(aVar, 4);
        r(0, 5);
        r(0, 4);
        r(5, 4);
        HashMap[] hashMapArr = this.f3529c;
        b bVar2 = (b) hashMapArr[1].get(ExifInterface.TAG_PIXEL_X_DIMENSION);
        b bVar3 = (b) hashMapArr[1].get(ExifInterface.TAG_PIXEL_Y_DIMENSION);
        if (bVar2 != null && bVar3 != null) {
            hashMapArr[0].put(ExifInterface.TAG_IMAGE_WIDTH, bVar2);
            hashMapArr[0].put(ExifInterface.TAG_IMAGE_LENGTH, bVar3);
        }
        if (hashMapArr[4].isEmpty() && l(hashMapArr[5])) {
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap();
        }
        if (!l(hashMapArr[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.f3528b != 8 || (bVar = (b) hashMapArr[1].get(ExifInterface.TAG_MAKER_NOTE)) == null) {
            return;
        }
        a aVar2 = new a(bVar.f3505c);
        aVar2.f3500b = this.f3530d;
        aVar2.b(6L);
        p(aVar2, 9);
        b bVar4 = (b) hashMapArr[9].get(ExifInterface.TAG_COLOR_SPACE);
        if (bVar4 != null) {
            hashMapArr[1].put(ExifInterface.TAG_COLOR_SPACE, bVar4);
        }
    }

    public final void j(a aVar) {
        i(aVar);
        HashMap[] hashMapArr = this.f3529c;
        if (((b) hashMapArr[0].get(ExifInterface.TAG_RW2_JPG_FROM_RAW)) != null) {
            e(aVar, this.i, 5);
        }
        b bVar = (b) hashMapArr[0].get(ExifInterface.TAG_RW2_ISO);
        b bVar2 = (b) hashMapArr[1].get(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (bVar == null || bVar2 != null) {
            return;
        }
        hashMapArr[1].put(ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, bVar);
    }

    public final void k(a aVar, HashMap hashMap) {
        int i;
        b bVar = (b) hashMap.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT);
        b bVar2 = (b) hashMap.get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (bVar == null || bVar2 == null) {
            return;
        }
        int e10 = bVar.e(this.f3530d);
        int min = Math.min(bVar2.e(this.f3530d), aVar.f3499a.available() - e10);
        int i6 = this.f3528b;
        if (i6 != 4 && i6 != 9 && i6 != 10) {
            if (i6 == 7) {
                i = this.f;
            }
            if (e10 > 0 || min <= 0 || this.f3527a != null) {
                return;
            }
            aVar.b(e10);
            aVar.readFully(new byte[min]);
            return;
        }
        i = this.f3531e;
        e10 += i;
        if (e10 > 0) {
        }
    }

    public final boolean l(HashMap hashMap) {
        b bVar = (b) hashMap.get(ExifInterface.TAG_IMAGE_LENGTH);
        b bVar2 = (b) hashMap.get(ExifInterface.TAG_IMAGE_WIDTH);
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.e(this.f3530d) <= 512 && bVar2.e(this.f3530d) <= 512;
    }

    public final void m(FileInputStream fileInputStream) {
        for (int i = 0; i < f3522u.length; i++) {
            try {
                this.f3529c[i] = new HashMap();
            } catch (IOException unused) {
                a();
                return;
            } catch (Throwable th) {
                a();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, 5000);
        this.f3528b = f(bufferedInputStream);
        a aVar = new a(bufferedInputStream);
        switch (this.f3528b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                i(aVar);
                break;
            case 4:
                e(aVar, 0, 0);
                break;
            case 7:
                g(aVar);
                break;
            case 9:
                h(aVar);
                break;
            case 10:
                j(aVar);
                break;
        }
        q(aVar);
        a();
    }

    public final void n(a aVar, int i) {
        ByteOrder o10 = o(aVar);
        this.f3530d = o10;
        aVar.f3500b = o10;
        int readUnsignedShort = aVar.readUnsignedShort();
        int i6 = this.f3528b;
        if (i6 != 7 && i6 != 10 && readUnsignedShort != 42) {
            androidx.core.content.pm.a.k(Integer.toHexString(readUnsignedShort), "Invalid start code: ");
            return;
        }
        int readInt = aVar.readInt();
        if (readInt < 8 || readInt >= i) {
            com.google.gson.internal.a.n(l.u(readInt, "Invalid first Ifd offset: "));
            return;
        }
        int i10 = readInt - 8;
        if (i10 <= 0 || aVar.skipBytes(i10) == i10) {
            return;
        }
        com.google.gson.internal.a.n(l.u(i10, "Couldn't jump to first Ifd: "));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(d.a r30, int r31) {
        /*
            Method dump skipped, instructions count: 638
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.e.p(d.a, int):void");
    }

    public final void q(a aVar) {
        b bVar;
        HashMap hashMap = this.f3529c[4];
        b bVar2 = (b) hashMap.get(ExifInterface.TAG_COMPRESSION);
        if (bVar2 == null) {
            k(aVar, hashMap);
            return;
        }
        int e10 = bVar2.e(this.f3530d);
        if (e10 != 1) {
            if (e10 == 6) {
                k(aVar, hashMap);
                return;
            } else if (e10 != 7) {
                return;
            }
        }
        b bVar3 = (b) hashMap.get(ExifInterface.TAG_BITS_PER_SAMPLE);
        if (bVar3 != null) {
            int[] iArr = (int[]) bVar3.g(this.f3530d);
            int[] iArr2 = f3513l;
            if (!Arrays.equals(iArr2, iArr)) {
                if (this.f3528b != 3 || (bVar = (b) hashMap.get(ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
                    return;
                }
                int e11 = bVar.e(this.f3530d);
                if ((e11 != 1 || !Arrays.equals(iArr, f3514m)) && (e11 != 6 || !Arrays.equals(iArr, iArr2))) {
                    return;
                }
            }
            b bVar4 = (b) hashMap.get(ExifInterface.TAG_STRIP_OFFSETS);
            b bVar5 = (b) hashMap.get(ExifInterface.TAG_STRIP_BYTE_COUNTS);
            if (bVar4 == null || bVar5 == null) {
                return;
            }
            long[] b7 = b(bVar4.g(this.f3530d));
            long[] b10 = b(bVar5.g(this.f3530d));
            if (b7 == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
                return;
            }
            if (b10 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
                return;
            }
            long j6 = 0;
            for (long j10 : b10) {
                j6 += j10;
            }
            byte[] bArr = new byte[(int) j6];
            int i = 0;
            int i6 = 0;
            for (int i10 = 0; i10 < b7.length; i10++) {
                int i11 = (int) b7[i10];
                int i12 = (int) b10[i10];
                int i13 = i11 - i;
                if (i13 < 0) {
                    Log.d("ExifInterface", "Invalid strip offset value");
                }
                aVar.b(i13);
                int i14 = i + i13;
                byte[] bArr2 = new byte[i12];
                aVar.read(bArr2);
                i = i14 + i12;
                System.arraycopy(bArr2, 0, bArr, i6, i12);
                i6 += i12;
            }
        }
    }

    public final void r(int i, int i6) {
        HashMap[] hashMapArr = this.f3529c;
        if (hashMapArr[i].isEmpty() || hashMapArr[i6].isEmpty()) {
            return;
        }
        b bVar = (b) hashMapArr[i].get(ExifInterface.TAG_IMAGE_LENGTH);
        b bVar2 = (b) hashMapArr[i].get(ExifInterface.TAG_IMAGE_WIDTH);
        b bVar3 = (b) hashMapArr[i6].get(ExifInterface.TAG_IMAGE_LENGTH);
        b bVar4 = (b) hashMapArr[i6].get(ExifInterface.TAG_IMAGE_WIDTH);
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int e10 = bVar.e(this.f3530d);
        int e11 = bVar2.e(this.f3530d);
        int e12 = bVar3.e(this.f3530d);
        int e13 = bVar4.e(this.f3530d);
        if (e10 >= e12 || e11 >= e13) {
            return;
        }
        HashMap hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i6];
        hashMapArr[i6] = hashMap;
    }

    public final void s(a aVar, int i) {
        b bVar;
        b c9;
        b c10;
        HashMap[] hashMapArr = this.f3529c;
        b bVar2 = (b) hashMapArr[i].get(ExifInterface.TAG_DEFAULT_CROP_SIZE);
        b bVar3 = (b) hashMapArr[i].get(ExifInterface.TAG_RW2_SENSOR_TOP_BORDER);
        b bVar4 = (b) hashMapArr[i].get(ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER);
        b bVar5 = (b) hashMapArr[i].get(ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER);
        b bVar6 = (b) hashMapArr[i].get(ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER);
        if (bVar2 != null) {
            int i6 = bVar2.f3503a;
            ByteOrder byteOrder = this.f3530d;
            if (i6 == 5) {
                d[] dVarArr = (d[]) bVar2.g(byteOrder);
                if (dVarArr == null || dVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(dVarArr));
                    return;
                }
                c9 = b.b(dVarArr[0], this.f3530d);
                c10 = b.b(dVarArr[1], this.f3530d);
            } else {
                int[] iArr = (int[]) bVar2.g(byteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                c9 = b.c(iArr[0], this.f3530d);
                c10 = b.c(iArr[1], this.f3530d);
            }
            hashMapArr[i].put(ExifInterface.TAG_IMAGE_WIDTH, c9);
            hashMapArr[i].put(ExifInterface.TAG_IMAGE_LENGTH, c10);
            return;
        }
        if (bVar3 == null || bVar4 == null || bVar5 == null || bVar6 == null) {
            b bVar7 = (b) hashMapArr[i].get(ExifInterface.TAG_IMAGE_LENGTH);
            b bVar8 = (b) hashMapArr[i].get(ExifInterface.TAG_IMAGE_WIDTH);
            if ((bVar7 == null || bVar8 == null) && (bVar = (b) hashMapArr[i].get(ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
                e(aVar, bVar.e(this.f3530d), i);
                return;
            }
            return;
        }
        int e10 = bVar3.e(this.f3530d);
        int e11 = bVar5.e(this.f3530d);
        int e12 = bVar6.e(this.f3530d);
        int e13 = bVar4.e(this.f3530d);
        if (e11 <= e10 || e12 <= e13) {
            return;
        }
        b c11 = b.c(e11 - e10, this.f3530d);
        b c12 = b.c(e12 - e13, this.f3530d);
        hashMapArr[i].put(ExifInterface.TAG_IMAGE_LENGTH, c11);
        hashMapArr[i].put(ExifInterface.TAG_IMAGE_WIDTH, c12);
    }
}
