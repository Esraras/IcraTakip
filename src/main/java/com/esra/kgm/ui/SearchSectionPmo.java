package com.esra.kgm.ui;

import org.apache.commons.lang3.StringUtils;
import org.linkki.core.defaults.ui.aspects.annotations.BindTooltip;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.vaadin.component.KeyCode;
import org.linkki.util.handler.Handler;

import com.vaadin.flow.component.button.ButtonVariant;

@UISection(caption = "Arama yap")
public class SearchSectionPmo {

    private String name;
    private String lastname;

    private final Handler searchHandler;

    public SearchSectionPmo(Handler searchHandler) {
        this.searchHandler = searchHandler;
    }

    @UITextField(position = 1, label = "İsim")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @UITextField(position = 2, label = "Soyisim")
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @UIButton(position = 4, caption = "Ara", variants = ButtonVariant.LUMO_PRIMARY, enabled = EnabledType.DYNAMIC, shortcutKeyCode = {
            KeyCode.ENTER })
    @BindTooltip
    public void doSearch() {
        searchHandler.apply();
    }

    public boolean isDoSearchEnabled() {
        return StringUtils.isNotBlank(name) || StringUtils.isNotBlank(lastname);
    }

    public String getDoSearchTooltip() {
        if (!isDoSearchEnabled()) {
            return "En az bir arama kelimesi giriniz";
        }
        return "";
    }

}
