package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class CLParser {
    static boolean sDebug = false;
    private String mContent;
    private boolean mHasComment = false;
    private int mLineNumber;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum TYPE {
        UNKNOWN,
        OBJECT,
        ARRAY,
        NUMBER,
        STRING,
        KEY,
        TOKEN
    }

    public CLParser(String str) {
        this.mContent = str;
    }

    private CLElement createElement(CLElement cLElement, int i, TYPE type, boolean z9, char[] cArr) {
        CLElement allocate;
        if (sDebug) {
            System.out.println("CREATE " + type + " at " + cArr[i]);
        }
        switch (type.ordinal()) {
            case 1:
                allocate = CLObject.allocate(cArr);
                i++;
                break;
            case 2:
                allocate = CLArray.allocate(cArr);
                i++;
                break;
            case 3:
                allocate = CLNumber.allocate(cArr);
                break;
            case 4:
                allocate = CLString.allocate(cArr);
                break;
            case 5:
                allocate = CLKey.allocate(cArr);
                break;
            case 6:
                allocate = CLToken.allocate(cArr);
                break;
            default:
                allocate = null;
                break;
        }
        if (allocate == null) {
            return null;
        }
        allocate.setLine(this.mLineNumber);
        if (z9) {
            allocate.setStart(i);
        }
        if (cLElement instanceof CLContainer) {
            allocate.setContainer((CLContainer) cLElement);
        }
        return allocate;
    }

    private CLElement getNextJsonElement(int i, char c9, CLElement cLElement, char[] cArr) throws CLParsingException {
        if (c9 != '\t' && c9 != '\n' && c9 != '\r' && c9 != ' ') {
            if (c9 == '\"' || c9 == '\'') {
                return cLElement instanceof CLObject ? createElement(cLElement, i, TYPE.KEY, true, cArr) : createElement(cLElement, i, TYPE.STRING, true, cArr);
            }
            if (c9 == '[') {
                return createElement(cLElement, i, TYPE.ARRAY, true, cArr);
            }
            if (c9 != ']') {
                if (c9 == '{') {
                    return createElement(cLElement, i, TYPE.OBJECT, true, cArr);
                }
                if (c9 != '}') {
                    switch (c9) {
                        case '+':
                        case '-':
                        case '.':
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE /* 48 */:
                        case '1':
                        case '2':
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TAG /* 51 */:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_TOP_OF /* 52 */:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BASELINE_TO_BOTTOM_OF /* 53 */:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_MARGIN_BASELINE /* 54 */:
                        case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                        case '8':
                        case '9':
                            return createElement(cLElement, i, TYPE.NUMBER, true, cArr);
                        case ',':
                        case ':':
                            break;
                        case '/':
                            int i6 = i + 1;
                            if (i6 >= cArr.length || cArr[i6] != '/') {
                                return cLElement;
                            }
                            this.mHasComment = true;
                            return cLElement;
                        default:
                            if (!(cLElement instanceof CLContainer) || (cLElement instanceof CLObject)) {
                                return createElement(cLElement, i, TYPE.KEY, true, cArr);
                            }
                            CLElement createElement = createElement(cLElement, i, TYPE.TOKEN, true, cArr);
                            CLToken cLToken = (CLToken) createElement;
                            if (cLToken.validate(c9, i)) {
                                return createElement;
                            }
                            throw new CLParsingException("incorrect token <" + c9 + "> at line " + this.mLineNumber, cLToken);
                    }
                }
            }
            cLElement.setEnd(i - 1);
            CLElement container = cLElement.getContainer();
            container.setEnd(i);
            return container;
        }
        return cLElement;
    }

    public CLObject parse() throws CLParsingException {
        int i;
        char[] charArray = this.mContent.toCharArray();
        int length = charArray.length;
        int i6 = 1;
        this.mLineNumber = 1;
        boolean z9 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            }
            char c9 = charArray[i10];
            if (c9 == '{') {
                break;
            }
            if (c9 == '\n') {
                this.mLineNumber++;
            }
            i10++;
        }
        if (i10 == -1) {
            throw new CLParsingException("invalid json content", null);
        }
        CLObject allocate = CLObject.allocate(charArray);
        allocate.setLine(this.mLineNumber);
        allocate.setStart(i10);
        int i11 = i10 + 1;
        CLElement cLElement = allocate;
        while (i11 < length) {
            char c10 = charArray[i11];
            if (c10 == '\n') {
                this.mLineNumber += i6;
            }
            if (this.mHasComment) {
                if (c10 == '\n') {
                    this.mHasComment = z9;
                } else {
                    i = i6;
                    i11++;
                    i6 = i;
                    z9 = false;
                }
            }
            if (cLElement == null) {
                break;
            }
            if (cLElement.isDone()) {
                cLElement = getNextJsonElement(i11, c10, cLElement, charArray);
            } else if (cLElement instanceof CLObject) {
                if (c10 == '}') {
                    cLElement.setEnd(i11 - 1);
                } else {
                    cLElement = getNextJsonElement(i11, c10, cLElement, charArray);
                }
            } else if (!(cLElement instanceof CLArray)) {
                boolean z10 = cLElement instanceof CLString;
                if (z10) {
                    long j = cLElement.mStart;
                    if (charArray[(int) j] == c10) {
                        cLElement.setStart(j + 1);
                        cLElement.setEnd(i11 - 1);
                    }
                } else {
                    if (cLElement instanceof CLToken) {
                        CLToken cLToken = (CLToken) cLElement;
                        i = i6;
                        if (!cLToken.validate(c10, i11)) {
                            throw new CLParsingException("parsing incorrect token " + cLToken.content() + " at line " + this.mLineNumber, cLToken);
                        }
                    } else {
                        i = i6;
                    }
                    if ((cLElement instanceof CLKey) || z10) {
                        long j6 = cLElement.mStart;
                        char c11 = charArray[(int) j6];
                        if ((c11 == '\'' || c11 == '\"') && c11 == c10) {
                            cLElement.setStart(j6 + 1);
                            cLElement.setEnd(i11 - 1);
                        }
                    }
                    if (!cLElement.isDone() && (c10 == '}' || c10 == ']' || c10 == ',' || c10 == ' ' || c10 == '\t' || c10 == '\r' || c10 == '\n' || c10 == ':')) {
                        long j10 = i11 - 1;
                        cLElement.setEnd(j10);
                        if (c10 == '}' || c10 == ']') {
                            cLElement = cLElement.getContainer();
                            cLElement.setEnd(j10);
                            if (cLElement instanceof CLKey) {
                                cLElement = cLElement.getContainer();
                                cLElement.setEnd(j10);
                            }
                        }
                    }
                    if (cLElement.isDone() && (!(cLElement instanceof CLKey) || ((CLKey) cLElement).mElements.size() > 0)) {
                        cLElement = cLElement.getContainer();
                    }
                    i11++;
                    i6 = i;
                    z9 = false;
                }
            } else if (c10 == ']') {
                cLElement.setEnd(i11 - 1);
            } else {
                cLElement = getNextJsonElement(i11, c10, cLElement, charArray);
            }
            i = i6;
            if (cLElement.isDone()) {
                cLElement = cLElement.getContainer();
            }
            i11++;
            i6 = i;
            z9 = false;
        }
        while (cLElement != null && !cLElement.isDone()) {
            if (cLElement instanceof CLString) {
                cLElement.setStart(((int) cLElement.mStart) + 1);
            }
            cLElement.setEnd(length - 1);
            cLElement = cLElement.getContainer();
        }
        if (sDebug) {
            System.out.println("Root: " + allocate.toJSON());
        }
        return allocate;
    }

    public static CLObject parse(String str) throws CLParsingException {
        return new CLParser(str).parse();
    }
}
