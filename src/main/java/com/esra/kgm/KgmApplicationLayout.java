package com.esra.kgm;

import org.linkki.framework.ui.application.ApplicationConfig;
import org.linkki.framework.ui.application.ApplicationLayout;
import org.springframework.stereotype.Component;

import com.vaadin.flow.spring.annotation.UIScope;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Theme(Lumo.class)
@Component
@UIScope
public class KgmApplicationLayout extends ApplicationLayout {

    private static final long serialVersionUID = 1L;

    protected KgmApplicationLayout(ApplicationConfig config) {
        super(config);
    }
}
