package com.khader.utils.corejavautils.asyn;

import com.khader.utils.corejavautils.asyn.dto.WaybillUpdateResponse;
import com.khader.utils.corejavautils.asyn.dto.WaybillUpdateResult;
import com.khader.utils.corejavautils.asyn.service.WaybillService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class UpdateWaybillStatusService {

//    @Autowired
    private WaybillService waybillService; // Assume you have a WaybillService to perform the update

    @Async
    public CompletableFuture<WaybillUpdateResponse> updateWaybills(List<String> waybillNumbers) {
        List<CompletableFuture<WaybillUpdateResult>> futures = waybillNumbers.parallelStream()
                .map(waybillNumber -> CompletableFuture.supplyAsync(() -> waybillService.updateWaybillStatus(waybillNumber)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        return allOf.thenApply(v -> {
            List<WaybillUpdateResult> results = futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList());

            // Assuming you have a WaybillUpdateResponse class to aggregate results
            return  WaybillUpdateResponse.builder().resultList(results).build();
        });
    }
}