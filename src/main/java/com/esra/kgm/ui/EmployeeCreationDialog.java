package com.esra.kgm.ui;

import com.esra.kgm.entity.Employee;
import org.linkki.core.defaults.ui.aspects.types.RequiredType;
import org.linkki.core.pmo.ModelObject;
import org.linkki.core.ui.element.annotation.UIIntegerField;
import org.linkki.core.ui.element.annotation.UITextField;
import org.linkki.core.ui.layout.annotation.UIFormSection;

import java.util.function.Consumer;

/**
 * Dialog to create a new Employee.
 */
@UIFormSection
public class EmployeeCreationDialog {


    private final Employee employee;

    public EmployeeCreationDialog(Employee employee) {
        this.employee = employee;
    }

    @ModelObject
    public Employee getEmployee() {
        return employee;
    }

    @UITextField(position = 10, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "fname", label = "İsim")
    public void fname() {
    }

    @UITextField(position = 11, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "lname", label = "Soyisim")
    public void lname() {
    }

    @UIIntegerField(position = 12, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "IDNumber", label = "T.C Kimlik No")
    public void IDNumber() {
    }

    @UIIntegerField(position = 13, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "registration", label = "Sicil No")
    public void registration() {
    }

    @UITextField(position = 14, width = "20em", required = RequiredType.REQUIRED, modelAttribute = "department", label = "Çalıştığı Birim")
    public void department() {
    }

}
