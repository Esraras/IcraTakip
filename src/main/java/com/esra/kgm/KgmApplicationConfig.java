package com.esra.kgm;

import org.linkki.framework.ui.application.ApplicationConfig;
import org.linkki.framework.ui.application.menu.ApplicationMenuItemDefinition;
import org.linkki.util.Sequence;
import org.springframework.stereotype.Component;

/**
 * An {@link ApplicationConfig} that defines no menu items and uses {@link KgmApplicationInfo}.
 */
@Component
public class KgmApplicationConfig implements ApplicationConfig {

    @Override
    public KgmApplicationInfo getApplicationInfo() {
        return new KgmApplicationInfo();
    }

    @Override
    public Sequence<ApplicationMenuItemDefinition> getMenuItemDefinitions() {
        return Sequence.empty();
    }

    @Override
    public ApplicationConfig.ApplicationHeaderDefinition getHeaderDefinition() {
        return KgmApplicationHeader::new;
    }

}
