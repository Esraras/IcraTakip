package com.esra.kgm.ui;

import java.util.function.Consumer;

import org.linkki.core.defaults.ui.aspects.types.CaptionType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIButton;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.table.column.annotation.UITableColumn;
import org.linkki.util.handler.Handler;

import com.esra.kgm.entity.Employee;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.VaadinIcon;

/**
 * Row to display a policy's pool assignment.
 */
public class EmployeeRowPmo {

    private final Employee employee;
    private final Consumer<Employee> deleteConsumer;

    public EmployeeRowPmo(Employee employee,
                          Consumer<Employee> deleteConsumer) {
        this.employee = employee;
        this.deleteConsumer = deleteConsumer;
    }

    @ModelObject
    public Employee getEmployee() {
        return employee;
    }

    @UITableColumn
    @UITextField(position = 1, label = "Isim", modelAttribute = "fname")
    public void name() {
    }

    @UITableColumn
    @UITextField(position = 2, label = "Soyisim", modelAttribute = "lname")
    public void lastname() {
    }

    @UITableColumn
    @UIButton(position = 3, icon = VaadinIcon.TRASH, variants = ButtonVariant.LUMO_ERROR, showIcon = true, captionType = CaptionType.NONE)
    public void delete() {
        deleteConsumer.accept(getEmployee());
    }


}
