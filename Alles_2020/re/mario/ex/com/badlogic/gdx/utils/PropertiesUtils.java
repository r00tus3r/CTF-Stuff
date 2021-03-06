package com.badlogic.gdx.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;

public final class PropertiesUtils {
  private static final int CONTINUE = 3;
  
  private static final int IGNORE = 5;
  
  private static final int KEY_DONE = 4;
  
  private static final String LINE_SEPARATOR = "\n";
  
  private static final int NONE = 0;
  
  private static final int SLASH = 1;
  
  private static final int UNICODE = 2;
  
  private static void dumpString(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
    int i = paramString.length();
    for (byte b = 0; b < i; b++) {
      char c = paramString.charAt(b);
      if (c > '=' && c < '') {
        Character character;
        if (c == '\\') {
          character = "\\\\";
        } else {
          character = Character.valueOf(c);
        } 
        paramStringBuilder.append(character);
      } else if (c != '\t') {
        if (c != '\n') {
          if (c != '\f') {
            if (c != '\r') {
              if (c != ' ') {
                if (c != '!' && c != '#' && c != ':' && c != '=') {
                  byte b1;
                  if (c < ' ' || c > '~') {
                    b1 = 1;
                  } else {
                    b1 = 0;
                  } 
                  if (b1 & paramBoolean2) {
                    String str = Integer.toHexString(c);
                    paramStringBuilder.append("\\u");
                    for (b1 = 0; b1 < 4 - str.length(); b1++)
                      paramStringBuilder.append('0'); 
                    paramStringBuilder.append(str);
                  } else {
                    paramStringBuilder.append(c);
                  } 
                } else {
                  paramStringBuilder.append('\\').append(c);
                } 
              } else if (b == 0 || paramBoolean1) {
                paramStringBuilder.append("\\ ");
              } else {
                paramStringBuilder.append(c);
              } 
            } else {
              paramStringBuilder.append("\\r");
            } 
          } else {
            paramStringBuilder.append("\\f");
          } 
        } else {
          paramStringBuilder.append("\\n");
        } 
      } else {
        paramStringBuilder.append("\\t");
      } 
    } 
  }
  
  public static void load(ObjectMap<String, String> paramObjectMap, Reader paramReader) throws IOException { // Byte code:
    //   0: aload_0
    //   1: ifnull -> 960
    //   4: aload_1
    //   5: ifnull -> 950
    //   8: bipush #40
    //   10: newarray char
    //   12: astore_2
    //   13: new java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial <init> : (Ljava/io/Reader;)V
    //   21: astore_3
    //   22: aload_2
    //   23: astore_1
    //   24: iconst_0
    //   25: istore #4
    //   27: iconst_0
    //   28: istore #5
    //   30: iconst_0
    //   31: istore #6
    //   33: iconst_1
    //   34: istore #7
    //   36: iconst_0
    //   37: istore #8
    //   39: iconst_m1
    //   40: istore #9
    //   42: iconst_1
    //   43: istore #10
    //   45: aload_1
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual read : ()I
    //   51: istore #11
    //   53: iload #11
    //   55: iconst_m1
    //   56: if_icmpne -> 182
    //   59: iload #6
    //   61: iconst_2
    //   62: if_icmpne -> 84
    //   65: iload #4
    //   67: iconst_4
    //   68: if_icmple -> 74
    //   71: goto -> 84
    //   74: new java/lang/IllegalArgumentException
    //   77: dup
    //   78: ldc 'Invalid Unicode sequence: expected format \uxxxx'
    //   80: invokespecial <init> : (Ljava/lang/String;)V
    //   83: athrow
    //   84: iload #9
    //   86: istore #11
    //   88: iload #9
    //   90: iconst_m1
    //   91: if_icmpne -> 107
    //   94: iload #9
    //   96: istore #11
    //   98: iload #8
    //   100: ifle -> 107
    //   103: iload #8
    //   105: istore #11
    //   107: iload #11
    //   109: iflt -> 181
    //   112: new java/lang/String
    //   115: dup
    //   116: aload_2
    //   117: iconst_0
    //   118: iload #8
    //   120: invokespecial <init> : ([CII)V
    //   123: astore_1
    //   124: aload_1
    //   125: iconst_0
    //   126: iload #11
    //   128: invokevirtual substring : (II)Ljava/lang/String;
    //   131: astore_3
    //   132: aload_1
    //   133: iload #11
    //   135: invokevirtual substring : (I)Ljava/lang/String;
    //   138: astore_2
    //   139: aload_2
    //   140: astore_1
    //   141: iload #6
    //   143: iload #7
    //   145: if_icmpne -> 174
    //   148: new java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial <init> : ()V
    //   155: astore_1
    //   156: aload_1
    //   157: aload_2
    //   158: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_1
    //   163: ldc ' '
    //   165: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_1
    //   170: invokevirtual toString : ()Ljava/lang/String;
    //   173: astore_1
    //   174: aload_0
    //   175: aload_3
    //   176: aload_1
    //   177: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: return
    //   182: iload #11
    //   184: i2c
    //   185: istore #12
    //   187: aload_2
    //   188: astore_1
    //   189: iload #8
    //   191: aload_2
    //   192: arraylength
    //   193: if_icmpne -> 212
    //   196: aload_2
    //   197: arraylength
    //   198: iconst_2
    //   199: imul
    //   200: newarray char
    //   202: astore_1
    //   203: aload_2
    //   204: iconst_0
    //   205: aload_1
    //   206: iconst_0
    //   207: iload #8
    //   209: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   212: iload #8
    //   214: istore #11
    //   216: iload #6
    //   218: istore #13
    //   220: iload #4
    //   222: istore #14
    //   224: iload #5
    //   226: istore #15
    //   228: iload #6
    //   230: iconst_2
    //   231: if_icmpne -> 344
    //   234: iload #12
    //   236: bipush #16
    //   238: invokestatic digit : (CI)I
    //   241: istore #11
    //   243: iload #11
    //   245: iflt -> 290
    //   248: iload #5
    //   250: iconst_4
    //   251: ishl
    //   252: iload #11
    //   254: iadd
    //   255: istore #11
    //   257: iload #4
    //   259: iconst_1
    //   260: iadd
    //   261: istore #13
    //   263: iload #13
    //   265: istore #4
    //   267: iload #11
    //   269: istore #5
    //   271: iload #13
    //   273: iconst_4
    //   274: if_icmpge -> 296
    //   277: aload_1
    //   278: astore_2
    //   279: iload #13
    //   281: istore #4
    //   283: iload #11
    //   285: istore #5
    //   287: goto -> 47
    //   290: iload #4
    //   292: iconst_4
    //   293: if_icmple -> 334
    //   296: iload #8
    //   298: iconst_1
    //   299: iadd
    //   300: istore #11
    //   302: aload_1
    //   303: iload #8
    //   305: iload #5
    //   307: i2c
    //   308: i2c
    //   309: castore
    //   310: iload #12
    //   312: bipush #10
    //   314: if_icmpeq -> 320
    //   317: goto -> 628
    //   320: iconst_0
    //   321: istore #13
    //   323: iload #4
    //   325: istore #14
    //   327: iload #5
    //   329: istore #15
    //   331: goto -> 344
    //   334: new java/lang/IllegalArgumentException
    //   337: dup
    //   338: ldc 'Invalid Unicode sequence: illegal character'
    //   340: invokespecial <init> : (Ljava/lang/String;)V
    //   343: athrow
    //   344: iload #13
    //   346: iload #7
    //   348: if_icmpne -> 522
    //   351: iload #12
    //   353: bipush #10
    //   355: if_icmpeq -> 502
    //   358: iload #12
    //   360: bipush #13
    //   362: if_icmpeq -> 482
    //   365: iload #12
    //   367: bipush #98
    //   369: if_icmpeq -> 460
    //   372: iload #12
    //   374: bipush #102
    //   376: if_icmpeq -> 453
    //   379: iload #12
    //   381: bipush #110
    //   383: if_icmpeq -> 446
    //   386: iload #12
    //   388: bipush #114
    //   390: if_icmpeq -> 439
    //   393: iload #12
    //   395: bipush #116
    //   397: if_icmpeq -> 432
    //   400: iload #12
    //   402: bipush #117
    //   404: if_icmpeq -> 414
    //   407: iload #12
    //   409: istore #6
    //   411: goto -> 464
    //   414: iconst_2
    //   415: istore #6
    //   417: iconst_0
    //   418: istore #4
    //   420: iconst_0
    //   421: istore #5
    //   423: iload #11
    //   425: istore #8
    //   427: aload_1
    //   428: astore_2
    //   429: goto -> 47
    //   432: bipush #9
    //   434: istore #6
    //   436: goto -> 464
    //   439: bipush #13
    //   441: istore #6
    //   443: goto -> 464
    //   446: bipush #10
    //   448: istore #6
    //   450: goto -> 464
    //   453: bipush #12
    //   455: istore #6
    //   457: goto -> 464
    //   460: bipush #8
    //   462: istore #6
    //   464: iload #6
    //   466: istore #7
    //   468: iconst_0
    //   469: istore #6
    //   471: iload #7
    //   473: istore #4
    //   475: iload #6
    //   477: istore #7
    //   479: goto -> 816
    //   482: iconst_3
    //   483: istore #6
    //   485: iload #11
    //   487: istore #8
    //   489: aload_1
    //   490: astore_2
    //   491: iload #14
    //   493: istore #4
    //   495: iload #15
    //   497: istore #5
    //   499: goto -> 47
    //   502: iconst_5
    //   503: istore #6
    //   505: iload #11
    //   507: istore #8
    //   509: aload_1
    //   510: astore_2
    //   511: iload #14
    //   513: istore #4
    //   515: iload #15
    //   517: istore #5
    //   519: goto -> 47
    //   522: iload #12
    //   524: bipush #10
    //   526: if_icmpeq -> 868
    //   529: iload #12
    //   531: bipush #13
    //   533: if_icmpeq -> 865
    //   536: iload #12
    //   538: bipush #33
    //   540: if_icmpeq -> 640
    //   543: iload #12
    //   545: bipush #35
    //   547: if_icmpeq -> 640
    //   550: iload #12
    //   552: bipush #58
    //   554: if_icmpeq -> 607
    //   557: iload #12
    //   559: bipush #61
    //   561: if_icmpeq -> 607
    //   564: iload #12
    //   566: bipush #92
    //   568: if_icmpeq -> 574
    //   571: goto -> 690
    //   574: iload #13
    //   576: iconst_4
    //   577: if_icmpne -> 584
    //   580: iload #11
    //   582: istore #9
    //   584: iconst_1
    //   585: istore #7
    //   587: iconst_1
    //   588: istore #6
    //   590: iload #11
    //   592: istore #8
    //   594: aload_1
    //   595: astore_2
    //   596: iload #14
    //   598: istore #4
    //   600: iload #15
    //   602: istore #5
    //   604: goto -> 47
    //   607: iload #9
    //   609: iconst_m1
    //   610: if_icmpne -> 690
    //   613: iload #11
    //   615: istore #9
    //   617: iconst_1
    //   618: istore #7
    //   620: iload #15
    //   622: istore #5
    //   624: iload #14
    //   626: istore #4
    //   628: iconst_0
    //   629: istore #6
    //   631: iload #11
    //   633: istore #8
    //   635: aload_1
    //   636: astore_2
    //   637: goto -> 47
    //   640: iload #10
    //   642: ifeq -> 690
    //   645: aload_3
    //   646: invokevirtual read : ()I
    //   649: istore #6
    //   651: iload #6
    //   653: iconst_m1
    //   654: if_icmpne -> 660
    //   657: goto -> 683
    //   660: iload #6
    //   662: i2c
    //   663: istore #7
    //   665: iload #13
    //   667: istore #6
    //   669: iload #7
    //   671: bipush #13
    //   673: if_icmpeq -> 761
    //   676: iload #7
    //   678: bipush #10
    //   680: if_icmpne -> 645
    //   683: iload #13
    //   685: istore #6
    //   687: goto -> 761
    //   690: iload #12
    //   692: invokestatic isSpace : (C)Z
    //   695: ifeq -> 781
    //   698: iload #13
    //   700: istore #6
    //   702: iload #13
    //   704: iconst_3
    //   705: if_icmpne -> 711
    //   708: iconst_5
    //   709: istore #6
    //   711: iload #11
    //   713: ifeq -> 761
    //   716: iload #11
    //   718: iload #9
    //   720: if_icmpeq -> 761
    //   723: iload #6
    //   725: iconst_5
    //   726: if_icmpne -> 732
    //   729: goto -> 761
    //   732: iload #9
    //   734: iconst_m1
    //   735: if_icmpne -> 785
    //   738: iconst_1
    //   739: istore #7
    //   741: iconst_4
    //   742: istore #6
    //   744: iload #11
    //   746: istore #8
    //   748: aload_1
    //   749: astore_2
    //   750: iload #14
    //   752: istore #4
    //   754: iload #15
    //   756: istore #5
    //   758: goto -> 47
    //   761: iconst_1
    //   762: istore #7
    //   764: iload #11
    //   766: istore #8
    //   768: aload_1
    //   769: astore_2
    //   770: iload #14
    //   772: istore #4
    //   774: iload #15
    //   776: istore #5
    //   778: goto -> 47
    //   781: iload #13
    //   783: istore #6
    //   785: iload #12
    //   787: istore #7
    //   789: iload #6
    //   791: iconst_5
    //   792: if_icmpeq -> 468
    //   795: iload #12
    //   797: istore #4
    //   799: iload #6
    //   801: istore #7
    //   803: iload #6
    //   805: iconst_3
    //   806: if_icmpne -> 816
    //   809: iload #12
    //   811: istore #7
    //   813: goto -> 468
    //   816: iload #7
    //   818: istore #6
    //   820: iload #7
    //   822: iconst_4
    //   823: if_icmpne -> 833
    //   826: iload #11
    //   828: istore #9
    //   830: iconst_0
    //   831: istore #6
    //   833: aload_1
    //   834: iload #11
    //   836: iload #4
    //   838: i2c
    //   839: castore
    //   840: iload #11
    //   842: iconst_1
    //   843: iadd
    //   844: istore #8
    //   846: iconst_1
    //   847: istore #7
    //   849: iconst_0
    //   850: istore #10
    //   852: aload_1
    //   853: astore_2
    //   854: iload #14
    //   856: istore #4
    //   858: iload #15
    //   860: istore #5
    //   862: goto -> 47
    //   865: goto -> 880
    //   868: iload #13
    //   870: iconst_3
    //   871: if_icmpne -> 880
    //   874: iconst_1
    //   875: istore #7
    //   877: goto -> 502
    //   880: iload #11
    //   882: ifgt -> 895
    //   885: iload #11
    //   887: ifne -> 939
    //   890: iload #9
    //   892: ifne -> 939
    //   895: iload #9
    //   897: istore #6
    //   899: iload #9
    //   901: iconst_m1
    //   902: if_icmpne -> 909
    //   905: iload #11
    //   907: istore #6
    //   909: new java/lang/String
    //   912: dup
    //   913: aload_1
    //   914: iconst_0
    //   915: iload #11
    //   917: invokespecial <init> : ([CII)V
    //   920: astore_2
    //   921: aload_0
    //   922: aload_2
    //   923: iconst_0
    //   924: iload #6
    //   926: invokevirtual substring : (II)Ljava/lang/String;
    //   929: aload_2
    //   930: iload #6
    //   932: invokevirtual substring : (I)Ljava/lang/String;
    //   935: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   938: pop
    //   939: iload #14
    //   941: istore #4
    //   943: iload #15
    //   945: istore #5
    //   947: goto -> 30
    //   950: new java/lang/NullPointerException
    //   953: dup
    //   954: ldc 'Reader cannot be null'
    //   956: invokespecial <init> : (Ljava/lang/String;)V
    //   959: athrow
    //   960: new java/lang/NullPointerException
    //   963: dup
    //   964: ldc 'ObjectMap cannot be null'
    //   966: invokespecial <init> : (Ljava/lang/String;)V
    //   969: astore_0
    //   970: goto -> 975
    //   973: aload_0
    //   974: athrow
    //   975: goto -> 973 }
  
  public static void store(ObjectMap<String, String> paramObjectMap, Writer paramWriter, String paramString) throws IOException { storeImpl(paramObjectMap, paramWriter, paramString, false); }
  
  private static void storeImpl(ObjectMap<String, String> paramObjectMap, Writer paramWriter, String paramString, boolean paramBoolean) throws IOException {
    if (paramString != null)
      writeComment(paramWriter, paramString); 
    paramWriter.write("#");
    paramWriter.write((new Date()).toString());
    paramWriter.write("\n");
    StringBuilder stringBuilder = new StringBuilder('È');
    ObjectMap.Entries entries = paramObjectMap.entries().iterator();
    while (entries.hasNext()) {
      ObjectMap.Entry entry = (ObjectMap.Entry)entries.next();
      dumpString(stringBuilder, (String)entry.key, true, paramBoolean);
      stringBuilder.append('=');
      dumpString(stringBuilder, (String)entry.value, false, paramBoolean);
      paramWriter.write("\n");
      paramWriter.write(stringBuilder.toString());
      stringBuilder.setLength(0);
    } 
    paramWriter.flush();
  }
  
  private static void writeComment(Writer paramWriter, String paramString) throws IOException { // Byte code:
    //   0: aload_0
    //   1: ldc '#'
    //   3: invokevirtual write : (Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokevirtual length : ()I
    //   10: istore_2
    //   11: iconst_0
    //   12: istore_3
    //   13: iconst_0
    //   14: istore #4
    //   16: iload_3
    //   17: iload_2
    //   18: if_icmpge -> 251
    //   21: aload_1
    //   22: iload_3
    //   23: invokevirtual charAt : (I)C
    //   26: istore #5
    //   28: iload #5
    //   30: sipush #255
    //   33: if_icmpgt -> 57
    //   36: iload #5
    //   38: bipush #10
    //   40: if_icmpeq -> 57
    //   43: iload_3
    //   44: istore #6
    //   46: iload #4
    //   48: istore #7
    //   50: iload #5
    //   52: bipush #13
    //   54: if_icmpne -> 239
    //   57: iload #4
    //   59: iload_3
    //   60: if_icmpeq -> 74
    //   63: aload_0
    //   64: aload_1
    //   65: iload #4
    //   67: iload_3
    //   68: invokevirtual substring : (II)Ljava/lang/String;
    //   71: invokevirtual write : (Ljava/lang/String;)V
    //   74: iload #5
    //   76: sipush #255
    //   79: if_icmple -> 131
    //   82: iload #5
    //   84: invokestatic toHexString : (I)Ljava/lang/String;
    //   87: astore #8
    //   89: aload_0
    //   90: ldc '\u'
    //   92: invokevirtual write : (Ljava/lang/String;)V
    //   95: iconst_0
    //   96: istore #7
    //   98: iload #7
    //   100: iconst_4
    //   101: aload #8
    //   103: invokevirtual length : ()I
    //   106: isub
    //   107: if_icmpge -> 122
    //   110: aload_0
    //   111: bipush #48
    //   113: invokevirtual write : (I)V
    //   116: iinc #7, 1
    //   119: goto -> 98
    //   122: aload_0
    //   123: aload #8
    //   125: invokevirtual write : (Ljava/lang/String;)V
    //   128: goto -> 231
    //   131: aload_0
    //   132: ldc '\\n'
    //   134: invokevirtual write : (Ljava/lang/String;)V
    //   137: iload_3
    //   138: istore #7
    //   140: iload #5
    //   142: bipush #13
    //   144: if_icmpne -> 180
    //   147: iload_3
    //   148: istore #7
    //   150: iload_3
    //   151: iload_2
    //   152: iconst_1
    //   153: isub
    //   154: if_icmpeq -> 180
    //   157: iload_3
    //   158: iconst_1
    //   159: iadd
    //   160: istore #4
    //   162: iload_3
    //   163: istore #7
    //   165: aload_1
    //   166: iload #4
    //   168: invokevirtual charAt : (I)C
    //   171: bipush #10
    //   173: if_icmpne -> 180
    //   176: iload #4
    //   178: istore #7
    //   180: iload #7
    //   182: iload_2
    //   183: iconst_1
    //   184: isub
    //   185: if_icmpeq -> 222
    //   188: iload #7
    //   190: iconst_1
    //   191: iadd
    //   192: istore #4
    //   194: iload #7
    //   196: istore_3
    //   197: aload_1
    //   198: iload #4
    //   200: invokevirtual charAt : (I)C
    //   203: bipush #35
    //   205: if_icmpeq -> 231
    //   208: iload #7
    //   210: istore_3
    //   211: aload_1
    //   212: iload #4
    //   214: invokevirtual charAt : (I)C
    //   217: bipush #33
    //   219: if_icmpeq -> 231
    //   222: aload_0
    //   223: ldc '#'
    //   225: invokevirtual write : (Ljava/lang/String;)V
    //   228: iload #7
    //   230: istore_3
    //   231: iload_3
    //   232: iconst_1
    //   233: iadd
    //   234: istore #7
    //   236: iload_3
    //   237: istore #6
    //   239: iload #6
    //   241: iconst_1
    //   242: iadd
    //   243: istore_3
    //   244: iload #7
    //   246: istore #4
    //   248: goto -> 16
    //   251: iload #4
    //   253: iload_3
    //   254: if_icmpeq -> 268
    //   257: aload_0
    //   258: aload_1
    //   259: iload #4
    //   261: iload_3
    //   262: invokevirtual substring : (II)Ljava/lang/String;
    //   265: invokevirtual write : (Ljava/lang/String;)V
    //   268: aload_0
    //   269: ldc '\\n'
    //   271: invokevirtual write : (Ljava/lang/String;)V
    //   274: return }
}


/* Location:              /home/r00tus3r/ctfs/2020/alles/re/prehistoric-mario-dex2jar.jar!/com/badlogic/gdx/utils/PropertiesUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.0.6
 */