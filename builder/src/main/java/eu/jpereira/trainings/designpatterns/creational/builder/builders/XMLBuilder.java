package eu.jpereira.trainings.designpatterns.creational.builder.builders;

import eu.jpereira.trainings.designpatterns.creational.builder.HTMLReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

import java.util.Iterator;
import java.util.List;

public class XMLBuilder extends XMLReportBody implements IReportBuilder {

    private XMLReportBody reportBody = new XMLReportBody();

    @Override
    public IReportBuilder setCustomerName(String customerName) {
        reportBody.putContent("<sale><customer><name>");
        reportBody.putContent(customerName);
        reportBody.putContent("</name><phone>");
        return this;
    }

    @Override
    public IReportBuilder setCustomerPhone(String phoneNumber) {
        reportBody.putContent(phoneNumber);
        reportBody.putContent("</phone></customer>");
        return this;
    }
    @Override
    public IReportBuilder setItems(List<SoldItem> soldItems) {
        reportBody.putContent("<items>");

        Iterator<SoldItem> it = soldItems.iterator();
        while ( it.hasNext() ) {
            SoldItem soldEntry= it.next();
            reportBody.putContent("<item><name>");
            reportBody.putContent(soldEntry.getName());
            reportBody.putContent("</name><quantity>");
            reportBody.putContent(soldEntry.getQuantity());
            reportBody.putContent("</quantity><price>");
            reportBody.putContent(soldEntry.getUnitPrice());
            reportBody.putContent("</price></item>");
        }
        reportBody.putContent("</items></sale>");
        return this;
    }

    @Override
    public ReportBody getReportBody() {
        return reportBody;
    }
}