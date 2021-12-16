package com.esra.kgm.ui;

import com.esra.kgm.entity.Employee;
import org.apache.commons.lang3.StringUtils;
import org.linkki.core.defaults.ui.aspects.annotations.BindTooltip;
import org.linkki.core.defaults.ui.aspects.types.EnabledType;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UISection;
import org.linkki.core.vaadin.component.KeyCode;
import org.linkki.framework.ui.dialogs.PmoBasedDialogFactory;
import org.linkki.util.handler.Handler;

import com.vaadin.flow.component.button.ButtonVariant;
import org.yaml.snakeyaml.events.Event;

import java.util.function.Consumer;
import java.util.function.Supplier;

@UISection(caption = "Arama yap")
public class SearchSectionPmo {

    private Integer registration;

    private final Consumer<Employee> saveEmployee;
    private final Consumer<Employee> searchEmployee;

    public SearchSectionPmo(Consumer<Employee> saveEmployee, Consumer<Employee> searchEmployee) {
        this.saveEmployee = saveEmployee;
        this.searchEmployee = searchEmployee;
    }

    @UITextField(position = 4, label = "Sicil No")
    public Integer getRegistration() {
        return registration;
    }

    public void setRegistration(int registration) {
        this.registration = registration;
    }


    @UIButton(position = 6, caption = "Ara", variants = ButtonVariant.LUMO_PRIMARY, enabled = EnabledType.DYNAMIC, shortcutKeyCode = {
            KeyCode.ENTER})
    @BindTooltip
    public void doSearch() {
        searchEmployee.accept(
                Employee.builder()
                        .registration(registration)
                        .build()
        );
    }

    @UIButton(position = 7, caption = "Yeni personel", variants = ButtonVariant.LUMO_PRIMARY)
    public void addEmployee() {

        Employee tempEmployee = new Employee();
        var employeeCreationDialog = new EmployeeCreationDialog(tempEmployee);

        Handler addEmployee = () -> {
            saveEmployee.accept(employeeCreationDialog.getEmployee());
        };

        var dialogFactory = new PmoBasedDialogFactory();
        var okCancelDialog = dialogFactory.newOkCancelDialog("Yeni personel",
                addEmployee,
                employeeCreationDialog);
        okCancelDialog.open().setSize("50em", "30em");
    }

    public boolean isDoSearchEnabled() {
        return registration != null;
    }

    public String getDoSearchTooltip() {
        if (!isDoSearchEnabled()) {
            return "Sicili doldurunuz";
        }
        return "";
    }

}
