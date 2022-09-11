package FirstProject;

import java.util.Date;

public class InvoicePreview {
    int customersNumber=0;

    public InvoicePreview(){
        InvoiceItems preview=new InvoiceItems();
        String customerName = preview.customerName;
        double invoiceTotal= preview.invoiceTotal;
        customersNumber+=1;
        Date date = new Date();


    }
}
