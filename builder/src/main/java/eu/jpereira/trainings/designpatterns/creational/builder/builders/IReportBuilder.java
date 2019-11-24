package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;

import java.util.List;

public interface IReportBuilder {
    IReportBuilder setCustomerName(String customerName);
    IReportBuilder setCustomerPhone(String phoneNumber);
    IReportBuilder setItems(List<SoldItem> soldItems);
    ReportBody getReportBody();
}