package org.dmetzler.isen.puissance4.rest;

import static org.assertj.core.api.Assertions.assertThat;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.dmetzler.isen.puissance4.jaxrs.Puissance4Application;
import org.dmetzler.isen.puissance4.jpa.Puissance4Adapter;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;

public class Puissance4APITest extends JerseyTest {

    @Override
    protected Application configure() {
        return new Puissance4Application();
    }

    @Test
    @Ignore
    public void itCanCreateAGame() throws Exception {
        Puissance4Adapter game = target("api").request(MediaType.APPLICATION_JSON)
                .get(Puissance4Adapter.class);

        assertThat(game.getToken()).isNotNull();

    }

}
