package com.khader.utils.corejavautils.asyn.dto;

import lombok.Builder;

import java.util.List;
@Builder
public class WaybillUpdateResponse {

    private List<WaybillUpdateResult> resultList;
}
