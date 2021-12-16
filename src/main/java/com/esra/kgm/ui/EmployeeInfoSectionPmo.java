package com.esra.kgm.ui;

import com.esra.kgm.entity.Employee;
import com.esra.kgm.entity.Entry;
import com.vaadin.flow.component.button.ButtonVariant;
import org.apache.commons.lang3.StringUtils;
import org.linkki.core.defaults.ui.aspects.types.RequiredType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.aspects.annotation.BindStyleNames;
import org.linkki.core.ui.element.annotation.*;
import org.linkki.core.ui.layout.annotation.UIFormSection;
import org.linkki.core.ui.layout.annotation.UIHorizontalLayout;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.ui.nested.annotation.UINestedComponent;
import org.linkki.framework.ui.dialogs.PmoBasedDialogFactory;
import org.linkki.util.handler.Handler;

import java.util.function.Consumer;

@UIFormSection
public class EmployeeInfoSectionPmo {

    private final Employee employee;
    private final Consumer<Entry> saveEntry;

    public EmployeeInfoSectionPmo(Employee employee, Consumer<Entry> saveEntry) {
        this.employee = employee;
        this.saveEntry = saveEntry;
    }

    @UINestedComponent(position = 20)
    public Nested getNestedComponent() {
        return new Nested();
    }

    @UIHorizontalLayout
    public class Nested {

        @ModelObject
        public Employee getEmployee() {
            return employee;
        }

        @UILabel(position = 10, modelAttribute = "fname", label = "İsim")
        public void fname() {
        }

        @UILabel(position = 11, modelAttribute = "lname", label = "Soyisim")
        public void lname() {
        }

        @UILabel(position = 12, modelAttribute = "IDNumber", label = "T.C Kimlik No")
        public void IDNumber() {
        }

        @UILabel(position = 13, modelAttribute = "registration", label = "Sicil No")
        public void registration() {
        }

        @UILabel(position = 14, modelAttribute = "department", label = "Çalıştığı Birim")
        public void department() {
        }

        @UIButton(position = 15, caption = "Yeni borc", variants = ButtonVariant.LUMO_PRIMARY)
        public void addEntry() {

            Entry entry = new Entry();
            entry.setEmployee(employee);
            var entryCreationDialog = new EntryCreationDialog(entry);

            Handler addEntry = () -> {
                saveEntry.accept(entryCreationDialog.getEntry());
            };

            var dialogFactory = new PmoBasedDialogFactory();
            var okCancelDialog = dialogFactory.newOkCancelDialog("Yeni borc",
                    addEntry,
                    entryCreationDialog);
            okCancelDialog.open().setSize("50em", "30em");
        }
    }






}
