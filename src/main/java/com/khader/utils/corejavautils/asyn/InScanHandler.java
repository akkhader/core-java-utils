package com.khader.utils.corejavautils.asyn;//package com.ajex.aone.ops.service;
//
//import com.ajex.aone.ops.controller.request.ConsignmentScanRequest;
//import com.ajex.aone.ops.entity.Consignment;
//import com.ajex.aone.ops.entity.ConsignmentEvent;
//import com.ajex.aone.ops.enums.EventCode;
//import com.ajex.aone.ops.kafka.KafkaProducer;
//import com.ajex.aone.ops.mapper.MappingHelper;
//import com.ajex.aone.ops.repository.ConsignmentEventRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.Set;
//
//@Component
//@RequiredArgsConstructor
//public class InScanHandler implements ConsignmentScanHandler {
//
//
//    private final ConsignmentService consignmentService;
//    private final ConsignmentEventRepository consignmentEventRepository;
//    private final MappingHelper mappingHelper;
//    private final KafkaProducer kafkaProducer;
//
//    @Override
//    public void handleScan(ConsignmentScanRequest request, Consignment consignment) {
//
//        if (request.getHubCode().equalsIgnoreCase(consignment.getOriginHub())){
//            // origin hub
//            request.setEventCode(EventCode.IN_SCAN_AT_ORIGIN_HUB.getCode());
//            request.setEventStatus(EventCode.IN_SCAN_AT_TRANSIT_HUB.getValue());
//        } else if (request.getHubCode().equalsIgnoreCase(consignment.getDestHub())) {
//            // destination hub
//            request.setEventCode(EventCode.IN_SCAN_AT_DEST_HUB.getCode());
//            request.setEventStatus(EventCode.IN_SCAN_AT_TRANSIT_HUB.getValue());
//        } else  {
//            // transit hub
//            request.setEventCode(EventCode.IN_SCAN_AT_TRANSIT_HUB.getCode());
//            request.setEventStatus(EventCode.IN_SCAN_AT_TRANSIT_HUB.getValue());
//        }
//        consignment.setStatus(EventCode.IN_SCAN_AT_TRANSIT_HUB.getValue());
//        consignment.setUpdatedBy(request.getEmployeeCode());
//
//        consignmentService.save(consignment);
//        ConsignmentEvent consignmentEvent = mappingHelper.map(request, ConsignmentEvent.class);
//        consignmentEventRepository.save(consignmentEvent);
//        kafkaProducer.sendToKafka(Arrays.asList(consignmentEvent));
//
//    }
//
//    @Override
//    public Set<Integer> getHandlerEventCode() {
//        return null;
//    }
//
//    @Override
//    public void invokeAnotherHandler(ConsignmentScanRequest request, Consignment consignment) {
//        if (EventCode.PICKUP_PENDING.name().equalsIgnoreCase(consignment.getStatus())){
//
//            consignmentService.
//        }
//
//    }
//}
