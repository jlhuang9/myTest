package io.jenkins.plugins.sample;

import com.alibaba.fastjson.JSONObject;
import io.jenkins.plugins.sample.entity.TaskEntity;
import io.jenkins.plugins.sample.util.HttpUtils;
import org.junit.Test;

import java.io.IOException;

public class HttpUtilsTest {

    private static final String host = "http://localhost:8888";
    @Test
    public void testSendHealth() throws IOException {
        String s = HttpUtils.httpGet(host + "/health");
    }

    @Test
    public void testSendBuildData() throws IOException {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setName("test");
        taskEntity.setNumber(1);
        taskEntity.setTimestamp(System.currentTimeMillis());
        String s = HttpUtils.httpPostWithJSON(host + "/build_data", JSONObject.toJSONString(taskEntity));
    }
}