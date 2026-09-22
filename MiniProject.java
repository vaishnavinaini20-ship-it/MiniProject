import java.util.Scanner;

public class MiniProject
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================");
        System.out.println("----- SMART BANK ATM-----");
        System.out.println("=========================");

        System.out.println("Enter Account Holder Name");
        String name = sc.nextLine();

        System.out.println("Enter Account Number");
        long accountNumber = sc.nextLong();

        System.out.println("Enter age");
        int age = sc.nextInt();

        System.out.println("Enter Initial Balance");
        double balance = sc.nextDouble();

        double initialBalance = balance;

        double interest = 0;
        double openingBalance = initialBalance;
        double lastAmount = 0;
        double lastFee = 0;
        String lastOperation = "No operation yet";

        if (age >= 18 && balance >= 1000)
        {
            System.out.println("System details are valid.");

            String accountType;

            if (balance >= 100000)
            {
                accountType = "Platinum";
            }
            else if (balance >= 50000)
            {
                accountType = "Gold";
            }
            else if (balance >= 10000)
            {
                accountType = "Silver";
            }
            else
            {
                accountType = "basic";
            }

            System.out.println();
            System.out.println("======================================");
            System.out.println("     ACCOUNT CREATED SUCCESSFULLY     ");
            System.out.println("======================================");

            System.out.println("Name         : " + name);
            System.out.println("Account No   : " + accountNumber);
            System.out.println("Account Type : " + accountType);
            System.out.println("Balance      : " + balance);

            System.out.println();
            System.out.println("============================");
            System.out.println("     ATM AUTHENTICATION     ");
            System.out.println("============================");

            System.out.println("Enter pin");
            int pin = sc.nextInt();

            if (pin == 1234)
            {
                System.out.println("Authentication Successful");
                System.out.println("Welcome!");

                System.out.println();
                System.out.println("==================");
                System.out.println("     ATM MENU     ");
                System.out.println("==================");

                System.out.println("1. Check balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Transfer Money");
                System.out.println("5. Calculate Interest");
                System.out.println("6. Account Summary");
                System.out.println("7. Exit");

                System.out.println("Enter your choice");
                int choice = sc.nextInt();

                switch (choice)
                {
                    case 1:
                        System.out.println();
                        System.out.println("=======================");
                        System.out.println("     Check Balance     ");
                        System.out.println("=======================");

                        System.out.println("Account Type : " + accountType);
                        System.out.println("Balance      : " + balance);

                        if (accountType.equals("basic"))
                        {
                            System.out.println("Maintain your balance to unlock benefits");
                        }
                        else if (accountType.equals("Silver"))
                        {
                            System.out.println("You are eligible for standard benefits.");
                        }
                        else if (accountType.equals("Gold"))
                        {
                            System.out.println("You are enjoying Gold benefits.");
                        }
                        else
                        {
                            System.out.println("You have access to Premium benefits");
                        }

                        break;

                    case 2:
                        System.out.println("Enter Deposit amount:");
                        double deposit = sc.nextDouble();

                        if (deposit <= 0)
                        {
                            System.out.println("Invalid deposit amount");
                        }
                        else
                        {
                            balance = balance + deposit;

                            lastOperation = "Deposit";
                            lastAmount = deposit;
                            lastFee = 0;

                            if (deposit >= 50000)
                            {
                                System.out.println("High-value deposit detected");
                            }
                            else
                            {
                                System.out.println("Deposit Successful");
                            }

                            System.out.println("Updated balance : " + balance);
                        }

                        break;

                    case 3:
                        System.out.println("Enter withdrawal amount:");
                        double withdrawal = sc.nextDouble();

                        double withdrawalFees;

                        if (accountType.equals("basic"))
                        {
                            withdrawalFees = 20;
                        }
                        else if (accountType.equals("Silver"))
                        {
                            withdrawalFees = 10;
                        }
                        else if (accountType.equals("Gold"))
                        {
                            withdrawalFees = 5;
                        }
                        else
                        {
                            withdrawalFees = 0;
                        }

                        if (withdrawal <= 0)
                        {
                            System.out.println("Invalid withdrawal amount");
                        }
                        else
                        {
                            double totalWithdrawal = withdrawal + withdrawalFees;

                            if (totalWithdrawal <= balance)
                            {
                                balance = balance - totalWithdrawal;

                                lastOperation = "Withdrawal";
                                lastAmount = withdrawal;
                                lastFee = withdrawalFees;

                                System.out.println("Withdrawal Successful");
                                System.out.println("Withdrawal amount = " + withdrawal);
                                System.out.println("Transaction fees = " + withdrawalFees);
                                System.out.println("Remaining balance = " + balance);
                            }
                            else
                            {
                                System.out.println("Insufficient balance");
                                System.out.println("Required amount = " + totalWithdrawal);
                                System.out.println("Available balance = " + balance);
                            }
                        }

                        break;

                    case 4:
                        System.out.println("Enter beneficiary account number:");
                        long beneficiaryAccount = sc.nextLong();

                        if (beneficiaryAccount >= 100000 && beneficiaryAccount <= 999999)
                        {
                            System.out.println("Enter transfer amount:");
                            double transfer = sc.nextDouble();

                            double transferFee;

                            if (accountType.equals("basic"))
                            {
                                transferFee = transfer * 0.01;
                            }
                            else if (accountType.equals("Silver"))
                            {
                                transferFee = transfer * 0.005;
                            }
                            else if (accountType.equals("Gold"))
                            {
                                transferFee = transfer * 0.0025;
                            }
                            else
                            {
                                transferFee = 0;
                            }

                            if (transfer <= 0)
                            {
                                System.out.println("Invalid transfer amount");
                            }
                            else
                            {
                                double totalTransfer = transfer + transferFee;

                                if (totalTransfer <= balance)
                                {
                                    balance = balance - totalTransfer;

                                    lastOperation = "Transfer";
                                    lastAmount = transfer;
                                    lastFee = transferFee;

                                    System.out.println("Transfer Successful.");
                                    System.out.println("Beneficiary account : " + beneficiaryAccount);
                                    System.out.println("Transfer Amount     : " + transfer);
                                    System.out.println("Transfer Fee        : " + transferFee);
                                    System.out.println("Total deduction     : " + totalTransfer);
                                    System.out.println("Remaining balance   : " + balance);
                                }
                                else
                                {
                                    System.out.println("Insufficient balance for transfer");
                                    System.out.println("Total amount required : " + totalTransfer);
                                    System.out.println("Available balance     : " + balance);
                                }
                            }
                        }
                        else
                        {
                            System.out.println("Invalid beneficiary account number.");
                            System.out.println("Account number must contain exactly 6 digits.");
                        }

                        break;

                    case 5:
                        System.out.println("Enter interest rate (%)");
                        double rate = sc.nextDouble();

                        System.out.println("Enter time in years");
                        double time = sc.nextDouble();

                        double maximumRate;

                        if (accountType.equals("basic"))
                        {
                            maximumRate = 4;
                        }
                        else if (accountType.equals("Silver"))
                        {
                            maximumRate = 5;
                        }
                        else if (accountType.equals("Gold"))
                        {
                            maximumRate = 6;
                        }
                        else
                        {
                            maximumRate = 7;
                        }

                        if (rate > maximumRate)
                        {
                            System.out.println("Requested rate exceeds the allowed rate.");
                            System.out.println("Maximum applicable rate : "+ maximumRate + "%");
                        }
                        else if (rate <= 0 || time <= 0)
                        {
                            System.out.println("Invalid interest rate or time");
                        }
                        else
                        {
                            interest = (balance * rate * time) / 100;

                            double totalAmount = balance + interest;

                            System.out.println("Principal : " + balance);
                            System.out.println("Rate     : " + rate + "%");
                            System.out.println("Time     : " + time + " years");
                            System.out.println("Interest : " + interest);
                            System.out.println("Amount   : " + totalAmount);
                        }

                        break;

                    case 6:
                        System.out.println();
                        System.out.println("=========================");
                        System.out.println("     Account Summary     ");
                        System.out.println("=========================");

                        System.out.println("Account Holder : " + name);
                        System.out.println("Account number : " + accountNumber);
                        System.out.println("Age            : " + age);
                        System.out.println("Account Type   : " + accountType);

                        System.out.println();
                        System.out.println("Opening Balance : " + openingBalance);
                        System.out.println("Current Balance : " + balance);

                        System.out.println();
                        System.out.println("Last Operation : " + lastOperation);
                        System.out.println("Last Amount    : " + lastAmount);
                        System.out.println("Last Fee       : " + lastFee);
                        System.out.println("Interest       : " + interest);

                        System.out.println("===========================");

                        break;

                    case 7:
                        System.out.println();
                        System.out.println("=======================================");
                        System.out.println("     THANK YOU FOR BANKING WITH US     ");
                        System.out.println("=======================================");

                        System.out.println("Final Balance : " + balance);

                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }
            else
            {
                System.out.println("Incorrect Pin");
                System.out.println("Access denied");
            }
        }
        else
        {
            System.out.println();
            System.out.println("Account creation failed");
            System.out.println("Please verify your details");
        }

        sc.close();
    }
}