package com.dmz.library.dmzapi.utils;

import android.content.ClipboardManager;
import android.content.Context;

/**
 * Created by dengmingzhi on 2017/9/25.
 */

public class Copy {
    /**
     * 复制文本内容到系统剪贴板
     *
     * @param content
     * @param ctx
     */
    public static void toCopy(String content, Context ctx) {
        ClipboardManager cm = (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
        cm.setText(content);
        MyToast.normal("已复制至剪切板");
    }
}
