package com.quarri6343.chattranslator.japanizer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GoogleIME {

    protected GoogleIME() {
    }

    /**
     * GoogleIMEの最初の変換候補を抽出して結合します
     *
     * @param json 変換元のJson形式の文字列
     * @return 変換後の文字列
     * @since 2.8.10
     */
    public static String parseJson(String json) {
        StringBuilder result = new StringBuilder();
        result.append(new Gson().fromJson(json, JsonObject.class).get("text").getAsString());
        return result.toString();
    }
}
