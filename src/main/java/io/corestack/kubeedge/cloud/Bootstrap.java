package io.corestack.kubeedge.cloud;

import io.corestack.kubeedge.cloud.controller.CloudController;
import io.quarkus.runtime.StartupEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.enterprise.event.Observes;

@Service
public class Bootstrap {

//    @Autowired
//    private CloudController cloudController;
//
//    public void main(@Observes StartupEvent event) {
//        cloudController.listAndWatch();
//    }
}
