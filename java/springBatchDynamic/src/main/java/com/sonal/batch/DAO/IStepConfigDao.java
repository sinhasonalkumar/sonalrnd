package com.sonal.batch.DAO;

import java.util.Map;

public interface IStepConfigDao {

    Map<String, String> getStepToTaskletMapping(String jobRequestId);

}