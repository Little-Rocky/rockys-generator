package com.gen.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

public class MetaManager {

    public static volatile Meta meta;

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    public static Meta initMeta() {
        // 先把Json文件里面的格式转换成String
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        // 再把String格式里面的字段转换成对象接收
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);

        return newMeta;
    }
}
