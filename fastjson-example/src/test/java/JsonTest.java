/*
 * Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
 */

import com.alibaba.fastjson.JSON;
import com.luobosi.study.fe.domain.TastePreferencesDO;
import org.junit.Test;

/**
 * JsonTest
 *
 * @author luobosi@2dfire.com
 * @since 2018-02-02
 */
public class JsonTest {

    @Test
    public void testJsonToString() {
        TastePreferencesDO tastePreferencesDO = new TastePreferencesDO();
        tastePreferencesDO.setPreferences("marvel");
        System.out.println(JSON.toJSONString(tastePreferencesDO));
    }

}