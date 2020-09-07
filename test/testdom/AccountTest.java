package testdom;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void depositDoesntAcceptNegativeValue() {
        Account account = new Account(20);
        final boolean result = account.deposit(-10);

        Assert.assertEquals(0d, account.getBalance(), epsilon);
        Assert.assertFalse(result);
    }

    @Test
    public void withdrawDoesntAcceptNegativeValue() {
        Account account = new Account(20);
        final boolean result = account.withdraw(-10);

        Assert.assertEquals(0d, account.getBalance(), epsilon);
        Assert.assertFalse(result);
    }

    @Test
    public void depositPositiveValueOk() {
        Account account = new Account(20);
        final boolean result = account.deposit(10);

        Assert.assertEquals(10d, account.getBalance(), epsilon);
        Assert.assertTrue(result);
    }

    @Test
    public void withdrawPositiveValueOverdraftOk() {
        Account account = new Account(20);
        final boolean result = account.withdraw(10);

        Assert.assertEquals(-10d, account.getBalance(), epsilon);
        Assert.assertTrue(result);
    }

    @Test
    public void withdrawPositiveValueBalanceOk() {
        Account account = new Account(0);
        account.deposit(20);
        final boolean result = account.withdraw(10);

        Assert.assertEquals(10d, account.getBalance(), epsilon);
        Assert.assertTrue(result);
    }

    @Test
    public void accountCannotOverstepOverdraftLimit() {
        Account account = new Account(20);
        final boolean result = account.withdraw(30);

        Assert.assertEquals(0d, account.getBalance(), epsilon);
        Assert.assertFalse(result);
    }
}