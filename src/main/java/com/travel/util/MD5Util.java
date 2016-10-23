package com.travel.util;

import com.sun.javafx.tk.TKClipboard;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * MD5 Util
 * <p/>
 * MD5工具类
 */

public class MD5Util {

    protected static char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected static MessageDigest messagedigest = null;

    static {
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5Util message digest initialize error" + e.getMessage());
        }
    }


    public static synchronized String getFileMD5String1(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
        messagedigest.update(byteBuffer);
        return bufferToHex(messagedigest.digest());
    }

    public static synchronized String getFileMD5String(File file) throws IOException {
        InputStream fis;
        fis = new FileInputStream(file);
        byte[] buffer = new byte[1024 * 16];
        int numRead;
        while ((numRead = fis.read(buffer)) > 0) {
            messagedigest.update(buffer, 0, numRead);
        }
        fis.close();
        return bufferToHex(messagedigest.digest());
    }

    public static synchronized String getSha1MD5String(String s, String random) {
        String str = DigestUtils.shaHex(random);
        return getMD5String((str + s).getBytes());
    }


    public static synchronized String getMD5String(String s) {
        return getMD5String(s.getBytes());
    }

    public static synchronized String getMD5String(byte[] bytes) {
        messagedigest.update(bytes);
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte bytes[]) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte bytes[], int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;
        for (int l = m; l < k; l++) {
            appendHexPair(bytes[l], stringbuffer);
        }
        return stringbuffer.toString();
    }

    private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
        char c0 = hexDigits[(bt & 0xf0) >> 4];
        char c1 = hexDigits[bt & 0xf];
        stringbuffer.append(c0);
        stringbuffer.append(c1);
    }

    public static String getMd5ByFile(File file) {
        String value = null;
        FileInputStream in = null;
        try {
            in = new FileInputStream(file);
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    public static long atoi(String str) throws Exception {

        boolean negative = false;
        long value = 0;

        if (str == null || str.equals("")) {
            throw new Exception("null string or the string has no character!");
        }

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
                if (str.charAt(0) == '-') {
                    negative = true;
                }
            } else {
                if (str.charAt(i) >= '0' && '9' >= str.charAt(i)) {
                    value = value * 10 + (str.charAt(i) - '0');
                    if (value > Integer.MAX_VALUE) {
                        throw new Exception("OUT OF INTEGER RANGE");
                    }
                } else {
                    throw new NumberFormatException("not an integer");
                }
            }
        }
        return negative == true ? value * -1 : value;
    }
    /**
     * 功能：Java读取txt文件的内容
     * 步骤：1：先获得文件句柄
     * 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流
     * 4：一行一行的输出。readline()。
     * 备注：需要考虑的是异常情况
     * @param filePath
     */
    public static void readTxtFile(String filePath) {
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                int i = 0;
                int num = 0;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                   // System.out.println(lineTxt);
                    num +=Integer.parseInt(lineTxt);
                    i++;
                }
                read.close();
                System.out.println(num/i);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception {
        //Vector<Point> lineVector = new Vectr<Point>();
           // List<double> a  = new ArrayList<double>();
     //   a.toString()
        //        String md5String = getMD5String("111111"+"");
//        System.out.println(md5String);
        // 96e79218965eb72c92a549dd5a330112   2d1a16e0b26a285fd8cc84c46e2cd363 2d1a16e0b26a285fd8cc84c46e2cd363
    }

}