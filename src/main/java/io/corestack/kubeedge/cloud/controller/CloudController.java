package io.corestack.kubeedge.cloud.controller;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientException;
import io.fabric8.kubernetes.client.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CloudController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CloudController.class);

    @Autowired
    private DefaultKubernetesClient client;

    public void listAndWatch() {
        client.pods().watch(new Watcher<Pod>() {
            @Override
            public void eventReceived(Action action, Pod pod) {
                LOGGER.info("Received action: {}, pod: {}.", action, pod);
            }

            @Override
            public void onClose(KubernetesClientException e) {
                LOGGER.warn("", e);
            }
        });

    }

}
