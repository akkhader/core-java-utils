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
//public class PickupScanHandler implements  ConsignmentScanHandler{
//
//    private final ConsignmentService consignmentService;
//    private final ConsignmentEventRepository consignmentEventRepository;
//    private final MappingHelper mappingHelper;
//    private final  KafkaProducer kafkaProducer;
//
//    @Override
//    public void handleScan(ConsignmentScanRequest request, Consignment consignment) {
//        consignment.setPickupCourierId(request.getEmployeeCode());
//        consignment.setStatus(EventCode.PICKUP_COMPLETED.name());
//
//        request.setEventStatus(EventCode.PICKUP_COMPLETED.name());
//        request.setCustomerAccount(consignment.getCustomerAccount());
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
//        return Set.of(201,202,203);
//    }
//
//
//    @Override
//    public void invokeAnotherHandler(ConsignmentScanRequest request, Consignment consignment) {
//
//    }
//}
