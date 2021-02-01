package com.hsy.java.base.blob;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

public class BlobUtil {

    public static String blob2String(Blob blob) {
        String content = null;
        if (blob != null) {
            try {
                InputStream is = blob.getBinaryStream();
                byte[] b = new byte[is.available()];
                is.read(b, 0, b.length);
                content = new String(b);
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    /*public static void main(String[] args) {

        System.out.println("https://mobile.priseer.com/freeitems-list/19430108?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/"
                + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/freeitems-list/19430108?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/"
                + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/1c989344-c18f-4e83-af16-9f77aed05a82?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/1c989344-c18f-4e83-af16-9f77aed05a82?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/36796730-66b9-474c-b236-6ffb2b35162d?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/36796730-66b9-474c-b236-6ffb2b35162d?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/07d61085-0a57-413b-8cb1-436d6d83da3c?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/07d61085-0a57-413b-8cb1-436d6d83da3c?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/12675f34-0639-46d3-9be9-b7faf770a79c?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/12675f34-0639-46d3-9be9-b7faf770a79c?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/8c769efa-110c-4c1f-9eb1-cde4f461cb31?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/8c769efa-110c-4c1f-9eb1-cde4f461cb31?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/b0a0a5c3-f836-48b6-8a2f-6f3dc1a97a5e?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/b0a0a5c3-f836-48b6-8a2f-6f3dc1a97a5e?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/2cd9f859-34f0-44fa-914c-624229ab250b?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/2cd9f859-34f0-44fa-914c-624229ab250b?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/93c9e2e9-5ed9-4091-9203-66a6f9f04e40?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/93c9e2e9-5ed9-4091-9203-66a6f9f04e40?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com/goods/4bd5a7a6-4a39-4a93-a606-59e88f9504d4?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com/goods/4bd5a7a6-4a39-4a93-a606-59e88f9504d4?utm_source=outsite_EDM".trim()));

        System.out.println("https://mobile.priseer.com?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://mobile.priseer.com?utm_source=outsite_EDM".trim()));

        System.out.println("https://itunes.apple.com/us/app/priseer/id1388263144?l=zh&ls=1&mt=8&utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://itunes.apple.com/us/app/priseer/id1388263144?l=zh&ls=1&mt=8&utm_source=outsite_EDM".trim()));

        System.out.println("https://play.google.com/store/apps/details?id=com.yinzheng.priseer&utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://play.google.com/store/apps/details?id=com.yinzheng.priseer&utm_source=outsite_EDM".trim()));

        System.out.println("https://www.facebook.com/priseerstore?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://www.facebook.com/priseerstore?utm_source=outsite_EDM".trim()));

        System.out.println("https://twitter.com/priseerstore?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://twitter.com/priseerstore?utm_source=outsite_EDM".trim()));

        System.out.println("https://www.instagram.com/priseerstore?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://www.instagram.com/priseerstore?utm_source=outsite_EDM".trim()));

        System.out.println("https://www.pinterest.com/priseer?utm_source=outsite_EDM    ----> "
                + "https://server.priseer.com/api/v1/link/" + com.askingdata.y.util.security.MD5Util.md5Hex("https://www.pinterest.com/priseer?utm_source=outsite_EDM".trim()));
    }*/
}
