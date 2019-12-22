package io.corestack.kubeedge.cloud.provider;

import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import org.springframework.stereotype.Service;

import javax.enterprise.inject.Produces;

@Service
public class ClientProvider {

    @Produces
    public DefaultKubernetesClient defaultKubernetesClient() {
        return new DefaultKubernetesClient();
    }

}
