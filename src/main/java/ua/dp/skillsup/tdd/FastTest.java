package ua.dp.skillsup.tdd;

import org.junit.Test;
import org.mockito.*;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class FastTest {
@Test
    public void transferOnWorking(){
    WorkingService transWorking = Mockito.mock(WorkingService.class);
    Mockito.when(transWorking.isWorking()).thenReturn(false);
    FeeService feeService = new FeeService(transWorking);
    AccountService workingAcountServis = new AccountService(feeService);
    BankAccount sender = new BankAccount(1000);
    BankAccount recipient = new BankAccount(0);

    workingAcountServis.transferMoney(sender,recipient,1000);
    Assert.assertEquals(0, sender.getAmount(), 0.00001);
    Assert.assertEquals(990,recipient.getAmount(),0.00001);


}
    @Test
    public void transferOnWeekend(){

    WeekendService transWeekend = new WeekendService(LocalDate.of(2018,Month.JANUARY,21));
    FeeService feeService = new FeeService(transWeekend);
    AccountService weekendAcountService = new AccountService(feeService);
    BankAccount sender = new BankAccount(1000);
    BankAccount recipient = new BankAccount(0);

    weekendAcountService.transferMoney(sender,recipient,1000);
    Assert.assertEquals(0, sender.getAmount(), 0.00001);
    Assert.assertEquals(985,recipient.getAmount(),0.00001);

    }

    @Test

    public void transferOnHolidaysWorking(){
        HolidayService holidayService = Mockito.mock(HolidayService.class);
        Mockito.when(holidayService.isHoliday(new Date())).thenReturn(true);
        WorkingService workingService = Mockito.mock(WorkingService.class);
        Mockito.when(workingService.isWorking()).thenReturn(false);
        FeeService feeService = new FeeService(holidayService,workingService);
        AccountService holidaysWorkingAcountServis = new AccountService(feeService);
        BankAccount sender = new BankAccount(1000);
        BankAccount recipient = new BankAccount(0);

        holidaysWorkingAcountServis.transferMoney(sender,recipient,1000);
        Assert.assertEquals(0, sender.getAmount(), 0.00001);
        Assert.assertEquals(985,recipient.getAmount(),0.00001);

    }
    @Test
    public  void transferOnHolidayWekend() {
        HolidayService holidayService = Mockito.mock(HolidayService.class);
        Mockito.when(holidayService.isHoliday(new Date())).thenReturn(true);
        WeekendService weekendService = new WeekendService(LocalDate.of(2018,Month.JANUARY,21));
        FeeService feeService = new FeeService(holidayService,weekendService);
        AccountService holidaysWeekendAcountServis = new AccountService(feeService);
        BankAccount sender = new BankAccount(1000);
        BankAccount recipient = new BankAccount(0);

        holidaysWeekendAcountServis.transferMoney(sender,recipient,1000);
        Assert.assertEquals(0,sender.getAmount(),0.0001);
        Assert.assertEquals(980,recipient.getAmount(),0.0001);


    }
}
