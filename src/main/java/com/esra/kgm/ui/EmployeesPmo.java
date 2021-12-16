package com.esra.kgm.ui;

import java.util.List;
import java.util.function.Consumer;

import org.linkki.core.defaults.columnbased.pmo.SimpleTablePmo;
import org.linkki.core.ui.layout.annotation.UISection;

import com.esra.kgm.entity.Employee;

/**
 *
 */
@UISection
public class EmployeesPmo extends SimpleTablePmo<Employee, EmployeeRowPmo> {

    private final Consumer<Employee> deleteConsumer;

    public EmployeesPmo(List<Employee> employees,
                        Consumer<Employee> deleteConsumer) {
        super(employees);
        this.deleteConsumer = deleteConsumer;
    }

    @Override
    protected EmployeeRowPmo createRow(Employee employee) {
        return new EmployeeRowPmo(employee, deleteConsumer);
    }
}
