package com.haliri.israj.apporder.service;

import com.haliri.israj.appcommon.dto.Item;
import com.haliri.israj.appcommon.dto.Request;
import com.haliri.israj.appcommon.util.JsonUtil;
import com.haliri.israj.apporder.client.ItemClient;
import com.haliri.israj.apporder.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ItemClient itemClient;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String kafkaTopicOrder;

    public List<Request> find() {
        return requestRepository.find(null, null, null);
    }

    @Transactional
    public void save(Request request) {
        requestRepository.save(request);

        itemClient.updateAmount(request.getItem().getId());

        Item item = itemClient.findById(request.getItem().getId());

        request.setItem(item);

        kafkaTemplate.send(kafkaTopicOrder, JsonUtil.toJson(request));
    }
}
