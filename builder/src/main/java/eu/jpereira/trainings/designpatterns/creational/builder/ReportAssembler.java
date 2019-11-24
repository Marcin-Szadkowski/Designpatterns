/**
 * Copyright 2011 Joao Miguel Pereira
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package eu.jpereira.trainings.designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.jpereira.trainings.designpatterns.creational.builder.builders.HTMLBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.builders.IReportBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.builders.JSONBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.builders.XMLBuilder;
import eu.jpereira.trainings.designpatterns.creational.builder.json.JSONReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.Report;
import eu.jpereira.trainings.designpatterns.creational.builder.model.ReportBody;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SaleEntry;
import eu.jpereira.trainings.designpatterns.creational.builder.model.SoldItem;
import eu.jpereira.trainings.designpatterns.creational.builder.xml.XMLReportBody;

/**
 * @author jpereira
 * 
 */
public class ReportAssembler {

	private SaleEntry saleEntry;
	private Report report;
	private String name;
	private String phoneNumber;
	private List<SoldItem> soldItems;


	public void setSaleEntry(SaleEntry saleEntry) {
		this.saleEntry = saleEntry;

	}

	/**
	 * @param reportBuilder
	 * @return
	 */
	public Report getReport(IReportBuilder reportBuilder) {
			report = new Report();

			name = saleEntry.getCustomer().getName();
			phoneNumber = saleEntry.getCustomer().getPhone();
			soldItems = saleEntry.getSoldItems();

			reportBuilder.setCustomerName(name).
					setCustomerPhone(phoneNumber).
					setItems(soldItems);

			report.setReportBody(reportBuilder.getReportBody());

			return report;
	}
}
