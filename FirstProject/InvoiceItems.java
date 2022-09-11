package FirstProject;

import java.util.Date;

public class InvoiceItems {
    public int number=2;
    public int invoiceNumber=0;
    public String customerName;
    public String itemName;
    public double price;
    public int count;
    public double itemTotal=0;
    public double invoiceTotal=0;

    public InvoiceItems() {
    }
    public InvoiceItems(String customerName,String itemName,double price,int count){
        this.customerName=customerName;
        this.itemName=itemName;
        this.price=price;
        this.count=count;
        invoiceNumber+=1;
        number+=1;
        itemTotal=price*count;
        invoiceTotal+=itemTotal;
        Date date = new Date();

    }
}


