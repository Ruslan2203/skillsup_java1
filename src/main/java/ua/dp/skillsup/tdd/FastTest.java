package ua.dp.skillsup.tdd;

import org.junit.Test;
import org.mockito.*;
import org.junit.Assert;

import java.time.Month;

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

    WeekendService transWeekend = new WeekendService(1);
    FeeService feeService = new FeeService(transWeekend);
    AccountService weekendAcountService = new AccountService(feeService);
    BankAccount sender = new BankAccount(1000);
    BankAccount recipient = new BankAccount(0);

    weekendAcountService.transferMoney(sender,recipient,1000);
    Assert.assertEquals(0, sender.getAmount(), 0.00001);
    Assert.assertEquals(985,recipient.getAmount(),0.00001);

    }
}
