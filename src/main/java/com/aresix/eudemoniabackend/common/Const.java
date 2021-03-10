package com.aresix.eudemoniabackend.common;

import java.io.File;

public class Const {
    public static final String CURRENT_USER = "USER";
    // 现在是我本地路径，将来要改成服务器路径的！
    // TODO: 改成服务器路径
    public static final String UPLOAD_IMG_PATH =
            "F:" + File.separator + "Projects" + File.separator +
                    "Entrepreneurship_and_innovation_project" +
                    File.separator + "2020_2021" + File.separator + "project" +
                    File.separator + "uploadImg";

    /**
     * TODO: 不要管我 我是要被删掉的…… 数据库改完之前只能先这么将就一下了……
     */
    public static int uid = 0;
    public static int tid = 0;
}
